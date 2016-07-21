package com.google.android.gm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableAddressListItem
  extends LinearLayout
  implements Checkable
{
  private static final int[] a = { 16842912 };
  private boolean b;
  
  public CheckableAddressListItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public CheckableAddressListItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CheckableAddressListItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean isChecked()
  {
    return b;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (b) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public void toggle()
  {
    if (!b) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.ui.CheckableAddressListItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */