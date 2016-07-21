import android.view.Window.Callback;

final class abm
  implements aek
{
  private boolean b;
  
  abm(abj paramabj) {}
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    if (b) {
      return;
    }
    b = true;
    a.a.l();
    if (a.c != null) {
      a.c.onPanelClosed(108, paramadu);
    }
    b = false;
  }
  
  public final boolean a_(adu paramadu)
  {
    if (a.c != null)
    {
      a.c.onMenuOpened(108, paramadu);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     abm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */