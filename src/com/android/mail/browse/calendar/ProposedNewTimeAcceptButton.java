package com.android.mail.browse.calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import btx;
import buj;

public class ProposedNewTimeAcceptButton
  extends Button
{
  private static final int[] a = { btx.a };
  private boolean b = false;
  
  public ProposedNewTimeAcceptButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProposedNewTimeAcceptButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProposedNewTimeAcceptButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ProposedNewTimeAcceptButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
    if (b) {}
    for (int i = buj.dH;; i = buj.dG)
    {
      setText(i);
      refreshDrawableState();
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (b) {
      mergeDrawableStates(arrayOfInt, a);
    }
    return arrayOfInt;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.calendar.ProposedNewTimeAcceptButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */