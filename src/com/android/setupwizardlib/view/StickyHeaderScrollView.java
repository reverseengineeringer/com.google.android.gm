package com.android.setupwizardlib.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;

public class StickyHeaderScrollView
  extends BottomScrollView
{
  private View b;
  private View c;
  private int d = 0;
  
  public StickyHeaderScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StickyHeaderScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StickyHeaderScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private final void b()
  {
    View localView;
    if ((Build.VERSION.SDK_INT >= 11) && (b != null))
    {
      if (c == null) {
        break label79;
      }
      localView = c;
      if (c == null) {
        break label87;
      }
    }
    label79:
    label87:
    for (int i = b.getTop();; i = 0)
    {
      if ((localView.getTop() - getScrollY() + i >= d) && (localView.isShown())) {
        break label92;
      }
      localView.setTranslationY(getScrollY() - i);
      return;
      localView = b;
      break;
    }
    label92:
    localView.setTranslationY(0.0F);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    WindowInsets localWindowInsets = paramWindowInsets;
    if (getFitsSystemWindows())
    {
      d = paramWindowInsets.getSystemWindowInsetTop();
      localWindowInsets = paramWindowInsets.replaceSystemWindowInsets(paramWindowInsets.getSystemWindowInsetLeft(), 0, paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    }
    return localWindowInsets;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (b == null)
    {
      b = findViewWithTag("sticky");
      c = findViewWithTag("stickyContainer");
    }
    b();
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.StickyHeaderScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */