import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

class aeb
  extends oy
{
  final ActionProvider c;
  
  public aeb(aea paramaea, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramContext);
    c = paramActionProvider;
  }
  
  public final View a()
  {
    return c.onCreateActionView();
  }
  
  public final void a(SubMenu paramSubMenu)
  {
    c.onPrepareSubMenu(d.a(paramSubMenu));
  }
  
  public final boolean d()
  {
    return c.onPerformDefaultAction();
  }
  
  public final boolean e()
  {
    return c.hasSubMenu();
  }
}

/* Location:
 * Qualified Name:     aeb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */