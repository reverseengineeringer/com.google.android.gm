import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class ejn<R extends ejk>
  implements ejh<R>
{
  private final CountDownLatch a = new CountDownLatch(1);
  public final Object b = new Object();
  public final ejo<R> c;
  public final ArrayList<eji> d = new ArrayList();
  public volatile R e;
  public volatile boolean f;
  private ejl<R> g;
  private boolean h;
  private boolean i;
  private enk j;
  
  protected ejn(Looper paramLooper)
  {
    c = new ejo(paramLooper);
  }
  
  static void b(ejk paramejk)
  {
    if ((paramejk instanceof ejj)) {}
    try
    {
      ((ejj)paramejk).b();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("AbstractPendingResult", "Unable to release " + paramejk, localRuntimeException);
    }
  }
  
  private final void c(R paramR)
  {
    e = paramR;
    j = null;
    a.countDown();
    paramR = e;
    if (g != null)
    {
      c.removeMessages(2);
      if (!h) {
        c.a(g, g());
      }
    }
    paramR = d.iterator();
    while (paramR.hasNext()) {
      ((eji)paramR.next()).a();
    }
    d.clear();
  }
  
  private boolean e()
  {
    return a.getCount() == 0L;
  }
  
  private final boolean f()
  {
    synchronized (b)
    {
      boolean bool = h;
      return bool;
    }
  }
  
  private final R g()
  {
    boolean bool = true;
    synchronized (b)
    {
      if (!f)
      {
        enz.a(bool, "Result has already been consumed.");
        enz.a(e(), "Result is not ready.");
        ejk localejk = e;
        e = null;
        g = null;
        f = true;
        c();
        return localejk;
      }
      bool = false;
    }
  }
  
  public final R a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = true;
    }
    for (;;)
    {
      enz.a(bool1, "await must not be called on the UI thread");
      if (!f)
      {
        bool1 = bool2;
        enz.a(bool1, "Result has already been consumed");
      }
      try
      {
        a.await();
        enz.a(e(), "Result is not ready.");
        return g();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          b(Status.b);
        }
      }
    }
  }
  
  public final R a(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramLong <= 0L) || (Looper.myLooper() != Looper.getMainLooper())) {
      bool1 = true;
    }
    for (;;)
    {
      enz.a(bool1, "await must not be called on the UI thread when time is greater than zero.");
      if (!f)
      {
        bool1 = bool2;
        enz.a(bool1, "Result has already been consumed.");
      }
      try
      {
        if (!a.await(paramLong, paramTimeUnit)) {
          b(Status.d);
        }
        enz.a(e(), "Result is not ready.");
        return g();
        bool1 = false;
        continue;
        bool1 = false;
      }
      catch (InterruptedException paramTimeUnit)
      {
        for (;;)
        {
          b(Status.b);
        }
      }
    }
  }
  
  public abstract R a(Status paramStatus);
  
  public final void a(eji parameji)
  {
    if (!f) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "Result has already been consumed.");
      synchronized (b)
      {
        if (e())
        {
          ejk localejk = e;
          parameji.a();
          return;
        }
        d.add(parameji);
      }
    }
  }
  
  public final void a(R paramR)
  {
    boolean bool2 = true;
    for (;;)
    {
      synchronized (b)
      {
        if ((i) || (h))
        {
          b(paramR);
          return;
        }
        if (!e())
        {
          bool1 = true;
          enz.a(bool1, "Results have already been set");
          if (f) {
            break label83;
          }
          bool1 = bool2;
          enz.a(bool1, "Result has already been consumed");
          c(paramR);
          return;
        }
      }
      boolean bool1 = false;
      continue;
      label83:
      bool1 = false;
    }
  }
  
  public final void a(ejl<R> paramejl)
  {
    if (!f) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool, "Result has already been consumed.");
      for (;;)
      {
        synchronized (b)
        {
          if (f()) {
            return;
          }
          if (e())
          {
            c.a(paramejl, g());
            return;
          }
        }
        g = paramejl;
      }
    }
  }
  
  public final void a(enk paramenk)
  {
    synchronized (b)
    {
      j = paramenk;
      return;
    }
  }
  
  public final void b()
  {
    synchronized (b)
    {
      if ((h) || (f)) {
        return;
      }
      enk localenk = j;
      if (localenk == null) {}
    }
    try
    {
      j.a();
      b(e);
      g = null;
      h = true;
      c(a(Status.e));
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public final void b(Status paramStatus)
  {
    synchronized (b)
    {
      if (!e())
      {
        a(a(paramStatus));
        i = true;
      }
      return;
    }
  }
  
  protected void c() {}
}

/* Location:
 * Qualified Name:     ejn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */