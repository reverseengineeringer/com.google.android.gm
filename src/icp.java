import java.util.TimeZone;

public final class icp
{
  public static final TimeZone a = TimeZone.getTimeZone("Etc/UTC");
  
  public static TimeZone a()
  {
    if ("true".equals(icg.a("net.fortuna.ical4j.timezone.date.floating"))) {
      return TimeZone.getDefault();
    }
    return a;
  }
  
  public static boolean a(TimeZone paramTimeZone)
  {
    return ("Etc/UTC".equals(paramTimeZone.getID())) || ("GMT".equals(paramTimeZone.getID()));
  }
}

/* Location:
 * Qualified Name:     icp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */