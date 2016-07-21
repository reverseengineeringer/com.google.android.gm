import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public final class ich
{
  public static int a(Date paramDate, int paramInt)
  {
    if ((paramInt == 0) || (paramInt < -31) || (paramInt > 31)) {
      throw new IllegalArgumentException(MessageFormat.format("Invalid month day [{0}]", new Object[] { new Integer(paramInt) }));
    }
    if (paramInt > 0) {
      return paramInt;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int i = localCalendar.get(2);
    paramDate = new ArrayList();
    localCalendar.set(5, 1);
    while (localCalendar.get(2) == i)
    {
      paramDate.add(new Integer(localCalendar.get(5)));
      localCalendar.add(5, 1);
    }
    return ((Integer)paramDate.get(paramDate.size() + paramInt)).intValue();
  }
  
  public static long a(long paramLong, int paramInt, TimeZone paramTimeZone)
  {
    if ((paramInt == 0) && (paramLong % 1000L == 0L)) {
      return paramLong;
    }
    paramTimeZone = Calendar.getInstance(paramTimeZone);
    paramTimeZone.setTimeInMillis(paramLong);
    if (paramInt == 1)
    {
      paramTimeZone.set(11, 0);
      paramTimeZone.clear(12);
      paramTimeZone.clear(13);
      paramTimeZone.clear(14);
    }
    for (;;)
    {
      return paramTimeZone.getTimeInMillis();
      if (paramInt == 0) {
        paramTimeZone.clear(14);
      }
    }
  }
  
  public static hsn a(Date paramDate, hzm paramhzm)
  {
    if (hzm.e.equals(paramhzm)) {
      return new hsn(paramDate);
    }
    return new hsq(paramDate);
  }
  
  public static Calendar a(hsn paramhsn)
  {
    if ((paramhsn instanceof hsq))
    {
      paramhsn = (hsq)paramhsn;
      if (b != null) {
        return Calendar.getInstance(b);
      }
      if (a.a) {
        return Calendar.getInstance(icp.a);
      }
      return Calendar.getInstance();
    }
    return Calendar.getInstance(icp.a());
  }
}

/* Location:
 * Qualified Name:     ich
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */