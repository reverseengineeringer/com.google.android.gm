import android.content.Context;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class ehw
  implements ehn
{
  static final eif a = new eif();
  private static final Object b = new Object();
  private static ScheduledExecutorService c;
  private static final long d = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
  private final eov e;
  private final eia f;
  private final Object g = new Object();
  private long h = 0L;
  private final long i;
  private ScheduledFuture<?> j = null;
  private eiz k = null;
  private final Runnable l = new ehx(this);
  
  public ehw()
  {
    this(new epb(), d, new eib());
  }
  
  private ehw(eov parameov, long paramLong, eia parameia)
  {
    e = parameov;
    i = paramLong;
    f = parameia;
  }
  
  private static ScheduledExecutorService a()
  {
    synchronized (b)
    {
      if (c == null) {
        c = Executors.newSingleThreadScheduledExecutor();
      }
      return c;
    }
  }
  
  public final ejh<Status> a(Context paramContext, LogEventParcelable paramLogEventParcelable)
  {
    synchronized (g)
    {
      if (k == null)
      {
        k = f.a(paramContext);
        k.b();
      }
      h = (e.b() + i);
      if (j != null) {
        j.cancel(false);
      }
      j = a().schedule(l, i, TimeUnit.MILLISECONDS);
      paramContext = k;
      a.a();
      paramLogEventParcelable = new eid(this, paramLogEventParcelable, paramContext);
      paramLogEventParcelable.a(new ehz(this));
      a().execute(new ehy(this, paramContext, paramLogEventParcelable));
      return paramLogEventParcelable;
    }
  }
}

/* Location:
 * Qualified Name:     ehw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */