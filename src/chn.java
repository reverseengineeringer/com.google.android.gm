import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ReplacementSpan;

public final class chn
  extends ReplacementSpan
{
  private final TextPaint a = new TextPaint();
  private final String b;
  private final int c;
  private final int d;
  private final cnj e;
  private final mx f;
  private final cho g;
  
  public chn(String paramString, int paramInt1, int paramInt2, cnj paramcnj, mx parammx, cho paramcho)
  {
    b = paramString;
    c = paramInt1;
    d = paramInt2;
    e = paramcnj;
    f = parammx;
    g = paramcho;
  }
  
  private final int a(Paint paramPaint)
  {
    paramPaint.setTextSize(e.g);
    return Math.min((int)paramPaint.measureText(b) + e.e * 2, g.b());
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    a.set(paramPaint);
    a.setTextSize(e.g);
    paramInt1 = a(a);
    paramCharSequence = a;
    paramCharSequence.setTextSize(e.g);
    paramCharSequence = paramCharSequence.getFontMetricsInt();
    paramInt2 = bottom - top;
    paramCharSequence = b;
    if (paramInt1 == g.b()) {
      paramCharSequence = TextUtils.ellipsize(b, a, paramInt1 - e.e * 2, TextUtils.TruncateAt.MIDDLE).toString();
    }
    cni.a(paramCanvas, paramFloat, paramInt4 - paramInt2, paramInt1, paramInt2, paramCharSequence, c, d, e, f, a);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    a.set(paramPaint);
    return a(a);
  }
}

/* Location:
 * Qualified Name:     chn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */