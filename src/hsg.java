import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

final class hsg
  extends hse
{
  private static final long serialVersionUID = 3005824302269636122L;
  final boolean a;
  
  public hsg(String paramString)
  {
    super(paramString);
    a = paramString.endsWith("'Z'");
  }
  
  public final StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    paramFieldPosition = new GregorianCalendar(getTimeZone());
    paramFieldPosition.setTimeInMillis(paramDate.getTime());
    hsd.a(paramStringBuffer, paramFieldPosition.get(1), 4);
    hsd.a(paramStringBuffer, paramFieldPosition.get(2) + 1, 2);
    hsd.a(paramStringBuffer, paramFieldPosition.get(5), 2);
    paramStringBuffer.append("T");
    hsd.a(paramStringBuffer, paramFieldPosition.get(11), 2);
    hsd.a(paramStringBuffer, paramFieldPosition.get(12), 2);
    hsd.a(paramStringBuffer, paramFieldPosition.get(13), 2);
    if (a) {
      paramStringBuffer.append("Z");
    }
    return paramStringBuffer;
  }
  
  public final Date parse(String paramString, ParsePosition paramParsePosition)
  {
    if (a)
    {
      if ((paramString.length() > 20) && (!isLenient()))
      {
        paramParsePosition.setErrorIndex(20);
        return null;
      }
    }
    else if ((paramString.length() > 17) && (!isLenient()))
    {
      paramParsePosition.setErrorIndex(17);
      return null;
    }
    try
    {
      if (paramString.charAt(8) != 'T')
      {
        paramParsePosition.setErrorIndex(8);
        return null;
      }
      if ((a) && (paramString.charAt(15) != 'Z'))
      {
        paramParsePosition.setErrorIndex(15);
        return null;
      }
      int i = Integer.parseInt(paramString.substring(0, 4));
      int j = Integer.parseInt(paramString.substring(4, 6));
      int k = Integer.parseInt(paramString.substring(6, 8));
      int m = Integer.parseInt(paramString.substring(9, 11));
      int n = Integer.parseInt(paramString.substring(11, 13));
      int i1 = Integer.parseInt(paramString.substring(13, 15));
      paramString = hsd.a(isLenient(), getTimeZone(), i, j - 1, k, m, n, i1).getTime();
      paramParsePosition.setIndex(15);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     hsg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */