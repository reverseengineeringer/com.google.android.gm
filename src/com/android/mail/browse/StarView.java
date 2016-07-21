package com.android.mail.browse;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import btx;
import buj;

public class StarView
  extends ImageView
{
  private static final int[] b = { btx.b };
  boolean a;
  private boolean c;
  
  public StarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    c = paramBoolean;
    int i;
    if (a) {
      if (c) {
        i = buj.ec;
      }
    }
    for (;;)
    {
      setContentDescription(getResources().getString(i));
      refreshDrawableState();
      return;
      i = buj.g;
      continue;
      if (c) {
        i = buj.ee;
      } else {
        i = buj.i;
      }
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (c) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.StarView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */