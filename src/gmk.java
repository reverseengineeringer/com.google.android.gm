import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gmk
{
  static final gmk a = new gmk();
  volatile boolean b = true;
  volatile boolean c;
  volatile boolean d;
  final AtomicBoolean e = new AtomicBoolean(false);
  private final List<gmm> f = new ArrayList();
  
  final void a()
  {
    try
    {
      if (!c)
      {
        c = true;
        Iterator localIterator = f.iterator();
        while (localIterator.hasNext()) {
          ((gmm)localIterator.next()).a(this);
        }
        f.clear();
      }
    }
    finally {}
  }
  
  final void a(Context paramContext)
  {
    try
    {
      if (c) {
        return;
      }
      if (!b) {
        return;
      }
      if (a(paramContext, "primes::shutdown_primes"))
      {
        a();
        return;
      }
    }
    finally {}
    int i = 0;
    String str1 = paramContext.getPackageName();
    String str2 = String.valueOf("primes:");
    String str3 = String.valueOf(":enable_leak_detection");
    boolean bool = a(paramContext, String.valueOf(str2).length() + 0 + String.valueOf(str1).length() + String.valueOf(str3).length() + str2 + str1 + str3);
    if (d != bool)
    {
      d = bool;
      i = 1;
    }
    if (i != 0)
    {
      paramContext = f.iterator();
      while (paramContext.hasNext()) {
        ((gmm)paramContext.next()).a(this);
      }
    }
  }
  
  public final void a(gmm paramgmm)
  {
    try
    {
      if (!c) {
        f.add((gmm)gol.a(paramgmm));
      }
      return;
    }
    finally
    {
      paramgmm = finally;
      throw paramgmm;
    }
  }
  
  final boolean a(Context paramContext, String paramString)
  {
    if (!b) {
      return false;
    }
    try
    {
      boolean bool = ghz.a(paramContext.getContentResolver(), paramString, false);
      return bool;
    }
    catch (SecurityException paramContext)
    {
      if (Log.isLoggable("PrimesGservices", 5)) {
        Log.w("PrimesGservices", "Fail to read GServices.", paramContext);
      }
      b = false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     gmk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */