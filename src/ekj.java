import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class ekj
  implements eiz
{
  private final enc A = new ekm(this);
  final Lock a = new ReentrantLock();
  final Condition b;
  final enb c;
  final Context d;
  final Looper e;
  final Queue<eks<?>> f = new LinkedList();
  volatile boolean g;
  long h = 120000L;
  long i = 5000L;
  final eko j;
  final eih k;
  BroadcastReceiver l;
  final Map<eiu<?>, eit> m = new HashMap();
  final Map<eiu<?>, ConnectionResult> n = new HashMap();
  Set<Scope> o = new HashSet();
  final emc p;
  final Map<eip<?>, Integer> q;
  final eiq<? extends gdb, gcd> r;
  volatile ekt s;
  final Set<eks<?>> t = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
  private final int u;
  private final int v;
  private ConnectionResult w = null;
  private final Set<ekv<?>> x = Collections.newSetFromMap(new WeakHashMap());
  private final ekr y = new ekk(this);
  private final ejc z = new ekl(this);
  
  public ekj(Context paramContext, Looper paramLooper, emc paramemc, eih parameih, eiq<? extends gdb, gcd> parameiq, Map<eip<?>, eir> paramMap, ArrayList<ejc> paramArrayList, ArrayList<eje> paramArrayList1, int paramInt1, int paramInt2)
  {
    d = paramContext;
    c = new enb(paramLooper, A);
    e = paramLooper;
    j = new eko(this, paramLooper);
    k = parameih;
    u = paramInt1;
    v = paramInt2;
    q = new HashMap();
    b = a.newCondition();
    s = new eki(this);
    parameih = paramArrayList.iterator();
    while (parameih.hasNext())
    {
      paramArrayList = (ejc)parameih.next();
      c.a(paramArrayList);
    }
    parameih = paramArrayList1.iterator();
    while (parameih.hasNext())
    {
      paramArrayList = (eje)parameih.next();
      c.a(paramArrayList);
    }
    paramArrayList = d;
    paramArrayList1 = paramMap.keySet().iterator();
    eip localeip;
    if (paramArrayList1.hasNext())
    {
      localeip = (eip)paramArrayList1.next();
      parameih = paramMap.get(localeip);
      if (paramArrayList.get(localeip) == null) {
        break label592;
      }
      if (getb) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label408:
      q.put(localeip, Integer.valueOf(paramInt1));
      label436:
      boolean bool;
      label452:
      ejc localejc;
      eje localeje;
      if (b != null)
      {
        paramInt2 = 1;
        if (paramInt2 == 0) {
          break label550;
        }
        if (a == null) {
          break label544;
        }
        bool = true;
        enz.a(bool, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        parameih = a;
        localejc = z;
        localeje = a(localeip, paramInt1);
      }
      label544:
      label550:
      for (parameih = new eml(paramContext, paramLooper, parameih.b(), localejc, localeje, paramemc, parameih.a());; parameih = localeip.a().a(paramContext, paramLooper, paramemc, parameih, z, a(localeip, paramInt1)))
      {
        m.put(localeip.b(), parameih);
        break;
        paramInt1 = 2;
        break label408;
        paramInt2 = 0;
        break label436;
        bool = false;
        break label452;
      }
      p = paramemc;
      r = parameiq;
      return;
      label592:
      paramInt1 = 0;
    }
  }
  
  private final eje a(eip<?> parameip, int paramInt)
  {
    return new ekn(this, parameip, paramInt);
  }
  
  public final Looper a()
  {
    return e;
  }
  
  public final ConnectionResult a(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      enz.a(bool, "blockingConnect must not be called on the UI thread");
      a.lock();
      try
      {
        b();
        paramLong = paramTimeUnit.toNanos(paramLong);
        for (;;)
        {
          bool = s instanceof eju;
          if (!bool) {
            break;
          }
          try
          {
            long l1 = b.awaitNanos(paramLong);
            paramLong = l1;
            if (l1 <= 0L)
            {
              paramTimeUnit = new ConnectionResult(14, null);
              return paramTimeUnit;
            }
          }
          catch (InterruptedException paramTimeUnit)
          {
            Thread.currentThread().interrupt();
            paramTimeUnit = new ConnectionResult(15, null);
            return paramTimeUnit;
          }
        }
        bool = false;
        continue;
        if ((s instanceof ejs))
        {
          paramTimeUnit = ConnectionResult.a;
          return paramTimeUnit;
        }
        if (w != null)
        {
          paramTimeUnit = w;
          return paramTimeUnit;
        }
        paramTimeUnit = new ConnectionResult(13, null);
        return paramTimeUnit;
      }
      finally
      {
        a.unlock();
      }
    }
  }
  
  public final <C extends eit> C a(eiu<C> parameiu)
  {
    parameiu = (eit)m.get(parameiu);
    enz.a(parameiu, "Appropriate Api was not requested.");
    return parameiu;
  }
  
  public final <A extends eit, R extends ejk, T extends ejq<R, A>> T a(T paramT)
  {
    if (g != null) {}
    for (boolean bool = true;; bool = false)
    {
      enz.b(bool, "This task can not be enqueued (it's probably a Batch or malformed)");
      enz.b(m.containsKey(g), "GoogleApiClient is not configured to use the API required for this call.");
      a.lock();
      try
      {
        paramT = s.a(paramT);
        return paramT;
      }
      finally
      {
        a.unlock();
      }
    }
  }
  
  public final <L> ekv<L> a(L paramL)
  {
    enz.a(paramL, "Listener must not be null");
    a.lock();
    try
    {
      paramL = new ekv(e, paramL);
      x.add(paramL);
      return paramL;
    }
    finally
    {
      a.unlock();
    }
  }
  
  final void a(ConnectionResult paramConnectionResult)
  {
    a.lock();
    try
    {
      w = paramConnectionResult;
      s = new eki(this);
      s.a();
      b.signalAll();
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public final void a(ejc paramejc)
  {
    c.a(paramejc);
  }
  
  public final void a(eje parameje)
  {
    c.a(parameje);
  }
  
  final void a(ekp paramekp)
  {
    paramekp = j.obtainMessage(3, paramekp);
    j.sendMessage(paramekp);
  }
  
  final <A extends eit> void a(eks<A> parameks)
  {
    t.add(parameks);
    parameks.a(y);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    paramPrintWriter.append(paramString).append("mState=").append(s.d());
    paramPrintWriter.append(" mResuming=").print(g);
    paramPrintWriter.append(" mWorkQueue.size()=").print(f.size());
    paramPrintWriter.append(" mUnconsumedRunners.size()=").println(t.size());
    String str = paramString + "  ";
    Iterator localIterator = q.keySet().iterator();
    while (localIterator.hasNext())
    {
      eip localeip = (eip)localIterator.next();
      paramPrintWriter.append(paramString).append(c).println(":");
      ((eit)m.get(localeip.b())).a(str, paramPrintWriter);
    }
  }
  
  public final <A extends eit, T extends ejq<? extends ejk, A>> T b(T paramT)
  {
    boolean bool;
    if (g != null) {
      bool = true;
    }
    for (;;)
    {
      enz.b(bool, "This task can not be executed (it's probably a Batch or malformed)");
      a.lock();
      try
      {
        if (!g) {
          break label113;
        }
        f.add(paramT);
        while (!f.isEmpty())
        {
          eks localeks = (eks)f.remove();
          a(localeks);
          localeks.c(Status.c);
        }
        bool = false;
      }
      finally
      {
        a.unlock();
      }
    }
    a.unlock();
    return paramT;
    label113:
    paramT = s.b(paramT);
    a.unlock();
    return paramT;
  }
  
  public final void b()
  {
    a.lock();
    try
    {
      s.c();
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public final void b(ejc paramejc)
  {
    enb localenb = c;
    enz.a(paramejc);
    synchronized (i)
    {
      if (!b.remove(paramejc)) {
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramejc + " not found");
      }
      while (!g) {
        return;
      }
      c.add(paramejc);
    }
  }
  
  public final void b(eje parameje)
  {
    enb localenb = c;
    enz.a(parameje);
    synchronized (i)
    {
      if (!d.remove(parameje)) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + parameje + " not found");
      }
      return;
    }
  }
  
  public final ConnectionResult c()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    }
    for (;;)
    {
      enz.a(bool, "blockingConnect must not be called on the UI thread");
      a.lock();
      try
      {
        b();
        for (;;)
        {
          bool = s instanceof eju;
          if (!bool) {
            break label89;
          }
          try
          {
            b.await();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
            localConnectionResult = new ConnectionResult(15, null);
            return localConnectionResult;
          }
        }
        bool = false;
        continue;
        label89:
        if ((s instanceof ejs))
        {
          localConnectionResult = ConnectionResult.a;
          return localConnectionResult;
        }
        if (w != null)
        {
          localConnectionResult = w;
          return localConnectionResult;
        }
        ConnectionResult localConnectionResult = new ConnectionResult(13, null);
        return localConnectionResult;
      }
      finally
      {
        a.unlock();
      }
    }
  }
  
  public final void d()
  {
    a.lock();
    try
    {
      h();
      s.b();
      return;
    }
    finally
    {
      a.unlock();
    }
  }
  
  public final boolean e()
  {
    return s instanceof ejs;
  }
  
  public final boolean f()
  {
    return s instanceof eju;
  }
  
  final void g()
  {
    Iterator localIterator = t.iterator();
    while (localIterator.hasNext())
    {
      eks localeks = (eks)localIterator.next();
      localeks.a(null);
      localeks.b();
    }
    t.clear();
    localIterator = x.iterator();
    while (localIterator.hasNext()) {
      nexta = null;
    }
    x.clear();
  }
  
  final boolean h()
  {
    if (!g) {
      return false;
    }
    g = false;
    j.removeMessages(2);
    j.removeMessages(1);
    if (l != null)
    {
      d.getApplicationContext().unregisterReceiver(l);
      l = null;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     ekj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */