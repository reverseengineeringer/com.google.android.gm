import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

final class hge<F, T>
  extends AbstractList<T>
  implements Serializable, RandomAccess
{
  private static final long serialVersionUID = 0L;
  final List<F> a;
  final hav<? super F, ? extends T> b;
  
  hge(List<F> paramList, hav<? super F, ? extends T> paramhav)
  {
    a = ((List)hbe.a(paramList));
    b = ((hav)hbe.a(paramhav));
  }
  
  public final void clear()
  {
    a.clear();
  }
  
  public final T get(int paramInt)
  {
    return (T)b.apply(a.get(paramInt));
  }
  
  public final boolean isEmpty()
  {
    return a.isEmpty();
  }
  
  public final Iterator<T> iterator()
  {
    return listIterator();
  }
  
  public final ListIterator<T> listIterator(int paramInt)
  {
    return new hgf(this, a.listIterator(paramInt));
  }
  
  public final T remove(int paramInt)
  {
    return (T)b.apply(a.remove(paramInt));
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */