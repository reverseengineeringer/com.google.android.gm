package com.android.mail.browse;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.provider.ContactsContract.StatusUpdates;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;
import com.android.mail.ContactInfo;
import com.android.mail.ContactInfoSource;
import com.android.mail.FormattedDateBuilder;
import com.android.mail.compose.ComposeActivity;
import com.android.mail.perf.Timer;
import com.android.mail.providers.Address;
import com.android.mail.providers.Message;
import com.android.mail.providers.Settings;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

public class MessageHeaderView
  extends LinearLayout
  implements View.OnClickListener, PopupMenu.OnMenuItemClickListener, ConversationContainer.DetachListener
{
  private static final String LOG_TAG = ;
  private ConversationViewAdapter.ConversationAccountController mAccountController;
  private Map<String, Address> mAddressCache;
  private View mAttachmentIcon;
  private String[] mBcc;
  private View mBottomBorderView;
  private MessageHeaderViewCallbacks mCallbacks;
  private String[] mCc;
  private boolean mCollapsedDetailsValid;
  private ViewGroup mCollapsedDetailsView;
  private int mCollapsedStarVis;
  private final DataSetObserver mContactInfoObserver = new DataSetObserver()
  {
    public void onChanged()
    {
      MessageHeaderView.this.updateContactInfo();
    }
  };
  private ContactInfoSource mContactInfoSource;
  private FormattedDateBuilder mDateBuilder;
  private AlertDialog mDetailsPopup;
  private View mDraftIcon;
  private View mEditDraftButton;
  private int mExpandMode = 0;
  private boolean mExpandable = true;
  private boolean mExpandedDetailsValid;
  private ViewGroup mExpandedDetailsView;
  private View mForwardButton;
  private String[] mFrom;
  private ViewGroup mImagePromptView;
  private final LayoutInflater mInflater;
  private MessageInviteView mInviteView;
  private boolean mIsDraft = false;
  private boolean mIsSending;
  private boolean mIsSnappy;
  private View mLeftSpacer;
  private MessageCursor.ConversationMessage mMessage;
  private ConversationViewAdapter.MessageHeaderItem mMessageHeaderItem;
  private boolean mObservingContactInfo;
  private View mOverflowButton;
  private View mPhotoSpacerView;
  private QuickContactBadge mPhotoView;
  private PopupMenu mPopup;
  private boolean mPreMeasuring;
  private ImageView mPresenceView;
  private AsyncQueryHandler mQueryHandler;
  private View mReplyAllButton;
  private View mReplyButton;
  private String[] mReplyTo;
  private View mRightSpacer;
  private Address mSender;
  private TextView mSenderEmailView;
  private TextView mSenderNameView;
  private boolean mShowImagePrompt;
  private String mSnippet;
  private SpamWarningView mSpamWarningView;
  private ImageView mStarView;
  private long mTimestampMs;
  private CharSequence mTimestampShort;
  private int mTitleContainerCollapsedMarginRight;
  private ViewGroup mTitleContainerView;
  private String[] mTo;
  private TextView mUpperDateView;
  private ViewGroup mUpperHeaderView;
  
  public MessageHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public MessageHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mInflater = LayoutInflater.from(paramContext);
  }
  
  private boolean ensureExpandedDetailsView()
  {
    if (mExpandedDetailsView == null)
    {
      View localView = mInflater.inflate(2130968617, null, false);
      localView.setOnClickListener(this);
      mExpandedDetailsView = ((ViewGroup)localView);
    }
    for (boolean bool = true;; bool = false)
    {
      if (!mExpandedDetailsValid)
      {
        if (mMessageHeaderItem.timestampLong == null) {
          mMessageHeaderItem.timestampLong = mDateBuilder.formatLongDateTime(mTimestampMs);
        }
        ((TextView)mExpandedDetailsView.findViewById(2131755129)).setText(mMessageHeaderItem.timestampLong);
        renderEmailList(2131755133, 2131755135, mReplyTo, false, mExpandedDetailsView);
        if (mMessage.viaDomain != null) {
          renderEmailList(2131755130, 2131755132, mFrom, true, mExpandedDetailsView);
        }
        renderEmailList(2131755136, 2131755138, mTo, false, mExpandedDetailsView);
        renderEmailList(2131755139, 2131755141, mCc, false, mExpandedDetailsView);
        renderEmailList(2131755142, 2131755144, mBcc, false, mExpandedDetailsView);
        mExpandedDetailsValid = true;
      }
      return bool;
    }
  }
  
  private com.android.mail.providers.Account getAccount()
  {
    return mAccountController.getAccount();
  }
  
  private Address getAddress(String paramString)
  {
    return getAddress(mAddressCache, paramString);
  }
  
  private static Address getAddress(Map<String, Address> paramMap, String paramString)
  {
    Address localAddress1 = null;
    if (paramMap != null) {
      localAddress1 = (Address)paramMap.get(paramString);
    }
    Address localAddress2 = localAddress1;
    if (localAddress1 == null)
    {
      localAddress1 = Address.getEmailAddress(paramString);
      localAddress2 = localAddress1;
      if (paramMap != null)
      {
        paramMap.put(paramString, localAddress1);
        localAddress2 = localAddress1;
      }
    }
    return localAddress2;
  }
  
  private CharSequence getHeaderSubtitle()
  {
    if (mIsSending) {
      return null;
    }
    if (isExpanded())
    {
      if (mMessage.viaDomain != null) {
        return getResources().getString(2131493108, new Object[] { mMessage.viaDomain });
      }
      return getSenderAddress(mSender);
    }
    return mSnippet;
  }
  
  private CharSequence getHeaderTitle()
  {
    if (mIsDraft) {
      return getResources().getQuantityText(2131820546, 1);
    }
    if (mIsSending) {
      return getResources().getString(2131493017);
    }
    return getSenderName(mSender);
  }
  
  private AsyncQueryHandler getQueryHandler()
  {
    if (mQueryHandler == null) {
      mQueryHandler = new AsyncQueryHandler(getContext().getContentResolver()) {};
    }
    return mQueryHandler;
  }
  
  static CharSequence getRecipientSummaryText(Context paramContext, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, Map<String, Address> paramMap)
  {
    paramContext = new RecipientListsBuilder(paramContext, paramString, paramMap);
    paramContext.append(paramArrayOfString1, 2131493054);
    paramContext.append(paramArrayOfString2, 2131493055);
    paramContext.append(paramArrayOfString3, 2131493056);
    return paramContext.build();
  }
  
  private static CharSequence getSenderAddress(Address paramAddress)
  {
    if (paramAddress == null) {}
    for (String str = ""; TextUtils.isEmpty(str); str = paramAddress.getName()) {
      return null;
    }
    return paramAddress.getAddress();
  }
  
  private static CharSequence getSenderName(Address paramAddress)
  {
    String str2 = paramAddress.getName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramAddress.getAddress();
    }
    return str1;
  }
  
  private void handleShowImagePromptClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    if (localInteger == null) {
      return;
    }
    switch (localInteger.intValue())
    {
    default: 
      return;
    case 1: 
      if (mCallbacks != null) {
        mCallbacks.showExternalResources(mMessage);
      }
      ((ImageView)paramView.findViewById(2131755156)).setContentDescription(getResources().getString(2131493058));
      ((TextView)paramView.findViewById(2131755157)).setText(2131493058);
      paramView.setTag(Integer.valueOf(2));
      updateSpacerHeight();
      return;
    }
    mMessage.markAlwaysShowImages(getQueryHandler(), 0, null);
    mShowImagePrompt = false;
    paramView.setTag(null);
    paramView.setVisibility(8);
    updateSpacerHeight();
    Toast.makeText(getContext(), 2131493059, 0).show();
  }
  
  private void hideCollapsedDetails()
  {
    if (mCollapsedDetailsView != null) {
      mCollapsedDetailsView.setVisibility(8);
    }
  }
  
  private void hideDetailsPopup()
  {
    if (mDetailsPopup != null) {
      mDetailsPopup.hide();
    }
  }
  
  private void hideExpandedDetails()
  {
    if (mExpandedDetailsView != null) {
      mExpandedDetailsView.setVisibility(8);
    }
  }
  
  private void hideInvite()
  {
    if (mInviteView != null) {
      mInviteView.setVisibility(8);
    }
  }
  
  private void hideShowImagePrompt()
  {
    if (mImagePromptView != null) {
      mImagePromptView.setVisibility(8);
    }
  }
  
  private void hideSpamWarning()
  {
    if (mSpamWarningView != null) {
      mSpamWarningView.setVisibility(8);
    }
  }
  
  static String makeSnippet(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramString = new StringReader(paramString);
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.read();
        if ((j != -1) && (localStringBuilder.length() < 100))
        {
          i = j;
          if (Character.isWhitespace(j))
          {
            localStringBuilder.append(' ');
            j = paramString.read();
            boolean bool = Character.isWhitespace(j);
            if (bool) {
              continue;
            }
            i = j;
            if (j != -1) {}
          }
        }
        else
        {
          return localStringBuilder.toString();
        }
        if (i == 60)
        {
          i = paramString.read();
          if (i != -1) {
            if (i != 62) {
              continue;
            }
          }
        }
        else if (i == 38)
        {
          localObject = new StringBuilder();
          i = paramString.read();
          if ((i == -1) || (i == 59))
          {
            localObject = ((StringBuilder)localObject).toString();
            if ("nbsp".equals(localObject))
            {
              localStringBuilder.append(' ');
              break label378;
            }
          }
          else
          {
            ((StringBuilder)localObject).append((char)i);
            continue;
          }
        }
      }
      catch (IOException paramString)
      {
        Object localObject;
        LogUtils.wtf(LOG_TAG, paramString, "Really? IOException while reading a freaking string?!? ", new Object[0]);
        continue;
        if ("lt".equals(localObject))
        {
          localStringBuilder.append('<');
        }
        else if ("gt".equals(localObject))
        {
          localStringBuilder.append('>');
        }
        else if ("amp".equals(localObject))
        {
          localStringBuilder.append('&');
        }
        else if ("quot".equals(localObject))
        {
          localStringBuilder.append('"');
        }
        else if (("apos".equals(localObject)) || ("#39".equals(localObject)))
        {
          localStringBuilder.append('\'');
        }
        else
        {
          localStringBuilder.append('&').append((String)localObject);
          if (i == 59)
          {
            localStringBuilder.append(';');
            break label378;
            localStringBuilder.append((char)i);
            continue;
            if (i != -1) {
              continue;
            }
            continue;
          }
        }
      }
      label378:
      if (i != -1) {}
    }
  }
  
  private int measureHeight()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup == null)
    {
      LogUtils.e(LOG_TAG, new Error(), "Unable to measure height of detached header", new Object[0]);
      return getHeight();
    }
    mPreMeasuring = true;
    int i = Utils.measureViewHeight(this, localViewGroup);
    mPreMeasuring = false;
    return i;
  }
  
  private void registerMessageClickTargets(int... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = findViewById(paramVarArgs[i]);
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      i += 1;
    }
  }
  
  private void render(boolean paramBoolean)
  {
    boolean bool = false;
    Timer localTimer = new Timer();
    localTimer.start("message header render");
    mCollapsedDetailsValid = false;
    mExpandedDetailsValid = false;
    mMessage = mMessageHeaderItem.getMessage();
    mShowImagePrompt = mMessage.shouldShowImagePrompt();
    setExpanded(mMessageHeaderItem.isExpanded());
    mTimestampMs = mMessage.dateReceivedMs;
    mTimestampShort = mMessageHeaderItem.timestampShort;
    if (mTimestampShort == null)
    {
      mTimestampShort = mDateBuilder.formatShortDate(mTimestampMs);
      mMessageHeaderItem.timestampShort = mTimestampShort;
    }
    mFrom = mMessage.getFromAddresses();
    mTo = mMessage.getToAddresses();
    mCc = mMessage.getCcAddresses();
    mBcc = mMessage.getBccAddresses();
    mReplyTo = mMessage.getReplyToAddresses();
    if (mMessage.draftType != 0) {
      bool = true;
    }
    mIsDraft = bool;
    mIsSending = mMessage.isSending;
    Object localObject2 = mMessage.from;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = getAccountname;
    }
    mSender = getAddress((String)localObject1);
    updateChildVisibility();
    int i;
    if ((mIsDraft) || (mIsSending))
    {
      mSnippet = makeSnippet(mMessage.snippet);
      mSenderNameView.setText(getHeaderTitle());
      mSenderEmailView.setText(getHeaderSubtitle());
      if (mUpperDateView != null) {
        mUpperDateView.setText(mTimestampShort);
      }
      mStarView.setSelected(mMessage.starred);
      localObject1 = mStarView;
      localObject2 = getResources();
      if (!mStarView.isSelected()) {
        break label394;
      }
      i = 2131492927;
      label352:
      ((ImageView)localObject1).setContentDescription(((Resources)localObject2).getString(i));
      if (!paramBoolean) {
        break label401;
      }
      unbind();
    }
    for (;;)
    {
      localTimer.pause("message header render");
      return;
      mSnippet = mMessage.snippet;
      break;
      label394:
      i = 2131492926;
      break label352;
      label401:
      updateContactInfo();
      if (!mObservingContactInfo)
      {
        mContactInfoSource.registerObserver(mContactInfoObserver);
        mObservingContactInfo = true;
      }
    }
  }
  
  private void renderEmailList(int paramInt1, int paramInt2, String[] paramArrayOfString, boolean paramBoolean, View paramView)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      return;
    }
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      Object localObject = getAddress(paramArrayOfString[i]);
      String str = ((Address)localObject).getName();
      localObject = ((Address)localObject).getAddress();
      if ((str == null) || (str.length() == 0)) {
        arrayOfString[i] = localObject;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramBoolean) {
          arrayOfString[i] = getResources().getString(2131493061, new Object[] { str, localObject, mMessage.viaDomain });
        } else {
          arrayOfString[i] = getResources().getString(2131493060, new Object[] { str, localObject });
        }
      }
    }
    ((TextView)paramView.findViewById(paramInt2)).setText(TextUtils.join("\n", arrayOfString));
    paramView.findViewById(paramInt1).setVisibility(0);
  }
  
  private static void setChildMarginRight(View paramView, int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    rightMargin = paramInt;
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void setChildVisibility(int paramInt, View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  private void setExpanded(boolean paramBoolean)
  {
    setActivated(paramBoolean);
    if (mMessageHeaderItem != null) {
      mMessageHeaderItem.setExpanded(paramBoolean);
    }
  }
  
  private void setMessageDetailsExpanded(boolean paramBoolean)
  {
    if (mExpandMode == 0) {
      if (paramBoolean)
      {
        showExpandedDetails();
        hideCollapsedDetails();
      }
    }
    for (;;)
    {
      if (mMessageHeaderItem != null) {
        mMessageHeaderItem.detailsExpanded = paramBoolean;
      }
      return;
      hideExpandedDetails();
      showCollapsedDetails();
      continue;
      if (mExpandMode == 1) {
        if (paramBoolean)
        {
          showDetailsPopup();
        }
        else
        {
          hideDetailsPopup();
          showCollapsedDetails();
        }
      }
    }
  }
  
  private void setReplyOrReplyAllVisible()
  {
    int k = 8;
    if (mIsDraft)
    {
      setChildVisibility(8, new View[] { mReplyButton, mReplyAllButton });
      return;
    }
    if (mOverflowButton == null)
    {
      setChildVisibility(0, new View[] { mReplyButton, mReplyAllButton });
      return;
    }
    int i;
    if (getAccountsettings.replyBehavior == 1)
    {
      i = 1;
      if (i == 0) {
        break label135;
      }
    }
    label135:
    for (int j = 8;; j = 0)
    {
      setChildVisibility(j, new View[] { mReplyButton });
      j = k;
      if (i != 0) {
        j = 0;
      }
      setChildVisibility(j, new View[] { mReplyAllButton });
      return;
      i = 0;
      break;
    }
  }
  
  private void showCollapsedDetails()
  {
    if (mCollapsedDetailsView == null)
    {
      mCollapsedDetailsView = ((ViewGroup)mInflater.inflate(2130968616, this, false));
      addView(mCollapsedDetailsView, indexOfChild(mUpperHeaderView) + 1);
      mCollapsedDetailsView.setOnClickListener(this);
    }
    if (!mCollapsedDetailsValid)
    {
      if (mMessageHeaderItem.recipientSummaryText == null) {
        mMessageHeaderItem.recipientSummaryText = getRecipientSummaryText(getContext(), getAccountname, mTo, mCc, mBcc, mAddressCache);
      }
      ((TextView)findViewById(2131755125)).setText(mMessageHeaderItem.recipientSummaryText);
      ((TextView)findViewById(2131755126)).setText(mTimestampShort);
      mCollapsedDetailsValid = true;
    }
    mCollapsedDetailsView.setVisibility(0);
  }
  
  private void showDetailsPopup()
  {
    ensureExpandedDetailsView();
    if (mDetailsPopup == null)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext());
      mExpandedDetailsView.findViewById(2131755145).setVisibility(8);
      localBuilder.setView(mExpandedDetailsView).setCancelable(true).setTitle(getContext().getString(2131493129));
      mDetailsPopup = localBuilder.show();
      return;
    }
    mDetailsPopup.show();
  }
  
  private void showExpandedDetails()
  {
    if (ensureExpandedDetailsView()) {
      addView(mExpandedDetailsView, indexOfChild(mUpperHeaderView) + 1);
    }
    mExpandedDetailsView.setVisibility(0);
  }
  
  private void showImagePrompt()
  {
    if (mImagePromptView == null)
    {
      ViewGroup localViewGroup = (ViewGroup)mInflater.inflate(2130968621, this, false);
      addView(localViewGroup);
      localViewGroup.setOnClickListener(this);
      localViewGroup.setTag(Integer.valueOf(1));
      mImagePromptView = localViewGroup;
    }
    mImagePromptView.setVisibility(0);
  }
  
  private void showInvite()
  {
    if (mInviteView == null)
    {
      mInviteView = ((MessageInviteView)mInflater.inflate(2130968620, this, false));
      addView(mInviteView);
    }
    mInviteView.bind(mMessage);
    mInviteView.setVisibility(0);
  }
  
  private void showSpamWarning()
  {
    if (mSpamWarningView == null)
    {
      mSpamWarningView = ((SpamWarningView)mInflater.inflate(2130968622, this, false));
      addView(mSpamWarningView);
    }
    mSpamWarningView.showSpamWarning(mMessage, mSender);
  }
  
  private void toggleMessageDetails(View paramView)
  {
    int i = measureHeight();
    if (paramView == mCollapsedDetailsView) {}
    for (boolean bool = true;; bool = false)
    {
      setMessageDetailsExpanded(bool);
      updateSpacerHeight();
      if (mCallbacks != null) {
        mCallbacks.setMessageDetailsExpanded(mMessageHeaderItem, bool, i);
      }
      return;
    }
  }
  
  private void updateChildVisibility()
  {
    if (isExpanded())
    {
      int j;
      if (mIsSnappy)
      {
        i = 8;
        setMessageDetailsVisibility(i);
        if (!mIsDraft) {
          break label159;
        }
        j = 8;
      }
      for (i = 0;; i = 8)
      {
        setReplyOrReplyAllVisible();
        setChildVisibility(j, new View[] { mPhotoView, mPhotoSpacerView, mForwardButton, mSenderEmailView, mOverflowButton });
        setChildVisibility(i, new View[] { mDraftIcon, mEditDraftButton });
        setChildVisibility(8, new View[] { mAttachmentIcon, mUpperDateView });
        setChildVisibility(0, new View[] { mStarView });
        setChildMarginRight(mTitleContainerView, 0);
        return;
        i = 0;
        break;
        label159:
        j = 0;
      }
    }
    setMessageDetailsVisibility(8);
    setChildVisibility(0, new View[] { mSenderEmailView, mUpperDateView });
    setChildVisibility(8, new View[] { mEditDraftButton, mReplyButton, mReplyAllButton, mForwardButton });
    setChildVisibility(8, new View[] { mOverflowButton });
    if (mMessage.hasAttachments) {}
    for (int i = 0;; i = 8)
    {
      setChildVisibility(i, new View[] { mAttachmentIcon });
      setChildVisibility(mCollapsedStarVis, new View[] { mStarView });
      setChildMarginRight(mTitleContainerView, mTitleContainerCollapsedMarginRight);
      if (!mIsDraft) {
        break;
      }
      setChildVisibility(0, new View[] { mDraftIcon });
      setChildVisibility(8, new View[] { mPhotoView, mPhotoSpacerView });
      return;
    }
    setChildVisibility(8, new View[] { mDraftIcon });
    setChildVisibility(0, new View[] { mPhotoView, mPhotoSpacerView });
  }
  
  private void updateContactInfo()
  {
    mPresenceView.setImageDrawable(null);
    mPresenceView.setVisibility(8);
    if ((mContactInfoSource == null) || (mSender == null))
    {
      mPhotoView.setImageToDefault();
      mPhotoView.setContentDescription(getResources().getString(2131493048));
    }
    label262:
    label273:
    for (;;)
    {
      return;
      Object localObject = getResources();
      String str;
      int j;
      if (!TextUtils.isEmpty(mSender.getName()))
      {
        str = mSender.getName();
        str = ((Resources)localObject).getString(2131493047, new Object[] { str });
        mPhotoView.setContentDescription(str);
        j = 0;
        int i = 0;
        localObject = mSender.getAddress();
        ContactInfo localContactInfo = mContactInfoSource.getContactInfo((String)localObject);
        if (localContactInfo == null) {
          break label262;
        }
        mPhotoView.assignContactUri(contactUri);
        if (photo != null)
        {
          mPhotoView.setImageBitmap(photo);
          String.format(str, new Object[] { mSender.getName() });
          i = 1;
        }
        j = i;
        if (!mIsDraft)
        {
          j = i;
          if (status != null)
          {
            mPresenceView.setImageResource(ContactsContract.StatusUpdates.getPresenceIconResourceId(status.intValue()));
            mPresenceView.setVisibility(0);
            j = i;
          }
        }
      }
      for (;;)
      {
        if (j != 0) {
          break label273;
        }
        mPhotoView.setImageToDefault();
        return;
        str = mSender.getAddress();
        break;
        mPhotoView.assignContactFromEmail((String)localObject, true);
      }
    }
  }
  
  private void updateSpacerHeight()
  {
    int i = measureHeight();
    mMessageHeaderItem.setHeight(i);
    if (mCallbacks != null) {
      mCallbacks.setMessageSpacerHeight(mMessageHeaderItem, i);
    }
  }
  
  public void bind(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, boolean paramBoolean)
  {
    if ((mMessageHeaderItem != null) && (mMessageHeaderItem == paramMessageHeaderItem)) {
      return;
    }
    mMessageHeaderItem = paramMessageHeaderItem;
    render(paramBoolean);
  }
  
  public void hideMessageDetails()
  {
    setMessageDetailsVisibility(8);
  }
  
  public void initialize(FormattedDateBuilder paramFormattedDateBuilder, ConversationViewAdapter.ConversationAccountController paramConversationAccountController, Map<String, Address> paramMap)
  {
    mDateBuilder = paramFormattedDateBuilder;
    mAccountController = paramConversationAccountController;
    mAddressCache = paramMap;
  }
  
  public boolean isExpanded()
  {
    return (mMessageHeaderItem == null) || (mMessageHeaderItem.isExpanded());
  }
  
  public void onClick(View paramView)
  {
    onClick(paramView, paramView.getId());
  }
  
  public boolean onClick(View paramView, int paramInt)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    if (mMessage == null)
    {
      LogUtils.i(LOG_TAG, "ignoring message header tap on unbound view", new Object[0]);
      return false;
    }
    boolean bool2 = true;
    switch (paramInt)
    {
    default: 
      LogUtils.i(LOG_TAG, "unrecognized header tap: %d", new Object[] { Integer.valueOf(paramInt) });
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      ComposeActivity.reply(getContext(), getAccount(), mMessage);
      bool1 = bool2;
      continue;
      ComposeActivity.replyAll(getContext(), getAccount(), mMessage);
      bool1 = bool2;
      continue;
      ComposeActivity.forward(getContext(), getAccount(), mMessage);
      bool1 = bool2;
      continue;
      if (!paramView.isSelected()) {}
      for (;;)
      {
        paramView.setSelected(bool1);
        mMessage.star(bool1);
        bool1 = bool2;
        break;
        bool1 = false;
      }
      ComposeActivity.editDraft(getContext(), getAccount(), mMessage);
      bool1 = bool2;
      continue;
      if (mPopup == null)
      {
        mPopup = new PopupMenu(getContext(), paramView);
        mPopup.getMenuInflater().inflate(2131886090, mPopup.getMenu());
        mPopup.setOnMenuItemClickListener(this);
      }
      if (getAccountsettings.replyBehavior == 1)
      {
        bool1 = true;
        label331:
        mPopup.getMenu().findItem(2131755169).setVisible(bool1);
        paramView = mPopup.getMenu().findItem(2131755170);
        if (bool1) {
          break label402;
        }
      }
      label402:
      for (bool1 = bool3;; bool1 = false)
      {
        paramView.setVisible(bool1);
        mPopup.show();
        bool1 = bool2;
        break;
        bool1 = false;
        break label331;
      }
      toggleMessageDetails(paramView);
      bool1 = bool2;
      continue;
      toggleExpanded();
      bool1 = bool2;
      continue;
      handleShowImagePromptClick(paramView);
      bool1 = bool2;
    }
  }
  
  public void onDetachedFromParent()
  {
    unbind();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mUpperHeaderView = ((ViewGroup)findViewById(2131755148));
    mSenderNameView = ((TextView)findViewById(2131755176));
    mSenderEmailView = ((TextView)findViewById(2131755178));
    mPhotoView = ((QuickContactBadge)findViewById(2131755165));
    mPhotoSpacerView = findViewById(2131755166);
    mReplyButton = findViewById(2131755169);
    mReplyAllButton = findViewById(2131755170);
    mForwardButton = findViewById(2131755172);
    mStarView = ((ImageView)findViewById(2131755104));
    mPresenceView = ((ImageView)findViewById(2131755177));
    mTitleContainerView = ((ViewGroup)findViewById(2131755173));
    mOverflowButton = findViewById(2131755119);
    mDraftIcon = findViewById(2131755167);
    mEditDraftButton = findViewById(2131755171);
    mUpperDateView = ((TextView)findViewById(2131755174));
    mAttachmentIcon = findViewById(2131755175);
    mCollapsedStarVis = mStarView.getVisibility();
    mTitleContainerCollapsedMarginRight = mTitleContainerView.getLayoutParams()).rightMargin;
    mBottomBorderView = findViewById(2131755149);
    mLeftSpacer = findViewById(2131755164);
    mRightSpacer = findViewById(2131755168);
    setExpanded(true);
    registerMessageClickTargets(new int[] { 2131755169, 2131755170, 2131755172, 2131755104, 2131755171, 2131755119, 2131755148 });
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Timer localTimer = new Timer();
    localTimer.start("message header layout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    localTimer.pause("message header layout");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Timer localTimer = new Timer();
    super.onMeasure(paramInt1, paramInt2);
    if (!mPreMeasuring) {
      localTimer.pause("message header measure");
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    mPopup.dismiss();
    return onClick(null, paramMenuItem.getItemId());
  }
  
  public void refresh()
  {
    render(false);
  }
  
  public void setCallbacks(MessageHeaderViewCallbacks paramMessageHeaderViewCallbacks)
  {
    mCallbacks = paramMessageHeaderViewCallbacks;
  }
  
  public void setContactInfoSource(ContactInfoSource paramContactInfoSource)
  {
    mContactInfoSource = paramContactInfoSource;
  }
  
  public void setExpandMode(int paramInt)
  {
    mExpandMode = paramInt;
  }
  
  public void setExpandable(boolean paramBoolean)
  {
    mExpandable = paramBoolean;
  }
  
  public void setMessageDetailsVisibility(int paramInt)
  {
    if (paramInt == 8)
    {
      hideCollapsedDetails();
      hideExpandedDetails();
      hideSpamWarning();
      hideShowImagePrompt();
      hideInvite();
    }
    for (;;)
    {
      if (mBottomBorderView != null) {
        mBottomBorderView.setVisibility(paramInt);
      }
      return;
      setMessageDetailsExpanded(mMessageHeaderItem.detailsExpanded);
      if (mMessage.spamWarningString == null)
      {
        hideSpamWarning();
        label67:
        if (!mShowImagePrompt) {
          break label102;
        }
        showImagePrompt();
      }
      for (;;)
      {
        if (!mMessage.isFlaggedCalendarInvite()) {
          break label109;
        }
        showInvite();
        break;
        showSpamWarning();
        break label67;
        label102:
        hideShowImagePrompt();
      }
      label109:
      hideInvite();
    }
  }
  
  public void setSnappy(boolean paramBoolean)
  {
    mIsSnappy = paramBoolean;
    hideMessageDetails();
    if (paramBoolean)
    {
      setBackgroundDrawable(null);
      mLeftSpacer.setVisibility(0);
      mRightSpacer.setVisibility(0);
      return;
    }
    setBackgroundColor(17170443);
    mLeftSpacer.setVisibility(8);
    mRightSpacer.setVisibility(8);
  }
  
  public void toggleExpanded()
  {
    if (!mExpandable) {
      return;
    }
    if (!isExpanded()) {}
    for (boolean bool = true;; bool = false)
    {
      setExpanded(bool);
      if (!mIsSnappy)
      {
        mSenderNameView.setText(getHeaderTitle());
        mSenderEmailView.setText(getHeaderSubtitle());
      }
      updateChildVisibility();
      int i = measureHeight();
      mMessageHeaderItem.setHeight(i);
      if (mCallbacks == null) {
        break;
      }
      mCallbacks.setMessageExpanded(mMessageHeaderItem, i);
      return;
    }
  }
  
  public void unbind()
  {
    mMessageHeaderItem = null;
    mMessage = null;
    if (mObservingContactInfo)
    {
      mContactInfoSource.unregisterObserver(mContactInfoObserver);
      mObservingContactInfo = false;
    }
  }
  
  public static abstract interface MessageHeaderViewCallbacks
  {
    public abstract void setMessageDetailsExpanded(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, boolean paramBoolean, int paramInt);
    
    public abstract void setMessageExpanded(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, int paramInt);
    
    public abstract void setMessageSpacerHeight(ConversationViewAdapter.MessageHeaderItem paramMessageHeaderItem, int paramInt);
    
    public abstract void showExternalResources(Message paramMessage);
  }
  
  private static class RecipientListsBuilder
  {
    private final Map<String, Address> mAddressCache;
    private final SpannableStringBuilder mBuilder = new SpannableStringBuilder();
    private final CharSequence mComma;
    private final Context mContext;
    boolean mFirst = true;
    private final String mMe;
    int mRecipientCount = 0;
    
    public RecipientListsBuilder(Context paramContext, String paramString, Map<String, Address> paramMap)
    {
      mContext = paramContext;
      mMe = paramString;
      mComma = mContext.getText(2131493073);
      mAddressCache = paramMap;
    }
    
    private CharSequence getSummaryTextForHeading(int paramInt1, String[] paramArrayOfString, int paramInt2)
    {
      if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramInt2 == 0)) {
        localObject = null;
      }
      SpannableStringBuilder localSpannableStringBuilder;
      int i;
      do
      {
        return (CharSequence)localObject;
        localSpannableStringBuilder = new SpannableStringBuilder(mContext.getString(paramInt1));
        localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 33);
        localSpannableStringBuilder.append(' ');
        i = Math.min(paramInt2, paramArrayOfString.length);
        paramInt2 = 1;
        paramInt1 = 0;
        localObject = localSpannableStringBuilder;
      } while (paramInt1 >= i);
      Object localObject = MessageHeaderView.getAddress(mAddressCache, paramArrayOfString[paramInt1]);
      if (mMe.equals(((Address)localObject).getAddress()))
      {
        localObject = mContext.getString(2131493019);
        label125:
        if (paramInt2 == 0) {
          break label156;
        }
        paramInt2 = 0;
      }
      for (;;)
      {
        localSpannableStringBuilder.append((CharSequence)localObject);
        paramInt1 += 1;
        break;
        localObject = ((Address)localObject).getSimplifiedName();
        break label125;
        label156:
        localSpannableStringBuilder.append(mComma);
      }
    }
    
    public void append(String[] paramArrayOfString, int paramInt)
    {
      int i = 50 - mRecipientCount;
      CharSequence localCharSequence = getSummaryTextForHeading(paramInt, paramArrayOfString, i);
      if (localCharSequence != null)
      {
        if (!mFirst) {
          break label60;
        }
        mFirst = false;
      }
      for (;;)
      {
        mBuilder.append(localCharSequence);
        mRecipientCount += Math.min(i, paramArrayOfString.length);
        return;
        label60:
        mBuilder.append("   ");
      }
    }
    
    public CharSequence build()
    {
      return mBuilder;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageHeaderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */