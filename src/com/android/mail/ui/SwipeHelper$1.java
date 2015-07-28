package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class SwipeHelper$1
  extends AnimatorListenerAdapter
{
  SwipeHelper$1(SwipeHelper paramSwipeHelper, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SwipeHelper.access$100(this$0).onChildDismissed(SwipeHelper.access$000(this$0));
    val$animView.setLayerType(0, null);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */