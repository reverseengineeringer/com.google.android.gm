import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class eph
  implements ServiceConnection
{
  boolean a = false;
  private final BlockingQueue<IBinder> b = new LinkedBlockingQueue();
  
  public final IBinder a()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
    }
    if (a) {
      throw new IllegalStateException();
    }
    a = true;
    return (IBinder)b.take();
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    b.add(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}

/* Location:
 * Qualified Name:     eph
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */