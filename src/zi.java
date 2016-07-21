import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

public final class zi
  implements wm
{
  public final DrawerLayout a;
  public Drawable b;
  public boolean c = true;
  public boolean d;
  private final zj e;
  private zm f;
  private final int g;
  private final int h;
  private boolean i = false;
  
  public zi(Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2)
  {
    this(paramActivity, paramDrawerLayout, paramInt1, paramInt2, (byte)0);
  }
  
  private <T extends Drawable,  extends zm> zi(DrawerLayout paramDrawerLayout, int paramInt, byte paramByte)
  {
    if ((paramDrawerLayout instanceof zk)) {
      e = ((zk)paramDrawerLayout).c();
    }
    for (;;)
    {
      a = paramInt;
      g = paramByte;
      int j;
      h = j;
      f = new zl(paramDrawerLayout, e.b());
      b = b();
      return;
      if (Build.VERSION.SDK_INT >= 18) {
        e = new zp(paramDrawerLayout);
      } else if (Build.VERSION.SDK_INT >= 11) {
        e = new zo(paramDrawerLayout);
      } else {
        e = new zn(paramDrawerLayout);
      }
    }
  }
  
  private final void b(int paramInt)
  {
    e.a(paramInt);
  }
  
  public final void a()
  {
    Drawable localDrawable;
    if (a.c())
    {
      f.a(1.0F);
      if (c)
      {
        localDrawable = (Drawable)f;
        if (!a.c()) {
          break label70;
        }
      }
    }
    label70:
    for (int j = h;; j = g)
    {
      a(localDrawable, j);
      return;
      f.a(0.0F);
      break;
    }
  }
  
  public final void a(int paramInt) {}
  
  public final void a(Drawable paramDrawable, int paramInt)
  {
    if ((!i) && (!e.c()))
    {
      Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
      i = true;
    }
    e.a(paramDrawable, paramInt);
  }
  
  public final void a(View paramView)
  {
    f.a(1.0F);
    if (c) {
      b(h);
    }
  }
  
  public final void a(View paramView, float paramFloat)
  {
    f.a(Math.min(1.0F, Math.max(0.0F, paramFloat)));
  }
  
  public final Drawable b()
  {
    return e.a();
  }
  
  public final void b(View paramView)
  {
    f.a(0.0F);
    if (c) {
      b(g);
    }
  }
}

/* Location:
 * Qualified Name:     zi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */