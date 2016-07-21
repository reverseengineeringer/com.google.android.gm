import java.io.Serializable;

public final class hhy
  extends hia<Comparable>
  implements Serializable
{
  public static final hhy a = new hhy();
  private static final long serialVersionUID = 0L;
  
  private final Object readResolve()
  {
    return a;
  }
  
  public final <S extends Comparable> hia<S> a()
  {
    return him.a;
  }
  
  public final String toString()
  {
    return "Ordering.natural()";
  }
}

/* Location:
 * Qualified Name:     hhy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */