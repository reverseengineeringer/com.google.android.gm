import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

final class hsh
  extends hse
{
  private static final long serialVersionUID = -1367114409994225425L;
  final boolean a;
  
  public hsh(String paramString)
  {
    super(paramString);
    a = paramString.endsWith("'Z'");
  }
  
  public final StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    paramFieldPosition = new GregorianCalendar(getTimeZone());
    paramFieldPosition.setTimeInMillis(paramDate.getTime());
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
      if ((paramString.length() > 9) && (!isLenient()))
      {
        paramParsePosition.setErrorIndex(9);
        return null;
      }
    }
    else if ((paramString.length() > 6) && (!isLenient()))
    {
      paramParsePosition.setErrorIndex(6);
      return null;
    }
    try
    {
      if ((a) && (paramString.charAt(6) != 'Z'))
      {
        paramParsePosition.setErrorIndex(6);
        return null;
      }
      int i = Integer.parseInt(paramString.substring(0, 2));
      int j = Integer.parseInt(paramString.substring(2, 4));
      int k = Integer.parseInt(paramString.substring(4, 6));
      paramString = hsd.a(isLenient(), getTimeZone(), 1970, 0, 1, i, j, k).getTime();
      paramParsePosition.setIndex(6);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     hsh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */