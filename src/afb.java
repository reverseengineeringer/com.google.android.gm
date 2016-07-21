import android.content.Context;
import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;
import android.view.View;

public final class afb
  extends aeh
{
  private aep k;
  
  public afb(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, aep paramaep)
  {
    super(paramContext, paramaep, null, false, aca.n);
    k = paramaep;
    int m;
    int i;
    if (!((ady)paramaep.getItem()).f())
    {
      if (i == null)
      {
        paramContext = (View)g;
        e = paramContext;
      }
    }
    else
    {
      g = p;
      m = paramaep.size();
      i = 0;
    }
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < m)
      {
        paramActionMenuPresenter = paramaep.getItem(i);
        if ((paramActionMenuPresenter.isVisible()) && (paramActionMenuPresenter.getIcon() != null)) {
          bool1 = true;
        }
      }
      else
      {
        h = bool1;
        return;
        paramContext = i;
        break;
      }
      i += 1;
    }
  }
  
  public final void onDismiss()
  {
    super.onDismiss();
    j.n = null;
    j.q = 0;
  }
}

/* Location:
 * Qualified Name:     afb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */