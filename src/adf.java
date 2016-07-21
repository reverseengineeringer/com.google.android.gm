import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class adf
  implements ada
{
  final ActionMode.Callback a;
  final Context b;
  final ArrayList<ade> c;
  final oi<Menu, Menu> d;
  
  public adf(Context paramContext, ActionMode.Callback paramCallback)
  {
    b = paramContext;
    a = paramCallback;
    c = new ArrayList();
    d = new oi();
  }
  
  private final Menu a(Menu paramMenu)
  {
    Menu localMenu2 = (Menu)d.get(paramMenu);
    Menu localMenu1 = localMenu2;
    if (localMenu2 == null)
    {
      localMenu1 = aen.a(b, (lk)paramMenu);
      d.put(paramMenu, localMenu1);
    }
    return localMenu1;
  }
  
  public final void a(acz paramacz)
  {
    a.onDestroyActionMode(b(paramacz));
  }
  
  public final boolean a(acz paramacz, Menu paramMenu)
  {
    return a.onCreateActionMode(b(paramacz), a(paramMenu));
  }
  
  public final boolean a(acz paramacz, MenuItem paramMenuItem)
  {
    return a.onActionItemClicked(b(paramacz), aen.a(b, (ll)paramMenuItem));
  }
  
  public final ActionMode b(acz paramacz)
  {
    int j = c.size();
    int i = 0;
    while (i < j)
    {
      ade localade = (ade)c.get(i);
      if ((localade != null) && (b == paramacz)) {
        return localade;
      }
      i += 1;
    }
    paramacz = new ade(b, paramacz);
    c.add(paramacz);
    return paramacz;
  }
  
  public final boolean b(acz paramacz, Menu paramMenu)
  {
    return a.onPrepareActionMode(b(paramacz), a(paramMenu));
  }
}

/* Location:
 * Qualified Name:     adf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */