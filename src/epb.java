import android.os.SystemClock;

public final class epb
  implements eov
{
  private static epb a;
  
  public static eov c()
  {
    try
    {
      if (a == null) {
        a = new epb();
      }
      epb localepb = a;
      return localepb;
    }
    finally {}
  }
  
  public final long a()
  {
    return System.currentTimeMillis();
  }
  
  public final long b()
  {
    return SystemClock.elapsedRealtime();
  }
}

/* Location:
 * Qualified Name:     epb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */