import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

class hgm<K, V>
  extends hda<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  final hgz a;
  final hgz b;
  final has<Object> c;
  final has<Object> d;
  final int e;
  transient ConcurrentMap<K, V> f;
  
  hgm(hgz paramhgz1, hgz paramhgz2, has<Object> paramhas1, has<Object> paramhas2, int paramInt, ConcurrentMap<K, V> paramConcurrentMap)
  {
    a = paramhgz1;
    b = paramhgz2;
    c = paramhas1;
    d = paramhas2;
    e = paramInt;
    f = paramConcurrentMap;
  }
  
  protected final ConcurrentMap<K, V> a()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     hgm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */