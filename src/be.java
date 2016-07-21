import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.util.List;

public abstract class be
  extends db<View>
{
  public int a = 0;
  public int b;
  private final Rect c = new Rect();
  private final Rect d = new Rect();
  
  public be() {}
  
  public be(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract View a(List<View> paramList);
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getLayoutParamsheight;
    if ((j == -1) || (j == -2))
    {
      View localView = a(paramCoordinatorLayout.a(paramView));
      if (localView != null)
      {
        if ((rg.t(localView)) && (!rg.t(paramView)))
        {
          rg.u(paramView);
          if (rg.t(paramView))
          {
            paramView.requestLayout();
            return true;
          }
        }
        if (rg.w(localView))
        {
          int i = View.MeasureSpec.getSize(paramInt3);
          paramInt3 = i;
          if (i == 0) {
            paramInt3 = paramCoordinatorLayout.getHeight();
          }
          int k = localView.getMeasuredHeight();
          int m = c(localView);
          if (j == -1) {}
          for (i = 1073741824;; i = Integer.MIN_VALUE)
          {
            paramCoordinatorLayout.a(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(m + (paramInt3 - k), i), paramInt4);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public float b(View paramView)
  {
    return 1.0F;
  }
  
  public int c(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected final void c(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    View localView = a(paramCoordinatorLayout.a(paramView));
    if (localView != null)
    {
      ag localag = (ag)paramView.getLayoutParams();
      Rect localRect = c;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + leftMargin, localView.getBottom() + topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - bottomMargin);
      paramCoordinatorLayout = d;
      int j = c;
      int i = j;
      if (j == 0) {
        i = 8388659;
      }
      pg.apply(i, paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = d(localView);
      paramView.layout(left, top - paramInt, right, bottom - paramInt);
      a = (top - localView.getBottom());
      return;
    }
    super.c(paramCoordinatorLayout, paramView, paramInt);
    a = 0;
  }
  
  public final int d(View paramView)
  {
    if (b == 0) {
      return 0;
    }
    return bf.a(Math.round(b(paramView) * b), 0, b);
  }
}

/* Location:
 * Qualified Name:     be
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */