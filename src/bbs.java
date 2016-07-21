import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.android.email.view.SlidingSetupWizardLayout;

public final class bbs
  implements ViewTreeObserver.OnPreDrawListener
{
  public bbs(SlidingSetupWizardLayout paramSlidingSetupWizardLayout) {}
  
  public final boolean onPreDraw()
  {
    a.getViewTreeObserver().removeOnPreDrawListener(a.b);
    a.setXFraction(a.a);
    return true;
  }
}

/* Location:
 * Qualified Name:     bbs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */