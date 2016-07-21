import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

final class ahn
  implements alp
{
  ahn(ahm paramahm) {}
  
  public final void a(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint)
  {
    float f1 = 2.0F * paramFloat;
    float f2 = paramRectF.width() - f1 - 1.0F;
    float f3 = paramRectF.height();
    if (paramFloat >= 1.0F)
    {
      float f4 = paramFloat + 0.5F;
      a.a.set(-f4, -f4, f4, f4);
      int i = paramCanvas.save();
      paramCanvas.translate(left + f4, top + f4);
      paramCanvas.drawArc(a.a, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(a.a, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f3 - f1 - 1.0F, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(a.a, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(a.a, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.restoreToCount(i);
      paramCanvas.drawRect(left + f4 - 1.0F, top, 1.0F + (right - f4), top + f4, paramPaint);
      paramCanvas.drawRect(left + f4 - 1.0F, 1.0F + (bottom - f4), 1.0F + (right - f4), bottom, paramPaint);
    }
    f1 = left;
    f2 = top;
    paramCanvas.drawRect(f1, Math.max(0.0F, paramFloat - 1.0F) + f2, right, 1.0F + (bottom - paramFloat), paramPaint);
  }
}

/* Location:
 * Qualified Name:     ahn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */