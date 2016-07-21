import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class aed
  extends adr<MenuItem.OnActionExpandListener>
  implements qj
{
  aed(aea paramaea, MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    super(paramOnActionExpandListener);
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)d).onMenuItemActionExpand(a.a(paramMenuItem));
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnActionExpandListener)d).onMenuItemActionCollapse(a.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     aed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */