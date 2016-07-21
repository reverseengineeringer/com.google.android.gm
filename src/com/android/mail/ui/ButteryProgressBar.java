package com.android.mail.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import bul;
import ckp;
import ckq;

public class ButteryProgressBar
  extends View
{
  private final GradientDrawable a;
  private final ValueAnimator b;
  private final Paint c = new Paint();
  private final int d;
  private final int e;
  private final int f;
  private final float g;
  private int h;
  
  public ButteryProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ButteryProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g = getResourcesgetDisplayMetricsdensity;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, bul.p);
    try
    {
      d = paramAttributeSet.getColor(bul.q, paramContext.getResources().getColor(17170450));
      e = paramAttributeSet.getDimensionPixelSize(bul.r, Math.round(4.0F * g));
      f = paramAttributeSet.getDimensionPixelSize(bul.s, Math.round(3.0F * g));
      paramAttributeSet.recycle();
      b = new ValueAnimator();
      b.setFloatValues(new float[] { 1.0F, 2.0F });
      b.setRepeatCount(-1);
      b.setInterpolator(new ckq());
      b.addUpdateListener(new ckp(this));
      c.setColor(d);
      a = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { d & 0xFFFFFF | 0x22000000, 0 });
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private final void a()
  {
    if (getVisibility() != 0) {
      return;
    }
    b.start();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b.cancel();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!b.isStarted()) {
      return;
    }
    a.draw(paramCanvas);
    float f2 = ((Float)b.getAnimatedValue()).floatValue();
    int j = getWidth();
    int k = j >> h - 1;
    int i = 0;
    label53:
    float f3;
    if (i < h)
    {
      f3 = f2 * (j >> i + 1);
      if (i != 0) {
        break label126;
      }
    }
    label126:
    for (float f1 = j + k;; f1 = 2.0F * f3)
    {
      paramCanvas.drawRect(f3 + f - k, 0.0F, f1 - k, e, c);
      i += 1;
      break label53;
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      paramInt1 = getWidth();
      a.setBounds(0, e, paramInt1, getHeight() - e);
      float f1 = paramInt1 / g / 300.0F;
      b.setDuration((int)((0.3F * (f1 - 1.0F) + 1.0F) * 500.0F));
      h = ((int)(((f1 - 1.0F) * 0.1F + 1.0F) * 5.0F));
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      a();
      return;
    }
    b.cancel();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ButteryProgressBar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */