import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.ValidateAccountRequest;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class emr<T extends IInterface>
  implements eit, enc
{
  public static final String[] e = { "service_esmobile", "service_googleme" };
  public final Context a;
  public final emc b;
  final Handler c;
  public AtomicInteger d = new AtomicInteger(0);
  private final Looper f;
  private final end g;
  private final eih h;
  private final Object i = new Object();
  private enq j;
  private ejd k;
  private T l;
  private final ArrayList<emu<?>> m = new ArrayList();
  private emw n;
  private int o = 1;
  private final Set<Scope> p;
  private final Account q;
  private final ejc r;
  private final eje s;
  private final int t;
  
  public emr(Context paramContext, Looper paramLooper, int paramInt, emc paramemc, ejc paramejc, eje parameje)
  {
    this(paramContext, paramLooper, end.a(paramContext), eih.b, paramInt, paramemc, (ejc)enz.a(paramejc), (eje)enz.a(parameje));
  }
  
  private emr(Context paramContext, Looper paramLooper, end paramend, eih parameih, int paramInt, emc paramemc, ejc paramejc, eje parameje)
  {
    a = ((Context)enz.a(paramContext, "Context must not be null"));
    f = ((Looper)enz.a(paramLooper, "Looper must not be null"));
    g = ((end)enz.a(paramend, "Supervisor must not be null"));
    h = ((eih)enz.a(parameih, "API availability must not be null"));
    c = new emt(this, paramLooper);
    t = paramInt;
    b = ((emc)enz.a(paramemc));
    q = a;
    p = a(c);
    r = paramejc;
    s = parameje;
  }
  
  private static Set<Scope> a(Set<Scope> paramSet)
  {
    if (paramSet == null) {}
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        return paramSet;
        localIterator = paramSet.iterator();
      }
    } while (paramSet.contains((Scope)localIterator.next()));
    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
  }
  
  private final void a(int paramInt, T paramT)
  {
    boolean bool = true;
    int i1;
    int i2;
    if (paramInt == 3)
    {
      i1 = 1;
      if (paramT == null) {
        break label290;
      }
      i2 = 1;
      label17:
      if (i1 != i2) {
        break label296;
      }
    }
    for (;;)
    {
      enz.b(bool);
      for (;;)
      {
        synchronized (i)
        {
          o = paramInt;
          l = paramT;
          switch (paramInt)
          {
          case 3: 
            return;
          case 2: 
            if (n != null)
            {
              Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + a());
              g.b(a(), n, b.f);
              d.incrementAndGet();
            }
            n = new emw(this, d.get());
            if (g.a(a(), n, b.f)) {
              continue;
            }
            Log.e("GmsClient", "unable to connect to service: " + a());
            c.sendMessage(c.obtainMessage(3, d.get(), 9));
          }
        }
        if (n != null)
        {
          g.b(a(), n, b.f);
          n = null;
        }
      }
      i1 = 0;
      break;
      label290:
      i2 = 0;
      break label17;
      label296:
      bool = false;
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, T paramT)
  {
    synchronized (i)
    {
      if (o != paramInt1) {
        return false;
      }
      a(paramInt2, paramT);
      return true;
    }
  }
  
  protected static void f() {}
  
  protected static void g() {}
  
  private final void m()
  {
    c.sendMessage(c.obtainMessage(4, d.get(), 1));
  }
  
  public abstract T a(IBinder paramIBinder);
  
  public abstract String a();
  
  public void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    c.sendMessage(c.obtainMessage(1, paramInt2, -1, new emy(this, paramInt1, paramIBinder, paramBundle)));
  }
  
  public final void a(ejd paramejd)
  {
    k = ((ejd)enz.a(paramejd, "Connection progress callbacks cannot be null."));
    a(2, null);
  }
  
  public final void a(eme parameme)
  {
    parameme = new ValidateAccountRequest(parameme, (Scope[])p.toArray(new Scope[p.size()]), a.getPackageName(), null);
    try
    {
      j.a(new emv(this, d.get()), parameme);
      return;
    }
    catch (DeadObjectException parameme)
    {
      Log.w("GmsClient", "service died");
      m();
      return;
    }
    catch (RemoteException parameme)
    {
      Log.w("GmsClient", "Remote exception occurred", parameme);
    }
  }
  
  public final void a(eme parameme, Set<Scope> paramSet)
  {
    for (;;)
    {
      try
      {
        Bundle localBundle = i();
        localGetServiceRequest = new GetServiceRequest(t);
        d = a.getPackageName();
        g = localBundle;
        if (paramSet != null) {
          f = ((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
        }
        if (!e()) {
          continue;
        }
        if (q == null) {
          continue;
        }
        paramSet = q;
        h = paramSet;
        if (parameme != null) {
          e = parameme.asBinder();
        }
      }
      catch (DeadObjectException parameme)
      {
        GetServiceRequest localGetServiceRequest;
        Log.w("GmsClient", "service died");
        m();
        return;
        if (!l()) {
          continue;
        }
        h = q;
        continue;
      }
      catch (RemoteException parameme)
      {
        Log.w("GmsClient", "Remote exception occurred", parameme);
      }
      j.a(new emv(this, d.get()), localGetServiceRequest);
      return;
      paramSet = new Account("<<default account>>", "com.google");
    }
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    IInterface localIInterface;
    for (;;)
    {
      synchronized (i)
      {
        int i1 = o;
        localIInterface = l;
        paramPrintWriter.append(paramString).append("mConnectState=");
        switch (i1)
        {
        default: 
          paramPrintWriter.print("UNKNOWN");
          paramPrintWriter.append(" mService=");
          if (localIInterface != null) {
            break label142;
          }
          paramPrintWriter.println("null");
          return;
        }
      }
      paramPrintWriter.print("CONNECTING");
      continue;
      paramPrintWriter.print("CONNECTED");
      continue;
      paramPrintWriter.print("DISCONNECTING");
      continue;
      paramPrintWriter.print("DISCONNECTED");
    }
    label142:
    paramPrintWriter.append(b()).append("@").println(Integer.toHexString(System.identityHashCode(localIInterface.asBinder())));
  }
  
  public abstract String b();
  
  public void c()
  {
    d.incrementAndGet();
    synchronized (m)
    {
      int i2 = m.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((emu)m.get(i1)).c();
        i1 += 1;
      }
      m.clear();
      a(1, null);
      return;
    }
  }
  
  public final boolean d()
  {
    for (;;)
    {
      synchronized (i)
      {
        if (o == 3)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public boolean e()
  {
    return false;
  }
  
  public final boolean h()
  {
    for (;;)
    {
      synchronized (i)
      {
        if (o == 2)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public Bundle i()
  {
    return new Bundle();
  }
  
  public final void j()
  {
    if (!d()) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
  }
  
  public final T k()
  {
    synchronized (i)
    {
      if (o == 4) {
        throw new DeadObjectException();
      }
    }
    j();
    if (l != null) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "Client is connected but service is null");
      IInterface localIInterface = l;
      return localIInterface;
    }
  }
  
  public boolean l()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     emr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */