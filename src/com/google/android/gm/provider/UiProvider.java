package com.google.android.gm.provider;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import android.util.Pair;
import android.util.SparseArray;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.ListParams;
import com.android.mail.providers.Message;
import com.android.mail.providers.ReplyFromAccount;
import com.android.mail.providers.UIProvider;
import com.android.mail.providers.UIProvider.AccountColumns;
import com.android.mail.providers.UIProvider.ConversationColumns;
import com.android.mail.providers.UIProvider.FolderColumns;
import com.android.mail.providers.UIProvider.MessageColumns;
import com.android.mail.providers.UIProviderValidator;
import com.android.mail.utils.DelayedTaskHandler;
import com.android.mail.utils.MatrixCursorWithExtra;
import com.google.android.gm.AccountHelper;
import com.google.android.gm.AccountHelper.AccountResultsCallback;
import com.google.android.gm.EmailAddress;
import com.google.android.gm.LabelOperations;
import com.google.android.gm.LabelOperations.Operation;
import com.google.android.gm.Utils;
import com.google.android.gm.comm.longshadow.LongShadowUtils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.uiprovider.AccountState;
import com.google.android.gm.provider.uiprovider.ConversationState;
import com.google.android.gm.provider.uiprovider.MessageState;
import com.google.android.gm.provider.uiprovider.UIAttachment;
import com.google.android.gm.provider.uiprovider.UIAttachment.UriParser;
import com.google.android.gm.provider.uiprovider.UIConversationCursor;
import com.google.android.gm.provider.uiprovider.UILabelCursor;
import com.google.android.gm.provider.uiprovider.UIMessageCursor;
import com.google.android.gm.utils.CustomFromUtils;
import com.google.android.gsf.Gservices;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

public class UiProvider
  extends ContentProvider
  implements MailEngine.MailEngineResultCallback
{
  private static final Uri ACCOUNTS_URI;
  private static final Uri BASE_AUTH_URI;
  private static final Uri BASE_GVIEW_URI;
  private static final Uri BASE_SETTINGS_URI;
  private static final String[] CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS;
  private static final Integer GMAIL_CAPABILITIES = Integer.valueOf(1572863);
  private static final ImmutableSet<String> INVALID_ACCOUNT_NAMES;
  private static final ImmutableSet<String> INVARIANT_LABELS;
  private static final int[] UI_PROVIDER_MESSAGE_TEXT_SIZE_VALUES = { -2, -1, 0, 1, 2 };
  private static final String[] UI_PROVIDER_REQUIRED_LABELS;
  private static final int[] UI_PROVIDER_SNAP_HEADER_MODE_VALUES = { 0, 1, 2 };
  private static int sAccountNotificationDelayMs;
  private static final Map<String, AccountState> sAccountStateMap = Maps.newHashMap();
  private static String sGmailQuote;
  private static UiProvider sInstance;
  private static Map<String, CharSequence> sSystemLabelNameMap;
  private static final UriMatcher sUrlMatcher;
  private final Map<String, AccountChangedNotifier> mAccountChangeNotifiers = Maps.newHashMap();
  private volatile boolean mAccountsFullyInitialized = false;
  private final Set<String> mAccountsPendingInitialization = Sets.newHashSet();
  private ContentResolver mContentResolver;
  private Gmail mGmail;
  private int mLastSequence = -1;
  private boolean mMailEnginesInitialized = false;
  private final List<ConversationLabelOperation> mPreviousOperationUndoOps = Lists.newArrayList();
  private Handler mUiProviderHandler;
  
  static
  {
    UI_PROVIDER_REQUIRED_LABELS = new String[] { "^^out" };
    ACCOUNTS_URI = Uri.parse("content://com.android.gmail.ui/accounts");
    BASE_SETTINGS_URI = Uri.parse("setting://gmail/");
    BASE_AUTH_URI = Uri.parse("auth://gmail/");
    BASE_GVIEW_URI = Uri.parse("gview://preview");
    CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS = new String[] { "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR" };
    INVALID_ACCOUNT_NAMES = ImmutableSet.of("null");
    sUrlMatcher = new UriMatcher(-1);
    INVARIANT_LABELS = ImmutableSet.of("^u", "^t", "^o");
    sUrlMatcher.addURI("com.android.gmail.ui", "accounts", 1);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/account", 2);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/labels", 3);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/label/*", 18);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/conversations/*", 4);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/conversationsForLabel/*", 5);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/conversationMessages/#", 6);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/messageAttachments/#/#", 22);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/messageAttachment/#/#/*", 23);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/messages", 7);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/sendNewMessage", 8);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/saveNewMessage", 9);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/expungeMessage", 24);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/message/#", 10);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/message/save", 11);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/message/send", 12);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/undo", 15);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/refresh", 17);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/refresh/*", 16);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/conversation/#", 13);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/conversationInlineResource/#/*", 14);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/search", 19);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/searchConversations", 20);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/recentFolders", 21);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/defaultRecentFolders", 25);
    sUrlMatcher.addURI("com.android.gmail.ui", "*/cookie", 26);
  }
  
  private int addRemoveLabel(String[] paramArrayOfString, String paramString, LabelOperations paramLabelOperations)
  {
    if (paramLabelOperations.count() == 0) {
      return 0;
    }
    Object localObject1 = getOrMakeMailEngine(paramString);
    ArrayList localArrayList1 = Lists.newArrayList();
    ArrayList localArrayList2 = Lists.newArrayList();
    paramLabelOperations = paramLabelOperations.getOperationList();
    ArrayList localArrayList3 = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = paramArrayOfString[i];
      localObject2 = ((MailEngine)localObject1).getConversationForId(Gmail.CONVERSATION_PROJECTION_LIMITED, (String)localObject2, paramString, mGmail);
      if (localObject2 != null) {
        localArrayList3.add(localObject2);
      }
      i += 1;
    }
    paramArrayOfString = localArrayList3.iterator();
    while (paramArrayOfString.hasNext())
    {
      localObject1 = (com.google.android.gm.ConversationInfo)paramArrayOfString.next();
      long l1 = ((com.google.android.gm.ConversationInfo)localObject1).getLocalMessageId();
      long l2 = ((com.google.android.gm.ConversationInfo)localObject1).getServerMessageId();
      long l3 = ((com.google.android.gm.ConversationInfo)localObject1).getConversationId();
      int k = paramLabelOperations.size();
      i = 0;
      while (i < k)
      {
        localObject2 = getRawOperations((com.google.android.gm.ConversationInfo)localObject1, getmLabel, getmAdd);
        int m = ((Map)localObject2).size();
        String[] arrayOfString = (String[])((Map)localObject2).keySet().toArray(new String[m]);
        j = 0;
        if (j < m)
        {
          ContentValues localContentValues = new ContentValues();
          String str = arrayOfString[j];
          boolean bool = ((Boolean)((Map)localObject2).get(str)).booleanValue();
          if (l1 != 0L)
          {
            localContentValues.put("canonicalName", str);
            localContentValues.put("_id", Long.valueOf(l1));
            localContentValues.put("messageId", Long.valueOf(l2));
            localContentValues.put("conversation", Long.valueOf(l3));
            localContentValues.put("add_label_action", Boolean.valueOf(bool));
            localArrayList2.add(localContentValues);
          }
          for (;;)
          {
            j += 1;
            break;
            localContentValues.put("_id", Long.valueOf(l3));
            localContentValues.put("canonicalName", str);
            localContentValues.put("maxMessageId", Long.valueOf(((com.google.android.gm.ConversationInfo)localObject1).getMaxMessageId()));
            localContentValues.put("add_label_action", Boolean.valueOf(bool));
            localArrayList1.add(localContentValues);
          }
        }
        i += 1;
      }
    }
    if (localArrayList1.size() > 0) {
      mGmail.addOrRemoveLabelOnConversationBulk(paramString, (ContentValues[])localArrayList1.toArray(new ContentValues[localArrayList1.size()]), true);
    }
    if (localArrayList2.size() > 0) {
      mGmail.addOrRemoveLabelOnMessageBulk(paramString, (ContentValues[])localArrayList2.toArray(new ContentValues[localArrayList2.size()]), true);
    }
    return localArrayList3.size();
  }
  
  private void addUndoOperation(int paramInt, ConversationLabelOperation paramConversationLabelOperation)
  {
    List localList = mPreviousOperationUndoOps;
    if (paramInt != -1) {}
    try
    {
      if (paramInt > mLastSequence)
      {
        LogUtils.w("Gmail", "About to clean %d undo operations. sequenceNum:%d mLastSequence: %d", new Object[] { Integer.valueOf(mPreviousOperationUndoOps.size()), Integer.valueOf(paramInt), Integer.valueOf(mLastSequence) });
        mPreviousOperationUndoOps.clear();
        mLastSequence = paramInt;
      }
      mPreviousOperationUndoOps.add(paramConversationLabelOperation);
      return;
    }
    finally {}
  }
  
  static void broadcastAccountChangeNotification(Context paramContext, String paramString)
  {
    UiProvider localUiProvider = sInstance;
    if (localUiProvider != null) {
      localUiProvider.scheduleAccountChangeNotification(paramContext, paramString);
    }
  }
  
  static void broadcastAccountFolderChangeNotification(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    paramContext = paramContext.getContentResolver();
    if (paramBoolean)
    {
      paramContext.notifyChange(getAccountSearchUri(paramString1), null, false);
      return;
    }
    paramContext.notifyChange(getAccountLabelNotificationUri(paramString1, paramString2), null, false);
  }
  
  static void broadcastFolderNotifications(Context paramContext, Gmail.LabelMap paramLabelMap, String paramString, Set<Long> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      if (localObject != null)
      {
        localObject = paramLabelMap.getCanonicalName(((Long)localObject).longValue());
        if (localObject != null) {
          paramContext.notifyChange(getAccountLabelNotificationUri(paramString, (String)localObject), null, false);
        }
      }
    }
    if (paramSet.size() > 0)
    {
      paramContext.notifyChange(getAccountFoldersUri(paramString), null, false);
      paramContext.notifyChange(getRecentFoldersUri(paramString), null, false);
    }
  }
  
  private AttachmentCursor createAttachmentCursor(String paramString, long paramLong1, long paramLong2, String[] paramArrayOfString, int paramInt)
  {
    paramArrayOfString = new AttachmentCursor(paramString, paramLong1, paramLong2, paramArrayOfString, paramInt);
    getConversationState(paramString, paramLong1).addAttachmentCursor(paramArrayOfString);
    return paramArrayOfString;
  }
  
  private ConversationLabelOperation createLabelOperations(String paramString, long paramLong, List<Folder> paramList, List<String> paramList1)
  {
    ConversationLabelOperation localConversationLabelOperation = new ConversationLabelOperation(paramString, paramLong, null);
    HashSet localHashSet2 = new HashSet();
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext()) {
      localHashSet2.add((String)((Iterator)localObject).next());
    }
    HashSet localHashSet1 = new HashSet();
    int i;
    if (paramList1.size() == 0)
    {
      i = 1;
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList();
      }
      paramList = ((List)localObject).iterator();
    }
    label109:
    int j;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label247;
      }
      String str = (String)nexturi.getPathSegments().get(2);
      localHashSet1.add(str);
      if ((i != 0) || (!localHashSet2.contains(str))) {}
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (!isUserSettableLabel(str))) {
          break label223;
        }
        Label localLabel = LabelManager.getLabel(getContext(), paramString, str);
        if (localLabel == null) {
          break label225;
        }
        localConversationLabelOperation.add(localLabel, true);
        break label109;
        i = 0;
        break;
      }
      label223:
      continue;
      label225:
      LogUtils.e("Gmail", "Couldn't create label for canonical name: %s", new Object[] { str });
    }
    label247:
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      i = 1;
      paramList = paramList1.iterator();
    }
    for (;;)
    {
      label274:
      if (!paramList.hasNext()) {
        break label389;
      }
      paramList1 = (String)paramList.next();
      if ((i != 0) || (!localHashSet1.contains(paramList1))) {}
      for (j = 1;; j = 0)
      {
        if ((j == 0) || (!isUserSettableLabel(paramList1))) {
          break label365;
        }
        localObject = LabelManager.getLabel(getContext(), paramString, paramList1);
        if (localObject == null) {
          break label367;
        }
        localConversationLabelOperation.add((Label)localObject, false);
        break label274;
        i = 0;
        break;
      }
      label365:
      continue;
      label367:
      LogUtils.e("Gmail", "Couldn't create label for canonical name: %s", new Object[] { paramList1 });
    }
    label389:
    return localConversationLabelOperation;
  }
  
  private ConversationLabelOperation createLabelOperationsForUIOperation(String paramString1, long paramLong, String paramString2)
  {
    LogUtils.d("Gmail", "Received operation %s for conversation %d", new Object[] { paramString2, Long.valueOf(paramLong) });
    ConversationLabelOperation localConversationLabelOperation = new ConversationLabelOperation(paramString1, paramLong, null);
    if ("archive".equals(paramString2)) {
      localConversationLabelOperation.add(LabelManager.getLabel(getContext(), paramString1, "^i"), false);
    }
    do
    {
      do
      {
        return localConversationLabelOperation;
        if ("mute".equals(paramString2))
        {
          localConversationLabelOperation.add(LabelManager.getLabel(getContext(), paramString1, "^g"), true);
          return localConversationLabelOperation;
        }
        if (("report_spam".equals(paramString2)) || ("report_not_spam".equals(paramString2)))
        {
          localConversationLabelOperation.add(LabelManager.getLabel(getContext(), paramString1, "^s"), "report_spam".equals(paramString2));
          return localConversationLabelOperation;
        }
      } while (!"report_phishing".equals(paramString2));
      paramString1 = LabelManager.getLabel(getContext(), paramString1, "^p");
    } while (paramString1 == null);
    localConversationLabelOperation.add(paramString1, true);
    return localConversationLabelOperation;
  }
  
  private int delete(String paramString1, String paramString2, int paramInt)
  {
    ConversationLabelOperation localConversationLabelOperation = new ConversationLabelOperation(paramString2, Long.parseLong(paramString1), null);
    localConversationLabelOperation.add(LabelManager.getLabel(getContext(), paramString2, "^k"), true);
    addUndoOperation(paramInt, (ConversationLabelOperation)localConversationLabelOperation.undoOperation());
    return addRemoveLabel(new String[] { paramString1 }, paramString2, localConversationLabelOperation);
  }
  
  private int expungeMessage(String paramString, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("_id")) {
      return 0;
    }
    paramString = getOrMakeMailEngine(paramString);
    long l = paramContentValues.getAsLong("_id").longValue();
    paramContentValues = paramString.getLocalMessage(l, false);
    int i = paramString.expungeLocalMessage(l);
    if (paramContentValues != null) {
      mContentResolver.notifyChange(getConversationMessageListUri(paramString.getAccountName(), conversationId), null, false);
    }
    return i;
  }
  
  private static Uri getAboutUri(String paramString)
  {
    return BASE_SETTINGS_URI.buildUpon().appendQueryParameter("preference_fragment_id", Long.toString(2131755291L)).appendQueryParameter("account", paramString).build();
  }
  
  private static Uri getAccountBaseNotificationUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.uiinternal/" + paramString + "/notification");
  }
  
  private static Uri getAccountConversationSearchUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/searchConversations");
  }
  
  private Cursor getAccountCookieCursor(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    Object localObject = getOrMakeMailEngine(paramString);
    String[] arrayOfString = UIProviderValidator.validateAccountCookieProjection(paramArrayOfString);
    try
    {
      paramArrayOfString = ((MailEngine)localObject).getAuthToken();
      if (paramArrayOfString != null)
      {
        paramString = Urls.getCookieString(paramString, paramArrayOfString);
        paramArrayOfString = new MatrixCursor(arrayOfString, 1);
        localObject = paramArrayOfString.newRow();
        int j = arrayOfString.length;
        for (;;)
        {
          if (i >= j) {
            return paramArrayOfString;
          }
          if (!TextUtils.equals(arrayOfString[i], "cookie")) {
            break;
          }
          ((MatrixCursor.RowBuilder)localObject).add(paramString);
          i += 1;
        }
      }
    }
    catch (IOException paramArrayOfString)
    {
      for (;;)
      {
        LogUtils.e("Gmail", paramArrayOfString, "IOException retrieving auth token", new Object[0]);
        paramArrayOfString = null;
      }
    }
    catch (MailEngine.AuthenticationException paramArrayOfString)
    {
      for (;;)
      {
        LogUtils.e("Gmail", paramArrayOfString, "AuthenticationException retrieving auth token", new Object[0]);
        paramArrayOfString = null;
        continue;
        paramString = null;
        continue;
        ((MatrixCursor.RowBuilder)localObject).add(null);
      }
    }
    return paramArrayOfString;
  }
  
  private static Uri getAccountCookieQueryUri(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse("content://com.android.gmail.ui").buildUpon();
    localBuilder.appendEncodedPath(paramString).appendEncodedPath("cookie");
    return localBuilder.build();
  }
  
  private Cursor getAccountCursor(String paramString, String[] paramArrayOfString)
  {
    paramString = getOrMakeMailEngine(paramString);
    if ((paramString != null) && (isAccountNameValid(paramString.getAccountName()))) {
      return getAccountsCursorForMailEngines(paramArrayOfString, Collections.singletonList(paramString));
    }
    if (paramString == null) {}
    for (paramString = "null MailEngine";; paramString = paramString.getAccountName())
    {
      LogUtils.e("Gmail", "Invalid mailEngine. %s", new Object[] { paramString });
      return null;
    }
  }
  
  private static Uri getAccountExpungeMessageUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/expungeMessage");
  }
  
  private static Uri getAccountFoldersUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/labels");
  }
  
  private Cursor getAccountLabelCursor(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString1);
    return getUiLabelCursor(localMailEngine, paramString1, UIProviderValidator.validateFolderProjection(paramArrayOfString), localMailEngine.getLabelQueryBuilder(Gmail.LABEL_PROJECTION).filterCanonicalName(Collections.singletonList(paramString2)).showHidden(false).query());
  }
  
  public static Uri getAccountLabelNotificationUri(String paramString1, String paramString2)
  {
    paramString1 = getAccountUri(paramString1).buildUpon();
    paramString1.appendPath("label");
    paramString1.appendPath(paramString2);
    return paramString1.build();
  }
  
  public static Uri getAccountLabelUri(String paramString1, String paramString2)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString1 + "/label/" + Uri.encode(paramString2));
  }
  
  private Cursor getAccountLabelsCursor(String paramString, String[] paramArrayOfString)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString);
    return getUiLabelCursor(localMailEngine, paramString, UIProviderValidator.validateFolderProjection(paramArrayOfString), localMailEngine.getLabelQueryBuilder(Gmail.LABEL_PROJECTION).showHidden(false).query());
  }
  
  public static com.android.mail.providers.Account getAccountObject(Context paramContext, String paramString)
  {
    MatrixCursor localMatrixCursor = new MatrixCursor(UIProvider.ACCOUNTS_PROJECTION, 1);
    MatrixCursor.RowBuilder localRowBuilder = localMatrixCursor.newRow();
    populateAccountCursorRow(paramContext, paramString, null, UIProvider.ACCOUNTS_PROJECTION, localRowBuilder);
    localMatrixCursor.moveToFirst();
    return new com.android.mail.providers.Account(localMatrixCursor);
  }
  
  private static Uri getAccountRefreshUri(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse("content://com.android.gmail.ui").buildUpon();
    localBuilder.appendEncodedPath(paramString).appendEncodedPath("refresh");
    return localBuilder.build();
  }
  
  private static Uri getAccountSaveDraftUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/saveNewMessage");
  }
  
  private static Uri getAccountSearchUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/search");
  }
  
  private static Uri getAccountSendMessageUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/sendNewMessage");
  }
  
  private static Uri getAccountSettingUri(String paramString)
  {
    return BASE_SETTINGS_URI.buildUpon().appendQueryParameter("account", paramString).build();
  }
  
  private static Uri getAccountUndoUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/undo");
  }
  
  public static Uri getAccountUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/account");
  }
  
  private static Uri getAccountViewIntentProxyUri(String paramString)
  {
    paramString = Uri.parse("content://com.android.gmail.ui").buildUpon();
    paramString.appendEncodedPath("proxy");
    return paramString.build();
  }
  
  private Cursor getAccountsCursor(String[] paramArrayOfString)
  {
    paramArrayOfString = getAccountsCursorForMailEngines(paramArrayOfString, MailEngine.getMailEngines(getContext()));
    try
    {
      if (!mMailEnginesInitialized)
      {
        initializeMailEngines();
        mMailEnginesInitialized = true;
      }
      return paramArrayOfString;
    }
    finally {}
  }
  
  private Cursor getAccountsCursorForMailEngines(String[] paramArrayOfString, List<MailEngine> paramList)
  {
    paramArrayOfString = UIProviderValidator.validateAccountProjection(paramArrayOfString);
    Object localObject = new Bundle();
    int i;
    if (mAccountsFullyInitialized)
    {
      i = 1;
      ((Bundle)localObject).putInt("accounts_loaded", i);
      localObject = new MatrixCursorWithExtra(paramArrayOfString, paramList.size(), (Bundle)localObject);
      paramList = paramList.iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label143;
      }
      MailEngine localMailEngine = (MailEngine)paramList.next();
      MatrixCursor.RowBuilder localRowBuilder = ((MatrixCursor)localObject).newRow();
      String str = localMailEngine.getAccountName();
      if (isAccountNameValid(str))
      {
        populateAccountCursorRow(getContext(), str, localMailEngine, paramArrayOfString, localRowBuilder);
        continue;
        i = 0;
        break;
      }
      LogUtils.e("Gmail", "Invalid MailEngine account name: %s", new Object[] { str });
    }
    label143:
    return (Cursor)localObject;
  }
  
  private static Uri getComposeUri(String paramString)
  {
    return Uri.parse("gmail2from://gmail-ls/account/" + paramString);
  }
  
  public static Uri getConversationBaseUri(String paramString)
  {
    return Uri.parse(Urls.getUriString(paramString));
  }
  
  public static Conversation getConversationForConversationCursor(Context paramContext, String paramString, Gmail.ConversationCursor paramConversationCursor)
  {
    long l1 = paramConversationCursor.getConversationId();
    String str3 = paramConversationCursor.getFromSnippetInstructions();
    String str1 = paramConversationCursor.getSnippet();
    int i = paramConversationCursor.getNumMessages();
    com.android.mail.providers.ConversationInfo localConversationInfo = new com.android.mail.providers.ConversationInfo();
    UIConversationCursor.generateConversationInfo(str3, i, str1, localConversationInfo, paramConversationCursor.getLabels().containsKey("^u"));
    Uri localUri1 = getConversationUri(paramString, l1);
    String str2 = paramConversationCursor.getSubject();
    long l2 = paramConversationCursor.getDateMs();
    boolean bool3 = paramConversationCursor.hasAttachments();
    Uri localUri2 = getConversationMessageListUri(paramString, l1);
    paramContext = parseSendersFromSnippetInstructions(str3, paramContext);
    int j = getConversationPriority(paramConversationCursor);
    boolean bool1;
    boolean bool4;
    int k;
    boolean bool5;
    boolean bool6;
    boolean bool7;
    Uri localUri3;
    if (!paramConversationCursor.getLabels().containsKey("^u"))
    {
      bool1 = true;
      bool4 = paramConversationCursor.getLabels().containsKey("^t");
      str3 = getSerializedFolderString(paramString, paramConversationCursor);
      k = getConversationPersonalLevel(paramConversationCursor);
      bool5 = paramConversationCursor.getLabels().containsKey("^s");
      bool6 = paramConversationCursor.getLabels().containsKey("^p");
      bool7 = paramConversationCursor.getLabels().containsKey("^g");
      localUri3 = getAccountUri(paramString);
      paramString = getConversationBaseUri(paramString);
      if (paramConversationCursor.isSynced()) {
        break label258;
      }
    }
    label258:
    for (boolean bool2 = true;; bool2 = false)
    {
      return Conversation.create(l1, localUri1, str2, l2, str1, bool3, localUri2, paramContext, i, 0, 0, j, bool1, bool4, str3, 0, k, bool5, bool6, bool7, localUri3, localConversationInfo, paramString, bool2);
      bool1 = false;
      break;
    }
  }
  
  public static Uri getConversationMessageListUri(String paramString, long paramLong)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/conversationMessages/" + paramLong);
  }
  
  private static int getConversationPersonalLevel(Gmail.ConversationCursor paramConversationCursor)
  {
    paramConversationCursor = paramConversationCursor.getPersonalLevel();
    if (paramConversationCursor == Gmail.PersonalLevel.NOT_TO_ME) {}
    do
    {
      return 0;
      if (paramConversationCursor == Gmail.PersonalLevel.ONLY_TO_ME) {
        return 2;
      }
    } while (paramConversationCursor != Gmail.PersonalLevel.TO_ME_AND_OTHERS);
    return 1;
  }
  
  private static int getConversationPriority(Gmail.ConversationCursor paramConversationCursor)
  {
    if (paramConversationCursor.getLabels().containsKey("^io_im")) {
      return 1;
    }
    return 0;
  }
  
  private ConversationState getConversationState(String paramString, long paramLong)
  {
    return getOrCreateAccountState(paramString).getOrCreateConversationState(getContext(), paramLong);
  }
  
  public static Uri getConversationUri(String paramString, long paramLong)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/conversation/" + paramLong);
  }
  
  private Cursor getConversationsForLabel(String paramString1, Uri paramUri, String paramString2, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean)
  {
    UIProviderValidator.validateConversationProjection(paramArrayOfString);
    return getConversationsForQuery(paramString1, paramUri, null, paramString2, paramArrayOfString, paramInteger, paramBoolean);
  }
  
  private Cursor getConversationsForLabelId(String paramString, Uri paramUri, long paramLong, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean)
  {
    String str = getOrMakeMailEngine(paramString).getLabelMap().getCanonicalName(paramLong);
    if (str == null)
    {
      LogUtils.e("Gmail", "Unknown canonical name: %s", new Object[] { str });
      return null;
    }
    return getConversationsForLabel(paramString, paramUri, str, paramArrayOfString, paramInteger, paramBoolean);
  }
  
  private Cursor getConversationsForQuery(String paramString1, Uri paramUri, String paramString2, String paramString3, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString1);
    String[] arrayOfString = UIProviderValidator.validateConversationProjection(paramArrayOfString);
    if (paramBoolean) {}
    for (paramArrayOfString = null;; paramArrayOfString = CONVERSATION_QUERY_LOCAL_ONLY_SELECTION_ARGS) {
      return getUiConversationCursor(paramString1, localMailEngine, paramUri, arrayOfString, localMailEngine.getConversationCursorForQuery(null, Utils.makeQueryString(paramString2, paramString3), paramArrayOfString, paramInteger, false), paramBoolean);
    }
  }
  
  private static Uri getDefaultRecentFoldersUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/defaultRecentFolders");
  }
  
  private static EmailAddress getEmailAddress(String paramString)
  {
    return EmailAddress.getEmailAddress(paramString);
  }
  
  private Cursor getFakeSearchFolder(Uri paramUri, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = getOrCreateAccountState(paramString1);
    Folder localFolder = Folder.newUnsafeInstance();
    paramString1 = getAccountConversationSearchUri(paramString1).buildUpon();
    paramString1.appendQueryParameter("query", paramString2);
    conversationListUri = paramString1.build();
    id = "search".hashCode();
    paramString1 = new MatrixCursor(UIProvider.FOLDERS_PROJECTION, 1);
    MatrixCursor.RowBuilder localRowBuilder = paramString1.newRow();
    String[] arrayOfString = UIProvider.FOLDERS_PROJECTION;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = arrayOfString[i];
      if (TextUtils.equals(str, "_id")) {
        localRowBuilder.add(Integer.valueOf(id));
      }
      for (;;)
      {
        i += 1;
        break;
        if (TextUtils.equals(str, "folderUri")) {
          localRowBuilder.add(paramUri);
        } else if (TextUtils.equals(str, "name")) {
          localRowBuilder.add("search");
        } else if (TextUtils.equals(str, "unreadCount")) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "totalCount")) {
          localRowBuilder.add(Integer.valueOf(paramString3.getNumSearchResults(paramString2)));
        } else if (TextUtils.equals(str, UIProvider.FolderColumns.HAS_CHILDREN)) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, UIProvider.FolderColumns.CAPABILITIES)) {
          localRowBuilder.add(Integer.valueOf(608));
        } else if (TextUtils.equals(str, UIProvider.FolderColumns.SYNC_WINDOW)) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "conversationListUri")) {
          localRowBuilder.add(conversationListUri);
        } else if (TextUtils.equals(str, "childFoldersListUri")) {
          localRowBuilder.add(null);
        } else if (TextUtils.equals(str, "refreshUri")) {
          localRowBuilder.add(conversationListUri);
        } else if (TextUtils.equals(str, "syncStatus")) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "lastSyncResult")) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "type")) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "iconResId")) {
          localRowBuilder.add(Integer.valueOf(0));
        } else if (TextUtils.equals(str, "bgColor")) {
          localRowBuilder.add(null);
        } else if (TextUtils.equals(str, "fgColor")) {
          localRowBuilder.add(null);
        } else if (TextUtils.equals(str, "loadMoreUri")) {
          localRowBuilder.add(null);
        } else if (TextUtils.equals(str, "hierarchicalDesc")) {
          localRowBuilder.add("search");
        } else {
          LogUtils.wtf("Gmail", "unexpected column: %s", new Object[] { str });
        }
      }
    }
    return paramString1;
  }
  
  public static int getFolderType(boolean paramBoolean, String paramString)
  {
    int j = 0;
    int i;
    if ("^t".equals(paramString)) {
      i = 7;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (!paramBoolean);
      if (("^i".equals(paramString)) || ("^iim".equals(paramString))) {
        return 1;
      }
      if ("^r".equals(paramString)) {
        return 2;
      }
      if ("^^out".equals(paramString)) {
        return 3;
      }
      if ("^f".equals(paramString)) {
        return 4;
      }
      if ("^k".equals(paramString)) {
        return 5;
      }
      if ("^s".equals(paramString)) {
        return 6;
      }
      if ("^all".equals(paramString)) {
        return 9;
      }
      i = j;
    } while (!"^im".equals(paramString));
    return 8;
  }
  
  private static Uri getHelpUri(Context paramContext)
  {
    return Uri.parse(Gservices.getString(paramContext.getContentResolver(), "gmail_context_sensitive_help_url", "http://support.google.com/mobile/?hl=%locale%"));
  }
  
  public static Uri getLabelConversationListFromNameUri(String paramString1, String paramString2)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString1 + "/conversationsForLabel/" + paramString2);
  }
  
  public static Uri getLabelConversationListUri(String paramString, int paramInt)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/conversations/" + paramInt);
  }
  
  private static final Pair<Long, CharSequence> getLabelFromCanonical(Context paramContext, Gmail.LabelMap paramLabelMap, String paramString1, String paramString2, boolean paramBoolean)
  {
    long l = -1L;
    if (paramBoolean) {
      paramContext = getSystemLabelName(paramContext, paramString2);
    }
    for (;;)
    {
      return Pair.create(Long.valueOf(l), paramContext);
      if (paramLabelMap != null)
      {
        l = paramLabelMap.getLabelId(paramString2);
        paramContext = paramLabelMap.getName(l);
      }
      else
      {
        paramContext = LabelManager.getLabel(paramContext, paramString1, paramString2);
        if (paramContext != null)
        {
          l = paramContext.getId();
          paramContext = paramContext.getName();
        }
        else
        {
          LogUtils.e("Gmail", "Couldn't find label: %s", new Object[] { LogUtils.sanitizeLabelName(paramString2) });
          paramContext = null;
        }
      }
    }
  }
  
  public static Uri getLabelRefreshUri(String paramString, Uri paramUri)
  {
    paramString = getAccountRefreshUri(paramString).buildUpon();
    paramString.appendPath(paramUri.toString());
    return paramString.build();
  }
  
  public static Uri getMessageAttachmentUri(String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = Uri.parse("content://com.android.gmail.ui/" + paramString1 + "/messageAttachment/" + paramLong1 + "/" + paramLong3 + "/" + paramString2).buildUpon();
    paramString1.appendQueryParameter("serverMessageId", Long.toString(paramLong2));
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.appendQueryParameter("mimeType", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.appendQueryParameter("gmailJoinedAttachment", paramString4);
    }
    return paramString1.build();
  }
  
  private Cursor getMessageAttachments(UIAttachment.UriParser paramUriParser, String[] paramArrayOfString)
  {
    long l1 = mConversationId;
    String str1 = mAccount;
    Object localObject = mPartId;
    long l2 = mLocalMessageId;
    long l3 = mMessageId;
    List localList = mContentTypeQueryParameters;
    String[] arrayOfString = UIProviderValidator.validateAttachmentProjection(paramArrayOfString);
    paramArrayOfString = getConversationState(str1, l1);
    getOrMakeMailEngine(str1);
    paramUriParser = paramArrayOfString.getOrCreateMessageState(paramUriParser);
    if (paramUriParser != null)
    {
      paramArrayOfString = paramUriParser.getMessageAttachments();
      paramUriParser = paramArrayOfString;
      if (paramArrayOfString != null)
      {
        paramUriParser = paramArrayOfString;
        if (paramArrayOfString.size() > 0)
        {
          paramUriParser = paramArrayOfString;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            LogUtils.d("Gmail", "Looking for attachment partId: %s", new Object[] { localObject });
            paramArrayOfString = paramArrayOfString.iterator();
            while (paramArrayOfString.hasNext())
            {
              paramUriParser = (UIAttachment)paramArrayOfString.next();
              if (((String)localObject).equalsIgnoreCase(paramUriParser.getPartId())) {
                LogUtils.d("Gmail", "Found attachment", new Object[0]);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramUriParser != null) {}
      for (paramUriParser = Collections.singletonList(paramUriParser);; paramUriParser = Collections.emptyList())
      {
        paramArrayOfString = paramUriParser;
        if (paramUriParser == null) {
          break label346;
        }
        paramArrayOfString = paramUriParser;
        if (paramUriParser.size() <= 0) {
          break label346;
        }
        paramArrayOfString = paramUriParser;
        if (localList == null) {
          break label346;
        }
        paramArrayOfString = paramUriParser;
        if (localList.isEmpty()) {
          break label346;
        }
        paramArrayOfString = new ArrayList();
        paramUriParser = paramUriParser.iterator();
        for (;;)
        {
          if (!paramUriParser.hasNext()) {
            break label346;
          }
          localObject = (UIAttachment)paramUriParser.next();
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            String str3 = ((UIAttachment)localObject).getContentType();
            if ((str3 == null) || (!str3.startsWith(str2))) {
              break;
            }
            paramArrayOfString.add(localObject);
          }
        }
        LogUtils.e("Gmail", "Couldn't find Message State, returning empty attachment list", new Object[0]);
        paramArrayOfString = Collections.emptyList();
        break;
      }
      label346:
      return getUiAttachmentsCursorForUIAttachments(str1, l1, l3, l2, arrayOfString, paramArrayOfString);
      paramUriParser = null;
    }
  }
  
  public static Uri getMessageAttachmentsUri(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/messageAttachments/" + paramLong1 + "/" + paramLong3).buildUpon().appendQueryParameter("serverMessageId", Long.toString(paramLong2)).build();
  }
  
  public static Uri getMessageByIdUri(String paramString, long paramLong)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/message/" + paramLong);
  }
  
  private Cursor getMessageForId(String paramString, long paramLong)
  {
    Object localObject = getOrMakeMailEngine(paramString);
    Persistence localPersistence = Persistence.getInstance();
    localObject = ((MailEngine)localObject).getMessageCursorForLocalMessageId(Gmail.MESSAGE_PROJECTION, paramLong);
    if (localObject == null) {
      return null;
    }
    return new UIMessageCursor(getContext(), (Cursor)localObject, paramString, localPersistence, sGmailQuote, UIProvider.MESSAGE_PROJECTION);
  }
  
  private Cursor getMessagesForConversation(String paramString, long paramLong, String[] paramArrayOfString, boolean paramBoolean)
  {
    Object localObject = getOrMakeMailEngine(paramString);
    if (!paramBoolean) {}
    Persistence localPersistence;
    for (paramBoolean = true;; paramBoolean = false)
    {
      localPersistence = Persistence.getInstance();
      paramArrayOfString = UIProviderValidator.validateMessageProjection(paramArrayOfString);
      localObject = ((MailEngine)localObject).getMessageCursorForConversationId(Gmail.MESSAGE_PROJECTION, paramLong, paramBoolean, false);
      if (localObject != null) {
        break;
      }
      return null;
    }
    paramArrayOfString = new UIMessageCursor(getContext(), (Cursor)localObject, paramString, localPersistence, sGmailQuote, paramArrayOfString);
    paramArrayOfString.setNotificationUri(mContentResolver, getConversationMessageListUri(paramString, paramLong));
    return paramArrayOfString;
  }
  
  private AccountState getOrCreateAccountState(String paramString)
  {
    synchronized (sAccountStateMap)
    {
      if (sAccountStateMap.containsKey(paramString))
      {
        paramString = (AccountState)sAccountStateMap.get(paramString);
        return paramString;
      }
      Object localObject = getOrMakeMailEngine(paramString);
      localObject = new AccountState(paramString, mUiProviderHandler, (MailEngine)localObject);
      sAccountStateMap.put(paramString, localObject);
      paramString = (String)localObject;
    }
  }
  
  private MailEngine getOrMakeMailEngine(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    return MailEngine.getOrMakeMailEngine(getContext(), paramString);
  }
  
  private static Map<String, Boolean> getRawOperations(com.google.android.gm.ConversationInfo paramConversationInfo, Label paramLabel, boolean paramBoolean)
  {
    int k = 0;
    HashMap localHashMap = Maps.newHashMap();
    paramLabel = paramLabel.getCanonicalName();
    localHashMap.put(paramLabel, Boolean.valueOf(paramBoolean));
    boolean bool;
    int i;
    label183:
    int j;
    if (("^k".equals(paramLabel)) || ("^g".equals(paramLabel)))
    {
      if (!paramBoolean)
      {
        bool = true;
        localHashMap.put("^i", Boolean.valueOf(bool));
      }
    }
    else
    {
      if (("^p".equals(paramLabel)) && (paramBoolean))
      {
        localHashMap.put("^i", Boolean.FALSE);
        localHashMap.put("^s", Boolean.TRUE);
      }
      if (("^i".equals(paramLabel)) && (paramBoolean))
      {
        localHashMap.put("^s", Boolean.FALSE);
        localHashMap.put("^k", Boolean.FALSE);
      }
      if (((!"^^important".equals(paramLabel)) || (!paramBoolean)) && ((!"^^unimportant".equals(paramLabel)) || (paramBoolean))) {
        break label384;
      }
      i = 1;
      if ((!"^^unimportant".equals(paramLabel)) || (!paramBoolean))
      {
        j = k;
        if ("^^important".equals(paramLabel))
        {
          j = k;
          if (paramBoolean) {}
        }
      }
      else
      {
        j = 1;
      }
      if (i == 0) {
        break label389;
      }
      localHashMap.put("^im", Boolean.TRUE);
      localHashMap.put("^io_im", Boolean.TRUE);
      localHashMap.put("^imi", Boolean.TRUE);
      localHashMap.put("^imn", Boolean.FALSE);
      localHashMap.put("^io_ns", Boolean.FALSE);
      if (paramConversationInfo.getLabels().containsKey("^i")) {
        localHashMap.put("^iim", Boolean.TRUE);
      }
    }
    for (;;)
    {
      if ((localHashMap.containsKey("^i")) && (paramConversationInfo.isImportant())) {
        localHashMap.put("^iim", Boolean.valueOf(((Boolean)localHashMap.get("^i")).booleanValue()));
      }
      return localHashMap;
      bool = false;
      break;
      label384:
      i = 0;
      break label183;
      label389:
      if (j != 0)
      {
        localHashMap.put("^imn", Boolean.TRUE);
        localHashMap.put("^im", Boolean.FALSE);
        localHashMap.put("^io_im", Boolean.FALSE);
        localHashMap.put("^iim", Boolean.FALSE);
        localHashMap.put("^imi", Boolean.FALSE);
        localHashMap.put("^io_ns", Boolean.FALSE);
      }
    }
  }
  
  private static Uri getReauthenticateUri(String paramString)
  {
    return BASE_AUTH_URI.buildUpon().appendQueryParameter("account", paramString).build();
  }
  
  private static Uri getRecentFoldersUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/recentFolders");
  }
  
  private Cursor getRecentLabelsCursor(String paramString, String[] paramArrayOfString)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString);
    paramArrayOfString = UIProviderValidator.validateFolderProjection(paramArrayOfString);
    LabelQueryBuilder localLabelQueryBuilder = localMailEngine.getLabelQueryBuilder(Gmail.LABEL_PROJECTION).showHidden(false);
    localLabelQueryBuilder.setRecent(System.currentTimeMillis(), 10);
    return getUiLabelCursor(localMailEngine, paramString, paramArrayOfString, localLabelQueryBuilder.query());
  }
  
  public static Uri getSaveMessageUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/message/save");
  }
  
  public static Uri getSendMessageUri(String paramString)
  {
    return Uri.parse("content://com.android.gmail.ui/" + paramString + "/message/send");
  }
  
  private static String getSerializedFolderString(String paramString, Gmail.ConversationCursor paramConversationCursor)
  {
    return getSerializedFolderString(paramString, paramConversationCursor.getLabels(), null, null);
  }
  
  public static String getSerializedFolderString(String paramString, Map<String, Label> paramMap, SparseArray<String> paramSparseArray, Map<String, String[]> paramMap1)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList(paramMap.size());
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.entrySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      paramMap = (Label)((Map.Entry)localIterator.next()).getValue();
      String str3 = paramMap.getCanonicalName();
      if ((LongShadowUtils.isUserLabel(str3)) || (Gmail.isDisplayableSystemLabel(str3)))
      {
        Folder localFolder = Folder.newUnsafeInstance();
        id = ((int)paramMap.getId());
        uri = getAccountLabelUri(paramString, paramMap.getCanonicalName());
        name = paramMap.getName();
        capabilities = 0;
        hasChildren = false;
        syncWindow = 0;
        conversationListUri = getLabelConversationListUri(paramString, (int)paramMap.getId());
        childFoldersListUri = null;
        unreadCount = 0;
        totalCount = 0;
        refreshUri = null;
        syncStatus = 0;
        lastSyncResult = 0;
        type = getFolderType(paramMap.isSystemLabel(), paramMap.getCanonicalName());
        iconResId = -1L;
        if ((paramMap1 != null) && (paramMap1.containsKey(str3)))
        {
          localObject = (String[])paramMap1.get(str3);
          paramMap = localObject[0];
          localObject = localObject[1];
        }
        for (;;)
        {
          bgColor = paramMap;
          fgColor = ((String)localObject);
          loadMoreUri = null;
          localArrayList.add(localFolder);
          break;
          String str1 = paramMap.getBackgroundColor() + "";
          String str2 = paramMap.getTextColor() + "";
          localObject = str2;
          paramMap = str1;
          if (paramMap1 != null)
          {
            paramMap1.put(str3, new String[] { str1, str2 });
            localObject = str2;
            paramMap = str1;
          }
        }
      }
    }
    int j = localArrayList.size();
    paramMap1 = localArrayList.iterator();
    if (paramMap1.hasNext())
    {
      localObject = (Folder)paramMap1.next();
      if (paramSparseArray != null)
      {
        paramMap = (String)paramSparseArray.get(id);
        paramString = paramMap;
        if (paramMap == null)
        {
          paramString = Folder.toString((Folder)localObject);
          paramSparseArray.put(id, paramString);
        }
      }
      for (;;)
      {
        localStringBuilder.append(paramString);
        if (i < j - 1) {
          localStringBuilder.append("^**^");
        }
        i += 1;
        break;
        paramString = Folder.toString((Folder)localObject);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static Folder getSparseFolderObject(Context paramContext, MailEngine paramMailEngine, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    MatrixCursor localMatrixCursor = new MatrixCursor(Gmail.LABEL_PROJECTION, 1);
    Object localObject1;
    boolean bool;
    int i;
    label63:
    String str;
    if (paramMailEngine != null)
    {
      localObject1 = paramMailEngine.getLabelMap();
      bool = Gmail.isSystemLabel(paramString2);
      paramContext = getLabelFromCanonical(paramContext, (Gmail.LabelMap)localObject1, paramString1, paramString2, bool);
      localObject1 = localMatrixCursor.newRow();
      String[] arrayOfString = Gmail.LABEL_PROJECTION;
      int k = arrayOfString.length;
      i = 0;
      if (i >= k) {
        break label230;
      }
      str = arrayOfString[i];
      if (!"_id".equals(str)) {
        break label113;
      }
      ((MatrixCursor.RowBuilder)localObject1).add(first);
    }
    for (;;)
    {
      i += 1;
      break label63;
      localObject1 = null;
      break;
      label113:
      if ("canonicalName".equals(str))
      {
        ((MatrixCursor.RowBuilder)localObject1).add(paramString2);
      }
      else
      {
        if ("systemLabel".equals(str))
        {
          if (bool) {}
          for (int j = 1;; j = 0)
          {
            ((MatrixCursor.RowBuilder)localObject1).add(Integer.valueOf(j));
            break;
          }
        }
        if ("name".equals(str)) {
          ((MatrixCursor.RowBuilder)localObject1).add(second);
        } else if ("color".equals(str)) {
          ((MatrixCursor.RowBuilder)localObject1).add("2147483647");
        } else {
          ((MatrixCursor.RowBuilder)localObject1).add(null);
        }
      }
    }
    label230:
    paramContext = (Context)localObject2;
    try
    {
      paramMailEngine = getUiLabelCursor(paramMailEngine, paramString1, UIProvider.FOLDERS_PROJECTION, localMatrixCursor);
      paramContext = paramMailEngine;
      paramMailEngine.moveToFirst();
      paramContext = paramMailEngine;
      paramString1 = new Folder(paramMailEngine);
      return paramString1;
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
  }
  
  private static CharSequence getSystemLabelName(Context paramContext, String paramString)
  {
    if (!Gmail.isSystemLabel(paramString)) {
      return null;
    }
    try
    {
      if (sSystemLabelNameMap == null) {
        sSystemLabelNameMap = Label.getSystemLabelNameMap(paramContext);
      }
      paramContext = (CharSequence)sSystemLabelNameMap.get(paramString);
      return paramContext;
    }
    finally {}
  }
  
  private Cursor getUiAttachmentsCursorForUIAttachments(String paramString, long paramLong1, long paramLong2, long paramLong3, String[] paramArrayOfString, List<UIAttachment> paramList)
  {
    AttachmentCursor localAttachmentCursor = createAttachmentCursor(paramString, paramLong1, paramLong2, paramArrayOfString, paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      UIAttachment localUIAttachment = (UIAttachment)localIterator.next();
      LogUtils.d("Gmail", "adding attachment to cursor %s", new Object[] { localUIAttachment });
      MatrixCursor.RowBuilder localRowBuilder = localAttachmentCursor.newRow();
      String str1 = localUIAttachment.getPartId();
      String str2 = localUIAttachment.getContentType();
      Uri localUri = getMessageAttachmentUri(paramString, paramLong1, paramLong2, paramLong3, str1, str2, localUIAttachment.getJoinedAttachmentInfo());
      int j = paramArrayOfString.length;
      int i = 0;
      label124:
      if (i < j)
      {
        paramList = paramArrayOfString[i];
        if (!TextUtils.equals(paramList, "uri")) {
          break label166;
        }
        localRowBuilder.add(localUri);
      }
      for (;;)
      {
        i += 1;
        break label124;
        break;
        label166:
        if (TextUtils.equals(paramList, "_display_name"))
        {
          localRowBuilder.add(localUIAttachment.getName());
        }
        else if (TextUtils.equals(paramList, "_size"))
        {
          localRowBuilder.add(Integer.valueOf(localUIAttachment.getSize()));
        }
        else if (TextUtils.equals(paramList, "contentType"))
        {
          localRowBuilder.add(str2);
        }
        else if (TextUtils.equals(paramList, "state"))
        {
          localRowBuilder.add(Integer.valueOf(localUIAttachment.getStatus()));
        }
        else if (TextUtils.equals(paramList, "destination"))
        {
          localRowBuilder.add(Integer.valueOf(localUIAttachment.getDestination()));
        }
        else if (TextUtils.equals(paramList, "downloadedSize"))
        {
          localRowBuilder.add(Integer.valueOf(localUIAttachment.getDownloadedSize()));
        }
        else
        {
          if (TextUtils.equals(paramList, "contentUri"))
          {
            if (localUIAttachment.getDestination() == 1) {}
            for (paramList = localUIAttachment.getExternalFilePath();; paramList = Gmail.getAttachmentUri(paramString, paramLong3, localUIAttachment, Gmail.AttachmentRendition.BEST, false))
            {
              localRowBuilder.add(paramList);
              break;
            }
          }
          if (TextUtils.equals(paramList, "thumbnailUri")) {
            localRowBuilder.add(Gmail.getAttachmentUri(paramString, paramLong3, localUIAttachment, Gmail.AttachmentRendition.SIMPLE, false));
          } else if (TextUtils.equals(paramList, "previewIntentUri")) {
            if (MimeType.isPreviewable(getContext(), str2)) {
              localRowBuilder.add(BASE_GVIEW_URI.buildUpon().appendQueryParameter("account", paramString).appendQueryParameter("serverMessageId", Long.toHexString(paramLong2)).appendQueryParameter("attId", str1).appendQueryParameter("mimeType", str2).build().toString());
            } else {
              localRowBuilder.add(null);
            }
          }
        }
      }
    }
    return localAttachmentCursor;
  }
  
  private Cursor getUiConversationCursor(String paramString, MailEngine paramMailEngine, Uri paramUri, String[] paramArrayOfString, Cursor paramCursor, boolean paramBoolean)
  {
    if (paramCursor == null) {
      paramMailEngine = null;
    }
    do
    {
      do
      {
        return paramMailEngine;
        paramArrayOfString = new UIConversationCursor(paramCursor, paramString, paramArrayOfString);
        paramMailEngine = paramArrayOfString;
      } while (paramUri == null);
      paramMailEngine = paramArrayOfString;
    } while (!paramBoolean);
    getOrCreateAccountState(paramString).cacheConversationCursor(paramUri, paramArrayOfString);
    return paramArrayOfString;
  }
  
  private static Cursor getUiLabelCursor(MailEngine paramMailEngine, String paramString, String[] paramArrayOfString, Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    return new UILabelCursor(paramCursor, paramMailEngine, paramString, paramArrayOfString);
  }
  
  private void initializeMailEngines()
  {
    final Context localContext = getContext();
    new AccountHelper(localContext).asyncGetAccountsInfo(new AccountHelper.AccountResultsCallback()
    {
      public void exec(android.accounts.Account[] paramAnonymousArrayOfAccount)
      {
        if (paramAnonymousArrayOfAccount.length > 0)
        {
          int j = paramAnonymousArrayOfAccount.length;
          int i = 0;
          while (i < j)
          {
            android.accounts.Account localAccount = paramAnonymousArrayOfAccount[i];
            LogUtils.d("Gmail", "Getting MailEngine for account: %s", new Object[] { name });
            mAccountsPendingInitialization.add(name);
            MailEngine.getOrMakeMailEngineAsync(localContext, name, UiProvider.this);
            i += 1;
          }
        }
        UiProvider.this.updateAccountsIntializedStatus();
      }
    });
  }
  
  private void intializeLoaderHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("UIProvider Thread", 10);
    localHandlerThread.start();
    mUiProviderHandler = new Handler(localHandlerThread.getLooper());
  }
  
  private static boolean isAccountNameValid(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!INVALID_ACCOUNT_NAMES.contains(paramString.toLowerCase()));
  }
  
  private static final boolean isUserSettableLabel(String paramString)
  {
    return (Gmail.isLabelUserSettable(paramString)) && (!INVARIANT_LABELS.contains(paramString));
  }
  
  static void notifyAccountChanged(Context paramContext, String paramString)
  {
    paramContext.getContentResolver().notifyChange(getAccountUri(paramString), null, false);
    notifyAccountListChanged(paramContext);
  }
  
  public static void notifyAccountListChanged(Context paramContext)
  {
    paramContext.getContentResolver().notifyChange(ACCOUNTS_URI, null, false);
  }
  
  static void notifyAttachmentChanged(String paramString, long paramLong)
  {
    synchronized (sAccountStateMap)
    {
      paramString = (AccountState)sAccountStateMap.get(paramString);
      if (paramString != null) {
        paramString.notifyAttachmentChange(paramLong);
      }
      return;
    }
  }
  
  public static void notifyMessageAttachmentsChanged(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3, Set<String> paramSet)
  {
    paramContext = paramContext.getContentResolver();
    paramContext.notifyChange(getMessageAttachmentsUri(paramString, paramLong1, paramLong2, paramLong3), null, false);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      paramContext.notifyChange(getMessageAttachmentUri(paramString, paramLong1, paramLong2, paramLong3, (String)paramSet.next(), null, null), null, false);
    }
  }
  
  static void onAttachmentDownloadFinished(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    UiProvider localUiProvider = sInstance;
    if (localUiProvider != null) {
      localUiProvider.onAttachmentDownloadFinishedImpl(paramString1, paramLong1, paramLong2, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
    }
  }
  
  private void onAttachmentDownloadFinishedImpl(String paramString1, long paramLong1, long paramLong2, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    paramString1 = getConversationState(paramString1, paramLong1).getOrCreateMessageState(paramLong2);
    if (paramString1 == null)
    {
      LogUtils.e("Gmail", "couldn't find message %d in update AttachmentState", new Object[] { Long.valueOf(paramLong2) });
      return;
    }
    UIAttachment localUIAttachment = paramString1.getMessageAttachment(paramString2);
    if (localUIAttachment == null)
    {
      paramString1 = paramString1.getMessageAttachments();
      LogUtils.e("Gmail", "couldn't find attachment %d %s in update AttachmentState.  attachments: %s", new Object[] { Long.valueOf(paramLong2), paramString2, Arrays.toString(paramString1.toArray(new UIAttachment[paramString1.size()])) });
      return;
    }
    if ((paramInt3 == 404) && (localUIAttachment.downloadCompletedSuccessfully()))
    {
      LogUtils.e("Gmail", "Attempt to make successful download a failure", new Object[0]);
      return;
    }
    LogUtils.d("Gmail", "Updating attachment state %d/%d/%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3 });
    localUIAttachment.updateState(paramInt2, paramInt1, paramString3);
  }
  
  public static void onConversationChanged(Context paramContext, String paramString, long paramLong)
  {
    paramContext.getContentResolver().notifyChange(getConversationMessageListUri(paramString, paramLong), null, false);
  }
  
  static String parseSendersFromSnippetInstructions(String paramString, Context paramContext)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    TextUtils.SimpleStringSplitter localSimpleStringSplitter = new TextUtils.SimpleStringSplitter('\n');
    localSimpleStringSplitter.setString(paramString);
    Object localObject = new String[8];
    int i = localObject.length;
    int j;
    if (paramContext != null)
    {
      paramString = paramContext.getString(2131493019);
      j = 0;
      paramContext = (Context)localObject;
    }
    for (;;)
    {
      int k;
      if (localSimpleStringSplitter.hasNext())
      {
        k = j + 1;
        paramContext[j] = localSimpleStringSplitter.next();
        if (k != i) {
          break label359;
        }
        localObject = new String[i * 2];
        System.arraycopy(paramContext, 0, localObject, 0, i);
        i *= 2;
        paramContext = (Context)localObject;
        j = k;
        continue;
        paramString = "me";
        break;
      }
      i = 0;
      if (i < j)
      {
        k = i + 1;
        localObject = paramContext[i];
        if ("".equals(localObject)) {
          i = k;
        }
        for (;;)
        {
          break;
          i = k;
          if (!"e".equals(localObject)) {
            if ("n".equals(localObject))
            {
              i = k + 1;
            }
            else if ("d".equals(localObject))
            {
              i = k + 1;
            }
            else
            {
              i = k;
              if (!"s".equals(localObject))
              {
                i = k;
                if (!"f".equals(localObject))
                {
                  i = k + 1;
                  localObject = paramContext[k];
                  localSimpleStringSplitter = paramContext[i];
                  localObject = localSimpleStringSplitter;
                  if (localSimpleStringSplitter.length() == 0) {
                    localObject = paramString.toString();
                  }
                  localSpannableStringBuilder.append((String)localObject + ", ");
                  i += 1;
                }
              }
            }
          }
        }
      }
      paramContext = localSpannableStringBuilder.toString().trim();
      paramString = paramContext;
      if (!TextUtils.isEmpty(paramContext))
      {
        paramString = paramContext;
        if (paramContext.length() > 1)
        {
          paramString = paramContext;
          if (paramContext.charAt(paramContext.length() - 1) == ',') {
            paramString = paramContext.substring(0, paramContext.length() - 1);
          }
        }
      }
      return paramString;
      label359:
      j = k;
    }
  }
  
  private Cursor performRefresh(String paramString1, String paramString2)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString1);
    if (paramString2 != null)
    {
      paramString1 = getOrCreateAccountState(paramString1).getConversationCursor(Uri.parse(paramString2));
      if (paramString1 != null) {
        paramString1 = paramString1.getWrappedCursor();
      }
    }
    for (;;)
    {
      localMailEngine.performRefresh(paramString1);
      return null;
      paramString1 = null;
      continue;
      paramString1 = null;
    }
  }
  
  private Cursor performUndo(Uri paramUri, String[] paramArrayOfString)
  {
    synchronized (mPreviousOperationUndoOps)
    {
      paramUri = ImmutableList.copyOf(mPreviousOperationUndoOps);
      mPreviousOperationUndoOps.clear();
      ??? = Sets.newHashSet();
      if (paramUri.isEmpty()) {
        break label162;
      }
      Iterator localIterator = paramUri.iterator();
      if (localIterator.hasNext())
      {
        ConversationLabelOperation localConversationLabelOperation = (ConversationLabelOperation)localIterator.next();
        ((Set)???).add(mAccount);
        localConversationLabelOperation.performOperation();
      }
    }
    LogUtils.w("Gmail", "Performed undo on %d operations", new Object[] { Integer.valueOf(paramUri.size()) });
    paramUri = ((Set)???).iterator();
    while (paramUri.hasNext())
    {
      ??? = (String)paramUri.next();
      mContentResolver.notifyChange(Gmail.getBaseUri((String)???), null, false);
      continue;
      label162:
      LogUtils.e("Gmail", "Requested to perform an undo when with no saved undo operations", new Object[0]);
    }
    return new MatrixCursor(paramArrayOfString, 0);
  }
  
  private static void populateAccountCursorRow(Context paramContext, String paramString, MailEngine paramMailEngine, String[] paramArrayOfString, MatrixCursor.RowBuilder paramRowBuilder)
  {
    android.accounts.Account localAccount = new android.accounts.Account(paramString, "com.google");
    Persistence localPersistence = Persistence.getInstance();
    int n = paramArrayOfString.length;
    int k = 0;
    Object localObject1;
    Object localObject2;
    int i;
    if (k < n)
    {
      localObject1 = paramArrayOfString[k];
      if (TextUtils.equals((CharSequence)localObject1, "_id")) {
        paramRowBuilder.add(Integer.valueOf(localAccount.hashCode()));
      }
      for (;;)
      {
        k += 1;
        break;
        if (TextUtils.equals((CharSequence)localObject1, "name"))
        {
          paramRowBuilder.add(paramString);
        }
        else if (TextUtils.equals((CharSequence)localObject1, "providerVersion"))
        {
          paramRowBuilder.add(Integer.valueOf(0));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "accountUri"))
        {
          paramRowBuilder.add(getAccountUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "capabilities"))
        {
          paramRowBuilder.add(GMAIL_CAPABILITIES);
        }
        else if (TextUtils.equals((CharSequence)localObject1, "folderListUri"))
        {
          paramRowBuilder.add(getAccountFoldersUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "fullFolderListUri"))
        {
          paramRowBuilder.add(null);
        }
        else if (TextUtils.equals((CharSequence)localObject1, "searchUri"))
        {
          paramRowBuilder.add(getAccountSearchUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "accountFromAddresses"))
        {
          localObject2 = CustomFromUtils.getCustomReplyFroms(getAccountUri(paramString));
          if (localObject2 != null)
          {
            localObject1 = new JSONArray();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((JSONArray)localObject1).put(((ReplyFromAccount)((Iterator)localObject2).next()).serialize());
            }
            paramRowBuilder.add(((JSONArray)localObject1).toString());
          }
          else
          {
            paramRowBuilder.add(null);
          }
        }
        else if (TextUtils.equals((CharSequence)localObject1, "saveDraftUri"))
        {
          paramRowBuilder.add(getAccountSaveDraftUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "sendMailUri"))
        {
          paramRowBuilder.add(getAccountSendMessageUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "expungeMessageUri"))
        {
          paramRowBuilder.add(getAccountExpungeMessageUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, "undoUri"))
        {
          paramRowBuilder.add(getAccountUndoUri(paramString));
        }
        else if (TextUtils.equals((CharSequence)localObject1, UIProvider.AccountColumns.SETTINGS_INTENT_URI))
        {
          paramRowBuilder.add(getAccountSettingUri(paramString));
        }
        else
        {
          if (TextUtils.equals((CharSequence)localObject1, "syncStatus"))
          {
            int j = 0;
            i = 0;
            if (paramMailEngine != null)
            {
              if (paramMailEngine.isBackgroundSyncInProgress()) {
                i = 4;
              }
              j = i;
              if (paramMailEngine.isLiveQueryInProgress()) {
                j = i | 0x2;
              }
              i = j;
              if (paramMailEngine.isHandlingUserRefresh()) {
                i = j | 0x1;
              }
              if ((paramMailEngine.labelsSynced()) && (requiredLabelsPresent(paramMailEngine))) {
                break label600;
              }
            }
            label600:
            for (int m = 1;; m = 0)
            {
              j = i;
              if (m != 0) {
                j = i | 0x8;
              }
              i = j;
              if (!paramMailEngine.labelsSynchronizationStateInitialized()) {
                i = j | 0x20;
              }
              j = i;
              if (!paramMailEngine.automaticSyncEnabled()) {
                j = i | 0x10;
              }
              paramRowBuilder.add(Integer.valueOf(j));
              break;
            }
          }
          if (TextUtils.equals((CharSequence)localObject1, UIProvider.AccountColumns.HELP_INTENT_URI))
          {
            paramRowBuilder.add(getHelpUri(paramContext));
          }
          else if (TextUtils.equals((CharSequence)localObject1, UIProvider.AccountColumns.SEND_FEEDBACK_INTENT_URI))
          {
            paramRowBuilder.add(getAboutUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, UIProvider.AccountColumns.REAUTHENTICATION_INTENT_URI))
          {
            paramRowBuilder.add(getReauthenticateUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "composeUri"))
          {
            paramRowBuilder.add(getComposeUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "mimeType"))
          {
            paramRowBuilder.add("application/gmail-ls");
          }
          else if (TextUtils.equals((CharSequence)localObject1, "recentFolderListUri"))
          {
            paramRowBuilder.add(getRecentFoldersUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "defaultRecentFolderListUri"))
          {
            paramRowBuilder.add(getDefaultRecentFoldersUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "manualSyncUri"))
          {
            paramRowBuilder.add(getAccountRefreshUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "viewProxyUri"))
          {
            paramRowBuilder.add(getAccountViewIntentProxyUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "accountCookieUri"))
          {
            paramRowBuilder.add(getAccountCookieQueryUri(paramString));
          }
          else if (TextUtils.equals((CharSequence)localObject1, "color"))
          {
            paramRowBuilder.add(Integer.valueOf(0));
          }
          else
          {
            if (!TextUtils.equals((CharSequence)localObject1, "signature")) {
              break label915;
            }
            localObject2 = localPersistence.getSignature(paramContext, paramString);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2)) {
              localObject1 = null;
            }
            paramRowBuilder.add(localObject1);
          }
        }
      }
      label915:
      if (TextUtils.equals((CharSequence)localObject1, "auto_advance"))
      {
        if (localPersistence.getHasUserSetAutoAdvanceSetting(paramContext)) {
          if (localPersistence.getAutoAdvanceModeNewer(paramContext)) {
            i = 2;
          }
        }
        for (;;)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
          if (localPersistence.getAutoAdvanceModeOlder(paramContext))
          {
            i = 1;
          }
          else
          {
            i = 3;
            continue;
            i = 0;
          }
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "message_text_size"))
      {
        localObject1 = localPersistence.getMessageTextSize(paramContext);
        localObject2 = paramContext.getResources().getStringArray(2131623956);
        i = 0;
        label1022:
        if (i >= localObject2.length) {
          break label1743;
        }
        if (!TextUtils.equals((CharSequence)localObject1, localObject2[i])) {}
      }
    }
    for (;;)
    {
      if (i != -1) {}
      for (i = UI_PROVIDER_MESSAGE_TEXT_SIZE_VALUES[i];; i = 0)
      {
        paramRowBuilder.add(Integer.valueOf(i));
        break;
        i += 1;
        break label1022;
      }
      if (TextUtils.equals((CharSequence)localObject1, "reply_behavior"))
      {
        if (localPersistence.getActionStripActionReplyAll(paramContext)) {}
        for (i = 1;; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "hide_checkboxes"))
      {
        if (localPersistence.getHideCheckboxes(paramContext)) {}
        for (i = 1;; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "confirm_delete"))
      {
        if (localPersistence.getConfirmDelete(paramContext)) {}
        for (i = 1;; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "confirm_archive"))
      {
        if (localPersistence.getConfirmArchive(paramContext)) {}
        for (i = 1;; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "confirm_send"))
      {
        if (localPersistence.getConfirmSend(paramContext)) {}
        for (i = 1;; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "default_inbox"))
      {
        paramRowBuilder.add(getAccountLabelUri(paramString, Persistence.getAccountInbox(paramContext, paramString)));
        break;
      }
      if (TextUtils.equals((CharSequence)localObject1, "default_inbox_name"))
      {
        localObject2 = Persistence.getAccountInbox(paramContext, paramString);
        if (paramMailEngine != null) {}
        for (localObject1 = paramMailEngine.getLabelMap();; localObject1 = null)
        {
          paramRowBuilder.add(getLabelFromCanonicalisSystemLabelsecond);
          break;
        }
      }
      if (TextUtils.equals((CharSequence)localObject1, "snap_headers"))
      {
        localObject1 = localPersistence.getSnapHeaderMode(paramContext);
        localObject2 = paramContext.getResources().getStringArray(2131623959);
        i = 0;
        label1424:
        if (i >= localObject2.length) {
          break label1737;
        }
        if (!TextUtils.equals((CharSequence)localObject1, localObject2[i])) {}
      }
      for (;;)
      {
        if (i != -1) {}
        for (i = UI_PROVIDER_SNAP_HEADER_MODE_VALUES[i];; i = 0)
        {
          paramRowBuilder.add(Integer.valueOf(i));
          break;
          i += 1;
          break label1424;
        }
        if (TextUtils.equals((CharSequence)localObject1, "force_reply_from_default"))
        {
          if (CustomFromUtils.replyFromDefaultAddress(getAccountUri(paramString))) {}
          for (i = 1;; i = 0)
          {
            paramRowBuilder.add(Integer.valueOf(i));
            break;
          }
        }
        if (TextUtils.equals((CharSequence)localObject1, "max_attachment_size"))
        {
          paramRowBuilder.add(Integer.valueOf(Gservices.getInt(paramContext.getContentResolver(), "gmail_max_attachment_size_bytes", 26214400)));
          break;
        }
        if (TextUtils.equals((CharSequence)localObject1, "swipe"))
        {
          paramRowBuilder.add(Integer.valueOf(localPersistence.getSwipeIntegerPreference(paramContext)));
          break;
        }
        if (TextUtils.equals((CharSequence)localObject1, "priority_inbox_arrows_enabled"))
        {
          if (localPersistence.getPriorityInboxArrowsEnabled(paramContext, paramString)) {}
          for (i = 1;; i = 0)
          {
            paramRowBuilder.add(Integer.valueOf(i));
            break;
          }
        }
        if (TextUtils.equals((CharSequence)localObject1, "setup_intent_uri"))
        {
          paramRowBuilder.add(Uri.EMPTY);
          break;
        }
        if (TextUtils.equals((CharSequence)localObject1, "conversation_view_mode"))
        {
          if (localPersistence.getConversationOverviewMode(paramContext)) {}
          for (i = 0;; i = 1)
          {
            paramRowBuilder.add(Integer.valueOf(i));
            break;
          }
        }
        throw new IllegalStateException("Unexpected column: " + (String)localObject1);
        return;
        label1737:
        i = -1;
      }
      label1743:
      i = -1;
    }
  }
  
  private final void populateRecentLabels(MailEngine paramMailEngine, String paramString)
  {
    LogUtils.d("Gmail", "UiProvider.populateRecentLabels()", new Object[0]);
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "^t";
    arrayOfString[1] = "^f";
    arrayOfString[2] = "^r";
    long l = System.currentTimeMillis();
    ContentValues localContentValues = new ContentValues(arrayOfString.length);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      LogUtils.d("Gmail", "Marking %s with %d", new Object[] { str, Long.valueOf(l) });
      localContentValues.put(str, Long.valueOf(l));
      i += 1;
    }
    paramMailEngine.updateLabelsLastTouched(localContentValues);
    mContentResolver.notifyChange(getRecentFoldersUri(paramString), null, false);
  }
  
  private static boolean requiredLabelsPresent(MailEngine paramMailEngine)
  {
    paramMailEngine = paramMailEngine.getLabelMap();
    String[] arrayOfString = UI_PROVIDER_REQUIRED_LABELS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!paramMailEngine.labelPresent(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private long saveDraft(MailEngine paramMailEngine, ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("_id")) {}
    for (long l = paramContentValues.getAsLong("_id").longValue();; l = 0L) {
      return sendOrSaveDraft(paramMailEngine, l, true, translateMessage(paramContentValues));
    }
  }
  
  private void scheduleAccountChangeNotification(Context paramContext, String paramString)
  {
    Handler localHandler = mUiProviderHandler;
    if (localHandler == null)
    {
      LogUtils.w("Gmail", "Attempting to schedule notification before initialization", new Object[0]);
      return;
    }
    synchronized (mAccountChangeNotifiers)
    {
      AccountChangedNotifier localAccountChangedNotifier2 = (AccountChangedNotifier)mAccountChangeNotifiers.get(paramString);
      AccountChangedNotifier localAccountChangedNotifier1 = localAccountChangedNotifier2;
      if (localAccountChangedNotifier2 == null)
      {
        localAccountChangedNotifier1 = new AccountChangedNotifier(paramContext, localHandler.getLooper(), paramString);
        mAccountChangeNotifiers.put(paramString, localAccountChangedNotifier1);
      }
      localAccountChangedNotifier1.scheduleTask();
      return;
    }
  }
  
  private long sendMessage(MailEngine paramMailEngine, ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("_id")) {}
    for (long l = paramContentValues.getAsLong("_id").longValue();; l = 0L) {
      return sendOrSaveDraft(paramMailEngine, l, false, translateMessage(paramContentValues));
    }
  }
  
  private long sendOrSaveDraft(MailEngine paramMailEngine, long paramLong, boolean paramBoolean, ContentValues paramContentValues)
  {
    paramContentValues = new ContentValues(paramContentValues);
    long l = paramContentValues.getAsLong("refMessageId").longValue();
    paramContentValues.remove("refMessageId");
    paramLong = paramMailEngine.sendOrSaveDraft(paramLong, paramBoolean, l, paramContentValues);
    paramContentValues = paramMailEngine.getLocalMessage(paramLong, false);
    if (paramContentValues != null) {
      mContentResolver.notifyChange(getConversationMessageListUri(paramMailEngine.getAccountName(), conversationId), null, false);
    }
    return paramLong;
  }
  
  private ContentValues translateMessage(ContentValues paramContentValues)
  {
    boolean bool2 = true;
    long l3 = 0L;
    long l1;
    ContentValues localContentValues;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    label199:
    Attachment localAttachment;
    if (paramContentValues.containsKey("_id"))
    {
      l1 = paramContentValues.getAsLong("_id").longValue();
      localContentValues = new ContentValues();
      localContentValues.put("toAddresses", uiProviderToGmailRecipients(paramContentValues.getAsString("toAddresses")));
      localContentValues.put("ccAddresses", uiProviderToGmailRecipients(paramContentValues.getAsString("ccAddresses")));
      localContentValues.put("bccAddresses", uiProviderToGmailRecipients(paramContentValues.getAsString("bccAddresses")));
      localContentValues.put("subject", paramContentValues.getAsString("subject"));
      localContentValues.put("snippet", paramContentValues.getAsString("snippet"));
      localContentValues.put("replyToAddresses", paramContentValues.getAsString("replyToAddress"));
      localContentValues.put("fromAddress", paramContentValues.getAsString("fromAddress"));
      localContentValues.put("customFromAddress", paramContentValues.getAsString("customFrom"));
      localObject1 = paramContentValues.getAsString("joinedAttachmentInfos");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label308;
      }
      localObject2 = Lists.newArrayList();
      localObject3 = Attachment.fromJSONArray((String)localObject1).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label292;
      }
      localAttachment = (Attachment)((Iterator)localObject3).next();
      localObject1 = uri;
      if ((localObject1 == null) || (!"com.android.gmail.ui".equals(((Uri)localObject1).getAuthority()))) {
        break label528;
      }
      localObject1 = ((Uri)localObject1).getQueryParameter("gmailJoinedAttachment");
      if (localObject1 == null) {
        break label528;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        localObject1 = localAttachment.toJoinedString();
      }
      for (;;)
      {
        ((List)localObject2).add(localObject1);
        break label199;
        l1 = 0L;
        break;
        label292:
        localContentValues.put("joinedAttachmentInfos", TextUtils.join("\n", (Iterable)localObject2));
        label308:
        localObject2 = paramContentValues.getAsString("bodyHtml");
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject3 = paramContentValues.getAsString("bodyText");
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = Html.toHtml(new SpannedString((CharSequence)localObject3));
          }
        }
        localContentValues.put("body", (String)localObject1);
        localObject1 = paramContentValues.getAsInteger("appendRefMessageContent");
        if ((localObject1 != null) && (((Integer)localObject1).intValue() != 0)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localContentValues.put("includeQuotedText", Boolean.valueOf(bool1));
          localContentValues.put("quoteStartPos", paramContentValues.getAsInteger("quotedTextStartPos"));
          l2 = l3;
          if (l1 == 0L)
          {
            if (paramContentValues.containsKey("refMessageId")) {
              break;
            }
            l2 = l3;
          }
          localContentValues.put("refMessageId", Long.valueOf(l2));
          return localContentValues;
        }
        long l2 = Long.parseLong(Uri.parse(paramContentValues.getAsString("refMessageId")).getLastPathSegment());
        if (paramContentValues.getAsInteger("draftType").intValue() == 4) {}
        for (bool1 = bool2;; bool1 = false)
        {
          localContentValues.put("forward", Boolean.valueOf(bool1));
          break;
        }
      }
      label528:
      localObject1 = null;
    }
  }
  
  private static String uiProviderToGmailRecipients(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return TextUtils.join("\n", Message.tokenizeAddresses(paramString));
  }
  
  private void updateAccountsIntializedStatus()
  {
    if (mAccountsPendingInitialization.size() == 0)
    {
      mAccountsFullyInitialized = true;
      notifyAccountListChanged(getContext());
    }
  }
  
  private int updateAttachmentState(Uri paramUri, ContentValues paramContentValues)
  {
    Integer localInteger = paramContentValues.getAsInteger("state");
    paramContentValues = paramContentValues.getAsInteger("destination");
    if ((localInteger == null) && (paramContentValues == null)) {}
    UIAttachment.UriParser localUriParser;
    do
    {
      return 0;
      localUriParser = UIAttachment.UriParser.parse(paramUri);
      localObject = getConversationState(mAccount, mConversationId);
      paramUri = getOrMakeMailEngine(mAccount);
    } while (localInteger == null);
    Object localObject = ((ConversationState)localObject).getOrCreateMessageState(localUriParser).getMessageAttachment(mPartId);
    if (localObject == null)
    {
      LogUtils.e("Gmail", "couldn't find attachment in update AttachmentState", new Object[0]);
      return 0;
    }
    int j = localInteger.intValue();
    switch (j)
    {
    case 1: 
    case 3: 
    default: 
      return 0;
    case 0: 
      if (((UIAttachment)localObject).getDestination() != 1) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      ((UIAttachment)localObject).updateState(0, 0, null);
      paramContentValues = MailProvider.attachmentRequestForUri(paramUri, Gmail.getAttachmentUri(mAccount, mLocalMessageId, (UIAttachment)localObject, Gmail.AttachmentRendition.BEST, bool));
      if (paramContentValues == null) {
        break;
      }
      return paramUri.getAttachmentManager().cancelDownloadRequest(message.conversationId, message.messageId, mPartId, rendition, saveToSd);
      int i;
      if (paramContentValues != null)
      {
        i = paramContentValues.intValue();
        label247:
        if (i != 1) {
          break label378;
        }
      }
      label378:
      for (bool = true;; bool = false)
      {
        ((UIAttachment)localObject).updateState(2, i, null);
        paramContentValues = MailProvider.attachmentRequestForUri(paramUri, Gmail.getAttachmentUri(mAccount, mLocalMessageId, (UIAttachment)localObject, Gmail.AttachmentRendition.BEST, bool));
        if (paramContentValues == null) {
          break;
        }
        paramUri = paramUri.getAttachmentManager();
        if (j == 4) {
          paramUri.resetAttachmentRequest(message.conversationId, message.messageId, attachment.partId, rendition, saveToSd);
        }
        paramUri.queryAndStartDownloadingAttachment(message.conversationId, message.messageId, attachment, rendition, saveToSd, null);
        return 1;
        i = 0;
        break label247;
      }
    }
  }
  
  private int updateConversation(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    MailEngine localMailEngine = getOrMakeMailEngine(paramString2);
    Object localObject1 = null;
    long l = Long.parseLong(paramString1);
    Object localObject2;
    int i;
    if (paramContentValues.containsKey("operation"))
    {
      localObject2 = paramContentValues.getAsString("operation");
      if ("discard_drafts".equals(localObject2)) {
        i = 1;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ConversationLabelOperation(paramString2, l, null);
      }
      if (paramContentValues.containsKey(UIProvider.ConversationColumns.STARRED)) {
        ((ConversationLabelOperation)localObject2).add(LabelManager.getLabel(getContext(), paramString2, "^t"), paramContentValues.getAsBoolean(UIProvider.ConversationColumns.STARRED).booleanValue());
      }
      boolean bool;
      label145:
      int j;
      if (paramContentValues.containsKey(UIProvider.ConversationColumns.READ))
      {
        localObject1 = LabelManager.getLabel(getContext(), paramString2, "^u");
        if (!paramContentValues.getAsBoolean(UIProvider.ConversationColumns.READ).booleanValue())
        {
          bool = true;
          ((ConversationLabelOperation)localObject2).add((Label)localObject1, bool);
        }
      }
      else
      {
        if (paramContentValues.containsKey("viewed")) {
          ((ConversationLabelOperation)localObject2).add(LabelManager.getLabel(getContext(), paramString2, "^o"), true);
        }
        if (paramContentValues.containsKey(UIProvider.ConversationColumns.PRIORITY))
        {
          if (paramContentValues.getAsInteger(UIProvider.ConversationColumns.PRIORITY).intValue() != 1) {
            break label354;
          }
          j = 1;
          label207:
          if (j == 0) {
            break label360;
          }
          paramContentValues = "^^important";
          label216:
          ((ConversationLabelOperation)localObject2).add(LabelManager.getLabel(getContext(), paramString2, paramContentValues), true);
        }
        if (i == 0) {
          break label367;
        }
      }
      label354:
      label360:
      label367:
      for (i = localMailEngine.expungeDraftMessages(l);; i = 0)
      {
        addUndoOperation(paramInt, (ConversationLabelOperation)((ConversationLabelOperation)localObject2).undoOperation());
        return addRemoveLabel(new String[] { paramString1 }, paramString2, (LabelOperations)localObject2) + i;
        localObject1 = createLabelOperationsForUIOperation(paramString2, l, (String)localObject2);
        i = 0;
        break;
        if (!paramContentValues.containsKey("rawFolders")) {
          break label373;
        }
        localObject1 = localMailEngine.getLabelsForConversation(getContext(), paramString1, mGmail);
        localObject1 = createLabelOperations(paramString2, l, Folder.getFoldersArray(paramContentValues.getAsString("rawFolders")), (List)localObject1);
        i = 0;
        break;
        bool = false;
        break label145;
        j = 0;
        break label207;
        paramContentValues = "^^unimportant";
        break label216;
      }
      label373:
      localObject1 = null;
      i = 0;
    }
  }
  
  private int updateLabelsLastTouched(MailEngine paramMailEngine, String paramString, ContentValues paramContentValues)
  {
    Object localObject = paramContentValues.keySet();
    paramContentValues = new ContentValues(paramContentValues.size());
    long l = System.currentTimeMillis();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramContentValues.put(Uri.parse((String)((Iterator)localObject).next()).getLastPathSegment(), Long.valueOf(l));
    }
    localObject = paramContentValues.keySet();
    if (LogUtils.isLoggable("Gmail", 2)) {
      LogUtils.v("Gmail", "Updating last touched for labels: %s", new Object[] { LogUtils.labelSetToString((Set)localObject) });
    }
    localObject = paramMailEngine.getLabelsForCanonicalNames((String[])((Set)localObject).toArray(new String[((Set)localObject).size()]));
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      MailCore.Label localLabel = localObject[i];
      if (localLabel != null) {
        paramMailEngine.clearNewUnreadMailForNotificationLabelIfNeeded(localLabel);
      }
      i += 1;
    }
    i = paramMailEngine.updateLabelsLastTouched(paramContentValues);
    mContentResolver.notifyChange(getRecentFoldersUri(paramString), null, false);
    return i;
  }
  
  private int updateMessageState(String paramString, Uri paramUri, ContentValues paramContentValues)
  {
    int k = 1;
    Object localObject1 = getOrMakeMailEngine(paramString);
    long l = Long.parseLong(paramUri.getLastPathSegment());
    Object localObject2 = paramContentValues.getAsInteger(UIProvider.MessageColumns.READ);
    paramUri = paramContentValues.getAsInteger(UIProvider.MessageColumns.STARRED);
    paramContentValues = paramContentValues.getAsInteger("alwaysShowImages");
    if ((paramContentValues == null) && (localObject2 == null) && (paramUri == null)) {
      return 0;
    }
    localObject1 = ((MailEngine)localObject1).getLocalMessage(l, false);
    if (localObject1 == null)
    {
      LogUtils.e("Gmail", "Error finding message for localMessageId: %d", new Object[] { Long.valueOf(l) });
      return 0;
    }
    boolean bool;
    if (localObject2 != null) {
      if (((Integer)localObject2).intValue() == 0)
      {
        bool = true;
        localObject2 = new ContentValues();
        ((ContentValues)localObject2).put("canonicalName", "^u");
        ((ContentValues)localObject2).put("_id", Long.valueOf(l));
        ((ContentValues)localObject2).put("messageId", Long.valueOf(messageId));
        ((ContentValues)localObject2).put("conversation", Long.valueOf(conversationId));
        ((ContentValues)localObject2).put("add_label_action", Boolean.valueOf(bool));
        mGmail.addOrRemoveLabelOnMessageBulk(paramString, new ContentValues[] { localObject2 }, true);
      }
    }
    for (int i = 1;; i = 0)
    {
      if (paramUri != null)
      {
        if (paramUri.intValue() != 0)
        {
          bool = true;
          label226:
          paramUri = new ContentValues();
          paramUri.put("canonicalName", "^t");
          paramUri.put("_id", Long.valueOf(l));
          paramUri.put("messageId", Long.valueOf(messageId));
          paramUri.put("conversation", Long.valueOf(conversationId));
          paramUri.put("add_label_action", Boolean.valueOf(bool));
          mGmail.addOrRemoveLabelOnMessageBulk(paramString, new ContentValues[] { paramUri }, true);
          i = 1;
        }
      }
      else
      {
        int j = i;
        if (paramContentValues != null)
        {
          j = i;
          if (paramContentValues.intValue() != 0)
          {
            paramString = Persistence.getInstance();
            paramUri = getEmailAddress(fromAddress).getAddress();
            paramString.setDisplayImagesFromSender(getContext(), paramUri);
            j = 1;
          }
        }
        if (j == 0) {
          break label388;
        }
      }
      label388:
      for (i = k;; i = 0)
      {
        return i;
        bool = false;
        break;
        bool = false;
        break label226;
      }
    }
  }
  
  private void updateSearchResultCount(String paramString1, int paramInt, String paramString2)
  {
    getOrCreateAccountState(paramString1).setNumSearchResults(paramString2, paramInt);
    mContentResolver.notifyChange(getAccountSearchUri(paramString1), null, false);
  }
  
  public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> paramArrayList)
    throws OperationApplicationException
  {
    localObject = Sets.newHashSet();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext()) {
      ((Set)localObject).add((String)((ContentProviderOperation)localIterator.next()).getUri().getPathSegments().get(0));
    }
    if (((Set)localObject).size() == 1)
    {
      localObject = ((Set)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        localObject = getOrMakeMailEngine((String)((Iterator)localObject).next());
      }
    }
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        ((MailEngine)localObject).beginTransaction(true);
        paramArrayList = super.applyBatch(paramArrayList);
        if (localObject != null) {
          ((MailEngine)localObject).setTransactionSuccessful();
        }
        return paramArrayList;
      }
      finally
      {
        if (localObject == null) {
          break;
        }
        ((MailEngine)localObject).endTransaction();
      }
      localObject = null;
      continue;
      localObject = null;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "UiProvider.delete: %s", new Object[] { LogUtils.contentUriToString(paramUri) });
    }
    int i = sUrlMatcher.match(paramUri);
    paramString = (String)paramUri.getPathSegments().get(0);
    switch (i)
    {
    default: 
      return 0;
    }
    paramArrayOfString = (String)paramUri.getPathSegments().get(2);
    i = -1;
    paramUri = paramUri.getQueryParameter("seq");
    if (paramUri != null) {
      i = Integer.parseInt(paramUri);
    }
    return delete(paramArrayOfString, paramString, i);
  }
  
  public String getType(Uri paramUri)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "UiProvider.getType: %s", new Object[] { LogUtils.contentUriToString(paramUri) });
    }
    switch (sUrlMatcher.match(paramUri))
    {
    default: 
      return null;
    }
    return paramUri.getQueryParameter("mimeType");
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "UiProvider.insert: %s(%s)", new Object[] { LogUtils.contentUriToString(paramUri), paramContentValues });
    }
    int i = sUrlMatcher.match(paramUri);
    String str = (String)paramUri.getPathSegments().get(0);
    MailEngine localMailEngine = getOrMakeMailEngine(str);
    MailIndexerService.onContentProviderAccess(str);
    switch (i)
    {
    default: 
      LogUtils.wtf("Gmail", "Unexpected UiProvider.insert: %s(%s)", new Object[] { LogUtils.contentUriToString(paramUri), paramContentValues });
      return null;
    case 8: 
      l = sendMessage(localMailEngine, paramContentValues);
      LogUtils.d("Gmail", "UiProvider.insert(): added local message %d", new Object[] { Long.valueOf(l) });
      return getMessageByIdUri(str, l);
    }
    long l = saveDraft(localMailEngine, paramContentValues);
    LogUtils.d("Gmail", "UiProvider.insert(): added local message %d", new Object[] { Long.valueOf(l) });
    return getMessageByIdUri(str, l);
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    mContentResolver = localContext.getContentResolver();
    mGmail = new Gmail(mContentResolver);
    sAccountNotificationDelayMs = localContext.getResources().getInteger(2131361854);
    sGmailQuote = localContext.getResources().getString(2131493126);
    intializeLoaderHandler();
    sInstance = this;
    return true;
  }
  
  public void onMailEngineResult(MailEngine paramMailEngine)
  {
    mAccountsPendingInitialization.remove(paramMailEngine.getAccountName());
    updateAccountsIntializedStatus();
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "UiProvider.query: %s(%s, %s)", new Object[] { LogUtils.contentUriToString(paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    int i = sUrlMatcher.match(paramUri);
    if (i == 1)
    {
      paramArrayOfString1 = getAccountsCursor(paramArrayOfString1);
      paramArrayOfString1.setNotificationUri(mContentResolver, ACCOUNTS_URI);
      return paramArrayOfString1;
    }
    paramArrayOfString2 = (String)paramUri.getPathSegments().get(0);
    paramString1 = null;
    switch (i)
    {
    case 7: 
    case 8: 
    case 9: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 24: 
    case 25: 
    default: 
      i = 1;
      paramUri = paramString1;
    case 2: 
    case 3: 
    case 18: 
      for (;;)
      {
        paramArrayOfString1 = paramUri;
        if (paramUri == null) {
          break;
        }
        paramArrayOfString1 = paramUri;
        if (i == 0) {
          break;
        }
        paramUri.setNotificationUri(mContentResolver, getAccountBaseNotificationUri(paramArrayOfString2));
        return paramUri;
        paramArrayOfString1 = getAccountCursor(paramArrayOfString2, paramArrayOfString1);
        paramArrayOfString1.setNotificationUri(mContentResolver, paramUri);
        paramUri = paramArrayOfString1;
        i = 0;
        continue;
        paramUri = getAccountLabelsCursor(paramArrayOfString2, paramArrayOfString1);
        paramUri.setNotificationUri(mContentResolver, getAccountFoldersUri(paramArrayOfString2));
        i = 0;
        continue;
        paramString1 = paramUri.getLastPathSegment();
        paramUri = getAccountLabelCursor(paramArrayOfString2, paramString1, paramArrayOfString1);
        paramUri.setNotificationUri(mContentResolver, getAccountLabelNotificationUri(paramArrayOfString2, paramString1));
        i = 0;
      }
    case 4: 
    case 5: 
      paramString2 = paramUri.getQueryParameter("limit");
      paramString1 = null;
    }
    try
    {
      int j = Integer.parseInt(paramString2);
      paramString1 = Integer.valueOf(j);
    }
    catch (NumberFormatException paramString2)
    {
      boolean bool1;
      for (;;) {}
      label946:
      i = 1;
    }
    bool1 = true;
    paramString2 = paramUri.getQueryParameter("use_network");
    if (paramString2 != null) {
      bool1 = Boolean.parseBoolean(paramString2);
    }
    paramString2 = paramUri.getQueryParameter("all_notifications");
    if (paramString2 != null) {}
    for (boolean bool2 = Boolean.parseBoolean(paramString2);; bool2 = false)
    {
      if (i == 4) {
        paramString2 = (String)paramUri.getPathSegments().get(2);
      }
      long l;
      for (;;)
      {
        try
        {
          l = Long.parseLong(paramString2);
          paramString1 = getConversationsForLabelId(paramArrayOfString2, paramUri, l, paramArrayOfString1, paramString1, bool1);
          paramUri = paramString1;
          if (paramString1 == null)
          {
            LogUtils.e("Gmail", "Returning an empty cursor instead of a null cursor", new Object[0]);
            paramUri = new MatrixCursor(paramArrayOfString1, 0);
          }
          if ((!bool2) || (paramUri == null)) {
            break label946;
          }
          paramUri.setNotificationUri(mContentResolver, Gmail.getBaseUri(paramArrayOfString2));
          i = 0;
        }
        catch (NumberFormatException paramUri)
        {
          LogUtils.e("Gmail", paramUri, "Unable to parse label id %s", new Object[] { paramString2 });
          return new MatrixCursor(paramArrayOfString1, 0);
        }
        paramString1 = getConversationsForLabel(paramArrayOfString2, paramUri, (String)paramUri.getPathSegments().get(2), paramArrayOfString1, paramString1, bool1);
      }
      paramString1 = (String)paramUri.getPathSegments().get(2);
      try
      {
        l = Long.parseLong(paramString1);
        bool2 = true;
        paramUri = paramUri.getQueryParameter("listParams");
        bool1 = bool2;
        if (paramUri != null)
        {
          paramUri = ListParams.newinstance(paramUri);
          bool1 = bool2;
          if (paramUri != null) {
            bool1 = mUseNetwork;
          }
        }
        paramUri = getMessagesForConversation(paramArrayOfString2, l, paramArrayOfString1, bool1);
        i = 0;
      }
      catch (NumberFormatException paramUri)
      {
        return null;
      }
      paramUri = getMessageForId(paramArrayOfString2, Long.parseLong(paramUri.getLastPathSegment()));
      i = 1;
      break;
      paramUri = performUndo(paramUri, paramArrayOfString1);
      i = 1;
      break;
      if (i == 16) {}
      for (paramUri = paramUri.getLastPathSegment();; paramUri = null)
      {
        paramUri = performRefresh(paramArrayOfString2, paramUri);
        i = 1;
        break;
      }
      paramString1 = paramUri.getQueryParameter("query");
      paramArrayOfString1 = paramUri.getQueryParameter("folder");
      if (paramArrayOfString1 != null) {}
      for (paramArrayOfString1 = (String)Uri.parse(paramArrayOfString1).getPathSegments().get(2);; paramArrayOfString1 = null)
      {
        paramArrayOfString1 = getFakeSearchFolder(paramUri, paramArrayOfString2, paramString1, paramArrayOfString1);
        paramArrayOfString1.setNotificationUri(mContentResolver, paramUri.buildUpon().clearQuery().build());
        paramUri = paramArrayOfString1;
        i = 0;
        break;
      }
      paramString2 = paramUri.getQueryParameter("query");
      paramString1 = paramUri.getQueryParameter("folder");
      if (paramString1 != null) {}
      for (paramString1 = (String)Uri.parse(paramString1).getPathSegments().get(2);; paramString1 = null)
      {
        paramUri = getConversationsForQuery(paramArrayOfString2, paramUri, paramString2, paramString1, paramArrayOfString1, null, true);
        updateSearchResultCount(paramArrayOfString2, paramUri.getCount(), paramString2);
        i = 1;
        break;
      }
      paramUri = getRecentLabelsCursor(paramArrayOfString2, paramArrayOfString1);
      paramUri.setNotificationUri(mContentResolver, getRecentFoldersUri(paramArrayOfString2));
      i = 0;
      break;
      paramArrayOfString1 = getMessageAttachments(UIAttachment.UriParser.parse(paramUri), paramArrayOfString1);
      paramArrayOfString1.setNotificationUri(mContentResolver, paramUri);
      paramUri = paramArrayOfString1;
      i = 0;
      break;
      paramUri = getAccountCookieCursor(paramArrayOfString2, paramArrayOfString1);
      i = 1;
      break;
      break;
    }
  }
  
  public void shutdown()
  {
    sInstance = null;
    sAccountStateMap.clear();
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "UiProvider.update: %s(%s)", new Object[] { LogUtils.contentUriToString(paramUri), paramContentValues });
    }
    int i = sUrlMatcher.match(paramUri);
    paramString = (String)paramUri.getPathSegments().get(0);
    paramArrayOfString = getOrMakeMailEngine(paramString);
    MailIndexerService.onContentProviderAccess(paramString);
    switch (i)
    {
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    default: 
      LogUtils.wtf("Gmail", "Unexpected UiProvider.update: %s", new Object[] { LogUtils.contentUriToString(paramUri) + " and values are : " + paramContentValues.toString() });
    case 13: 
    case 8: 
    case 12: 
    case 9: 
    case 11: 
    case 25: 
      for (;;)
      {
        return 0;
        paramArrayOfString = (String)paramUri.getPathSegments().get(2);
        i = -1;
        paramUri = paramUri.getQueryParameter("seq");
        if (paramUri != null) {
          i = Integer.parseInt(paramUri);
        }
        return updateConversation(paramArrayOfString, paramString, paramContentValues, i);
        long l = sendMessage(paramArrayOfString, paramContentValues);
        LogUtils.d("Gmail", "UiProvider.update(): added local message %d", new Object[] { Long.valueOf(l) });
        return (int)l;
        l = saveDraft(paramArrayOfString, paramContentValues);
        LogUtils.d("Gmail", "UiProvider.update(): added local message %d", new Object[] { Long.valueOf(l) });
        return (int)l;
        LogUtils.d("Gmail", "update: running populateRecentLabels.", new Object[0]);
        populateRecentLabels(paramArrayOfString, paramString);
      }
    case 21: 
      return updateLabelsLastTouched(paramArrayOfString, paramString, paramContentValues);
    case 23: 
      return updateAttachmentState(paramUri, paramContentValues);
    case 22: 
      return 0;
    case 10: 
      return updateMessageState(paramString, paramUri, paramContentValues);
    }
    return expungeMessage(paramString, paramContentValues);
  }
  
  private static class AccountChangedNotifier
    extends DelayedTaskHandler
  {
    private final Uri mNotificationUri;
    private final ContentResolver mResolver;
    
    AccountChangedNotifier(Context paramContext, Looper paramLooper, String paramString)
    {
      super(UiProvider.sAccountNotificationDelayMs);
      mResolver = paramContext.getContentResolver();
      mNotificationUri = UiProvider.getAccountBaseNotificationUri(paramString);
    }
    
    protected void performTask()
    {
      mResolver.notifyChange(mNotificationUri, null, false);
    }
  }
  
  private class AttachmentCursor
    extends MatrixCursor
  {
    private final String mAccount;
    private final long mConversationId;
    private final long mMessageId;
    
    public AttachmentCursor(String paramString, long paramLong1, long paramLong2, String[] paramArrayOfString, int paramInt)
    {
      super(paramInt);
      mAccount = paramString;
      mConversationId = paramLong1;
      mMessageId = paramLong2;
    }
    
    public void close()
    {
      synchronized (UiProvider.sAccountStateMap)
      {
        Object localObject1 = (AccountState)UiProvider.sAccountStateMap.get(mAccount);
        if (localObject1 != null)
        {
          localObject1 = ((AccountState)localObject1).getConversationState(mConversationId);
          if (localObject1 != null) {
            ((ConversationState)localObject1).handleCursorClose(this);
          }
        }
        super.close();
        return;
      }
    }
  }
  
  private class ConversationLabelOperation
    extends LabelOperations
  {
    final String mAccount;
    final long mConversationId;
    
    private ConversationLabelOperation(String paramString, long paramLong)
    {
      mAccount = paramString;
      mConversationId = paramLong;
    }
    
    private void performOperation()
    {
      UiProvider localUiProvider = UiProvider.this;
      String str1 = Long.toString(mConversationId);
      String str2 = mAccount;
      localUiProvider.addRemoveLabel(new String[] { str1 }, str2, this);
    }
    
    protected LabelOperations createNewInstance()
    {
      return new ConversationLabelOperation(UiProvider.this, mAccount, mConversationId);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.UiProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */