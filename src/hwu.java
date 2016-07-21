import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class hwu
  implements Serializable
{
  private static final NumberFormat b = new DecimalFormat("00");
  private static final NumberFormat c = new DecimalFormat("00");
  private static final NumberFormat d = new DecimalFormat("00");
  private static final long serialVersionUID = 5883111996721531728L;
  public long a;
  
  public hwu(String paramString)
  {
    if (paramString.length() < 5) {
      throw new IllegalArgumentException(String.valueOf(paramString).length() + 58 + "Invalid UTC offset [" + paramString + "] - must be of the form: (+/-)HHMM[SS]");
    }
    if (paramString.charAt(0) == '-') {}
    for (int i = 1; (i == 0) && (paramString.charAt(0) != '+'); i = 0) {
      throw new IllegalArgumentException("UTC offset value must be signed");
    }
    a = 0L;
    a += Integer.parseInt(paramString.substring(1, 3)) * 3600000L;
    a += Integer.parseInt(paramString.substring(3, 5)) * 60000L;
    if (paramString.length() == 7) {
      a += Integer.parseInt(paramString.substring(5, 7)) * 1000L;
    }
    if (i != 0) {
      a = (-a);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hwu)) {
      return a == a;
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return idlaa).a;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l = Math.abs(a);
    if (a < 0L) {
      localStringBuffer.append('-');
    }
    for (;;)
    {
      localStringBuffer.append(b.format(l / 3600000L));
      l %= 3600000L;
      localStringBuffer.append(c.format(l / 60000L));
      l %= 60000L;
      if (l > 0L) {
        localStringBuffer.append(d.format(l / 1000L));
      }
      return localStringBuffer.toString();
      localStringBuffer.append('+');
    }
  }
}

/* Location:
 * Qualified Name:     hwu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */