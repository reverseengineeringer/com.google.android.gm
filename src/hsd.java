import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class hsd
{
  private static final Log a = LogFactory.getLog(hsd.class);
  
  public static DateFormat a(String paramString)
  {
    if ((paramString.equals("yyyyMMdd'T'HHmmss")) || (paramString.equals("yyyyMMdd'T'HHmmss'Z'"))) {
      return new hsg(paramString);
    }
    if (paramString.equals("yyyyMMdd")) {
      return new hsf(paramString);
    }
    if ((paramString.equals("HHmmss")) || (paramString.equals("HHmmss'Z'"))) {
      return new hsh(paramString);
    }
    Log localLog;
    if (a.isDebugEnabled())
    {
      localLog = a;
      str = String.valueOf(paramString);
      if (str.length() == 0) {
        break label122;
      }
    }
    label122:
    for (String str = "unexpected date format pattern: ".concat(str);; str = new String("unexpected date format pattern: "))
    {
      localLog.debug(str);
      return new SimpleDateFormat(paramString);
    }
  }
  
  static Calendar a(boolean paramBoolean, TimeZone paramTimeZone, int paramInt1, int paramInt2, int paramInt3)
  {
    return b(paramBoolean, paramTimeZone, paramInt1, paramInt2, paramInt3, 0, 0, 0);
  }
  
  static void a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    String str = Integer.toString(paramInt1);
    int i = str.length();
    paramInt1 = 0;
    while (paramInt1 < paramInt2 - i)
    {
      paramStringBuffer.append("0");
      paramInt1 += 1;
    }
    paramStringBuffer.append(str);
  }
  
  private static Calendar b(boolean paramBoolean, TimeZone paramTimeZone, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramTimeZone = new GregorianCalendar(paramTimeZone);
    paramTimeZone.setLenient(paramBoolean);
    paramTimeZone.set(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    paramTimeZone.set(14, 0);
    return paramTimeZone;
  }
}

/* Location:
 * Qualified Name:     hsd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */