import android.os.SystemClock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

final class jm
  extends kc<Void, Void, D>
  implements Runnable
{
  boolean a;
  private final CountDownLatch h = new CountDownLatch(1);
  
  jm(jl paramjl) {}
  
  private final D c()
  {
    try
    {
      Object localObject = b.d();
      return (D)localObject;
    }
    catch (mf localmf)
    {
      if (!e.isCancelled()) {
        throw localmf;
      }
    }
    return null;
  }
  
  protected final void a(D paramD)
  {
    for (;;)
    {
      jl localjl;
      try
      {
        localjl = b;
        if (a != this)
        {
          localjl.a(this, paramD);
          return;
        }
        if (s)
        {
          localjl.a(paramD);
          continue;
        }
        v = false;
      }
      finally
      {
        h.countDown();
      }
      d = SystemClock.uptimeMillis();
      a = null;
      localjl.b(paramD);
    }
  }
  
  protected final void b(D paramD)
  {
    try
    {
      b.a(this, paramD);
      return;
    }
    finally
    {
      h.countDown();
    }
  }
  
  public final void run()
  {
    a = false;
    b.c();
  }
}

/* Location:
 * Qualified Name:     jm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */