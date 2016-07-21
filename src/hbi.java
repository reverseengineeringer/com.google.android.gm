import java.io.Serializable;

final class hbi<T>
  implements hbf<T>, Serializable
{
  private static final long serialVersionUID = 0L;
  private final T a;
  
  hbi(T paramT)
  {
    a = paramT;
  }
  
  public final boolean apply(T paramT)
  {
    return a.equals(paramT);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hbi))
    {
      paramObject = (hbi)paramObject;
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
    return String.valueOf(str).length() + 20 + "Predicates.equalTo(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     hbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */