import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class ekb
  implements ejd
{
  private final WeakReference<eju> a;
  private final eip<?> b;
  private final int c;
  
  public ekb(eju parameju, eip<?> parameip, int paramInt)
  {
    a = new WeakReference(parameju);
    b = parameip;
    c = paramInt;
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    boolean bool = false;
    eju localeju = (eju)a.get();
    if (localeju == null) {
      return;
    }
    if (Looper.myLooper() == a.e) {
      bool = true;
    }
    enz.a(bool, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    b.lock();
    try
    {
      bool = localeju.b(0);
      if (!bool) {
        return;
      }
      if (!paramConnectionResult.b()) {
        localeju.b(paramConnectionResult, b, c);
      }
      if (localeju.e()) {
        localeju.f();
      }
      return;
    }
    finally
    {
      b.unlock();
    }
  }
  
  public final void b(ConnectionResult paramConnectionResult)
  {
    boolean bool = true;
    eju localeju = (eju)a.get();
    if (localeju == null) {
      return;
    }
    if (Looper.myLooper() == a.e) {}
    for (;;)
    {
      enz.a(bool, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
      b.lock();
      try
      {
        bool = localeju.b(1);
        if (!bool)
        {
          return;
          bool = false;
          continue;
        }
        if (!paramConnectionResult.b()) {
          localeju.b(paramConnectionResult, b, c);
        }
        if (localeju.e()) {
          localeju.g();
        }
        return;
      }
      finally
      {
        b.unlock();
      }
    }
  }
}

/* Location:
 * Qualified Name:     ekb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */