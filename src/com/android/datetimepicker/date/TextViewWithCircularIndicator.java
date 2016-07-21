package com.android.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.TextView;
import aog;
import aoh;
import aol;

public class TextViewWithCircularIndicator
  extends TextView
{
  Paint a = new Paint();
  public boolean b;
  private final int c;
  private final int d;
  private final String e;
  
  public TextViewWithCircularIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources();
    d = paramAttributeSet.getColor(aog.b);
    c = paramAttributeSet.getDimensionPixelOffset(aoh.h);
    e = paramContext.getResources().getString(aol.h);
    a.setFakeBoldText(true);
    a.setAntiAlias(true);
    a.setColor(d);
    a.setTextAlign(Paint.Align.CENTER);
    a.setStyle(Paint.Style.FILL);
    a.setAlpha(60);
  }
  
  public CharSequence getContentDescription()
  {
    CharSequence localCharSequence = getText();
    Object localObject = localCharSequence;
    if (b) {
      localObject = String.format(e, new Object[] { localCharSequence });
    }
    return (CharSequence)localObject;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (b)
    {
      int i = getWidth();
      int j = getHeight();
      int k = Math.min(i, j) / 2;
      paramCanvas.drawCircle(i / 2, j / 2, k, a);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.datetimepicker.date.TextViewWithCircularIndicator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */