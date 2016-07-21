import android.os.Bundle;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState;

public final class aas
  implements Runnable
{
  public aas(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void run()
  {
    AppCompatDelegateImplV7 localAppCompatDelegateImplV7;
    AppCompatDelegateImplV7.PanelFeatureState localPanelFeatureState;
    Bundle localBundle;
    if ((a.y & 0x1) != 0)
    {
      localAppCompatDelegateImplV7 = a;
      localPanelFeatureState = localAppCompatDelegateImplV7.g(0);
      if (j != null)
      {
        localBundle = new Bundle();
        j.b(localBundle);
        if (localBundle.size() > 0) {
          s = localBundle;
        }
        j.d();
        j.clear();
      }
      r = true;
      q = true;
      if (r != null)
      {
        localPanelFeatureState = localAppCompatDelegateImplV7.g(0);
        if (localPanelFeatureState != null)
        {
          m = false;
          localAppCompatDelegateImplV7.a(localPanelFeatureState, null);
        }
      }
    }
    if ((a.y & 0x1000) != 0)
    {
      localAppCompatDelegateImplV7 = a;
      localPanelFeatureState = localAppCompatDelegateImplV7.g(108);
      if (j != null)
      {
        localBundle = new Bundle();
        j.b(localBundle);
        if (localBundle.size() > 0) {
          s = localBundle;
        }
        j.d();
        j.clear();
      }
      r = true;
      q = true;
      if (r != null)
      {
        localPanelFeatureState = localAppCompatDelegateImplV7.g(0);
        if (localPanelFeatureState != null)
        {
          m = false;
          localAppCompatDelegateImplV7.a(localPanelFeatureState, null);
        }
      }
    }
    a.x = false;
    a.y = 0;
  }
}

/* Location:
 * Qualified Name:     aas
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */