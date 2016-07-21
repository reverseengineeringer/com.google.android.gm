import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;

public final class att
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public att(ats paramats) {}
  
  public final void onGlobalLayout()
  {
    a.m.smoothScrollTo(0, 0);
    ViewTreeObserver localViewTreeObserver = a.m.getViewTreeObserver();
    if (cxd.a())
    {
      localViewTreeObserver.removeOnGlobalLayoutListener(this);
      return;
    }
    localViewTreeObserver.removeGlobalOnLayoutListener(this);
  }
}

/* Location:
 * Qualified Name:     att
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */