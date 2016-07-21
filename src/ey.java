import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class ey
  implements ViewTreeObserver.OnPreDrawListener
{
  ey(ev paramev, View paramView, fa paramfa, int paramInt, Object paramObject) {}
  
  public final boolean onPreDraw()
  {
    a.getViewTreeObserver().removeOnPreDrawListener(this);
    e.a(b, c, d);
    return true;
  }
}

/* Location:
 * Qualified Name:     ey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */