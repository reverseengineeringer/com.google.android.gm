import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.android.email.service.ImapPurgeService;

final class bar
  implements baq
{
  public final void a(Context paramContext)
  {
    if (cxd.d())
    {
      ((JobScheduler)paramContext.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(0, new ComponentName(paramContext, ImapPurgeService.class)).setBackoffCriteria(600000L, 1).setPeriodic(86400000L).setPersisted(true).setRequiresCharging(true).build());
      cvm.b(bap.a, "scheduled Imap purge job", new Object[0]);
      return;
    }
    cvm.d(bap.a, "Email running on pre-L, cannot schedule a job", new Object[0]);
  }
  
  public final void b(Context paramContext)
  {
    if (cxd.d())
    {
      ((JobScheduler)paramContext.getSystemService("jobscheduler")).cancel(0);
      cvm.b(bap.a, "canceled Imap purge job", new Object[0]);
      return;
    }
    cvm.d(bap.a, "Email running on pre-L, cannot cancel a job", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     bar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */