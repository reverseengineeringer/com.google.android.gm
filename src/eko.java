import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.locks.Lock;

final class eko
  extends Handler
{
  eko(ekj paramekj, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      Log.w("GoogleApiClientImpl", "Unknown message id: " + what);
      return;
    case 1: 
      paramMessage = a;
      a.lock();
      try
      {
        if (paramMessage.h()) {
          paramMessage.b();
        }
        return;
      }
      finally
      {
        a.unlock();
      }
    case 2: 
      ekj.a(a);
      return;
    case 3: 
      ekp localekp = (ekp)obj;
      paramMessage = a;
      a.lock();
      try
      {
        ekt localekt1 = s;
        ekt localekt2 = d;
        if (localekt1 != localekt2) {
          return;
        }
        localekp.a();
        return;
      }
      finally
      {
        a.unlock();
      }
    }
    throw ((RuntimeException)obj);
  }
}

/* Location:
 * Qualified Name:     eko
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */