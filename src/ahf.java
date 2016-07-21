import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.PopupWindow.OnDismissListener;

final class ahf
  implements PopupWindow.OnDismissListener
{
  ahf(ahc paramahc, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener) {}
  
  public final void onDismiss()
  {
    ViewTreeObserver localViewTreeObserver = b.d.getViewTreeObserver();
    if (localViewTreeObserver != null) {
      localViewTreeObserver.removeGlobalOnLayoutListener(a);
    }
  }
}

/* Location:
 * Qualified Name:     ahf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */