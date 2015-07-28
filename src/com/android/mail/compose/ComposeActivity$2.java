package com.android.mail.compose;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;

class ComposeActivity$2
  implements DialogInterface.OnClickListener
{
  ComposeActivity$2(ComposeActivity paramComposeActivity, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ComposeActivity.access$300(this$0, ComposeActivity.access$200(this$0).getEditableText(), val$save, val$showToast, val$orientationChanged);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */