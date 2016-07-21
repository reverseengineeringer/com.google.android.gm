import java.io.Serializable;
import java.util.Comparator;

final class hcy<T>
  extends hia<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<T> a;
  
  hcy(Comparator<T> paramComparator)
  {
    a = ((Comparator)hbe.a(paramComparator));
  }
  
  public final int compare(T paramT1, T paramT2)
  {
    return a.compare(paramT1, paramT2);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof hcy))
    {
      paramObject = (hcy)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return a.hashCode();
  }
  
  public final String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     hcy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */