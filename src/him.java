import java.io.Serializable;

final class him
  extends hia<Comparable>
  implements Serializable
{
  static final him a = new him();
  private static final long serialVersionUID = 0L;
  
  private final Object readResolve()
  {
    return a;
  }
  
  public final <S extends Comparable> hia<S> a()
  {
    return hhy.a;
  }
  
  public final String toString()
  {
    return "Ordering.natural().reverse()";
  }
}

/* Location:
 * Qualified Name:     him
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */