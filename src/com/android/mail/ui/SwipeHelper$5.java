package com.android.mail.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SwipeHelper$5
  implements ValueAnimator.AnimatorUpdateListener
{
  SwipeHelper$5(SwipeHelper paramSwipeHelper, boolean paramBoolean, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (val$canAnimViewBeDismissed) {
      val$animView.setAlpha(SwipeHelper.access$200(this$0, val$animView));
    }
    SwipeHelper.invalidateGlobalRegion(val$animView);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SwipeHelper.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */