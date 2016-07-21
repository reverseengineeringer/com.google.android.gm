import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.android.mail.MailLogService;

final class cin
  implements Runnable
{
  private boolean b = false;
  
  cin(cht paramcht) {}
  
  public final void run()
  {
    Intent localIntent = new Intent(a.h, MailLogService.class);
    boolean bool = cvm.a(MailLogService.b, 3);
    if (b != bool)
    {
      if (!bool) {
        break label83;
      }
      cvm.e(cht.I, "Starting MailLogService", new Object[0]);
      a.h.startService(localIntent);
    }
    for (;;)
    {
      b = bool;
      a.n.postDelayed(this, 300000L);
      return;
      label83:
      cvm.e(cht.I, "Stopping MailLogService", new Object[0]);
      a.h.stopService(localIntent);
    }
  }
}

/* Location:
 * Qualified Name:     cin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */