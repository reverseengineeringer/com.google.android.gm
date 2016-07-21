import android.support.design.widget.SwipeDismissBehavior;
import android.view.View;
import android.view.ViewParent;

public final class cc
  extends zb
{
  private int b;
  private int c = -1;
  
  public cc(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  public final int a(View paramView)
  {
    return paramView.getWidth();
  }
  
  public final void a(int paramInt)
  {
    if (a.c != null) {
      a.c.a(paramInt);
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    c = -1;
    int j = paramView.getWidth();
    int i;
    if (paramFloat1 != 0.0F) {
      if (rg.g(paramView) == 1)
      {
        i = 1;
        if (a.d != 2) {
          break label114;
        }
        i = 1;
        label45:
        if (i == 0) {
          break label290;
        }
        if (paramView.getLeft() >= b) {
          break label278;
        }
        i = b - j;
        label70:
        if (!a.b.a(i, paramView.getTop())) {
          break label302;
        }
        rg.a(paramView, new ce(a, paramView, bool));
      }
    }
    label114:
    label278:
    label290:
    label302:
    while ((!bool) || (a.c == null))
    {
      return;
      i = 0;
      break;
      if (a.d == 0)
      {
        if (i != 0)
        {
          if (paramFloat1 < 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 > 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      if (a.d == 1)
      {
        if (i != 0)
        {
          if (paramFloat1 > 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (paramFloat1 < 0.0F)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
        i = paramView.getLeft();
        int k = b;
        int m = Math.round(paramView.getWidth() * a.e);
        if (Math.abs(i - k) >= m)
        {
          i = 1;
          break label45;
        }
        i = 0;
        break label45;
      }
      i = 0;
      break label45;
      i = b + j;
      break label70;
      i = b;
      bool = false;
      break label70;
    }
    a.c.a(paramView);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    float f1 = b + paramView.getWidth() * a.f;
    float f2 = b + paramView.getWidth() * a.g;
    if (paramInt1 <= f1)
    {
      rg.c(paramView, 1.0F);
      return;
    }
    if (paramInt1 >= f2)
    {
      rg.c(paramView, 0.0F);
      return;
    }
    rg.c(paramView, SwipeDismissBehavior.a(0.0F, 1.0F - (paramInt1 - f1) / (f2 - f1), 1.0F));
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return (c == -1) && (a.b(paramView));
  }
  
  public final int b(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
  
  public final int c(View paramView, int paramInt)
  {
    int i;
    int j;
    if (rg.g(paramView) == 1)
    {
      i = 1;
      if (a.d != 0) {
        break label75;
      }
      if (i == 0) {
        break label56;
      }
      j = b - paramView.getWidth();
      i = b;
    }
    for (;;)
    {
      return Math.min(Math.max(j, paramInt), i);
      i = 0;
      break;
      label56:
      j = b;
      i = b + paramView.getWidth();
      continue;
      label75:
      if (a.d == 1)
      {
        if (i != 0)
        {
          j = b;
          i = b + paramView.getWidth();
        }
        else
        {
          j = b - paramView.getWidth();
          i = b;
        }
      }
      else
      {
        j = b - paramView.getWidth();
        i = b + paramView.getWidth();
      }
    }
  }
  
  public final void d(View paramView, int paramInt)
  {
    c = paramInt;
    b = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
}

/* Location:
 * Qualified Name:     cc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */