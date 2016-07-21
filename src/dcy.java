import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ToggleButton;
import com.google.android.apps.work.common.richedittext.RichTextToolbar;

public final class dcy
  implements View.OnTouchListener
{
  public dcy(RichTextToolbar paramRichTextToolbar) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getActionMasked() & 0x4) == 4) && (a.k != null))
    {
      paramView = new int[2];
      a.k.getLocationOnScreen(paramView);
      if ((!new Rect(paramView[0], paramView[1], paramView[0] + a.k.getWidth(), paramView[1] + a.k.getHeight()).contains(Math.round(paramMotionEvent.getRawX()), Math.round(paramMotionEvent.getRawY()))) && ((a.k instanceof ToggleButton))) {
        ((ToggleButton)a.k).setChecked(false);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     dcy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */