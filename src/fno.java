import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class fno<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  private final int b(K paramK, V paramV)
  {
    int i = a(paramV);
    if (i < 0) {
      throw new IllegalStateException("Negative size: " + paramK + "=" + paramV);
    }
    return i;
  }
  
  public int a(V paramV)
  {
    return 1;
  }
  
  public final V a(K paramK, V paramV)
  {
    if (paramV == null) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      d += 1;
      b += b(paramK, paramV);
      paramV = a.put(paramK, paramV);
      if (paramV != null) {
        b -= b(paramK, paramV);
      }
      a(c);
      return paramV;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    try
    {
      if ((b < 0) || ((a.isEmpty()) && (b != 0))) {
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
      }
    }
    finally
    {
      throw ((Throwable)localObject1);
      if ((b <= paramInt) || (a.isEmpty())) {
        return;
      }
      Object localObject3 = (Map.Entry)a.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      a.remove(localObject2);
      b -= b(localObject2, localObject3);
      e += 1;
    }
  }
  
  public final V b(K paramK)
  {
    try
    {
      paramK = a.get(paramK);
      if (paramK != null)
      {
        f += 1;
        return paramK;
      }
      g += 1;
      return null;
    }
    finally {}
  }
  
  public final String toString()
  {
    int i = 0;
    try
    {
      int j = f + g;
      if (j != 0) {
        i = f * 100 / j;
      }
      String str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(c), Integer.valueOf(f), Integer.valueOf(g), Integer.valueOf(i) });
      return str;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     fno
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */