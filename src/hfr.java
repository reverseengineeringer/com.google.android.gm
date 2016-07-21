import java.io.Serializable;
import java.util.Comparator;

final class hfr<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super E> a;
  final Object[] b;
  
  public hfr(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
  {
    a = paramComparator;
    b = paramArrayOfObject;
  }
  
  final Object readResolve()
  {
    return new hfq(a).c(b).b();
  }
}

/* Location:
 * Qualified Name:     hfr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */