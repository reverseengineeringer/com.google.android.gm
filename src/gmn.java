import android.os.SystemClock;

public final class gmn
{
  static final gmn c;
  final long a = SystemClock.elapsedRealtime();
  long b;
  
  static
  {
    gmn localgmn = new gmn();
    c = localgmn;
    b = -1L;
  }
}

/* Location:
 * Qualified Name:     gmn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */