import android.content.Context;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class add
  extends acz
  implements adv
{
  private Context a;
  private ActionBarContextView d;
  private ada e;
  private WeakReference<View> f;
  private boolean g;
  private boolean h;
  private adu i;
  
  public add(Context paramContext, ActionBarContextView paramActionBarContextView, ada paramada, boolean paramBoolean)
  {
    a = paramContext;
    d = paramActionBarContextView;
    e = paramada;
    paramContext = new adu(paramActionBarContextView.getContext());
    e = 1;
    i = paramContext;
    i.a(this);
    h = paramBoolean;
  }
  
  public final MenuInflater a()
  {
    return new adg(d.getContext());
  }
  
  public final void a(int paramInt)
  {
    b(a.getString(paramInt));
  }
  
  public final void a(adu paramadu)
  {
    d();
    d.a();
  }
  
  public final void a(View paramView)
  {
    d.a(paramView);
    if (paramView != null) {}
    for (paramView = new WeakReference(paramView);; paramView = null)
    {
      f = paramView;
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    d.b(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    d.a(paramBoolean);
  }
  
  public final boolean a(adu paramadu, MenuItem paramMenuItem)
  {
    return e.a(this, paramMenuItem);
  }
  
  public final Menu b()
  {
    return i;
  }
  
  public final void b(int paramInt)
  {
    a(a.getString(paramInt));
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    d.a(paramCharSequence);
  }
  
  public final void c()
  {
    if (g) {
      return;
    }
    g = true;
    d.sendAccessibilityEvent(32);
    e.a(this);
  }
  
  public final void d()
  {
    e.b(this, i);
  }
  
  public final CharSequence f()
  {
    return d.g;
  }
  
  public final CharSequence g()
  {
    return d.h;
  }
  
  public final boolean h()
  {
    return d.j;
  }
  
  public final View i()
  {
    if (f != null) {
      return (View)f.get();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     add
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */