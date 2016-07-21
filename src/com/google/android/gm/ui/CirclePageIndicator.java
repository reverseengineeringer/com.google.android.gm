package com.google.android.gm.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import dft;
import dfw;
import dgg;
import qv;
import su;

public class CirclePageIndicator
  extends View
  implements su
{
  public ViewPager a;
  private final float b;
  private final float c;
  private Paint d;
  private Paint e;
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, dft.a);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, dgg.s);
    try
    {
      d = new Paint();
      d.setStyle(Paint.Style.FILL);
      d.setAntiAlias(true);
      d.setColor(paramContext.getColor(dgg.t, 17170450));
      e = new Paint();
      e.setStyle(Paint.Style.FILL);
      e.setAntiAlias(true);
      e.setColor(paramContext.getColor(dgg.u, 17170451));
      b = paramContext.getDimension(dgg.v, localResources.getDimension(dfw.i));
      c = paramContext.getDimension(dgg.w, b);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private final int a()
  {
    return b() + getPaddingLeft() + getPaddingRight();
  }
  
  private final int b()
  {
    if (a == null) {
      return 0;
    }
    int i = d();
    float f1 = b;
    float f2 = i;
    float f3 = c;
    return (int)((i - 1) * f3 + f1 * f2);
  }
  
  private final int c()
  {
    if (a == null) {}
    for (int i = 0;; i = (int)b) {
      return i + getPaddingTop() + getPaddingBottom();
    }
  }
  
  private final int d()
  {
    if (a != null) {
      return a.b.a();
    }
    return 0;
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void a_(int paramInt)
  {
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f3 = getMeasuredWidth() - (getPaddingLeft() + getPaddingRight());
    float f4 = getMeasuredHeight() - (getPaddingTop() + getPaddingBottom());
    if ((f3 <= 0.0F) || (f4 <= 0.0F)) {
      return;
    }
    int k = d();
    int i;
    label76:
    float f2;
    float f1;
    int j;
    if (a != null)
    {
      i = a.c;
      f2 = b / 2.0F;
      f1 = getPaddingLeft();
      float f5 = f3 / 2.0F;
      float f6 = b() / 2;
      f3 = getPaddingTop();
      f4 /= 2.0F;
      f1 = f5 + f1 - f6 + f2;
      j = 0;
      label130:
      if (j < k) {
        if (i != j) {
          break label190;
        }
      }
    }
    label190:
    for (Paint localPaint = d;; localPaint = e)
    {
      paramCanvas.drawCircle(f1, f3 + f4, f2, localPaint);
      f1 += b + c;
      j += 1;
      break label130;
      break;
      i = -1;
      break label76;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    switch (View.MeasureSpec.getMode(paramInt1))
    {
    default: 
      paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
      switch (View.MeasureSpec.getMode(paramInt2))
      {
      default: 
        paramInt2 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
      }
      break;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      break;
      paramInt1 = Math.max(a(), getSuggestedMinimumWidth());
      break;
      paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), Math.max(a(), getSuggestedMinimumWidth()));
      break;
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      continue;
      paramInt2 = Math.max(c(), getSuggestedMinimumHeight());
      continue;
      paramInt2 = Math.min(View.MeasureSpec.getSize(paramInt2), Math.max(c(), getSuggestedMinimumHeight()));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.CirclePageIndicator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */