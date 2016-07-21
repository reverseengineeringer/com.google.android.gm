import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import java.lang.ref.WeakReference;

public final class v
  extends zb
{
  public v(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  public final int a()
  {
    if (a.c) {
      return a.f - a.a;
    }
    return a.b - a.a;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 1) {
      a.a(1);
    }
  }
  
  public final void a(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 3;
    int i;
    if (paramFloat2 < 0.0F) {
      i = a.a;
    }
    while (a.e.a(paramView.getLeft(), i))
    {
      a.a(2);
      rg.a(paramView, new x(a, paramView, j));
      return;
      if ((a.c) && (a.a(paramView, paramFloat2)))
      {
        i = a.f;
        j = 5;
      }
      else if (paramFloat2 == 0.0F)
      {
        i = paramView.getTop();
        if (Math.abs(i - a.a) < Math.abs(i - a.b))
        {
          i = a.a;
        }
        else
        {
          i = a.b;
          j = 4;
        }
      }
      else
      {
        i = a.b;
        j = 4;
      }
    }
    a.a(j);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2)
  {
    a.a();
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    if (a.d == 1) {
      return false;
    }
    if (a.j) {
      return false;
    }
    if ((a.d == 3) && (a.i == paramInt))
    {
      View localView = (View)a.h.get();
      if ((localView != null) && (rg.b(localView, -1))) {
        return false;
      }
    }
    return (a.g != null) && (a.g.get() == paramView);
  }
  
  public final int b(View paramView, int paramInt)
  {
    int j = a.a;
    if (a.c) {}
    for (int i = a.f;; i = a.b) {
      return bf.a(paramInt, j, i);
    }
  }
  
  public final int c(View paramView, int paramInt)
  {
    return paramView.getLeft();
  }
}

/* Location:
 * Qualified Name:     v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */