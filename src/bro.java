import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SyncResult;
import android.os.IBinder;
import com.android.exchange.service.EasService;

public abstract class bro
  extends Service
{
  public bey a;
  public ServiceConnection b;
  
  public static boolean a(int paramInt, SyncResult paramSyncResult)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 38: 
    default: 
      return false;
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 33: 
      stats.numAuthExceptions = 1L;
      return true;
    case 34: 
    case 39: 
      databaseError = true;
      return true;
    case 32: 
    case 35: 
      stats.numIoExceptions = 1L;
      return true;
    case 37: 
      tooManyRetries = true;
      return true;
    }
    cvm.e("Exchange", "Unexpected sync result %d", new Object[] { Integer.valueOf(paramInt) });
    return false;
  }
  
  public abstract AbstractThreadedSyncAdapter a();
  
  protected final void a(int paramInt, long paramLong)
  {
    if ((paramInt == 21) || (paramInt == 22) || (paramInt == 23) || (paramInt == 33) || (paramInt == 25)) {
      bsw.a(this, paramLong, true);
    }
    while (paramInt != 0) {
      return;
    }
    bsw.a(this, paramLong, false);
  }
  
  protected final boolean b()
  {
    synchronized (b)
    {
      if (a == null)
      {
        cvm.b("Exchange", "service not yet connected", new Object[0]);
        try
        {
          b.wait(10000L);
          if (a == null)
          {
            cvm.f("Exchange", "timed out waiting for EasService to connect", new Object[0]);
            return false;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          cvm.f("Exchange", "InterrupedException waiting for EasService to connect", new Object[0]);
          return false;
        }
      }
    }
    return true;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return a().getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    bdv.i(this);
    bnq.a(this);
    b = new brp(this);
    bindService(new Intent(this, EasService.class), b, 1);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    unbindService(b);
  }
}

/* Location:
 * Qualified Name:     bro
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */