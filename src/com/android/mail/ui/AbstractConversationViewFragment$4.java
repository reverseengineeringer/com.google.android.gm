package com.android.mail.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class AbstractConversationViewFragment$4
  extends AnimatorListenerAdapter
{
  AbstractConversationViewFragment$4(AbstractConversationViewFragment paramAbstractConversationViewFragment, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AbstractConversationViewFragment.access$400(this$0).setVisibility(8);
    AbstractConversationViewFragment.access$400(this$0).setLayerType(0, null);
    if (val$doAfter != null) {
      val$doAfter.run();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.AbstractConversationViewFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */