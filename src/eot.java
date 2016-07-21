import android.os.SystemClock;
import android.util.Log;

public final class eot
{
  private final long a;
  private final int b;
  private final oi<String, Long> c;
  
  public eot()
  {
    a = 60000L;
    b = 10;
    c = new oi(10);
  }
  
  public eot(long paramLong)
  {
    a = paramLong;
    b = 1024;
    c = new oi();
  }
  
  public final Long a(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = a;
    for (;;)
    {
      int i;
      try
      {
        if (c.size() >= b)
        {
          i = c.size() - 1;
          if (i >= 0)
          {
            if (l2 - ((Long)c.c(i)).longValue() > l1) {
              c.d(i);
            }
          }
          else
          {
            l1 /= 2L;
            Log.w("ConnectionTracker", "The max capacity " + b + " is not enough. Current durationThreshold is: " + l1);
          }
        }
        else
        {
          paramString = (Long)c.put(paramString, Long.valueOf(l2));
          return paramString;
        }
      }
      finally {}
      i -= 1;
    }
  }
  
  public final boolean b(String paramString)
  {
    for (;;)
    {
      try
      {
        if (c.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     eot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */