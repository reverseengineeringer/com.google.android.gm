import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;

public final class ejo<R extends ejk>
  extends Handler
{
  public ejo()
  {
    this(Looper.getMainLooper());
  }
  
  public ejo(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void a(ejl<R> paramejl, R paramR)
  {
    sendMessage(obtainMessage(1, new Pair(paramejl, paramR)));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
      return;
    case 1: 
      Object localObject = (Pair)obj;
      paramMessage = (ejl)first;
      localObject = (ejk)second;
      try
      {
        paramMessage.a((ejk)localObject);
        return;
      }
      catch (RuntimeException paramMessage)
      {
        ejn.b((ejk)localObject);
        throw paramMessage;
      }
    }
    ((ejn)obj).b(Status.d);
  }
}

/* Location:
 * Qualified Name:     ejo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */