package com.android.setupwizardlib.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import cyq;
import cyr;

public class BottomScrollView
  extends ScrollView
{
  public cyr a;
  private int b;
  private boolean c = false;
  private final Runnable d = new cyq(this);
  
  public BottomScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BottomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BottomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a()
  {
    if (a != null)
    {
      if (getScrollY() < b) {
        break label28;
      }
      a.c();
    }
    label28:
    while (c) {
      return;
    }
    c = true;
    a.d();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = getChildAt(0);
    if (localView != null) {
      b = Math.max(0, localView.getMeasuredHeight() - paramInt4 + paramInt2 - getPaddingBottom());
    }
    if (paramInt4 - paramInt2 > 0) {
      post(d);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt4 != paramInt2) {
      a();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.setupwizardlib.view.BottomScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */