import android.os.Handler;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class kc<Params, Progress, Result>
{
  private static final ThreadFactory a = new kd();
  private static final BlockingQueue<Runnable> b = new LinkedBlockingQueue(10);
  public static final Executor c;
  private static ki h;
  private static volatile Executor i;
  final kk<Params, Result> d = new ke(this);
  final FutureTask<Result> e = new kf(this, d);
  volatile int f = kj.a;
  final AtomicBoolean g = new AtomicBoolean();
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, b, a);
    c = localThreadPoolExecutor;
    i = localThreadPoolExecutor;
  }
  
  protected static void b(Progress... paramVarArgs) {}
  
  private static Handler c()
  {
    try
    {
      if (h == null) {
        h = new ki();
      }
      ki localki = h;
      return localki;
    }
    finally {}
  }
  
  protected abstract Result a();
  
  protected void a(Result paramResult) {}
  
  protected void b(Result paramResult) {}
  
  final Result c(Result paramResult)
  {
    c().obtainMessage(1, new kh(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }
}

/* Location:
 * Qualified Name:     kc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */