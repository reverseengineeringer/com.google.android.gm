import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState;
import android.view.Window;
import android.view.Window.Callback;

public final class abe
  implements aek
{
  public abe(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7) {}
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    adu localadu = paramadu.k();
    if (localadu != paramadu) {}
    for (int i = 1;; i = 0)
    {
      AppCompatDelegateImplV7 localAppCompatDelegateImplV7 = a;
      if (i != 0) {
        paramadu = localadu;
      }
      paramadu = localAppCompatDelegateImplV7.a(paramadu);
      if (paramadu != null)
      {
        if (i == 0) {
          break;
        }
        a.a(a, paramadu, localadu);
        a.a(paramadu, true);
      }
      return;
    }
    a.a(paramadu, paramBoolean);
  }
  
  public final boolean a_(adu paramadu)
  {
    if ((paramadu == null) && (a.j))
    {
      Window.Callback localCallback = a.d.getCallback();
      if ((localCallback != null) && (!a.p)) {
        localCallback.onMenuOpened(108, paramadu);
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     abe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */