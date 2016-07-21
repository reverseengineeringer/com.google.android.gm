import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

final class hsf
  extends hse
{
  private static final long serialVersionUID = -7626077667268431779L;
  
  public hsf(String paramString)
  {
    super(paramString);
  }
  
  public final StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    paramFieldPosition = Calendar.getInstance(getTimeZone());
    paramFieldPosition.setTimeInMillis(paramDate.getTime());
    hsd.a(paramStringBuffer, paramFieldPosition.get(1), 4);
    hsd.a(paramStringBuffer, paramFieldPosition.get(2) + 1, 2);
    hsd.a(paramStringBuffer, paramFieldPosition.get(5), 2);
    return paramStringBuffer;
  }
  
  public final Date parse(String paramString, ParsePosition paramParsePosition)
  {
    if ((paramString.length() > 8) && (!isLenient()))
    {
      paramParsePosition.setErrorIndex(8);
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString.substring(0, 4));
      int j = Integer.parseInt(paramString.substring(4, 6));
      int k = Integer.parseInt(paramString.substring(6, 8));
      paramString = hsd.a(isLenient(), getTimeZone(), i, j - 1, k).getTime();
      paramParsePosition.setIndex(8);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     hsf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */