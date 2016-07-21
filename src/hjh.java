import java.util.ListIterator;

abstract class hjh<F, T>
  extends hjg<F, T>
  implements ListIterator<T>
{
  hjh(ListIterator<? extends F> paramListIterator)
  {
    super(paramListIterator);
  }
  
  public void add(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean hasPrevious()
  {
    return hfu.e(b).hasPrevious();
  }
  
  public final int nextIndex()
  {
    return hfu.e(b).nextIndex();
  }
  
  public final T previous()
  {
    return (T)a(hfu.e(b).previous());
  }
  
  public final int previousIndex()
  {
    return hfu.e(b).previousIndex();
  }
  
  public void set(T paramT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     hjh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */