package com.android.mail.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class ScrollIndicatorsView
  extends View
  implements ScrollNotifier.ScrollListener
{
  private ScrollNotifier mSource;
  
  public ScrollIndicatorsView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollIndicatorsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return mSource.computeHorizontalScrollExtent();
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return mSource.computeHorizontalScrollOffset();
  }
  
  protected int computeHorizontalScrollRange()
  {
    return mSource.computeHorizontalScrollRange();
  }
  
  protected int computeVerticalScrollExtent()
  {
    return mSource.computeVerticalScrollExtent();
  }
  
  protected int computeVerticalScrollOffset()
  {
    return mSource.computeVerticalScrollOffset();
  }
  
  protected int computeVerticalScrollRange()
  {
    return mSource.computeVerticalScrollRange();
  }
  
  public void onNotifierScroll(int paramInt1, int paramInt2)
  {
    awakenScrollBars();
  }
  
  public void setSourceView(ScrollNotifier paramScrollNotifier)
  {
    mSource = paramScrollNotifier;
    mSource.addScrollListener(this);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ScrollIndicatorsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */