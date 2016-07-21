import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class hsq
  extends hsn
{
  private static final hsr d;
  private static final hsr e;
  private static final hsr f;
  private static final hsr g;
  private static final hsr h = new hsr(new SimpleDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'"));
  private static final long serialVersionUID = -6407231357919440387L;
  public hwp a;
  public hwq b;
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
    localSimpleDateFormat.setTimeZone(icp.a);
    localSimpleDateFormat.setLenient(false);
    d = new hsr(localSimpleDateFormat);
    localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
    localSimpleDateFormat.setLenient(false);
    e = new hsr(localSimpleDateFormat);
    f = new hsr(new SimpleDateFormat("yyyyMMdd'T'HHmmss"));
    localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    localSimpleDateFormat.setLenient(true);
    g = new hsr(localSimpleDateFormat);
  }
  
  public hsq()
  {
    super(TimeZone.getDefault());
    a = new hwp(getTime(), c.getTimeZone());
  }
  
  public hsq(byte paramByte)
  {
    this();
    a(true);
  }
  
  public hsq(long paramLong)
  {
    super(paramLong, 0, TimeZone.getDefault());
    a = new hwp(paramLong, c.getTimeZone());
  }
  
  public hsq(String paramString)
  {
    this(paramString, null);
  }
  
  public hsq(String paramString, hwq paramhwq) {}
  
  public hsq(Date paramDate)
  {
    super(paramDate.getTime(), 0, TimeZone.getDefault());
    a = new hwp(paramDate.getTime(), c.getTimeZone());
    if ((paramDate instanceof hsq))
    {
      paramDate = (hsq)paramDate;
      if (a.a) {
        a(true);
      }
    }
    else
    {
      return;
    }
    a(b);
  }
  
  private final void a()
  {
    c.setTimeZone(hwq.getDefault());
  }
  
  private final void a(String paramString, DateFormat paramDateFormat, TimeZone paramTimeZone)
  {
    if (paramTimeZone != null) {
      paramDateFormat.setTimeZone(paramTimeZone);
    }
    setTime(paramDateFormat.parse(paramString).getTime());
  }
  
  public final void a(hwq paramhwq)
  {
    b = paramhwq;
    if (paramhwq != null) {
      c.setTimeZone(paramhwq);
    }
    for (;;)
    {
      a = new hwp(a, c.getTimeZone(), false);
      return;
      a();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    b = null;
    if (paramBoolean) {
      c.setTimeZone(icp.a);
    }
    for (;;)
    {
      a = new hwp(a, c.getTimeZone(), paramBoolean);
      return;
      a();
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof hsq)) {
      return idkaa, a).a;
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final void setTime(long paramLong)
  {
    super.setTime(paramLong);
    if (a != null) {
      a.setTime(paramLong);
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(super.toString());
    localStringBuffer.append('T');
    localStringBuffer.append(a.toString());
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hsq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */