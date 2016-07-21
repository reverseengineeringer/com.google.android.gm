import java.io.Serializable;
import java.util.Comparator;

public final class hgc<T>
  extends hia<Iterable<T>>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final Comparator<? super T> a;
  
  public hgc(Comparator<? super T> paramComparator)
  {
    a = paramComparator;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof hgc))
    {
      paramObject = (hgc)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return a.hashCode() ^ 0x7BB78CF5;
  }
  
  public final String toString()
  {
    String str = String.valueOf(a);
    return String.valueOf(str).length() + 18 + str + ".lexicographical()";
  }
}

/* Location:
 * Qualified Name:     hgc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */