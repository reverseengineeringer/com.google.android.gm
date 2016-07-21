package android.support.design.widget;

import ad;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import j;
import java.lang.ref.WeakReference;
import qk;
import qq;
import rc;
import rg;
import v;
import x;
import yy;
import zb;

public class BottomSheetBehavior<V extends View>
  extends ad<V>
{
  public int a;
  public int b;
  public boolean c;
  public int d = 4;
  public yy e;
  public int f;
  public WeakReference<V> g;
  public WeakReference<View> h;
  public int i;
  public boolean j;
  private float k;
  private int l;
  private boolean m;
  private int n;
  private boolean o;
  private VelocityTracker p;
  private int q;
  private final zb r = new v(this);
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, j.q);
    int i1 = paramAttributeSet.getDimensionPixelSize(j.s, 0);
    l = Math.max(0, i1);
    b = (f - i1);
    c = paramAttributeSet.getBoolean(j.r, false);
    paramAttributeSet.recycle();
    k = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private final View b(View paramView)
  {
    if ((paramView instanceof qq)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i2 = paramView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = b(paramView.getChildAt(i1));
        if (localView != null) {
          return localView;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  private final void b()
  {
    i = -1;
    if (p != null)
    {
      p.recycle();
      p = null;
    }
  }
  
  public final void a()
  {
    g.get();
  }
  
  public final void a(int paramInt)
  {
    if (d == paramInt) {
      return;
    }
    d = paramInt;
    g.get();
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (BottomSheetBehavior.SavedState)paramParcelable;
    super.a(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    if ((a == 1) || (a == 2))
    {
      d = 4;
      return;
    }
    d = a;
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView)
  {
    int i2 = 3;
    if (paramV.getTop() == a) {
      a(3);
    }
    while ((paramView != h.get()) || (!o)) {
      return;
    }
    int i1;
    if (n > 0)
    {
      i1 = a;
      if (!e.a(paramV, paramV.getLeft(), i1)) {
        break label215;
      }
      a(2);
      rg.a(paramV, new x(this, paramV, i2));
    }
    for (;;)
    {
      o = false;
      return;
      if (c)
      {
        p.computeCurrentVelocity(1000, k);
        if (a(paramV, rc.b(p, i)))
        {
          i1 = f;
          i2 = 5;
          break;
        }
      }
      if (n == 0)
      {
        i1 = paramV.getTop();
        if (Math.abs(i1 - a) < Math.abs(i1 - b))
        {
          i1 = a;
          break;
        }
        i1 = b;
        i2 = 4;
        break;
      }
      i1 = b;
      i2 = 4;
      break;
      label215:
      a(i2);
    }
  }
  
  public final void a(int paramInt)
  {
    ;
    if (localView2 != (View)h.get()) {
      return;
    }
    View localView1;
    int i2 = localView1.getTop();
    int i1;
    int i3 = i2 - i1;
    Object localObject;
    if (i1 > 0) {
      if (i3 < a)
      {
        localObject[1] = (i2 - a);
        rg.e(localView1, -localObject[1]);
        a(3);
      }
    }
    for (;;)
    {
      localView1.getTop();
      a();
      n = i1;
      o = true;
      return;
      localObject[1] = i1;
      rg.e(localView1, -i1);
      a(1);
      continue;
      if ((i1 < 0) && (!rg.b(localView2, -1))) {
        if ((i3 <= b) || (c))
        {
          localObject[1] = i1;
          rg.e(localView1, -i1);
          a(1);
        }
        else
        {
          localObject[1] = (i2 - b);
          rg.e(localView1, -localObject[1]);
          a(4);
        }
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((d != 1) && (d != 2))
    {
      if ((rg.t(paramCoordinatorLayout)) && (!rg.t(paramV))) {
        rg.u(paramV);
      }
      paramCoordinatorLayout.a(paramV, paramInt);
    }
    f = paramCoordinatorLayout.getHeight();
    a = Math.max(0, f - paramV.getHeight());
    b = Math.max(f - l, a);
    if (d == 3) {
      rg.e(paramV, a);
    }
    for (;;)
    {
      if (e == null) {
        e = yy.a(paramCoordinatorLayout, r);
      }
      g = new WeakReference(paramV);
      h = new WeakReference(b(paramV));
      return true;
      if ((c) && (d == 5)) {
        rg.e(paramV, f);
      } else if (d == 4) {
        rg.e(paramV, b);
      }
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {}
    int i1;
    do
    {
      return false;
      i1 = qk.a(paramMotionEvent);
      if (i1 == 0) {
        b();
      }
      if (p == null) {
        p = VelocityTracker.obtain();
      }
      p.addMovement(paramMotionEvent);
      switch (i1)
      {
      }
      while ((!m) && (e.a(paramMotionEvent)))
      {
        return true;
        j = false;
        i = -1;
        if (m)
        {
          m = false;
          return false;
          int i2 = (int)paramMotionEvent.getX();
          q = ((int)paramMotionEvent.getY());
          View localView = (View)h.get();
          if ((localView != null) && (paramCoordinatorLayout.a(localView, i2, q)))
          {
            i = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            j = true;
          }
          if ((i == -1) && (!paramCoordinatorLayout.a(paramV, i2, q))) {}
          for (boolean bool = true;; bool = false)
          {
            m = bool;
            break;
          }
        }
      }
      paramV = (View)h.get();
    } while ((i1 != 2) || (paramV == null) || (m) || (d == 1) || (paramCoordinatorLayout.a(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (Math.abs(q - paramMotionEvent.getY()) <= e.b));
    return true;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == h.get()) && ((d != 3) || (super.a(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool = false;
    n = 0;
    o = false;
    int i1;
    if ((i1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean a(View paramView, float paramFloat)
  {
    if (paramView.getTop() < b) {}
    while (Math.abs(paramView.getTop() + 0.1F * paramFloat - b) / l <= 0.5F) {
      return false;
    }
    return true;
  }
  
  public final Parcelable b(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new BottomSheetBehavior.SavedState(super.b(paramCoordinatorLayout, paramV), d);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {}
    do
    {
      return false;
      int i1 = qk.a(paramMotionEvent);
      if ((d == 1) && (i1 == 0)) {
        return true;
      }
      e.b(paramMotionEvent);
      if (i1 == 0) {
        b();
      }
      if (p == null) {
        p = VelocityTracker.obtain();
      }
      p.addMovement(paramMotionEvent);
      if ((i1 == 2) && (!m) && (Math.abs(q - paramMotionEvent.getY()) > e.b)) {
        e.a(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
      }
    } while (m);
    return true;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */