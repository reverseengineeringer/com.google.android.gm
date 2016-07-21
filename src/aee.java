import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class aee
  extends adr<MenuItem.OnMenuItemClickListener>
  implements MenuItem.OnMenuItemClickListener
{
  aee(aea paramaea, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    super(paramOnMenuItemClickListener);
  }
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    return ((MenuItem.OnMenuItemClickListener)d).onMenuItemClick(a.a(paramMenuItem));
  }
}

/* Location:
 * Qualified Name:     aee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */