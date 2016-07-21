import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class cyb
  implements ViewTreeObserver.OnPreDrawListener
{
  cyb(cya paramcya) {}
  
  public final boolean onPreDraw()
  {
    a.getViewTreeObserver().removeOnPreDrawListener(a.d);
    a.setXFraction(a.c);
    return true;
  }
}

/* Location:
 * Qualified Name:     cyb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */