import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public abstract class jl<D>
  extends jy<D>
{
  volatile jm a;
  volatile jm b;
  long c;
  long d = -10000L;
  Handler e;
  private final Executor f;
  
  public jl(Context paramContext)
  {
    this(paramContext, kc.c);
  }
  
  private jl(Context paramContext, Executor paramExecutor)
  {
    super(paramContext);
    f = paramExecutor;
  }
  
  protected final void a()
  {
    super.a();
    b();
    a = new jm(this);
    c();
  }
  
  public void a(D paramD) {}
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (a != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mTask=");
      paramPrintWriter.print(a);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(a.a);
    }
    if (b != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mCancellingTask=");
      paramPrintWriter.print(b);
      paramPrintWriter.print(" waiting=");
      paramPrintWriter.println(b.a);
    }
    if (c != 0L)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mUpdateThrottle=");
      ok.a(c, paramPrintWriter);
      paramPrintWriter.print(" mLastLoadCompleteTime=");
      ok.a(d, SystemClock.uptimeMillis(), paramPrintWriter);
      paramPrintWriter.println();
    }
  }
  
  final void a(jm paramjm, D paramD)
  {
    a(paramD);
    if (b == paramjm)
    {
      if (v) {
        u = true;
      }
      d = SystemClock.uptimeMillis();
      b = null;
      if (p != null) {
        p.d();
      }
      c();
    }
  }
  
  protected final boolean b()
  {
    if (a != null)
    {
      if (b != null)
      {
        if (a.a)
        {
          a.a = false;
          e.removeCallbacks(a);
        }
        a = null;
      }
    }
    else {
      return false;
    }
    if (a.a)
    {
      a.a = false;
      e.removeCallbacks(a);
      a = null;
      return false;
    }
    boolean bool = a.e.cancel(false);
    if (bool)
    {
      b = a;
      e();
    }
    a = null;
    return bool;
  }
  
  final void c()
  {
    if ((b == null) && (a != null))
    {
      if (a.a)
      {
        a.a = false;
        e.removeCallbacks(a);
      }
      if ((c > 0L) && (SystemClock.uptimeMillis() < d + c))
      {
        a.a = true;
        e.postAtTime(a, d + c);
      }
    }
    else
    {
      return;
    }
    jm localjm = a;
    Executor localExecutor = f;
    if (f != kj.a) {}
    switch (kg.a[(f - 1)])
    {
    default: 
      f = kj.b;
      d.b = null;
      localExecutor.execute(e);
      return;
    case 1: 
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }
  
  public abstract D d();
  
  public void e() {}
}

/* Location:
 * Qualified Name:     jl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */