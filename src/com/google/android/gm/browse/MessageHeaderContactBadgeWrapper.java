package com.google.android.gm.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import dga;
import ghz;

public class MessageHeaderContactBadgeWrapper
  extends FrameLayout
{
  public MessageHeaderContactBadgeWrapper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageHeaderContactBadgeWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MessageHeaderContactBadgeWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (ghz.a(getContext().getContentResolver(), "gmail_use_smart_profile", true)) {}
    for (int i = dga.t;; i = dga.s)
    {
      inflate(getContext(), i, this);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.browse.MessageHeaderContactBadgeWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */