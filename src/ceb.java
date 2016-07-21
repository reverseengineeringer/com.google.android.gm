import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public final class ceb
  extends Drawable
{
  public final Paint a = new Paint();
  private final int b;
  
  public ceb(Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    a.setShader(paramBitmap);
    a.setAntiAlias(true);
    b = paramInt;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    bottom += b;
    paramCanvas.drawRoundRect(new RectF(localRect), b, b, a);
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt)
  {
    a.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    a.setColorFilter(paramColorFilter);
  }
}

/* Location:
 * Qualified Name:     ceb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */