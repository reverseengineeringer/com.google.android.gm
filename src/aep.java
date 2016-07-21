import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class aep
  extends adu
  implements SubMenu
{
  public adu m;
  private ady n;
  
  public aep(Context paramContext, adu paramadu, ady paramady)
  {
    super(paramContext);
    m = paramadu;
    n = paramady;
  }
  
  public final String a()
  {
    if (n != null) {}
    for (int i = n.getItemId(); i == 0; i = 0) {
      return null;
    }
    return super.a() + ":" + i;
  }
  
  public final void a(adv paramadv)
  {
    m.a(paramadv);
  }
  
  final boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    return (super.a(paramadu, paramMenuItem)) || (m.a(paramadu, paramMenuItem));
  }
  
  public final boolean a(ady paramady)
  {
    return m.a(paramady);
  }
  
  public final boolean b()
  {
    return m.b();
  }
  
  public final boolean b(ady paramady)
  {
    return m.b(paramady);
  }
  
  public final boolean c()
  {
    return m.c();
  }
  
  public MenuItem getItem()
  {
    return n;
  }
  
  public final adu k()
  {
    return m;
  }
  
  public SubMenu setHeaderIcon(int paramInt)
  {
    super.a(jr.a(a, paramInt));
    return this;
  }
  
  public SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    super.a(paramDrawable);
    return this;
  }
  
  public SubMenu setHeaderTitle(int paramInt)
  {
    super.a(a.getResources().getString(paramInt));
    return this;
  }
  
  public SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    return this;
  }
  
  public SubMenu setHeaderView(View paramView)
  {
    super.a(null, null, paramView);
    return this;
  }
  
  public SubMenu setIcon(int paramInt)
  {
    n.setIcon(paramInt);
    return this;
  }
  
  public SubMenu setIcon(Drawable paramDrawable)
  {
    n.setIcon(paramDrawable);
    return this;
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    m.setQwertyMode(paramBoolean);
  }
}

/* Location:
 * Qualified Name:     aep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */