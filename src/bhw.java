import java.text.SimpleDateFormat;
import java.util.Date;

public final class bhw
  extends ThreadLocal<SimpleDateFormat>
{
  private final String a;
  
  public bhw(String paramString)
  {
    a = paramString;
  }
  
  public final String a(long paramLong)
  {
    return ((SimpleDateFormat)super.get()).format(new Date(paramLong));
  }
  
  public final Date a(String paramString)
  {
    return ((SimpleDateFormat)super.get()).parse(paramString);
  }
}

/* Location:
 * Qualified Name:     bhw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */