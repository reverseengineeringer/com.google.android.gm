package com.android.mail.browse;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import buc;
import bwb;
import bwc;
import bwd;
import bwe;
import bwf;
import bxh;
import bxp;
import bzp;
import cub;
import cvm;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rg;

public class ConversationContainer
  extends ViewGroup
  implements bzp
{
  public static final int[] a = { buc.aK };
  private static final int[] g = { buc.aJ };
  public bxp b;
  public bwe[] c;
  public int d;
  public final cub<Integer, View> e = new cub();
  public final SparseArray<bwf> f = new SparseArray();
  private ConversationWebView h;
  private final List<View> i = new ArrayList();
  private float j;
  private boolean k;
  private final int l;
  private float m;
  private int n;
  private boolean o = false;
  private boolean p;
  private int q;
  private boolean r;
  private final DataSetObserver s = new bwb(this);
  private int t;
  
  public ConversationContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ConversationContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setMotionEventSplittingEnabled(false);
  }
  
  private static bwe a(bxh parambxh, int paramInt1, int paramInt2, int paramInt3)
  {
    if (parambxh.e() == 0)
    {
      if (paramInt3 == 48) {}
      for (;;)
      {
        return new bwe(paramInt1, paramInt1);
        paramInt1 = paramInt2;
      }
    }
    if (paramInt3 != 0) {}
    for (;;)
    {
      paramInt3 &= 0x70;
      switch (paramInt3)
      {
      default: 
        throw new UnsupportedOperationException(32 + "unsupported gravity: " + paramInt3);
        paramInt3 = parambxh.d();
      }
    }
    return new bwe(paramInt2 - parambxh.e(), paramInt2);
    return new bwe(paramInt1, parambxh.e() + paramInt1);
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject1 = (bwf)f.get(paramInt1);
    bxh localbxh = b.a(paramInt1);
    a = paramInt2;
    if ((paramInt2 != paramInt3) && (paramInt3 > d) && (paramInt2 < d + getHeight()))
    {
      label110:
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = a;
        if (localObject1 != null) {
          break label344;
        }
        paramInt3 = b.getItemViewType(paramInt1);
        localObject1 = (Deque)e.a.get(Integer.valueOf(paramInt3));
        if (localObject1 != null) {
          break label297;
        }
        localObject1 = null;
        localObject1 = (View)localObject1;
        localObject2 = b.getView(paramInt1, (View)localObject1, this);
        f.put(paramInt1, new bwf((View)localObject2, paramInt3));
        if (localObject1 != localObject2) {
          break label309;
        }
        cvm.b("ConvLayout", "want to REUSE scrolled-in view: index=%d obj=%s", new Object[] { Integer.valueOf(paramInt1), localObject2 });
        label179:
        if (((View)localObject2).getParent() != null) {
          break label336;
        }
        a((View)localObject2, paramBoolean);
        label195:
        rg.d((View)localObject2, rg.g(this));
        a((View)localObject2);
        b = false;
        a("show/measure overlay %d", new Object[] { Integer.valueOf(paramInt1) });
        a("laying out overlay %d with h=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject2).getMeasuredHeight()) });
        paramInt1 = ((View)localObject2).getMeasuredHeight() + paramInt2;
        a((View)localObject2, paramInt2, paramInt1);
        if (paramInt1 <= t) {
          break label449;
        }
      }
      for (;;)
      {
        t = paramInt1;
        return;
        localObject1 = null;
        break;
        label297:
        localObject1 = ((Deque)localObject1).poll();
        break label110;
        label309:
        cvm.b("ConvLayout", "want to CREATE scrolled-in view: index=%d obj=%s", new Object[] { Integer.valueOf(paramInt1), localObject2 });
        break label179;
        label336:
        ((View)localObject2).postInvalidate();
        break label195;
        label344:
        a("move overlay %d", new Object[] { Integer.valueOf(paramInt1) });
        if (!b) {}
        for (paramInt3 = 1;; paramInt3 = 0)
        {
          localObject2 = localObject1;
          if (paramInt3 != 0) {
            break;
          }
          localbxh.b((View)localObject1);
          a((View)localObject1);
          b = false;
          a("and (re)measure overlay %d, old/new heights=%d/%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getHeight()), Integer.valueOf(((View)localObject1).getMeasuredHeight()) });
          localObject2 = localObject1;
          break;
        }
        label449:
        paramInt1 = t;
      }
    }
    if (localObject1 != null)
    {
      a("hide overlay %d", new Object[] { Integer.valueOf(paramInt1) });
      a(paramInt1, (bwf)localObject1, paramInt2, paramInt3);
      if (paramInt3 <= t) {
        break label524;
      }
    }
    for (;;)
    {
      t = paramInt3;
      return;
      a("ignore non-visible overlay %d", new Object[] { Integer.valueOf(paramInt1) });
      break;
      label524:
      paramInt3 = t;
    }
  }
  
  private void a(int paramInt1, bwf parambwf, int paramInt2, int paramInt3)
  {
    f.remove(paramInt1);
    a(parambwf, false);
    a(a, paramInt2, paramInt3);
  }
  
  private final void a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.setAction(paramInt);
    h.onTouchEvent(paramMotionEvent);
    cvm.a("ConvLayout", "in Container.OnTouch. fake: action=%d x/y=%f/%f pointers=%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()), Integer.valueOf(paramMotionEvent.getPointerCount()) });
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2)
  {
    int i1 = d;
    int i2 = d;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i3 = getPaddingLeft();
    i3 = leftMargin + i3;
    paramView.layout(i3, paramInt1 - i1, paramView.getMeasuredWidth() + i3, paramInt2 - i2);
  }
  
  private final void a(bwf parambwf, boolean paramBoolean)
  {
    if (paramBoolean) {
      removeViewInLayout(a);
    }
    e.a(Integer.valueOf(b), a);
    if ((a instanceof bwd)) {
      ((bwd)a).a();
    }
  }
  
  private final int c(int paramInt)
  {
    return (int)(paramInt * j);
  }
  
  public final void a()
  {
    int i2 = f.size();
    int i1 = 0;
    while (i1 < i2)
    {
      a((bwf)f.valueAt(i1), true);
      i1 += 1;
    }
    f.clear();
  }
  
  public final void a(int paramInt)
  {
    r = true;
    a(paramInt, true);
    r = false;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    d = paramInt;
    if (k)
    {
      j = h.getScale();
      a("in positionOverlays, raw scale=%f, effective scale=%f", new Object[] { Float.valueOf(h.getScale()), Float.valueOf(j) });
      if ((c != null) && (b != null)) {
        break label95;
      }
    }
    for (;;)
    {
      return;
      if (j != 0.0F) {
        break;
      }
      j = h.b();
      break;
      label95:
      a("IN positionOverlays, spacerCount=%d overlayCount=%d", new Object[] { Integer.valueOf(c.length), Integer.valueOf(b.getCount()) });
      t = 0;
      paramInt = b.getCount() - 1;
      int i1 = c.length - 1;
      while ((i1 >= 0) && (paramInt >= 0))
      {
        int i8 = c(c[i1].a);
        int i9 = c(c[i1].b);
        int i2;
        int i3;
        int i4;
        int i5;
        label216:
        bxh localbxh;
        bwe localbwe;
        label310:
        label329:
        int i6;
        if (i1 == 0)
        {
          i2 = 48;
          i3 = paramInt;
          i4 = 1;
          if (i4 == 0) {
            break label471;
          }
          i5 = i3 - paramInt;
          localbxh = b.a(i5);
          localbwe = a(localbxh, i8, i9, i2);
          a("in loop, spacer=%d overlay=%d t/b=%d/%d (%s)", new Object[] { Integer.valueOf(i1), Integer.valueOf(i5), Integer.valueOf(a), Integer.valueOf(b), localbxh });
          a(i5, a, b, paramBoolean);
          paramInt -= 1;
          if (paramInt < 0) {
            break label500;
          }
          if (i4 == 0) {
            break label477;
          }
          i5 = i3 - paramInt;
          localbxh = b.a(i5);
          if ((i1 > 0) && (!localbxh.b())) {
            break label500;
          }
          if (i4 == 0) {
            break label483;
          }
          i6 = b;
          label364:
          if (i4 == 0) {
            break label490;
          }
        }
        label471:
        label477:
        label483:
        label490:
        for (int i7 = i9;; i7 = a)
        {
          localbwe = a(localbxh, i6, i7, i2);
          a("in contig loop, spacer=%d overlay=%d t/b=%d/%d (%s)", new Object[] { Integer.valueOf(i1), Integer.valueOf(i5), Integer.valueOf(a), Integer.valueOf(b), localbxh });
          a(i5, a, b, paramBoolean);
          break label310;
          i2 = 0;
          i3 = 0;
          i4 = 0;
          break;
          i5 = paramInt;
          break label216;
          i5 = paramInt;
          break label329;
          i6 = i8;
          break label364;
        }
        label500:
        i1 -= 1;
      }
    }
  }
  
  public final void a(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    ViewGroup.MarginLayoutParams localMarginLayoutParams1 = localMarginLayoutParams2;
    if (localMarginLayoutParams2 == null) {
      localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)generateDefaultLayoutParams();
    }
    int i2 = ViewGroup.getChildMeasureSpec(q, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin, width);
    int i1 = height;
    if (i1 > 0) {}
    for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    paramView = new bwc(this, paramView);
    if (paramBoolean)
    {
      post(paramView);
      return;
    }
    paramView.run();
  }
  
  public final void a(bxp parambxp)
  {
    if (b != null)
    {
      b.unregisterDataSetObserver(s);
      a();
    }
    b = parambxp;
    if (b != null) {
      b.registerDataSetObserver(s);
    }
  }
  
  public final void a(String paramString, Object... paramVarArgs)
  {
    if (r) {
      return;
    }
    cvm.b("ConvLayout", paramString, paramVarArgs);
  }
  
  public final void a(List<Integer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Integer)paramList.next();
      bxh localbxh = b.a(((Integer)localObject).intValue());
      localObject = (bwf)f.get(((Integer)localObject).intValue());
      if ((localObject != null) && (a != null) && (localbxh != null)) {
        localbxh.a(a);
      }
    }
  }
  
  public final void b()
  {
    b.d();
  }
  
  public final void b(int paramInt)
  {
    int i1 = d;
    d = 0;
    bwf localbwf = (bwf)f.get(paramInt);
    int i2;
    if (localbwf != null)
    {
      i2 = getHeight();
      a(paramInt, localbwf, i2, a.getHeight() + i2);
      cvm.c("ConvLayout", "footer scrolled off. container height=%s, measuredHeight=%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(getMeasuredHeight()) });
    }
    for (;;)
    {
      d = i1;
      return;
      cvm.c("ConvLayout", "footer not found with adapterIndex=%s", new Object[] { Integer.valueOf(paramInt) });
      i2 = f.size();
      paramInt = 0;
      while (paramInt < i2)
      {
        int i3 = f.keyAt(paramInt);
        localbwf = (bwf)f.valueAt(paramInt);
        cvm.c("ConvLayout", "OverlayView: adapterIndex=%s, itemType=%s, view=%s", new Object[] { Integer.valueOf(i3), Integer.valueOf(b), a });
        paramInt += 1;
      }
      i2 = b.getCount();
      paramInt = 0;
      while (paramInt < i2)
      {
        cvm.c("ConvLayout", "adapter item: index=%s, item=%s", new Object[] { Integer.valueOf(paramInt), b.a(paramInt) });
        paramInt += 1;
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.MarginLayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    h = ((ConversationWebView)findViewById(buc.aK));
    h.a(this);
    int[] arrayOfInt = a;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    int i3;
    while (i1 < i2)
    {
      i3 = arrayOfInt[i1];
      i.add(findViewById(i3));
      i1 += 1;
    }
    arrayOfInt = g;
    i2 = arrayOfInt.length;
    i1 = 0;
    while (i1 < i2)
    {
      i3 = arrayOfInt[i1];
      i.add(findViewById(i3));
      i1 += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!k) {
      k = true;
    }
    if (h.f) {
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      cvm.b("ConvLayout", "Container is intercepting non-primary touch!", new Object[0]);
      p = true;
      requestDisallowInterceptTouchEvent(true);
      continue;
      m = paramMotionEvent.getY();
      n = paramMotionEvent.getPointerId(0);
      bool = false;
      continue;
      float f1 = paramMotionEvent.getY(paramMotionEvent.findPointerIndex(n));
      if ((int)Math.abs(f1 - m) <= l) {
        break;
      }
      m = f1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    cvm.b("ConvLayout", "*** IN header container onLayout", new Object[0]);
    Iterator localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getVisibility() != 8)
      {
        paramInt1 = localView.getMeasuredWidth();
        paramInt2 = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt3 = leftMargin;
        paramInt4 = topMargin;
        localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      }
    }
    if (b != null)
    {
      paramInt2 = b.getCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        b.a(paramInt1).b = true;
        paramInt1 += 1;
      }
    }
    a(d, false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (cvm.a("ConvLayout", 3)) {
      cvm.b("ConvLayout", "*** IN header container onMeasure spec for w/h=%s/%s", new Object[] { View.MeasureSpec.toString(paramInt1), View.MeasureSpec.toString(paramInt2) });
    }
    Iterator localIterator = i.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (localView.getVisibility() != 8) {
        measureChildWithMargins(localView, paramInt1, 0, paramInt2, 0);
      }
    }
    q = paramInt1;
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (b != null) {
      return b.d();
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if ((i1 == 1) || (i1 == 3)) {}
    for (o = false;; o = true)
    {
      do
      {
        return h.onTouchEvent(paramMotionEvent);
      } while ((o) || ((i1 != 2) && (i1 != 5)));
      a(paramMotionEvent, 0);
      if (p)
      {
        a(paramMotionEvent, 5);
        p = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.browse.ConversationContainer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */