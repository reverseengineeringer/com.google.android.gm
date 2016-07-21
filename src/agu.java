import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

final class agu
  implements ViewTreeObserver.OnScrollChangedListener
{
  agu(Field paramField, PopupWindow paramPopupWindow, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener) {}
  
  public final void onScrollChanged()
  {
    try
    {
      WeakReference localWeakReference = (WeakReference)a.get(b);
      if (localWeakReference != null)
      {
        if (localWeakReference.get() == null) {
          return;
        }
        c.onScrollChanged();
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException) {}
  }
}

/* Location:
 * Qualified Name:     agu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */