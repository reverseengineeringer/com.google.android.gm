package com.android.mail.browse;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.android.mail.perf.Timer;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider.ConversationColumns;
import com.android.mail.ui.AnimatedAdapter;
import com.android.mail.ui.ControllableActivity;
import com.android.mail.ui.ConversationSelectionSet;
import com.android.mail.ui.FolderDisplayer;
import com.android.mail.ui.SwipeableItemView;
import com.android.mail.ui.SwipeableListView;
import com.android.mail.ui.ViewMode;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import com.google.android.common.html.parser.HtmlParser;
import com.google.android.common.html.parser.HtmlTreeBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;

public class ConversationItemView
  extends View
  implements ToggleableItem, SwipeableItemView
{
  private static Bitmap ATTACHMENT;
  private static Bitmap CHECKMARK_OFF;
  private static Bitmap CHECKMARK_ON;
  private static Bitmap DATE_BACKGROUND;
  private static Bitmap IMPORTANT_ONLY_TO_ME;
  private static Bitmap IMPORTANT_TO_ME_AND_OTHERS;
  private static Bitmap IMPORTANT_TO_OTHERS;
  private static final String LOG_TAG;
  private static Bitmap MORE_FOLDERS;
  private static Bitmap ONLY_TO_ME;
  private static Bitmap STAR_OFF;
  private static Bitmap STAR_ON;
  private static Bitmap STATE_CALENDAR_INVITE;
  private static Bitmap STATE_FORWARDED;
  private static Bitmap STATE_REPLIED;
  private static Bitmap STATE_REPLIED_AND_FORWARDED;
  private static Bitmap TO_ME_AND_OTHERS;
  private static int sActivatedTextColor;
  private static CharacterStyle sActivatedTextSpan;
  private static int sAnimatingBackgroundColor;
  private static Bitmap sDateBackgroundAttachment;
  private static int sDateBackgroundHeight;
  private static Bitmap sDateBackgroundNoAttachment;
  private static int sDateBackgroundPaddingLeft;
  private static int sDateTextColor;
  private static int sDefaultTextColor;
  private static String sElidedPaddingToken;
  private static int sFadedActivatedColor;
  private static TextPaint sFoldersPaint;
  private static HtmlTreeBuilder sHtmlBuilder;
  private static HtmlParser sHtmlParser;
  private static int sLayoutCount = 0;
  private static TextPaint sPaint;
  private static int sScrollSlop;
  private static String sSendersSplitToken;
  private static int sSendersTextColorRead;
  private static int sSendersTextColorUnread;
  private static TextView sSendersTextView;
  private static int sSendersTextViewHeight;
  private static int sSendersTextViewTopPadding;
  private static int sShrinkAnimationDuration;
  private static int sSlideAnimationDuration;
  private static int sSnippetTextColorRead;
  private static int sSnippetTextColorUnread;
  private static int sStandardScaledDimen;
  private static int sSubjectTextColorRead;
  private static int sSubjectTextColorUnead;
  private static TextView sSubjectTextView;
  private static Timer sTimer;
  private static int sTouchSlop;
  private String mAccount;
  private ControllableActivity mActivity;
  private AnimatedAdapter mAdapter;
  private int mAnimatedHeight = -1;
  private int mBackgroundOverride = -1;
  private final SparseArray<Drawable> mBackgrounds = new SparseArray();
  private boolean mCheckboxesEnabled;
  private boolean mChecked = false;
  private final Context mContext;
  ConversationItemViewCoordinates mCoordinates;
  private int mDateX;
  private Folder mDisplayedFolder;
  private boolean mDownEvent;
  private int mFoldersXEnd;
  public ConversationItemViewModel mHeader;
  private int mLastTouchX;
  private int mLastTouchY;
  private int mMode = -1;
  private int mPaperclipX;
  private int mPreviousMode;
  private boolean mPriorityMarkersEnabled;
  private ConversationSelectionSet mSelectedConversationSet;
  private int mSendersWidth;
  private boolean mSwipeEnabled;
  private final boolean mTabletDevice;
  private boolean mTesting = false;
  private int mViewWidth = -1;
  
  static
  {
    LOG_TAG = LogTag.getLogTag();
    sPaint = new TextPaint();
    sFoldersPaint = new TextPaint();
    sFadedActivatedColor = -1;
    sPaint.setAntiAlias(true);
    sFoldersPaint.setAntiAlias(true);
  }
  
  public ConversationItemView(Context paramContext, String paramString)
  {
    super(paramContext);
    setClickable(true);
    setLongClickable(true);
    mContext = paramContext.getApplicationContext();
    mTabletDevice = Utils.useTabletUI(mContext);
    mAccount = paramString;
    paramContext = mContext.getResources();
    if (CHECKMARK_OFF == null)
    {
      CHECKMARK_OFF = BitmapFactory.decodeResource(paramContext, 2130837512);
      CHECKMARK_ON = BitmapFactory.decodeResource(paramContext, 2130837513);
      STAR_OFF = BitmapFactory.decodeResource(paramContext, 2130837516);
      STAR_ON = BitmapFactory.decodeResource(paramContext, 2130837520);
      ONLY_TO_ME = BitmapFactory.decodeResource(paramContext, 2130837571);
      TO_ME_AND_OTHERS = BitmapFactory.decodeResource(paramContext, 2130837574);
      IMPORTANT_ONLY_TO_ME = BitmapFactory.decodeResource(paramContext, 2130837572);
      IMPORTANT_TO_ME_AND_OTHERS = BitmapFactory.decodeResource(paramContext, 2130837575);
      IMPORTANT_TO_OTHERS = BitmapFactory.decodeResource(paramContext, 2130837573);
      ATTACHMENT = BitmapFactory.decodeResource(paramContext, 2130837562);
      MORE_FOLDERS = BitmapFactory.decodeResource(paramContext, 2130837577);
      DATE_BACKGROUND = BitmapFactory.decodeResource(paramContext, 2130837533);
      STATE_REPLIED = BitmapFactory.decodeResource(paramContext, 2130837566);
      STATE_FORWARDED = BitmapFactory.decodeResource(paramContext, 2130837563);
      STATE_REPLIED_AND_FORWARDED = BitmapFactory.decodeResource(paramContext, 2130837565);
      STATE_CALENDAR_INVITE = BitmapFactory.decodeResource(paramContext, 2130837564);
      sDefaultTextColor = paramContext.getColor(2131296260);
      sActivatedTextColor = paramContext.getColor(17170443);
      sActivatedTextSpan = CharacterStyle.wrap(new ForegroundColorSpan(sActivatedTextColor));
      sSubjectTextColorRead = paramContext.getColor(2131296264);
      sSubjectTextColorUnead = paramContext.getColor(2131296261);
      sSnippetTextColorRead = paramContext.getColor(2131296265);
      sSnippetTextColorUnread = paramContext.getColor(2131296262);
      sSendersTextColorRead = paramContext.getColor(2131296266);
      sSendersTextColorUnread = paramContext.getColor(2131296263);
      sDateTextColor = paramContext.getColor(2131296267);
      sDateBackgroundPaddingLeft = paramContext.getDimensionPixelSize(2131427364);
      sTouchSlop = paramContext.getDimensionPixelSize(2131427365);
      sDateBackgroundHeight = paramContext.getDimensionPixelSize(2131427363);
      sStandardScaledDimen = paramContext.getDimensionPixelSize(2131427367);
      sShrinkAnimationDuration = paramContext.getInteger(2131361801);
      sSlideAnimationDuration = paramContext.getInteger(2131361802);
      sSendersSplitToken = paramContext.getString(2131493120);
      sElidedPaddingToken = paramContext.getString(2131493123);
      sAnimatingBackgroundColor = paramContext.getColor(2131296297);
      sSendersTextViewTopPadding = paramContext.getDimensionPixelSize(2131427425);
      sSendersTextViewHeight = paramContext.getDimensionPixelSize(2131427426);
      sScrollSlop = paramContext.getInteger(2131361821);
    }
  }
  
  private void beginDragMode()
  {
    if ((mLastTouchX < 0) || (mLastTouchY < 0)) {
      return;
    }
    if (!mChecked) {
      toggleCheckMark();
    }
    int j = mSelectedConversationSet.size();
    Object localObject = Utils.formatPlural(mContext, 2131820545, j);
    localObject = ClipData.newUri(mContext.getContentResolver(), (CharSequence)localObject, Conversation.MOVE_CONVERSATIONS_URI);
    Iterator localIterator = mSelectedConversationSet.values().iterator();
    while (localIterator.hasNext()) {
      ((ClipData)localObject).addItem(new ClipData.Item(String.valueOf(nextposition)));
    }
    int k = getWidth();
    int m = getHeight();
    if ((k < 0) || (m < 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      LogUtils.e(LOG_TAG, "ConversationItemView: dimension is negative: width=%d, height=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      return;
    }
    mActivity.startDragMode();
    startDrag((ClipData)localObject, new ShadowBuilder(this, j, mLastTouchX, mLastTouchY), null, 0);
  }
  
  private void bind(ConversationItemViewModel paramConversationItemViewModel, ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AnimatedAdapter paramAnimatedAdapter)
  {
    mHeader = paramConversationItemViewModel;
    mActivity = paramControllableActivity;
    mSelectedConversationSet = paramConversationSelectionSet;
    mDisplayedFolder = paramFolder;
    if (!paramBoolean1) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      mCheckboxesEnabled = paramBoolean1;
      mSwipeEnabled = paramBoolean2;
      mPriorityMarkersEnabled = paramBoolean3;
      mAdapter = paramAnimatedAdapter;
      setContentDescription();
      requestLayout();
      return;
    }
  }
  
  private void calculateCoordinates()
  {
    startTimer("CCHV.coordinates");
    sPaint.setTextSize(mCoordinates.dateFontSize);
    sPaint.setTypeface(Typeface.DEFAULT);
    mDateX = (mCoordinates.dateXEnd - (int)sPaint.measureText(mHeader.dateText));
    mPaperclipX = (mDateX - ATTACHMENT.getWidth());
    int j = mContext.getResources().getDimensionPixelSize(2131427368);
    if (ConversationItemViewCoordinates.isWideMode(mMode))
    {
      mFoldersXEnd = mCoordinates.dateXEnd;
      mSendersWidth = mCoordinates.sendersWidth;
      if (mHeader.isLayoutValid(mContext)) {
        pauseTimer("CCHV.coordinates");
      }
    }
    else
    {
      if (mCoordinates.showFolders)
      {
        if (mHeader.paperclip != null) {}
        for (mFoldersXEnd = mPaperclipX;; mFoldersXEnd = (mDateX - j / 2))
        {
          mSendersWidth = (mFoldersXEnd - mCoordinates.sendersX - j * 2);
          if (!mHeader.folderDisplayer.hasVisibleFolders()) {
            break;
          }
          mSendersWidth -= ConversationItemViewCoordinates.getFoldersWidth(mContext, mMode);
          break;
        }
      }
      if (mHeader.paperclip != null) {}
      for (i = mPaperclipX;; i = mDateX)
      {
        mSendersWidth = (i - mCoordinates.sendersX - j);
        break;
      }
    }
    int m = mCoordinates.sendersY - mCoordinates.sendersAscent;
    if (mHeader.styledSenders != null)
    {
      ellipsizeStyledSenders();
      sPaint.setTextSize(mCoordinates.sendersFontSize);
      sPaint.setTypeface(Typeface.DEFAULT);
      if (mSendersWidth < 0) {
        mSendersWidth = 0;
      }
      pauseTimer("CCHV.coordinates");
      return;
    }
    j = 0;
    int i = 0;
    sPaint.setTextSize(mCoordinates.sendersFontSize);
    sPaint.setTypeface(Typeface.DEFAULT);
    Iterator localIterator = mHeader.senderFragments.iterator();
    while (localIterator.hasNext())
    {
      ConversationItemViewModel.SenderFragment localSenderFragment = (ConversationItemViewModel.SenderFragment)localIterator.next();
      CharacterStyle localCharacterStyle = style;
      k = start;
      int n = end;
      localCharacterStyle.updateDrawState(sPaint);
      width = ((int)sPaint.measureText(mHeader.sendersText, k, n));
      k = i;
      if (isFixed) {
        k = i + width;
      }
      j += width;
      i = k;
    }
    int k = m;
    if (!ConversationItemViewCoordinates.displaySendersInline(mMode)) {
      if (j > mSendersWidth) {
        break label588;
      }
    }
    label588:
    for (j = mCoordinates.sendersLineHeight / 2;; j = 0)
    {
      k = m + j;
      if (mSendersWidth < 0) {
        mSendersWidth = 0;
      }
      ellipsize(i, k);
      mHeader.sendersDisplayLayout = new StaticLayout(mHeader.sendersDisplayText, sPaint, mSendersWidth, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  private void calculateTextsAndBitmaps()
  {
    startTimer("CCHV.txtsbmps");
    if (mSelectedConversationSet != null) {
      mChecked = mSelectedConversationSet.contains(mHeader.conversation);
    }
    boolean bool = mCheckboxesEnabled;
    if (mHeader.checkboxVisible != bool) {
      mHeader.checkboxVisible = bool;
    }
    bool = mHeader.unread;
    updateBackground(bool);
    if (mHeader.isLayoutValid(mContext))
    {
      pauseTimer("CCHV.txtsbmps");
      return;
    }
    startTimer("CCHV.folders");
    if (mCoordinates.showFolders)
    {
      mHeader.folderDisplayer = new ConversationItemFolderDisplayer(mContext);
      mHeader.folderDisplayer.loadConversationFolders(mHeader.conversation, mDisplayedFolder);
    }
    pauseTimer("CCHV.folders");
    mHeader.dateText = DateUtils.getRelativeTimeSpanString(mContext, mHeader.conversation.dateMs).toString();
    mHeader.paperclip = null;
    if (mHeader.conversation.hasAttachments) {
      mHeader.paperclip = ATTACHMENT;
    }
    mHeader.personalLevelBitmap = null;
    int j;
    int i;
    label266:
    ConversationItemViewModel localConversationItemViewModel;
    Object localObject;
    if (mCoordinates.showPersonalLevel)
    {
      j = mHeader.conversation.personalLevel;
      if (mHeader.conversation.priority == 1)
      {
        i = 1;
        if ((i == 0) || (!mPriorityMarkersEnabled)) {
          break label485;
        }
        i = 1;
        if (j != 2) {
          break label498;
        }
        localConversationItemViewModel = mHeader;
        if (i == 0) {
          break label490;
        }
        localObject = IMPORTANT_ONLY_TO_ME;
        label286:
        personalLevelBitmap = ((Bitmap)localObject);
      }
    }
    else
    {
      label293:
      startTimer("CCHV.sendersubj");
      layoutSubjectSpans(bool);
      mHeader.sendersDisplayText = new SpannableStringBuilder();
      mHeader.styledSendersString = new SpannableStringBuilder();
      if (mHeader.conversation.conversationInfo == null) {
        break label558;
      }
      localObject = getContext();
      mHeader.messageInfoString = SendersView.createMessageInfo((Context)localObject, mHeader.conversation);
      i = ConversationItemViewCoordinates.getMode((Context)localObject, mActivity.getViewMode());
      if ((mHeader.folderDisplayer == null) || (mHeader.folderDisplayer.mFoldersCount <= 0)) {
        break label553;
      }
      bool = true;
      label410:
      i = ConversationItemViewCoordinates.getSubjectLength((Context)localObject, i, bool, mHeader.conversation.hasAttachments);
      mHeader.styledSenders = SendersView.format((Context)localObject, mHeader.conversation.conversationInfo, mHeader.messageInfoString.toString(), i, getParser(), getBuilder());
    }
    for (;;)
    {
      pauseTimer("CCHV.sendersubj");
      pauseTimer("CCHV.txtsbmps");
      return;
      i = 0;
      break;
      label485:
      i = 0;
      break label266;
      label490:
      localObject = ONLY_TO_ME;
      break label286;
      label498:
      if (j == 1)
      {
        localConversationItemViewModel = mHeader;
        if (i != 0) {}
        for (localObject = IMPORTANT_TO_ME_AND_OTHERS;; localObject = TO_ME_AND_OTHERS)
        {
          personalLevelBitmap = ((Bitmap)localObject);
          break;
        }
      }
      if (i == 0) {
        break label293;
      }
      mHeader.personalLevelBitmap = IMPORTANT_TO_OTHERS;
      break label293;
      label553:
      bool = false;
      break label410;
      label558:
      SendersView.formatSenders(mHeader, getContext());
    }
  }
  
  private boolean canFitFragment(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == mCoordinates.sendersLineCount) {
      if (paramInt1 + paramInt3 > mSendersWidth) {}
    }
    while (paramInt1 <= mSendersWidth)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private SpannableString copyStyles(CharacterStyle[] paramArrayOfCharacterStyle, CharSequence paramCharSequence)
  {
    paramCharSequence = new SpannableString(paramCharSequence);
    if ((paramArrayOfCharacterStyle != null) && (paramArrayOfCharacterStyle.length > 0)) {
      paramCharSequence.setSpan(paramArrayOfCharacterStyle[0], 0, paramCharSequence.length(), 0);
    }
    return paramCharSequence;
  }
  
  private ObjectAnimator createHeightAnimation(boolean paramBoolean)
  {
    int i = ConversationItemViewCoordinates.getMinHeight(getContext(), mActivity.getViewMode());
    int j;
    if (paramBoolean)
    {
      j = 0;
      if (!paramBoolean) {
        break label78;
      }
    }
    for (;;)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofInt(this, "animatedHeight", new int[] { j, i });
      localObjectAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
      localObjectAnimator.setDuration(sShrinkAnimationDuration);
      return localObjectAnimator;
      j = i;
      break;
      label78:
      i = 0;
    }
  }
  
  private SpannableStringBuilder createSubject(boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = filterTag(mHeader.conversation.subject);
    String str2 = mHeader.conversation.getSnippet();
    int i;
    int j;
    if (paramBoolean2)
    {
      i = sActivatedTextColor;
      if (!paramBoolean2) {
        break label166;
      }
      j = sActivatedTextColor;
    }
    for (;;)
    {
      SpannableStringBuilder localSpannableStringBuilder = Conversation.getSubjectAndSnippetForDisplay(mContext, str1, str2);
      if (paramBoolean1) {
        localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, str1.length(), 33);
      }
      if (str1 != null) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, str1.length(), 33);
      }
      if (!TextUtils.isEmpty(str2)) {
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(j), str1.length() + 1, localSpannableStringBuilder.length(), 33);
      }
      return localSpannableStringBuilder;
      if (paramBoolean1)
      {
        i = sSubjectTextColorUnead;
        break;
      }
      i = sSubjectTextColorRead;
      break;
      label166:
      if (paramBoolean1) {
        j = sSnippetTextColorUnread;
      } else {
        j = sSnippetTextColorRead;
      }
    }
  }
  
  private ObjectAnimator createTranslateXAnimation(boolean paramBoolean)
  {
    float f2 = 0.0F;
    Object localObject = getListView();
    int i;
    float f1;
    if (localObject != null)
    {
      i = ((SwipeableListView)localObject).getMeasuredWidth();
      if (!paramBoolean) {
        break label84;
      }
      f1 = i;
      label28:
      if (!paramBoolean) {
        break label89;
      }
    }
    for (;;)
    {
      localObject = ObjectAnimator.ofFloat(this, "translationX", new float[] { f1, f2 });
      ((ObjectAnimator)localObject).setInterpolator(new DecelerateInterpolator(2.0F));
      ((ObjectAnimator)localObject).setDuration(sSlideAnimationDuration);
      return (ObjectAnimator)localObject;
      i = 0;
      break;
      label84:
      f1 = 0.0F;
      break label28;
      label89:
      f2 = i;
    }
  }
  
  private void drawSenders(Canvas paramCanvas)
  {
    paramCanvas.translate(mCoordinates.sendersX, mCoordinates.sendersY + sSendersTextViewTopPadding);
    mHeader.sendersTextView = getSendersTextView();
    if (mHeader.styledSendersString != null)
    {
      if ((!isActivated()) || (!showActivatedText())) {
        break label158;
      }
      mHeader.styledSendersString.setSpan(sActivatedTextSpan, 0, mHeader.styledMessageInfoStringOffset, 33);
    }
    for (;;)
    {
      mHeader.sendersTextView.setText(mHeader.styledSendersString, TextView.BufferType.SPANNABLE);
      int i = View.MeasureSpec.makeMeasureSpec(mSendersWidth, 1073741824);
      mHeader.sendersTextView.measure(i, sSendersTextViewHeight);
      mHeader.sendersTextView.layout(0, 0, mSendersWidth, sSendersTextViewHeight);
      mHeader.sendersTextView.draw(paramCanvas);
      return;
      label158:
      mHeader.styledSendersString.removeSpan(sActivatedTextSpan);
    }
  }
  
  private void drawSubject(Canvas paramCanvas)
  {
    TextView localTextView = getSubjectTextView();
    int i = mCoordinates.subjectWidth;
    int j = (int)(localTextView.getLineHeight() * 2 + sPaint.descent());
    sPaint.setTextSize(mCoordinates.subjectFontSize);
    if ((isActivated()) && (showActivatedText())) {
      mHeader.subjectText.setSpan(sActivatedTextSpan, 0, mHeader.subjectText.length(), 33);
    }
    for (;;)
    {
      paramCanvas.translate(mCoordinates.subjectX, mCoordinates.subjectY + sSendersTextViewTopPadding);
      localTextView.setText(mHeader.subjectText, TextView.BufferType.SPANNABLE);
      localTextView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), j);
      localTextView.layout(0, 0, i, j);
      localTextView.draw(paramCanvas);
      return;
      mHeader.subjectText.removeSpan(sActivatedTextSpan);
    }
  }
  
  private void drawText(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    paramCanvas.drawText(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, paramTextPaint);
  }
  
  private int ellipsize(int paramInt1, int paramInt2)
  {
    int m = 0;
    int j = 1;
    int k = 0;
    Iterator localIterator = mHeader.senderFragments.iterator();
    int i = paramInt2;
    int n = paramInt1;
    paramInt2 = m;
    paramInt1 = k;
    while (localIterator.hasNext())
    {
      ConversationItemViewModel.SenderFragment localSenderFragment = (ConversationItemViewModel.SenderFragment)localIterator.next();
      Object localObject = style;
      int i5 = start;
      int i6 = end;
      int i4 = width;
      boolean bool = isFixed;
      ((CharacterStyle)localObject).updateDrawState(sPaint);
      if ((paramInt1 != 0) && (!bool))
      {
        shouldDisplay = false;
      }
      else
      {
        ellipsizedText = null;
        k = n;
        if (bool) {
          k = n - i4;
        }
        n = j;
        int i1 = paramInt1;
        int i2 = paramInt2;
        int i3 = i4;
        m = i;
        if (!canFitFragment(paramInt2 + i4, j, k))
        {
          if (paramInt2 != 0) {
            break label384;
          }
          paramInt1 = 1;
          label175:
          n = j;
          i1 = paramInt1;
          i2 = paramInt2;
          i3 = i4;
          m = i;
          if (paramInt1 != 0)
          {
            n = mSendersWidth - paramInt2;
            m = n;
            if (j == mCoordinates.sendersLineCount) {
              m = n - k;
            }
            ellipsizedText = TextUtils.ellipsize(mHeader.sendersText.substring(i5, i6), sPaint, m, TextUtils.TruncateAt.END).toString();
            i3 = (int)sPaint.measureText(ellipsizedText);
            m = i;
            i2 = paramInt2;
            i1 = paramInt1;
            n = j;
          }
        }
        shouldDisplay = true;
        paramInt2 = i2 + i3;
        if (ellipsizedText != null) {}
        for (localObject = ellipsizedText;; localObject = mHeader.sendersText.substring(i5, i6))
        {
          paramInt1 = mHeader.sendersDisplayText.length();
          mHeader.sendersDisplayText.append((CharSequence)localObject);
          mHeader.sendersDisplayText.setSpan(style, paramInt1, mHeader.sendersDisplayText.length(), 33);
          j = n;
          paramInt1 = i1;
          n = k;
          i = m;
          break;
          label384:
          if (j < mCoordinates.sendersLineCount)
          {
            m = j + 1;
            n = i + mCoordinates.sendersLineHeight;
            i1 = 0;
            j = m;
            paramInt2 = i1;
            i = n;
            if (0 + i4 <= mSendersWidth) {
              break label175;
            }
            paramInt1 = 1;
            j = m;
            paramInt2 = i1;
            i = n;
            break label175;
          }
          paramInt1 = 1;
          break label175;
        }
      }
    }
    return paramInt2;
  }
  
  private int ellipsizeStyledSenders()
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder();
    int i = 0;
    SpannableStringBuilder localSpannableStringBuilder2 = mHeader.messageInfoString;
    Object localObject1;
    if (localSpannableStringBuilder2.length() > 0)
    {
      localObject1 = (CharacterStyle[])localSpannableStringBuilder2.getSpans(0, localSpannableStringBuilder2.length(), CharacterStyle.class);
      if (localObject1.length > 0) {
        localObject1[0].updateDrawState(sPaint);
      }
    }
    for (float f1 = sPaint.measureText(localSpannableStringBuilder2.toString()) + 0.0F;; f1 = 0.0F)
    {
      SpannableString[] arrayOfSpannableString = mHeader.styledSenders;
      int k = arrayOfSpannableString.length;
      int j = 0;
      localObject1 = null;
      SpannableString localSpannableString;
      while (j < k)
      {
        localSpannableString = arrayOfSpannableString[j];
        if (localSpannableString == null) {
          j += 1;
        } else {
          if (i == 0) {
            break label166;
          }
        }
      }
      mHeader.styledMessageInfoStringOffset = localSpannableStringBuilder1.length();
      if (localSpannableStringBuilder2 != null) {
        localSpannableStringBuilder1.append(localSpannableStringBuilder2);
      }
      mHeader.styledSendersString = localSpannableStringBuilder1;
      return (int)f1;
      label166:
      Object localObject2 = (CharacterStyle[])localSpannableString.getSpans(0, localSpannableString.length(), CharacterStyle.class);
      if (localObject2.length > 0) {
        localObject2[0].updateDrawState(sPaint);
      }
      label250:
      float f2;
      if (SendersView.sElidedString.equals(localSpannableString.toString()))
      {
        localObject1 = copyStyles((CharacterStyle[])localObject2, sElidedPaddingToken + localSpannableString + sElidedPaddingToken);
        if (localObject2.length > 0) {
          localObject2[0].updateDrawState(sPaint);
        }
        f2 = (int)sPaint.measureText(((SpannableString)localObject1).toString());
        if (f2 + f1 <= mSendersWidth) {
          break label430;
        }
        f2 = mSendersWidth;
        localObject2 = copyStyles((CharacterStyle[])localObject2, TextUtils.ellipsize((CharSequence)localObject1, sPaint, f2 - f1, TextUtils.TruncateAt.END));
        f2 = (int)sPaint.measureText(((SpannableString)localObject2).toString());
        i = 1;
      }
      for (;;)
      {
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        localSpannableStringBuilder1.append((CharSequence)localObject1);
        f1 += f2;
        localObject1 = localSpannableString;
        break;
        if ((localSpannableStringBuilder1.length() > 0) && ((localObject1 == null) || (!SendersView.sElidedString.equals(((SpannableString)localObject1).toString()))))
        {
          localObject1 = copyStyles((CharacterStyle[])localObject2, sSendersSplitToken + localSpannableString);
          break label250;
        }
        localObject1 = localSpannableString;
        break label250;
        label430:
        localObject2 = null;
      }
    }
  }
  
  private String filterTag(String paramString)
  {
    String str2 = getContext().getResources().getString(2131493015);
    String str1 = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str1 = paramString;
      if (paramString.charAt(0) == '[')
      {
        int i = paramString.indexOf(']');
        str1 = paramString;
        if (i > 0) {
          str1 = String.format(str2, new Object[] { Utils.ellipsize(paramString.substring(1, i), 7), paramString.substring(i + 1) });
        }
      }
    }
    return str1;
  }
  
  private static HtmlTreeBuilder getBuilder()
  {
    if (sHtmlBuilder == null) {
      sHtmlBuilder = new HtmlTreeBuilder();
    }
    return sHtmlBuilder;
  }
  
  private Bitmap getDateBackground(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = mPaperclipX;; i = mDateX)
    {
      i -= sDateBackgroundPaddingLeft;
      if (!paramBoolean) {
        break;
      }
      if (sDateBackgroundAttachment == null) {
        sDateBackgroundAttachment = Bitmap.createScaledBitmap(DATE_BACKGROUND, mViewWidth - i, sDateBackgroundHeight, false);
      }
      return sDateBackgroundAttachment;
    }
    if (sDateBackgroundNoAttachment == null) {
      sDateBackgroundNoAttachment = Bitmap.createScaledBitmap(DATE_BACKGROUND, mViewWidth - i, sDateBackgroundHeight, false);
    }
    return sDateBackgroundNoAttachment;
  }
  
  private int getFontColor(int paramInt)
  {
    if ((isActivated()) && (showActivatedText())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramInt = sActivatedTextColor;
      }
      return paramInt;
    }
  }
  
  private SwipeableListView getListView()
  {
    SwipeableListView localSwipeableListView2 = (SwipeableListView)((SwipeableConversationItemView)getParent()).getListView();
    SwipeableListView localSwipeableListView1 = localSwipeableListView2;
    if (localSwipeableListView2 == null) {
      localSwipeableListView1 = mAdapter.getListView();
    }
    return localSwipeableListView1;
  }
  
  private static int getPadding(int paramInt1, int paramInt2)
  {
    return (paramInt1 - paramInt2) / 2;
  }
  
  private static HtmlParser getParser()
  {
    if (sHtmlParser == null) {
      sHtmlParser = new HtmlParser();
    }
    return sHtmlParser;
  }
  
  private TextView getSendersTextView()
  {
    if (sSendersTextView == null)
    {
      TextView localTextView = new TextView(mContext);
      localTextView.setMaxLines(1);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      sSendersTextView = localTextView;
    }
    return sSendersTextView;
  }
  
  private Bitmap getStarBitmap()
  {
    if (mHeader.conversation.starred) {
      return STAR_ON;
    }
    return STAR_OFF;
  }
  
  private TextView getSubjectTextView()
  {
    if (sSubjectTextView == null)
    {
      TextView localTextView = new TextView(mContext);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      sSubjectTextView = localTextView;
    }
    return sSubjectTextView;
  }
  
  private boolean isTouchInCheckmark(float paramFloat1, float paramFloat2)
  {
    return (mHeader.checkboxVisible) && (paramFloat1 < mCoordinates.sendersX + sTouchSlop);
  }
  
  private boolean isTouchInStar(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 > mCoordinates.starX - sTouchSlop;
  }
  
  private void layoutSubjectSpans(boolean paramBoolean)
  {
    mHeader.subjectText = createSubject(paramBoolean, false);
  }
  
  private int measureHeight(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      return paramInt1;
    }
    paramInt2 = ConversationItemViewCoordinates.getHeight(mContext, paramInt2);
    if (i == Integer.MIN_VALUE) {
      return Math.min(paramInt2, paramInt1);
    }
    return paramInt2;
  }
  
  private boolean onTouchEventNoSwipe(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    mLastTouchX = i;
    mLastTouchY = j;
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool1 = bool2;
    }
    do
    {
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          bool2 = super.onTouchEvent(paramMotionEvent);
        }
        return bool2;
        if (!isTouchInCheckmark(i, j))
        {
          bool1 = bool2;
          if (!isTouchInStar(i, j)) {}
        }
        else
        {
          mDownEvent = true;
          bool1 = true;
          continue;
          mDownEvent = false;
          bool1 = bool2;
        }
      }
      bool1 = bool2;
    } while (!mDownEvent);
    if (isTouchInCheckmark(i, j)) {
      toggleCheckMark();
    }
    for (;;)
    {
      bool1 = true;
      break;
      if (isTouchInStar(i, j)) {
        toggleStar();
      }
    }
  }
  
  private static void pauseTimer(String paramString)
  {
    if (sTimer != null) {
      sTimer.pause(paramString);
    }
  }
  
  private void setCheckedActivatedBackground()
  {
    if ((isActivated()) && (mTabletDevice))
    {
      setBackgroundResource(2130837619);
      return;
    }
    setBackgroundResource(2130837636);
  }
  
  private void setContentDescription()
  {
    if (mActivity.isAccessibilityEnabled())
    {
      mHeader.resetContentDescription();
      setContentDescription(mHeader.getContentDescription(mContext));
    }
  }
  
  private boolean showActivatedText()
  {
    boolean bool = mContext.getResources().getBoolean(2131689472);
    return (mTabletDevice) && (!bool);
  }
  
  private static void startTimer(String paramString)
  {
    if (sTimer != null) {
      sTimer.start(paramString);
    }
  }
  
  private void toggleCheckMark()
  {
    boolean bool;
    Conversation localConversation;
    SwipeableListView localSwipeableListView;
    if ((mHeader != null) && (mHeader.conversation != null))
    {
      if (mChecked) {
        break label106;
      }
      bool = true;
      mChecked = bool;
      localConversation = mHeader.conversation;
      localSwipeableListView = getListView();
      if ((!mChecked) || (localSwipeableListView == null)) {
        break label111;
      }
    }
    label106:
    label111:
    for (int i = localSwipeableListView.getPositionForView(this);; i = -1)
    {
      position = i;
      if (mSelectedConversationSet != null) {
        mSelectedConversationSet.toggle(this, localConversation);
      }
      if (mSelectedConversationSet.isEmpty()) {
        localSwipeableListView.commitDestructiveActions(true);
      }
      requestLayout();
      return;
      bool = false;
      break;
    }
  }
  
  private void updateBackground(boolean paramBoolean)
  {
    if (mBackgroundOverride != -1)
    {
      setBackgroundColor(mBackgroundOverride);
      return;
    }
    int i;
    if ((mTabletDevice) && (mActivity.getViewMode().isListMode())) {
      i = 1;
    }
    while (paramBoolean) {
      if (i != 0)
      {
        if (mChecked)
        {
          setBackgroundResource(2130837627);
          return;
          i = 0;
        }
        else
        {
          setBackgroundResource(2130837530);
        }
      }
      else
      {
        if (mChecked)
        {
          setCheckedActivatedBackground();
          return;
        }
        setBackgroundResource(2130837528);
        return;
      }
    }
    if (i != 0)
    {
      if (mChecked)
      {
        setBackgroundResource(2130837623);
        return;
      }
      setBackgroundResource(2130837529);
      return;
    }
    if (mChecked)
    {
      setCheckedActivatedBackground();
      return;
    }
    setBackgroundResource(2130837527);
  }
  
  public void bind(Cursor paramCursor, ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AnimatedAdapter paramAnimatedAdapter)
  {
    bind(ConversationItemViewModel.forCursor(mAccount, paramCursor), paramControllableActivity, paramConversationSelectionSet, paramFolder, paramBoolean1, paramBoolean2, paramBoolean3, paramAnimatedAdapter);
  }
  
  public void bind(Conversation paramConversation, ControllableActivity paramControllableActivity, ConversationSelectionSet paramConversationSelectionSet, Folder paramFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, AnimatedAdapter paramAnimatedAdapter)
  {
    bind(ConversationItemViewModel.forConversation(mAccount, paramConversation), paramControllableActivity, paramConversationSelectionSet, paramFolder, paramBoolean1, paramBoolean2, paramBoolean3, paramAnimatedAdapter);
  }
  
  public boolean canChildBeDismissed()
  {
    return true;
  }
  
  public void dismiss()
  {
    if (getListView() != null) {
      getListView().dismissChild(this);
    }
  }
  
  public Conversation getConversation()
  {
    return mHeader.conversation;
  }
  
  public float getMinAllowScrollDistance()
  {
    return sScrollSlop;
  }
  
  public View getSwipeableView()
  {
    return this;
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    switch (paramDragEvent.getAction())
    {
    default: 
      return false;
    }
    mActivity.stopDragMode();
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject;
    int i;
    label161:
    label213:
    int j;
    if (mHeader.checkboxVisible)
    {
      if (mChecked)
      {
        localObject = CHECKMARK_ON;
        paramCanvas.drawBitmap((Bitmap)localObject, mCoordinates.checkmarkX, mCoordinates.checkmarkY, sPaint);
      }
    }
    else
    {
      if ((mCoordinates.showPersonalLevel) && (mHeader.personalLevelBitmap != null)) {
        paramCanvas.drawBitmap(mHeader.personalLevelBitmap, mCoordinates.personalLevelX, mCoordinates.personalLevelY, sPaint);
      }
      boolean bool = mHeader.unread;
      paramCanvas.save();
      if (mHeader.sendersDisplayLayout == null) {
        break label815;
      }
      sPaint.setTextSize(mCoordinates.sendersFontSize);
      sPaint.setTypeface(SendersView.getTypeface(bool));
      localObject = sPaint;
      if (!bool) {
        break label808;
      }
      i = sSendersTextColorUnread;
      ((TextPaint)localObject).setColor(getFontColor(i));
      paramCanvas.translate(mCoordinates.sendersX, mCoordinates.sendersY + mHeader.sendersDisplayLayout.getTopPadding());
      mHeader.sendersDisplayLayout.draw(paramCanvas);
      paramCanvas.restore();
      sPaint.setTypeface(Typeface.DEFAULT);
      paramCanvas.save();
      drawSubject(paramCanvas);
      paramCanvas.restore();
      if ((mCoordinates.showFolders) && (mHeader.folderDisplayer != null)) {
        mHeader.folderDisplayer.drawFolders(paramCanvas, mCoordinates, mFoldersXEnd, mMode);
      }
      if (mHeader.conversation.color != 0)
      {
        sFoldersPaint.setColor(mHeader.conversation.color);
        sFoldersPaint.setStyle(Paint.Style.FILL);
        i = ConversationItemViewCoordinates.getColorBlockWidth(mContext);
        j = ConversationItemViewCoordinates.getColorBlockHeight(mContext);
        paramCanvas.drawRect(mCoordinates.dateXEnd - i, 0.0F, mCoordinates.dateXEnd, j, sFoldersPaint);
      }
      if ((isActivated()) || ((!mHeader.conversation.hasAttachments) && ((mHeader.folderDisplayer == null) || (!mHeader.folderDisplayer.hasVisibleFolders()))) || (!ConversationItemViewCoordinates.showAttachmentBackground(mMode))) {
        break label842;
      }
      if (!mHeader.conversation.hasAttachments) {
        break label823;
      }
      i = mPaperclipX;
      label437:
      int k = sDateBackgroundPaddingLeft;
      if (!mCoordinates.showFolders) {
        break label831;
      }
      j = mCoordinates.foldersY;
      label460:
      mHeader.dateBackground = getDateBackground(mHeader.conversation.hasAttachments);
      paramCanvas.drawBitmap(mHeader.dateBackground, i - k, j, sPaint);
      label502:
      if (mCoordinates.showReplyState)
      {
        if ((!mHeader.hasBeenRepliedTo) || (!mHeader.hasBeenForwarded)) {
          break label853;
        }
        paramCanvas.drawBitmap(STATE_REPLIED_AND_FORWARDED, mCoordinates.replyStateX, mCoordinates.replyStateY, null);
      }
    }
    for (;;)
    {
      sPaint.setTextSize(mCoordinates.dateFontSize);
      sPaint.setTypeface(Typeface.DEFAULT);
      sPaint.setColor(sDateTextColor);
      drawText(paramCanvas, mHeader.dateText, mDateX, mCoordinates.dateY - mCoordinates.dateAscent, sPaint);
      if (mHeader.paperclip != null) {
        paramCanvas.drawBitmap(mHeader.paperclip, mPaperclipX, mCoordinates.paperclipY, sPaint);
      }
      if (mHeader.faded)
      {
        if (sFadedActivatedColor == -1) {
          sFadedActivatedColor = mContext.getResources().getColor(2131296272);
        }
        i = sFadedActivatedColor;
        j = paramCanvas.save();
        localObject = paramCanvas.getClipBounds();
        paramCanvas.clipRect(left, top, right - mContext.getResources().getDimensionPixelSize(2131427369), bottom);
        paramCanvas.drawARGB(Color.alpha(i), Color.red(i), Color.green(i), Color.blue(i));
        paramCanvas.restoreToCount(j);
      }
      paramCanvas.drawBitmap(getStarBitmap(), mCoordinates.starX, mCoordinates.starY, sPaint);
      return;
      localObject = CHECKMARK_OFF;
      break;
      label808:
      i = sSendersTextColorRead;
      break label161;
      label815:
      drawSenders(paramCanvas);
      break label213;
      label823:
      i = mDateX;
      break label437;
      label831:
      j = mCoordinates.dateY;
      break label460;
      label842:
      mHeader.dateBackground = null;
      break label502;
      label853:
      if (mHeader.hasBeenRepliedTo) {
        paramCanvas.drawBitmap(STATE_REPLIED, mCoordinates.replyStateX, mCoordinates.replyStateY, null);
      } else if (mHeader.hasBeenForwarded) {
        paramCanvas.drawBitmap(STATE_FORWARDED, mCoordinates.replyStateX, mCoordinates.replyStateY, null);
      } else if (mHeader.isInvite) {
        paramCanvas.drawBitmap(STATE_CALENDAR_INVITE, mCoordinates.replyStateX, mCoordinates.replyStateY, null);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    startTimer("CCHV.layout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = mActivity.getViewMode().getMode();
    if ((paramInt1 != mViewWidth) || (mPreviousMode != paramInt2))
    {
      mViewWidth = paramInt1;
      mPreviousMode = paramInt2;
      if (!mTesting) {
        mMode = ConversationItemViewCoordinates.getMode(mContext, mPreviousMode);
      }
    }
    mHeader.viewWidth = mViewWidth;
    Resources localResources = getResources();
    mHeader.standardScaledDimen = localResources.getDimensionPixelOffset(2131427367);
    if (mHeader.standardScaledDimen != sStandardScaledDimen)
    {
      sStandardScaledDimen = mHeader.standardScaledDimen;
      ConversationItemViewCoordinates.refreshConversationHeights(mContext);
      sDateBackgroundHeight = localResources.getDimensionPixelSize(2131427363);
    }
    mCoordinates = ConversationItemViewCoordinates.forWidth(mContext, mViewWidth, mMode, mHeader.standardScaledDimen);
    calculateTextsAndBitmaps();
    calculateCoordinates();
    if (!mHeader.isLayoutValid(mContext)) {
      setContentDescription();
    }
    mHeader.validate(mContext);
    pauseTimer("CCHV.layout");
    if (sTimer != null)
    {
      paramInt1 = sLayoutCount + 1;
      sLayoutCount = paramInt1;
      if (paramInt1 >= 50)
      {
        sTimer.dumpResults();
        sTimer = new Timer();
        sLayoutCount = 0;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (mAnimatedHeight == -1)
    {
      setMeasuredDimension(paramInt1, measureHeight(paramInt2, ConversationItemViewCoordinates.getMode(mContext, mActivity.getViewMode())));
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), mAnimatedHeight);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    mLastTouchX = i;
    mLastTouchY = j;
    boolean bool;
    if (!mSwipeEnabled)
    {
      bool = onTouchEventNoSwipe(paramMotionEvent);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      do
      {
        do
        {
          bool = super.onTouchEvent(paramMotionEvent);
          if (paramMotionEvent.getAction() != 0) {
            break;
          }
          return true;
        } while ((!isTouchInCheckmark(i, j)) && (!isTouchInStar(i, j)));
        mDownEvent = true;
        return true;
      } while (!mDownEvent);
      if (isTouchInCheckmark(i, j))
      {
        mDownEvent = false;
        toggleCheckMark();
        return true;
      }
    } while (!isTouchInStar(i, j));
    mDownEvent = false;
    toggleStar();
    return true;
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    SwipeableListView localSwipeableListView = getListView();
    if ((localSwipeableListView != null) && (localSwipeableListView.getAdapter() != null)) {
      localSwipeableListView.performItemClick(this, localSwipeableListView.findConversation(this, mHeader.conversation), mHeader.conversation.id);
    }
    return bool;
  }
  
  public void reset()
  {
    mBackgroundOverride = -1;
    setAlpha(1.0F);
    setTranslationX(0.0F);
    setAnimatedHeight(-1);
    setMinimumHeight(ConversationItemViewCoordinates.getMinHeight(mContext, mActivity.getViewMode()));
  }
  
  public void setAnimatedHeight(int paramInt)
  {
    mAnimatedHeight = paramInt;
    requestLayout();
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable2 = (Drawable)mBackgrounds.get(paramInt);
    Drawable localDrawable1 = localDrawable2;
    if (localDrawable2 == null)
    {
      localDrawable1 = getResources().getDrawable(paramInt);
      mBackgrounds.put(paramInt, localDrawable1);
    }
    if (getBackground() != localDrawable1) {
      super.setBackgroundDrawable(localDrawable1);
    }
  }
  
  public void setItemAlpha(float paramFloat)
  {
    setAlpha(paramFloat);
    invalidate();
  }
  
  void setMode(int paramInt)
  {
    mMode = paramInt;
    mTesting = true;
  }
  
  public void startDestroyAnimation(Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator = createHeightAnimation(false);
    int i = ConversationItemViewCoordinates.getMinHeight(mContext, mActivity.getViewMode());
    setMinimumHeight(0);
    mBackgroundOverride = sAnimatingBackgroundColor;
    setBackgroundColor(mBackgroundOverride);
    mAnimatedHeight = i;
    localObjectAnimator.addListener(paramAnimatorListener);
    localObjectAnimator.start();
  }
  
  public void startDestroyWithSwipeAnimation(Animator.AnimatorListener paramAnimatorListener)
  {
    ObjectAnimator localObjectAnimator1 = createTranslateXAnimation(false);
    ObjectAnimator localObjectAnimator2 = createHeightAnimation(false);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
    localAnimatorSet.addListener(paramAnimatorListener);
    localAnimatorSet.start();
  }
  
  public void startSwipeUndoAnimation(ViewMode paramViewMode, Animator.AnimatorListener paramAnimatorListener)
  {
    paramViewMode = createTranslateXAnimation(true);
    paramViewMode.addListener(paramAnimatorListener);
    paramViewMode.start();
  }
  
  public void startUndoAnimation(ViewMode paramViewMode, Animator.AnimatorListener paramAnimatorListener)
  {
    setMinimumHeight(ConversationItemViewCoordinates.getMinHeight(mContext, paramViewMode));
    mAnimatedHeight = 0;
    paramViewMode = createHeightAnimation(true);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "itemAlpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(sShrinkAnimationDuration);
    localObjectAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { paramViewMode, localObjectAnimator });
    localAnimatorSet.addListener(paramAnimatorListener);
    localAnimatorSet.start();
  }
  
  public void toggleCheckMarkOrBeginDrag()
  {
    ViewMode localViewMode = mActivity.getViewMode();
    if ((!mTabletDevice) || (!localViewMode.isListMode()))
    {
      toggleCheckMark();
      return;
    }
    beginDragMode();
  }
  
  public void toggleStar()
  {
    Object localObject = mHeader.conversation;
    if (!mHeader.conversation.starred) {}
    for (boolean bool = true;; bool = false)
    {
      starred = bool;
      localObject = getStarBitmap();
      postInvalidate(mCoordinates.starX, mCoordinates.starY, mCoordinates.starX + ((Bitmap)localObject).getWidth(), mCoordinates.starY + ((Bitmap)localObject).getHeight());
      ((ConversationCursor)mAdapter.getCursor()).updateBoolean(mContext, mHeader.conversation, UIProvider.ConversationColumns.STARRED, mHeader.conversation.starred);
      return;
    }
  }
  
  static class ConversationItemFolderDisplayer
    extends FolderDisplayer
  {
    private int mFoldersCount;
    private boolean mHasMoreFolders;
    
    public ConversationItemFolderDisplayer(Context paramContext)
    {
      super();
    }
    
    private int measureFolders(int paramInt)
    {
      int k = ConversationItemViewCoordinates.getFoldersWidth(mContext, paramInt);
      int m = ConversationItemViewCoordinates.getFolderCellWidth(mContext, paramInt, mFoldersCount);
      paramInt = 0;
      Iterator localIterator = mFoldersSortedSet.iterator();
      int i;
      do
      {
        i = paramInt;
        if (!localIterator.hasNext()) {
          break;
        }
        String str = nextname;
        int j = (int)ConversationItemView.sFoldersPaint.measureText(str) + m;
        i = j;
        if (j % m != 0) {
          i = j + (m - j % m);
        }
        i = paramInt + i;
        paramInt = i;
      } while (i <= k);
      return i;
    }
    
    public void drawFolders(Canvas paramCanvas, ConversationItemViewCoordinates paramConversationItemViewCoordinates, int paramInt1, int paramInt2)
    {
      if (mFoldersCount == 0) {
        return;
      }
      int i2;
      int i3;
      int i4;
      int i5;
      int j;
      int n;
      int i6;
      int i7;
      int i;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        i2 = foldersY - foldersAscent;
        i3 = foldersHeight;
        i4 = foldersTopPadding;
        i5 = foldersAscent;
        ConversationItemView.sFoldersPaint.setTextSize(foldersFontSize);
        j = ConversationItemViewCoordinates.getFoldersWidth(mContext, paramInt2);
        n = j / mFoldersCount;
        i6 = ConversationItemViewCoordinates.getFolderCellWidth(mContext, paramInt2, mFoldersCount);
        i7 = measureFolders(paramInt2);
        i = paramInt1 - Math.min(j, i7);
        localIterator = mFoldersSortedSet.iterator();
      }
      Object localObject = (Folder)localIterator.next();
      String str = name;
      int i8 = ((Folder)localObject).getForegroundColor(mDefaultFgColor);
      int i9 = ((Folder)localObject).getBackgroundColor(mDefaultBgColor);
      int i1 = 0;
      int k = (int)ConversationItemView.sFoldersPaint.measureText(str) + i6;
      paramInt2 = k;
      if (k % i6 != 0) {
        paramInt2 = k + (i6 - k % i6);
      }
      int m = i1;
      k = paramInt2;
      if (i7 > j)
      {
        m = i1;
        k = paramInt2;
        if (paramInt2 > n)
        {
          k = n;
          m = 1;
        }
      }
      ConversationItemView.sFoldersPaint.setColor(i9);
      ConversationItemView.sFoldersPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      paramCanvas.drawRect(i, i2 + i5, i + k, i2 + i5 + i3, ConversationItemView.sFoldersPaint);
      paramInt2 = ConversationItemView.getPadding(k, (int)ConversationItemView.sFoldersPaint.measureText(str));
      if (m != 0)
      {
        localObject = new TextPaint();
        ((TextPaint)localObject).setColor(i8);
        ((TextPaint)localObject).setTextSize(foldersFontSize);
        paramInt2 = i6 / 2;
        m = i + k - paramInt2;
        ((TextPaint)localObject).setShader(new LinearGradient(m - paramInt2, i2, m, i2, i8, Utils.getTransparentColor(i8), Shader.TileMode.CLAMP));
        paramCanvas.drawText(str, i + paramInt2, i2 + i4, (Paint)localObject);
      }
      for (;;)
      {
        paramInt2 = j - k;
        k = i + k;
        j = paramInt2;
        i = k;
        if (paramInt2 > 0) {
          break;
        }
        j = paramInt2;
        i = k;
        if (!mHasMoreFolders) {
          break;
        }
        paramCanvas.drawBitmap(ConversationItemView.MORE_FOLDERS, paramInt1, i2 + i5, ConversationItemView.sFoldersPaint);
        return;
        ConversationItemView.sFoldersPaint.setColor(i8);
        paramCanvas.drawText(str, i + paramInt2, i2 + i4, ConversationItemView.sFoldersPaint);
      }
    }
    
    public boolean hasVisibleFolders()
    {
      return mFoldersCount > 0;
    }
    
    public void loadConversationFolders(Conversation paramConversation, Folder paramFolder)
    {
      super.loadConversationFolders(paramConversation, paramFolder);
      mFoldersCount = mFoldersSortedSet.size();
      if (mFoldersCount > 4) {}
      for (boolean bool = true;; bool = false)
      {
        mHasMoreFolders = bool;
        mFoldersCount = Math.min(mFoldersCount, 4);
        return;
      }
    }
  }
  
  private class ShadowBuilder
    extends View.DragShadowBuilder
  {
    private final Drawable mBackground;
    private final String mDragDesc;
    private int mDragDescX;
    private int mDragDescY;
    private final int mTouchX;
    private final int mTouchY;
    private final View mView;
    
    public ShadowBuilder(View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
      mView = paramView;
      mBackground = mView.getResources().getDrawable(2130837633);
      mDragDesc = Utils.formatPlural(mView.getContext(), 2131820545, paramInt1);
      mTouchX = paramInt2;
      mTouchY = paramInt3;
    }
    
    public void onDrawShadow(Canvas paramCanvas)
    {
      mBackground.setBounds(0, 0, mView.getWidth(), mView.getHeight());
      mBackground.draw(paramCanvas);
      ConversationItemView.sPaint.setTextSize(mCoordinates.subjectFontSize);
      paramCanvas.drawText(mDragDesc, mDragDescX, mDragDescY, ConversationItemView.sPaint);
    }
    
    public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
    {
      int i = mView.getWidth();
      int j = mView.getHeight();
      mDragDescX = mCoordinates.sendersX;
      mDragDescY = (ConversationItemView.getPadding(j, mCoordinates.subjectFontSize) - mCoordinates.subjectAscent);
      paramPoint1.set(i, j);
      paramPoint2.set(mTouchX, mTouchY);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */