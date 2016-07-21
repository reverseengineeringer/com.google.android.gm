package android.support.design.widget;

import ae;
import agj;
import agq;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import ao;
import ap;
import av;
import ay;
import az;
import bb;
import cl;
import di;
import e;
import i;
import j;

@ae(a=FloatingActionButton.Behavior.class)
public class FloatingActionButton
  extends di
{
  public int a;
  public boolean b;
  public final Rect c = new Rect();
  private ColorStateList e;
  private PorterDuff.Mode f;
  private int g;
  private int h;
  private int i;
  private agq j;
  private ay k;
  
  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    cl.a(paramContext);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, j.R, paramInt, i.c);
    e = localTypedArray.getColorStateList(j.S);
    switch (localTypedArray.getInt(j.T, -1))
    {
    default: 
      paramContext = null;
    }
    for (;;)
    {
      f = paramContext;
      h = localTypedArray.getColor(j.Y, 0);
      i = localTypedArray.getInt(j.W, 0);
      g = localTypedArray.getDimensionPixelSize(j.U, 0);
      float f1 = localTypedArray.getDimension(j.V, 0.0F);
      float f2 = localTypedArray.getDimension(j.X, 0.0F);
      b = localTypedArray.getBoolean(j.Z, false);
      localTypedArray.recycle();
      j = new agq(this, agj.a());
      j.a(paramAttributeSet, paramInt);
      paramInt = (int)getResources().getDimension(e.a);
      a = ((a() - paramInt) / 2);
      b().a(e, f, h, g);
      paramContext = b();
      if (h != f1)
      {
        h = f1;
        paramContext.a(f1);
      }
      paramContext = b();
      if (i != f2)
      {
        i = f2;
        paramContext.b(f2);
      }
      b().d();
      return;
      paramContext = PorterDuff.Mode.SRC_OVER;
      continue;
      paramContext = PorterDuff.Mode.SRC_IN;
      continue;
      paramContext = PorterDuff.Mode.SRC_ATOP;
      continue;
      paramContext = PorterDuff.Mode.MULTIPLY;
      continue;
      paramContext = PorterDuff.Mode.SCREEN;
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (m)
    {
    case 0: 
    default: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  public final int a()
  {
    switch (i)
    {
    default: 
      return getResources().getDimensionPixelSize(e.c);
    }
    return getResources().getDimensionPixelSize(e.b);
  }
  
  final ay b()
  {
    int m;
    Object localObject;
    if (k == null)
    {
      m = Build.VERSION.SDK_INT;
      if (m < 21) {
        break label44;
      }
      localObject = new bb(this, new ao(this));
    }
    for (;;)
    {
      k = ((ay)localObject);
      return k;
      label44:
      if (m >= 14) {
        localObject = new av(this, new ao(this));
      } else {
        localObject = new ap(this, new ao(this));
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b().a(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return e;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return f;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    b().a();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ay localay = b();
    if (localay.b())
    {
      if (o == null) {
        o = new az(localay);
      }
      m.getViewTreeObserver().addOnPreDrawListener(o);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ay localay = b();
    if (o != null)
    {
      m.getViewTreeObserver().removeOnPreDrawListener(o);
      o = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = a();
    paramInt1 = Math.min(a(m, paramInt1), a(m, paramInt2));
    setMeasuredDimension(c.left + paramInt1 + c.right, paramInt1 + c.top + c.bottom);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (e != paramColorStateList)
    {
      e = paramColorStateList;
      b().a(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (f != paramMode)
    {
      f = paramMode;
      b().a(paramMode);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    j.a(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */