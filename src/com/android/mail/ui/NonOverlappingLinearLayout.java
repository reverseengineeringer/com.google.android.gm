package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class NonOverlappingLinearLayout
  extends LinearLayout
{
  public NonOverlappingLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NonOverlappingLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NonOverlappingLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.NonOverlappingLinearLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */