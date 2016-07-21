import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

final class pd
  implements pc
{
  private static final int l = ;
  private static final int m = ViewConfiguration.getTapTimeout();
  private static final int n = ViewConfiguration.getDoubleTapTimeout();
  final Handler a = new pe(this);
  final GestureDetector.OnGestureListener b;
  GestureDetector.OnDoubleTapListener c;
  boolean d;
  boolean e;
  boolean f;
  MotionEvent g;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean o;
  private boolean p;
  private MotionEvent q;
  private boolean r;
  private float s;
  private float t;
  private float u;
  private float v;
  private boolean w;
  private VelocityTracker x;
  
  public pd(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    b = paramOnGestureListener;
    if ((paramOnGestureListener instanceof GestureDetector.OnDoubleTapListener)) {
      c = ((GestureDetector.OnDoubleTapListener)paramOnGestureListener);
    }
    if (paramContext == null) {
      throw new IllegalArgumentException("Context must not be null");
    }
    if (b == null) {
      throw new IllegalArgumentException("OnGestureListener must not be null");
    }
    w = true;
    paramContext = ViewConfiguration.get(paramContext);
    int i1 = paramContext.getScaledTouchSlop();
    int i2 = paramContext.getScaledDoubleTapSlop();
    j = paramContext.getScaledMinimumFlingVelocity();
    k = paramContext.getScaledMaximumFlingVelocity();
    h = (i1 * i1);
    i = (i2 * i2);
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    int i6 = paramMotionEvent.getAction();
    if (x == null) {
      x = VelocityTracker.obtain();
    }
    x.addMovement(paramMotionEvent);
    int i1;
    if ((i6 & 0xFF) == 6)
    {
      i1 = 1;
      if (i1 == 0) {
        break label127;
      }
    }
    int i5;
    int i4;
    float f1;
    float f2;
    float f4;
    float f3;
    label127:
    for (int i3 = qk.b(paramMotionEvent);; i3 = -1)
    {
      i5 = qk.c(paramMotionEvent);
      i4 = 0;
      f1 = 0.0F;
      for (f2 = 0.0F; i4 < i5; f2 = f3)
      {
        f4 = f1;
        f3 = f2;
        if (i3 != i4)
        {
          f3 = f2 + qk.c(paramMotionEvent, i4);
          f4 = f1 + qk.d(paramMotionEvent, i4);
        }
        i4 += 1;
        f1 = f4;
      }
      i1 = 0;
      break;
    }
    if (i1 != 0)
    {
      i1 = i5 - 1;
      f2 /= i1;
      f1 /= i1;
    }
    boolean bool2;
    MotionEvent localMotionEvent;
    Object localObject;
    label757:
    int i2;
    switch (i6 & 0xFF)
    {
    case 4: 
    default: 
    case 5: 
    case 6: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return false;
          i1 = i5;
          break;
          s = f2;
          u = f2;
          t = f1;
          v = f1;
          a.removeMessages(1);
          a.removeMessages(2);
          a.removeMessages(3);
          r = false;
          o = false;
          p = false;
          e = false;
        } while (!f);
        f = false;
        return false;
        s = f2;
        u = f2;
        t = f1;
        v = f1;
        x.computeCurrentVelocity(1000, k);
        i3 = qk.b(paramMotionEvent);
        i1 = qk.b(paramMotionEvent, i3);
        f1 = rc.a(x, i1);
        f2 = rc.b(x, i1);
        i1 = 0;
        while (i1 < i5)
        {
          if (i1 != i3)
          {
            i4 = qk.b(paramMotionEvent, i1);
            f3 = rc.a(x, i4);
            if (rc.b(x, i4) * f2 + f3 * f1 < 0.0F)
            {
              x.clear();
              return false;
            }
          }
          i1 += 1;
        }
        if (c != null)
        {
          bool2 = a.hasMessages(3);
          if (bool2) {
            a.removeMessages(3);
          }
          if ((g != null) && (q != null) && (bool2))
          {
            localMotionEvent = g;
            localObject = q;
            if ((p) && (paramMotionEvent.getEventTime() - ((MotionEvent)localObject).getEventTime() <= n))
            {
              i1 = (int)localMotionEvent.getX() - (int)paramMotionEvent.getX();
              i3 = (int)localMotionEvent.getY() - (int)paramMotionEvent.getY();
              if (i3 * i3 + i1 * i1 < i)
              {
                i1 = 1;
                if (i1 == 0) {
                  break label757;
                }
                r = true;
              }
            }
          }
        }
        for (boolean bool1 = c.onDoubleTap(g) | false | c.onDoubleTapEvent(paramMotionEvent);; bool1 = false)
        {
          s = f2;
          u = f2;
          t = f1;
          v = f1;
          if (g != null) {
            g.recycle();
          }
          g = MotionEvent.obtain(paramMotionEvent);
          o = true;
          p = true;
          d = true;
          f = false;
          e = false;
          if (w)
          {
            a.removeMessages(2);
            a.sendEmptyMessageAtTime(2, g.getDownTime() + m + l);
          }
          a.sendEmptyMessageAtTime(1, g.getDownTime() + m);
          return bool1 | b.onDown(paramMotionEvent);
          bool1 = false;
          break;
          a.sendEmptyMessageDelayed(3, n);
        }
      } while (f);
      f3 = s - f2;
      f4 = t - f1;
      if (r) {
        return c.onDoubleTapEvent(paramMotionEvent) | false;
      }
      if (o)
      {
        i2 = (int)(f2 - u);
        i3 = (int)(f1 - v);
        i2 = i2 * i2 + i3 * i3;
        if (i2 <= h) {
          break label1350;
        }
        bool2 = b.onScroll(g, paramMotionEvent, f3, f4);
        s = f2;
        t = f1;
        o = false;
        a.removeMessages(3);
        a.removeMessages(1);
        a.removeMessages(2);
      }
      break;
    }
    for (;;)
    {
      if (i2 > h) {
        p = false;
      }
      return bool2;
      if ((Math.abs(f3) < 1.0F) && (Math.abs(f4) < 1.0F)) {
        break;
      }
      bool2 = b.onScroll(g, paramMotionEvent, f3, f4);
      s = f2;
      t = f1;
      return bool2;
      d = false;
      localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      if (r) {
        bool2 = c.onDoubleTapEvent(paramMotionEvent) | false;
      }
      for (;;)
      {
        if (q != null) {
          q.recycle();
        }
        q = localMotionEvent;
        if (x != null)
        {
          x.recycle();
          x = null;
        }
        r = false;
        e = false;
        a.removeMessages(1);
        a.removeMessages(2);
        return bool2;
        if (f)
        {
          a.removeMessages(3);
          f = false;
          bool2 = false;
        }
        else if (o)
        {
          boolean bool3 = b.onSingleTapUp(paramMotionEvent);
          bool2 = bool3;
          if (e)
          {
            bool2 = bool3;
            if (c != null)
            {
              c.onSingleTapConfirmed(paramMotionEvent);
              bool2 = bool3;
            }
          }
        }
        else
        {
          localObject = x;
          i2 = qk.b(paramMotionEvent, 0);
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, k);
          f1 = rc.b((VelocityTracker)localObject, i2);
          f2 = rc.a((VelocityTracker)localObject, i2);
          if ((Math.abs(f1) > j) || (Math.abs(f2) > j))
          {
            bool2 = b.onFling(g, paramMotionEvent, f2, f1);
            continue;
            a.removeMessages(1);
            a.removeMessages(2);
            a.removeMessages(3);
            x.recycle();
            x = null;
            r = false;
            d = false;
            o = false;
            p = false;
            e = false;
            if (!f) {
              break;
            }
            f = false;
            return false;
          }
          bool2 = false;
        }
      }
      label1350:
      bool2 = false;
    }
  }
}

/* Location:
 * Qualified Name:     pd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */