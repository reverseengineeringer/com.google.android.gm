import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class yy
{
  private static final Interpolator v = new yz();
  public int a;
  public int b;
  public float[] c;
  public float[] d;
  public float[] e;
  public float[] f;
  public float g;
  public int h;
  public int i;
  View j;
  private int k = -1;
  private int[] l;
  private int[] m;
  private int[] n;
  private int o;
  private VelocityTracker p;
  private float q;
  private xu r;
  private final zb s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w = new za(this);
  
  private yy(Context paramContext, ViewGroup paramViewGroup, zb paramzb)
  {
    if (paramViewGroup == null) {
      throw new IllegalArgumentException("Parent view may not be null");
    }
    if (paramzb == null) {
      throw new IllegalArgumentException("Callback may not be null");
    }
    u = paramViewGroup;
    s = paramzb;
    paramViewGroup = ViewConfiguration.get(paramContext);
    h = ((int)(getResourcesgetDisplayMetricsdensity * 20.0F + 0.5F));
    b = paramViewGroup.getScaledTouchSlop();
    q = paramViewGroup.getScaledMaximumFlingVelocity();
    g = paramViewGroup.getScaledMinimumFlingVelocity();
    r = xu.a(paramContext, v);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      paramFloat2 = 0.0F;
    }
    do
    {
      return paramFloat2;
      if (f1 <= paramFloat3) {
        break;
      }
      paramFloat2 = paramFloat3;
    } while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }
  
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = u.getWidth();
    int i2 = i1 / 2;
    float f3 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f1 = i2;
    float f2 = i2;
    f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {}
    for (paramInt1 = Math.round(Math.abs((f3 * f2 + f1) / paramInt2) * 1000.0F) * 4;; paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F)) {
      return Math.min(paramInt1, 600);
    }
  }
  
  public static yy a(ViewGroup paramViewGroup, float paramFloat, zb paramzb)
  {
    paramViewGroup = a(paramViewGroup, paramzb);
    b = ((int)(b * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  public static yy a(ViewGroup paramViewGroup, zb paramzb)
  {
    return new yy(paramViewGroup.getContext(), paramViewGroup, paramzb);
  }
  
  private final void a(float paramFloat1, float paramFloat2)
  {
    t = true;
    s.a(j, paramFloat1, paramFloat2);
    t = false;
    if (a == 1) {
      b(0);
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i2 = 0;
    if ((c == null) || (c.length <= paramInt))
    {
      localObject = new float[paramInt + 1];
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (c != null)
      {
        System.arraycopy(c, 0, localObject, 0, c.length);
        System.arraycopy(d, 0, arrayOfFloat1, 0, d.length);
        System.arraycopy(e, 0, arrayOfFloat2, 0, e.length);
        System.arraycopy(f, 0, arrayOfFloat3, 0, f.length);
        System.arraycopy(l, 0, arrayOfInt1, 0, l.length);
        System.arraycopy(m, 0, arrayOfInt2, 0, m.length);
        System.arraycopy(n, 0, arrayOfInt3, 0, n.length);
      }
      c = ((float[])localObject);
      d = arrayOfFloat1;
      e = arrayOfFloat2;
      f = arrayOfFloat3;
      l = arrayOfInt1;
      m = arrayOfInt2;
      n = arrayOfInt3;
    }
    Object localObject = c;
    e[paramInt] = paramFloat1;
    localObject[paramInt] = paramFloat1;
    localObject = d;
    f[paramInt] = paramFloat2;
    localObject[paramInt] = paramFloat2;
    localObject = l;
    int i4 = (int)paramFloat1;
    int i3 = (int)paramFloat2;
    if (i4 < u.getLeft() + h) {
      i2 = 1;
    }
    int i1 = i2;
    if (i3 < u.getTop() + h) {
      i1 = i2 | 0x4;
    }
    i2 = i1;
    if (i4 > u.getRight() - h) {
      i2 = i1 | 0x2;
    }
    i1 = i2;
    if (i3 > u.getBottom() - h) {
      i1 = i2 | 0x8;
    }
    localObject[paramInt] = i1;
    o |= 1 << paramInt;
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((l[paramInt1] & paramInt2) != paramInt2) || ((i & paramInt2) == 0) || ((n[paramInt1] & paramInt2) == paramInt2) || ((m[paramInt1] & paramInt2) == paramInt2) || ((paramFloat1 <= b) && (paramFloat2 <= b))) {}
    while (((m[paramInt1] & paramInt2) != 0) || (paramFloat1 <= b)) {
      return false;
    }
    return true;
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = j.getLeft();
    int i2 = j.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      r.h();
      b(0);
      return false;
    }
    View localView = j;
    paramInt3 = b(paramInt3, (int)g, (int)q);
    paramInt4 = b(paramInt4, (int)g, (int)q);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(paramInt3);
    int i6 = Math.abs(paramInt4);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    float f1;
    if (paramInt3 != 0)
    {
      f1 = i5 / i7;
      if (paramInt4 == 0) {
        break label237;
      }
    }
    label237:
    for (float f2 = i6 / i7;; f2 = i4 / i8)
    {
      paramInt3 = a(paramInt1, paramInt3, s.a(localView));
      paramInt4 = a(paramInt2, paramInt4, s.a());
      float f3 = paramInt3;
      paramInt3 = (int)(f2 * paramInt4 + f1 * f3);
      r.a(i1, i2, paramInt1, paramInt2, paramInt3);
      b(2);
      return true;
      f1 = i3 / i8;
      break;
    }
  }
  
  private final boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    label20:
    int i2;
    label72:
    label78:
    do
    {
      do
      {
        return false;
        int i1;
        if (s.a(paramView) > 0)
        {
          i1 = 1;
          if (s.a() <= 0) {
            break label72;
          }
        }
        for (i2 = 1;; i2 = 0)
        {
          if ((i1 == 0) || (i2 == 0)) {
            break label78;
          }
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= b * b) {
            break;
          }
          return true;
          i1 = 0;
          break label20;
        }
        if (i1 == 0) {
          break;
        }
      } while (Math.abs(paramFloat1) <= b);
      return true;
    } while ((i2 == 0) || (Math.abs(paramFloat2) <= b));
    return true;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      paramInt2 = 0;
    }
    do
    {
      return paramInt2;
      if (i1 <= paramInt3) {
        break;
      }
      paramInt2 = paramInt3;
    } while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }
  
  private final void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i2 = 1;
    if (a(paramFloat1, paramFloat2, paramInt, 1)) {}
    for (;;)
    {
      int i1 = i2;
      if (a(paramFloat2, paramFloat1, paramInt, 4)) {
        i1 = i2 | 0x4;
      }
      i2 = i1;
      if (a(paramFloat1, paramFloat2, paramInt, 2)) {
        i2 = i1 | 0x2;
      }
      i1 = i2;
      if (a(paramFloat2, paramFloat1, paramInt, 8)) {
        i1 = i2 | 0x8;
      }
      if (i1 != 0)
      {
        int[] arrayOfInt = m;
        arrayOfInt[paramInt] |= i1;
        s.a(i1, paramInt);
      }
      return;
      i2 = 0;
    }
  }
  
  private final boolean b(View paramView, int paramInt)
  {
    if ((paramView == j) && (k == paramInt)) {
      return true;
    }
    if ((paramView != null) && (s.a(paramView, paramInt)))
    {
      k = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom())) {
      return false;
    }
    return true;
  }
  
  private final void c(int paramInt)
  {
    if (c == null) {
      return;
    }
    c[paramInt] = 0.0F;
    d[paramInt] = 0.0F;
    e[paramInt] = 0.0F;
    f[paramInt] = 0.0F;
    l[paramInt] = 0;
    m[paramInt] = 0;
    n[paramInt] = 0;
    o &= (1 << paramInt ^ 0xFFFFFFFF);
  }
  
  private final void c(MotionEvent paramMotionEvent)
  {
    int i2 = qk.c(paramMotionEvent);
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = qk.b(paramMotionEvent, i1);
      float f1 = qk.c(paramMotionEvent, i1);
      float f2 = qk.d(paramMotionEvent, i1);
      e[i3] = f1;
      f[i3] = f2;
      i1 += 1;
    }
  }
  
  private final void d()
  {
    p.computeCurrentVelocity(1000, q);
    a(a(rc.a(p, k), g, q), a(rc.b(p, k), g, q));
  }
  
  private final boolean d(int paramInt)
  {
    if (!a(paramInt))
    {
      Log.e("ViewDragHelper", "Ignoring pointerId=" + paramInt + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  public final void a()
  {
    k = -1;
    if (c != null)
    {
      Arrays.fill(c, 0.0F);
      Arrays.fill(d, 0.0F);
      Arrays.fill(e, 0.0F);
      Arrays.fill(f, 0.0F);
      Arrays.fill(l, 0);
      Arrays.fill(m, 0);
      Arrays.fill(n, 0);
      o = 0;
    }
    if (p != null)
    {
      p.recycle();
      p = null;
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    if (paramView.getParent() != u) {
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + u + ")");
    }
    j = paramView;
    k = paramInt;
    s.d(paramView, paramInt);
    b(1);
  }
  
  public final boolean a(int paramInt)
  {
    return (o & 1 << paramInt) != 0;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (!t) {
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }
    return a(paramInt1, paramInt2, (int)rc.a(p, k), (int)rc.b(p, k));
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = qk.a(paramMotionEvent);
    int i1 = qk.b(paramMotionEvent);
    if (i2 == 0) {
      a();
    }
    if (p == null) {
      p = VelocityTracker.obtain();
    }
    p.addMovement(paramMotionEvent);
    switch (i2)
    {
    }
    while (a == 1)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      i1 = qk.b(paramMotionEvent, 0);
      a(f1, f2, i1);
      paramMotionEvent = b((int)f1, (int)f2);
      if ((paramMotionEvent == j) && (a == 2)) {
        b(paramMotionEvent, i1);
      }
      if ((l[i1] & i) != 0)
      {
        s.d();
        continue;
        i2 = qk.b(paramMotionEvent, i1);
        f1 = qk.c(paramMotionEvent, i1);
        f2 = qk.d(paramMotionEvent, i1);
        a(f1, f2, i2);
        if (a == 0)
        {
          if ((l[i2] & i) != 0) {
            s.d();
          }
        }
        else if (a == 2)
        {
          paramMotionEvent = b((int)f1, (int)f2);
          if (paramMotionEvent == j)
          {
            b(paramMotionEvent, i2);
            continue;
            if ((c != null) && (d != null))
            {
              int i3 = qk.c(paramMotionEvent);
              i1 = 0;
              if (i1 < i3)
              {
                int i4 = qk.b(paramMotionEvent, i1);
                float f3;
                float f4;
                View localView;
                if (d(i4))
                {
                  f1 = qk.c(paramMotionEvent, i1);
                  f2 = qk.d(paramMotionEvent, i1);
                  f3 = f1 - c[i4];
                  f4 = f2 - d[i4];
                  localView = b((int)f1, (int)f2);
                  if ((localView == null) || (!a(localView, f3, f4))) {
                    break label551;
                  }
                }
                label551:
                for (i2 = 1;; i2 = 0)
                {
                  if (i2 != 0)
                  {
                    int i5 = localView.getLeft();
                    int i6 = (int)f3;
                    i6 = s.c(localView, i6 + i5);
                    int i7 = localView.getTop();
                    int i8 = (int)f4;
                    i8 = s.b(localView, i8 + i7);
                    int i9 = s.a(localView);
                    int i10 = s.a();
                    if (((i9 == 0) || ((i9 > 0) && (i6 == i5))) && ((i10 == 0) || ((i10 > 0) && (i8 == i7)))) {
                      break label557;
                    }
                  }
                  b(f3, f4, i4);
                  if ((a == 1) || ((i2 != 0) && (b(localView, i4)))) {
                    break label557;
                  }
                  i1 += 1;
                  break;
                }
              }
              label557:
              c(paramMotionEvent);
              continue;
              c(qk.b(paramMotionEvent, i1));
              continue;
              a();
            }
          }
        }
      }
    }
    return false;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    j = paramView;
    k = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (a == 0) && (j != null)) {
      j = null;
    }
    return bool;
  }
  
  public final View b(int paramInt1, int paramInt2)
  {
    int i1 = u.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = u.getChildAt(i1);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i1 -= 1;
    }
    return null;
  }
  
  public final void b()
  {
    a();
    if (a == 2)
    {
      r.b();
      r.c();
      r.h();
      int i1 = r.b();
      int i2 = r.c();
      s.a(j, i1, i2);
    }
    b(0);
  }
  
  final void b(int paramInt)
  {
    u.removeCallbacks(w);
    if (a != paramInt)
    {
      a = paramInt;
      s.a(paramInt);
      if (a == 0) {
        j = null;
      }
    }
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    int i2 = 0;
    int i4 = qk.a(paramMotionEvent);
    int i3 = qk.b(paramMotionEvent);
    if (i4 == 0) {
      a();
    }
    if (p == null) {
      p = VelocityTracker.obtain();
    }
    p.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (i4)
    {
    case 4: 
    default: 
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              f1 = paramMotionEvent.getX();
              f2 = paramMotionEvent.getY();
              i1 = qk.b(paramMotionEvent, 0);
              paramMotionEvent = b((int)f1, (int)f2);
              a(f1, f2, i1);
              b(paramMotionEvent, i1);
            } while ((l[i1] & i) == 0);
            s.d();
            return;
            i1 = qk.b(paramMotionEvent, i3);
            f1 = qk.c(paramMotionEvent, i3);
            f2 = qk.d(paramMotionEvent, i3);
            a(f1, f2, i1);
            if (a != 0) {
              break;
            }
            b(b((int)f1, (int)f2), i1);
          } while ((l[i1] & i) == 0);
          s.d();
          return;
          i2 = (int)f1;
          i3 = (int)f2;
        } while (!b(j, i2, i3));
        b(j, i1);
        return;
        if (a != 1) {
          break;
        }
      } while (!d(k));
      i1 = qk.a(paramMotionEvent, k);
      f1 = qk.c(paramMotionEvent, i1);
      f2 = qk.d(paramMotionEvent, i1);
      i4 = (int)(f1 - e[k]);
      int i5 = (int)(f2 - f[k]);
      i2 = j.getLeft() + i4;
      i3 = j.getTop() + i5;
      int i7 = j.getLeft();
      int i6 = j.getTop();
      i1 = i2;
      if (i4 != 0)
      {
        i1 = s.c(j, i2);
        rg.f(j, i1 - i7);
      }
      i2 = i3;
      if (i5 != 0)
      {
        i2 = s.b(j, i3);
        rg.e(j, i2 - i6);
      }
      if ((i4 != 0) || (i5 != 0)) {
        s.a(j, i1, i2);
      }
      c(paramMotionEvent);
      return;
      i3 = qk.c(paramMotionEvent);
      i1 = i2;
      while (i1 < i3)
      {
        i2 = qk.b(paramMotionEvent, i1);
        if (d(i2))
        {
          f1 = qk.c(paramMotionEvent, i1);
          f2 = qk.d(paramMotionEvent, i1);
          float f3 = f1 - c[i2];
          float f4 = f2 - d[i2];
          b(f3, f4, i2);
          if (a == 1) {
            break;
          }
          View localView = b((int)f1, (int)f2);
          if ((a(localView, f3, f4)) && (b(localView, i2))) {
            break;
          }
        }
        i1 += 1;
      }
      c(paramMotionEvent);
      return;
    case 6: 
      i2 = qk.b(paramMotionEvent, i3);
      if ((a == 1) && (i2 == k))
      {
        i3 = qk.c(paramMotionEvent);
        if (i1 >= i3) {
          break label785;
        }
        i4 = qk.b(paramMotionEvent, i1);
        if (i4 == k) {
          break label740;
        }
        f1 = qk.c(paramMotionEvent, i1);
        f2 = qk.d(paramMotionEvent, i1);
        if ((b((int)f1, (int)f2) != j) || (!b(j, i4))) {
          break label740;
        }
      }
      break;
    }
    label740:
    label785:
    for (i1 = k;; i1 = -1)
    {
      if (i1 == -1) {
        d();
      }
      c(i2);
      return;
      i1 += 1;
      break;
      if (a == 1) {
        d();
      }
      a();
      return;
      if (a == 1) {
        a(0.0F, 0.0F);
      }
      a();
      return;
    }
  }
  
  public final boolean c()
  {
    boolean bool2 = false;
    if (a == 2)
    {
      boolean bool3 = r.g();
      int i1 = r.b();
      int i2 = r.c();
      int i3 = i1 - j.getLeft();
      int i4 = i2 - j.getTop();
      if (i3 != 0) {
        rg.f(j, i3);
      }
      if (i4 != 0) {
        rg.e(j, i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        s.a(j, i1, i2);
      }
      bool1 = bool3;
      if (bool3)
      {
        bool1 = bool3;
        if (i1 == r.d())
        {
          bool1 = bool3;
          if (i2 == r.e())
          {
            r.h();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        u.post(w);
      }
    }
    boolean bool1 = bool2;
    if (a == 2) {
      bool1 = true;
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     yy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */