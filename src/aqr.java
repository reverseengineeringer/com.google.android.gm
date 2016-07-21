import android.os.Looper;
import android.os.Process;

final class aqr
  implements Runnable
{
  Looper a;
  private final Object b = new Object();
  
  public aqr()
  {
    new Thread(null, this, "EmailNotification").start();
    synchronized (b)
    {
      for (;;)
      {
        Looper localLooper = a;
        if (localLooper != null) {
          break;
        }
        try
        {
          b.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
  }
  
  public final void run()
  {
    synchronized (b)
    {
      Looper.prepare();
      a = Looper.myLooper();
      b.notifyAll();
      Process.setThreadPriority(10);
      Looper.loop();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     aqr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */