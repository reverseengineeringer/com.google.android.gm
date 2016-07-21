import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class hsn
  extends hsv
{
  private static final long serialVersionUID = 7136072363141363141L;
  
  public hsn()
  {
    super("yyyyMMdd", 1, icp.a());
  }
  
  protected hsn(long paramLong, int paramInt, TimeZone paramTimeZone)
  {
    super(paramLong, "yyyyMMdd", paramInt, paramTimeZone);
  }
  
  public hsn(String paramString)
  {
    this();
    try
    {
      setTime(c.parse(paramString).getTime());
      return;
    }
    catch (ParseException localParseException)
    {
      SimpleDateFormat localSimpleDateFormat;
      if (icf.a("ical4j.compatibility.vcard"))
      {
        localSimpleDateFormat = new SimpleDateFormat("yyyy'-'MM'-'dd");
        localSimpleDateFormat.setTimeZone(icp.a());
        setTime(localSimpleDateFormat.parse(paramString).getTime());
        return;
      }
      throw localSimpleDateFormat;
    }
  }
  
  public hsn(Date paramDate)
  {
    this(paramDate.getTime(), 1, icp.a());
  }
  
  protected hsn(TimeZone paramTimeZone)
  {
    super("yyyyMMdd", 0, paramTimeZone);
  }
}

/* Location:
 * Qualified Name:     hsn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */