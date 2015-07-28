package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class TwoPaneLayout$2
  extends AnimatorListenerAdapter
{
  TwoPaneLayout$2(TwoPaneLayout paramTwoPaneLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    TwoPaneLayout.access$100(this$0).unbind();
    TwoPaneLayout.access$200(this$0, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    TwoPaneLayout.access$100(this$0).unbind();
    TwoPaneLayout.access$200(this$0, false);
    TwoPaneLayout.access$300(this$0);
    TwoPaneLayout.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.TwoPaneLayout.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */