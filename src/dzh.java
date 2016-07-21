import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class dzh
  extends Handler
{
  dzh(dzg paramdzg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    a.stopSelf();
  }
}

/* Location:
 * Qualified Name:     dzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */