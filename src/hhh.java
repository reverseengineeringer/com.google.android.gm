import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class hhh<K, V>
  extends WeakReference<K>
  implements hgv<K, V>
{
  final int a;
  final hgv<K, V> b;
  volatile hhf<K, V> c = hgj.j;
  
  hhh(ReferenceQueue<K> paramReferenceQueue, K paramK, int paramInt, hgv<K, V> paramhgv)
  {
    super(paramK, paramReferenceQueue);
    a = paramInt;
    b = paramhgv;
  }
  
  public final hhf<K, V> a()
  {
    return c;
  }
  
  public final void a(hhf<K, V> paramhhf)
  {
    hhf localhhf = c;
    c = paramhhf;
    localhhf.b();
  }
  
  public final hgv<K, V> b()
  {
    return b;
  }
  
  public final int c()
  {
    return a;
  }
  
  public final K d()
  {
    return (K)get();
  }
}

/* Location:
 * Qualified Name:     hhh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */