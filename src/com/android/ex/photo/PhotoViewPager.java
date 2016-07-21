package com.android.ex.photo;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import bmb;
import bmc;
import bmd;
import java.lang.reflect.Method;
import qk;

public class PhotoViewPager
  extends ViewPager
{
  public bmd i;
  private float j;
  private int k;
  private float l;
  private float m;
  
  public PhotoViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PhotoViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private final void c()
  {
    int i1 = 1;
    bmb localbmb = new bmb(this);
    int n;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (f == null) {
        break label110;
      }
      n = 1;
    }
    for (;;)
    {
      if (1 != n)
      {
        n = i1;
        label35:
        f = localbmb;
        if ((Build.VERSION.SDK_INT >= 7) && (g != null)) {}
      }
      try
      {
        g = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] { Boolean.TYPE });
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          for (;;)
          {
            g.invoke(this, new Object[] { Boolean.valueOf(true) });
            h = 2;
            if (n != 0) {
              b();
            }
            return;
            label110:
            n = 0;
            break;
            n = 0;
            break label35;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("ViewPager", "Error changing children drawing order", localException);
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 1;
    int i1;
    if (i != null)
    {
      i1 = i.a(l, m);
      if ((i1 != bmc.d) && (i1 != bmc.b)) {
        break label142;
      }
      n = 1;
      label47:
      if ((i1 != bmc.d) && (i1 != bmc.c)) {
        break label147;
      }
      i1 = 1;
      label66:
      int i3 = paramMotionEvent.getAction() & 0xFF;
      if ((i3 == 3) || (i3 == 1)) {
        k = -1;
      }
      switch (i3)
      {
      }
    }
    label142:
    label147:
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        i1 = bmc.a;
        break;
        n = 0;
        break label47;
        i1 = 0;
        break label66;
        if ((n != 0) || (i1 != 0))
        {
          i2 = k;
          if (i2 != -1)
          {
            float f = qk.c(paramMotionEvent, qk.a(paramMotionEvent, i2));
            if ((n != 0) && (i1 != 0))
            {
              j = f;
              return false;
            }
            if ((n != 0) && (f > j))
            {
              j = f;
              return false;
            }
            if ((i1 != 0) && (f < j))
            {
              j = f;
              return false;
              j = paramMotionEvent.getX();
              l = paramMotionEvent.getRawX();
              m = paramMotionEvent.getRawY();
              k = qk.b(paramMotionEvent, 0);
            }
          }
        }
      }
      n = qk.b(paramMotionEvent);
    } while (qk.b(paramMotionEvent, n) != k);
    if (n == 0) {}
    for (int n = i2;; n = 0)
    {
      j = qk.c(paramMotionEvent, n);
      k = qk.b(paramMotionEvent, n);
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.android.ex.photo.PhotoViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */