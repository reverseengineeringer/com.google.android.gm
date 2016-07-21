import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class gkn
  implements gka
{
  gkn(gkk paramgkk) {}
  
  public final void a()
  {
    a.a(Integer.valueOf(3));
    gkk localgkk = a;
    if (b != null)
    {
      b.cancel(true);
      b = null;
    }
    if (c != null)
    {
      c.cancel(true);
      c = null;
    }
    a.b = a.d.schedule(new gko(this), 10L, TimeUnit.SECONDS);
  }
}

/* Location:
 * Qualified Name:     gkn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */