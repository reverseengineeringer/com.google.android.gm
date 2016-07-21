import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.util.WeakHashMap;

class rh
  implements rt
{
  WeakHashMap<View, tg> a = null;
  
  public void A(View paramView) {}
  
  public boolean B(View paramView)
  {
    return false;
  }
  
  public boolean C(View paramView)
  {
    if ((paramView instanceof qq)) {
      return ((qq)paramView).isNestedScrollingEnabled();
    }
    return false;
  }
  
  public ColorStateList D(View paramView)
  {
    if ((paramView instanceof rb)) {
      return ((rb)paramView).c();
    }
    return null;
  }
  
  public PorterDuff.Mode E(View paramView)
  {
    if ((paramView instanceof rb)) {
      return ((rb)paramView).d();
    }
    return null;
  }
  
  public void F(View paramView)
  {
    if ((paramView instanceof qq)) {
      ((qq)paramView).stopNestedScroll();
    }
  }
  
  public boolean G(View paramView)
  {
    return (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
  
  public float H(View paramView)
  {
    return y(paramView) + x(paramView);
  }
  
  public boolean I(View paramView)
  {
    return paramView.getWindowToken() != null;
  }
  
  public boolean J(View paramView)
  {
    return false;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSize(paramInt1, paramInt2);
  }
  
  public int a(View paramView)
  {
    return 2;
  }
  
  long a()
  {
    return 10L;
  }
  
  public tz a(View paramView, tz paramtz)
  {
    return paramtz;
  }
  
  public void a(View paramView, float paramFloat) {}
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(View paramView, int paramInt, Paint paramPaint) {}
  
  public void a(View paramView, ColorStateList paramColorStateList)
  {
    if ((paramView instanceof rb)) {
      ((rb)paramView).a(paramColorStateList);
    }
  }
  
  public void a(View paramView, Paint paramPaint) {}
  
  public void a(View paramView, PorterDuff.Mode paramMode)
  {
    if ((paramView instanceof rb)) {
      ((rb)paramView).a(paramMode);
    }
  }
  
  public void a(View paramView, AccessibilityEvent paramAccessibilityEvent) {}
  
  public void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, a());
  }
  
  public void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    paramView.postDelayed(paramRunnable, a() + paramLong);
  }
  
  public void a(View paramView, ol paramol) {}
  
  public void a(View paramView, qu paramqu) {}
  
  public void a(View paramView, uk paramuk) {}
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public boolean a(View paramView, int paramInt)
  {
    if ((paramView instanceof ra))
    {
      paramView = (ra)paramView;
      int i = paramView.computeHorizontalScrollOffset();
      int j = paramView.computeHorizontalScrollRange() - paramView.computeHorizontalScrollExtent();
      if (j != 0) {
        if (paramInt < 0) {
          if (i > 0) {
            paramInt = 1;
          }
        }
      }
      while (paramInt != 0)
      {
        return true;
        paramInt = 0;
        continue;
        if (i < j - 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    return false;
  }
  
  public boolean a(View paramView, int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  public tz b(View paramView, tz paramtz)
  {
    return paramtz;
  }
  
  public void b(View paramView, float paramFloat) {}
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void b(View paramView, boolean paramBoolean) {}
  
  public boolean b(View paramView)
  {
    return false;
  }
  
  public boolean b(View paramView, int paramInt)
  {
    if ((paramView instanceof ra))
    {
      paramView = (ra)paramView;
      int i = paramView.computeVerticalScrollOffset();
      int j = paramView.computeVerticalScrollRange() - paramView.computeVerticalScrollExtent();
      if (j != 0) {
        if (paramInt < 0) {
          if (i > 0) {
            paramInt = 1;
          }
        }
      }
      while (paramInt != 0)
      {
        return true;
        paramInt = 0;
        continue;
        if (i < j - 1) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
      }
    }
    return false;
  }
  
  public void c(View paramView, float paramFloat) {}
  
  public void c(View paramView, int paramInt) {}
  
  public void c(View paramView, boolean paramBoolean) {}
  
  public boolean c(View paramView)
  {
    return false;
  }
  
  public void d(View paramView)
  {
    paramView.invalidate();
  }
  
  public void d(View paramView, float paramFloat) {}
  
  public void d(View paramView, int paramInt) {}
  
  public int e(View paramView)
  {
    return 0;
  }
  
  public void e(View paramView, float paramFloat) {}
  
  public void e(View paramView, int paramInt) {}
  
  public float f(View paramView)
  {
    return 1.0F;
  }
  
  public void f(View paramView, float paramFloat) {}
  
  public void f(View paramView, int paramInt)
  {
    int i = paramView.getLeft();
    paramView.offsetLeftAndRight(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(i - paramInt, paramView.getTop(), i + paramView.getWidth() + paramInt, paramView.getBottom());
      }
    }
    else
    {
      return;
    }
    paramView.invalidate();
  }
  
  public int g(View paramView)
  {
    return 0;
  }
  
  public void g(View paramView, int paramInt)
  {
    int i = paramView.getTop();
    paramView.offsetTopAndBottom(paramInt);
    if (paramInt != 0)
    {
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent instanceof View))
      {
        paramInt = Math.abs(paramInt);
        ((View)localViewParent).invalidate(paramView.getLeft(), i - paramInt, paramView.getRight(), i + paramView.getHeight() + paramInt);
      }
    }
    else
    {
      return;
    }
    paramView.invalidate();
  }
  
  public int h(View paramView)
  {
    return 0;
  }
  
  public ViewParent i(View paramView)
  {
    return paramView.getParent();
  }
  
  public boolean j(View paramView)
  {
    boolean bool2 = false;
    paramView = paramView.getBackground();
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.getOpacity() == -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int k(View paramView)
  {
    return paramView.getMeasuredWidth();
  }
  
  public int l(View paramView)
  {
    return 0;
  }
  
  public int m(View paramView)
  {
    return paramView.getPaddingLeft();
  }
  
  public int n(View paramView)
  {
    return paramView.getPaddingRight();
  }
  
  public boolean o(View paramView)
  {
    return true;
  }
  
  public float p(View paramView)
  {
    return 0.0F;
  }
  
  public float q(View paramView)
  {
    return 0.0F;
  }
  
  public float r(View paramView)
  {
    return 0.0F;
  }
  
  public int s(View paramView)
  {
    return ru.a(paramView);
  }
  
  public int t(View paramView)
  {
    return ru.b(paramView);
  }
  
  public tg u(View paramView)
  {
    return new tg(paramView);
  }
  
  public int v(View paramView)
  {
    return 0;
  }
  
  public void w(View paramView) {}
  
  public float x(View paramView)
  {
    return 0.0F;
  }
  
  public float y(View paramView)
  {
    return 0.0F;
  }
  
  public boolean z(View paramView)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     rh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */