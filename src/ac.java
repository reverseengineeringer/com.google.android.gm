import android.support.design.widget.CoordinatorLayout;
import android.view.View;

public final class ac
  implements qu
{
  public ac(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final tz a(View paramView, tz paramtz)
  {
    boolean bool2 = true;
    int i = 0;
    CoordinatorLayout localCoordinatorLayout = a;
    if (j != paramtz)
    {
      j = paramtz;
      if (paramtz.b() > 0)
      {
        bool1 = true;
        k = bool1;
        if ((k) || (localCoordinatorLayout.getBackground() != null)) {
          break label143;
        }
      }
      label143:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localCoordinatorLayout.setWillNotDraw(bool1);
        if (paramtz.e()) {
          break label149;
        }
        int j = localCoordinatorLayout.getChildCount();
        paramView = paramtz;
        for (;;)
        {
          paramtz = paramView;
          if (i >= j) {
            break;
          }
          paramtz = localCoordinatorLayout.getChildAt(i);
          if ((rg.t(paramtz)) && (getLayoutParamsa != null))
          {
            paramtz = paramView;
            if (paramView.e()) {
              break;
            }
          }
          i += 1;
        }
        bool1 = false;
        break;
      }
      label149:
      localCoordinatorLayout.requestLayout();
      return paramtz;
    }
    return paramtz;
  }
}

/* Location:
 * Qualified Name:     ac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */