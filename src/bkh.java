import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View.DragShadowBuilder;
import com.android.ex.chips.RecipientEditTextView;

public final class bkh
  extends View.DragShadowBuilder
{
  private final bkq b;
  
  public bkh(RecipientEditTextView paramRecipientEditTextView, bkq parambkq)
  {
    b = parambkq;
  }
  
  public final void onDrawShadow(Canvas paramCanvas)
  {
    b.a(paramCanvas);
  }
  
  public final void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    Rect localRect = b.i();
    paramPoint1.set(localRect.width(), localRect.height());
    paramPoint2.set(localRect.centerX(), localRect.centerY());
  }
}

/* Location:
 * Qualified Name:     bkh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */