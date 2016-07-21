import android.content.ComponentCallbacks;
import android.content.res.Configuration;

final class cxb
  implements ComponentCallbacks
{
  public final void onConfigurationChanged(Configuration arg1)
  {
    synchronized (cxa.c)
    {
      cxa.d = -1;
      cxa.e = null;
      cxa.f = null;
      cxa.g = null;
      return;
    }
  }
  
  public final void onLowMemory() {}
}

/* Location:
 * Qualified Name:     cxb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */