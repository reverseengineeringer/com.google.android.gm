import android.os.SystemClock;

public final class gmz
{
  public final Object a = new Object();
  public int b = 0;
  public long c = 0L;
  private final int d;
  
  public gmz(int paramInt)
  {
    d = paramInt;
  }
  
  public final boolean a()
  {
    synchronized (a)
    {
      if (SystemClock.elapsedRealtime() - c > 1000L) {
        return false;
      }
      if (b >= d) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     gmz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */