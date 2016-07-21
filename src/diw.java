import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

final class diw
  implements Runnable
{
  diw(Spinner paramSpinner, TextView paramTextView, View paramView) {}
  
  public final void run()
  {
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    a.getHitRect(localRect1);
    b.getHitRect(localRect2);
    bottom = bottom;
    c.setTouchDelegate(new TouchDelegate(localRect1, a));
  }
}

/* Location:
 * Qualified Name:     diw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */