import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class hgi
{
  boolean a;
  int b = -1;
  int c = -1;
  hgz d;
  hgz e;
  has<Object> f;
  
  final int a()
  {
    if (b == -1) {
      return 16;
    }
    return b;
  }
  
  final int b()
  {
    if (c == -1) {
      return 4;
    }
    return c;
  }
  
  final hgz c()
  {
    return (hgz)haz.a(d, hgz.a);
  }
  
  public final <K, V> ConcurrentMap<K, V> d()
  {
    if (!a) {
      return new ConcurrentHashMap(a(), 0.75F, b());
    }
    return new hgj(this);
  }
  
  public final String toString()
  {
    hba localhba = new hba(getClass().getSimpleName());
    if (b != -1) {
      localhba.a("initialCapacity", b);
    }
    if (c != -1) {
      localhba.a("concurrencyLevel", c);
    }
    if (d != null) {
      localhba.a("keyStrength", gzw.a(d.toString()));
    }
    if (e != null) {
      localhba.a("valueStrength", gzw.a(e.toString()));
    }
    if (f != null) {
      ab = "keyEquivalence";
    }
    return localhba.toString();
  }
}

/* Location:
 * Qualified Name:     hgi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */