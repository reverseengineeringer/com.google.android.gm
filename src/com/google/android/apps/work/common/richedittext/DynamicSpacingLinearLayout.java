package com.google.android.apps.work.common.richedittext;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import dck;

public class DynamicSpacingLinearLayout
  extends LinearLayout
{
  private int a;
  
  public DynamicSpacingLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DynamicSpacingLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0, 0);
  }
  
  public DynamicSpacingLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public DynamicSpacingLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private final void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, dck.C, paramInt1, paramInt2);
    try
    {
      a = paramContext.getDimensionPixelSize(dck.D, 0);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static void a(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams;
    if (!(paramView instanceof ViewGroup))
    {
      localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      if ((Build.VERSION.SDK_INT >= 17) && (1 == localLayoutParams.getLayoutDirection()))
      {
        localLayoutParams.setMargins(paramInt, topMargin, rightMargin, bottomMargin);
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      return;
      localLayoutParams.setMargins(leftMargin, topMargin, paramInt, bottomMargin);
      break;
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i), paramInt);
        i += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (!(localViewGroup instanceof HorizontalScrollView))
    {
      Log.e("DynamicSpacingLayout", "DynamicSpacingLinearLayout must be a child of a HorizontalScrollView");
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = localViewGroup.getMeasuredWidth();
    double d2;
    double d1;
    if ((i > a) && (a > 0))
    {
      d2 = i / a;
      if (d2 > 1.6D)
      {
        d1 = Math.floor(d2);
        d2 -= d1;
        i = 0;
        if (d2 <= 0.6D) {
          break label137;
        }
        i = (int)Math.round((d2 - 0.5D) * a / d1);
      }
    }
    for (;;)
    {
      if (i > 0) {
        a(this, i);
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
      label137:
      if (d2 < 0.4D) {
        i = (int)Math.round((0.5D + d2) * a / (d1 - 1.0D));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.apps.work.common.richedittext.DynamicSpacingLinearLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */