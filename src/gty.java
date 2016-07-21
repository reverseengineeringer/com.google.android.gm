import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Pattern;

public final class gty
  implements Serializable
{
  static final TimeZone a = TimeZone.getTimeZone("GMT");
  static final Pattern b = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
  private static final long serialVersionUID = 1L;
  private final long c;
  private final boolean d;
  private final int e;
  
  public gty()
  {
    this(false, 0L, null);
  }
  
  public gty(boolean paramBoolean, long paramLong, Integer paramInteger)
  {
    d = paramBoolean;
    c = paramLong;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      e = i;
      return;
      if (paramInteger == null) {
        i = TimeZone.getDefault().getOffset(paramLong) / 60000;
      } else {
        i = paramInteger.intValue();
      }
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0)
    {
      paramStringBuilder.append('-');
      i = -paramInt1;
    }
    paramInt1 = i;
    while (paramInt1 > 0)
    {
      paramInt1 /= 10;
      paramInt2 -= 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramStringBuilder.append('0');
      paramInt1 += 1;
    }
    if (i != 0) {
      paramStringBuilder.append(i);
    }
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(a);
    localGregorianCalendar.setTimeInMillis(c + e * 60000L);
    a(localStringBuilder, localGregorianCalendar.get(1), 4);
    localStringBuilder.append('-');
    a(localStringBuilder, localGregorianCalendar.get(2) + 1, 2);
    localStringBuilder.append('-');
    a(localStringBuilder, localGregorianCalendar.get(5), 2);
    if (!d)
    {
      localStringBuilder.append('T');
      a(localStringBuilder, localGregorianCalendar.get(11), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(12), 2);
      localStringBuilder.append(':');
      a(localStringBuilder, localGregorianCalendar.get(13), 2);
      if (localGregorianCalendar.isSet(14))
      {
        localStringBuilder.append('.');
        a(localStringBuilder, localGregorianCalendar.get(14), 3);
      }
      if (e == 0) {
        localStringBuilder.append('Z');
      }
    }
    else
    {
      return localStringBuilder.toString();
    }
    int i = e;
    if (e > 0) {
      localStringBuilder.append('+');
    }
    for (;;)
    {
      a(localStringBuilder, i / 60, 2);
      localStringBuilder.append(':');
      a(localStringBuilder, i % 60, 2);
      break;
      localStringBuilder.append('-');
      i = -i;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof gty)) {
        return false;
      }
      paramObject = (gty)paramObject;
    } while ((d == d) && (c == c) && (e == e));
    return false;
  }
  
  public final int hashCode()
  {
    long l2 = c;
    if (d) {}
    for (long l1 = 1L;; l1 = 0L) {
      return Arrays.hashCode(new long[] { l2, l1, e });
    }
  }
  
  public final String toString()
  {
    return a();
  }
}

/* Location:
 * Qualified Name:     gty
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */