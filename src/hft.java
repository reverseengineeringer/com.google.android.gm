import java.util.Collection;

public final class hft
{
  public static <T> T a(Iterable<T> paramIterable)
  {
    return (T)hfu.b(paramIterable.iterator());
  }
  
  public static <T> T[] a(Iterable<? extends T> paramIterable, Class<T> paramClass)
  {
    return a(paramIterable, hhz.a(paramClass, 0));
  }
  
  static <T> T[] a(Iterable<? extends T> paramIterable, T[] paramArrayOfT)
  {
    if ((paramIterable instanceof Collection)) {}
    for (paramIterable = (Collection)paramIterable;; paramIterable = hgd.a(paramIterable.iterator())) {
      return paramIterable.toArray(paramArrayOfT);
    }
  }
  
  public static <T> T b(T paramT)
  {
    return (T)hfu.b(paramT.iterator(), null);
  }
}

/* Location:
 * Qualified Name:     hft
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */