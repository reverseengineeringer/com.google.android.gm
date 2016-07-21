import android.content.Context;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Formatter;

public final class btq
{
  public final StringBuilder a;
  public final Formatter b;
  public final Context c;
  
  public btq(Context paramContext)
  {
    c = paramContext;
    a = new StringBuilder();
    b = new Formatter(a);
  }
  
  public static boolean a(long paramLong)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public final CharSequence a(long paramLong, int paramInt)
  {
    a.setLength(0);
    DateUtils.formatDateRange(c, b, paramLong, paramLong, paramInt);
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     btq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */