package com.android.mail.browse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import bzj;
import cvm;

public class MessageScrollView
  extends ScrollView
  implements GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener
{
  public bzj a;
  private boolean b;
  private boolean c;
  private final ScaleGestureDetector d;
  private boolean e;
  private final GestureDetector f;
  private boolean g;
  private boolean h;
  private final int i;
  private float j;
  private float k;
  
  public MessageScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MessageScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int m = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    i = (m * m);
    d = new ScaleGestureDetector(paramContext, this);
    f = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener());
    f.setOnDoubleTapListener(this);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      if (a != null) {
        a.b();
      }
      d.onTouchEvent(paramMotionEvent);
      f.onTouchEvent(paramMotionEvent);
      bool = super.dispatchTouchEvent(paramMotionEvent);
      cvm.b("MsgScroller", "OUT ScrollView.dispatchTouch, handled=%s ev=%s", new Object[] { Boolean.valueOf(bool), paramMotionEvent });
      if ((b) && (!e)) {
        if ((a == null) || (!a.a())) {
          break label175;
        }
      }
      break;
    }
    label175:
    for (int m = 1;; m = 0)
    {
      if (m == 0) {
        break label180;
      }
      cvm.b("MsgScroller", "IN extra ScrollView.onTouch, ev=%s", new Object[] { paramMotionEvent });
      onTouchEvent(paramMotionEvent);
      return bool;
      cvm.b("MsgScroller", "IN ScrollView.dispatchTouch, clearing flags", new Object[0]);
      b = false;
      c = false;
      break;
    }
    label180:
    c = true;
    b = false;
    return bool;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    g = true;
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      j = paramMotionEvent.getX();
      k = paramMotionEvent.getY();
      return false;
    case 1: 
      if (g) {
        if (h)
        {
          a.zoomOut();
          label76:
          if (h) {
            break label130;
          }
          bool1 = true;
          label86:
          h = bool1;
          cvm.b(cvm.a, "Trigger Zoom!", new Object[0]);
        }
      }
      break;
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      g = false;
      return bool1;
      a.zoomIn();
      break label76;
      label130:
      bool1 = false;
      break label86;
      int m = (int)(paramMotionEvent.getX() - j);
      int n = (int)(paramMotionEvent.getY() - k);
      if (m * m + n * n <= i) {
        break;
      }
      g = false;
      return false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (c)
    {
      cvm.b("MsgScroller", "IN ScrollView.onIntercept, NOW stealing. ev=%s", new Object[] { paramMotionEvent });
      return true;
    }
    if (b)
    {
      cvm.b("MsgScroller", "IN ScrollView.onIntercept, already stealing. ev=%s", new Object[] { paramMotionEvent });
      return false;
    }
    b = super.onInterceptTouchEvent(paramMotionEvent);
    cvm.b("MsgScroller", "OUT ScrollView.onIntercept, steal=%s ev=%s", new Object[] { Boolean.valueOf(b), paramMotionEvent });
    return false;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    cvm.b("MsgScroller", "Begin scale gesture", new Object[0]);
    e = true;
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    cvm.b("MsgScroller", "End scale gesture", new Object[0]);
    e = false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.MessageScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */