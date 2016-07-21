import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;

public final class bsv
  extends AsyncTask<Void, Void, Void>
{
  final bqi a;
  private final com.android.emailcommon.provider.Account b;
  private final bst c;
  
  public bsv(Context paramContext, com.android.emailcommon.provider.Account paramAccount, android.accounts.Account paramAccount1, bst parambst)
  {
    b = paramAccount;
    a = new bqi(paramContext, paramAccount, paramAccount1);
    c = parambst;
  }
  
  private final Void b()
  {
    cvm.c("Exchange", "Ping task starting for %d", new Object[] { Long.valueOf(a.g.D) });
    for (;;)
    {
      try
      {
        localbqi = a;
        l1 = SystemClock.elapsedRealtime();
        j = localbqi.p_();
        if (j != -7) {
          continue;
        }
        cvm.e("Exchange", "doPing authentication failure, dropping ping", new Object[0]);
        bsw.a(f, g.D, true);
        i = j;
      }
      catch (Exception localException)
      {
        bqi localbqi;
        int j;
        boolean bool;
        cvm.e("Exchange", localException, "Ping exception for account %d", new Object[] { Long.valueOf(a.g.D) });
        int i = -103;
        continue;
        i = j;
        if (j != -4) {
          continue;
        }
        long l1 = SystemClock.elapsedRealtime() - l1;
        b = Math.max(480L, b - 300L);
        Object localObject = String.valueOf("decreasePingDuration adjusting by 300s, new duration ");
        long l2 = b;
        long l3 = g.D;
        cvm.b("Exchange", String.valueOf(localObject).length() + 50 + (String)localObject + l2 + "s account " + l3, new Object[0]);
        localException.j();
        if (l1 < 480L) {
          continue;
        }
        cvm.b("Exchange", "doPing request failure, network problem at %d millis, restarting", new Object[] { Long.valueOf(l1) });
        i = 100;
        continue;
        cvm.b("Exchange", "doPing request failure, network problem at %d millis, delaying", new Object[] { Long.valueOf(l1) });
        i = j;
        continue;
      }
      if (bqi.c(i)) {
        c.a(b);
      }
      bool = bqi.c(i);
      if (!bool)
      {
        cvm.c("Exchange", "Ping task ending with status: %d", new Object[] { Integer.valueOf(i) });
        c.a(a.g.D, a.a, i);
        return null;
        if (j != -101) {
          continue;
        }
        cvm.e("Exchange", "doPing bad request", new Object[0]);
        localObject = new Bundle(3);
        ((Bundle)localObject).putBoolean("ignore_settings", false);
        ((Bundle)localObject).putBoolean("force", false);
        ((Bundle)localObject).putBoolean("expedited", false);
        if (ContentResolver.getSyncAutomatically(a, bdv.F)) {
          ContentResolver.requestSync(a, bdv.F, (Bundle)localObject);
        }
        if (ContentResolver.getSyncAutomatically(a, "com.android.calendar")) {
          ContentResolver.requestSync(a, "com.android.calendar", (Bundle)localObject);
        }
        if (ContentResolver.getSyncAutomatically(a, "com.android.contacts")) {
          ContentResolver.requestSync(a, "com.android.contacts", (Bundle)localObject);
        }
        cvm.b("Exchange", "requesFullSync EasPing %s, %s", new Object[] { a, localObject });
        i = j;
      }
    }
  }
  
  public final void a()
  {
    executeOnExecutor(THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:
 * Qualified Name:     bsv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */