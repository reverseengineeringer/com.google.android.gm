package com.android.mail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import yg;

public class MailSwipeRefreshLayout
  extends yg
{
  public View m;
  
  public MailSwipeRefreshLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MailSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final boolean b()
  {
    return m.canScrollVertically(-1);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.MailSwipeRefreshLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */