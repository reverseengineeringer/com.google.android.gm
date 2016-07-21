import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

final class kf
  extends FutureTask<Result>
{
  kf(kc paramkc, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    try
    {
      Object localObject = get();
      kc localkc2 = a;
      if (!g.get()) {
        localkc2.c(localObject);
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.w("AsyncTask", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      kc localkc1;
      do
      {
        localkc1 = a;
      } while (g.get());
      localkc1.c(null);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     kf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */