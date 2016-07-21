package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View.MeasureSpec;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import cxy;

public class Illustration
  extends FrameLayout
{
  public float a = 0.0F;
  private float b;
  private Drawable c;
  private Drawable d;
  private final Rect e = new Rect();
  private final Rect f = new Rect();
  private float g = 1.0F;
  
  public Illustration(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public Illustration(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public Illustration(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, cxy.ar, paramInt, 0);
      a = paramAttributeSet.getFloat(cxy.as, 0.0F);
      paramAttributeSet.recycle();
    }
    b = (getResourcesgetDisplayMetricsdensity * 8.0F);
    setWillNotDraw(false);
  }
  
  private final boolean a(Drawable paramDrawable, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        bool = paramDrawable.isAutoMirrored();
      }
      do
      {
        return bool;
        if (Build.VERSION.SDK_INT < 17) {
          break;
        }
      } while ((getContextgetApplicationInfoflags & 0x400000) != 0);
      return false;
    }
    return false;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (paramDrawable == d) {
      return;
    }
    d = paramDrawable;
    invalidate();
    requestLayout();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (c != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, f.height());
      paramCanvas.scale(g, g, 0.0F, 0.0F);
      if ((Build.VERSION.SDK_INT > 17) && (a(c, getLayoutDirection())))
      {
        paramCanvas.scale(-1.0F, 1.0F);
        paramCanvas.translate(-c.getBounds().width(), 0.0F);
      }
      c.draw(paramCanvas);
      paramCanvas.restore();
    }
    if (d != null)
    {
      paramCanvas.save();
      if ((Build.VERSION.SDK_INT > 17) && (a(d, getLayoutDirection())))
      {
        paramCanvas.scale(-1.0F, 1.0F);
        paramCanvas.translate(-f.width(), 0.0F);
      }
      d.draw(paramCanvas);
      paramCanvas.restore();
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    if (d != null)
    {
      int m = d.getIntrinsicWidth();
      int n = d.getIntrinsicHeight();
      e.set(0, 0, k, i1);
      int j = n;
      int i = m;
      if (a != 0.0F)
      {
        g = (k / m);
        j = (int)(n * g);
        i = k;
      }
      Gravity.apply(55, i, j, e, f);
      d.setBounds(f);
    }
    if (c != null) {
      c.setBounds(0, 0, (int)Math.ceil(k / g), (int)Math.ceil((i1 - f.height()) / g));
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (a != 0.0F)
    {
      int i = (int)(View.MeasureSpec.getSize(paramInt1) / a);
      setPadding(0, (int)(i - i % b), 0, 0);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == c) {
      return;
    }
    c = paramDrawable;
    invalidate();
    requestLayout();
  }
  
  @Deprecated
  public void setForeground(Drawable paramDrawable)
  {
    a(paramDrawable);
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.Illustration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */