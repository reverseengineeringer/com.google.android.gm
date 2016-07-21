import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;

class rr
  extends rq
{
  public final boolean C(View paramView)
  {
    return paramView.isNestedScrollingEnabled();
  }
  
  public final ColorStateList D(View paramView)
  {
    return paramView.getBackgroundTintList();
  }
  
  public final PorterDuff.Mode E(View paramView)
  {
    return paramView.getBackgroundTintMode();
  }
  
  public final void F(View paramView)
  {
    paramView.stopNestedScroll();
  }
  
  public final float H(View paramView)
  {
    return paramView.getZ();
  }
  
  public final tz a(View paramView, tz paramtz)
  {
    Object localObject = paramtz;
    if ((paramtz instanceof ua))
    {
      WindowInsets localWindowInsets = a;
      paramView = paramView.onApplyWindowInsets(localWindowInsets);
      localObject = paramtz;
      if (paramView != localWindowInsets) {
        localObject = new ua(paramView);
      }
    }
    return (tz)localObject;
  }
  
  public final void a(View paramView, ColorStateList paramColorStateList)
  {
    paramView.setBackgroundTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramColorStateList = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramColorStateList != null) && (i != 0))
      {
        if (paramColorStateList.isStateful()) {
          paramColorStateList.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramColorStateList);
      }
      return;
    }
  }
  
  public final void a(View paramView, PorterDuff.Mode paramMode)
  {
    paramView.setBackgroundTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramMode = paramView.getBackground();
      if ((paramView.getBackgroundTintList() == null) || (paramView.getBackgroundTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramMode != null) && (i != 0))
      {
        if (paramMode.isStateful()) {
          paramMode.setState(paramView.getDrawableState());
        }
        paramView.setBackground(paramMode);
      }
      return;
    }
  }
  
  public final void a(View paramView, qu paramqu)
  {
    if (paramqu == null)
    {
      paramView.setOnApplyWindowInsetsListener(null);
      return;
    }
    paramView.setOnApplyWindowInsetsListener(new ry(paramqu));
  }
  
  public final tz b(View paramView, tz paramtz)
  {
    Object localObject = paramtz;
    if ((paramtz instanceof ua))
    {
      WindowInsets localWindowInsets = a;
      paramView = paramView.dispatchApplyWindowInsets(localWindowInsets);
      localObject = paramtz;
      if (paramView != localWindowInsets) {
        localObject = new ua(paramView);
      }
    }
    return (tz)localObject;
  }
  
  public final void f(View paramView, float paramFloat)
  {
    paramView.setElevation(paramFloat);
  }
  
  public void f(View paramView, int paramInt)
  {
    Rect localRect = rx.a();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      rw.b(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public void g(View paramView, int paramInt)
  {
    Rect localRect = rx.a();
    ViewParent localViewParent = paramView.getParent();
    int i;
    if ((localViewParent instanceof View))
    {
      View localView = (View)localViewParent;
      localRect.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
      if (!localRect.intersects(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom())) {
        i = 1;
      }
    }
    for (;;)
    {
      rw.a(paramView, paramInt);
      if ((i != 0) && (localRect.intersect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom()))) {
        ((View)localViewParent).invalidate(localRect);
      }
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final void w(View paramView)
  {
    paramView.requestApplyInsets();
  }
  
  public final float x(View paramView)
  {
    return paramView.getElevation();
  }
  
  public final float y(View paramView)
  {
    return paramView.getTranslationZ();
  }
}

/* Location:
 * Qualified Name:     rr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */