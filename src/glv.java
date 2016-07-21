import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class glv
  implements ThreadFactory
{
  private final ThreadFactory a = Executors.defaultThreadFactory();
  private final AtomicInteger b = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = a.newThread(paramRunnable);
    int i = b.getAndIncrement();
    paramRunnable.setName(18 + "Primes-" + i);
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     glv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */