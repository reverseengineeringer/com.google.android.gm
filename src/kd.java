import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class kd
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ModernAsyncTask #" + a.getAndIncrement());
  }
}

/* Location:
 * Qualified Name:     kd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */