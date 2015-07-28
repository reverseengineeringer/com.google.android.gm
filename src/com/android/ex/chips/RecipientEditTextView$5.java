package com.android.ex.chips;

import android.os.Handler;
import android.os.Message;
import android.widget.ListPopupWindow;

class RecipientEditTextView$5
  extends Handler
{
  RecipientEditTextView$5(RecipientEditTextView paramRecipientEditTextView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (what == RecipientEditTextView.access$600())
    {
      ((ListPopupWindow)obj).dismiss();
      return;
    }
    super.handleMessage(paramMessage);
  }
}

/* Location:
 * Qualified Name:     com.android.ex.chips.RecipientEditTextView.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */