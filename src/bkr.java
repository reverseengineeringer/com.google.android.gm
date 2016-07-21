import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;

public final class bkr
  extends ReplacementSpan
  implements bkq
{
  private final bkt a;
  
  public bkr(bkn parambkn)
  {
    a = new bkt(parambkn);
  }
  
  public final void a(Canvas paramCanvas) {}
  
  public final void a(String paramString)
  {
    a.a(paramString);
  }
  
  public final boolean a()
  {
    return a.g;
  }
  
  public final CharSequence b()
  {
    return a.a;
  }
  
  public final long c()
  {
    return a.b;
  }
  
  public final Long d()
  {
    return a.c;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint) {}
  
  public final String e()
  {
    return a.d;
  }
  
  public final long f()
  {
    return a.e;
  }
  
  public final bkn g()
  {
    return a.f;
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    return 0;
  }
  
  public final CharSequence h()
  {
    return a.h();
  }
  
  public final Rect i()
  {
    return new Rect(0, 0, 0, 0);
  }
}

/* Location:
 * Qualified Name:     bkr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */