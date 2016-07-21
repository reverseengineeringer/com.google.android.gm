import android.content.Context;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

public final class gog
  implements Thread.UncaughtExceptionHandler
{
  private final Context a;
  private final Thread.UncaughtExceptionHandler b;
  private final AtomicReference<Throwable> c;
  private final goh d;
  
  public gog(Context paramContext, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, AtomicReference<Throwable> paramAtomicReference, goh paramgoh)
  {
    a = paramContext;
    b = paramUncaughtExceptionHandler;
    c = paramAtomicReference;
    d = paramgoh;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      bool = d.a();
      if (bool)
      {
        goc.a(a, paramThrowable, d.b());
        c.set(paramThrowable);
      }
      b.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.e("SilentFeedbackHandler", "An error occured checking if exception should be reported, skipping silent feedback.", localThrowable);
        boolean bool = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     gog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */