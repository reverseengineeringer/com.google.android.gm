package com.android.ex.photo.views;

import android.widget.ProgressBar;

public class ProgressBarWrapper
{
  private final ProgressBar mDeterminate;
  private final ProgressBar mIndeterminate;
  private boolean mIsIndeterminate;
  
  public ProgressBarWrapper(ProgressBar paramProgressBar1, ProgressBar paramProgressBar2, boolean paramBoolean)
  {
    mDeterminate = paramProgressBar1;
    mIndeterminate = paramProgressBar2;
    setIndeterminate(paramBoolean);
  }
  
  private void setVisibility(boolean paramBoolean)
  {
    int j = 8;
    ProgressBar localProgressBar = mIndeterminate;
    if (paramBoolean)
    {
      i = 0;
      localProgressBar.setVisibility(i);
      localProgressBar = mDeterminate;
      if (!paramBoolean) {
        break label46;
      }
    }
    label46:
    for (int i = j;; i = 0)
    {
      localProgressBar.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    mIsIndeterminate = paramBoolean;
    setVisibility(mIsIndeterminate);
  }
  
  public void setMax(int paramInt)
  {
    mDeterminate.setMax(paramInt);
  }
  
  public void setProgress(int paramInt)
  {
    mDeterminate.setProgress(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8))
    {
      mIndeterminate.setVisibility(paramInt);
      mDeterminate.setVisibility(paramInt);
      return;
    }
    setVisibility(mIsIndeterminate);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.views.ProgressBarWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */