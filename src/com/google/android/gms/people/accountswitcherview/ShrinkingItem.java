package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ShrinkingItem
  extends FrameLayout
{
  public float a = 1.0F;
  
  public ShrinkingItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShrinkingItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = getMeasuredHeight();
    paramInt2 = i;
    if (a != 1.0F)
    {
      float f = a;
      paramInt2 = Math.round(i * f);
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.accountswitcherview.ShrinkingItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */