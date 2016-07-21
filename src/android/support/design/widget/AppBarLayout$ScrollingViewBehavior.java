package android.support.design.widget;

import ag;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import be;
import j;
import java.util.List;
import rg;
import u;

public class AppBarLayout$ScrollingViewBehavior
  extends be
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.az);
    b = paramContext.getDimensionPixelSize(j.aA, 0);
    paramContext.recycle();
  }
  
  final View a(List<View> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if ((localView instanceof AppBarLayout)) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  public final boolean a_(View paramView)
  {
    return paramView instanceof AppBarLayout;
  }
  
  final float b(View paramView)
  {
    if ((paramView instanceof AppBarLayout))
    {
      paramView = (AppBarLayout)paramView;
      int k = paramView.a();
      if (a != -1)
      {
        i = a;
        paramView = getLayoutParamsa;
        if (!(paramView instanceof AppBarLayout.Behavior)) {
          break label219;
        }
      }
      label219:
      for (int j = ((AppBarLayout.Behavior)paramView).a();; j = 0)
      {
        if ((i == 0) || (k + j > i)) {
          break label224;
        }
        return 0.0F;
        j = paramView.getChildCount() - 1;
        i = 0;
        if (j >= 0)
        {
          View localView = paramView.getChildAt(j);
          u localu = (u)localView.getLayoutParams();
          int m = localView.getMeasuredHeight();
          int n = a;
          if ((n & 0x5) == 5)
          {
            i1 = topMargin;
            i = bottomMargin + i1 + i;
            if ((n & 0x8) != 0) {
              i += rg.p(localView);
            }
          }
          while (i <= 0) {
            for (;;)
            {
              int i1;
              j -= 1;
              break;
              if ((n & 0x2) != 0) {
                i += m - rg.p(localView);
              } else {
                i += m;
              }
            }
          }
        }
        i = Math.max(0, i - paramView.b());
        a = i;
        break;
      }
      label224:
      int i = k - i;
      if (i != 0) {
        return j / i + 1.0F;
      }
    }
    return 0.0F;
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    paramCoordinatorLayout = getLayoutParamsa;
    if ((paramCoordinatorLayout instanceof AppBarLayout.Behavior))
    {
      paramCoordinatorLayout = (AppBarLayout.Behavior)paramCoordinatorLayout;
      int i = paramView2.getBottom();
      int j = paramView1.getTop();
      rg.e(paramView1, a + (i - j) + a - d(paramView2));
    }
    return false;
  }
  
  final int c(View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      return ((AppBarLayout)paramView).a();
    }
    return super.c(paramView);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.ScrollingViewBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */