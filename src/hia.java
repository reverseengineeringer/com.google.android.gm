import java.util.Comparator;

public abstract class hia<T>
  implements Comparator<T>
{
  public static <T> hia<T> a(Comparator<T> paramComparator)
  {
    if ((paramComparator instanceof hia)) {
      return (hia)paramComparator;
    }
    return new hcy(paramComparator);
  }
  
  public <S extends T> hia<S> a()
  {
    return new hin(this);
  }
  
  public final <F> hia<F> a(hav<F, ? extends T> paramhav)
  {
    return new hcv(paramhav, this);
  }
  
  public abstract int compare(T paramT1, T paramT2);
}

/* Location:
 * Qualified Name:     hia
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */