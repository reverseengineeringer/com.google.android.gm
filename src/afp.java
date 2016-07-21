import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

public final class afp
  implements Comparable<afp>
{
  public final ResolveInfo a;
  public float b;
  
  public afp(afo paramafo, ResolveInfo paramResolveInfo)
  {
    a = paramResolveInfo;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (afp)paramObject;
    } while (Float.floatToIntBits(b) == Float.floatToIntBits(b));
    return false;
  }
  
  public final int hashCode()
  {
    return Float.floatToIntBits(b) + 31;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("resolveInfo:").append(a.toString());
    localStringBuilder.append("; weight:").append(new BigDecimal(b));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     afp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */