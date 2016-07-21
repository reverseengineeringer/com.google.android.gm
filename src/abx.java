import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public final class abx
  extends acz
  implements adv
{
  private final Context d;
  private final adu e;
  private ada f;
  private WeakReference<View> g;
  
  public abx(abt paramabt, Context paramContext, ada paramada)
  {
    d = paramContext;
    f = paramada;
    paramabt = new adu(paramContext);
    e = 1;
    e = paramabt;
    e.a(this);
  }
  
  public final MenuInflater a()
  {
    return new adg(d);
  }
  
  public final void a(int paramInt)
  {
    b(a.a.getResources().getString(paramInt));
  }
  
  public final void a(adu paramadu)
  {
    if (f == null) {
      return;
    }
    d();
    a.e.a();
  }
  
  public final void a(View paramView)
  {
    a.e.a(paramView);
    g = new WeakReference(paramView);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    a.e.b(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    a.e.a(paramBoolean);
  }
  
  public final boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    if (f != null) {
      return f.a(this, paramMenuItem);
    }
    return false;
  }
  
  public final Menu b()
  {
    return e;
  }
  
  public final void b(int paramInt)
  {
    a(a.a.getResources().getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a.e.a(paramCharSequence);
  }
  
  public final void c()
  {
    if (a.g != this) {
      return;
    }
    if (!abt.a(a.k, a.l, false))
    {
      a.h = this;
      a.i = f;
    }
    for (;;)
    {
      f = null;
      a.g(false);
      ActionBarContextView localActionBarContextView = a.e;
      if (i == null) {
        localActionBarContextView.b();
      }
      a.d.a().sendAccessibilityEvent(32);
      a.b.a(a.n);
      a.g = null;
      return;
      f.a(this);
    }
  }
  
  public final void d()
  {
    if (a.g != this) {
      return;
    }
    e.d();
    try
    {
      f.b(this, e);
      return;
    }
    finally
    {
      e.e();
    }
  }
  
  public final boolean e()
  {
    e.d();
    try
    {
      boolean bool = f.a(this, e);
      return bool;
    }
    finally
    {
      e.e();
    }
  }
  
  public final CharSequence f()
  {
    return a.e.g;
  }
  
  public final CharSequence g()
  {
    return a.e.h;
  }
  
  public final boolean h()
  {
    return a.e.j;
  }
  
  public final View i()
  {
    if (g != null) {
      return (View)g.get();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     abx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */