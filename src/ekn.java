import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class ekn
  implements eje
{
  ekn(ekj paramekj, eip parameip, int paramInt) {}
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    c.a.lock();
    try
    {
      c.s.a(paramConnectionResult, a, b);
      return;
    }
    finally
    {
      c.a.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     ekn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */