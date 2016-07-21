import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

public abstract class cua
  extends Handler
{
  private final int a;
  private long b = -1L;
  
  public cua(Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    a = paramInt;
  }
  
  public final void a()
  {
    long l = SystemClock.elapsedRealtime();
    removeMessages(0);
    if ((b == -1L) || (b + a < l))
    {
      sendEmptyMessage(0);
      return;
    }
    sendEmptyMessageDelayed(0, a);
  }
  
  public abstract void b();
  
  public void dispatchMessage(Message paramMessage)
  {
    b = SystemClock.elapsedRealtime();
    b();
  }
}

/* Location:
 * Qualified Name:     cua
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */