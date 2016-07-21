import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;

public class bks
  extends ReplacementSpan
{
  public static final Paint b = new Paint();
  public Drawable c;
  public float d;
  
  public bks(Drawable paramDrawable)
  {
    c = paramDrawable;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat, (paramInt5 - c.getBounds().bottom + paramInt3) / 2);
    c.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    b.set(paramPaint);
    if (paramFontMetricsInt != null)
    {
      b.getFontMetricsInt(paramFontMetricsInt);
      paramPaint = i();
      paramInt1 = descent - ascent;
      paramInt2 = (int)d / 2;
      ascent = (Math.min(top, top + (paramInt1 - bottom) / 2) - paramInt2);
      int i = bottom;
      int j = bottom;
      descent = (Math.max(i, (bottom - paramInt1) / 2 + j) + paramInt2);
      top = ascent;
      bottom = descent;
    }
    return iright;
  }
  
  protected Rect i()
  {
    return c.getBounds();
  }
}

/* Location:
 * Qualified Name:     bks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */