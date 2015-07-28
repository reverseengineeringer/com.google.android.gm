package com.android.mail.ui;

import android.view.View;

public abstract interface SwipeableItemView
{
  public abstract boolean canChildBeDismissed();
  
  public abstract void dismiss();
  
  public abstract float getMinAllowScrollDistance();
  
  public abstract View getSwipeableView();
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeableItemView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */