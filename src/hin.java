import java.io.Serializable;

final class hin<T>
  extends hia<T>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hia<? super T> a;
  
  hin(hia<? super T> paramhia)
  {
    a = ((hia)hbe.a(paramhia));
  }
  
  public final <S extends T> hia<S> a()
  {
    return a;
  }
  
  public final int compare(T paramT1, T paramT2)
  {
    return a.compare(paramT2, paramT1);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof hin))
    {
      paramObject = (hin)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return -a.hashCode();
  }
  
  public final String toString()
  {
    String str = String.valueOf(a);
    return String.valueOf(str).length() + 10 + str + ".reverse()";
  }
}

/* Location:
 * Qualified Name:     hin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */