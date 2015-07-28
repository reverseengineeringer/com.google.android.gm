package com.android.mail.browse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.mail.utils.LogUtils;

public abstract class ConversationOverlayItem
{
  private int mHeight;
  private boolean mNeedsMeasure;
  private int mTop;
  
  public boolean belongsToMessage(MessageCursor.ConversationMessage paramConversationMessage)
  {
    return false;
  }
  
  public abstract void bindView(View paramView, boolean paramBoolean);
  
  public boolean canBecomeSnapHeader()
  {
    return false;
  }
  
  public boolean canPushSnapHeader()
  {
    return false;
  }
  
  public abstract View createView(Context paramContext, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public int getGravity()
  {
    return 80;
  }
  
  public int getHeight()
  {
    return mHeight;
  }
  
  public int getTop()
  {
    return mTop;
  }
  
  public abstract int getType();
  
  public void invalidateMeasurement()
  {
    mNeedsMeasure = true;
  }
  
  public abstract boolean isContiguous();
  
  public boolean isMeasurementValid()
  {
    return !mNeedsMeasure;
  }
  
  public void markMeasurementValid()
  {
    mNeedsMeasure = false;
  }
  
  public void onModelUpdated(View paramView) {}
  
  public boolean setHeight(int paramInt)
  {
    LogUtils.i("ConvLayout", "IN setHeight=%dpx of overlay item: %s", new Object[] { Integer.valueOf(paramInt), this });
    if (mHeight != paramInt)
    {
      mHeight = paramInt;
      mNeedsMeasure = true;
      return true;
    }
    return false;
  }
  
  public void setMessage(MessageCursor.ConversationMessage paramConversationMessage) {}
  
  public void setTop(int paramInt)
  {
    mTop = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationOverlayItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */