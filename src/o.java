import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

public class o
  extends FrameLayout
{
  private Drawable a;
  private Rect b;
  private Rect c;
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((b != null) && (a != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      c.set(0, 0, i, b.top);
      a.setBounds(c);
      a.draw(paramCanvas);
      c.set(0, j - b.bottom, i, j);
      a.setBounds(c);
      a.draw(paramCanvas);
      c.set(0, b.top, b.left, j - b.bottom);
      a.setBounds(c);
      a.draw(paramCanvas);
      c.set(i - b.right, b.top, i, j - b.bottom);
      a.setBounds(c);
      a.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (a != null) {
      a.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (a != null) {
      a.setCallback(null);
    }
  }
}

/* Location:
 * Qualified Name:     o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */