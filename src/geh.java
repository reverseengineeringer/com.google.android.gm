import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

public class geh
  extends Service
  implements gdj, gdl, gdp, gdx, gea, geb
{
  private volatile int a = -1;
  private IBinder b;
  String c;
  Handler d;
  Object e = new Object();
  boolean f;
  
  public void a(gds paramgds) {}
  
  public void a(gdy paramgdy) {}
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return b;
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onCreate: ").append(getPackageName());
    }
    c = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    d = new Handler(localHandlerThread.getLooper());
    b = new gei(this);
  }
  
  public void onDestroy()
  {
    synchronized (e)
    {
      f = true;
      if (d == null) {
        throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
      }
    }
    d.getLooper().quit();
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     geh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */