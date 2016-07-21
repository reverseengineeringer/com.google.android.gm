package com.android.setupwizardlib.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;

public class StickyHeaderRecyclerView
  extends HeaderRecyclerView
{
  private View H;
  private int I = 0;
  private RectF J = new RectF();
  
  public StickyHeaderRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StickyHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StickyHeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (J.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      paramMotionEvent.offsetLocation(-J.left, -J.top);
      return G.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j;
    View localView1;
    int i;
    if (H != null)
    {
      View localView2 = G;
      j = paramCanvas.save();
      if (localView2 == null) {
        break label143;
      }
      localView1 = localView2;
      if (localView2 == null) {
        break label152;
      }
      i = H.getTop();
      label45:
      if ((localView1.getTop() + i >= I) && (localView1.isShown())) {
        break label157;
      }
      J.set(0.0F, -i + I, localView1.getWidth(), localView1.getHeight() - i + I);
      paramCanvas.translate(0.0F, J.top);
      paramCanvas.clipRect(0, 0, localView1.getWidth(), localView1.getHeight());
      localView1.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label143:
      localView1 = H;
      break;
      label152:
      i = 0;
      break label45;
      label157:
      J.setEmpty();
    }
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    if (getFitsSystemWindows())
    {
      I = paramWindowInsets.getSystemWindowInsetTop();
      paramWindowInsets.replaceSystemWindowInsets(paramWindowInsets.getSystemWindowInsetLeft(), 0, paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    }
    return paramWindowInsets;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView;
    if (H == null)
    {
      localView = G;
      if (localView != null) {
        H = localView.findViewWithTag("sticky");
      }
    }
    if (H != null)
    {
      localView = G;
      if ((localView != null) && (localView.getHeight() == 0)) {
        localView.layout(0, -localView.getMeasuredHeight(), localView.getMeasuredWidth(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (H != null) {
      measureChild(G, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.StickyHeaderRecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */