import android.view.View;
import android.view.ViewPropertyAnimator;

class tm
  extends tj
{
  public final void a(tg paramtg, View paramView, tw paramtw)
  {
    if (paramtw != null)
    {
      paramView.animate().setListener(new tt(paramtw, paramView));
      return;
    }
    paramView.animate().setListener(null);
  }
}

/* Location:
 * Qualified Name:     tm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */