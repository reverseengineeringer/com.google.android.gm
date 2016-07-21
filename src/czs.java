import android.content.Context;
import java.util.ArrayList;

public final class czs
  implements Thread.UncaughtExceptionHandler
{
  private final Thread.UncaughtExceptionHandler a;
  private final dbm b;
  private final dbi c;
  private czr d;
  
  public czs(dbm paramdbm, dbi paramdbi, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramdbm == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramdbi == null) {
      throw new NullPointerException("serviceManager cannot be null");
    }
    a = paramUncaughtExceptionHandler;
    b = paramdbm;
    c = paramdbi;
    d = new dbl(paramContext, new ArrayList());
    paramdbi = new StringBuilder("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramdbm = "null";; paramdbm = paramUncaughtExceptionHandler.getClass().getName())
    {
      dav.d(paramdbm);
      return;
    }
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    String str = "UncaughtException";
    if (d != null) {
      if (paramThread == null) {
        break label93;
      }
    }
    label93:
    for (str = paramThread.getName();; str = null)
    {
      str = d.a(str, paramThrowable);
      dav.d("Tracking Exception: " + str);
      b.d(str);
      c.c();
      if (a != null)
      {
        dav.d("Passing exception to original handler.");
        a.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     czs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */