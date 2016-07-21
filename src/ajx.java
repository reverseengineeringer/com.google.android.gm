import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

final class ajx
  implements View.OnTouchListener
{
  ajx(ajn paramajn) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if ((i == 0) && (a.e != null) && (a.e.isShowing()) && (j >= 0) && (j < a.e.getWidth()) && (k >= 0) && (k < a.e.getHeight())) {
      a.q.postDelayed(a.p, 250L);
    }
    for (;;)
    {
      return false;
      if (i == 1) {
        a.q.removeCallbacks(a.p);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ajx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */