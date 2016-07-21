import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

public final class cea
  extends InsetDrawable
{
  private final Paint a = new Paint();
  
  public cea(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramDrawable, paramInt1, 0, paramInt2, 0);
    a.setColor(paramInt3);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.drawRect(getBounds(), a);
    super.draw(paramCanvas);
  }
}

/* Location:
 * Qualified Name:     cea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */