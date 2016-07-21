import android.os.Handler;
import java.util.Timer;

public final class cww
{
  private static final String i = cvl.a;
  private static final Timer j = new Timer();
  public final Timer a;
  final Handler b;
  final Runnable c;
  public final int d;
  public final int e;
  public int f;
  public long g;
  public cwx h;
  private final String k;
  
  public cww(String paramString, Runnable paramRunnable, Handler paramHandler)
  {
    this(paramString, paramRunnable, paramHandler, 200, 300, j);
  }
  
  private cww(String paramString, Runnable paramRunnable, Handler paramHandler, int paramInt1, int paramInt2, Timer paramTimer)
  {
    k = paramString;
    c = paramRunnable;
    a = paramTimer;
    b = paramHandler;
    d = 200;
    e = 300;
    f = d;
  }
}

/* Location:
 * Qualified Name:     cww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */