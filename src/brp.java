import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class brp
  implements ServiceConnection
{
  brp(bro parambro) {}
  
  public final void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    cvm.a("Exchange", "onServiceConnected", new Object[0]);
    synchronized (a.b)
    {
      a.a = bez.a(paramIBinder);
      a.b.notify();
      return;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.a = null;
  }
}

/* Location:
 * Qualified Name:     brp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */