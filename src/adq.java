import android.content.Context;
import android.os.Build.VERSION;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

class adq<T>
  extends adr<T>
{
  final Context a;
  Map<ll, MenuItem> b;
  Map<lm, SubMenu> c;
  
  adq(Context paramContext, T paramT)
  {
    super(paramT);
    a = paramContext;
  }
  
  final MenuItem a(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof ll))
    {
      ll localll = (ll)paramMenuItem;
      if (b == null) {
        b = new ns();
      }
      MenuItem localMenuItem = (MenuItem)b.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = aen.a(a, localll);
        b.put(localll, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof lm))
    {
      lm locallm = (lm)paramSubMenu;
      if (c == null) {
        c = new ns();
      }
      SubMenu localSubMenu = (SubMenu)c.get(locallm);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = a;
        if (Build.VERSION.SDK_INT >= 14)
        {
          paramSubMenu = new aeq(paramSubMenu, locallm);
          c.put(locallm, paramSubMenu);
        }
      }
      else
      {
        return paramSubMenu;
      }
      throw new UnsupportedOperationException();
    }
    return paramSubMenu;
  }
}

/* Location:
 * Qualified Name:     adq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */