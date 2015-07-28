package com.android.mail.compose;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.android.mail.providers.Account;
import com.android.mail.providers.MailAppProvider;
import com.android.mail.providers.Message;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ComposeActivity$3
  implements ComposeActivity.SendOrSaveCallback
{
  ComposeActivity$3(ComposeActivity paramComposeActivity) {}
  
  public Message getMessage()
  {
    synchronized (ComposeActivity.access$500(this$0))
    {
      Message localMessage = ComposeActivity.access$700(this$0);
      return localMessage;
    }
  }
  
  public void initializeSendOrSave(ComposeActivity.SendOrSaveTask paramSendOrSaveTask)
  {
    synchronized (this$0.mActiveTasks)
    {
      if (this$0.mActiveTasks.size() == 0) {
        this$0.startService(new Intent(this$0, EmptyService.class));
      }
      this$0.mActiveTasks.add(paramSendOrSaveTask);
      if (ComposeActivity.access$400() != null) {
        ComposeActivity.access$400().initializeSendOrSave(paramSendOrSaveTask);
      }
      return;
    }
  }
  
  public void notifyMessageIdAllocated(ComposeActivity.SendOrSaveMessage paramSendOrSaveMessage, Message paramMessage)
  {
    synchronized (ComposeActivity.access$500(this$0))
    {
      ComposeActivity.access$602(this$0, id);
      ComposeActivity.access$702(this$0, paramMessage);
      if (ComposeActivity.access$800() != null) {
        ComposeActivity.access$800().put(Integer.valueOf(paramSendOrSaveMessage.requestId()), Long.valueOf(ComposeActivity.access$600(this$0)));
      }
      ComposeActivity.access$900(this$0);
      if (ComposeActivity.access$400() != null) {
        ComposeActivity.access$400().notifyMessageIdAllocated(paramSendOrSaveMessage, paramMessage);
      }
      return;
    }
  }
  
  public void sendOrSaveFinished(ComposeActivity.SendOrSaveTask paramSendOrSaveTask, boolean paramBoolean)
  {
    if (ComposeActivity.access$1000(this$0) != null) {
      MailAppProvider.getInstance().setLastSentFromAccount(access$1000this$0).uri.toString());
    }
    if (paramBoolean) {
      ComposeActivity.access$1100(this$0);
    }
    synchronized (this$0.mActiveTasks)
    {
      this$0.mActiveTasks.remove(paramSendOrSaveTask);
      int i = this$0.mActiveTasks.size();
      if (i == 0) {
        this$0.stopService(new Intent(this$0, EmptyService.class));
      }
      if (ComposeActivity.access$400() != null) {
        ComposeActivity.access$400().sendOrSaveFinished(paramSendOrSaveTask, paramBoolean);
      }
      return;
      Toast.makeText(this$0, 2131493018, 0).show();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.ComposeActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */