package android.support.design.widget;

import ae;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;
import rg;
import tz;
import u;

@ae(a=AppBarLayout.Behavior.class)
public final class AppBarLayout
  extends LinearLayout
{
  int a;
  int b;
  boolean c;
  int d;
  final List<Object> e;
  private int f;
  private tz g;
  
  private final u a(AttributeSet paramAttributeSet)
  {
    return new u(getContext(), paramAttributeSet);
  }
  
  private static u a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {
      return new u((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new u((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new u(paramLayoutParams);
  }
  
  private final void c()
  {
    f = -1;
    a = -1;
    b = -1;
  }
  
  public final int a()
  {
    if (f != -1) {
      return f;
    }
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      View localView = getChildAt(j);
      u localu = (u)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      int m = a;
      if ((m & 0x1) != 0)
      {
        int i1 = topMargin;
        i += bottomMargin + (n + i1);
        if ((m & 0x2) != 0) {
          i -= rg.p(localView);
        }
      }
    }
    for (;;)
    {
      i = Math.max(0, i - b());
      f = i;
      return i;
      j += 1;
      break;
    }
  }
  
  final int b()
  {
    if (g != null) {
      return g.b();
    }
    return 0;
  }
  
  protected final boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof u;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    c();
    c = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        if (getChildAtgetLayoutParamsb != null) {
          c = true;
        }
      }
      else {
        return;
      }
      paramInt1 += 1;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    c();
  }
  
  public final void setOrientation(int paramInt)
  {
    if (paramInt != 1) {
      throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }
    super.setOrientation(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */