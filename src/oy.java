import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class oy
{
  public oz a;
  public pa b;
  private final Context c;
  
  public oy(Context paramContext)
  {
    c = paramContext;
  }
  
  public abstract View a();
  
  public View a(MenuItem paramMenuItem)
  {
    return a();
  }
  
  public void a(SubMenu paramSubMenu) {}
  
  public void a(pa parampa)
  {
    if (b != null) {
      Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
    }
    b = parampa;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (a != null) {
      a.a(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     oy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */