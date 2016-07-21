import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import java.util.Calendar;
import java.util.TimeZone;

public final class car
{
  public static int a(long paramLong, TimeZone paramTimeZone)
  {
    return Time.getJulianDay(paramLong, a(paramTimeZone, paramLong));
  }
  
  private static long a(TimeZone paramTimeZone, long paramLong)
  {
    return paramTimeZone.getOffset(paramLong) / 1000;
  }
  
  public static long a(boolean paramBoolean, long paramLong, TimeZone paramTimeZone)
  {
    long l = paramLong;
    if (paramBoolean) {
      l = b(paramLong, paramTimeZone);
    }
    return l;
  }
  
  public static String a(Context paramContext, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    int j;
    label34:
    int k;
    Resources localResources;
    long l;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    TimeZone localTimeZone;
    if (paramBoolean2)
    {
      i = 98304;
      j = i | 0x12;
      if ((cxd.b()) || (!DateFormat.is24HourFormat(paramContext))) {
        break label236;
      }
      i = 128;
      k = i | 0x1401;
      localResources = paramContext.getResources();
      l = System.currentTimeMillis();
      i = 0;
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
      localTimeZone = TimeZone.getDefault();
      if (!paramBoolean1) {
        break label310;
      }
      paramLong1 = b(paramLong1, localTimeZone);
      paramLong2 = b(paramLong2, localTimeZone);
      if (!a(paramLong1, paramLong2, localTimeZone)) {
        break label276;
      }
      switch (b(paramLong1, l, localTimeZone))
      {
      default: 
        localStringBuilder1.append(DateUtils.formatDateTime(paramContext, paramLong1, 18));
        label153:
        if (localStringBuilder1.length() == 0)
        {
          localStringBuilder1.append(localStringBuilder2);
          localStringBuilder2.setLength(0);
          i = 0;
        }
        if (i != 0)
        {
          localStringBuilder1.append(localResources.getString(buj.bN));
          label197:
          if (localStringBuilder2.length() <= 0) {
            break label491;
          }
          if (!paramBoolean2) {
            break label484;
          }
        }
        break;
      }
    }
    label236:
    label276:
    label310:
    label484:
    for (char c = ' ';; c = '\n')
    {
      return c + localStringBuilder2;
      i = 0;
      break;
      i = 0;
      break label34;
      localStringBuilder1.append(localResources.getString(buj.bO));
      break label153;
      localStringBuilder1.append(localResources.getString(buj.bP));
      break label153;
      localStringBuilder1.append(DateUtils.formatDateTime(paramContext, paramLong1, j));
      localStringBuilder2.append(DateUtils.formatDateTime(paramContext, paramLong2 - 1L, j));
      i = 1;
      break label153;
      if (a(paramLong1, paramLong2, localTimeZone))
      {
        int m = b(paramLong1, l, localTimeZone);
        if (1 == m) {
          localStringBuilder1.append(localResources.getString(buj.bO));
        }
        for (;;)
        {
          localStringBuilder2.append(DateUtils.formatDateRange(paramContext, paramLong1, paramLong2, k));
          break;
          if (2 == m) {
            localStringBuilder1.append(localResources.getString(buj.bP));
          } else {
            localStringBuilder1.append(DateUtils.formatDateRange(paramContext, paramLong1, paramLong1, j));
          }
        }
      }
      i = j | k;
      localStringBuilder1.append(DateUtils.formatDateRange(paramContext, paramLong1, paramLong1, i));
      localStringBuilder2.append(DateUtils.formatDateRange(paramContext, paramLong2, paramLong2, i));
      i = 1;
      break label153;
      if ((!paramBoolean2) || (localStringBuilder2.length() <= 0)) {
        break label197;
      }
      return localResources.getString(buj.bM, new Object[] { localStringBuilder1, localStringBuilder2 });
    }
    label491:
    return localStringBuilder1.toString();
  }
  
  public static String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    return DateUtils.formatDateTime(paramContext, a(paramBoolean, paramLong, TimeZone.getDefault()), 16);
  }
  
  private static boolean a(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    if (paramLong1 == paramLong2) {}
    while (a(paramLong1, paramTimeZone) == Time.getJulianDay(paramLong2 - 1L, a(paramTimeZone, paramLong2))) {
      return true;
    }
    return false;
  }
  
  private static int b(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    int i = 1;
    int j = a(paramLong1, paramTimeZone) - a(paramLong2, paramTimeZone);
    if (j == 1) {
      i = 2;
    }
    while (j == 0) {
      return i;
    }
    return 0;
  }
  
  private static long b(long paramLong, TimeZone paramTimeZone)
  {
    Calendar localCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    localCalendar.setTimeInMillis(paramLong);
    paramTimeZone = Calendar.getInstance(paramTimeZone);
    paramTimeZone.set(localCalendar.get(1), localCalendar.get(2), localCalendar.get(5), localCalendar.get(11), localCalendar.get(12), localCalendar.get(13));
    paramTimeZone.set(14, localCalendar.get(14));
    return paramTimeZone.getTimeInMillis();
  }
}

/* Location:
 * Qualified Name:     car
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */