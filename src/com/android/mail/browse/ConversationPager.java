package com.android.mail.browse;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class ConversationPager
  extends ViewPager
{
  public boolean i;
  
  public ConversationPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void requestLayout()
  {
    if (!i) {
      super.requestLayout();
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */