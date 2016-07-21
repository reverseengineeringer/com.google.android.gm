import android.support.design.widget.Snackbar;
import android.view.View;

public final class bl
  implements cd
{
  bl(Snackbar paramSnackbar) {}
  
  public final void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      bv.a().a(a.d);
      return;
    }
    bv.a().b(a.d);
  }
  
  public final void a(View paramView)
  {
    paramView.setVisibility(8);
    ??? = a;
    paramView = bv.a();
    bx localbx = d;
    synchronized (a)
    {
      if (paramView.d(localbx)) {
        paramView.a(b);
      }
      while (!paramView.e(localbx)) {
        return;
      }
      paramView.a(c);
    }
  }
}

/* Location:
 * Qualified Name:     bl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */