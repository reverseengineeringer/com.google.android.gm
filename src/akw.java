import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;

public abstract class akw
{
  public ahr h;
  public RecyclerView i;
  public ale j;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  boolean n = true;
  public int o;
  public int p;
  public int q;
  public int r;
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = i1;
    switch (i2)
    {
    default: 
      paramInt1 = Math.max(paramInt2, paramInt3);
    case 1073741824: 
      return paramInt1;
    }
    return Math.min(i1, Math.max(paramInt2, paramInt3));
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = Math.max(0, paramInt1 - paramInt3);
    if (paramBoolean) {
      if (paramInt4 >= 0)
      {
        paramInt3 = 1073741824;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt3);
      if (paramInt4 == -1)
      {
        switch (paramInt2)
        {
        case 0: 
        default: 
          paramInt1 = 0;
          paramInt3 = i1;
          break;
        case 1073741824: 
        case -2147483648: 
          paramInt1 = i2;
          paramInt3 = paramInt2;
          break;
        }
      }
      else
      {
        if (paramInt4 == -2)
        {
          paramInt1 = 0;
          paramInt3 = i1;
          continue;
          if (paramInt4 >= 0)
          {
            paramInt3 = 1073741824;
            paramInt1 = paramInt4;
            continue;
          }
          if (paramInt4 == -1)
          {
            paramInt1 = i2;
            paramInt3 = paramInt2;
            continue;
          }
          if (paramInt4 == -2)
          {
            if (paramInt2 != Integer.MIN_VALUE)
            {
              paramInt1 = i2;
              paramInt3 = i1;
              if (paramInt2 != 1073741824) {
                continue;
              }
            }
            paramInt3 = Integer.MIN_VALUE;
            paramInt1 = i2;
            continue;
          }
        }
        paramInt1 = 0;
        paramInt3 = i1;
      }
    }
  }
  
  public static int a(View paramView)
  {
    return getLayoutParamsa.c();
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = getLayoutParamsb;
    paramView.layout(left + paramInt1, top + paramInt2, paramInt3 - right, paramInt4 - bottom);
  }
  
  public static int b(View paramView)
  {
    Rect localRect = getLayoutParamsb;
    int i1 = paramView.getMeasuredWidth();
    int i2 = left;
    return right + (i1 + i2);
  }
  
  static boolean b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
    do
    {
      do
      {
        return false;
        switch (i1)
        {
        default: 
          return false;
        }
      } while (paramInt2 < paramInt1);
      return true;
      return true;
    } while (paramInt2 != paramInt1);
    return true;
  }
  
  public static int c(View paramView)
  {
    Rect localRect = getLayoutParamsb;
    int i1 = paramView.getMeasuredHeight();
    int i2 = top;
    return bottom + (i1 + i2);
  }
  
  public static int d(View paramView)
  {
    return paramView.getLeft() - getLayoutParamsb.left;
  }
  
  public static int e(View paramView)
  {
    return paramView.getTop() - getLayoutParamsb.top;
  }
  
  public static int f(View paramView)
  {
    int i1 = paramView.getRight();
    return getLayoutParamsb.right + i1;
  }
  
  public static int g(View paramView)
  {
    int i1 = paramView.getBottom();
    return getLayoutParamsb.bottom + i1;
  }
  
  private final void g(int paramInt)
  {
    if (c(paramInt) != null)
    {
      ahr localahr = h;
      paramInt = localahr.a(paramInt);
      View localView = a.b(paramInt);
      if (localView != null)
      {
        if (b.d(paramInt)) {
          localahr.b(localView);
        }
        a.a(paramInt);
      }
    }
  }
  
  private final void h(int paramInt)
  {
    c(paramInt);
    h.d(paramInt);
  }
  
  public int a(int paramInt, ala paramala, alg paramalg)
  {
    return 0;
  }
  
  public int a(alg paramalg)
  {
    return 0;
  }
  
  public abstract akx a();
  
  public akx a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new akx(paramContext, paramAttributeSet);
  }
  
  public akx a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof akx)) {
      return new akx((akx)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new akx((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new akx(paramLayoutParams);
  }
  
  public View a(int paramInt)
  {
    int i2 = i();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = c(i1);
      alj localalj = RecyclerView.b(localView);
      if ((localalj != null) && (localalj.c() == paramInt) && (!localalj.b()) && ((i.A.g) || (!localalj.l()))) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public View a(View paramView, int paramInt, ala paramala, alg paramalg)
  {
    return null;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    q = View.MeasureSpec.getSize(paramInt1);
    o = View.MeasureSpec.getMode(paramInt1);
    if ((o == 0) && (!RecyclerView.b)) {
      q = 0;
    }
    r = View.MeasureSpec.getSize(paramInt2);
    p = View.MeasureSpec.getMode(paramInt2);
    if ((p == 0) && (!RecyclerView.b)) {
      r = 0;
    }
  }
  
  public final void a(int paramInt, ala paramala)
  {
    View localView = c(paramInt);
    g(paramInt);
    paramala.a(localView);
  }
  
  public final void a(ala paramala)
  {
    int i1 = i() - 1;
    if (i1 >= 0)
    {
      View localView = c(i1);
      alj localalj = RecyclerView.b(localView);
      if (!localalj.b())
      {
        if ((!localalj.i()) || (localalj.l()) || (i.i.a)) {
          break label78;
        }
        g(i1);
        paramala.a(localalj);
      }
      for (;;)
      {
        i1 -= 1;
        break;
        label78:
        h(i1);
        paramala.c(localView);
        i.f.c(localalj);
      }
    }
  }
  
  public void a(ala paramala, alg paramalg)
  {
    Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
  }
  
  public void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i1 = paramRect.width();
    int i2 = j();
    int i3 = l();
    int i4 = paramRect.height();
    int i5 = k();
    int i6 = m();
    h(a(paramInt1, i1 + i2 + i3, rg.o(i)), a(paramInt2, i4 + i5 + i6, rg.p(i)));
  }
  
  public void a(Parcelable paramParcelable) {}
  
  public final void a(RecyclerView paramRecyclerView)
  {
    if (paramRecyclerView == null)
    {
      i = null;
      h = null;
      q = 0;
    }
    for (r = 0;; r = paramRecyclerView.getHeight())
    {
      o = 1073741824;
      p = 1073741824;
      return;
      i = paramRecyclerView;
      h = e;
      q = paramRecyclerView.getWidth();
    }
  }
  
  public void a(RecyclerView paramRecyclerView, ala paramala) {}
  
  public final void a(View paramView, int paramInt, boolean paramBoolean)
  {
    alj localalj1 = RecyclerView.b(paramView);
    akx localakx1;
    if ((paramBoolean) || (localalj1.l()))
    {
      i.f.b(localalj1);
      localakx1 = (akx)paramView.getLayoutParams();
      if ((!localalj1.f()) && (!localalj1.d())) {
        break label128;
      }
      if (!localalj1.d()) {
        break label120;
      }
      localalj1.e();
      label68:
      h.a(paramView, paramInt, paramView.getLayoutParams(), false);
    }
    for (;;)
    {
      if (d)
      {
        a.invalidate();
        d = false;
      }
      return;
      i.f.c(localalj1);
      break;
      label120:
      localalj1.g();
      break label68;
      label128:
      Object localObject;
      if (paramView.getParent() == i)
      {
        int i2 = h.c(paramView);
        int i1 = paramInt;
        if (paramInt == -1) {
          i1 = h.a();
        }
        if (i2 == -1) {
          throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + i.indexOfChild(paramView));
        }
        if (i2 != i1)
        {
          paramView = i.j;
          localObject = paramView.c(i2);
          if (localObject == null) {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2);
          }
          paramView.h(i2);
          akx localakx2 = (akx)((View)localObject).getLayoutParams();
          alj localalj2 = RecyclerView.b((View)localObject);
          if (localalj2.l()) {
            i.f.b(localalj2);
          }
          for (;;)
          {
            h.a((View)localObject, i1, localakx2, localalj2.l());
            break;
            i.f.c(localalj2);
          }
        }
      }
      else
      {
        h.a(paramView, paramInt, false);
        c = true;
        if ((j != null) && (j.d))
        {
          localObject = j;
          if (RecyclerView.c(paramView) == a) {
            e = paramView;
          }
        }
      }
    }
  }
  
  public final void a(View paramView, ala paramala)
  {
    ahr localahr = h;
    int i1 = a.a(paramView);
    if (i1 >= 0)
    {
      if (b.d(i1)) {
        localahr.b(paramView);
      }
      a.a(i1);
    }
    paramala.a(paramView);
  }
  
  public final void a(View paramView, uk paramuk)
  {
    Object localObject = RecyclerView.b(paramView);
    if ((localObject != null) && (!((alj)localObject).l()) && (!h.d(a)))
    {
      localObject = i.c;
      localObject = i.A;
      b(paramView, paramuk);
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = true;
    Object localObject = i.c;
    localObject = i.A;
    paramAccessibilityEvent = ub.a(paramAccessibilityEvent);
    if (i == null) {
      return;
    }
    boolean bool1 = bool2;
    if (!rg.b(i, 1))
    {
      bool1 = bool2;
      if (!rg.b(i, -1))
      {
        bool1 = bool2;
        if (!rg.a(i, -1)) {
          if (!rg.a(i, 1)) {
            break label115;
          }
        }
      }
    }
    label115:
    for (bool1 = bool2;; bool1 = false)
    {
      paramAccessibilityEvent.a(bool1);
      if (i.i == null) {
        break;
      }
      paramAccessibilityEvent.a(i.i.b());
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (i != null) {
      i.a(paramString);
    }
  }
  
  public boolean a(akx paramakx)
  {
    return paramakx != null;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2, akx paramakx)
  {
    return (paramView.isLayoutRequested()) || (!n) || (!b(paramView.getWidth(), paramInt1, width)) || (!b(paramView.getHeight(), paramInt2, height));
  }
  
  public final boolean a(Runnable paramRunnable)
  {
    if (i != null) {
      return i.removeCallbacks(paramRunnable);
    }
    return false;
  }
  
  public int b(int paramInt, ala paramala, alg paramalg)
  {
    return 0;
  }
  
  public int b(ala paramala, alg paramalg)
  {
    if ((i == null) || (i.i == null)) {}
    while (!d()) {
      return 1;
    }
    return i.i.b();
  }
  
  public int b(alg paramalg)
  {
    return 0;
  }
  
  public Parcelable b()
  {
    return null;
  }
  
  public void b(int paramInt) {}
  
  public final void b(int paramInt1, int paramInt2)
  {
    int i2 = Integer.MAX_VALUE;
    int i1 = Integer.MIN_VALUE;
    int i10 = i();
    if (i10 == 0)
    {
      i.b(paramInt1, paramInt2);
      return;
    }
    int i5 = 0;
    int i3 = Integer.MIN_VALUE;
    int i4 = Integer.MAX_VALUE;
    int i6;
    int i8;
    int i7;
    if (i5 < i10)
    {
      View localView = c(i5);
      akx localakx = (akx)localView.getLayoutParams();
      int i9 = d(localView) - leftMargin;
      i6 = f(localView);
      i8 = rightMargin + i6;
      i7 = e(localView) - topMargin;
      i6 = g(localView);
      i6 = bottomMargin + i6;
      if (i9 >= i4) {
        break label217;
      }
      i4 = i9;
    }
    label217:
    for (;;)
    {
      if (i8 > i3) {
        i3 = i8;
      }
      for (;;)
      {
        if (i7 < i2) {
          i2 = i7;
        }
        for (;;)
        {
          if (i6 > i1) {
            i1 = i6;
          }
          for (;;)
          {
            i5 += 1;
            break;
            i.h.set(i4, i2, i3, i1);
            a(i.h, paramInt1, paramInt2);
            return;
          }
        }
      }
    }
  }
  
  public final void b(ala paramala)
  {
    int i2 = a.size();
    int i1 = i2 - 1;
    while (i1 >= 0)
    {
      View localView = a.get(i1)).a;
      alj localalj = RecyclerView.b(localView);
      if (!localalj.b())
      {
        localalj.a(false);
        if (localalj.m()) {
          i.removeDetachedView(localView, false);
        }
        if (i.x != null) {
          i.x.c(localalj);
        }
        localalj.a(true);
        paramala.b(localView);
      }
      i1 -= 1;
    }
    a.clear();
    if (b != null) {
      b.clear();
    }
    if (i2 > 0) {
      i.invalidate();
    }
  }
  
  public final void b(RecyclerView paramRecyclerView)
  {
    a(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
  }
  
  public final void b(RecyclerView paramRecyclerView, ala paramala)
  {
    l = false;
    a(paramRecyclerView, paramala);
  }
  
  public void b(View paramView, uk paramuk)
  {
    int i1;
    if (d())
    {
      i1 = a(paramView);
      if (!c()) {
        break label44;
      }
    }
    label44:
    for (int i2 = a(paramView);; i2 = 0)
    {
      paramuk.b(uw.a(i1, 1, i2, 1, false));
      return;
      i1 = 0;
      break;
    }
  }
  
  public int c(ala paramala, alg paramalg)
  {
    if ((i == null) || (i.i == null)) {}
    while (!c()) {
      return 1;
    }
    return i.i.b();
  }
  
  public int c(alg paramalg)
  {
    return 0;
  }
  
  public final View c(int paramInt)
  {
    if (h != null) {
      return h.b(paramInt);
    }
    return null;
  }
  
  public void c(int paramInt1, int paramInt2) {}
  
  public final void c(ala paramala)
  {
    int i1 = i() - 1;
    while (i1 >= 0)
    {
      if (!RecyclerView.b(c(i1)).b()) {
        a(i1, paramala);
      }
      i1 -= 1;
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d(alg paramalg)
  {
    return 0;
  }
  
  public void d(int paramInt)
  {
    if (i != null)
    {
      RecyclerView localRecyclerView = i;
      int i2 = e.a();
      int i1 = 0;
      while (i1 < i2)
      {
        e.b(i1).offsetLeftAndRight(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2) {}
  
  public boolean d()
  {
    return false;
  }
  
  public int e(alg paramalg)
  {
    return 0;
  }
  
  public void e(int paramInt)
  {
    if (i != null)
    {
      RecyclerView localRecyclerView = i;
      int i2 = e.a();
      int i1 = 0;
      while (i1 < i2)
      {
        e.b(i1).offsetTopAndBottom(paramInt);
        i1 += 1;
      }
    }
  }
  
  public void e(int paramInt1, int paramInt2) {}
  
  public boolean e()
  {
    return false;
  }
  
  public int f(alg paramalg)
  {
    return 0;
  }
  
  public void f(int paramInt) {}
  
  public void f(int paramInt1, int paramInt2) {}
  
  public boolean f()
  {
    return false;
  }
  
  public final void g()
  {
    if (i != null) {
      i.requestLayout();
    }
  }
  
  public final void g(int paramInt1, int paramInt2)
  {
    i.b(paramInt1, paramInt2);
  }
  
  public final void h(int paramInt1, int paramInt2)
  {
    RecyclerView.a(i, paramInt1, paramInt2);
  }
  
  public final boolean h()
  {
    return (j != null) && (j.d);
  }
  
  public final int i()
  {
    if (h != null) {
      return h.a();
    }
    return 0;
  }
  
  public final int j()
  {
    if (i != null) {
      return i.getPaddingLeft();
    }
    return 0;
  }
  
  public final int k()
  {
    if (i != null) {
      return i.getPaddingTop();
    }
    return 0;
  }
  
  public final int l()
  {
    if (i != null) {
      return i.getPaddingRight();
    }
    return 0;
  }
  
  public final int m()
  {
    if (i != null) {
      return i.getPaddingBottom();
    }
    return 0;
  }
  
  public void n() {}
}

/* Location:
 * Qualified Name:     akw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */