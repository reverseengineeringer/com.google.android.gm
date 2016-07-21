import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

final class pf
  implements pc
{
  private final GestureDetector a;
  
  public pf(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    a = new GestureDetector(paramContext, paramOnGestureListener, null);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    return a.onTouchEvent(paramMotionEvent);
  }
}

/* Location:
 * Qualified Name:     pf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */