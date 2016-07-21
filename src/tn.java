import android.view.View;
import android.view.ViewPropertyAnimator;

class tn
  extends tl
{
  public final void a(View paramView, ty paramty)
  {
    tv localtv = null;
    if (paramty != null) {
      localtv = new tv(paramty, paramView);
    }
    paramView.animate().setUpdateListener(localtv);
  }
}

/* Location:
 * Qualified Name:     tn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */