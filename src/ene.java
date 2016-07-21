import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashMap;
import java.util.Set;

final class ene
  extends end
  implements Handler.Callback
{
  private final HashMap<enf, eng> a = new HashMap();
  private final Context b;
  private final Handler c;
  private final eop d;
  private final long e;
  
  ene(Context paramContext)
  {
    b = paramContext.getApplicationContext();
    c = new Handler(paramContext.getMainLooper(), this);
    d = eop.a();
    e = 5000L;
  }
  
  private final void a(enf paramenf, ServiceConnection paramServiceConnection)
  {
    enz.a(paramServiceConnection, "ServiceConnection must not be null");
    eng localeng;
    synchronized (a)
    {
      localeng = (eng)a.get(paramenf);
      if (localeng == null) {
        throw new IllegalStateException("Nonexistent connection status for service config: " + paramenf);
      }
    }
    if (!localeng.a(paramServiceConnection)) {
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + paramenf);
    }
    h.d.a(h.b, paramServiceConnection, null, null, 4);
    b.remove(paramServiceConnection);
    if (localeng.a())
    {
      paramenf = c.obtainMessage(0, localeng);
      c.sendMessageDelayed(paramenf, e);
    }
  }
  
  private final boolean a(enf paramenf, ServiceConnection paramServiceConnection, String paramString)
  {
    enz.a(paramServiceConnection, "ServiceConnection must not be null");
    for (;;)
    {
      eng localeng;
      synchronized (a)
      {
        localeng = (eng)a.get(paramenf);
        if (localeng == null)
        {
          localeng = new eng(this, paramenf);
          localeng.a(paramServiceConnection, paramString);
          localeng.a(paramString);
          a.put(paramenf, localeng);
          paramenf = localeng;
          boolean bool = d;
          return bool;
        }
        c.removeMessages(0, localeng);
        if (localeng.a(paramServiceConnection)) {
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramenf);
        }
      }
      localeng.a(paramServiceConnection, paramString);
      switch (c)
      {
      case 1: 
        paramServiceConnection.onServiceConnected(g, e);
        paramenf = localeng;
        break;
      case 2: 
        localeng.a(paramString);
        paramenf = localeng;
        break;
      default: 
        paramenf = localeng;
      }
    }
  }
  
  public final boolean a(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    return a(new enf(paramComponentName), paramServiceConnection, paramString);
  }
  
  public final boolean a(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return a(new enf(paramString1), paramServiceConnection, paramString2);
  }
  
  public final void b(ComponentName paramComponentName, ServiceConnection paramServiceConnection, String paramString)
  {
    a(new enf(paramComponentName), paramServiceConnection);
  }
  
  public final void b(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    a(new enf(paramString1), paramServiceConnection);
  }
  
  public final boolean handleMessage(Message arg1)
  {
    switch (what)
    {
    default: 
      return false;
    }
    eng localeng = (eng)obj;
    synchronized (a)
    {
      if (localeng.a())
      {
        if (d)
        {
          h.d.a(h.b, a);
          d = false;
          c = 2;
        }
        a.remove(f);
      }
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     ene
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */