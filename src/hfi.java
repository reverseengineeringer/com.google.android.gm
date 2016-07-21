import java.util.Comparator;

final class hfi<E>
  extends hic<E>
  implements hit<E>
{
  hfi(hfp<E> paramhfp, hef<E> paramhef)
  {
    super(paramhfp, paramhef);
  }
  
  final hef<E> b(int paramInt1, int paramInt2)
  {
    return new hil(super.b(paramInt1, paramInt2), comparator()).f();
  }
  
  public final Comparator<? super E> comparator()
  {
    return ((hfp)super.b()).comparator();
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public final int indexOf(Object paramObject)
  {
    int i = ((hfp)super.b()).a(paramObject);
    if ((i >= 0) && (get(i).equals(paramObject))) {
      return i;
    }
    return -1;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    return indexOf(paramObject);
  }
}

/* Location:
 * Qualified Name:     hfi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */