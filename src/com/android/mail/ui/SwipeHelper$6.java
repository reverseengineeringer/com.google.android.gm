package com.android.mail.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class SwipeHelper$6
  implements Animator.AnimatorListener
{
  SwipeHelper$6(SwipeHelper paramSwipeHelper, View paramView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    val$animView.setAlpha(1.0F);
    SwipeHelper.access$100(this$0).onDragCancelled(SwipeHelper.access$000(this$0));
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeHelper.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */