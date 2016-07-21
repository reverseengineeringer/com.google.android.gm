import java.io.Serializable;
import java.util.Arrays;

final class hcv<F, T>
  extends hia<F>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  final hav<F, ? extends T> a;
  final hia<T> b;
  
  hcv(hav<F, ? extends T> paramhav, hia<T> paramhia)
  {
    a = ((hav)hbe.a(paramhav));
    b = ((hia)hbe.a(paramhia));
  }
  
  public final int compare(F paramF1, F paramF2)
  {
    return b.compare(a.apply(paramF1), a.apply(paramF2));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof hcv)) {
        break;
      }
      paramObject = (hcv)paramObject;
    } while ((a.equals(a)) && (b.equals(b)));
    return false;
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b });
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(b);
    String str2 = String.valueOf(a);
    return String.valueOf(str1).length() + 13 + String.valueOf(str2).length() + str1 + ".onResultOf(" + str2 + ")";
  }
}

/* Location:
 * Qualified Name:     hcv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */