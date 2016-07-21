import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ggu
  extends emr<gfw>
{
  final ExecutorService f = Executors.newCachedThreadPool();
  private final gfz<gdh> g = new gfz();
  private final gfz<gdf> h = new gfz();
  private final gfz<gdl> i = new gfz();
  private final gfz<gdp> j = new gfz();
  private final gfz<gdx> k = new gfz();
  private final gfz<geb> l = new gfz();
  private final gfz<gea> m = new gfz();
  private final Map<String, gfz<gdj>> n = new HashMap();
  
  public ggu(Context paramContext, Looper paramLooper, ejc paramejc, eje parameje, emc paramemc)
  {
    super(paramContext, paramLooper, 14, paramemc, paramejc, parameje);
  }
  
  protected final String a()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      new StringBuilder("onPostInitHandler: statusCode ").append(paramInt1);
    }
    if (paramInt1 == 0)
    {
      g.a(paramIBinder);
      h.a(paramIBinder);
      j.a(paramIBinder);
      k.a(paramIBinder);
      l.a(paramIBinder);
      m.a(paramIBinder);
      synchronized (n)
      {
        Iterator localIterator = n.values().iterator();
        if (localIterator.hasNext()) {
          ((gfz)localIterator.next()).a(paramIBinder);
        }
      }
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  public final void c()
  {
    g.a(this);
    h.a(this);
    j.a(this);
    k.a(this);
    l.a(this);
    m.a(this);
    synchronized (n)
    {
      Iterator localIterator = n.values().iterator();
      if (localIterator.hasNext()) {
        ((gfz)localIterator.next()).a(this);
      }
    }
    super.c();
  }
}

/* Location:
 * Qualified Name:     ggu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */