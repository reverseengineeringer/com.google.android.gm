import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ny<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ny(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    c = paramInt;
    a = new LinkedHashMap(0, 0.75F, true);
  }
  
  private final void a(int paramInt)
  {
    Object localObject3;
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
      localObject3 = (Map.Entry)a.entrySet().iterator().next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = ((Map.Entry)localObject3).getValue();
      a.remove(localObject2);
      b -= 1;
      e += 1;
    }
  }
  
  public final V a(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
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
  
  public final V a(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new NullPointerException("key == null || value == null");
    }
    try
    {
      d += 1;
      b += 1;
      paramK = a.put(paramK, paramV);
      if (paramK != null) {
        b -= 1;
      }
      if (paramK != null) {
        a(false, paramK, paramV);
      }
      a(c);
      return paramK;
    }
    finally {}
  }
  
  public void a(V paramV) {}
  
  public final V b(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    try
    {
      paramK = a.remove(paramK);
      if (paramK != null) {
        b -= 1;
      }
      if (paramK != null) {
        a(false, paramK, null);
      }
      return paramK;
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
 * Qualified Name:     ny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */