import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

final class ilb
{
  private static NumberFormat a;
  private static NumberFormat b;
  
  static
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    a = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(2);
    localDecimalFormat = new DecimalFormat();
    b = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(4);
    b.setGroupingUsed(false);
  }
  
  public static String a(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    StringBuffer localStringBuffer = new StringBuffer();
    localGregorianCalendar.setTime(paramDate);
    localStringBuffer.append(b.format(localGregorianCalendar.get(1)));
    localStringBuffer.append(a.format(localGregorianCalendar.get(2) + 1));
    localStringBuffer.append(a.format(localGregorianCalendar.get(5)));
    localStringBuffer.append(a.format(localGregorianCalendar.get(11)));
    localStringBuffer.append(a.format(localGregorianCalendar.get(12)));
    localStringBuffer.append(a.format(localGregorianCalendar.get(13)));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ilb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */