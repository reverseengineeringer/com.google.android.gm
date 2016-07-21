import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

final class bux
  extends Drawable
{
  private static Bitmap a;
  private static int b;
  private static final Matrix f = new Matrix();
  private final Paint c;
  private float d;
  private float e;
  
  public bux(Resources paramResources)
  {
    if (a == null)
    {
      a = BitmapFactory.decodeResource(paramResources, bub.q);
      b = paramResources.getColor(btz.c);
    }
    c = new Paint();
    c.setAntiAlias(true);
    c.setFilterBitmap(true);
    c.setColor(b);
  }
  
  public final void a(float paramFloat)
  {
    float f1 = d;
    d = paramFloat;
    if (f1 != d) {
      invalidateSelf();
    }
  }
  
  public final void b(float paramFloat)
  {
    float f1 = e;
    e = paramFloat;
    if (f1 != e) {
      invalidateSelf();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    if ((!isVisible()) || (localRect.isEmpty())) {
      return;
    }
    paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), localRect.width() / 2, c);
    f.reset();
    f.setScale(d, d, a.getWidth() / 2, a.getHeight() / 2);
    f.postTranslate(localRect.centerX() - a.getWidth() / 2, localRect.centerY() - a.getHeight() / 2);
    int i = c.getAlpha();
    c.setAlpha((int)(i * e));
    paramCanvas.drawBitmap(a, f, c);
    c.setAlpha(i);
  }
  
  public final int getOpacity()
  {
    return -1;
  }
  
  public final void setAlpha(int paramInt)
  {
    c.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    c.setColorFilter(paramColorFilter);
  }
}

/* Location:
 * Qualified Name:     bux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */