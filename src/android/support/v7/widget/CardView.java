package android.support.v7.widget;

import acm;
import aco;
import acp;
import ahj;
import ahk;
import ahl;
import ahm;
import aho;
import ahp;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView
  extends FrameLayout
{
  private static final int[] g = { 16842801 };
  private static final aho h;
  public boolean a;
  public boolean b;
  public int c;
  public int d;
  public final Rect e = new Rect();
  public final Rect f = new Rect();
  private final ahl i = new ahj(this);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {
      h = new ahk();
    }
    for (;;)
    {
      h.a();
      return;
      if (Build.VERSION.SDK_INT >= 17) {
        h = new ahp();
      } else {
        h = new ahm();
      }
    }
  }
  
  public CardView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public CardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, acp.r, paramInt, aco.a);
    if (paramAttributeSet.hasValue(acp.u)) {
      paramInt = paramAttributeSet.getColor(acp.u, 0);
    }
    for (;;)
    {
      float f4 = paramAttributeSet.getDimension(acp.v, 0.0F);
      float f2 = paramAttributeSet.getDimension(acp.w, 0.0F);
      float f3 = paramAttributeSet.getDimension(acp.x, 0.0F);
      a = paramAttributeSet.getBoolean(acp.z, false);
      b = paramAttributeSet.getBoolean(acp.y, true);
      int j = paramAttributeSet.getDimensionPixelSize(acp.A, 0);
      e.left = paramAttributeSet.getDimensionPixelSize(acp.C, j);
      e.top = paramAttributeSet.getDimensionPixelSize(acp.E, j);
      e.right = paramAttributeSet.getDimensionPixelSize(acp.D, j);
      e.bottom = paramAttributeSet.getDimensionPixelSize(acp.B, j);
      float f1 = f3;
      if (f2 > f3) {
        f1 = f2;
      }
      c = paramAttributeSet.getDimensionPixelSize(acp.t, 0);
      d = paramAttributeSet.getDimensionPixelSize(acp.s, 0);
      paramAttributeSet.recycle();
      h.a(i, paramContext, paramInt, f4, f2, f1);
      return;
      Object localObject = getContext().obtainStyledAttributes(g);
      paramInt = ((TypedArray)localObject).getColor(0, 0);
      ((TypedArray)localObject).recycle();
      localObject = new float[3];
      Color.colorToHSV(paramInt, (float[])localObject);
      if (localObject[2] > 0.5F) {
        paramInt = getResources().getColor(acm.b);
      } else {
        paramInt = getResources().getColor(acm.a);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!(h instanceof ahk))
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      switch (j)
      {
      default: 
        j = View.MeasureSpec.getMode(paramInt2);
        switch (j)
        {
        }
        break;
      }
      for (;;)
      {
        super.onMeasure(paramInt1, paramInt2);
        return;
        paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(h.a(i)), View.MeasureSpec.getSize(paramInt1)), j);
        break;
        paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.max((int)Math.ceil(h.b(i)), View.MeasureSpec.getSize(paramInt2)), j);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setMinimumHeight(int paramInt)
  {
    d = paramInt;
    super.setMinimumHeight(paramInt);
  }
  
  public void setMinimumWidth(int paramInt)
  {
    c = paramInt;
    super.setMinimumWidth(paramInt);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void setPaddingRelative(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */