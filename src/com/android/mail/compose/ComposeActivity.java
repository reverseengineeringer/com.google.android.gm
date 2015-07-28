package com.android.mail.compose;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.android.common.Rfc822Validator;
import com.android.ex.chips.RecipientEditTextView;
import com.android.mail.providers.Address;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.Message;
import com.android.mail.providers.MessageModification;
import com.android.mail.providers.ReplyFromAccount;
import com.android.mail.providers.Settings;
import com.android.mail.providers.UIProvider;
import com.android.mail.ui.MailActivity;
import com.android.mail.ui.WaitFragment;
import com.android.mail.utils.AccountUtils;
import com.android.mail.utils.AttachmentUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class ComposeActivity
  extends Activity
  implements View.OnClickListener, ActionBar.OnNavigationListener, QuotedTextView.RespondInlineListener, DialogInterface.OnClickListener, TextWatcher, AttachmentsView.AttachmentAddedOrDeletedListener, FromAddressSpinner.OnAccountChangedListener, LoaderManager.LoaderCallbacks<Cursor>, TextView.OnEditorActionListener
{
  static final String[] ALL_EXTRAS = { "subject", "body", "to", "cc", "bcc" };
  private static final String EXTRA_FOCUS_SELECTION_END = null;
  private static final String LOG_TAG;
  private static ConcurrentHashMap<Integer, Long> sRequestMessageIdMap;
  private static SendOrSaveCallback sTestSendOrSaveCallback = null;
  private com.android.mail.providers.Account mAccount;
  private com.android.mail.providers.Account[] mAccounts;
  public ArrayList<SendOrSaveTask> mActiveTasks = Lists.newArrayList();
  private boolean mAddingAttachment;
  private boolean mAttachmentsChanged;
  private AttachmentsView mAttachmentsView;
  private RecipientEditTextView mBcc;
  private RecipientTextWatcher mBccListener;
  private EditText mBodyView;
  private Settings mCachedSettings;
  private RecipientEditTextView mCc;
  private Button mCcBccButton;
  private CcBccView mCcBccView;
  private RecipientTextWatcher mCcListener;
  private int mComposeMode = -1;
  private ComposeModeAdapter mComposeModeAdapter;
  private Message mDraft;
  private long mDraftId = -1L;
  private Object mDraftLock = new Object();
  private boolean mForward;
  protected FromAddressSpinner mFromSpinner;
  private View mFromSpinnerWrapper;
  private View mFromStatic;
  private TextView mFromStaticText;
  private boolean mLaunchedFromEmail = false;
  private View mPhotoAttachmentsButton;
  private QuotedTextView mQuotedTextView;
  private String mRecipient;
  private AlertDialog mRecipientErrorDialog;
  protected Message mRefMessage;
  private Uri mRefMessageUri;
  private ReplyFromAccount mReplyFromAccount;
  private boolean mReplyFromChanged;
  private int mRequestId;
  private MenuItem mSave;
  private Bundle mSavedInstanceState;
  private MenuItem mSend;
  private AlertDialog mSendConfirmDialog;
  private Handler mSendSaveTaskHandler = null;
  private String mSignature;
  private TextView mSubject;
  private boolean mTextChanged;
  private RecipientEditTextView mTo;
  private RecipientTextWatcher mToListener;
  private Rfc822Validator mValidator;
  private View mVideoAttachmentsButton;
  
  static
  {
    sRequestMessageIdMap = null;
    LOG_TAG = LogTag.getLogTag();
  }
  
  private void addAddressToList(String paramString, RecipientEditTextView paramRecipientEditTextView)
  {
    if ((paramString == null) || (paramRecipientEditTextView == null)) {}
    for (;;)
    {
      return;
      paramString = Rfc822Tokenizer.tokenize(paramString);
      int i = 0;
      while (i < paramString.length)
      {
        paramRecipientEditTextView.append(paramString[i] + ", ");
        i += 1;
      }
    }
  }
  
  private void addBccAddresses(Collection<String> paramCollection)
  {
    addAddressesToList(paramCollection, mBcc);
  }
  
  private void addCcAddresses(Collection<String> paramCollection1, Collection<String> paramCollection2)
  {
    List localList = tokenizeAddressList(paramCollection1);
    if (paramCollection2 != null) {}
    for (paramCollection1 = tokenizeAddressList(paramCollection2);; paramCollection1 = null)
    {
      addCcAddressesToList(localList, paramCollection1, mCc);
      return;
    }
  }
  
  private void addRecipients(String paramString, Set<String> paramSet, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!recipientMatchesThisAccount(paramString, Address.getEmailAddress(str).getAddress())) {
        paramSet.add(str.replace("\"\"", ""));
      }
      i += 1;
    }
  }
  
  private void addToAddresses(Collection<String> paramCollection)
  {
    addAddressesToList(paramCollection, mTo);
  }
  
  private void appendSignature()
  {
    if (mCachedSettings != null) {}
    for (String str = mCachedSettings.signature;; str = null)
    {
      boolean bool = mBodyView.hasFocus();
      if (!TextUtils.equals(str, mSignature))
      {
        mSignature = str;
        if ((!TextUtils.isEmpty(mSignature)) && (getSignatureStartPosition(mSignature, mBodyView.getText().toString()) < 0))
        {
          mBodyView.removeTextChangedListener(this);
          mBodyView.append(convertToPrintableSignature(mSignature));
          mBodyView.addTextChangedListener(this);
        }
        if (bool) {
          focusBody();
        }
      }
      return;
    }
  }
  
  private void checkValidAccounts()
  {
    mAccounts = AccountUtils.getAccounts(this);
    if ((mAccounts == null) || (mAccounts.length == 0))
    {
      localObject = MailAppProvider.getNoAccountIntent(this);
      if (localObject != null) {
        startActivityForResult((Intent)localObject, 2);
      }
      return;
    }
    int k = 0;
    Object localObject = mAccounts;
    int m = localObject.length;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (localObject[i].isAccountReady()) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          break;
        }
        mAccounts = null;
        getLoaderManager().initLoader(1, null, this);
        return;
      }
      i += 1;
    }
    finishCreate();
  }
  
  private void clearChangeListeners()
  {
    mSubject.removeTextChangedListener(this);
    mBodyView.removeTextChangedListener(this);
    mTo.removeTextChangedListener(mToListener);
    mCc.removeTextChangedListener(mCcListener);
    mBcc.removeTextChangedListener(mBccListener);
    mFromSpinner.setOnAccountChangedListener(null);
    mAttachmentsView.setAttachmentChangesListener(null);
  }
  
  private void clearImeText()
  {
    mBodyView.clearComposingText();
    BaseInputConnection.removeComposingSpans(mBodyView.getEditableText());
    mSubject.clearComposingText();
    BaseInputConnection.removeComposingSpans(mSubject.getEditableText());
  }
  
  public static void compose(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    launch(paramContext, paramAccount, null, -1);
  }
  
  private HashSet<String> convertToHashSet(List<Rfc822Token[]> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Rfc822Token[] arrayOfRfc822Token = (Rfc822Token[])paramList.next();
      int i = 0;
      while (i < arrayOfRfc822Token.length)
      {
        localHashSet.add(arrayOfRfc822Token[i].getAddress());
        i += 1;
      }
    }
    return localHashSet;
  }
  
  private String convertToPrintableSignature(String paramString)
  {
    String str2 = getResources().getString(2131492920);
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    return String.format(str2, new Object[] { str1 });
  }
  
  private Message createMessage(ReplyFromAccount paramReplyFromAccount, int paramInt)
  {
    boolean bool2 = true;
    Message localMessage = new Message();
    id = -1L;
    serverId = null;
    uri = null;
    conversationUri = null;
    subject = mSubject.getText().toString();
    snippet = null;
    to = formatSenders(mTo.getText().toString());
    cc = formatSenders(mCc.getText().toString());
    bcc = formatSenders(mBcc.getText().toString());
    replyTo = null;
    dateReceivedMs = 0L;
    bodyHtml = Html.toHtml(mBodyView.getText());
    bodyText = mBodyView.getText().toString();
    embedsExternalResources = false;
    Object localObject;
    boolean bool1;
    if (mRefMessage != null)
    {
      localObject = mRefMessage.uri.toString();
      refMessageId = ((String)localObject);
      if (mQuotedTextView.getQuotedTextIfIncluded() == null) {
        break label348;
      }
      bool1 = true;
      label213:
      appendRefMessageContent = bool1;
      localObject = mAttachmentsView.getAttachments();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label354;
      }
      bool1 = bool2;
      label246:
      hasAttachments = bool1;
      attachmentListUri = null;
      messageFlags = 0L;
      saveUri = null;
      sendUri = null;
      alwaysShowImages = false;
      attachmentsJson = Attachment.toJSONArray((Collection)localObject);
      localObject = mQuotedTextView.getQuotedText();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label360;
      }
    }
    label348:
    label354:
    label360:
    for (int i = QuotedTextView.getQuotedTextOffset(localObject.toString());; i = -1)
    {
      quotedTextOffset = i;
      accountUri = null;
      updateMessage(localMessage, paramReplyFromAccount, paramInt);
      return localMessage;
      localObject = null;
      break;
      bool1 = false;
      break label213;
      bool1 = false;
      break label246;
    }
  }
  
  private void discardChanges()
  {
    mTextChanged = false;
    mAttachmentsChanged = false;
    mReplyFromChanged = false;
  }
  
  private void doAttach(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.GET_CONTENT");
    localIntent.addCategory("android.intent.category.OPENABLE");
    localIntent.addFlags(524288);
    localIntent.setType(paramString);
    mAddingAttachment = true;
    startActivityForResult(Intent.createChooser(localIntent, getText(2131492908)), 1);
  }
  
  private void doDiscard()
  {
    new AlertDialog.Builder(this).setMessage(2131493021).setPositiveButton(2131493074, this).setNegativeButton(2131493075, null).create().show();
  }
  
  private void doDiscardWithoutConfirmation(boolean paramBoolean)
  {
    synchronized (mDraftLock)
    {
      if (mDraftId != -1L)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("_id", Long.valueOf(mDraftId));
        if (!mAccount.expungeMessageUri.equals(Uri.EMPTY))
        {
          getContentResolver().update(mAccount.expungeMessageUri, localContentValues, null, null);
          mDraftId = -1L;
        }
      }
      else
      {
        if (paramBoolean) {
          Toast.makeText(this, 2131492919, 0).show();
        }
        discardChanges();
        finish();
        return;
      }
      getContentResolver().delete(mDraft.uri, null, null);
    }
  }
  
  private void doSave(boolean paramBoolean)
  {
    clearImeText();
    sendOrSaveWithSanityChecks(true, paramBoolean, false, false);
  }
  
  private void doSend()
  {
    clearImeText();
    sendOrSaveWithSanityChecks(false, true, false, false);
  }
  
  public static void editDraft(Context paramContext, com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    launch(paramContext, paramAccount, paramMessage, 3);
  }
  
  private void findViews()
  {
    findViewById(2131755071).setVisibility(0);
    mCcBccButton = ((Button)findViewById(2131755080));
    if (mCcBccButton != null) {
      mCcBccButton.setOnClickListener(this);
    }
    mCcBccView = ((CcBccView)findViewById(2131755081));
    mAttachmentsView = ((AttachmentsView)findViewById(2131755073));
    mPhotoAttachmentsButton = findViewById(2131755084);
    if (mPhotoAttachmentsButton != null) {
      mPhotoAttachmentsButton.setOnClickListener(this);
    }
    mVideoAttachmentsButton = findViewById(2131755293);
    if (mVideoAttachmentsButton != null) {
      mVideoAttachmentsButton.setOnClickListener(this);
    }
    mTo = ((RecipientEditTextView)findViewById(2131755079));
    mCc = ((RecipientEditTextView)findViewById(2131755062));
    mBcc = ((RecipientEditTextView)findViewById(2131755065));
    mSubject = ((TextView)findViewById(2131755083));
    mSubject.setOnEditorActionListener(this);
    mQuotedTextView = ((QuotedTextView)findViewById(2131755074));
    mQuotedTextView.setRespondInlineListener(this);
    mBodyView = ((EditText)findViewById(2131755093));
    mFromStatic = findViewById(2131755096);
    mFromStaticText = ((TextView)findViewById(2131755097));
    mFromSpinnerWrapper = findViewById(2131755094);
    mFromSpinner = ((FromAddressSpinner)findViewById(2131755095));
  }
  
  private void finishCreate()
  {
    Bundle localBundle = mSavedInstanceState;
    findViews();
    Intent localIntent = getIntent();
    boolean bool1 = false;
    int i;
    com.android.mail.providers.Account localAccount;
    Message localMessage;
    ArrayList localArrayList;
    if (hadSavedInstanceStateMessage(localBundle))
    {
      i = localBundle.getInt("action", -1);
      localAccount = (com.android.mail.providers.Account)localBundle.getParcelable("account");
      localMessage = (Message)localBundle.getParcelable("extraMessage");
      localArrayList = localBundle.getParcelableArrayList("attachmentPreviews");
      mRefMessage = ((Message)localBundle.getParcelable("in-reference-to-message"));
    }
    for (;;)
    {
      mAttachmentsView.setAttachmentPreviews(localArrayList);
      setAccount(localAccount);
      if (mAccount != null) {
        break;
      }
      return;
      localAccount = obtainAccount(localIntent);
      i = localIntent.getIntExtra("action", -1);
      localMessage = (Message)localIntent.getParcelableExtra("original-draft-message");
      localArrayList = localIntent.getParcelableArrayListExtra("attachmentPreviews");
      mRefMessage = ((Message)localIntent.getParcelableExtra("in-reference-to-message"));
      mRefMessageUri = ((Uri)localIntent.getParcelableExtra("in-reference-to-message-uri"));
    }
    if (localIntent.getBooleanExtra("fromemail", false)) {}
    for (mLaunchedFromEmail = true; mRefMessageUri != null; mLaunchedFromEmail = TextUtils.equals(localIntent.getData().getScheme(), mAccount.composeIntentUri.getScheme()))
    {
      label202:
      getLoaderManager().initLoader(0, null, this);
      return;
      if ((!"android.intent.action.SEND".equals(localIntent.getAction())) || (localIntent.getData() == null)) {
        break label202;
      }
    }
    int j;
    if ((localMessage != null) && (i != 3))
    {
      initFromDraftMessage(localMessage);
      initQuotedTextFromRefMessage(mRefMessage, i);
      showCcBcc(localBundle);
      bool1 = appendRefMessageContent;
      j = i;
    }
    for (;;)
    {
      finishSetup(j, localIntent, localBundle, bool1);
      return;
      if (i == 3)
      {
        initFromDraftMessage(localMessage);
        label345:
        boolean bool2;
        if (!TextUtils.isEmpty(bcc))
        {
          bool1 = true;
          if ((!bool1) && (TextUtils.isEmpty(cc))) {
            break label431;
          }
          bool2 = true;
          label363:
          mCcBccView.show(false, bool2, bool1);
          switch (draftType)
          {
          default: 
            i = -1;
          }
        }
        for (;;)
        {
          initQuotedTextFromRefMessage(mRefMessage, i);
          bool1 = appendRefMessageContent;
          j = i;
          break;
          bool1 = false;
          break label345;
          label431:
          bool2 = false;
          break label363;
          i = 0;
          continue;
          i = 1;
          continue;
          i = 2;
        }
      }
      if ((i == 0) || (i == 1) || (i == 2))
      {
        j = i;
        if (mRefMessage != null)
        {
          initFromRefMessage(i, mAccount.name);
          bool1 = true;
          j = i;
        }
      }
      else
      {
        initFromExtras(localIntent);
        j = i;
      }
    }
  }
  
  private void finishSetup(int paramInt, Intent paramIntent, Bundle paramBundle, boolean paramBoolean)
  {
    setFocus(paramInt);
    if (paramInt == -1) {
      mQuotedTextView.setVisibility(8);
    }
    initRecipients();
    if (!hadSavedInstanceStateMessage(paramBundle)) {
      initAttachmentsFromIntent(paramIntent);
    }
    initActionBar(paramInt);
    if (paramBundle != null) {}
    for (;;)
    {
      initFromSpinner(paramBundle, paramInt);
      initChangeListeners();
      updateHideOrShowCcBcc();
      updateHideOrShowQuotedText(paramBoolean);
      return;
      paramBundle = paramIntent.getExtras();
    }
  }
  
  private String formatSenders(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.charAt(paramString.length() - 1) == ',') {
        str = paramString.substring(0, paramString.length() - 1);
      }
    }
    return str;
  }
  
  public static void forward(Context paramContext, com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    launch(paramContext, paramAccount, paramMessage, 2);
  }
  
  private ReplyFromAccount getDefaultReplyFromAccount(com.android.mail.providers.Account paramAccount)
  {
    Iterator localIterator = paramAccount.getReplyFroms().iterator();
    while (localIterator.hasNext())
    {
      ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)localIterator.next();
      if (isDefault) {
        return localReplyFromAccount;
      }
    }
    return new ReplyFromAccount(paramAccount, uri, name, name, name, true, false);
  }
  
  private static int getDraftType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case -1: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 3;
    }
    return 4;
  }
  
  private int getMode()
  {
    int j = -1;
    ActionBar localActionBar = getActionBar();
    int i = j;
    if (localActionBar != null)
    {
      i = j;
      if (localActionBar.getNavigationMode() == 1) {
        i = localActionBar.getSelectedNavigationIndex();
      }
    }
    return i;
  }
  
  private ReplyFromAccount getReplyFromAccountForReply(com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    if (accountUri != null)
    {
      paramAccount = mFromSpinner.getReplyFromAccounts().iterator();
      while (paramAccount.hasNext())
      {
        ReplyFromAccount localReplyFromAccount = (ReplyFromAccount)paramAccount.next();
        if (account.uri.equals(accountUri)) {
          return localReplyFromAccount;
        }
      }
      return null;
    }
    return getReplyFromAccount(paramAccount, paramMessage);
  }
  
  private ReplyFromAccount getReplyFromAccountFromDraft(com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    String str = from;
    paramMessage = null;
    Object localObject = mFromSpinner.getReplyFromAccounts();
    if (TextUtils.equals(name, str))
    {
      paramAccount = new ReplyFromAccount(mAccount, mAccount.uri, mAccount.name, mAccount.name, mAccount.name, true, false);
      return paramAccount;
    }
    localObject = ((List)localObject).iterator();
    do
    {
      paramAccount = paramMessage;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      paramAccount = (ReplyFromAccount)((Iterator)localObject).next();
    } while (!TextUtils.equals(name, str));
    return paramAccount;
  }
  
  private WaitFragment getWaitFragment()
  {
    return (WaitFragment)getFragmentManager().findFragmentByTag("wait-fragment");
  }
  
  private boolean hadSavedInstanceStateMessage(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("extraMessage"));
  }
  
  private void initActionBar(int paramInt)
  {
    mComposeMode = paramInt;
    ActionBar localActionBar = getActionBar();
    if (localActionBar == null) {
      return;
    }
    if (paramInt == -1)
    {
      localActionBar.setNavigationMode(0);
      localActionBar.setTitle(2131492901);
    }
    for (;;)
    {
      localActionBar.setDisplayOptions(6, 6);
      localActionBar.setHomeButtonEnabled(true);
      return;
      localActionBar.setTitle(null);
      if (mComposeModeAdapter == null) {
        mComposeModeAdapter = new ComposeModeAdapter(this);
      }
      localActionBar.setNavigationMode(1);
      localActionBar.setListNavigationCallbacks(mComposeModeAdapter, this);
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        localActionBar.setSelectedNavigationItem(0);
        break;
      case 1: 
        localActionBar.setSelectedNavigationItem(1);
        break;
      case 2: 
        localActionBar.setSelectedNavigationItem(2);
      }
    }
  }
  
  private void initAttachmentsFromIntent(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getExtras();
    if (localObject1 == null) {
      localObject1 = Bundle.EMPTY;
    }
    for (;;)
    {
      paramIntent = paramIntent.getAction();
      long l1;
      long l2;
      if (!mAttachmentsChanged)
      {
        l1 = 0L;
        Object localObject2;
        if (((Bundle)localObject1).containsKey("attachments"))
        {
          localObject2 = (String[])((Bundle)localObject1).getSerializable("attachments");
          int j = localObject2.length;
          int i = 0;
          l1 = 0L;
          for (;;)
          {
            if (i >= j) {
              break label147;
            }
            Uri localUri = Uri.parse(localObject2[i]);
            l2 = 0L;
            try
            {
              long l3 = mAttachmentsView.addAttachment(mAccount, localUri);
              l2 = l3;
            }
            catch (AttachmentsView.AttachmentFailureException localAttachmentFailureException2)
            {
              for (;;)
              {
                LogUtils.e(LOG_TAG, localAttachmentFailureException2, "Error adding attachment", new Object[0]);
                showAttachmentTooBigToast(localAttachmentFailureException2.getErrorRes());
              }
            }
            l1 += l2;
            i += 1;
          }
        }
        label147:
        l2 = l1;
        if (((Bundle)localObject1).containsKey("android.intent.extra.STREAM"))
        {
          if (!"android.intent.action.SEND_MULTIPLE".equals(paramIntent)) {
            break label323;
          }
          localObject1 = ((Bundle)localObject1).getParcelableArrayList("android.intent.extra.STREAM");
          paramIntent = new ArrayList();
          localObject1 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Parcelable)((Iterator)localObject1).next();
            try
            {
              paramIntent.add(mAttachmentsView.generateLocalAttachment((Uri)localObject2));
            }
            catch (AttachmentsView.AttachmentFailureException localAttachmentFailureException1)
            {
              LogUtils.e(LOG_TAG, localAttachmentFailureException1, "Error adding attachment", new Object[0]);
              showErrorToast(getString(2131492912, new Object[] { AttachmentUtils.convertToHumanReadableSize(getApplicationContext(), mAccount.settings.getMaxAttachmentSize()) }));
            }
          }
          l2 = l1 + addAttachments(paramIntent);
        }
      }
      for (;;)
      {
        if (l2 > 0L)
        {
          mAttachmentsChanged = true;
          updateSaveUi();
        }
        return;
        label323:
        paramIntent = (Uri)((Bundle)localObject1).getParcelable("android.intent.extra.STREAM");
        try
        {
          l2 = mAttachmentsView.addAttachment(mAccount, paramIntent);
          l2 = l1 + l2;
        }
        catch (AttachmentsView.AttachmentFailureException paramIntent)
        {
          for (;;)
          {
            LogUtils.e(LOG_TAG, paramIntent, "Error adding attachment", new Object[0]);
            showAttachmentTooBigToast(paramIntent.getErrorRes());
            l2 = 0L;
          }
        }
      }
    }
  }
  
  private void initChangeListeners()
  {
    mSubject.addTextChangedListener(this);
    mBodyView.addTextChangedListener(this);
    if (mToListener == null) {
      mToListener = new RecipientTextWatcher(mTo, this);
    }
    mTo.addTextChangedListener(mToListener);
    if (mCcListener == null) {
      mCcListener = new RecipientTextWatcher(mCc, this);
    }
    mCc.addTextChangedListener(mCcListener);
    if (mBccListener == null) {
      mBccListener = new RecipientTextWatcher(mBcc, this);
    }
    mBcc.addTextChangedListener(mBccListener);
    mFromSpinner.setOnAccountChangedListener(this);
    mAttachmentsView.setAttachmentChangesListener(this);
  }
  
  private void initFromDraftMessage(Message paramMessage)
  {
    Object localObject3 = null;
    boolean bool = true;
    LogUtils.d(LOG_TAG, "Intializing draft from previous draft message: %s", new Object[] { paramMessage });
    mDraft = paramMessage;
    mDraftId = id;
    mSubject.setText(subject);
    if (draftType == 4) {}
    Object localObject1;
    for (;;)
    {
      mForward = bool;
      localObject1 = Arrays.asList(paramMessage.getToAddresses());
      addToAddresses((Collection)localObject1);
      addCcAddresses(Arrays.asList(paramMessage.getCcAddresses()), (Collection)localObject1);
      addBccAddresses(Arrays.asList(paramMessage.getBccAddresses()));
      if (!hasAttachments) {
        break;
      }
      localObject1 = paramMessage.getAttachments().iterator();
      while (((Iterator)localObject1).hasNext()) {
        addAttachmentAndUpdateView((Attachment)((Iterator)localObject1).next());
      }
      bool = false;
    }
    int i;
    if (appendRefMessageContent)
    {
      i = quotedTextOffset;
      if (TextUtils.isEmpty(bodyHtml)) {
        break label269;
      }
      if (i <= -1) {
        break label255;
      }
      i = QuotedTextView.findQuotedTextIndex(bodyHtml);
      if (i <= -1) {
        break label362;
      }
      localObject1 = Html.fromHtml(bodyHtml.substring(0, i));
      paramMessage = bodyHtml.subSequence(i, bodyHtml.length());
    }
    for (;;)
    {
      mBodyView.setText((CharSequence)localObject1);
      if ((i > -1) && (paramMessage != null)) {
        mQuotedTextView.setQuotedTextFromDraft(paramMessage, mForward);
      }
      return;
      i = -1;
      break;
      label255:
      localObject1 = Html.fromHtml(bodyHtml);
      paramMessage = null;
      continue;
      label269:
      String str = bodyText;
      if (!TextUtils.isEmpty(str)) {
        if (i > -1) {
          localObject1 = bodyText.substring(0, i);
        }
      }
      for (;;)
      {
        Object localObject2 = localObject3;
        if (i > -1)
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(str)) {
            localObject2 = bodyText.substring(i);
          }
        }
        mBodyView.setText((CharSequence)localObject1);
        paramMessage = (Message)localObject2;
        break;
        localObject1 = bodyText;
        continue;
        localObject1 = "";
      }
      label362:
      localObject1 = "";
      paramMessage = null;
    }
  }
  
  private void initFromRefMessage(int paramInt, String paramString)
  {
    setFieldsFromRefMessage(paramInt, paramString);
    if ((mRefMessage != null) && (!TextUtils.isEmpty(mCc.getText())) && (paramInt == 1)) {
      mCcBccView.show(false, true, false);
    }
    updateHideOrShowCcBcc();
  }
  
  private void initFromSpinner(Bundle paramBundle, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3)
    {
      i = paramInt;
      if (mDraft.draftType == 1) {
        i = -1;
      }
    }
    mFromSpinner.asyncInitFromSpinner(i, mAccount, mAccounts);
    if (paramBundle != null)
    {
      if (paramBundle.containsKey("replyFromAccount")) {
        mReplyFromAccount = ReplyFromAccount.deserialize(mAccount, paramBundle.getString("replyFromAccount"));
      }
    }
    else if (mReplyFromAccount == null)
    {
      if (mDraft == null) {
        break label206;
      }
      mReplyFromAccount = getReplyFromAccountFromDraft(mAccount, mDraft);
    }
    for (;;)
    {
      if (mReplyFromAccount == null) {
        mReplyFromAccount = getDefaultReplyFromAccount(mAccount);
      }
      mFromSpinner.setCurrentAccount(mReplyFromAccount);
      if (mFromSpinner.getCount() <= 1) {
        break label232;
      }
      mFromStatic.setVisibility(8);
      mFromStaticText.setText(mAccount.name);
      mFromSpinnerWrapper.setVisibility(0);
      return;
      if (!paramBundle.containsKey("fromAccountString")) {
        break;
      }
      paramBundle = paramBundle.getString("fromAccountString");
      mReplyFromAccount = mFromSpinner.getMatchingReplyFromAccount(paramBundle);
      break;
      label206:
      if (mRefMessage != null) {
        mReplyFromAccount = getReplyFromAccountForReply(mAccount, mRefMessage);
      }
    }
    label232:
    mFromStatic.setVisibility(0);
    mFromStaticText.setText(mAccount.name);
    mFromSpinnerWrapper.setVisibility(8);
  }
  
  private void initQuotedTextFromRefMessage(Message paramMessage, int paramInt)
  {
    boolean bool = true;
    QuotedTextView localQuotedTextView;
    if ((mRefMessage != null) && ((paramInt == 0) || (paramInt == 1) || (paramInt == 2)))
    {
      localQuotedTextView = mQuotedTextView;
      if (paramInt == 2) {
        break label43;
      }
    }
    for (;;)
    {
      localQuotedTextView.setQuotedText(paramInt, paramMessage, bool);
      return;
      label43:
      bool = false;
    }
  }
  
  private void initRecipients()
  {
    setupRecipients(mTo);
    setupRecipients(mCc);
    setupRecipients(mBcc);
  }
  
  private static void launch(Context paramContext, com.android.mail.providers.Account paramAccount, Message paramMessage, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ComposeActivity.class);
    localIntent.putExtra("fromemail", true);
    localIntent.putExtra("action", paramInt);
    localIntent.putExtra("account", paramAccount);
    if (paramInt == 3) {
      localIntent.putExtra("original-draft-message", paramMessage);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("in-reference-to-message", paramMessage);
    }
  }
  
  private com.android.mail.providers.Account obtainAccount(Intent paramIntent)
  {
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = localObject5;
    Object localObject2 = localObject4;
    if (paramIntent != null)
    {
      localObject1 = localObject5;
      localObject2 = localObject4;
      if (paramIntent.getExtras() != null)
      {
        localObject2 = paramIntent.getExtras().get("account");
        if ((localObject2 instanceof com.android.mail.providers.Account)) {
          return (com.android.mail.providers.Account)localObject2;
        }
        localObject1 = localObject3;
        if ((localObject2 instanceof String))
        {
          localObject2 = com.android.mail.providers.Account.newinstance((String)localObject2);
          localObject1 = localObject2;
          if (localObject2 != null) {
            return (com.android.mail.providers.Account)localObject2;
          }
        }
        localObject2 = paramIntent.getStringExtra("selectedAccount");
      }
    }
    if (localObject1 == null)
    {
      paramIntent = MailAppProvider.getInstance().getLastSentFromAccount();
      if (TextUtils.isEmpty(paramIntent)) {}
    }
    for (localObject3 = Uri.parse(paramIntent);; localObject3 = localObject2)
    {
      localObject2 = localObject1;
      if (mAccounts != null)
      {
        localObject2 = localObject1;
        if (mAccounts.length > 0)
        {
          int j;
          int i;
          if (((localObject3 instanceof String)) && (!TextUtils.isEmpty((String)localObject3)))
          {
            localObject2 = mAccounts;
            j = localObject2.length;
            i = 0;
            for (;;)
            {
              paramIntent = (Intent)localObject1;
              if (i >= j) {
                break;
              }
              paramIntent = localObject2[i];
              if (name.equals(localObject3)) {
                localObject1 = paramIntent;
              }
              i += 1;
            }
          }
          paramIntent = (Intent)localObject1;
          if ((localObject3 instanceof Uri))
          {
            localObject2 = mAccounts;
            j = localObject2.length;
            i = 0;
            for (;;)
            {
              paramIntent = (Intent)localObject1;
              if (i >= j) {
                break;
              }
              paramIntent = localObject2[i];
              if (uri.equals(localObject3)) {
                localObject1 = paramIntent;
              }
              i += 1;
            }
          }
          localObject2 = paramIntent;
          if (paramIntent == null) {
            localObject2 = mAccounts[0];
          }
        }
      }
      return (com.android.mail.providers.Account)localObject2;
    }
  }
  
  private void onAppUpPressed()
  {
    if (mLaunchedFromEmail)
    {
      onBackPressed();
      return;
    }
    Intent localIntent = Utils.createViewInboxIntent(mAccount);
    localIntent.setFlags(268484608);
    startActivity(localIntent);
    finish();
  }
  
  public static void registerTestSendOrSaveCallback(SendOrSaveCallback paramSendOrSaveCallback)
  {
    if ((sTestSendOrSaveCallback != null) && (paramSendOrSaveCallback != null)) {
      throw new IllegalStateException("Attempting to register more than one test callback");
    }
    sTestSendOrSaveCallback = paramSendOrSaveCallback;
  }
  
  private int replaceFragment(Fragment paramFragment, int paramInt, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.addToBackStack(null);
    localFragmentTransaction.setTransition(paramInt);
    localFragmentTransaction.replace(2131755076, paramFragment, paramString);
    return localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public static void reply(Context paramContext, com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    launch(paramContext, paramAccount, paramMessage, 0);
  }
  
  public static void replyAll(Context paramContext, com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    launch(paramContext, paramAccount, paramMessage, 1);
  }
  
  private void saveIfNeeded()
  {
    if (mAccount == null) {}
    while (!shouldSave()) {
      return;
    }
    if (!mAddingAttachment) {}
    for (boolean bool = true;; bool = false)
    {
      doSave(bool);
      return;
    }
  }
  
  private void saveRequestMap() {}
  
  private void sendOrSave(Spanned paramSpanned, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (ActivityManager.isUserAMonkey()) {
      return;
    }
    label12:
    SendOrSaveCallback local3;
    ReplyFromAccount localReplyFromAccount;
    Object localObject;
    if (paramBoolean3)
    {
      local3 = new SendOrSaveCallback()
      {
        public Message getMessage()
        {
          synchronized (mDraftLock)
          {
            Message localMessage = mDraft;
            return localMessage;
          }
        }
        
        public void initializeSendOrSave(ComposeActivity.SendOrSaveTask paramAnonymousSendOrSaveTask)
        {
          synchronized (mActiveTasks)
          {
            if (mActiveTasks.size() == 0) {
              startService(new Intent(ComposeActivity.this, EmptyService.class));
            }
            mActiveTasks.add(paramAnonymousSendOrSaveTask);
            if (ComposeActivity.sTestSendOrSaveCallback != null) {
              ComposeActivity.sTestSendOrSaveCallback.initializeSendOrSave(paramAnonymousSendOrSaveTask);
            }
            return;
          }
        }
        
        public void notifyMessageIdAllocated(ComposeActivity.SendOrSaveMessage paramAnonymousSendOrSaveMessage, Message paramAnonymousMessage)
        {
          synchronized (mDraftLock)
          {
            ComposeActivity.access$602(ComposeActivity.this, id);
            ComposeActivity.access$702(ComposeActivity.this, paramAnonymousMessage);
            if (ComposeActivity.sRequestMessageIdMap != null) {
              ComposeActivity.sRequestMessageIdMap.put(Integer.valueOf(paramAnonymousSendOrSaveMessage.requestId()), Long.valueOf(mDraftId));
            }
            ComposeActivity.this.saveRequestMap();
            if (ComposeActivity.sTestSendOrSaveCallback != null) {
              ComposeActivity.sTestSendOrSaveCallback.notifyMessageIdAllocated(paramAnonymousSendOrSaveMessage, paramAnonymousMessage);
            }
            return;
          }
        }
        
        public void sendOrSaveFinished(ComposeActivity.SendOrSaveTask paramAnonymousSendOrSaveTask, boolean paramAnonymousBoolean)
        {
          if (mAccount != null) {
            MailAppProvider.getInstance().setLastSentFromAccount(mAccount.uri.toString());
          }
          if (paramAnonymousBoolean) {
            ComposeActivity.this.discardChanges();
          }
          synchronized (mActiveTasks)
          {
            mActiveTasks.remove(paramAnonymousSendOrSaveTask);
            int i = mActiveTasks.size();
            if (i == 0) {
              stopService(new Intent(ComposeActivity.this, EmptyService.class));
            }
            if (ComposeActivity.sTestSendOrSaveCallback != null) {
              ComposeActivity.sTestSendOrSaveCallback.sendOrSaveFinished(paramAnonymousSendOrSaveTask, paramAnonymousBoolean);
            }
            return;
            Toast.makeText(ComposeActivity.this, 2131493018, 0).show();
          }
        }
      };
      localReplyFromAccount = mReplyFromAccount;
      localObject = name;
      if ((localReplyFromAccount != null) && (localObject != null)) {
        break label270;
      }
      localReplyFromAccount = mReplyFromAccount;
      localObject = mAccount.name;
    }
    label262:
    label270:
    for (;;)
    {
      if (mSendSaveTaskHandler == null)
      {
        localObject = new HandlerThread("Send Message Task Thread");
        ((HandlerThread)localObject).start();
        mSendSaveTaskHandler = new Handler(((HandlerThread)localObject).getLooper());
      }
      localObject = createMessage(mReplyFromAccount, getMode());
      mRequestId = sendOrSaveInternal(this, mReplyFromAccount, (Message)localObject, mRefMessage, paramSpanned, mQuotedTextView.getQuotedTextIfIncluded(), local3, mSendSaveTaskHandler, paramBoolean1, mComposeMode);
      if ((mRecipient != null) && (mRecipient.equals(mAccount.name))) {
        mRecipient = name;
      }
      setAccount(account);
      if ((paramBoolean2) && ((getChangingConfigurations() & 0x80) == 0)) {
        if (!paramBoolean1) {
          break label262;
        }
      }
      for (int i = 2131493062;; i = 2131493063)
      {
        Toast.makeText(this, i, 1).show();
        discardChanges();
        updateSaveUi();
        if (paramBoolean1) {
          break;
        }
        finish();
        return;
        getToAddresses();
        getCcAddresses();
        getBccAddresses();
        break label12;
      }
    }
  }
  
  static int sendOrSaveInternal(Context paramContext, ReplyFromAccount paramReplyFromAccount, Message paramMessage1, Message paramMessage2, Spanned paramSpanned, CharSequence paramCharSequence, SendOrSaveCallback paramSendOrSaveCallback, Handler paramHandler, boolean paramBoolean, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    boolean bool1;
    label85:
    boolean bool2;
    if (paramMessage2 != null)
    {
      str = uri.toString();
      MessageModification.putToAddresses(localContentValues, paramMessage1.getToAddresses());
      MessageModification.putCcAddresses(localContentValues, paramMessage1.getCcAddresses());
      MessageModification.putBccAddresses(localContentValues, paramMessage1.getBccAddresses());
      MessageModification.putCustomFromAddress(localContentValues, from);
      MessageModification.putSubject(localContentValues, subject);
      paramSpanned = Html.toHtml(paramSpanned);
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label311;
      }
      bool1 = true;
      paramSpanned = new StringBuilder(paramSpanned);
      if (bool1)
      {
        paramCharSequence = paramCharSequence.toString();
        if (!QuotedTextView.containsQuotedText(paramCharSequence)) {
          break label323;
        }
        int i = QuotedTextView.getQuotedTextOffset(paramCharSequence);
        int j = paramSpanned.length();
        paramSpanned.append(paramCharSequence);
        MessageModification.putQuoteStartPos(localContentValues, i + j);
        if (paramInt != 2) {
          break label317;
        }
        bool2 = true;
        label158:
        MessageModification.putForward(localContentValues, bool2);
        MessageModification.putAppendRefMessageContent(localContentValues, bool1);
      }
      label172:
      MessageModification.putDraftType(localContentValues, getDraftType(paramInt));
      if (paramMessage2 == null) {
        break label348;
      }
      if (!TextUtils.isEmpty(bodyHtml)) {
        MessageModification.putBodyHtml(localContentValues, paramSpanned.toString());
      }
      if (!TextUtils.isEmpty(bodyText)) {
        MessageModification.putBody(localContentValues, Html.fromHtml(paramSpanned.toString()).toString());
      }
    }
    for (;;)
    {
      MessageModification.putAttachments(localContentValues, paramMessage1.getAttachments());
      if (!TextUtils.isEmpty(str)) {
        MessageModification.putRefMessageId(localContentValues, str);
      }
      paramReplyFromAccount = new SendOrSaveMessage(paramReplyFromAccount, localContentValues, str, paramBoolean);
      paramContext = new SendOrSaveTask(paramContext, paramReplyFromAccount, paramSendOrSaveCallback);
      paramSendOrSaveCallback.initializeSendOrSave(paramContext);
      paramHandler.post(paramContext);
      return paramReplyFromAccount.requestId();
      str = "";
      break;
      label311:
      bool1 = false;
      break label85;
      label317:
      bool2 = false;
      break label158;
      label323:
      LogUtils.w(LOG_TAG, "Couldn't find quoted text", new Object[0]);
      paramSpanned.append(paramCharSequence);
      break label172;
      label348:
      MessageModification.putBodyHtml(localContentValues, paramSpanned.toString());
      MessageModification.putBody(localContentValues, Html.fromHtml(paramSpanned.toString()).toString());
    }
  }
  
  private void setFieldsFromRefMessage(int paramInt, String paramString)
  {
    setSubject(mRefMessage, paramInt);
    if (paramInt == 2) {
      mForward = true;
    }
    initRecipientsFromRefMessage(paramString, mRefMessage, paramInt);
    initQuotedTextFromRefMessage(mRefMessage, paramInt);
    if ((paramInt == 2) || (mAttachmentsChanged)) {
      initAttachments(mRefMessage);
    }
  }
  
  private void setFocus(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 3) {
      switch (mDraft.draftType)
      {
      }
    }
    for (i = 0;; i = -1) {
      switch (i)
      {
      case 0: 
      case 1: 
      default: 
        focusBody();
        return;
      }
    }
    mTo.requestFocus();
  }
  
  private void setSubject(Message paramMessage, int paramInt)
  {
    String str = subject;
    if (paramInt == -1)
    {
      paramMessage = "";
      if ((TextUtils.isEmpty(str)) || (!str.toLowerCase().startsWith(paramMessage.toLowerCase()))) {
        break label73;
      }
    }
    label73:
    for (paramMessage = str;; paramMessage = String.format(getString(2131492902), new Object[] { paramMessage, str }))
    {
      mSubject.setText(paramMessage);
      return;
      if (paramInt == 2)
      {
        paramMessage = getString(2131492904);
        break;
      }
      paramMessage = getString(2131492903);
      break;
    }
  }
  
  private void setupRecipients(RecipientEditTextView paramRecipientEditTextView)
  {
    paramRecipientEditTextView.setAdapter(new RecipientAdapter(this, mAccount));
    paramRecipientEditTextView.setTokenizer(new Rfc822Tokenizer());
    if (mValidator == null)
    {
      String str2 = mAccount.name;
      String str1 = str2;
      if (str2.indexOf("@") + 1 > -1) {
        str1 = str2.substring(str2.indexOf("@") + 1);
      }
      mValidator = new Rfc822Validator(str1);
    }
    paramRecipientEditTextView.setValidator(mValidator);
  }
  
  private boolean shouldSave()
  {
    for (;;)
    {
      synchronized (mDraftLock)
      {
        if (((mTextChanged) || (mAttachmentsChanged) || (mReplyFromChanged)) && (!isBlank()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void showAttachmentTooBigToast(int paramInt)
  {
    showErrorToast(getString(paramInt, new Object[] { AttachmentUtils.convertToHumanReadableSize(getApplicationContext(), mAccount.settings.getMaxAttachmentSize()) }));
  }
  
  private void showCcBcc(Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("showCc")))
    {
      boolean bool1 = paramBundle.getBoolean("showCc");
      boolean bool2 = paramBundle.getBoolean("showBcc");
      if ((bool1) || (bool2)) {
        mCcBccView.show(false, bool1, bool2);
      }
    }
  }
  
  private void showCcBccViews()
  {
    mCcBccView.show(true, true, true);
    if (mCcBccButton != null) {
      mCcBccButton.setVisibility(4);
    }
  }
  
  private void showErrorToast(String paramString)
  {
    Toast localToast = Toast.makeText(this, paramString, 1);
    localToast.setText(paramString);
    localToast.setGravity(1, 0, getResources().getDimensionPixelSize(2131427396));
    localToast.show();
  }
  
  private void showSendConfirmDialog(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (mSendConfirmDialog != null)
    {
      mSendConfirmDialog.dismiss();
      mSendConfirmDialog = null;
    }
    mSendConfirmDialog = new AlertDialog.Builder(this).setMessage(paramInt).setTitle(2131492915).setIconAttribute(16843605).setPositiveButton(2131492922, paramOnClickListener).setNegativeButton(2131493075, this).show();
  }
  
  private void showWaitFragment(com.android.mail.providers.Account paramAccount)
  {
    WaitFragment localWaitFragment = getWaitFragment();
    if (localWaitFragment != null)
    {
      localWaitFragment.updateAccount(paramAccount);
      return;
    }
    findViewById(2131755076).setVisibility(0);
    replaceFragment(WaitFragment.newInstance(paramAccount, true), 4097, "wait-fragment");
  }
  
  private void updateHideOrShowCcBcc()
  {
    boolean bool1 = mCcBccView.isCcVisible();
    boolean bool2 = mCcBccView.isBccVisible();
    Button localButton;
    if (mCcBccButton != null)
    {
      if ((bool1) && (bool2)) {
        break label71;
      }
      mCcBccButton.setVisibility(0);
      localButton = mCcBccButton;
      if (bool1) {
        break label64;
      }
    }
    label64:
    for (int i = 2131492958;; i = 2131492959)
    {
      localButton.setText(getString(i));
      return;
    }
    label71:
    mCcBccButton.setVisibility(4);
  }
  
  private void updateHideOrShowQuotedText(boolean paramBoolean)
  {
    mQuotedTextView.updateCheckedState(paramBoolean);
    QuotedTextView localQuotedTextView = mQuotedTextView;
    if (mAttachmentsView.getAttachments().size() > 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localQuotedTextView.setUpperDividerVisible(paramBoolean);
      return;
    }
  }
  
  private void updateMessage(Message paramMessage, ReplyFromAccount paramReplyFromAccount, int paramInt)
  {
    if (paramReplyFromAccount != null) {
      paramReplyFromAccount = address;
    }
    for (;;)
    {
      from = paramReplyFromAccount;
      draftType = getDraftType(paramInt);
      return;
      if (mAccount != null) {
        paramReplyFromAccount = mAccount.name;
      } else {
        paramReplyFromAccount = null;
      }
    }
  }
  
  void addAddressesToList(Collection<String> paramCollection, RecipientEditTextView paramRecipientEditTextView)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      addAddressToList((String)paramCollection.next(), paramRecipientEditTextView);
    }
  }
  
  public void addAttachmentAndUpdateView(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (paramIntent = paramIntent.getData();; paramIntent = (Uri)null)
    {
      addAttachmentAndUpdateView(paramIntent);
      return;
    }
  }
  
  public void addAttachmentAndUpdateView(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    try
    {
      addAttachmentAndUpdateView(mAttachmentsView.generateLocalAttachment(paramUri));
      return;
    }
    catch (AttachmentsView.AttachmentFailureException paramUri)
    {
      LogUtils.e(LOG_TAG, paramUri, "Error adding attachment", new Object[0]);
      showErrorToast(getResources().getString(paramUri.getErrorRes(), new Object[] { AttachmentUtils.convertToHumanReadableSize(getApplicationContext(), mAccount.settings.getMaxAttachmentSize()) }));
    }
  }
  
  public void addAttachmentAndUpdateView(Attachment paramAttachment)
  {
    try
    {
      if (mAttachmentsView.addAttachment(mAccount, paramAttachment) > 0L)
      {
        mAttachmentsChanged = true;
        updateSaveUi();
      }
      return;
    }
    catch (AttachmentsView.AttachmentFailureException paramAttachment)
    {
      LogUtils.e(LOG_TAG, paramAttachment, "Error adding attachment", new Object[0]);
      showAttachmentTooBigToast(paramAttachment.getErrorRes());
    }
  }
  
  public long addAttachments(List<Attachment> paramList)
  {
    long l1 = 0L;
    Object localObject = null;
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Attachment localAttachment = (Attachment)localIterator.next();
        try
        {
          long l2 = mAttachmentsView.addAttachment(mAccount, localAttachment);
          l1 += l2;
        }
        catch (AttachmentsView.AttachmentFailureException localAttachmentFailureException)
        {
          for (;;) {}
        }
      }
    }
    if (localAttachmentFailureException != null)
    {
      LogUtils.e(LOG_TAG, localAttachmentFailureException, "Error adding attachment", new Object[0]);
      if (paramList.size() > 1) {
        showAttachmentTooBigToast(2131492910);
      }
    }
    else
    {
      return l1;
    }
    showAttachmentTooBigToast(localAttachmentFailureException.getErrorRes());
    return l1;
  }
  
  protected void addCcAddressesToList(List<Rfc822Token[]> paramList1, List<Rfc822Token[]> paramList2, RecipientEditTextView paramRecipientEditTextView)
  {
    int i;
    Object localObject;
    if (paramList2 == null)
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (Rfc822Token[])paramList1.next();
        i = 0;
        while (i < paramList2.length)
        {
          localObject = paramList2[i].toString();
          paramRecipientEditTextView.append((String)localObject + ", ");
          i += 1;
        }
      }
    }
    paramList2 = convertToHashSet(paramList2);
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      localObject = (Rfc822Token[])paramList1.next();
      i = 0;
      while (i < localObject.length)
      {
        String str = localObject[i].toString();
        if (!paramList2.contains(localObject[i].getAddress())) {
          paramRecipientEditTextView.append(str + ", ");
        }
        i += 1;
      }
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    mTextChanged = true;
    updateSaveUi();
  }
  
  public void appendToBody(CharSequence paramCharSequence, boolean paramBoolean)
  {
    Editable localEditable = mBodyView.getEditableText();
    if ((localEditable != null) && (localEditable.length() > 0))
    {
      localEditable.append(paramCharSequence);
      return;
    }
    setBody(paramCharSequence, paramBoolean);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void checkInvalidEmails(String[] paramArrayOfString, List<String> paramList)
  {
    if (mValidator == null) {}
    for (;;)
    {
      return;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (!mValidator.isValid(str)) {
          paramList.add(str);
        }
        i += 1;
      }
    }
  }
  
  protected String decodeEmailInUri(String paramString)
    throws UnsupportedEncodingException
  {
    String str = paramString.replace("+", "%2B");
    try
    {
      str = URLDecoder.decode(str, "UTF-8");
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (!LogUtils.isLoggable(LOG_TAG, 2)) {
        break label59;
      }
    }
    LogUtils.e(LOG_TAG, "%s while decoding '%s'", new Object[] { localIllegalArgumentException.getMessage(), paramString });
    for (;;)
    {
      return null;
      label59:
      LogUtils.e(LOG_TAG, localIllegalArgumentException, "Exception  while decoding mailto address", new Object[0]);
    }
  }
  
  public void enableSave(boolean paramBoolean)
  {
    if (mSave != null) {
      mSave.setEnabled(paramBoolean);
    }
  }
  
  public void enableSend(boolean paramBoolean)
  {
    if (mSend != null) {
      mSend.setEnabled(paramBoolean);
    }
  }
  
  public void focusBody()
  {
    mBodyView.requestFocus();
    int i = mBodyView.getText().length();
    int j = getSignatureStartPosition(mSignature, mBodyView.getText().toString());
    if (j > -1) {
      mBodyView.setSelection(j);
    }
    while (i < 0) {
      return;
    }
    mBodyView.setSelection(i);
  }
  
  public String[] getAddressesFromList(RecipientEditTextView paramRecipientEditTextView)
  {
    if (paramRecipientEditTextView == null)
    {
      paramRecipientEditTextView = new String[0];
      return paramRecipientEditTextView;
    }
    Rfc822Token[] arrayOfRfc822Token = Rfc822Tokenizer.tokenize(paramRecipientEditTextView.getText());
    int j = arrayOfRfc822Token.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    for (;;)
    {
      paramRecipientEditTextView = arrayOfString;
      if (i >= j) {
        break;
      }
      arrayOfString[i] = arrayOfRfc822Token[i].toString();
      i += 1;
    }
  }
  
  protected ArrayList<Attachment> getAttachments()
  {
    return mAttachmentsView.getAttachments();
  }
  
  public String[] getBccAddresses()
  {
    return getAddressesFromList(mBcc);
  }
  
  public String[] getCcAddresses()
  {
    return getAddressesFromList(mCc);
  }
  
  public com.android.mail.providers.Account getFromAccount()
  {
    if ((mReplyFromAccount != null) && (mReplyFromAccount.account != null)) {
      return mReplyFromAccount.account;
    }
    return mAccount;
  }
  
  protected ReplyFromAccount getMatchingRecipient(com.android.mail.providers.Account paramAccount, List<String> paramList)
  {
    Iterator localIterator = null;
    List<String> localList = null;
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = Rfc822Tokenizer.tokenize((String)paramList.next());
      i = 0;
      while (i < localObject.length)
      {
        localHashSet.add(localObject[i].getAddress());
        i += 1;
      }
    }
    int j = 0;
    int i = 0;
    Object localObject = paramAccount.getReplyFroms();
    paramList = localIterator;
    if (localObject != null)
    {
      localIterator = ((List)localObject).iterator();
      for (;;)
      {
        j = i;
        paramList = localList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (ReplyFromAccount)localIterator.next();
        if (localHashSet.contains(address))
        {
          localList = paramList;
          i += 1;
        }
      }
    }
    if (j > 1) {
      paramList = getDefaultReplyFromAccount(paramAccount);
    }
    return paramList;
  }
  
  public ReplyFromAccount getReplyFromAccount(com.android.mail.providers.Account paramAccount, Message paramMessage)
  {
    if (mCachedSettings.forceReplyFromDefault) {
      return getDefaultReplyFromAccount(paramAccount);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(paramMessage.getToAddresses()));
    localArrayList.addAll(Arrays.asList(paramMessage.getCcAddresses()));
    return getMatchingRecipient(paramAccount, localArrayList);
  }
  
  protected int getSignatureStartPosition(String paramString1, String paramString2)
  {
    int j = -1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return -1;
    }
    int k = paramString2.length();
    int m = paramString1.length();
    String str = convertToPrintableSignature(paramString1);
    int i = str.length();
    if ((k >= i) && (paramString2.substring(k - i).equals(str))) {
      i = k - i;
    }
    for (;;)
    {
      return i;
      i = j;
      if (k >= m)
      {
        i = j;
        if (paramString2.substring(k - m).equals(paramString1)) {
          i = k - m;
        }
      }
    }
  }
  
  public String[] getToAddresses()
  {
    return getAddressesFromList(mTo);
  }
  
  protected void initAttachments(Message paramMessage)
  {
    addAttachments(paramMessage.getAttachments());
  }
  
  public void initFromExtras(Intent paramIntent)
  {
    Object localObject = paramIntent.getData();
    int i;
    label138:
    String str1;
    String str2;
    if (localObject != null)
    {
      if ("mailto".equals(((Uri)localObject).getScheme())) {
        initFromMailTo(((Uri)localObject).toString());
      }
    }
    else
    {
      localObject = paramIntent.getStringArrayExtra("android.intent.extra.EMAIL");
      if (localObject != null) {
        addToAddresses(Arrays.asList((Object[])localObject));
      }
      localObject = paramIntent.getStringArrayExtra("android.intent.extra.CC");
      if (localObject != null) {
        addCcAddresses(Arrays.asList((Object[])localObject), null);
      }
      localObject = paramIntent.getStringArrayExtra("android.intent.extra.BCC");
      if (localObject != null) {
        addBccAddresses(Arrays.asList((Object[])localObject));
      }
      localObject = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
      if (localObject != null) {
        mSubject.setText((CharSequence)localObject);
      }
      localObject = ALL_EXTRAS;
      int j = localObject.length;
      i = 0;
      if (i >= j) {
        break label352;
      }
      str1 = localObject[i];
      if (paramIntent.hasExtra(str1))
      {
        str2 = paramIntent.getStringExtra(str1);
        if (!"to".equals(str1)) {
          break label253;
        }
        addToAddresses(Arrays.asList(TextUtils.split(str2, ",")));
      }
    }
    for (;;)
    {
      i += 1;
      break label138;
      if (mAccount.composeIntentUri.equals(localObject)) {
        break;
      }
      localObject = ((Uri)localObject).getSchemeSpecificPart();
      if (localObject == null) {
        break;
      }
      mTo.setText("");
      addToAddresses(Arrays.asList(TextUtils.split((String)localObject, ",")));
      break;
      label253:
      if ("cc".equals(str1)) {
        addCcAddresses(Arrays.asList(TextUtils.split(str2, ",")), null);
      } else if ("bcc".equals(str1)) {
        addBccAddresses(Arrays.asList(TextUtils.split(str2, ",")));
      } else if ("subject".equals(str1)) {
        mSubject.setText(str2);
      } else if ("body".equals(str1)) {
        setBody(str2, true);
      }
    }
    label352:
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getCharSequence("android.intent.extra.TEXT");
      if (paramIntent != null) {
        setBody(paramIntent, true);
      }
    }
  }
  
  public void initFromMailTo(String paramString)
  {
    Uri localUri = Uri.parse("foo://" + paramString);
    int i = paramString.indexOf("?");
    int j = "mailto".length() + 1;
    if (i == -1) {}
    try
    {
      str = decodeEmailInUri(paramString.substring(j));
      if (!TextUtils.isEmpty(str)) {
        addToAddresses(Arrays.asList(TextUtils.split(str, ",")));
      }
      paramString = localUri.getQueryParameters("cc");
      addCcAddresses(Arrays.asList(paramString.toArray(new String[paramString.size()])), null);
      paramString = localUri.getQueryParameters("to");
      addToAddresses(Arrays.asList(paramString.toArray(new String[paramString.size()])));
      paramString = localUri.getQueryParameters("bcc");
      addBccAddresses(Arrays.asList(paramString.toArray(new String[paramString.size()])));
      paramString = localUri.getQueryParameters("subject");
      if (paramString.size() <= 0) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      try
      {
        for (;;)
        {
          mSubject.setText(URLDecoder.decode((String)paramString.get(0), "UTF-8"));
          paramString = localUri.getQueryParameters("body");
          if (paramString.size() > 0) {}
          try
          {
            setBody(URLDecoder.decode((String)paramString.get(0), "UTF-8"), true);
            return;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException3)
          {
            LogUtils.e(LOG_TAG, "%s while decoding body '%s'", new Object[] { localUnsupportedEncodingException3.getMessage(), paramString });
          }
          String str = decodeEmailInUri(paramString.substring(j, i));
          continue;
          localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
          if (!LogUtils.isLoggable(LOG_TAG, 2)) {
            break;
          }
          LogUtils.e(LOG_TAG, "%s while decoding '%s'", new Object[] { localUnsupportedEncodingException1.getMessage(), paramString });
        }
        LogUtils.e(LOG_TAG, localUnsupportedEncodingException1, "Exception  while decoding mailto address", new Object[0]);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;)
        {
          LogUtils.e(LOG_TAG, "%s while decoding subject '%s'", new Object[] { localUnsupportedEncodingException2.getMessage(), paramString });
        }
      }
    }
  }
  
  void initRecipientsFromRefMessage(String paramString, Message paramMessage, int paramInt)
  {
    if (paramInt == 2) {
      return;
    }
    initReplyRecipients(mAccount.name, paramMessage, paramInt);
  }
  
  void initReplyRecipients(String paramString, Message paramMessage, int paramInt)
  {
    String str1 = Address.getEmailAddress(paramString).getAddress();
    String[] arrayOfString = paramMessage.getToAddresses();
    String str2 = replyTo;
    if (paramInt == 0) {
      addToAddresses(initToRecipients(paramString, str1, from, str2, arrayOfString));
    }
    while (paramInt != 1) {
      return;
    }
    HashSet localHashSet = Sets.newHashSet();
    paramString = initToRecipients(paramString, str1, from, str2, arrayOfString);
    addToAddresses(paramString);
    addRecipients(str1, localHashSet, arrayOfString);
    addRecipients(str1, localHashSet, paramMessage.getCcAddresses());
    addCcAddresses(localHashSet, paramString);
  }
  
  protected Collection<String> initToRecipients(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString)
  {
    paramString2 = Sets.newHashSet();
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString2.add(paramString4);
      return paramString2;
    }
    if (!recipientMatchesThisAccount(paramString1, paramString3))
    {
      paramString2.add(paramString3);
      return paramString2;
    }
    paramString2.addAll(Arrays.asList(paramArrayOfString));
    return paramString2;
  }
  
  public boolean isBlank()
  {
    return (mSubject.getText().length() == 0) && ((mBodyView.getText().length() == 0) || (getSignatureStartPosition(mSignature, mBodyView.getText().toString()) == 0)) && (mTo.length() == 0) && (mCc.length() == 0) && (mBcc.length() == 0) && (mAttachmentsView.getAttachments().size() == 0);
  }
  
  public boolean isBodyEmpty()
  {
    return !mQuotedTextView.isTextIncluded();
  }
  
  public boolean isSubjectEmpty()
  {
    return TextUtils.getTrimmedLength(mSubject.getText()) == 0;
  }
  
  public void onAccountChanged()
  {
    mReplyFromAccount = mFromSpinner.getCurrentAccount();
    if (!mAccount.equals(mReplyFromAccount.account))
    {
      setAccount(mReplyFromAccount.account);
      if (!isBlank()) {
        enableSave(true);
      }
      mReplyFromChanged = true;
      initRecipients();
    }
  }
  
  protected final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      addAttachmentAndUpdateView(paramIntent);
      mAddingAttachment = false;
    }
    while (paramInt1 != 2) {
      return;
    }
    if (paramInt2 != -1)
    {
      finish();
      return;
    }
    getLoaderManager().initLoader(1, null, this);
    showWaitFragment(null);
  }
  
  public void onAttachmentAdded()
  {
    QuotedTextView localQuotedTextView = mQuotedTextView;
    if (mAttachmentsView.getAttachments().size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localQuotedTextView.setUpperDividerVisible(bool);
      mAttachmentsView.focusLastAttachment();
      return;
    }
  }
  
  public void onAttachmentDeleted()
  {
    boolean bool = true;
    mAttachmentsChanged = true;
    QuotedTextView localQuotedTextView = mQuotedTextView;
    if (mAttachmentsView.getAttachments().size() > 0) {}
    for (;;)
    {
      localQuotedTextView.setUpperDividerVisible(bool);
      updateSaveUi();
      return;
      bool = false;
    }
  }
  
  public void onBackPressed()
  {
    if (getWaitFragment() != null)
    {
      finish();
      return;
    }
    super.onBackPressed();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -1: 
      doDiscardWithoutConfirmation(true);
      return;
    }
    enableSend(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131755080: 
      showCcBccViews();
      return;
    case 2131755084: 
      doAttach("image/*");
      return;
    }
    doAttach("video/*");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968598);
    mSavedInstanceState = paramBundle;
    checkValidAccounts();
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return new CursorLoader(this, mRefMessageUri, UIProvider.MESSAGE_PROJECTION, null, null, null);
    }
    return new CursorLoader(this, MailAppProvider.getAccountsUri(), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = false;
    super.onCreateOptionsMenu(paramMenu);
    if ((mAccounts == null) || (mAccounts.length == 0)) {
      return true;
    }
    getMenuInflater().inflate(2131886080, paramMenu);
    mSave = paramMenu.findItem(2131755294);
    mSend = paramMenu.findItem(2131755292);
    MenuItem localMenuItem = paramMenu.findItem(2131755298);
    paramMenu = paramMenu.findItem(2131755297);
    if (localMenuItem != null) {
      if ((mAccount == null) || (!mAccount.supportsCapability(32768))) {
        break label159;
      }
    }
    label159:
    for (boolean bool1 = true;; bool1 = false)
    {
      localMenuItem.setVisible(bool1);
      if (paramMenu == null) {
        break;
      }
      bool1 = bool2;
      if (mAccount != null)
      {
        bool1 = bool2;
        if (mAccount.supportsCapability(65536)) {
          bool1 = true;
        }
      }
      paramMenu.setVisible(bool1);
      return true;
    }
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 6)
    {
      focusBody();
      return true;
    }
    return false;
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    Object localObject = null;
    switch (paramLoader.getId())
    {
    }
    do
    {
      do
      {
        int i;
        do
        {
          return;
          if ((paramCursor == null) || (!paramCursor.moveToFirst())) {
            break;
          }
          mRefMessage = new Message(paramCursor);
          mRefMessage.to = null;
          mRefMessage.from = null;
          paramLoader = getIntent();
          i = paramLoader.getIntExtra("action", -1);
          initFromRefMessage(i, mAccount.name);
          finishSetup(i, paramLoader, null, true);
        } while (i == 2);
        paramLoader = paramLoader.getStringExtra("to");
      } while (TextUtils.isEmpty(paramLoader));
      clearChangeListeners();
      mTo.append(paramLoader);
      initChangeListeners();
      return;
      finish();
      return;
    } while ((paramCursor == null) || (!paramCursor.moveToFirst()));
    ArrayList localArrayList = new ArrayList();
    paramLoader = new ArrayList();
    do
    {
      com.android.mail.providers.Account localAccount = new com.android.mail.providers.Account(paramCursor);
      if (localAccount.isAccountReady()) {
        paramLoader.add(localAccount);
      }
      localArrayList.add(localAccount);
    } while (paramCursor.moveToNext());
    if (paramLoader.size() > 0)
    {
      findViewById(2131755076).setVisibility(8);
      getLoaderManager().destroyLoader(1);
      findViewById(2131755071).setVisibility(0);
      mAccounts = ((com.android.mail.providers.Account[])localArrayList.toArray(new com.android.mail.providers.Account[paramLoader.size()]));
      finishCreate();
      invalidateOptionsMenu();
      return;
    }
    paramLoader = (Loader<Cursor>)localObject;
    if (localArrayList.size() > 0) {
      paramLoader = (com.android.mail.providers.Account)localArrayList.get(0);
    }
    showWaitFragment(paramLoader);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public boolean onNavigationItemSelected(int paramInt, long paramLong)
  {
    int i = mComposeMode;
    boolean bool3;
    boolean bool2;
    if (paramInt == 0)
    {
      mComposeMode = 0;
      clearChangeListeners();
      if (i != mComposeMode)
      {
        resetMessageForModeChange();
        if ((mDraft == null) && (mRefMessage != null)) {
          setFieldsFromRefMessage(mComposeMode, mAccount.name);
        }
        bool1 = false;
        bool3 = false;
        if (mDraft == null) {
          break label179;
        }
        if (TextUtils.isEmpty(mDraft.bcc)) {
          break label167;
        }
        bool2 = true;
        label90:
        if ((!bool2) && ((TextUtils.isEmpty(mDraft.cc)) || (mComposeMode != 1))) {
          break label173;
        }
        bool1 = true;
      }
    }
    label167:
    label173:
    label179:
    do
    {
      for (;;)
      {
        mCcBccView.show(false, bool1, bool2);
        updateHideOrShowCcBcc();
        initChangeListeners();
        return true;
        if (paramInt == 1)
        {
          mComposeMode = 1;
          break;
        }
        if (paramInt != 2) {
          break;
        }
        mComposeMode = 2;
        break;
        bool2 = false;
        break label90;
        bool1 = false;
      }
      bool2 = bool3;
    } while (mRefMessage == null);
    if (!TextUtils.isEmpty(mCc.getText())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      break;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool1 = true;
    switch (paramMenuItem.getItemId())
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (!bool1) {
        bool2 = super.onOptionsItemSelected(paramMenuItem);
      }
      return bool2;
      doAttach("image/*");
      continue;
      doAttach("video/*");
      continue;
      showCcBccViews();
      continue;
      doSave(true);
      continue;
      doSend();
      continue;
      doDiscard();
      continue;
      Utils.showSettings(this, mAccount);
      continue;
      onAppUpPressed();
      continue;
      Utils.showHelp(this, mAccount, getString(2131492874));
      continue;
      Utils.sendFeedback(this, mAccount, false);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (mSendConfirmDialog != null) {
      mSendConfirmDialog.dismiss();
    }
    if (mRecipientErrorDialog != null) {
      mRecipientErrorDialog.dismiss();
    }
    if (!isChangingConfigurations()) {
      saveIfNeeded();
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    paramMenu = paramMenu.findItem(2131755080);
    int i;
    if ((paramMenu != null) && (mCc != null))
    {
      boolean bool1 = mCc.isShown();
      boolean bool2 = mBcc.isShown();
      if ((bool1) && (bool2)) {
        break label105;
      }
      paramMenu.setVisible(true);
      if (bool1) {
        break label98;
      }
      i = 2131492958;
      paramMenu.setTitle(getString(i));
    }
    for (;;)
    {
      if (mSave != null) {
        mSave.setEnabled(shouldSave());
      }
      return true;
      label98:
      i = 2131492959;
      break;
      label105:
      paramMenu.setVisible(false);
    }
  }
  
  public void onRespondInline(String paramString)
  {
    appendToBody(paramString, false);
    mQuotedTextView.setUpperDividerVisible(false);
    mTo.requestFocus();
  }
  
  public final void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("focusSelectionStart")))
    {
      int i = paramBundle.getInt("focusSelectionStart");
      int j = paramBundle.getInt(EXTRA_FOCUS_SELECTION_END);
      paramBundle = (EditText)getCurrentFocus();
      int k = paramBundle.getText().length();
      if ((i < k) && (j < k)) {
        paramBundle.setSelection(i, j);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if ((mFromSpinner != null) && (mAccount != null)) {
      mFromSpinner.asyncInitFromSpinner(mComposeMode, mAccount, mAccounts);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((mAccounts == null) || (mAccounts.length == 0)) {
      return;
    }
    Object localObject = getCurrentFocus();
    if ((localObject != null) && ((localObject instanceof EditText)))
    {
      localObject = (EditText)localObject;
      paramBundle.putInt("focusSelectionStart", ((EditText)localObject).getSelectionStart());
      paramBundle.putInt(EXTRA_FOCUS_SELECTION_END, ((EditText)localObject).getSelectionEnd());
    }
    localObject = mFromSpinner.getReplyFromAccounts();
    int i = mFromSpinner.getSelectedItemPosition();
    label143:
    Message localMessage;
    if ((localObject != null) && (((List)localObject).size() > 0) && (((List)localObject).size() > i))
    {
      localObject = (ReplyFromAccount)((List)localObject).get(i);
      if (localObject == null) {
        break label283;
      }
      paramBundle.putString("replyFromAccount", ((ReplyFromAccount)localObject).serialize().toString());
      paramBundle.putParcelable("account", account);
      if ((mDraftId == -1L) && (mRequestId != 0)) {
        paramBundle.putInt("requestId", mRequestId);
      }
      i = getMode();
      paramBundle.putInt("action", i);
      if (mDraft == null) {
        break label297;
      }
      localMessage = mDraft;
      updateMessage(localMessage, (ReplyFromAccount)localObject, i);
    }
    label283:
    label297:
    for (localObject = localMessage;; localObject = createMessage((ReplyFromAccount)localObject, i))
    {
      paramBundle.putParcelable("extraMessage", (Parcelable)localObject);
      if (mRefMessage != null) {
        paramBundle.putParcelable("in-reference-to-message", mRefMessage);
      }
      paramBundle.putBoolean("showCc", mCcBccView.isCcVisible());
      paramBundle.putBoolean("showBcc", mCcBccView.isBccVisible());
      paramBundle.putParcelableArrayList("attachmentPreviews", mAttachmentsView.getAttachmentPreviews());
      return;
      localObject = null;
      break;
      paramBundle.putParcelable("account", mAccount);
      break label143;
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected boolean recipientMatchesThisAccount(String paramString1, String paramString2)
  {
    return (paramString1.equalsIgnoreCase(paramString2)) || (ReplyFromAccount.isCustomFrom(paramString2, mFromSpinner.getReplyFromAccounts()));
  }
  
  protected void resetMessageForModeChange()
  {
    mTo.setText("");
    mCc.setText("");
    mBcc.setText("");
    mSubject.setText("");
    if (!mAttachmentsChanged) {
      mAttachmentsView.deleteAllAttachments();
    }
  }
  
  protected boolean sendOrSaveWithSanityChecks(final boolean paramBoolean1, final boolean paramBoolean2, final boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((mAccounts == null) || (mAccount == null))
    {
      Toast.makeText(this, 2131493018, 0).show();
      if (paramBoolean4) {
        finish();
      }
      return false;
    }
    Editable localEditable = mBodyView.getEditableText();
    Object localObject2;
    Object localObject3;
    if (paramBoolean3)
    {
      localObject1 = new String[0];
      localObject2 = localObject1;
      localObject3 = localObject1;
    }
    while ((!paramBoolean1) && (localObject3.length == 0) && (localObject2.length == 0) && (localObject1.length == 0))
    {
      showRecipientErrorDialog(getString(2131492913));
      return false;
      localObject3 = getToAddresses();
      localObject2 = getCcAddresses();
      localObject1 = getBccAddresses();
    }
    ArrayList localArrayList = new ArrayList();
    if (!paramBoolean1)
    {
      checkInvalidEmails((String[])localObject3, localArrayList);
      checkInvalidEmails((String[])localObject2, localArrayList);
      checkInvalidEmails((String[])localObject1, localArrayList);
    }
    if (localArrayList.size() > 0)
    {
      showRecipientErrorDialog(String.format(getString(2131493064), new Object[] { localArrayList.get(0) }));
      return false;
    }
    Object localObject1 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ComposeActivity.this.sendOrSave(mBodyView.getEditableText(), paramBoolean1, paramBoolean2, paramBoolean3);
      }
    };
    if (!paramBoolean1)
    {
      if ((mAttachmentsView.getAttachments().isEmpty()) && (showEmptyTextWarnings()))
      {
        paramBoolean3 = isSubjectEmpty();
        if (TextUtils.getTrimmedLength(localEditable) == 0)
        {
          i = 1;
          if ((i == 0) || ((mForward) && (!isBodyEmpty()))) {
            break label293;
          }
        }
        label293:
        for (int i = 1;; i = 0)
        {
          if (!paramBoolean3) {
            break label299;
          }
          showSendConfirmDialog(2131492916, (DialogInterface.OnClickListener)localObject1);
          return true;
          i = 0;
          break;
        }
        label299:
        if (i != 0)
        {
          showSendConfirmDialog(2131492917, (DialogInterface.OnClickListener)localObject1);
          return true;
        }
      }
      if (showSendConfirmation())
      {
        showSendConfirmDialog(2131492918, (DialogInterface.OnClickListener)localObject1);
        return true;
      }
    }
    sendOrSave(localEditable, paramBoolean1, paramBoolean2, false);
    return true;
  }
  
  void setAccount(com.android.mail.providers.Account paramAccount)
  {
    if (paramAccount == null) {}
    do
    {
      return;
      if (!paramAccount.equals(mAccount))
      {
        mAccount = paramAccount;
        mCachedSettings = mAccount.settings;
        appendSignature();
      }
    } while (mAccount == null);
    MailActivity.setForegroundNdef(MailActivity.getMailtoNdef(mAccount.name));
  }
  
  public void setBody(CharSequence paramCharSequence, boolean paramBoolean)
  {
    mBodyView.setText(paramCharSequence);
    if (paramBoolean) {
      appendSignature();
    }
  }
  
  protected boolean showEmptyTextWarnings()
  {
    return mAttachmentsView.getAttachments().size() == 0;
  }
  
  public void showRecipientErrorDialog(String paramString)
  {
    if (mRecipientErrorDialog != null) {
      mRecipientErrorDialog.dismiss();
    }
    mRecipientErrorDialog = new AlertDialog.Builder(this).setMessage(paramString).setTitle(2131492914).setIconAttribute(16843605).setPositiveButton(2131493074, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if (mTo != null) {
          mTo.requestFocus();
        }
        ComposeActivity.access$102(ComposeActivity.this, null);
      }
    }).show();
  }
  
  protected boolean showSendConfirmation()
  {
    if (mCachedSettings != null) {
      return mCachedSettings.confirmSend;
    }
    return false;
  }
  
  protected List<Rfc822Token[]> tokenizeAddressList(Collection<String> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(Rfc822Tokenizer.tokenize((String)paramCollection.next()));
    }
    return localArrayList;
  }
  
  public void updateSaveUi()
  {
    MenuItem localMenuItem;
    if (mSave != null)
    {
      localMenuItem = mSave;
      if ((!shouldSave()) || (isBlank())) {
        break label37;
      }
    }
    label37:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setEnabled(bool);
      return;
    }
  }
  
  private class ComposeModeAdapter
    extends ArrayAdapter<String>
  {
    private LayoutInflater mInflater;
    
    public ComposeModeAdapter(Context paramContext)
    {
      super(2130968604, 2131755098, getResources().getStringArray(2131623942));
    }
    
    private LayoutInflater getInflater()
    {
      if (mInflater == null) {
        mInflater = LayoutInflater.from(getContext());
      }
      return mInflater;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = getInflater().inflate(2130968603, null);
      }
      ((TextView)localView.findViewById(2131755098)).setText((CharSequence)getItem(paramInt));
      return super.getView(paramInt, localView, paramViewGroup);
    }
  }
  
  private class RecipientTextWatcher
    implements TextWatcher
  {
    private HashMap<String, Integer> mContent = new HashMap();
    private TextWatcher mListener;
    private RecipientEditTextView mView;
    
    public RecipientTextWatcher(RecipientEditTextView paramRecipientEditTextView, TextWatcher paramTextWatcher)
    {
      mView = paramRecipientEditTextView;
      mListener = paramTextWatcher;
    }
    
    private boolean hasChanged()
    {
      String[] arrayOfString = tokenizeRecips(getAddressesFromList(mView));
      int j = arrayOfString.length;
      int i = 0;
      Object localObject = mContent.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        i += ((Integer)((Map.Entry)((Iterator)localObject).next()).getValue()).intValue();
      }
      if (j != i) {
        return true;
      }
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localObject = arrayOfString[i];
        if (!mContent.containsKey(localObject)) {
          return true;
        }
        int k = ((Integer)mContent.get(localObject)).intValue() - 1;
        if (k < 0) {
          return true;
        }
        mContent.put(localObject, Integer.valueOf(k));
        i += 1;
      }
      return false;
    }
    
    private String[] tokenizeRecips(String[] paramArrayOfString)
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = Rfc822Tokenizer.tokenize(paramArrayOfString[i])[0].getAddress();
        i += 1;
      }
      return arrayOfString;
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (hasChanged()) {
        mListener.afterTextChanged(paramEditable);
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      paramCharSequence = tokenizeRecips(getAddressesFromList(mView));
      paramInt2 = paramCharSequence.length;
      paramInt1 = 0;
      if (paramInt1 < paramInt2)
      {
        Object localObject = paramCharSequence[paramInt1];
        if (!mContent.containsKey(localObject)) {
          mContent.put(localObject, Integer.valueOf(1));
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          mContent.put(localObject, Integer.valueOf(((Integer)mContent.get(localObject)).intValue() + 1));
        }
      }
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static abstract interface SendOrSaveCallback
  {
    public abstract Message getMessage();
    
    public abstract void initializeSendOrSave(ComposeActivity.SendOrSaveTask paramSendOrSaveTask);
    
    public abstract void notifyMessageIdAllocated(ComposeActivity.SendOrSaveMessage paramSendOrSaveMessage, Message paramMessage);
    
    public abstract void sendOrSaveFinished(ComposeActivity.SendOrSaveTask paramSendOrSaveTask, boolean paramBoolean);
  }
  
  public static class SendOrSaveMessage
  {
    final ReplyFromAccount mAccount;
    final String mRefMessageId;
    final int mRequestId;
    public final boolean mSave;
    final ContentValues mValues;
    
    public SendOrSaveMessage(ReplyFromAccount paramReplyFromAccount, ContentValues paramContentValues, String paramString, boolean paramBoolean)
    {
      mAccount = paramReplyFromAccount;
      mValues = paramContentValues;
      mRefMessageId = paramString;
      mSave = paramBoolean;
      mRequestId = (mValues.hashCode() ^ hashCode());
    }
    
    int requestId()
    {
      return mRequestId;
    }
  }
  
  public static class SendOrSaveTask
    implements Runnable
  {
    private final Context mContext;
    public final ComposeActivity.SendOrSaveCallback mSendOrSaveCallback;
    public final ComposeActivity.SendOrSaveMessage mSendOrSaveMessage;
    
    public SendOrSaveTask(Context paramContext, ComposeActivity.SendOrSaveMessage paramSendOrSaveMessage, ComposeActivity.SendOrSaveCallback paramSendOrSaveCallback)
    {
      mContext = paramContext;
      mSendOrSaveCallback = paramSendOrSaveCallback;
      mSendOrSaveMessage = paramSendOrSaveMessage;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveMessage	Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
      //   4: astore 6
      //   6: aload 6
      //   8: getfield 34	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mAccount	Lcom/android/mail/providers/ReplyFromAccount;
      //   11: astore 5
      //   13: aload_0
      //   14: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
      //   17: invokeinterface 40 1 0
      //   22: astore 7
      //   24: aload 7
      //   26: ifnull +240 -> 266
      //   29: aload 7
      //   31: getfield 46	com/android/mail/providers/Message:id	J
      //   34: lstore_1
      //   35: lload_1
      //   36: lstore_3
      //   37: aload 5
      //   39: aload 6
      //   41: getfield 34	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mAccount	Lcom/android/mail/providers/ReplyFromAccount;
      //   44: invokevirtual 50	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   47: ifne +75 -> 122
      //   50: lload_1
      //   51: lstore_3
      //   52: lload_1
      //   53: ldc2_w 51
      //   56: lcmp
      //   57: ifeq +65 -> 122
      //   60: aload_0
      //   61: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   64: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   67: astore 8
      //   69: new 60	android/content/ContentValues
      //   72: dup
      //   73: invokespecial 61	android/content/ContentValues:<init>	()V
      //   76: astore 9
      //   78: aload 9
      //   80: ldc 63
      //   82: lload_1
      //   83: invokestatic 69	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   86: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   89: aload 5
      //   91: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
      //   94: getfield 85	com/android/mail/providers/Account:expungeMessageUri	Landroid/net/Uri;
      //   97: ifnull +21 -> 118
      //   100: aload 8
      //   102: aload 5
      //   104: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
      //   107: getfield 85	com/android/mail/providers/Account:expungeMessageUri	Landroid/net/Uri;
      //   110: aload 9
      //   112: aconst_null
      //   113: aconst_null
      //   114: invokevirtual 91	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   117: pop
      //   118: ldc2_w 51
      //   121: lstore_3
      //   122: lload_3
      //   123: ldc2_w 51
      //   126: lcmp
      //   127: ifeq +156 -> 283
      //   130: aload 6
      //   132: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   135: ldc 63
      //   137: lload_3
      //   138: invokestatic 69	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   141: invokevirtual 73	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
      //   144: aload_0
      //   145: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   148: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   151: astore 8
      //   153: aload 6
      //   155: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
      //   158: ifeq +115 -> 273
      //   161: aload 7
      //   163: getfield 103	com/android/mail/providers/Message:saveUri	Ljava/lang/String;
      //   166: astore 5
      //   168: aload 8
      //   170: aload 5
      //   172: invokestatic 109	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   175: aload 6
      //   177: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   180: aconst_null
      //   181: aconst_null
      //   182: invokevirtual 91	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   185: pop
      //   186: aload 6
      //   188: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
      //   191: ifne +63 -> 254
      //   194: aload_0
      //   195: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   198: aload 6
      //   200: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   203: ldc 111
      //   205: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   208: checkcast 117	java/lang/String
      //   211: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
      //   214: aload_0
      //   215: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   218: aload 6
      //   220: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   223: ldc 125
      //   225: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   228: checkcast 117	java/lang/String
      //   231: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
      //   234: aload_0
      //   235: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   238: aload 6
      //   240: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   243: ldc 127
      //   245: invokevirtual 115	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
      //   248: checkcast 117	java/lang/String
      //   251: invokestatic 123	com/android/mail/providers/UIProvider:incrementRecipientsTimesContacted	(Landroid/content/Context;Ljava/lang/String;)V
      //   254: aload_0
      //   255: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
      //   258: aload_0
      //   259: iconst_1
      //   260: invokeinterface 131 3 0
      //   265: return
      //   266: ldc2_w 51
      //   269: lstore_1
      //   270: goto -235 -> 35
      //   273: aload 7
      //   275: getfield 134	com/android/mail/providers/Message:sendUri	Ljava/lang/String;
      //   278: astore 5
      //   280: goto -112 -> 168
      //   283: aload_0
      //   284: getfield 22	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mContext	Landroid/content/Context;
      //   287: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   290: astore 7
      //   292: aload 6
      //   294: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
      //   297: ifeq +100 -> 397
      //   300: aload 5
      //   302: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
      //   305: getfield 137	com/android/mail/providers/Account:saveDraftUri	Landroid/net/Uri;
      //   308: astore 5
      //   310: aload 7
      //   312: aload 5
      //   314: aload 6
      //   316: getfield 95	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mValues	Landroid/content/ContentValues;
      //   319: invokevirtual 141	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
      //   322: astore 5
      //   324: aload 6
      //   326: getfield 99	com/android/mail/compose/ComposeActivity$SendOrSaveMessage:mSave	Z
      //   329: ifeq -143 -> 186
      //   332: aload 5
      //   334: ifnull -148 -> 186
      //   337: aload 7
      //   339: aload 5
      //   341: getstatic 145	com/android/mail/providers/UIProvider:MESSAGE_PROJECTION	[Ljava/lang/String;
      //   344: aconst_null
      //   345: aconst_null
      //   346: aconst_null
      //   347: invokevirtual 149	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   350: astore 5
      //   352: aload 5
      //   354: ifnull -168 -> 186
      //   357: aload 5
      //   359: invokeinterface 155 1 0
      //   364: ifeq +23 -> 387
      //   367: aload_0
      //   368: getfield 24	com/android/mail/compose/ComposeActivity$SendOrSaveTask:mSendOrSaveCallback	Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
      //   371: aload 6
      //   373: new 42	com/android/mail/providers/Message
      //   376: dup
      //   377: aload 5
      //   379: invokespecial 158	com/android/mail/providers/Message:<init>	(Landroid/database/Cursor;)V
      //   382: invokeinterface 162 3 0
      //   387: aload 5
      //   389: invokeinterface 165 1 0
      //   394: goto -208 -> 186
      //   397: aload 5
      //   399: getfield 79	com/android/mail/providers/ReplyFromAccount:account	Lcom/android/mail/providers/Account;
      //   402: getfield 168	com/android/mail/providers/Account:sendMessageUri	Landroid/net/Uri;
      //   405: astore 5
      //   407: goto -97 -> 310
      //   410: astore 6
      //   412: aload 5
      //   414: invokeinterface 165 1 0
      //   419: aload 6
      //   421: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	422	0	this	SendOrSaveTask
      //   34	236	1	l1	long
      //   36	102	3	l2	long
      //   11	402	5	localObject1	Object
      //   4	368	6	localSendOrSaveMessage	ComposeActivity.SendOrSaveMessage
      //   410	10	6	localObject2	Object
      //   22	316	7	localObject3	Object
      //   67	102	8	localContentResolver	ContentResolver
      //   76	35	9	localContentValues	ContentValues
      // Exception table:
      //   from	to	target	type
      //   357	387	410	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */