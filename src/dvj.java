import android.content.Context;
import android.util.LruCache;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class dvj
{
  public final Map<Long, dvk> a = new HashMap();
  public final Map<String, Integer> b = new HashMap();
  public final LruCache<String, WeakReference<dvp>> c = new LruCache(3);
  private final String d;
  private final drp e;
  
  public dvj(String paramString, drp paramdrp)
  {
    d = paramString;
    e = paramdrp;
  }
  
  public final dvk a(long paramLong)
  {
    synchronized (a)
    {
      dvk localdvk = (dvk)a.get(Long.valueOf(paramLong));
      return localdvk;
    }
  }
  
  public final dvk a(Context paramContext, long paramLong)
  {
    synchronized (a)
    {
      if (a.containsKey(Long.valueOf(paramLong)))
      {
        paramContext = (dvk)a.get(Long.valueOf(paramLong));
        return paramContext;
      }
      paramContext = new dvk(paramContext, d, paramLong, e);
      a.put(Long.valueOf(paramLong), paramContext);
    }
  }
  
  public final void a(String paramString)
  {
    if (!b.containsKey(paramString))
    {
      b.clear();
      b.put(paramString, Integer.valueOf(0));
    }
  }
}

/* Location:
 * Qualified Name:     dvj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */