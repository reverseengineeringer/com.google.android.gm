package com.android.mail.ui;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import cmm;

public class ConversationViewFrame
  extends FrameLayout
{
  public cmm a;
  private final ViewConfiguration b;
  private long c;
  private float d;
  private float e;
  
  public ConversationViewFrame(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationViewFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b = ViewConfiguration.get(paramContext);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((a != null) && (a.y_())) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (paramMotionEvent.getActionMasked() == 0) && (a != null)) {
        a.c();
      }
      return bool;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a != null)
    {
      switch (paramMotionEvent.getActionMasked())
      {
      }
      for (;;)
      {
        return true;
        c = SystemClock.elapsedRealtime();
        d = paramMotionEvent.getX();
        e = paramMotionEvent.getY();
        continue;
        long l1 = SystemClock.elapsedRealtime();
        long l2 = c;
        float f1 = paramMotionEvent.getX();
        float f2 = d;
        float f3 = paramMotionEvent.getY();
        float f4 = e;
        if ((l1 - l2 < ViewConfiguration.getTapTimeout()) && (f1 - f2 < b.getScaledTouchSlop()) && (f3 - f4 < b.getScaledTouchSlop())) {
          a.b();
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.ConversationViewFrame
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */