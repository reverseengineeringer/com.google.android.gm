import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public final class aqk
  extends BroadcastReceiver
{
  public final String a;
  public final Object b = new Object();
  public final PowerManager.WakeLock c;
  public final ConnectivityManager d;
  public boolean e = false;
  public Thread f;
  public boolean g = true;
  private final Context h;
  
  public aqk(Context paramContext, String paramString)
  {
    h = paramContext;
    a = paramString;
    d = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    c = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, paramString);
    h.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
  }
  
  public final void a()
  {
    try
    {
      h.unregisterReceiver(this);
      g = false;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      localRuntimeException = localRuntimeException;
      g = false;
      return;
    }
    finally
    {
      localObject = finally;
      g = false;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onReceive(Context paramContext, Intent arg2)
  {
    if (???.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      paramContext = ???.getExtras();
      if (paramContext != null)
      {
        paramContext = (NetworkInfo)paramContext.get("networkInfo");
        if (paramContext != null) {
          break label36;
        }
      }
    }
    label36:
    do
    {
      return;
      ??? = paramContext.getState();
      if (??? == NetworkInfo.State.CONNECTED) {
        synchronized (b)
        {
          b.notifyAll();
          paramContext.getType();
          return;
        }
      }
    } while (??? != NetworkInfo.State.DISCONNECTED);
    paramContext.getType();
  }
}

/* Location:
 * Qualified Name:     aqk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */