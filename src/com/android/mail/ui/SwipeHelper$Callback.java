package com.android.mail.ui;

import android.view.MotionEvent;
import android.view.View;

public abstract interface SwipeHelper$Callback
{
  public abstract boolean canChildBeDismissed(SwipeableItemView paramSwipeableItemView);
  
  public abstract View getChildAtPosition(MotionEvent paramMotionEvent);
  
  public abstract void onBeginDrag(View paramView);
  
  public abstract void onChildDismissed(SwipeableItemView paramSwipeableItemView);
  
  public abstract void onDragCancelled(SwipeableItemView paramSwipeableItemView);
  
  public abstract void onScroll();
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeHelper.Callback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */