import android.content.Context;
import android.support.v7.app.AppCompatDelegateImplV7;
import android.support.v7.widget.ContentFrameLayout;
import android.view.KeyEvent;
import android.view.MotionEvent;

public final class abc
  extends ContentFrameLayout
{
  public abc(AppCompatDelegateImplV7 paramAppCompatDelegateImplV7, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (a.a(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((i < -5) || (j < -5) || (i > getWidth() + 5) || (j > getHeight() + 5)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramMotionEvent = a;
        paramMotionEvent.a(paramMotionEvent.g(0), true);
        return true;
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    setBackgroundDrawable(agj.a().a(getContext(), paramInt, false));
  }
}

/* Location:
 * Qualified Name:     abc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */