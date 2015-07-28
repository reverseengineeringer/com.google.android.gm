package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.ui.FolderDisplayer;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.android.mail.utils.Utils;
import java.util.Iterator;
import java.util.SortedSet;

public class ConversationViewHeader
  extends RelativeLayout
  implements View.OnClickListener
{
  private static final String LOG_TAG = ;
  private ConversationViewAdapter.ConversationAccountController mAccountController;
  private ConversationViewHeaderCallbacks mCallbacks;
  private ConversationFolderDisplayer mFolderDisplayer;
  private FolderSpanTextView mFoldersView;
  private ConversationViewAdapter.ConversationHeaderItem mHeaderItem;
  private TextView mSubjectView;
  
  public ConversationViewHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationViewHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int getTotalMeasuredChildWidth(View paramView)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredWidth() + leftMargin + rightMargin;
  }
  
  private int measureHeight()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup == null)
    {
      LogUtils.e(LOG_TAG, "Unable to measure height of conversation header", new Object[0]);
      return getHeight();
    }
    return Utils.measureViewHeight(this, localViewGroup);
  }
  
  public void bind(ConversationViewAdapter.ConversationHeaderItem paramConversationHeaderItem)
  {
    mHeaderItem = paramConversationHeaderItem;
  }
  
  public void onClick(View paramView)
  {
    if ((2131755051 == paramView.getId()) && (mCallbacks != null)) {
      mCallbacks.onFoldersClicked();
    }
  }
  
  public void onConversationUpdated(Conversation paramConversation)
  {
    setFolders(paramConversation);
    int i = measureHeight();
    if (mHeaderItem.setHeight(i)) {
      mCallbacks.onConversationViewHeaderHeightChange(i);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mSubjectView = ((TextView)findViewById(2131755083));
    mFoldersView = ((FolderSpanTextView)findViewById(2131755051));
    mFoldersView.setOnClickListener(this);
    mFolderDisplayer = new ConversationFolderDisplayer(getContext(), mFoldersView);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getTotalMeasuredChildWidth(mSubjectView) + getTotalMeasuredChildWidth(mFoldersView) + getPaddingLeft() + getPaddingRight() > getMeasuredWidth())
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)mFoldersView.getLayoutParams();
      localLayoutParams.addRule(3, 2131755083);
      localLayoutParams.addRule(4, 0);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  public void setCallbacks(ConversationViewHeaderCallbacks paramConversationViewHeaderCallbacks, ConversationViewAdapter.ConversationAccountController paramConversationAccountController)
  {
    mCallbacks = paramConversationViewHeaderCallbacks;
    mAccountController = paramConversationAccountController;
  }
  
  public void setFolders(Conversation paramConversation)
  {
    setFoldersVisible(true);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((mAccountController.getAccount().settings.priorityArrowsEnabled) && (paramConversation.isImportant()))
    {
      localSpannableStringBuilder.append('.');
      localSpannableStringBuilder.setSpan(new PriorityIndicatorSpan(getContext(), 2130837573, mFoldersView.getPadding(), 0), 0, 1, 17);
    }
    mFolderDisplayer.loadConversationFolders(paramConversation, null);
    mFolderDisplayer.appendFolderSpans(localSpannableStringBuilder);
    mFoldersView.setText(localSpannableStringBuilder);
  }
  
  public void setFoldersVisible(boolean paramBoolean)
  {
    FolderSpanTextView localFolderSpanTextView = mFoldersView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localFolderSpanTextView.setVisibility(i);
      return;
    }
  }
  
  public void setSubject(String paramString)
  {
    String str1 = paramString;
    String str2 = str1;
    if (mCallbacks != null)
    {
      str2 = str1;
      if (mCallbacks.getSubjectRemainder(paramString) == null) {
        str2 = null;
      }
    }
    mSubjectView.setText(str2);
    if (TextUtils.isEmpty(str2)) {
      mSubjectView.setVisibility(8);
    }
  }
  
  private static class ConversationFolderDisplayer
    extends FolderDisplayer
  {
    private FolderSpan.FolderSpanDimensions mDims;
    
    public ConversationFolderDisplayer(Context paramContext, FolderSpan.FolderSpanDimensions paramFolderSpanDimensions)
    {
      super();
      mDims = paramFolderSpanDimensions;
    }
    
    private void addSpan(SpannableStringBuilder paramSpannableStringBuilder, Folder paramFolder)
    {
      int i = paramSpannableStringBuilder.length();
      paramSpannableStringBuilder.append(name);
      int j = paramSpannableStringBuilder.length();
      int k = paramFolder.getForegroundColor(mDefaultFgColor);
      paramSpannableStringBuilder.setSpan(new BackgroundColorSpan(paramFolder.getBackgroundColor(mDefaultBgColor)), i, j, 33);
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(k), i, j, 33);
      paramSpannableStringBuilder.setSpan(new FolderSpan(paramSpannableStringBuilder, mDims), i, j, 33);
    }
    
    public void appendFolderSpans(SpannableStringBuilder paramSpannableStringBuilder)
    {
      Object localObject = mFoldersSortedSet.iterator();
      while (((Iterator)localObject).hasNext()) {
        addSpan(paramSpannableStringBuilder, (Folder)((Iterator)localObject).next());
      }
      if (mFoldersSortedSet.isEmpty())
      {
        localObject = Folder.newUnsafeInstance();
        Resources localResources = mContext.getResources();
        name = localResources.getString(2131493038);
        bgColor = ("" + localResources.getColor(2131296286));
        fgColor = ("" + localResources.getColor(2131296285));
        addSpan(paramSpannableStringBuilder, (Folder)localObject);
      }
    }
  }
  
  public static abstract interface ConversationViewHeaderCallbacks
  {
    public abstract String getSubjectRemainder(String paramString);
    
    public abstract void onConversationViewHeaderHeightChange(int paramInt);
    
    public abstract void onFoldersClicked();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationViewHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */