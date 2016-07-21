package android.support.v7.widget;

import aca;
import aci;
import afo;
import afz;
import agj;
import ajn;
import alz;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import oy;

public class ShareActionProvider
  extends oy
{
  public final Context c;
  public String d = "share_history.xml";
  private int e = 4;
  private final alz f = new alz(this);
  
  public ShareActionProvider(Context paramContext)
  {
    super(paramContext);
    c = paramContext;
  }
  
  public final View a()
  {
    ActivityChooserView localActivityChooserView = new ActivityChooserView(c);
    if (!localActivityChooserView.isInEditMode())
    {
      localObject = afo.a(c, d);
      afz localafz = a;
      afo localafo = c.a.a;
      if ((localafo != null) && (c.isShown())) {
        localafo.unregisterObserver(c.i);
      }
      a = ((afo)localObject);
      if ((localObject != null) && (c.isShown())) {
        ((afo)localObject).registerObserver(c.i);
      }
      localafz.notifyDataSetChanged();
      if (de.isShowing())
      {
        localActivityChooserView.b();
        localActivityChooserView.a();
      }
    }
    Object localObject = new TypedValue();
    c.getTheme().resolveAttribute(aca.k, (TypedValue)localObject, true);
    localObject = agj.a().a(c, resourceId, false);
    e.setImageDrawable((Drawable)localObject);
    h = this;
    m = aci.e;
    int i = aci.d;
    localObject = localActivityChooserView.getContext().getString(i);
    e.setContentDescription((CharSequence)localObject);
    return localActivityChooserView;
  }
  
  public final void a(SubMenu paramSubMenu)
  {
    paramSubMenu.clear();
    afo localafo = afo.a(c, d);
    PackageManager localPackageManager = c.getPackageManager();
    int j = localafo.a();
    int k = Math.min(j, e);
    int i = 0;
    ResolveInfo localResolveInfo;
    while (i < k)
    {
      localResolveInfo = localafo.a(i);
      paramSubMenu.add(0, i, i, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(f);
      i += 1;
    }
    if (k < j)
    {
      paramSubMenu = paramSubMenu.addSubMenu(0, k, k, c.getString(aci.b));
      i = 0;
      while (i < j)
      {
        localResolveInfo = localafo.a(i);
        paramSubMenu.add(0, i, i, localResolveInfo.loadLabel(localPackageManager)).setIcon(localResolveInfo.loadIcon(localPackageManager)).setOnMenuItemClickListener(f);
        i += 1;
      }
    }
  }
  
  public final boolean e()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ShareActionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */