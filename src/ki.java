import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.FutureTask;

final class ki
  extends Handler
{
  public ki()
  {
    super(Looper.getMainLooper());
  }
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = (kh)obj;
    switch (what)
    {
    default: 
      return;
    case 1: 
      paramMessage = a;
      localObject = b[0];
      if (e.isCancelled()) {
        paramMessage.b(localObject);
      }
      for (;;)
      {
        f = kj.c;
        return;
        paramMessage.a(localObject);
      }
    }
    kc.b();
  }
}

/* Location:
 * Qualified Name:     ki
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */