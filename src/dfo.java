import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gm.GcmImapPurgeService;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;

public final class dfo
  implements baq
{
  public final void a(Context paramContext)
  {
    cvm.b(cvm.a, "setting up Gcm purge task", new Object[0]);
    Object localObject = new fka();
    d = GcmImapPurgeService.class.getName();
    a = 86400L;
    b = 600L;
    e = "IMAP_PURGE";
    g = true;
    h = true;
    ((fka)localObject).a();
    localObject = new PeriodicTask((fka)localObject);
    fjs.a(paramContext).a((Task)localObject);
  }
  
  public final void b(Context paramContext)
  {
    cvm.b(cvm.a, "canceling Gcm purge task", new Object[0]);
    paramContext = fjs.a(paramContext);
    fjs.a("IMAP_PURGE");
    paramContext.b(GcmImapPurgeService.class.getName());
    Intent localIntent = paramContext.a();
    if (localIntent != null)
    {
      localIntent.putExtra("scheduler_action", "CANCEL_TASK");
      localIntent.putExtra("tag", "IMAP_PURGE");
      localIntent.putExtra("component", new ComponentName(a, GcmImapPurgeService.class));
      a.sendBroadcast(localIntent);
    }
  }
}

/* Location:
 * Qualified Name:     dfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */