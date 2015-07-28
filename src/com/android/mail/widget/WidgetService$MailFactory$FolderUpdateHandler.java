package com.android.mail.widget;

import android.content.CursorLoader;
import android.os.Looper;
import com.android.mail.utils.DelayedTaskHandler;

class WidgetService$MailFactory$FolderUpdateHandler
  extends DelayedTaskHandler
{
  public WidgetService$MailFactory$FolderUpdateHandler(WidgetService.MailFactory paramMailFactory, int paramInt)
  {
    super(Looper.myLooper(), paramInt);
  }
  
  protected void performTask()
  {
    if (WidgetService.MailFactory.access$200(this$0) != null) {
      WidgetService.MailFactory.access$200(this$0).startLoading();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.WidgetService.MailFactory.FolderUpdateHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */