package android.support.v7.widget;

import aca;
import acf;
import aek;
import aew;
import aex;
import aey;
import aez;
import afa;
import ahv;
import ahw;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import ane;
import qs;
import qt;
import rg;
import tg;
import tw;
import xu;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements ahv, qs
{
  static final int[] j = { aca.b, 16842841 };
  private final Runnable A = new aey(this);
  private final qt B;
  public int a = 0;
  public ActionBarContainer b;
  public boolean c;
  public boolean d;
  public boolean e;
  public int f;
  public aez g;
  public tg h;
  public final tw i = new aew(this);
  private int k;
  private ContentFrameLayout l;
  private ahw m;
  private Drawable n;
  private boolean o;
  private boolean p;
  private int q;
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private final Rect u = new Rect();
  private final Rect v = new Rect();
  private final Rect w = new Rect();
  private final int x = 600;
  private xu y;
  private final Runnable z = new aex(this);
  
  public ActionBarOverlayLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    B = new qt(this);
  }
  
  public static void a() {}
  
  private final void a(Context paramContext)
  {
    boolean bool2 = true;
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(j);
    k = localTypedArray.getDimensionPixelSize(0, 0);
    n = localTypedArray.getDrawable(1);
    if (n == null)
    {
      bool1 = true;
      setWillNotDraw(bool1);
      localTypedArray.recycle();
      if (getApplicationInfotargetSdkVersion >= 19) {
        break label91;
      }
    }
    label91:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      o = bool1;
      y = xu.a(paramContext, null);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    boolean bool = false;
    paramView = (afa)paramView.getLayoutParams();
    if (leftMargin != left)
    {
      leftMargin = left;
      bool = true;
    }
    if (topMargin != top)
    {
      topMargin = top;
      bool = true;
    }
    if (rightMargin != right)
    {
      rightMargin = right;
      bool = true;
    }
    if ((paramBoolean) && (bottomMargin != bottom))
    {
      bottomMargin = bottom;
      return true;
    }
    return bool;
  }
  
  private final void b(int paramInt)
  {
    c();
    paramInt = Math.max(0, Math.min(paramInt, b.getHeight()));
    rg.b(b, -paramInt);
  }
  
  private final void k()
  {
    if (l == null)
    {
      l = ((ContentFrameLayout)findViewById(acf.b));
      b = ((ActionBarContainer)findViewById(acf.c));
      localObject = findViewById(acf.a);
      if (!(localObject instanceof ahw)) {
        break label61;
      }
    }
    for (Object localObject = (ahw)localObject;; localObject = ((Toolbar)localObject).g())
    {
      m = ((ahw)localObject);
      return;
      label61:
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    throw new IllegalStateException("Can't make a decor toolbar out of " + localObject.getClass().getSimpleName());
  }
  
  public final void a(int paramInt)
  {
    boolean bool = true;
    k();
    switch (paramInt)
    {
    case 2: 
    case 5: 
    default: 
      return;
    }
    c = true;
    if (getContextgetApplicationInfotargetSdkVersion < 19) {}
    for (;;)
    {
      o = bool;
      return;
      bool = false;
    }
  }
  
  public final void a(Menu paramMenu, aek paramaek)
  {
    k();
    m.a(paramMenu, paramaek);
  }
  
  public final void a(Window.Callback paramCallback)
  {
    k();
    m.a(paramCallback);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    k();
    m.a(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean != p)
    {
      p = paramBoolean;
      if (!paramBoolean)
      {
        c();
        b(0);
      }
    }
  }
  
  public final int b()
  {
    if (b != null) {
      return -(int)rg.n(b);
    }
    return 0;
  }
  
  public final void c()
  {
    removeCallbacks(z);
    removeCallbacks(A);
    if (h != null) {
      h.a();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof afa;
  }
  
  public final boolean d()
  {
    k();
    return m.f();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((n != null) && (!o)) {
      if (b.getVisibility() != 0) {
        break label82;
      }
    }
    label82:
    for (int i1 = (int)(b.getBottom() + rg.n(b) + 0.5F);; i1 = 0)
    {
      n.setBounds(0, i1, getWidth(), n.getIntrinsicHeight() + i1);
      n.draw(paramCanvas);
      return;
    }
  }
  
  public final boolean e()
  {
    k();
    return m.g();
  }
  
  public final boolean f()
  {
    k();
    return m.h();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    k();
    rg.r(this);
    boolean bool = a(b, paramRect, false);
    u.set(paramRect);
    ane.a(this, u, r);
    if (!s.equals(r))
    {
      s.set(r);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public final boolean g()
  {
    k();
    return m.i();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new afa(paramLayoutParams);
  }
  
  public int getNestedScrollAxes()
  {
    return B.a;
  }
  
  public final boolean h()
  {
    k();
    return m.j();
  }
  
  public final void i()
  {
    k();
    m.k();
  }
  
  public final void j()
  {
    k();
    m.l();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    a(getContext());
    rg.s(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        afa localafa = (afa)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = leftMargin + paramInt3;
        int i4 = topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    k();
    measureChildWithMargins(b, paramInt1, 0, paramInt2, 0);
    Object localObject = (afa)b.getLayoutParams();
    int i6 = Math.max(0, b.getMeasuredWidth() + leftMargin + rightMargin);
    int i1 = b.getMeasuredHeight();
    int i2 = topMargin;
    int i5 = Math.max(0, bottomMargin + (i1 + i2));
    int i4 = ane.a(0, rg.i(b));
    int i3;
    if ((rg.r(this) & 0x100) != 0)
    {
      i2 = 1;
      if (i2 == 0) {
        break label444;
      }
      i3 = k;
      i1 = i3;
      if (d)
      {
        i1 = i3;
        if (b.a != null) {
          i1 = i3 + k;
        }
      }
    }
    for (;;)
    {
      label153:
      t.set(r);
      v.set(u);
      if ((!c) && (i2 == 0))
      {
        localObject = t;
        top = (i1 + top);
        localObject = t;
      }
      for (bottom += 0;; bottom += 0)
      {
        a(l, t, true);
        if (!w.equals(v))
        {
          w.set(v);
          l.a(v);
        }
        measureChildWithMargins(l, paramInt1, 0, paramInt2, 0);
        localObject = (afa)l.getLayoutParams();
        i1 = Math.max(i6, l.getMeasuredWidth() + leftMargin + rightMargin);
        i2 = l.getMeasuredHeight();
        i3 = topMargin;
        i2 = Math.max(i5, bottomMargin + (i2 + i3));
        i3 = ane.a(i4, rg.i(l));
        i4 = getPaddingLeft();
        i5 = getPaddingRight();
        i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
        setMeasuredDimension(rg.a(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), rg.a(i2, paramInt2, i3 << 16));
        return;
        i2 = 0;
        break;
        label444:
        if (b.getVisibility() == 8) {
          break label506;
        }
        i1 = b.getMeasuredHeight();
        break label153;
        localObject = v;
        top = (i1 + top);
        localObject = v;
      }
      label506:
      i1 = 0;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int i1 = 0;
    if ((!p) || (!paramBoolean)) {
      return false;
    }
    y.a(0, 0, (int)paramFloat2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if (y.e() > b.getHeight()) {
      i1 = 1;
    }
    if (i1 != 0)
    {
      c();
      A.run();
    }
    for (;;)
    {
      e = true;
      return true;
      c();
      z.run();
    }
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    q += paramInt2;
    b(q);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    B.a = paramInt;
    q = b();
    c();
    if (g != null) {
      g.s();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) == 0) || (b.getVisibility() != 0)) {
      return false;
    }
    return p;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((p) && (!e))
    {
      if (q <= b.getHeight())
      {
        c();
        postDelayed(z, 600L);
      }
    }
    else {
      return;
    }
    c();
    postDelayed(A, 600L);
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    k();
    int i3 = f;
    f = paramInt;
    int i1;
    int i2;
    if ((paramInt & 0x4) == 0)
    {
      i1 = 1;
      if ((paramInt & 0x100) == 0) {
        break label120;
      }
      i2 = 1;
      label49:
      if (g != null)
      {
        aez localaez = g;
        if (i2 != 0) {
          break label125;
        }
        label66:
        localaez.f(bool);
        if ((i1 == 0) && (i2 != 0)) {
          break label131;
        }
        g.q();
      }
    }
    for (;;)
    {
      if ((((i3 ^ paramInt) & 0x100) != 0) && (g != null)) {
        rg.s(this);
      }
      return;
      i1 = 0;
      break;
      label120:
      i2 = 0;
      break label49;
      label125:
      bool = false;
      break label66;
      label131:
      g.r();
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    a = paramInt;
    if (g != null) {
      g.f(paramInt);
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */