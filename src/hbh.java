import java.io.Serializable;
import java.util.Collection;

final class hbh<T>
  implements hbf<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final Collection<?> a;
  
  hbh(Collection<?> paramCollection)
  {
    a = ((Collection)hbe.a(paramCollection));
  }
  
  public final boolean apply(T paramT)
  {
    try
    {
      boolean bool = a.contains(paramT);
      return bool;
    }
    catch (ClassCastException paramT)
    {
      return false;
    }
    catch (NullPointerException paramT) {}
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hbh))
    {
      paramObject = (hbh)paramObject;
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
    String str = String.valueOf(a);
    return String.valueOf(str).length() + 15 + "Predicates.in(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     hbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */