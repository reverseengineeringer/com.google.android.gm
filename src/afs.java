import android.content.ComponentName;
import java.math.BigDecimal;

public final class afs
{
  public final ComponentName a;
  public final long b;
  public final float c;
  
  public afs(ComponentName paramComponentName, long paramLong, float paramFloat)
  {
    a = paramComponentName;
    b = paramLong;
    c = paramFloat;
  }
  
  public afs(String paramString, long paramLong, float paramFloat)
  {
    this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
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
      paramObject = (afs)paramObject;
      if (a == null)
      {
        if (a != null) {
          return false;
        }
      }
      else if (!a.equals(a)) {
        return false;
      }
      if (b != b) {
        return false;
      }
    } while (Float.floatToIntBits(c) == Float.floatToIntBits(c));
    return false;
  }
  
  public final int hashCode()
  {
    if (a == null) {}
    for (int i = 0;; i = a.hashCode()) {
      return ((i + 31) * 31 + (int)(b ^ b >>> 32)) * 31 + Float.floatToIntBits(c);
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("; activity:").append(a);
    localStringBuilder.append("; time:").append(b);
    localStringBuilder.append("; weight:").append(new BigDecimal(c));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     afs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */