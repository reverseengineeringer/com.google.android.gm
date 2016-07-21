import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class akg
  implements adv, aek
{
  public Context a;
  public adu b;
  public View c;
  public aeh d;
  public aki e;
  public View.OnTouchListener f;
  
  public akg(Context paramContext, View paramView)
  {
    this(paramContext, paramView, 0, aca.H);
  }
  
  private akg(Context paramContext, View paramView, int paramInt1, int paramInt2)
  {
    a = paramContext;
    b = new adu(paramContext);
    b.a(this);
    c = paramView;
    d = new aeh(paramContext, b, paramView, false, paramInt2, 0);
    d.i = 0;
    d.g = this;
  }
  
  public void a()
  {
    d.c();
  }
  
  public final void a(adu paramadu) {}
  
  public final void a(adu paramadu, boolean paramBoolean) {}
  
  public final boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    if (e != null) {
      return e.a(paramMenuItem);
    }
    return false;
  }
  
  public final boolean a_(adu paramadu)
  {
    boolean bool = true;
    if (paramadu == null) {
      bool = false;
    }
    while (!paramadu.hasVisibleItems()) {
      return bool;
    }
    new aeh(a, paramadu, c).c();
    return true;
  }
}

/* Location:
 * Qualified Name:     akg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */