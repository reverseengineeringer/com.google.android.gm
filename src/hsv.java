import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public class hsv
  extends Date
{
  private static final long serialVersionUID = -4290728005713946811L;
  private DateFormat a;
  private int b;
  DateFormat c;
  
  public hsv(long paramLong, String paramString, int paramInt, TimeZone paramTimeZone)
  {
    super(ich.a(paramLong, paramInt, paramTimeZone));
    c = hsd.a(paramString);
    c.setTimeZone(paramTimeZone);
    c.setLenient(icf.a("ical4j.parsing.relaxed"));
    b = paramInt;
  }
  
  public hsv(String paramString, int paramInt, TimeZone paramTimeZone)
  {
    this(1000L * Math.floor(System.currentTimeMillis() / 1000.0D), paramString, paramInt, paramTimeZone);
  }
  
  public void setTime(long paramLong)
  {
    if (c != null)
    {
      super.setTime(ich.a(paramLong, b, c.getTimeZone()));
      return;
    }
    super.setTime(paramLong);
  }
  
  public String toString()
  {
    TimeZone localTimeZone = c.getTimeZone();
    if (!(localTimeZone instanceof hwq))
    {
      if (a == null)
      {
        a = ((DateFormat)c.clone());
        a.setTimeZone(hwq.getTimeZone("Etc/GMT"));
      }
      if ((localTimeZone.inDaylightTime(this)) && (localTimeZone.inDaylightTime(new Date(getTime() - 1L)))) {
        return a.format(new Date(getTime() + localTimeZone.getRawOffset() + localTimeZone.getDSTSavings()));
      }
      return a.format(new Date(getTime() + localTimeZone.getRawOffset()));
    }
    return c.format(this);
  }
}

/* Location:
 * Qualified Name:     hsv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */