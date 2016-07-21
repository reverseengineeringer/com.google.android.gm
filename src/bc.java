import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

public class bc<V extends View>
  extends db<V>
{
  private Runnable a;
  xu b;
  private boolean c;
  private int d = -1;
  private int e;
  private int f = -1;
  private VelocityTracker g;
  
  public bc() {}
  
  public bc(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void c()
  {
    if (g == null) {
      g = VelocityTracker.obtain();
    }
  }
  
  public int a()
  {
    return b();
  }
  
  public int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = b();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = bf.a(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            a(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  public int a(V paramV)
  {
    return paramV.getHeight();
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  public final boolean a(float paramFloat)
  {
    View localView;
    if (a != null)
    {
      localView.removeCallbacks(a);
      a = null;
    }
    if (b == null) {
      b = xu.a(localView.getContext(), null);
    }
    Object localObject;
    int i;
    b.a(b(), 0, Math.round(localObject), 0, 0, i, 0);
    if (b.g())
    {
      a = new bd(this, paramFloat, localView);
      rg.a(localView, a);
      return true;
    }
    a(paramFloat, localView);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (f < 0) {
      f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (c)) {
      return true;
    }
    switch (qk.a(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (g != null) {
        g.addMovement(paramMotionEvent);
      }
      return c;
      c = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((c(paramV)) && (paramCoordinatorLayout.a(paramV, i, j)))
      {
        e = j;
        d = qk.b(paramMotionEvent, 0);
        c();
        continue;
        i = d;
        if (i != -1)
        {
          i = qk.a(paramMotionEvent, i);
          if (i != -1)
          {
            i = (int)qk.d(paramMotionEvent, i);
            if (Math.abs(i - e) > f)
            {
              c = true;
              e = i;
              continue;
              c = false;
              d = -1;
              if (g != null)
              {
                g.recycle();
                g = null;
              }
            }
          }
        }
      }
    }
  }
  
  public final int a_(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  public final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3);
  }
  
  public int b(V paramV)
  {
    return -paramV.getHeight();
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (f < 0) {
      f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    switch (qk.a(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (g != null) {
        g.addMovement(paramMotionEvent);
      }
      boolean bool1 = true;
      do
      {
        do
        {
          do
          {
            return bool1;
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
            bool1 = bool2;
          } while (!paramCoordinatorLayout.a(paramV, i, j));
          bool1 = bool2;
        } while (!c(paramV));
        e = j;
        d = qk.b(paramMotionEvent, 0);
        c();
        break;
        i = qk.a(paramMotionEvent, d);
        bool1 = bool2;
      } while (i == -1);
      int k = (int)qk.d(paramMotionEvent, i);
      int j = e - k;
      int i = j;
      if (!c)
      {
        i = j;
        if (Math.abs(j) > f)
        {
          c = true;
          if (j <= 0) {
            break label260;
          }
        }
      }
      label260:
      for (i = j - f; c; i = j + f)
      {
        e = k;
        b(paramCoordinatorLayout, paramV, i, b(paramV), 0);
        break;
      }
      if (g != null)
      {
        g.addMovement(paramMotionEvent);
        g.computeCurrentVelocity(1000);
        float f1 = rc.b(g, d);
        a(paramCoordinatorLayout, paramV, -a(paramV), f1);
      }
      c = false;
      d = -1;
      if (g != null)
      {
        g.recycle();
        g = null;
      }
    }
  }
  
  public boolean c(V paramV)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     bc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */