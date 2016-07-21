import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import android.widget.ListAdapter;

final class abp
  extends adl
{
  public abp(abj paramabj, Window.Callback paramCallback)
  {
    super(paramCallback);
  }
  
  public final View onCreatePanelView(int paramInt)
  {
    switch (paramInt)
    {
    }
    Menu localMenu;
    do
    {
      return super.onCreatePanelView(paramInt);
      localMenu = a.a.r();
    } while ((!onPreparePanel(paramInt, null, localMenu)) || (!onMenuOpened(paramInt, localMenu)));
    abj localabj = a;
    adu localadu;
    Object localObject;
    Resources.Theme localTheme;
    if ((d == null) && ((localMenu instanceof adu)))
    {
      localadu = (adu)localMenu;
      localObject = a.b();
      TypedValue localTypedValue = new TypedValue();
      localTheme = ((Context)localObject).getResources().newTheme();
      localTheme.setTo(((Context)localObject).getTheme());
      localTheme.resolveAttribute(aca.a, localTypedValue, true);
      if (resourceId != 0) {
        localTheme.applyStyle(resourceId, true);
      }
      localTheme.resolveAttribute(aca.G, localTypedValue, true);
      if (resourceId == 0) {
        break label260;
      }
      localTheme.applyStyle(resourceId, true);
    }
    for (;;)
    {
      localObject = new ContextThemeWrapper((Context)localObject, 0);
      ((Context)localObject).getTheme().setTo(localTheme);
      d = new ads((Context)localObject, ach.k);
      d.h = new abo(localabj);
      localadu.a(d);
      if ((localMenu != null) && (d != null)) {
        break;
      }
      return null;
      label260:
      localTheme.applyStyle(acj.b, true);
    }
    if (d.c().getCount() > 0) {
      return (View)d.a(a.a());
    }
    return null;
  }
  
  public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
    if ((bool) && (!a.b))
    {
      a.a.k();
      a.b = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     abp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */