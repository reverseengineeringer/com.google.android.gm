package com.android.mail.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import bzo;
import bzp;

public class ScrollIndicatorsView
  extends View
  implements bzp
{
  public bzo a;
  
  public ScrollIndicatorsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollIndicatorsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(int paramInt)
  {
    awakenScrollBars();
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return a.computeHorizontalScrollExtent();
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return a.computeHorizontalScrollOffset();
  }
  
  protected int computeHorizontalScrollRange()
  {
    return a.computeHorizontalScrollRange();
  }
  
  protected int computeVerticalScrollExtent()
  {
    return a.computeVerticalScrollExtent();
  }
  
  protected int computeVerticalScrollOffset()
  {
    return a.computeVerticalScrollOffset();
  }
  
  protected int computeVerticalScrollRange()
  {
    return a.computeVerticalScrollRange();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ScrollIndicatorsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */