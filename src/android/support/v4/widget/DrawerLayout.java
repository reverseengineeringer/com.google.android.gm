package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;
import java.util.List;
import kn;
import kp;
import pg;
import pl;
import pp;
import qk;
import rg;
import rt;
import sf;
import si;
import wh;
import wi;
import wj;
import wk;
import wl;
import wm;
import wn;
import wp;
import wt;
import yy;

public class DrawerLayout
  extends ViewGroup
  implements wt
{
  public static final int[] a;
  public static final boolean b;
  public static final boolean c;
  static final wj n;
  private int A = 3;
  private int B = 3;
  private boolean C;
  private float D;
  private float E;
  private Drawable F;
  private Drawable G;
  private Object H;
  private boolean I;
  private Drawable J = null;
  private Drawable K = null;
  private Drawable L = null;
  private final ArrayList<View> M;
  public final yy d;
  public final yy e;
  public int f;
  public boolean g;
  @Deprecated
  public wm h;
  public List<wm> i;
  public Drawable j;
  public CharSequence k;
  public CharSequence l;
  public Drawable m = null;
  private final wi o = new wi(this);
  private float p;
  private int q;
  private int r = -1728053248;
  private float s;
  private Paint t = new Paint();
  private final wp u;
  private final wp v;
  private boolean w;
  private boolean x = true;
  private int y = 3;
  private int z = 3;
  
  static
  {
    boolean bool2 = true;
    a = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      b = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label65;
      }
    }
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      c = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label70;
      }
      n = new wk();
      return;
      bool1 = false;
      break;
    }
    label70:
    n = new wl();
  }
  
  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResourcesgetDisplayMetricsdensity;
    q = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    u = new wp(this, 3);
    v = new wp(this, 5);
    d = yy.a(this, 1.0F, u);
    d.i = 1;
    d.g = f2;
    u.b = d;
    e = yy.a(this, 1.0F, v);
    e.i = 2;
    e.g = f2;
    v.b = e;
    setFocusableInTouchMode(true);
    rg.c(this, 1);
    rg.a(this, new wh(this));
    sf.a.a(this, false);
    if (rg.t(this))
    {
      n.a(this);
      j = n.a(paramContext);
    }
    p = (f1 * 10.0F);
    M = new ArrayList();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int i1 = pg.a(paramInt2, rg.g(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i1 == 3)
        {
          localObject = d;
          label67:
          ((yy)localObject).a();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        y = paramInt1;
        break;
        z = paramInt1;
        break;
        A = paramInt1;
        break;
        B = paramInt1;
        break;
        localObject = e;
        break label67;
        localObject = c(i1);
      } while (localObject == null);
      e((View)localObject);
      return;
      localObject = c(i1);
    } while (localObject == null);
    f((View)localObject);
  }
  
  private static boolean a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable == null) || (!kn.b(paramDrawable))) {
      return false;
    }
    kn.a.b(paramDrawable, paramInt);
    return true;
  }
  
  public static float b(View paramView)
  {
    return getLayoutParamsb;
  }
  
  public static String d(int paramInt)
  {
    if ((paramInt & 0x3) == 3) {
      return "LEFT";
    }
    if ((paramInt & 0x5) == 5) {
      return "RIGHT";
    }
    return Integer.toHexString(paramInt);
  }
  
  public static boolean d(View paramView)
  {
    int i1 = pg.a(getLayoutParamsa, rg.g(paramView));
    if ((i1 & 0x3) != 0) {
      return true;
    }
    return (i1 & 0x5) != 0;
  }
  
  private final View e()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((getLayoutParamsd & 0x1) == 1) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  public static boolean g(View paramView)
  {
    if (!d(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return (getLayoutParamsd & 0x1) == 1;
  }
  
  public static boolean h(View paramView)
  {
    if (!d(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return getLayoutParamsb > 0.0F;
  }
  
  public static boolean i(View paramView)
  {
    return (rg.d(paramView) != 4) && (rg.d(paramView) != 2);
  }
  
  private static boolean j(View paramView)
  {
    return getLayoutParamsa == 0;
  }
  
  public final int a(View paramView)
  {
    if (!d(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    return b(getLayoutParamsa);
  }
  
  public final void a()
  {
    if (c) {
      return;
    }
    int i1 = rg.g(this);
    Drawable localDrawable;
    if (i1 == 0)
    {
      if (m == null) {
        break label102;
      }
      a(m, i1);
      localDrawable = m;
      F = localDrawable;
      i1 = rg.g(this);
      if (i1 != 0) {
        break label110;
      }
      if (J == null) {
        break label134;
      }
      a(J, i1);
      localDrawable = J;
    }
    for (;;)
    {
      G = localDrawable;
      return;
      if (J != null)
      {
        a(J, i1);
        localDrawable = J;
        break;
      }
      label102:
      localDrawable = K;
      break;
      label110:
      if (m != null)
      {
        a(m, i1);
        localDrawable = m;
      }
      else
      {
        label134:
        localDrawable = L;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    a(paramInt, 3);
    a(paramInt, 5);
  }
  
  public final void a(View paramView, float paramFloat)
  {
    wn localwn = (wn)paramView.getLayoutParams();
    if (paramFloat == b) {}
    for (;;)
    {
      return;
      b = paramFloat;
      if (i != null)
      {
        int i1 = i.size() - 1;
        while (i1 >= 0)
        {
          ((wm)i.get(i1)).a(paramView, paramFloat);
          i1 -= 1;
        }
      }
    }
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (((!paramBoolean) && (!d(localView))) || ((paramBoolean) && (localView == paramView))) {
        rg.c(localView, 1);
      }
      for (;;)
      {
        i1 += 1;
        break;
        rg.c(localView, 4);
      }
    }
  }
  
  public final void a(Object paramObject, boolean paramBoolean)
  {
    H = paramObject;
    I = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i4 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    if (i2 < i4)
    {
      View localView = getChildAt(i2);
      wn localwn = (wn)localView.getLayoutParams();
      boolean bool = i1;
      int i3;
      if (d(localView)) {
        if (paramBoolean)
        {
          bool = i1;
          if (!c) {}
        }
        else
        {
          i3 = localView.getWidth();
          if (!a(localView, 3)) {
            break label115;
          }
          i1 |= d.a(localView, -i3, localView.getTop());
        }
      }
      for (;;)
      {
        c = false;
        i3 = i1;
        i2 += 1;
        i1 = i3;
        break;
        label115:
        i1 |= e.a(localView, getWidth(), localView.getTop());
      }
    }
    u.b();
    v.b();
    if (i1 != 0) {
      invalidate();
    }
  }
  
  public final boolean a(View paramView, int paramInt)
  {
    return (c(paramView) & paramInt) == paramInt;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i3 = 0;
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int i4 = getChildCount();
    int i1 = 0;
    int i2 = 0;
    View localView;
    if (i1 < i4)
    {
      localView = getChildAt(i1);
      if (d(localView)) {
        if (g(localView))
        {
          i2 = 1;
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        M.add(localView);
      }
    }
    if (i2 == 0)
    {
      i2 = M.size();
      i1 = i3;
      while (i1 < i2)
      {
        localView = (View)M.get(i1);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    M.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((e() != null) || (d(paramView))) {
      rg.c(paramView, 4);
    }
    for (;;)
    {
      if (!b) {
        rg.a(paramView, o);
      }
      return;
      rg.c(paramView, 1);
    }
  }
  
  public final int b(int paramInt)
  {
    int i1 = rg.g(this);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      if (y != 3) {
        return y;
      }
      if (i1 == 0) {}
      for (paramInt = A; paramInt != 3; paramInt = B) {
        return paramInt;
      }
      if (z != 3) {
        return z;
      }
      if (i1 == 0) {}
      for (paramInt = B; paramInt != 3; paramInt = A) {
        return paramInt;
      }
      if (A != 3) {
        return A;
      }
      if (i1 == 0) {}
      for (paramInt = y; paramInt != 3; paramInt = z) {
        return paramInt;
      }
      if (B != 3) {
        return B;
      }
      if (i1 == 0) {}
      for (paramInt = z; paramInt != 3; paramInt = y) {
        return paramInt;
      }
    }
  }
  
  public final void b()
  {
    View localView = c(8388611);
    if (localView == null) {
      throw new IllegalArgumentException("No drawer view found with gravity " + d(8388611));
    }
    e(localView);
  }
  
  public final int c(View paramView)
  {
    return pg.a(getLayoutParamsa, rg.g(this));
  }
  
  public final View c(int paramInt)
  {
    int i1 = pg.a(paramInt, rg.g(this));
    int i2 = getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      View localView = getChildAt(paramInt);
      if ((c(localView) & 0x7) == (i1 & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  public final boolean c()
  {
    View localView = c(8388611);
    if (localView != null) {
      return g(localView);
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof wn)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, getChildAtgetLayoutParamsb);
      i1 += 1;
    }
    s = f1;
    if ((d.c() | e.c())) {
      rg.c(this);
    }
  }
  
  public final View d()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((d(localView)) && (h(localView))) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i7 = getHeight();
    boolean bool1 = j(paramView);
    int i2 = 0;
    int i5 = 0;
    int i1 = getWidth();
    int i8 = paramCanvas.save();
    int i3 = i1;
    int i4;
    View localView;
    if (bool1)
    {
      int i9 = getChildCount();
      i4 = 0;
      i2 = i5;
      if (i4 < i9)
      {
        localView = getChildAt(i4);
        if ((localView != paramView) && (localView.getVisibility() == 0))
        {
          Drawable localDrawable = localView.getBackground();
          if (localDrawable != null) {
            if (localDrawable.getOpacity() == -1)
            {
              i3 = 1;
              label105:
              if ((i3 == 0) || (!d(localView)) || (localView.getHeight() < i7)) {
                break label215;
              }
              if (!a(localView, 3)) {
                break label193;
              }
              i3 = localView.getRight();
              if (i3 <= i2) {
                break label558;
              }
              i2 = i3;
            }
          }
        }
      }
    }
    label193:
    label215:
    label558:
    for (;;)
    {
      i5 = i2;
      i3 = i1;
      for (;;)
      {
        i4 += 1;
        i1 = i3;
        i2 = i5;
        break;
        i3 = 0;
        break label105;
        i3 = 0;
        break label105;
        int i6 = localView.getLeft();
        i3 = i6;
        i5 = i2;
        if (i6 >= i1)
        {
          i3 = i1;
          i5 = i2;
        }
      }
      paramCanvas.clipRect(i2, 0, i1, getHeight());
      i3 = i1;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i8);
      if ((s > 0.0F) && (bool1))
      {
        i1 = (int)(((r & 0xFF000000) >>> 24) * s);
        i4 = r;
        t.setColor(i1 << 24 | i4 & 0xFFFFFF);
        paramCanvas.drawRect(i2, 0.0F, i3, getHeight(), t);
      }
      do
      {
        return bool2;
        if ((F != null) && (a(paramView, 3)))
        {
          i1 = F.getIntrinsicWidth();
          i2 = paramView.getRight();
          i3 = d.h;
          f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
          F.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
          F.setAlpha((int)(255.0F * f1));
          F.draw(paramCanvas);
          return bool2;
        }
      } while ((G == null) || (!a(paramView, 5)));
      i1 = G.getIntrinsicWidth();
      i2 = paramView.getLeft();
      i3 = getWidth();
      i4 = e.h;
      float f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
      G.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      G.setAlpha((int)(255.0F * f1));
      G.draw(paramCanvas);
      return bool2;
    }
  }
  
  public final void e(View paramView)
  {
    if (!d(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    wn localwn = (wn)paramView.getLayoutParams();
    if (x)
    {
      b = 1.0F;
      d = 1;
      a(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      wn.a(localwn, 2);
      if (a(paramView, 3)) {
        d.a(paramView, 0, paramView.getTop());
      } else {
        e.a(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  public final void f(View paramView)
  {
    if (!d(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    wn localwn = (wn)paramView.getLayoutParams();
    if (x)
    {
      b = 0.0F;
      d = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      wn.a(localwn, 4);
      if (a(paramView, 3)) {
        d.a(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        e.a(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new wn();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new wn(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof wn)) {
      return new wn((wn)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new wn((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new wn(paramLayoutParams);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    x = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    x = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((I) && (j != null))
    {
      int i1 = n.a(H);
      if (i1 > 0)
      {
        j.setBounds(0, 0, getWidth(), i1);
        j.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i1 = qk.a(paramMotionEvent);
    boolean bool2 = d.a(paramMotionEvent);
    boolean bool3 = e.a(paramMotionEvent);
    label63:
    int i2;
    label85:
    label113:
    float f1;
    float f2;
    switch (i1)
    {
    default: 
      i1 = 0;
      if ((!(bool3 | bool2)) && (i1 == 0))
      {
        i2 = getChildCount();
        i1 = 0;
        if (i1 >= i2) {
          break label373;
        }
        if (!getChildAtgetLayoutParamsc) {
          break;
        }
        i1 = 1;
        if ((i1 == 0) && (!g)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      D = f1;
      E = f2;
      if (s > 0.0F)
      {
        paramMotionEvent = d.b((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!j(paramMotionEvent))) {}
      }
      break;
    }
    for (i1 = 1;; i1 = 0)
    {
      C = false;
      g = false;
      break label63;
      paramMotionEvent = d;
      int i3 = c.length;
      i2 = 0;
      label214:
      if (i2 < i3) {
        if (paramMotionEvent.a(i2))
        {
          f1 = e[i2] - c[i2];
          f2 = f[i2] - d[i2];
          if (f1 * f1 + f2 * f2 > b * b)
          {
            i1 = 1;
            label286:
            if (i1 == 0) {
              break label331;
            }
          }
        }
      }
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        u.b();
        v.b();
        i1 = 0;
        break label63;
        i1 = 0;
        break label286;
        i1 = 0;
        break label286;
        label331:
        i2 += 1;
        break label214;
      }
      a(true);
      C = false;
      g = false;
      break;
      i1 += 1;
      break label85;
      label373:
      i1 = 0;
      break label113;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (d() != null) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        pl.a.a(paramKeyEvent);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = d();
      if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0)) {
        a(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    w = true;
    int i4 = paramInt3 - paramInt1;
    int i5 = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < i5)
    {
      View localView = getChildAt(paramInt3);
      wn localwn;
      if (localView.getVisibility() != 8)
      {
        localwn = (wn)localView.getLayoutParams();
        if (j(localView)) {
          localView.layout(leftMargin, topMargin, leftMargin + localView.getMeasuredWidth(), topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i6 = localView.getMeasuredWidth();
      int i7 = localView.getMeasuredHeight();
      int i1;
      float f1;
      label163:
      int i2;
      if (a(localView, 3))
      {
        paramInt1 = -i6;
        i1 = (int)(i6 * b) + paramInt1;
        f1 = (i6 + i1) / i6;
        if (f1 == b) {
          break label310;
        }
        i2 = 1;
        label177:
        switch (a & 0x70)
        {
        default: 
          localView.layout(i1, topMargin, i6 + i1, i7 + topMargin);
          label237:
          if (i2 != 0) {
            a(localView, f1);
          }
          if (b <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i1 = i4 - (int)(i6 * b);
        f1 = (i4 - i1) / i6;
        break label163;
        label310:
        i2 = 0;
        break label177;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i1, paramInt1 - bottomMargin - localView.getMeasuredHeight(), i6 + i1, paramInt1 - bottomMargin);
        break label237;
        int i8 = paramInt4 - paramInt2;
        int i3 = (i8 - i7) / 2;
        if (i3 < topMargin) {
          paramInt1 = topMargin;
        }
        for (;;)
        {
          localView.layout(i1, paramInt1, i6 + i1, i7 + paramInt1);
          break;
          paramInt1 = i3;
          if (i3 + i7 > i8 - bottomMargin) {
            paramInt1 = i8 - bottomMargin - i7;
          }
        }
      }
    }
    w = false;
    x = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i2;
    int i1;
    if (i6 == 1073741824)
    {
      i2 = i3;
      if (i5 == 1073741824) {}
    }
    else if (isInEditMode())
    {
      i1 = i3;
      if (i6 != Integer.MIN_VALUE)
      {
        i1 = i3;
        if (i6 == 0) {
          i1 = 300;
        }
      }
      i2 = i1;
      if (i5 == Integer.MIN_VALUE) {
        break label579;
      }
      i2 = i1;
      if (i5 != 0) {
        break label579;
      }
      i3 = 300;
    }
    for (i4 = i1;; i4 = i2)
    {
      setMeasuredDimension(i4, i3);
      label146:
      View localView;
      int i7;
      int i8;
      wn localwn;
      if ((H != null) && (rg.t(this)))
      {
        i5 = 1;
        int i9 = rg.g(this);
        i1 = 0;
        i2 = 0;
        int i10 = getChildCount();
        i6 = 0;
        if (i6 >= i10) {
          break label578;
        }
        localView = getChildAt(i6);
        i7 = i2;
        i8 = i1;
        if (localView.getVisibility() != 8)
        {
          localwn = (wn)localView.getLayoutParams();
          if (i5 != 0)
          {
            i7 = pg.a(a, i9);
            if (!rg.t(localView)) {
              break label322;
            }
            n.a(localView, H, i7);
          }
        }
      }
      for (;;)
      {
        if (!j(localView)) {
          break label341;
        }
        localView.measure(View.MeasureSpec.makeMeasureSpec(i4 - leftMargin - rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - topMargin - bottomMargin, 1073741824));
        i8 = i1;
        i7 = i2;
        i6 += 1;
        i2 = i7;
        i1 = i8;
        break label146;
        throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        i5 = 0;
        break;
        label322:
        n.a(localwn, H, i7);
      }
      label341:
      if (d(localView))
      {
        if ((c) && (rg.a.x(localView) != p)) {
          rg.f(localView, p);
        }
        i8 = c(localView) & 0x7;
        if (i8 == 3) {}
        for (i7 = 1; ((i7 != 0) && (i1 != 0)) || ((i7 == 0) && (i2 != 0)); i7 = 0) {
          throw new IllegalStateException("Child drawer has absolute gravity " + d(i8) + " but this DrawerLayout already has a drawer view along that edge");
        }
        if (i7 != 0) {
          i1 = 1;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, q + leftMargin + rightMargin, width), getChildMeasureSpec(paramInt2, topMargin + bottomMargin, height));
          i7 = i2;
          i8 = i1;
          break;
          i2 = 1;
        }
      }
      throw new IllegalStateException("Child " + localView + " at index " + i6 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      label578:
      return;
      label579:
      i3 = i4;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DrawerLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (DrawerLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (a != 0)
      {
        View localView = c(a);
        if (localView != null) {
          e(localView);
        }
      }
      if (b != 3) {
        a(b, 3);
      }
      if (c != 3) {
        a(c, 5);
      }
      if (d != 3) {
        a(d, 8388611);
      }
    } while (e == 3);
    a(e, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    a();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int i4 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      wn localwn;
      int i2;
      if (i1 < i4)
      {
        localwn = (wn)getChildAt(i1).getLayoutParams();
        if (d != 1) {
          break label119;
        }
        i2 = 1;
        if (d != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int i3 = 1;; i3 = 0)
      {
        if ((i2 == 0) && (i3 == 0)) {
          break label129;
        }
        a = a;
        b = y;
        c = z;
        d = A;
        e = B;
        return localSavedState;
        i2 = 0;
        break;
      }
      label129:
      i1 += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    d.b(paramMotionEvent);
    e.b(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      D = f1;
      E = f2;
      C = false;
      g = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = d.b((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (j(paramMotionEvent)))
      {
        f2 -= D;
        f1 -= E;
        int i1 = d.b;
        if (f2 * f2 + f1 * f1 < i1 * i1)
        {
          paramMotionEvent = e();
          if (paramMotionEvent != null) {
            if (a(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      a(bool);
      C = false;
      return true;
      bool = false;
      continue;
      a(true);
      C = false;
      g = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    C = paramBoolean;
    if (paramBoolean) {
      a(true);
    }
  }
  
  public void requestLayout()
  {
    if (!w) {
      super.requestLayout();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */