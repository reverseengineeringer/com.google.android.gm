package com.google.android.gm.provider;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gm.Utils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MailProvider
  extends ContentProvider
  implements OnAccountsUpdateListener
{
  private static volatile MailProvider sThis;
  private static final UriMatcher sUrlMatcher = new UriMatcher(-1);
  private String mBoundAccount = null;
  private MailEngine mBoundEngine;
  private ContentResolver mContentResolver;
  private Handler mHandler;
  
  static
  {
    sUrlMatcher.addURI("gmail-ls", "*/conversations", 1);
    sUrlMatcher.addURI("gmail-ls", "*/conversations/labels", 16);
    sUrlMatcher.addURI("gmail-ls", "*/conversations/#/labels", 3);
    sUrlMatcher.addURI("gmail-ls", "*/conversations/#/labels/*", 4);
    sUrlMatcher.addURI("gmail-ls", "*/conversations/#/attachments", 21);
    sUrlMatcher.addURI("gmail-ls", "*/conversations/#/messages", 5);
    sUrlMatcher.addURI("gmail-ls", "*/messages", 6);
    sUrlMatcher.addURI("gmail-ls", "*/messages/#", 7);
    sUrlMatcher.addURI("gmail-ls", "*/messages/server/#", 8);
    sUrlMatcher.addURI("gmail-ls", "*/messages/#/labels", 9);
    sUrlMatcher.addURI("gmail-ls", "*/messages/#/labels/*", 10);
    sUrlMatcher.addURI("gmail-ls", "*/messages/labels", 17);
    sUrlMatcher.addURI("gmail-ls", "*/messages/#/attachments/*/*/*", 11);
    sUrlMatcher.addURI("gmail-ls", "*/messages/#/attachments/*/*/*/download", 12);
    sUrlMatcher.addURI("gmail-ls", "*/labels/lastTouched", 22);
    sUrlMatcher.addURI("gmail-ls", "*/labels/*/#", 18);
    sUrlMatcher.addURI("gmail-ls", "*/labels/*", 13);
    sUrlMatcher.addURI("gmail-ls", "*/label/#", 19);
    sUrlMatcher.addURI("gmail-ls", "*/settings", 14);
    sUrlMatcher.addURI("gmail-ls", "*/unread/*", 15);
    sUrlMatcher.addURI("gmail-ls", "*/status", 20);
  }
  
  static AttachmentRequest attachmentRequestForUri(MailEngine paramMailEngine, Uri paramUri)
  {
    paramMailEngine = paramMailEngine.getLocalMessage(Long.parseLong((String)paramUri.getPathSegments().get(2)), false);
    if (paramMailEngine == null)
    {
      LogUtils.w("Gmail", "Message not found", new Object[0]);
      return null;
    }
    Gmail.Attachment localAttachment = paramMailEngine.getAttachmentOrNull((String)paramUri.getPathSegments().get(4));
    if (localAttachment == null)
    {
      LogUtils.w("Gmail", "Attachment not found", new Object[0]);
      return null;
    }
    Gmail.AttachmentRendition localAttachmentRendition = Gmail.AttachmentRendition.valueOf((String)paramUri.getPathSegments().get(5));
    boolean bool = Boolean.valueOf((String)paramUri.getPathSegments().get(6)).booleanValue();
    paramUri = new AttachmentRequest();
    message = paramMailEngine;
    attachment = localAttachment;
    rendition = localAttachmentRendition;
    saveToSd = bool;
    return paramUri;
  }
  
  static MailProvider getMailProvider()
  {
    return sThis;
  }
  
  private void notifyDatasetChanged(String paramString)
  {
    mContentResolver.notifyChange(Gmail.getBaseUri(paramString), null);
  }
  
  private long sendOrSaveDraft(MailEngine paramMailEngine, long paramLong, ContentValues paramContentValues)
  {
    paramContentValues = new ContentValues(paramContentValues);
    boolean bool = paramContentValues.getAsBoolean("save").booleanValue();
    paramContentValues.remove("save");
    long l = paramContentValues.getAsLong("refMessageId").longValue();
    paramContentValues.remove("refMessageId");
    return paramMailEngine.sendOrSaveDraft(paramLong, bool, l, paramContentValues);
  }
  
  public void bindAccount(String paramString)
  {
    try
    {
      MailEngine.clearMailEngines();
      mBoundAccount = null;
      mBoundEngine = getOrMakeMailEngine(paramString);
      mBoundAccount = paramString;
      return;
    }
    finally {}
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    int i = sUrlMatcher.match(paramUri);
    Object localObject = (String)paramUri.getPathSegments().get(0);
    String str = paramUri.getQueryParameter("suppressUINotifications");
    if ((str != null) && (Boolean.valueOf(str).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = getOrMakeMailEngine((String)localObject);
      switch (i)
      {
      default: 
        throw new IllegalArgumentException(paramUri.toString());
      }
    }
    ((MailEngine)localObject).setLabelOnConversationsBulk(paramArrayOfContentValues, bool);
    return 0;
    ((MailEngine)localObject).setLabelOnLocalMessageBulk(paramArrayOfContentValues, bool);
    return 0;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = sUrlMatcher.match(paramUri);
    String str = (String)paramUri.getPathSegments().get(0);
    MailEngine localMailEngine = getOrMakeMailEngine(str);
    MailIndexerService.onContentProviderAccess(str);
    long l1;
    switch (i)
    {
    case 5: 
    case 8: 
    case 9: 
    case 11: 
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 10: 
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = paramUri.getLastPathSegment();
      LogUtils.d("Gmail", "MailProvider.delete(): removing label %s from local message %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!Gmail.isLabelUserSettable(paramUri)) {
        throw new IllegalArgumentException("label is not user-settable: " + paramUri);
      }
      localMailEngine.setLabelOnLocalMessage(l1, paramUri, false);
      return 1;
    case 4: 
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = paramUri.getLastPathSegment();
      if ((!TextUtils.equals(paramString, "maxMessageId")) || (paramArrayOfString.length != 1)) {
        throw new IllegalArgumentException("selection must be 'maxMessageId', selection args must contain max message id");
      }
      long l2 = Long.parseLong(paramArrayOfString[0]);
      LogUtils.d("Gmail", "MailProvider.delete(): removing label %s from conversation %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!Gmail.isLabelUserSettable(paramUri)) {
        throw new IllegalArgumentException("label is not user-settable: " + paramUri);
      }
      localMailEngine.setLabelOnConversation(l1, l2, paramUri, false);
      return 1;
    case 7: 
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      l1 = Long.parseLong(paramUri.getLastPathSegment());
      LogUtils.d("Gmail", "MailProvider.delete(): removing local message %d", new Object[] { Long.valueOf(l1) });
      return localMailEngine.expungeLocalMessage(l1);
    case 6: 
      if (!TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("selection must be empty");
      }
      if (paramArrayOfString == null) {
        throw new IllegalArgumentException("selection Args must be specified");
      }
      paramUri = Lists.newArrayList();
      int j = paramArrayOfString.length;
      i = 0;
      while (i < j)
      {
        paramUri.add(Long.valueOf(Long.parseLong(paramArrayOfString[i])));
        i += 1;
      }
      return localMailEngine.expungeLocalMessages(paramUri);
    }
    paramUri = attachmentRequestForUri(localMailEngine, paramUri);
    if (paramUri == null) {
      return 0;
    }
    return localMailEngine.getAttachmentManager().cancelDownloadRequest(message.conversationId, message.messageId, attachment.partId, rendition, saveToSd);
  }
  
  MailEngine getOrMakeMailEngine(String paramString)
  {
    if (mBoundAccount != null)
    {
      if (mBoundAccount.equals(paramString)) {
        return mBoundEngine;
      }
      throw new IllegalArgumentException("Must request bound account");
    }
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    return MailEngine.getOrMakeMailEngine(getContext(), paramString);
  }
  
  public String getType(Uri paramUri)
  {
    switch (sUrlMatcher.match(paramUri))
    {
    }
    do
    {
      return null;
      return "com.google.android.gm/conversations";
      paramUri = attachmentRequestForUri(getOrMakeMailEngine((String)paramUri.getPathSegments().get(0)), paramUri);
    } while (paramUri == null);
    return attachment.contentType;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "MailProvider.insert: %s(%s)", new Object[] { LogUtils.contentUriToString(paramUri), paramContentValues });
    }
    int i = sUrlMatcher.match(paramUri);
    String str = (String)paramUri.getPathSegments().get(0);
    MailEngine localMailEngine = getOrMakeMailEngine(str);
    MailIndexerService.onContentProviderAccess(str);
    switch (i)
    {
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 9: 
      l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
      if (paramContentValues.size() != 1) {
        throw new IllegalArgumentException(paramContentValues.toString());
      }
      if (!paramContentValues.containsKey("canonicalName")) {
        throw new IllegalArgumentException("values must have 'canonicalName'");
      }
      paramUri = paramContentValues.getAsString("canonicalName");
      LogUtils.d("Gmail", "MailProvider.insert(): adding label %s to local message %d", new Object[] { paramUri, Long.valueOf(l1) });
      if (!Gmail.isLabelUserSettable(paramUri)) {
        throw new IllegalArgumentException("label is not user-settable: " + paramUri);
      }
      localMailEngine.setLabelOnLocalMessage(l1, paramUri, true);
      return Gmail.getMessageLabelUri(str, l1, paramUri);
    case 6: 
      l1 = sendOrSaveDraft(localMailEngine, 0L, paramContentValues);
      LogUtils.d("Gmail", "MailProvider.insert(): added local message %d", new Object[] { Long.valueOf(l1) });
      return Gmail.getMessageByIdUri(str, l1);
    }
    long l1 = Long.parseLong((String)paramUri.getPathSegments().get(2));
    if (!paramContentValues.containsKey("canonicalName")) {
      throw new IllegalArgumentException("values must have 'canonicalName'");
    }
    paramUri = paramContentValues.getAsString("canonicalName");
    if (!paramContentValues.containsKey("maxMessageId")) {
      throw new IllegalArgumentException("values must have 'maxMessageId'");
    }
    long l2 = paramContentValues.getAsLong("maxMessageId").longValue();
    if (paramContentValues.size() != 2) {
      throw new IllegalArgumentException(paramContentValues.toString());
    }
    LogUtils.d("Gmail", "MailProvider.insert(): adding label %s to conversation %d,maxMessageId %d", new Object[] { paramUri, Long.valueOf(l1), Long.valueOf(l2) });
    if (!Gmail.isLabelUserSettable(paramUri)) {
      throw new IllegalArgumentException("label is not user-settable: " + paramUri);
    }
    localMailEngine.setLabelOnConversation(l1, l2, paramUri, true);
    return Gmail.getConversationLabelUri(str, l1, paramUri);
  }
  
  public void onAccountsUpdated(Account[] paramArrayOfAccount)
  {
    Object localObject1;
    try
    {
      if (mBoundAccount != null) {
        return;
      }
      localObject1 = Sets.newHashSet();
      j = paramArrayOfAccount.length;
      i = 0;
      if (i < j)
      {
        localObject2 = paramArrayOfAccount[i];
        if (!type.equals("com.google")) {
          break label424;
        }
        ((Set)localObject1).add(name);
      }
    }
    finally {}
    paramArrayOfAccount = Sets.newHashSet();
    Object localObject2 = ((Set)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      paramArrayOfAccount.add(MailEngine.getDbName((String)localObject3));
      paramArrayOfAccount.add(MailEngine.getInternalDbName((String)localObject3));
    }
    int j = 0;
    localObject2 = getContext();
    Object localObject3 = ((Context)localObject2).databaseList();
    int n = localObject3.length;
    int i = 0;
    label154:
    Object localObject4;
    if (i < n)
    {
      localObject4 = localObject3[i];
      if ((!((String)localObject4).startsWith("mailstore")) || (!((String)localObject4).endsWith(".db"))) {
        break label441;
      }
    }
    label424:
    label431:
    label441:
    for (int m = 1;; m = 0)
    {
      int k = j;
      if (m != 0)
      {
        k = j;
        if (!paramArrayOfAccount.contains(localObject4))
        {
          LogUtils.i("Gmail", "Deleting mail db %s because there is no account for it", new Object[] { localObject4 });
          ((Context)localObject2).deleteDatabase((String)localObject4);
          k = j;
          if (MailEngine.getMailEngine(((String)localObject4).substring("mailstore".length() + 1, ((String)localObject4).lastIndexOf(".db"))) != null)
          {
            k = 1;
            break label431;
            if (j != 0)
            {
              Utils.cancelAllNotifications((Context)localObject2);
              LogUtils.i("Gmail", "Restarting because we deleted an account.", new Object[0]);
              System.exit(-1);
            }
            for (;;)
            {
              return;
              localObject2 = MailEngine.getMailEngines(getContext());
              paramArrayOfAccount = Sets.newHashSet();
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                paramArrayOfAccount.add(((MailEngine)((Iterator)localObject2).next()).getAccountName());
              }
              ((Set)localObject1).removeAll(paramArrayOfAccount);
              paramArrayOfAccount = ((Set)localObject1).iterator();
              while (paramArrayOfAccount.hasNext())
              {
                localObject1 = (String)paramArrayOfAccount.next();
                LogUtils.d("Gmail", "Creating mailengine for account %s", new Object[] { localObject1 });
                getOrMakeMailEngine((String)localObject1);
              }
            }
            i += 1;
            break;
          }
        }
      }
      i += 1;
      j = k;
      break label154;
    }
  }
  
  public boolean onCreate()
  {
    sThis = this;
    Object localObject = new HandlerThread("AccountManager Listener", 10);
    ((HandlerThread)localObject).start();
    mHandler = new Handler(((HandlerThread)localObject).getLooper());
    mContentResolver = getContext().getContentResolver();
    AccountManager.get(getContext()).addOnAccountsUpdatedListener(this, mHandler, true);
    localObject = new Intent("com.google.android.gm.intent.ACTION_PROVIDER_CREATED");
    getContext().sendBroadcast((Intent)localObject);
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "MailProvider.openFile: %s", new Object[] { LogUtils.contentUriToString(paramUri) });
    }
    int i = sUrlMatcher.match(paramUri);
    MailEngine localMailEngine = getOrMakeMailEngine((String)paramUri.getPathSegments().get(0));
    switch (i)
    {
    default: 
      throw new IllegalArgumentException("Unsupported uri in openFile: " + paramUri.toString());
    }
    paramUri = attachmentRequestForUri(localMailEngine, paramUri);
    if (paramUri == null) {
      throw new FileNotFoundException();
    }
    try
    {
      paramString = localMailEngine.getAttachmentManager().openAttachment(message.conversationId, message.messageId, attachment, rendition, saveToSd, paramString);
      return paramString;
    }
    catch (FileNotFoundException paramString) {}
    return localMailEngine.openLocalAttachment(attachment);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (LogUtils.isLoggable("Gmail", 3)) {
      LogUtils.d("Gmail", "MailProvider.query: %s(%s, %s)", new Object[] { LogUtils.contentUriToString(paramUri), paramString1, Arrays.toString(paramArrayOfString2) });
    }
    if (!TextUtils.isEmpty(paramString2)) {
      throw new IllegalArgumentException("sortOrder must be empty");
    }
    int i = sUrlMatcher.match(paramUri);
    String str = (String)paramUri.getPathSegments().get(0);
    if ((mBoundAccount != null) && (!str.equals(mBoundAccount))) {
      bindAccount(str);
    }
    MailEngine localMailEngine = getOrMakeMailEngine(str);
    int j = 1;
    MailIndexerService.onContentProviderAccess(str);
    switch (i)
    {
    case 2: 
    case 3: 
    case 4: 
    case 9: 
    case 10: 
    case 15: 
    case 16: 
    case 17: 
    default: 
      paramUri = null;
      i = j;
    }
    for (;;)
    {
      if ((paramUri != null) && (i != 0)) {
        paramUri.setNotificationUri(mContentResolver, Gmail.getBaseUri(str));
      }
      return paramUri;
      if (paramString1 != null)
      {
        paramString2 = paramString1;
        if (paramString1.length() != 0) {}
      }
      else
      {
        paramString2 = "label:^i";
      }
      paramUri = paramUri.getQueryParameter("limit");
      if (paramUri != null)
      {
        paramUri = Integer.valueOf(paramUri);
        label292:
        if ((Gmail.isRunningICSOrLater()) || (Binder.getCallingPid() == Process.myPid())) {
          break label336;
        }
      }
      label336:
      for (boolean bool = true;; bool = false)
      {
        paramUri = localMailEngine.getConversationCursorForQuery(paramArrayOfString1, paramString2, paramArrayOfString2, paramUri, bool);
        i = j;
        break;
        paramUri = null;
        break label292;
      }
      paramUri = localMailEngine.getMessageCursorForConversationId(paramArrayOfString1, Long.parseLong((String)paramUri.getPathSegments().get(2)), "1".equals(paramUri.getQueryParameter("useCache")), "1".equals(paramUri.getQueryParameter("useMatrixCursor")));
      i = j;
      continue;
      long l = Long.parseLong((String)paramUri.getPathSegments().get(2));
      paramUri = localMailEngine.getAttachmentManager().queryForConversation(l, paramArrayOfString1);
      paramUri.setNotificationUri(mContentResolver, Gmail.getAttachmentsForConversationUri(str, l));
      i = 0;
      continue;
      paramArrayOfString1 = localMailEngine.getMessageCursorForMessageId(paramArrayOfString1, Long.parseLong(paramString1));
      paramArrayOfString1.setNotificationUri(mContentResolver, paramUri);
      i = 0;
      paramUri = paramArrayOfString1;
      continue;
      paramUri = localMailEngine.getMessageCursorForLocalMessageId(paramArrayOfString1, ContentUris.parseId(paramUri));
      i = j;
      continue;
      paramUri = localMailEngine.getMessageCursorForMessageId(paramArrayOfString1, ContentUris.parseId(paramUri));
      i = j;
      continue;
      paramUri = attachmentRequestForUri(localMailEngine, paramUri);
      if (paramUri == null) {
        return null;
      }
      paramUri = localMailEngine.getAttachmentManager().queryAndStartDownloadingAttachment(message.conversationId, message.messageId, attachment, rendition, saveToSd, paramArrayOfString1);
      i = j;
      continue;
      paramString1 = attachmentRequestForUri(localMailEngine, paramUri);
      if (paramString1 == null) {
        return null;
      }
      if (paramArrayOfString1 != null)
      {
        paramUri = paramArrayOfString1;
        paramArrayOfString1 = new MatrixCursor(paramUri);
        paramArrayOfString2 = paramArrayOfString1.newRow();
        int k = paramUri.length;
        i = 0;
        label614:
        if (i >= k) {
          break label730;
        }
        paramString2 = paramUri[i];
        if (!"_display_name".equals(paramString2)) {
          break label680;
        }
        paramArrayOfString2.add(attachment.name);
      }
      for (;;)
      {
        i += 1;
        break label614;
        paramUri = new String[2];
        paramUri[0] = "_display_name";
        paramUri[1] = "_size";
        break;
        label680:
        if (("_size".equals(paramString2)) && (rendition == Gmail.AttachmentRendition.BEST)) {
          paramArrayOfString2.add(Integer.valueOf(attachment.size));
        } else {
          paramArrayOfString2.add(null);
        }
      }
      label730:
      paramUri = paramArrayOfString1;
      i = j;
      continue;
      if (Long.valueOf((String)paramUri.getPathSegments().get(2)).longValue() != 0L) {}
      for (bool = true;; bool = false)
      {
        paramString1 = paramUri.getQueryParameter("before");
        paramArrayOfString2 = paramUri.getQueryParameter("limit");
        paramUri = paramUri.getQueryParameters("canonicalName");
        paramUri = localMailEngine.getLabelQueryBuilder(paramArrayOfString1).filterCanonicalName(paramUri).showHidden(bool);
        if (paramString1 != null) {
          paramUri.setRecent(Long.parseLong(paramString1), Integer.parseInt(paramArrayOfString2));
        }
        paramUri = paramUri.query();
        i = j;
        break;
      }
      paramString1 = (String)paramUri.getPathSegments().get(2);
      if (Long.valueOf((String)paramUri.getPathSegments().get(3)).longValue() != 0L) {}
      for (bool = true;; bool = false)
      {
        paramUri = localMailEngine.getLabelQueryBuilder(paramArrayOfString1).filterCanonicalName(ImmutableList.of(paramString1)).showHidden(bool).query();
        i = j;
        break;
      }
      l = Long.valueOf((String)paramUri.getPathSegments().get(2)).longValue();
      paramUri = localMailEngine.getLabelQueryBuilder(paramArrayOfString1).labelId(l).query();
      i = j;
      continue;
      paramUri = localMailEngine.getPublicSettingsCursor(paramArrayOfString1);
      i = j;
      continue;
      paramUri = localMailEngine.getStatusCursor(paramArrayOfString1);
      paramUri.setNotificationUri(mContentResolver, Gmail.getStatusUri(str));
      i = 0;
    }
  }
  
  public void shutdown() {}
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("selection must be empty");
    }
    int i = 0;
    int j = sUrlMatcher.match(paramUri);
    paramString = (String)paramUri.getPathSegments().get(0);
    paramArrayOfString = getOrMakeMailEngine(paramString);
    MailIndexerService.onContentProviderAccess(paramString);
    switch (j)
    {
    default: 
      throw new IllegalArgumentException(paramUri.toString());
    case 7: 
      sendOrSaveDraft(paramArrayOfString, ContentUris.parseId(paramUri), paramContentValues);
      i = 1;
    case 14: 
      do
      {
        return i;
      } while (!paramArrayOfString.setPublicSettings(paramContentValues));
      notifyDatasetChanged(paramString);
      return 1;
    }
    return paramArrayOfString.updateLabelsLastTouched(paramContentValues);
  }
  
  static class AttachmentRequest
  {
    public Gmail.Attachment attachment;
    public MailSync.Message message;
    public Gmail.AttachmentRendition rendition;
    public boolean saveToSd;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */