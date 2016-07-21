import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

final class bgo
  implements Executor
{
  private Handler a;
  
  public bgo(String paramString)
  {
    paramString = new HandlerThread(String.valueOf(paramString).concat(" executor"));
    paramString.start();
    a = new Handler(paramString.getLooper());
  }
  
  public final void execute(Runnable paramRunnable)
  {
    a.post(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     bgo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */