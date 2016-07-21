import android.content.Context;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

final class aeg
  extends aeb
  implements ActionProvider.VisibilityListener
{
  pa e;
  
  public aeg(aef paramaef, Context paramContext, ActionProvider paramActionProvider)
  {
    super(paramaef, paramContext, paramActionProvider);
  }
  
  public final View a(MenuItem paramMenuItem)
  {
    return c.onCreateActionView(paramMenuItem);
  }
  
  public final void a(pa parampa)
  {
    e = parampa;
    c.setVisibilityListener(this);
  }
  
  public final boolean b()
  {
    return c.overridesItemVisibility();
  }
  
  public final boolean c()
  {
    return c.isVisible();
  }
  
  public final void onActionProviderVisibilityChanged(boolean paramBoolean)
  {
    if (e != null) {
      e.a();
    }
  }
}

/* Location:
 * Qualified Name:     aeg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */