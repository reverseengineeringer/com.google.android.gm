import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

final class glt
  implements RejectedExecutionHandler
{
  public final void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    paramRunnable = String.valueOf(paramRunnable);
    new StringBuilder(String.valueOf(paramRunnable).length() + 30).append("Service rejected execution of ").append(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     glt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */