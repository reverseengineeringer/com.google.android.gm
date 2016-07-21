import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;

public final class bvs
  extends ReplacementSpan
{
  private final TextPaint a = new TextPaint();
  private final Spanned b;
  private final bvt c;
  
  public bvs(Spanned paramSpanned, bvt parambvt)
  {
    b = paramSpanned;
    c = parambvt;
  }
  
  private final int a(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    return (int)paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) + c.a() * 2;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    a.set(paramPaint);
    paramPaint = (CharacterStyle[])b.getSpans(paramInt1, paramInt2, CharacterStyle.class);
    int j = paramPaint.length;
    int i = 0;
    while (i < j)
    {
      paramPaint[i].updateDrawState(a);
      i += 1;
    }
    if (a.bgColor != 0)
    {
      i = a.getColor();
      paramPaint = a.getStyle();
      a.setColor(a.bgColor);
      a.setStyle(Paint.Style.FILL);
      j = a(a, paramCharSequence, paramInt1, paramInt2);
      RectF localRectF = new RectF(paramFloat, paramInt3, j + paramFloat, paramInt5);
      float f = c.b();
      paramCanvas.drawRoundRect(localRectF, f, f, a);
      a.setColor(i);
      a.setStyle(paramPaint);
    }
    paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat + c.a(), paramInt4, a);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramFontMetricsInt != null)
    {
      paramPaint.getFontMetricsInt(paramFontMetricsInt);
      top = ascent;
    }
    return a(paramPaint, paramCharSequence, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     bvs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */