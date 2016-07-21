import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

abstract class caj
  implements MenuItem.OnMenuItemClickListener
{
  private final String b;
  
  public caj(cah paramcah, String paramString)
  {
    b = paramString;
  }
  
  public abstract boolean a();
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    buo.a().a("web_context_menu", "menu_clicked", b, 0L);
    return a();
  }
}

/* Location:
 * Qualified Name:     caj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */