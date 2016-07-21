package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;
import qk;
import qq;
import qr;
import qs;
import qt;
import ra;
import rc;
import rg;
import wu;
import xi;
import xj;
import xu;
import xv;

public class NestedScrollView
  extends FrameLayout
  implements qq, qs, ra
{
  private static final xi w = new xi();
  private static final int[] x = { 16843130 };
  private float A;
  public xj a;
  private long b;
  private final Rect c = new Rect();
  private xu d = xu.a(getContext(), null);
  private wu e;
  private wu f;
  private int g;
  private boolean h = true;
  private boolean i = false;
  private View j = null;
  private boolean k = false;
  private VelocityTracker l;
  private boolean m;
  private boolean n = true;
  private int o;
  private int p;
  private int q;
  private int r = -1;
  private final int[] s = new int[2];
  private final int[] t = new int[2];
  private int u;
  private NestedScrollView.SavedState v;
  private final qt y;
  private final qr z;
  
  public NestedScrollView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    o = localViewConfiguration.getScaledTouchSlop();
    p = localViewConfiguration.getScaledMinimumFlingVelocity();
    q = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x, paramInt, 0);
    boolean bool = paramContext.getBoolean(0, false);
    if (bool != m)
    {
      m = bool;
      requestLayout();
    }
    paramContext.recycle();
    y = new qt(this);
    z = new qr(this);
    setNestedScrollingEnabled(true);
    rg.a(this, w);
  }
  
  private final int a(Rect paramRect)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    int i4 = getHeight();
    int i1 = getScrollY();
    int i3 = i1 + i4;
    int i5 = getVerticalFadingEdgeLength();
    int i2 = i1;
    if (top > 0) {
      i2 = i1 + i5;
    }
    i1 = i3;
    if (bottom < getChildAt(0).getHeight()) {
      i1 = i3 - i5;
    }
    if ((bottom > i1) && (top > i2)) {
      if (paramRect.height() > i4)
      {
        i2 = top - i2 + 0;
        i1 = Math.min(i2, getChildAt(0).getBottom() - i1);
      }
    }
    for (;;)
    {
      return i1;
      i2 = bottom - i1 + 0;
      break;
      if ((top < i2) && (bottom < i1))
      {
        if (paramRect.height() > i4) {}
        for (i1 = 0 - (i1 - bottom);; i1 = 0 - (i2 - top))
        {
          i1 = Math.max(i1, -getScrollY());
          break;
        }
      }
      i1 = 0;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - b > 250L)
    {
      paramInt1 = getHeight();
      int i1 = getPaddingBottom();
      int i2 = getPaddingTop();
      i1 = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i1 - i2));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt1 + paramInt2, i1));
      xu localxu = d;
      i1 = getScrollX();
      b.a(a, i1, paramInt1, 0, paramInt2 - paramInt1);
      rg.c(this);
    }
    for (;;)
    {
      b = AnimationUtils.currentAnimationTimeMillis();
      return;
      if (!d.a()) {
        d.h();
      }
      scrollBy(paramInt1, paramInt2);
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (qk.b(paramMotionEvent, i1) == r) {
      if (i1 != 0) {
        break label64;
      }
    }
    label64:
    for (i1 = 1;; i1 = 0)
    {
      g = ((int)qk.d(paramMotionEvent, i1));
      r = qk.b(paramMotionEvent, i1);
      if (l != null) {
        l.clear();
      }
      return;
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = getHeight();
    int i6 = getScrollY();
    int i7 = i6 + i1;
    int i3;
    Object localObject1;
    int i4;
    label53:
    Object localObject2;
    int i5;
    int i9;
    int i2;
    if (paramInt1 == 33)
    {
      i3 = 1;
      ArrayList localArrayList = getFocusables(2);
      localObject1 = null;
      i1 = 0;
      int i8 = localArrayList.size();
      i4 = 0;
      if (i4 >= i8) {
        break label237;
      }
      localObject2 = (View)localArrayList.get(i4);
      i5 = ((View)localObject2).getTop();
      i9 = ((View)localObject2).getBottom();
      if ((paramInt2 >= i9) || (i5 >= paramInt3)) {
        break label312;
      }
      if ((paramInt2 >= i5) || (i9 >= paramInt3)) {
        break label143;
      }
      i2 = 1;
      label115:
      if (localObject1 != null) {
        break label149;
      }
      localObject1 = localObject2;
      i1 = i2;
    }
    label143:
    label149:
    label210:
    label237:
    label312:
    for (;;)
    {
      i4 += 1;
      break label53;
      i3 = 0;
      break;
      i2 = 0;
      break label115;
      if (((i3 != 0) && (i5 < ((View)localObject1).getTop())) || ((i3 == 0) && (i9 > ((View)localObject1).getBottom()))) {}
      for (i5 = 1;; i5 = 0)
      {
        if (i1 == 0) {
          break label210;
        }
        if ((i2 == 0) || (i5 == 0)) {
          break label312;
        }
        localObject1 = localObject2;
        break;
      }
      if (i2 != 0)
      {
        localObject1 = localObject2;
        i1 = 1;
      }
      else if (i5 != 0)
      {
        localObject1 = localObject2;
        continue;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = this;
        }
        boolean bool;
        if ((paramInt2 >= i6) && (paramInt3 <= i7))
        {
          bool = false;
          if (localObject2 != findFocus()) {
            ((View)localObject2).requestFocus(paramInt1);
          }
          return bool;
        }
        if (i3 != 0) {
          paramInt2 -= i6;
        }
        for (;;)
        {
          d(paramInt2);
          bool = true;
          break;
          paramInt2 = paramInt3 - i7;
        }
      }
    }
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool3 = false;
    rg.a(this);
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    paramInt1 = paramInt3 + paramInt1;
    paramInt2 = paramInt4 + paramInt2;
    paramInt3 = paramInt5 + 0;
    boolean bool1;
    if (paramInt1 > 0)
    {
      bool1 = true;
      paramInt1 = 0;
    }
    for (;;)
    {
      boolean bool2;
      if (paramInt2 > paramInt3)
      {
        paramInt2 = paramInt3;
        bool2 = true;
      }
      for (;;)
      {
        if (bool2) {
          d.a(paramInt1, paramInt2, a());
        }
        onOverScrolled(paramInt1, paramInt2, bool1, bool2);
        if (!bool1)
        {
          bool1 = bool3;
          if (!bool2) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
        if (paramInt1 >= 0) {
          break label140;
        }
        bool1 = true;
        paramInt1 = 0;
        break;
        if (paramInt2 < 0)
        {
          bool2 = true;
          paramInt2 = 0;
        }
        else
        {
          bool2 = false;
        }
      }
      label140:
      bool1 = false;
    }
  }
  
  private final boolean a(View paramView)
  {
    boolean bool = false;
    if (!a(paramView, 0, getHeight())) {
      bool = true;
    }
    return bool;
  }
  
  private final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(c);
    offsetDescendantRectToMyCoords(paramView, c);
    return (c.bottom + paramInt1 >= getScrollY()) && (c.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
      i1 = 0;
    }
    do
    {
      return i1;
      i1 = paramInt1;
    } while (paramInt2 + paramInt1 <= paramInt3);
    return paramInt3 - paramInt2;
  }
  
  private final void b()
  {
    if (l == null) {
      l = VelocityTracker.obtain();
    }
  }
  
  private final void b(View paramView)
  {
    paramView.getDrawingRect(c);
    offsetDescendantRectToMyCoords(paramView, c);
    int i1 = a(c);
    if (i1 != 0) {
      scrollBy(0, i1);
    }
  }
  
  private final boolean b(int paramInt)
  {
    if (paramInt == 130) {}
    for (int i1 = 1;; i1 = 0)
    {
      int i2 = getHeight();
      c.top = 0;
      c.bottom = i2;
      if (i1 != 0)
      {
        i1 = getChildCount();
        if (i1 > 0)
        {
          View localView = getChildAt(i1 - 1);
          c.bottom = (localView.getBottom() + getPaddingBottom());
          c.top = (c.bottom - i2);
        }
      }
      return a(paramInt, c.top, c.bottom);
    }
  }
  
  private final void c()
  {
    if (l != null)
    {
      l.recycle();
      l = null;
    }
  }
  
  private final boolean c(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i2 = (int)(0.5F * getHeight());
    if ((localView2 != null) && (a(localView2, i2, getHeight())))
    {
      localView2.getDrawingRect(c);
      offsetDescendantRectToMyCoords(localView2, c);
      d(a(c));
      localView2.requestFocus(paramInt);
      if ((localView1 != null) && (localView1.isFocused()) && (a(localView1)))
      {
        paramInt = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(paramInt);
      }
      return true;
    }
    int i1;
    if ((paramInt == 33) && (getScrollY() < i2)) {
      i1 = getScrollY();
    }
    while (i1 == 0)
    {
      return false;
      i1 = i2;
      if (paramInt == 130)
      {
        i1 = i2;
        if (getChildCount() > 0)
        {
          int i3 = getChildAt(0).getBottom();
          int i4 = getScrollY() + getHeight() - getPaddingBottom();
          i1 = i2;
          if (i3 - i4 < i2) {
            i1 = i3 - i4;
          }
        }
      }
    }
    if (paramInt == 130) {}
    for (;;)
    {
      d(i1);
      break;
      i1 = -i1;
    }
  }
  
  private final void d()
  {
    k = false;
    c();
    stopNestedScroll();
    if (e != null)
    {
      e.c();
      f.c();
    }
  }
  
  private final void d(int paramInt)
  {
    if (paramInt != 0)
    {
      if (n) {
        a(0, paramInt);
      }
    }
    else {
      return;
    }
    scrollBy(0, paramInt);
  }
  
  private final void e()
  {
    if (rg.a(this) != 2)
    {
      if (e == null)
      {
        Context localContext = getContext();
        e = new wu(localContext);
        f = new wu(localContext);
      }
      return;
    }
    e = null;
    f = null;
  }
  
  private final void e(int paramInt)
  {
    int i1 = getScrollY();
    if (((i1 > 0) || (paramInt > 0)) && ((i1 < a()) || (paramInt < 0))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!dispatchNestedPreFling(0.0F, paramInt))
      {
        dispatchNestedFling(0.0F, paramInt, bool);
        if ((bool) && (getChildCount() > 0))
        {
          int i3 = getHeight() - getPaddingBottom() - getPaddingTop();
          int i4 = getChildAt(0).getHeight();
          xu localxu = d;
          i1 = getScrollX();
          int i2 = getScrollY();
          i4 = Math.max(0, i4 - i3);
          i3 /= 2;
          b.a(a, i1, i2, 0, paramInt, 0, 0, 0, i4, 0, i3);
          rg.c(this);
        }
      }
      return;
    }
  }
  
  public final int a()
  {
    int i1 = 0;
    if (getChildCount() > 0) {
      i1 = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i1;
  }
  
  public final void a(int paramInt)
  {
    a(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    c.setEmpty();
    View localView = getChildAt(0);
    int i1;
    boolean bool1;
    if (localView != null)
    {
      i1 = localView.getHeight();
      if (getHeight() < i1 + getPaddingTop() + getPaddingBottom())
      {
        i1 = 1;
        if (i1 != 0) {
          break label151;
        }
        bool1 = bool2;
        if (isFocused())
        {
          bool1 = bool2;
          if (paramKeyEvent.getKeyCode() != 4)
          {
            localView = findFocus();
            paramKeyEvent = localView;
            if (localView == this) {
              paramKeyEvent = null;
            }
            paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
            bool1 = bool2;
            if (paramKeyEvent != null)
            {
              bool1 = bool2;
              if (paramKeyEvent != this)
              {
                bool1 = bool2;
                if (paramKeyEvent.requestFocus(130)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    label151:
    do
    {
      return bool1;
      i1 = 0;
      break;
      i1 = 0;
      break;
      bool1 = bool2;
    } while (paramKeyEvent.getAction() != 0);
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 19: 
      if (!paramKeyEvent.isAltPressed()) {
        return c(33);
      }
      return b(33);
    case 20: 
      if (!paramKeyEvent.isAltPressed()) {
        return c(130);
      }
      return b(130);
    }
    int i2;
    label265:
    int i3;
    if (paramKeyEvent.isShiftPressed())
    {
      i1 = 33;
      if (i1 != 130) {
        break label383;
      }
      i2 = 1;
      i3 = getHeight();
      if (i2 == 0) {
        break label388;
      }
      c.top = (getScrollY() + i3);
      i2 = getChildCount();
      if (i2 > 0)
      {
        paramKeyEvent = getChildAt(i2 - 1);
        if (c.top + i3 > paramKeyEvent.getBottom()) {
          c.top = (paramKeyEvent.getBottom() - i3);
        }
      }
    }
    for (;;)
    {
      c.bottom = (i3 + c.top);
      a(i1, c.top, c.bottom);
      return false;
      i1 = 130;
      break;
      label383:
      i2 = 0;
      break label265;
      label388:
      c.top = (getScrollY() - i3);
      if (c.top < 0) {
        c.top = 0;
      }
    }
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("ScrollView can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    int i3;
    int i5;
    int i6;
    int i1;
    if (d.g())
    {
      int i2 = getScrollX();
      i3 = getScrollY();
      int i4 = d.b();
      i5 = d.c();
      if ((i2 != i4) || (i3 != i5))
      {
        i6 = a();
        i1 = rg.a(this);
        if ((i1 != 0) && ((i1 != 1) || (i6 <= 0))) {
          break label128;
        }
        i1 = 1;
        a(i4 - i2, i5 - i3, i2, i3, i6);
        if (i1 != 0)
        {
          e();
          if ((i5 > 0) || (i3 <= 0)) {
            break label133;
          }
          e.a((int)d.f());
        }
      }
    }
    label128:
    label133:
    while ((i5 < i6) || (i3 >= i6))
    {
      return;
      i1 = 0;
      break;
    }
    f.a((int)d.f());
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int i2 = getChildCount();
    int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i2 == 0) {}
    int i3;
    int i4;
    do
    {
      return i1;
      i2 = getChildAt(0).getBottom();
      i3 = getScrollY();
      i4 = Math.max(0, i2 - i1);
      if (i3 < 0) {
        return i2 - i3;
      }
      i1 = i2;
    } while (i3 <= i4);
    return i2 + (i3 - i4);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return z.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return z.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return z.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return z.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (e != null)
    {
      int i1 = getScrollY();
      int i2;
      int i3;
      int i4;
      if (!e.a())
      {
        i2 = paramCanvas.save();
        i3 = getWidth();
        i4 = getPaddingLeft();
        int i5 = getPaddingRight();
        paramCanvas.translate(getPaddingLeft(), Math.min(0, i1));
        e.a(i3 - i4 - i5, getHeight());
        if (e.a(paramCanvas)) {
          rg.c(this);
        }
        paramCanvas.restoreToCount(i2);
      }
      if (!f.a())
      {
        i2 = paramCanvas.save();
        i3 = getWidth() - getPaddingLeft() - getPaddingRight();
        i4 = getHeight();
        paramCanvas.translate(-i3 + getPaddingLeft(), Math.max(a(), i1) + i4);
        paramCanvas.rotate(180.0F, i3, 0.0F);
        f.a(i3, i4);
        if (f.a(paramCanvas)) {
          rg.c(this);
        }
        paramCanvas.restoreToCount(i2);
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    i2 = getChildAt(0).getBottom() - getScrollY() - (i2 - i3);
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public int getNestedScrollAxes()
  {
    return y.a;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getScrollY();
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return z.a();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return z.a;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + paramInt2, width);
    paramInt2 = topMargin;
    paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(bottomMargin + paramInt2, 0));
  }
  
  public void onAttachedToWindow()
  {
    i = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((qk.d(paramMotionEvent) & 0x2) != 0) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return false;
      if (!k)
      {
        float f1 = qk.e(paramMotionEvent, 9);
        if (f1 != 0.0F)
        {
          if (A == 0.0F)
          {
            paramMotionEvent = new TypedValue();
            Context localContext = getContext();
            if (!localContext.getTheme().resolveAttribute(16842829, paramMotionEvent, true)) {
              throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            A = paramMotionEvent.getDimension(localContext.getResources().getDisplayMetrics());
          }
          int i1 = (int)(f1 * A);
          int i2 = a();
          int i4 = getScrollY();
          int i3 = i4 - i1;
          if (i3 < 0) {
            i1 = 0;
          }
          while (i1 != i4)
          {
            super.scrollTo(getScrollX(), i1);
            return true;
            i1 = i2;
            if (i3 <= i2) {
              i1 = i3;
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (k)) {
      return true;
    }
    switch (i1 & 0xFF)
    {
    }
    for (;;)
    {
      return k;
      i1 = r;
      if (i1 != -1)
      {
        int i2 = qk.a(paramMotionEvent, i1);
        if (i2 == -1)
        {
          Log.e("NestedScrollView", "Invalid pointerId=" + i1 + " in onInterceptTouchEvent");
        }
        else
        {
          i1 = (int)qk.d(paramMotionEvent, i2);
          if ((Math.abs(i1 - g) > o) && ((getNestedScrollAxes() & 0x2) == 0))
          {
            k = true;
            g = i1;
            b();
            l.addMovement(paramMotionEvent);
            u = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null)
            {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
              continue;
              i2 = (int)paramMotionEvent.getY();
              i1 = (int)paramMotionEvent.getX();
              if (getChildCount() > 0)
              {
                int i3 = getScrollY();
                View localView = getChildAt(0);
                if ((i2 >= localView.getTop() - i3) && (i2 < localView.getBottom() - i3) && (i1 >= localView.getLeft()) && (i1 < localView.getRight())) {
                  i1 = 1;
                }
              }
              for (;;)
              {
                if (i1 != 0) {
                  break label307;
                }
                k = false;
                c();
                break;
                i1 = 0;
                continue;
                i1 = 0;
              }
              label307:
              g = i2;
              r = qk.b(paramMotionEvent, 0);
              if (l == null)
              {
                l = VelocityTracker.obtain();
                label335:
                l.addMovement(paramMotionEvent);
                d.g();
                if (d.a()) {
                  break label386;
                }
              }
              for (;;)
              {
                k = bool;
                startNestedScroll(2);
                break;
                l.clear();
                break label335;
                label386:
                bool = false;
              }
              k = false;
              r = -1;
              c();
              if (d.a(getScrollX(), getScrollY(), a())) {
                rg.c(this);
              }
              stopNestedScroll();
              continue;
              a(paramMotionEvent);
            }
          }
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    h = false;
    if ((j != null) && (a(j, this))) {
      b(j);
    }
    j = null;
    if (!i)
    {
      if (v != null)
      {
        scrollTo(getScrollX(), v.a);
        v = null;
      }
      if (getChildCount() <= 0) {
        break label153;
      }
      paramInt1 = getChildAt(0).getMeasuredHeight();
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() <= paramInt1) {
        break label158;
      }
      scrollTo(getScrollX(), paramInt1);
    }
    for (;;)
    {
      scrollTo(getScrollX(), getScrollY());
      i = true;
      return;
      label153:
      paramInt1 = 0;
      break;
      label158:
      if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!m) {}
    View localView;
    do
    {
      do
      {
        return;
      } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
      localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
    } while (localView.getMeasuredHeight() >= paramInt2);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
    localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      e((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    y.a = paramInt;
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1;
    View localView;
    if (paramInt == 2)
    {
      i1 = 130;
      if (paramRect != null) {
        break label44;
      }
      localView = FocusFinder.getInstance().findNextFocus(this, null, i1);
      label24:
      if (localView != null) {
        break label58;
      }
    }
    label44:
    label58:
    while (a(localView))
    {
      return false;
      i1 = paramInt;
      if (paramInt != 1) {
        break;
      }
      i1 = 33;
      break;
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i1);
      break label24;
    }
    return localView.requestFocus(i1, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof NestedScrollView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (NestedScrollView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    v = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    NestedScrollView.SavedState localSavedState = new NestedScrollView.SavedState(super.onSaveInstanceState());
    a = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (a != null) {
      a.a(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if ((localView == null) || (this == localView)) {}
    while (!a(localView, 0, paramInt4)) {
      return;
    }
    localView.getDrawingRect(c);
    offsetDescendantRectToMyCoords(localView, c);
    d(a(c));
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    y.a = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i1 = qk.a(paramMotionEvent);
    if (i1 == 0) {
      u = 0;
    }
    localMotionEvent.offsetLocation(0.0F, u);
    int i3;
    int i4;
    int i2;
    switch (i1)
    {
    case 4: 
    default: 
    case 0: 
    case 2: 
      ViewParent localViewParent;
      for (;;)
      {
        if (l != null) {
          l.addMovement(localMotionEvent);
        }
        localMotionEvent.recycle();
        return true;
        if (getChildCount() == 0) {
          return false;
        }
        if (!d.a()) {}
        for (boolean bool = true;; bool = false)
        {
          k = bool;
          if (bool)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
          }
          if (!d.a()) {
            d.h();
          }
          g = ((int)paramMotionEvent.getY());
          r = qk.b(paramMotionEvent, 0);
          startNestedScroll(2);
          break;
        }
        i3 = qk.a(paramMotionEvent, r);
        if (i3 != -1) {
          break;
        }
        Log.e("NestedScrollView", "Invalid pointerId=" + r + " in onTouchEvent");
      }
      i4 = (int)qk.d(paramMotionEvent, i3);
      i2 = g - i4;
      i1 = i2;
      if (dispatchNestedPreScroll(0, i2, t, s))
      {
        i1 = i2 - t[1];
        localMotionEvent.offsetLocation(0.0F, s[1]);
        u += s[1];
      }
      if ((!k) && (Math.abs(i1) > o))
      {
        localViewParent = getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
        k = true;
        if (i1 > 0) {
          i1 -= o;
        }
      }
      break;
    }
    label383:
    while (k)
    {
      g = (i4 - s[1]);
      int i5 = getScrollY();
      i4 = a();
      i2 = rg.a(this);
      if ((i2 == 0) || ((i2 == 1) && (i4 > 0))) {}
      for (i2 = 1;; i2 = 0)
      {
        if ((a(0, i1, 0, getScrollY(), i4)) && (!hasNestedScrollingParent())) {
          l.clear();
        }
        int i6 = getScrollY() - i5;
        if (!dispatchNestedScroll(0, i6, 0, i1 - i6, s)) {
          break label555;
        }
        g -= s[1];
        localMotionEvent.offsetLocation(0.0F, s[1]);
        u += s[1];
        break;
        i1 += o;
        break label383;
      }
      label555:
      if (i2 == 0) {
        break;
      }
      e();
      i2 = i5 + i1;
      if (i2 < 0)
      {
        e.a(i1 / getHeight(), qk.c(paramMotionEvent, i3) / getWidth());
        if (!f.a()) {
          f.c();
        }
      }
      while ((e != null) && ((!e.a()) || (!f.a())))
      {
        rg.c(this);
        break;
        if (i2 > i4)
        {
          f.a(i1 / getHeight(), 1.0F - qk.c(paramMotionEvent, i3) / getWidth());
          if (!e.a()) {
            e.c();
          }
        }
      }
      if (k)
      {
        paramMotionEvent = l;
        paramMotionEvent.computeCurrentVelocity(1000, q);
        i1 = (int)rc.b(paramMotionEvent, r);
        if (Math.abs(i1) <= p) {
          break label772;
        }
        e(-i1);
      }
      for (;;)
      {
        r = -1;
        d();
        break;
        label772:
        if (d.a(getScrollX(), getScrollY(), a())) {
          rg.c(this);
        }
      }
      if ((k) && (getChildCount() > 0) && (d.a(getScrollX(), getScrollY(), a()))) {
        rg.c(this);
      }
      r = -1;
      d();
      break;
      i1 = qk.b(paramMotionEvent);
      g = ((int)qk.d(paramMotionEvent, i1));
      r = qk.b(paramMotionEvent, i1);
      break;
      a(paramMotionEvent);
      g = ((int)qk.d(paramMotionEvent, qk.a(paramMotionEvent, r)));
      break;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!h) {
      b(paramView2);
    }
    for (;;)
    {
      super.requestChildFocus(paramView1, paramView2);
      return;
      j = paramView2;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i1 = a(paramRect);
    if (i1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (!paramBoolean) {
          break;
        }
        scrollBy(0, i1);
      }
      return bool;
    }
    a(0, i1);
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    h = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = b(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = b(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    z.a(paramBoolean);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return z.a(paramInt);
  }
  
  public void stopNestedScroll()
  {
    z.b();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */