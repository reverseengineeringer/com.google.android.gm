import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import java.util.Map;

public final class azy
  implements Runnable
{
  private final long b;
  private final azx c;
  private int d = 0;
  
  public azy(azv paramazv, long paramLong, azx paramazx)
  {
    b = paramLong;
    c = paramazx;
  }
  
  public final void run()
  {
    for (;;)
    {
      synchronized (a.d)
      {
        Object localObject1 = (Boolean)a.d.get(Long.valueOf(b));
        if (!Boolean.FALSE.equals(localObject1)) {
          break label336;
        }
        if (a.c)
        {
          cvm.b(azv.a, "RefreshStatusMonitor: mailboxId=%d LOW STORAGE", new Object[] { Long.valueOf(b) });
          c.a(b, 4);
          a.d.remove(Long.valueOf(b));
          return;
        }
        localObject1 = ((ConnectivityManager)a.e.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          i = 1;
          if (i != 0) {
            break label219;
          }
          cvm.b(azv.a, "RefreshStatusMonitor: mailboxId=%d NOT CONNECTED", new Object[] { Long.valueOf(b) });
          c.a(b, 1);
          a.d.remove(Long.valueOf(b));
        }
      }
      int i = 0;
      continue;
      label219:
      d += 1;
      cvm.b(azv.a, "RefreshStatusMonitor: mailboxId=%d Retry %d", new Object[] { Long.valueOf(b), Integer.valueOf(d) });
      if (d > 240)
      {
        cvm.b(azv.a, "RefreshStatusMonitor: mailboxId=%d TIMEOUT", new Object[] { Long.valueOf(b) });
        a.d.remove(Long.valueOf(b));
      }
      else
      {
        a.b.postDelayed(this, 250L);
        continue;
        label336:
        cvm.b(azv.a, "RefreshStatusMonitor: mailboxId=%d SYNC DETECTED", new Object[] { Long.valueOf(b) });
        c.a(b, 0);
        a.d.remove(Long.valueOf(b));
      }
    }
  }
}

/* Location:
 * Qualified Name:     azy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */