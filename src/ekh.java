import android.os.Message;
import java.util.concurrent.locks.Lock;

abstract class ekh
  implements Runnable
{
  ekh(eju parameju) {}
  
  protected abstract void a();
  
  public void run()
  {
    b.b.lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool) {
        return;
      }
      a();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      ekj localekj = b.a;
      Message localMessage = j.obtainMessage(4, localRuntimeException);
      j.sendMessage(localMessage);
      return;
    }
    finally
    {
      b.b.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     ekh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */