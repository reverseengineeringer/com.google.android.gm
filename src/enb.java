import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class enb
  implements Handler.Callback
{
  public final enc a;
  public final ArrayList<ejc> b = new ArrayList();
  public final ArrayList<ejc> c = new ArrayList();
  public final ArrayList<eje> d = new ArrayList();
  public volatile boolean e = false;
  public final AtomicInteger f = new AtomicInteger(0);
  public boolean g = false;
  public final Handler h;
  public final Object i = new Object();
  
  public enb(Looper paramLooper, enc paramenc)
  {
    a = paramenc;
    h = new Handler(paramLooper, this);
  }
  
  public final void a()
  {
    e = false;
    f.incrementAndGet();
  }
  
  public final void a(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == h.getLooper()) {
      bool = true;
    }
    enz.a(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    h.removeMessages(1);
    synchronized (i)
    {
      g = true;
      Object localObject2 = new ArrayList(b);
      int j = f.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ejc localejc = (ejc)((Iterator)localObject2).next();
        if ((e) && (f.get() == j)) {
          if (b.contains(localejc)) {
            localejc.a(paramInt);
          }
        }
      }
    }
    c.clear();
    g = false;
  }
  
  public final void a(ejc paramejc)
  {
    enz.a(paramejc);
    synchronized (i)
    {
      if (b.contains(paramejc))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramejc + " is already registered");
        if (a.d()) {
          h.sendMessage(h.obtainMessage(1, paramejc));
        }
        return;
      }
      b.add(paramejc);
    }
  }
  
  public final void a(eje parameje)
  {
    enz.a(parameje);
    synchronized (i)
    {
      if (d.contains(parameje))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + parameje + " is already registered");
        return;
      }
      d.add(parameje);
    }
  }
  
  public final boolean handleMessage(Message arg1)
  {
    if (what == 1)
    {
      ejc localejc = (ejc)obj;
      synchronized (i)
      {
        if ((e) && (a.d()) && (b.contains(localejc))) {
          localejc.a(null);
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
    return false;
  }
}

/* Location:
 * Qualified Name:     enb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */