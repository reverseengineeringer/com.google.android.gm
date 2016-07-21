package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ListView;
import cxy;

public class StickyHeaderListView
  extends ListView
{
  private View a;
  private View b;
  private int c = 0;
  private RectF d = new RectF();
  
  public StickyHeaderListView(Context paramContext)
  {
    super(paramContext);
    a(null, 16842868);
  }
  
  public StickyHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 16842868);
  }
  
  public StickyHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, cxy.aJ, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(cxy.aK, 0);
    if (paramInt != 0) {
      addHeaderView(LayoutInflater.from(getContext()).inflate(paramInt, this, false), null, false);
    }
    paramAttributeSet.recycle();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (d.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      paramMotionEvent.offsetLocation(-d.left, -d.top);
      return b.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j;
    View localView;
    int i;
    if (a != null)
    {
      j = paramCanvas.save();
      if (b == null) {
        break label143;
      }
      localView = b;
      if (b == null) {
        break label152;
      }
      i = a.getTop();
      label45:
      if ((localView.getTop() + i >= c) && (localView.isShown())) {
        break label157;
      }
      d.set(0.0F, -i + c, localView.getWidth(), localView.getHeight() - i + c);
      paramCanvas.translate(0.0F, d.top);
      paramCanvas.clipRect(0, 0, localView.getWidth(), localView.getHeight());
      localView.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restoreToCount(j);
      return;
      label143:
      localView = a;
      break;
      label152:
      i = 0;
      break label45;
      label157:
      d.setEmpty();
    }
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    if (getFitsSystemWindows())
    {
      c = paramWindowInsets.getSystemWindowInsetTop();
      paramWindowInsets.replaceSystemWindowInsets(paramWindowInsets.getSystemWindowInsetLeft(), 0, paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    }
    return paramWindowInsets;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (a != null) {}
    for (int i = 1;; i = 0)
    {
      paramAccessibilityEvent.setItemCount(paramAccessibilityEvent.getItemCount() - i);
      paramAccessibilityEvent.setFromIndex(Math.max(paramAccessibilityEvent.getFromIndex() - i, 0));
      if (Build.VERSION.SDK_INT >= 14) {
        paramAccessibilityEvent.setToIndex(Math.max(paramAccessibilityEvent.getToIndex() - i, 0));
      }
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (a == null)
    {
      a = findViewWithTag("sticky");
      b = findViewWithTag("stickyContainer");
    }
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.StickyHeaderListView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */