import android.os.Bundle;
import java.util.concurrent.locks.Lock;

final class ekl
  implements ejc
{
  ekl(ekj paramekj) {}
  
  public final void a(int paramInt)
  {
    a.a.lock();
    try
    {
      a.s.a(paramInt);
      return;
    }
    finally
    {
      a.a.unlock();
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    a.a.lock();
    try
    {
      a.s.a(paramBundle);
      return;
    }
    finally
    {
      a.a.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     ekl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */