import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Canvas;
import android.view.Window;

public final class cke
  extends acr
{
  public boolean c;
  public ValueAnimator d;
  private final Activity e;
  
  public cke(Activity paramActivity)
  {
    super(paramActivity);
    e = paramActivity;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (cxe.a(e.getWindow().getDecorView())) {}
    for (int i = 1;; i = 0)
    {
      if (i != b)
      {
        b = i;
        invalidateSelf();
      }
      super.draw(paramCanvas);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */