import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

final class adi
{
  Menu a;
  int b;
  int c;
  int d;
  int e;
  boolean f;
  boolean g;
  boolean h;
  int i;
  int j;
  CharSequence k;
  CharSequence l;
  int m;
  char n;
  char o;
  int p;
  boolean q;
  boolean r;
  boolean s;
  int t;
  int u;
  String v;
  String w;
  String x;
  oy y;
  
  public adi(adg paramadg, Menu paramMenu)
  {
    a = paramMenu;
    a();
  }
  
  static char a(String paramString)
  {
    if (paramString == null) {
      return '\000';
    }
    return paramString.charAt(0);
  }
  
  final <T> T a(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramArrayOfClass = z.e.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.newInstance(paramArrayOfObject);
      return paramArrayOfClass;
    }
    catch (Exception paramArrayOfClass)
    {
      Log.w("SupportMenuInflater", "Cannot instantiate class: " + paramString, paramArrayOfClass);
    }
    return null;
  }
  
  public final void a()
  {
    b = 0;
    c = 0;
    d = 0;
    e = 0;
    f = true;
    g = true;
  }
  
  final void a(MenuItem paramMenuItem)
  {
    int i1 = 1;
    Object localObject = paramMenuItem.setChecked(q).setVisible(r).setEnabled(s);
    if (p > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((MenuItem)localObject).setCheckable(bool).setTitleCondensed(l).setIcon(m).setAlphabeticShortcut(n).setNumericShortcut(o);
      if (t >= 0) {
        qe.a(paramMenuItem, t);
      }
      if (x == null) {
        break label188;
      }
      if (!z.e.isRestricted()) {
        break;
      }
      throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
    }
    localObject = z;
    if (f == null) {
      f = ((adg)localObject).a(e);
    }
    paramMenuItem.setOnMenuItemClickListener(new adh(f, x));
    label188:
    if (p >= 2)
    {
      if ((paramMenuItem instanceof ady)) {
        ((ady)paramMenuItem).a(true);
      }
    }
    else
    {
      if (v == null) {
        break label390;
      }
      qe.a(paramMenuItem, (View)a(v, adg.a, z.c));
    }
    for (;;)
    {
      if (u > 0)
      {
        if (i1 != 0) {
          break label378;
        }
        qe.b(paramMenuItem, u);
      }
      for (;;)
      {
        if (y != null) {
          qe.a(paramMenuItem, y);
        }
        return;
        if (!(paramMenuItem instanceof aea)) {
          break;
        }
        localObject = (aea)paramMenuItem;
        try
        {
          if (e == null) {
            e = ((ll)d).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[] { Boolean.TYPE });
          }
          e.invoke(d, new Object[] { Boolean.valueOf(true) });
        }
        catch (Exception localException)
        {
          Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", localException);
        }
        break;
        label378:
        Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
      label390:
      i1 = 0;
    }
  }
  
  public final SubMenu b()
  {
    h = true;
    SubMenu localSubMenu = a.addSubMenu(b, i, j, k);
    a(localSubMenu.getItem());
    return localSubMenu;
  }
}

/* Location:
 * Qualified Name:     adi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */