package com.google.android.apps.work.common.richedittext;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.BulletSpan;
import android.util.DisplayMetrics;

public class RichTextBulletSpan
  extends BulletSpan
{
  private int a;
  private int b;
  private int c;
  
  public RichTextBulletSpan()
  {
    this((byte)0);
  }
  
  private RichTextBulletSpan(byte paramByte)
  {
    a = 2;
    b = 52;
    c = 4;
  }
  
  public RichTextBulletSpan(RichTextBulletSpan paramRichTextBulletSpan)
  {
    a = a;
    b = b;
    c = c;
  }
  
  public void drawLeadingMargin(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, boolean paramBoolean, Layout paramLayout)
  {
    float f = getSystemgetDisplayMetricsscaledDensity;
    paramInt4 = Math.round(b * f);
    paramInt7 = Math.round(f * a);
    if (((Spanned)paramCharSequence).getSpanStart(this) == paramInt6)
    {
      paramCharSequence = paramPaint.getStyle();
      paramPaint.setStyle(Paint.Style.FILL);
      if (!paramCanvas.isHardwareAccelerated()) {
        break label144;
      }
      paramLayout = new Path();
      paramLayout.addCircle(0.0F, 0.0F, 1.2F * paramInt7, Path.Direction.CW);
      paramCanvas.save();
      paramCanvas.translate((paramInt7 + paramInt4) * paramInt2 + paramInt1, (paramInt3 + paramInt5) / 2.0F);
      paramCanvas.drawPath(paramLayout, paramPaint);
      paramCanvas.restore();
    }
    for (;;)
    {
      paramPaint.setStyle(paramCharSequence);
      return;
      label144:
      paramCanvas.drawCircle((paramInt4 + paramInt7) * paramInt2 + paramInt1, (paramInt3 + paramInt5) / 2.0F, paramInt7, paramPaint);
    }
  }
  
  public int getLeadingMargin(boolean paramBoolean)
  {
    return Math.round(getSystemgetDisplayMetricsscaledDensity * (b + a * 2 + c));
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.RichTextBulletSpan
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */