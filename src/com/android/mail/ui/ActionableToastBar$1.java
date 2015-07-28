package com.android.mail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ActionableToastBar$1
  implements View.OnClickListener
{
  ActionableToastBar$1(ActionableToastBar paramActionableToastBar, ActionableToastBar.ActionClickedListener paramActionClickedListener) {}
  
  public void onClick(View paramView)
  {
    val$listener.onActionClicked();
    this$0.hide(true);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ActionableToastBar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */