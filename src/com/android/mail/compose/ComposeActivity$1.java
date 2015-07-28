package com.android.mail.compose;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.android.ex.chips.RecipientEditTextView;

class ComposeActivity$1
  implements DialogInterface.OnClickListener
{
  ComposeActivity$1(ComposeActivity paramComposeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (ComposeActivity.access$000(this$0) != null) {
      ComposeActivity.access$000(this$0).requestFocus();
    }
    ComposeActivity.access$102(this$0, null);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */