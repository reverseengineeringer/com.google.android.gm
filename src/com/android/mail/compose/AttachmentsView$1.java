package com.android.mail.compose;

import android.view.View;
import android.view.View.OnClickListener;
import com.android.mail.providers.Attachment;

class AttachmentsView$1
  implements View.OnClickListener
{
  AttachmentsView$1(AttachmentsView paramAttachmentsView, ComposeAttachmentTile paramComposeAttachmentTile, Attachment paramAttachment) {}
  
  public void onClick(View paramView)
  {
    this$0.deleteAttachment(val$attachmentTile, val$attachment);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.AttachmentsView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */