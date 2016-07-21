import android.support.v4.widget.DrawerLayout;
import android.view.View;
import java.util.List;

public final class wp
  extends zb
{
  final int a;
  public yy b;
  private final Runnable d = new wq(this);
  
  public wp(DrawerLayout paramDrawerLayout, int paramInt)
  {
    a = paramInt;
  }
  
  public final int a(View paramView)
  {
    if (DrawerLayout.d(paramView)) {
      return paramView.getWidth();
    }
    return 0;
  }
  
  public final void a(int paramInt)
  {
    DrawerLayout localDrawerLayout = c;
    View localView = b.j;
    int i = d.a;
    int j = e.a;
    if ((i == 1) || (j == 1)) {
      i = 1;
    }
    wn localwn;
    while ((localView != null) && (paramInt == 0))
    {
      localwn = (wn)localView.getLayoutParams();
      if (b != 0.0F) {
        break label276;
      }
      localwn = (wn)localView.getLayoutParams();
      if ((d & 0x1) == 1)
      {
        d = 0;
        if (i != null)
        {
          paramInt = i.size() - 1;
          for (;;)
          {
            if (paramInt >= 0)
            {
              ((wm)i.get(paramInt)).b(localView);
              paramInt -= 1;
              continue;
              if ((i == 2) || (j == 2))
              {
                i = 2;
                break;
              }
              i = 0;
              break;
            }
          }
        }
        localDrawerLayout.a(localView, false);
        if (localDrawerLayout.hasWindowFocus())
        {
          localView = localDrawerLayout.getRootView();
          if (localView != null) {
            localView.sendAccessibilityEvent(32);
          }
        }
      }
    }
    while (i != f)
    {
      f = i;
      if (i == null) {
        break;
      }
      paramInt = i.size() - 1;
      while (paramInt >= 0)
      {
        ((wm)i.get(paramInt)).a(i);
        paramInt -= 1;
      }
      label276:
      if (b == 1.0F)
      {
        localwn = (wn)localView.getLayoutParams();
        if ((d & 0x1) == 0)
        {
          d = 1;
          if (i != null)
          {
            paramInt = i.size() - 1;
            while (paramInt >= 0)
            {
              ((wm)i.get(paramInt)).a(localView);
              paramInt -= 1;
            }
          }
          localDrawerLayout.a(localView, true);
          if (localDrawerLayout.hasWindowFocus()) {
            localDrawerLayout.sendAccessibilityEvent(32);
          }
          localView.requestFocus();
        }
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 & 0x1) == 1) {}
    for (View localView = c.c(3);; localView = c.c(5))
    {
      if ((localView != null) && (c.a(localView) == 0)) {
        b.a(localView, paramInt2);
      }
      return;
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramFloat2 = DrawerLayout.b(paramView);
    int k = paramView.getWidth();
    int i;
    if (c.a(paramView, 3)) {
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
        i = 0;
      }
    }
    for (;;)
    {
      b.a(i, paramView.getTop());
      c.invalidate();
      return;
      i = -k;
      continue;
      int j = c.getWidth();
      if (paramFloat1 >= 0.0F)
      {
        i = j;
        if (paramFloat1 == 0.0F)
        {
          i = j;
          if (paramFloat2 <= 0.5F) {}
        }
      }
      else
      {
        i = j - k;
      }
    }
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    paramInt2 = paramView.getWidth();
    float f;
    if (c.a(paramView, 3))
    {
      f = (paramInt2 + paramInt1) / paramInt2;
      c.a(paramView, f);
      if (f != 0.0F) {
        break label76;
      }
    }
    label76:
    for (paramInt1 = 4;; paramInt1 = 0)
    {
      paramView.setVisibility(paramInt1);
      c.invalidate();
      return;
      f = (c.getWidth() - paramInt1) / paramInt2;
      break;
    }
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return (DrawerLayout.d(paramView)) && (c.a(paramView, a)) && (c.a(paramView) == 0);
  }
  
  public final int b(View paramView, int paramInt)
  {
    return paramView.getTop();
  }
  
  public final void b()
  {
    c.removeCallbacks(d);
  }
  
  public final int c(View paramView, int paramInt)
  {
    if (c.a(paramView, 3)) {
      return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
    }
    int i = c.getWidth();
    return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
  }
  
  final void c()
  {
    int i = 3;
    if (a == 3) {
      i = 5;
    }
    View localView = c.c(i);
    if (localView != null) {
      c.f(localView);
    }
  }
  
  public final void d()
  {
    c.postDelayed(d, 160L);
  }
  
  public final void d(View paramView, int paramInt)
  {
    getLayoutParamsc = false;
    c();
  }
}

/* Location:
 * Qualified Name:     wp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */