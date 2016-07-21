import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

final class hgg<F, T>
  extends AbstractSequentialList<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final List<F> a;
  final hav<? super F, ? extends T> b;
  
  hgg(List<F> paramList, hav<? super F, ? extends T> paramhav)
  {
    a = ((List)hbe.a(paramList));
    b = ((hav)hbe.a(paramhav));
  }
  
  public final void clear()
  {
    a.clear();
  }
  
  public final ListIterator<T> listIterator(int paramInt)
  {
    return new hgh(this, a.listIterator(paramInt));
  }
  
  public final int size()
  {
    return a.size();
  }
}

/* Location:
 * Qualified Name:     hgg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */