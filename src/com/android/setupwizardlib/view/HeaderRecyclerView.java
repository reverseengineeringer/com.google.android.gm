package com.android.setupwizardlib.view;

import akw;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import cxy;

public class HeaderRecyclerView
  extends RecyclerView
{
  View G;
  private int H;
  
  public HeaderRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public HeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public HeaderRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  private final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, cxy.ap, paramInt, 0);
    H = paramAttributeSet.getResourceId(cxy.aq, 0);
    paramAttributeSet.recycle();
  }
  
  public final void a(akw paramakw)
  {
    super.a(paramakw);
    if ((paramakw != null) && (G == null) && (H != 0)) {
      G = LayoutInflater.from(getContext()).inflate(H, this, false);
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (G != null) {}
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
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.HeaderRecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */