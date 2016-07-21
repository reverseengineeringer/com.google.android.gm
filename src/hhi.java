import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class hhi<K, V>
  extends WeakReference<V>
  implements hhf<K, V>
{
  final hgv<K, V> a;
  
  hhi(ReferenceQueue<V> paramReferenceQueue, V paramV, hgv<K, V> paramhgv)
  {
    super(paramV, paramReferenceQueue);
    a = paramhgv;
  }
  
  public final hgv<K, V> a()
  {
    return a;
  }
  
  public final hhf<K, V> a(ReferenceQueue<V> paramReferenceQueue, V paramV, hgv<K, V> paramhgv)
  {
    return new hhi(paramReferenceQueue, paramV, paramhgv);
  }
  
  public final void b()
  {
    clear();
  }
}

/* Location:
 * Qualified Name:     hhi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */