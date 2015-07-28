package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider.CursorStatus;
import com.android.mail.ui.ViewMode.ModeChangeListener;
import com.android.mail.utils.Utils;

public final class ConversationListFooterView
  extends LinearLayout
  implements View.OnClickListener, ViewMode.ModeChangeListener
{
  private static Drawable sNormalBackground;
  private static Drawable sWideBackground;
  private FooterViewClickListener mClickListener;
  private Button mErrorActionButton;
  private int mErrorStatus;
  private TextView mErrorText;
  private Folder mFolder;
  private View mLoadMore;
  private Uri mLoadMoreUri;
  private View mLoading;
  private View mNetworkError;
  private final boolean mTabletDevice;
  
  public ConversationListFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    mTabletDevice = Utils.useTabletUI(paramContext);
  }
  
  private Drawable getBackground(int paramInt)
  {
    return getContext().getResources().getDrawable(paramInt);
  }
  
  private Drawable getNormalBackground()
  {
    if (sNormalBackground == null) {
      sNormalBackground = getBackground(2130837528);
    }
    return sNormalBackground;
  }
  
  private Drawable getWideBackground()
  {
    if (sWideBackground == null) {
      sWideBackground = getBackground(2130837530);
    }
    return sWideBackground;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    paramView = (Folder)paramView.getTag();
    switch (i)
    {
    case 2131755110: 
    default: 
      return;
    case 2131755109: 
      mClickListener.onFooterViewErrorActionClick(paramView, mErrorStatus);
      return;
    }
    mClickListener.onFooterViewLoadMoreClick(paramView);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mLoading = findViewById(2131755110);
    mNetworkError = findViewById(2131755107);
    mLoadMore = findViewById(2131755111);
    mLoadMore.setOnClickListener(this);
    mErrorActionButton = ((Button)findViewById(2131755109));
    mErrorActionButton.setOnClickListener(this);
    mErrorText = ((TextView)findViewById(2131755108));
  }
  
  public void onViewModeChanged(int paramInt)
  {
    if ((mTabletDevice) && (paramInt == 2)) {}
    for (Drawable localDrawable = getWideBackground();; localDrawable = getNormalBackground())
    {
      setBackgroundDrawable(localDrawable);
      return;
    }
  }
  
  public void setClickListener(FooterViewClickListener paramFooterViewClickListener)
  {
    mClickListener = paramFooterViewClickListener;
  }
  
  public void setFolder(Folder paramFolder)
  {
    mFolder = paramFolder;
    mErrorActionButton.setTag(mFolder);
    mLoadMore.setTag(mFolder);
    mLoadMoreUri = loadMoreUri;
  }
  
  public boolean updateStatus(ConversationCursor paramConversationCursor)
  {
    int j = 0;
    if (paramConversationCursor == null) {
      return false;
    }
    boolean bool = true;
    paramConversationCursor = paramConversationCursor.getExtras();
    int k = paramConversationCursor.getInt("cursor_status");
    int i;
    if (paramConversationCursor.containsKey("cursor_error"))
    {
      i = paramConversationCursor.getInt("cursor_error");
      mErrorStatus = i;
      if (!UIProvider.CursorStatus.isWaitingForResults(k)) {
        break label87;
      }
      mLoading.setVisibility(0);
      mNetworkError.setVisibility(8);
      mLoadMore.setVisibility(8);
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label87:
      if (mErrorStatus != 0)
      {
        mNetworkError.setVisibility(0);
        mErrorText.setText(Utils.getSyncStatusText(getContext(), mErrorStatus));
        mLoading.setVisibility(8);
        mLoadMore.setVisibility(8);
        paramConversationCursor = mErrorActionButton;
        if (mErrorStatus != 3)
        {
          i = j;
          label153:
          paramConversationCursor.setVisibility(i);
          switch (mErrorStatus)
          {
          default: 
            i = 2131492865;
            mNetworkError.setVisibility(8);
          }
        }
        for (;;)
        {
          mErrorActionButton.setText(i);
          break;
          i = 8;
          break label153;
          i = 2131492865;
          continue;
          i = 2131493109;
          continue;
          i = 2131492865;
          mNetworkError.setVisibility(8);
          continue;
          i = 2131493110;
          continue;
          i = 2131493111;
        }
      }
      if (mLoadMoreUri != null)
      {
        mLoading.setVisibility(8);
        mNetworkError.setVisibility(8);
        mLoadMore.setVisibility(0);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public static abstract interface FooterViewClickListener
  {
    public abstract void onFooterViewErrorActionClick(Folder paramFolder, int paramInt);
    
    public abstract void onFooterViewLoadMoreClick(Folder paramFolder);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationListFooterView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */