import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;

public class yg
  extends ViewGroup
  implements qq, qs
{
  private static final int[] E = { 16842766 };
  private static final String m = yg.class.getSimpleName();
  private boolean A;
  private int B = -1;
  private boolean C;
  private final DecelerateInterpolator D;
  private int F = -1;
  private Animation G;
  private Animation H;
  private Animation I;
  private Animation J;
  private Animation K;
  private int L;
  private int M;
  private Animation.AnimationListener N = new yh(this);
  private final Animation O = new ym(this);
  private final Animation P = new yn(this);
  public yp a;
  boolean b = false;
  int c;
  boolean d;
  vx e;
  public int f;
  float g;
  public int h;
  xd i;
  float j;
  boolean k;
  boolean l;
  private View n;
  private int o;
  private float p = -1.0F;
  private float q;
  private final qt r;
  private final qr s;
  private final int[] t = new int[2];
  private final int[] u = new int[2];
  private boolean v;
  private int w;
  private boolean x = false;
  private float y;
  private float z;
  
  public yg(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public yg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    o = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    w = getResources().getInteger(17694721);
    setWillNotDraw(false);
    D = new DecelerateInterpolator(2.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, E);
    setEnabled(paramContext.getBoolean(0, true));
    paramContext.recycle();
    paramContext = getResources().getDisplayMetrics();
    L = ((int)(density * 40.0F));
    M = ((int)(density * 40.0F));
    e = new vx(getContext());
    i = new xd(getContext(), this);
    i.b.v = -328966;
    e.setImageDrawable(i);
    e.setVisibility(8);
    addView(e);
    rg.a.a(this, true);
    j = (density * 64.0F);
    p = j;
    r = new qt(this);
    s = new qr(this);
    setNestedScrollingEnabled(true);
  }
  
  private static float a(MotionEvent paramMotionEvent, int paramInt)
  {
    paramInt = qk.a(paramMotionEvent, paramInt);
    if (paramInt < 0) {
      return -1.0F;
    }
    return qk.d(paramMotionEvent, paramInt);
  }
  
  private final Animation a(int paramInt1, int paramInt2)
  {
    if ((d) && (c())) {
      return null;
    }
    yk localyk = new yk(this, paramInt1, paramInt2);
    localyk.setDuration(300L);
    e.a = null;
    e.clearAnimation();
    e.startAnimation(localyk);
    return localyk;
  }
  
  private final void a(int paramInt)
  {
    e.getBackground().setAlpha(paramInt);
    i.setAlpha(paramInt);
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = qk.b(paramMotionEvent);
    if (qk.b(paramMotionEvent, i1) == B) {
      if (i1 != 0) {
        break label33;
      }
    }
    label33:
    for (i1 = 1;; i1 = 0)
    {
      B = qk.b(paramMotionEvent, i1);
      return;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (b != paramBoolean1)
    {
      k = paramBoolean2;
      d();
      b = paramBoolean1;
      if (b)
      {
        int i1 = c;
        Animation.AnimationListener localAnimationListener = N;
        f = i1;
        O.reset();
        O.setDuration(200L);
        O.setInterpolator(D);
        if (localAnimationListener != null) {
          e.a = localAnimationListener;
        }
        e.clearAnimation();
        e.startAnimation(O);
      }
    }
    else
    {
      return;
    }
    a(N);
  }
  
  private static boolean a(Animation paramAnimation)
  {
    return (paramAnimation != null) && (paramAnimation.hasStarted()) && (!paramAnimation.hasEnded());
  }
  
  private final void b(float paramFloat)
  {
    i.a(true);
    float f2 = Math.min(1.0F, Math.abs(paramFloat / p));
    float f3 = (float)Math.max(f2 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = p;
    float f1;
    int i1;
    int i2;
    if (l)
    {
      f1 = j - h;
      f4 = Math.max(0.0F, Math.min(f4 - f5, f1 * 2.0F) / f1);
      f4 = (float)(f4 / 4.0F - Math.pow(f4 / 4.0F, 2.0D)) * 2.0F;
      i1 = h;
      i2 = (int)(f1 * f2 + f1 * f4 * 2.0F);
      if (e.getVisibility() != 0) {
        e.setVisibility(0);
      }
      if (!d)
      {
        rg.d(e, 1.0F);
        rg.e(e, 1.0F);
      }
      if (d) {
        a(Math.min(1.0F, paramFloat / p));
      }
      if (paramFloat >= p) {
        break label332;
      }
      if ((i.getAlpha() > 76) && (!a(I))) {
        I = a(i.getAlpha(), 76);
      }
    }
    for (;;)
    {
      i.b(Math.min(0.8F, f3 * 0.8F));
      i.a(Math.min(1.0F, f3));
      i.b.c((-0.25F + f3 * 0.4F + f4 * 2.0F) * 0.5F);
      a(i2 + i1 - c, true);
      return;
      f1 = j;
      break;
      label332:
      if ((i.getAlpha() < 255) && (!a(J))) {
        J = a(i.getAlpha(), 255);
      }
    }
  }
  
  private final void c(float paramFloat)
  {
    if (paramFloat > p)
    {
      a(true, true);
      return;
    }
    b = false;
    i.b(0.0F);
    yl localyl = null;
    if (!d) {
      localyl = new yl(this);
    }
    int i1 = c;
    if (d)
    {
      f = i1;
      if (c())
      {
        g = i.getAlpha();
        K = new yo(this);
        K.setDuration(150L);
        if (localyl != null) {
          e.a = localyl;
        }
        e.clearAnimation();
        e.startAnimation(K);
      }
    }
    for (;;)
    {
      i.a(false);
      return;
      vx localvx = e;
      g = rg.a.r(localvx);
      break;
      f = i1;
      P.reset();
      P.setDuration(200L);
      P.setInterpolator(D);
      if (localyl != null) {
        e.a = localyl;
      }
      e.clearAnimation();
      e.startAnimation(P);
    }
  }
  
  private static boolean c()
  {
    return Build.VERSION.SDK_INT < 11;
  }
  
  private final void d()
  {
    int i1;
    if (n == null) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (!localView.equals(e)) {
          n = localView;
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  final void a()
  {
    e.clearAnimation();
    i.stop();
    e.setVisibility(8);
    a(255);
    if (d) {
      a(0.0F);
    }
    for (;;)
    {
      c = e.getTop();
      return;
      a(h - c, true);
    }
  }
  
  final void a(float paramFloat)
  {
    if (c())
    {
      a((int)(255.0F * paramFloat));
      return;
    }
    rg.d(e, paramFloat);
    rg.e(e, paramFloat);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    e.bringToFront();
    e.offsetTopAndBottom(paramInt);
    c = e.getTop();
    if ((paramBoolean) && (Build.VERSION.SDK_INT < 11)) {
      invalidate();
    }
  }
  
  final void a(Animation.AnimationListener paramAnimationListener)
  {
    H = new yj(this);
    H.setDuration(150L);
    e.a = paramAnimationListener;
    e.clearAnimation();
    e.startAnimation(H);
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (b != paramBoolean))
    {
      b = paramBoolean;
      if (!l) {}
      for (int i1 = (int)(j + h);; i1 = (int)j)
      {
        a(i1 - c, true);
        k = false;
        Animation.AnimationListener localAnimationListener = N;
        e.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 11) {
          i.setAlpha(255);
        }
        G = new yi(this);
        G.setDuration(w);
        if (localAnimationListener != null) {
          e.a = localAnimationListener;
        }
        e.clearAnimation();
        e.startAnimation(G);
        return;
      }
    }
    a(paramBoolean, false);
  }
  
  public final void a(int... paramVarArgs)
  {
    Resources localResources = getResources();
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i1 = 0;
    while (i1 < paramVarArgs.length)
    {
      arrayOfInt[i1] = localResources.getColor(paramVarArgs[i1]);
      i1 += 1;
    }
    d();
    paramVarArgs = i;
    b.a(arrayOfInt);
    b.a(0);
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT < 14)
    {
      if ((n instanceof AbsListView))
      {
        AbsListView localAbsListView = (AbsListView)n;
        return (localAbsListView.getChildCount() > 0) && ((localAbsListView.getFirstVisiblePosition() > 0) || (localAbsListView.getChildAt(0).getTop() < localAbsListView.getPaddingTop()));
      }
      return (rg.b(n, -1)) || (n.getScrollY() > 0);
    }
    return rg.b(n, -1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return s.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return s.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return s.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return s.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (F < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return F;
      }
    } while (paramInt2 < F);
    return paramInt2 + 1;
  }
  
  public int getNestedScrollAxes()
  {
    return r.a;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return s.a();
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return s.a;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    d();
    int i1 = qk.a(paramMotionEvent);
    if ((C) && (i1 == 0)) {
      C = false;
    }
    if ((!isEnabled()) || (C) || (b()) || (b) || (v)) {
      return false;
    }
    switch (i1)
    {
    }
    for (;;)
    {
      return A;
      a(h - e.getTop(), true);
      B = qk.b(paramMotionEvent, 0);
      A = false;
      float f1 = a(paramMotionEvent, B);
      if (f1 == -1.0F) {
        break;
      }
      z = f1;
      continue;
      if (B == -1)
      {
        Log.e(m, "Got ACTION_MOVE event but don't have an active pointer id.");
        return false;
      }
      f1 = a(paramMotionEvent, B);
      if (f1 == -1.0F) {
        break;
      }
      if ((f1 - z > o) && (!A))
      {
        y = (z + o);
        A = true;
        i.setAlpha(76);
        continue;
        a(paramMotionEvent);
        continue;
        A = false;
        B = -1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0) {}
    do
    {
      return;
      if (n == null) {
        d();
      }
    } while (n == null);
    View localView = n;
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    localView.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt2 = e.getMeasuredWidth();
    paramInt3 = e.getMeasuredHeight();
    e.layout(paramInt1 / 2 - paramInt2 / 2, c, paramInt1 / 2 + paramInt2 / 2, c + paramInt3);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (n == null) {
      d();
    }
    if (n == null) {}
    for (;;)
    {
      return;
      n.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
      e.measure(View.MeasureSpec.makeMeasureSpec(L, 1073741824), View.MeasureSpec.makeMeasureSpec(M, 1073741824));
      if ((!l) && (!x))
      {
        x = true;
        paramInt1 = -e.getMeasuredHeight();
        h = paramInt1;
        c = paramInt1;
      }
      F = -1;
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        if (getChildAt(paramInt1) == e)
        {
          F = paramInt1;
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramInt2 > 0) && (q > 0.0F))
    {
      if (paramInt2 <= q) {
        break label141;
      }
      paramArrayOfInt[1] = (paramInt2 - (int)q);
      q = 0.0F;
    }
    for (;;)
    {
      b(q);
      if ((l) && (paramInt2 > 0) && (q == 0.0F) && (Math.abs(paramInt2 - paramArrayOfInt[1]) > 0)) {
        e.setVisibility(8);
      }
      paramView = t;
      if (dispatchNestedPreScroll(paramInt1 - paramArrayOfInt[0], paramInt2 - paramArrayOfInt[1], paramView, null))
      {
        paramArrayOfInt[0] += paramView[0];
        paramInt1 = paramArrayOfInt[1];
        paramView[1] += paramInt1;
      }
      return;
      label141:
      q -= paramInt2;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, u);
    paramInt1 = u[1] + paramInt4;
    if ((paramInt1 < 0) && (!b()))
    {
      float f1 = q;
      q = (Math.abs(paramInt1) + f1);
      b(q);
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    r.a = paramInt;
    startNestedScroll(paramInt & 0x2);
    q = 0.0F;
    v = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (isEnabled()) && (!C) && (!b) && ((paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    r.a = 0;
    v = false;
    if (q > 0.0F)
    {
      c(q);
      q = 0.0F;
    }
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = qk.a(paramMotionEvent);
    if ((C) && (i1 == 0)) {
      C = false;
    }
    if ((!isEnabled()) || (C) || (b()) || (v)) {
      return false;
    }
    switch (i1)
    {
    case 3: 
    case 4: 
    default: 
    case 0: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        return true;
        B = qk.b(paramMotionEvent, 0);
        A = false;
        continue;
        i1 = qk.a(paramMotionEvent, B);
        if (i1 < 0)
        {
          Log.e(m, "Got ACTION_MOVE event but have an invalid active pointer id.");
          return false;
        }
        f1 = (qk.d(paramMotionEvent, i1) - y) * 0.5F;
        if (A)
        {
          if (f1 <= 0.0F) {
            break;
          }
          b(f1);
          continue;
          i1 = qk.b(paramMotionEvent);
          if (i1 < 0)
          {
            Log.e(m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
            return false;
          }
          B = qk.b(paramMotionEvent, i1);
          continue;
          a(paramMotionEvent);
        }
      }
    }
    i1 = qk.a(paramMotionEvent, B);
    if (i1 < 0)
    {
      Log.e(m, "Got ACTION_UP event but don't have an active pointer id.");
      return false;
    }
    float f1 = qk.d(paramMotionEvent, i1);
    float f2 = y;
    A = false;
    c((f1 - f2) * 0.5F);
    B = -1;
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 21) || (!(n instanceof AbsListView))) {
      if (n != null)
      {
        View localView = n;
        if (!rg.a.C(localView)) {}
      }
      else
      {
        super.requestDisallowInterceptTouchEvent(paramBoolean);
      }
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    s.a(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return s.a(paramInt);
  }
  
  public void stopNestedScroll()
  {
    s.b();
  }
}

/* Location:
 * Qualified Name:     yg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */