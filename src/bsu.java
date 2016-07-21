import android.accounts.Account;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.android.exchange.service.EasService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public final class bsu
{
  bsv a = null;
  int b = 0;
  int c = 0;
  Condition d;
  long e;
  long f;
  boolean g;
  
  public bsu(bst parambst, Lock paramLock, long paramLong)
  {
    d = paramLock.newCondition();
    e = paramLong;
  }
  
  static long a(long paramLong)
  {
    if (paramLong == 0L) {
      return 60000L;
    }
    return Math.min(2L * paramLong, 1680000L);
  }
  
  static void a(Context paramContext, long paramLong1, Account paramAccount, long paramLong2)
  {
    cvm.c("Exchange", "PSS Scheduling a delayed ping acct:%d, delay %d ms.", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Intent localIntent = new Intent(paramContext, EasService.class);
    localIntent.setAction(bnq.f);
    localIntent.putExtra("START_PING", true);
    localIntent.putExtra("ACCOUNT", paramAccount);
    localIntent.putExtra("PING_DELAY", paramLong2);
    paramAccount = PendingIntent.getService(paramContext, 0, localIntent, 1073741824);
    ((AlarmManager)paramContext.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + paramLong2, paramAccount);
  }
  
  public final void a()
  {
    cvm.c("Exchange", "PSS pushStop acct:%d", new Object[] { Long.valueOf(e) });
    b = 2;
    if (a != null) {
      a.a.l();
    }
  }
}

/* Location:
 * Qualified Name:     bsu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */