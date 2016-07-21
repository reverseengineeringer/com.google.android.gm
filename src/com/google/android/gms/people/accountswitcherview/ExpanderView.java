package com.google.android.gms.people.accountswitcherview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageButton;
import fsx;

public class ExpanderView
  extends ImageButton
{
  private static final int[] a = { 16842920 };
  private boolean b;
  private String c;
  private String d;
  
  public ExpanderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpanderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ExpanderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private final void a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    c = paramContext.getString(fsx.d);
    d = paramContext.getString(fsx.b);
  }
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
    if (b) {}
    for (String str = d;; str = c)
    {
      setContentDescription(str);
      refreshDrawableState();
      return;
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (b) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.accountswitcherview.ExpanderView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */