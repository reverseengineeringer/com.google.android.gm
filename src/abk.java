import android.view.Menu;
import android.view.Window.Callback;

final class abk
  implements Runnable
{
  abk(abj paramabj) {}
  
  public final void run()
  {
    abj localabj = a;
    Menu localMenu = localabj.q();
    if ((localMenu instanceof adu)) {}
    for (localadu = (adu)localMenu;; localadu = null)
    {
      if (localadu != null) {
        localadu.d();
      }
      try
      {
        localMenu.clear();
        if ((!c.onCreatePanelMenu(0, localMenu)) || (!c.onPreparePanel(0, null, localMenu))) {
          localMenu.clear();
        }
        return;
      }
      finally
      {
        if (localadu == null) {
          break;
        }
        localadu.e();
      }
    }
  }
}

/* Location:
 * Qualified Name:     abk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */