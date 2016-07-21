import android.app.Application;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

final class gkk
{
  final AtomicBoolean a = new AtomicBoolean(false);
  ScheduledFuture<?> b;
  ScheduledFuture<?> c;
  final ScheduledExecutorService d;
  final gkb e;
  final gjz f = new gkl(this);
  final gka g = new gkn(this);
  private final gkt<Integer> h;
  
  gkk(gkt<Integer> paramgkt, Application paramApplication)
  {
    this(paramgkt, glr.a(), gkb.a(paramApplication));
  }
  
  private gkk(ScheduledExecutorService paramScheduledExecutorService)
  {
    h = paramScheduledExecutorService;
    ScheduledExecutorService localScheduledExecutorService;
    d = localScheduledExecutorService;
    gkb localgkb;
    e = localgkb;
  }
  
  public final void a(Integer paramInteger)
  {
    h.a(paramInteger);
  }
}

/* Location:
 * Qualified Name:     gkk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */