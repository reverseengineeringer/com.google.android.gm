import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class abt
  extends zc
  implements aez
{
  private static final Interpolator r = new AccelerateInterpolator();
  private static final Interpolator s = new DecelerateInterpolator();
  private static final boolean t;
  private int A = -1;
  private boolean B;
  private boolean C;
  private ArrayList<ze> D = new ArrayList();
  private boolean E;
  private int F = 0;
  private boolean G;
  private boolean H = true;
  private boolean I;
  Context a;
  ActionBarOverlayLayout b;
  ActionBarContainer c;
  ahw d;
  ActionBarContextView e;
  View f;
  abx g;
  acz h;
  ada i;
  boolean j = true;
  boolean k;
  boolean l;
  adj m;
  boolean n;
  final tw o = new abu(this);
  final tw p = new abv(this);
  final ty q = new abw(this);
  private Context u;
  private Activity v;
  private Dialog w;
  private als x;
  private ArrayList<aby> y = new ArrayList();
  private aby z;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      t = bool;
      return;
    }
  }
  
  public abt(Activity paramActivity, boolean paramBoolean)
  {
    v = paramActivity;
    paramActivity = paramActivity.getWindow().getDecorView();
    a(paramActivity);
    if (!paramBoolean) {
      f = paramActivity.findViewById(16908290);
    }
  }
  
  public abt(Dialog paramDialog)
  {
    w = paramDialog;
    a(paramDialog.getWindow().getDecorView());
  }
  
  private final void a(View paramView)
  {
    b = ((ActionBarOverlayLayout)paramView.findViewById(acf.p));
    if (b != null)
    {
      localObject = b;
      g = this;
      if (((ActionBarOverlayLayout)localObject).getWindowToken() != null)
      {
        g.f(a);
        if (f != 0)
        {
          ((ActionBarOverlayLayout)localObject).onWindowSystemUiVisibilityChanged(f);
          rg.s((View)localObject);
        }
      }
    }
    Object localObject = paramView.findViewById(acf.a);
    if ((localObject instanceof ahw)) {}
    for (localObject = (ahw)localObject;; localObject = ((Toolbar)localObject).g())
    {
      d = ((ahw)localObject);
      e = ((ActionBarContextView)paramView.findViewById(acf.f));
      c = ((ActionBarContainer)paramView.findViewById(acf.c));
      if ((d != null) && (e != null) && (c != null)) {
        break label256;
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      if (!(localObject instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of " + localObject != null) {}
    for (paramView = localObject.getClass().getSimpleName();; paramView = "null") {
      throw new IllegalStateException(paramView);
    }
    label256:
    a = d.b();
    if ((d.m() & 0x4) != 0) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        B = true;
      }
      paramView = acy.a(a);
      i1 = a.getApplicationInfo().targetSdkVersion;
      h(paramView.a());
      paramView = a.obtainStyledAttributes(null, ack.b, aca.c, 0);
      if (!paramView.getBoolean(ack.l, false)) {
        break label387;
      }
      if (b.c) {
        break;
      }
      throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }
    n = true;
    b.a(true);
    label387:
    i1 = paramView.getDimensionPixelSize(ack.j, 0);
    if (i1 != 0)
    {
      float f1 = i1;
      rg.f(c, f1);
    }
    paramView.recycle();
  }
  
  static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private final void h(boolean paramBoolean)
  {
    boolean bool = true;
    E = paramBoolean;
    int i1;
    label45:
    label78:
    Object localObject;
    if (!E)
    {
      d.a(null);
      c.a(x);
      if (t() != 2) {
        break label155;
      }
      i1 = 1;
      if (x != null)
      {
        if (i1 == 0) {
          break label160;
        }
        x.setVisibility(0);
        if (b != null) {
          rg.s(b);
        }
      }
      localObject = d;
      if ((E) || (i1 == 0)) {
        break label172;
      }
      paramBoolean = true;
      label97:
      ((ahw)localObject).a(paramBoolean);
      localObject = b;
      if ((E) || (i1 == 0)) {
        break label177;
      }
    }
    label155:
    label160:
    label172:
    label177:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      d = paramBoolean;
      return;
      c.a(null);
      d.a(x);
      break;
      i1 = 0;
      break label45;
      x.setVisibility(8);
      break label78;
      paramBoolean = false;
      break label97;
    }
  }
  
  private final void i(boolean paramBoolean)
  {
    float f2;
    float f1;
    Object localObject1;
    Object localObject2;
    if (a(k, l, G)) {
      if (!H)
      {
        H = true;
        if (m != null) {
          m.b();
        }
        c.setVisibility(0);
        if ((F != 0) || (!t) || ((!I) && (!paramBoolean))) {
          break label271;
        }
        rg.b(c, 0.0F);
        f2 = -c.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject1 = new int[2];
          Object tmp107_105 = localObject1;
          tmp107_105[0] = 0;
          Object tmp111_107 = tmp107_105;
          tmp111_107[1] = 0;
          tmp111_107;
          c.getLocationInWindow((int[])localObject1);
          f1 = f2 - localObject1[1];
        }
        rg.b(c, f1);
        localObject1 = new adj();
        localObject2 = rg.q(c).c(0.0F);
        ((tg)localObject2).a(q);
        ((adj)localObject1).a((tg)localObject2);
        if ((j) && (f != null))
        {
          rg.b(f, f1);
          ((adj)localObject1).a(rg.q(f).c(0.0F));
        }
        ((adj)localObject1).a(s);
        ((adj)localObject1).c();
        ((adj)localObject1).a(p);
        m = ((adj)localObject1);
        ((adj)localObject1).a();
        if (b != null) {
          rg.s(b);
        }
      }
    }
    label271:
    while (!H) {
      for (;;)
      {
        return;
        rg.c(c, 1.0F);
        rg.b(c, 0.0F);
        if ((j) && (f != null)) {
          rg.b(f, 0.0F);
        }
        p.b(null);
      }
    }
    H = false;
    if (m != null) {
      m.b();
    }
    if ((F == 0) && (t) && ((I) || (paramBoolean)))
    {
      rg.c(c, 1.0F);
      c.a(true);
      localObject1 = new adj();
      f2 = -c.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject2 = new int[2];
        Object tmp420_418 = localObject2;
        tmp420_418[0] = 0;
        Object tmp424_420 = tmp420_418;
        tmp424_420[1] = 0;
        tmp424_420;
        c.getLocationInWindow((int[])localObject2);
        f1 = f2 - localObject2[1];
      }
      localObject2 = rg.q(c).c(f1);
      ((tg)localObject2).a(q);
      ((adj)localObject1).a((tg)localObject2);
      if ((j) && (f != null)) {
        ((adj)localObject1).a(rg.q(f).c(f1));
      }
      ((adj)localObject1).a(r);
      ((adj)localObject1).c();
      ((adj)localObject1).a(o);
      m = ((adj)localObject1);
      ((adj)localObject1).a();
      return;
    }
    o.b(null);
  }
  
  private final int t()
  {
    return d.n();
  }
  
  public final acz a(ada paramada)
  {
    if (g != null) {
      g.c();
    }
    b.a(false);
    e.b();
    paramada = new abx(this, e.getContext(), paramada);
    if (paramada.e())
    {
      paramada.d();
      e.a(paramada);
      g(true);
      e.sendAccessibilityEvent(32);
      g = paramada;
      return paramada;
    }
    return null;
  }
  
  public final void a()
  {
    d.a(17170445);
  }
  
  public final void a(int paramInt)
  {
    switch (d.n())
    {
    default: 
      throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    case 2: 
      a((zg)y.get(paramInt));
      return;
    }
    d.d(paramInt);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int i1 = d.m();
    if ((paramInt2 & 0x4) != 0) {
      B = true;
    }
    d.b(i1 & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    h(acy.a(a).a());
  }
  
  public final void a(Drawable paramDrawable)
  {
    d.b(paramDrawable);
  }
  
  public final void a(View paramView, zd paramzd)
  {
    paramView.setLayoutParams(paramzd);
    d.a(paramView);
  }
  
  public final void a(SpinnerAdapter paramSpinnerAdapter, zf paramzf)
  {
    d.a(paramSpinnerAdapter, new abi(paramzf));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    d.b(paramCharSequence);
  }
  
  public final void a(ze paramze)
  {
    D.add(paramze);
  }
  
  public final void a(zg paramzg)
  {
    int i1 = -1;
    if (t() != 2) {
      if (paramzg != null)
      {
        i1 = paramzg.a();
        A = i1;
      }
    }
    label120:
    label150:
    for (;;)
    {
      return;
      i1 = -1;
      break;
      gd localgd;
      if (((v instanceof fj)) && (!d.a().isInEditMode()))
      {
        localgd = ((fj)v).a_().a().a();
        if (z != paramzg) {
          break label120;
        }
        if (z != null) {
          x.b(paramzg.a());
        }
      }
      for (;;)
      {
        if ((localgd == null) || (localgd.d())) {
          break label150;
        }
        localgd.b();
        return;
        localgd = null;
        break;
        als localals = x;
        if (paramzg != null) {
          i1 = paramzg.a();
        }
        localals.a(i1);
        z = ((aby)paramzg);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 2;; i1 = 0)
    {
      a(i1, 2);
      return;
    }
  }
  
  public final void b()
  {
    d.a(null);
  }
  
  public final void b(int paramInt)
  {
    a(a.getString(paramInt));
  }
  
  public final void b(Drawable paramDrawable)
  {
    d.c(paramDrawable);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    d.c(paramCharSequence);
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 4;; i1 = 0)
    {
      a(i1, 4);
      return;
    }
  }
  
  public final void c()
  {
    a(0, 1);
  }
  
  public final void c(int paramInt)
  {
    b(a.getString(paramInt));
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    d.a(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean)
  {
    if (!B) {
      b(paramBoolean);
    }
  }
  
  public final void d()
  {
    a(0, 8);
  }
  
  public final void d(int paramInt)
  {
    boolean bool2 = true;
    int i2 = d.n();
    label88:
    Object localObject;
    switch (i2)
    {
    default: 
      if ((i2 != paramInt) && (!E) && (b != null)) {
        rg.s(b);
      }
      d.c(paramInt);
      switch (paramInt)
      {
      default: 
        localObject = d;
        if ((paramInt == 2) && (!E))
        {
          bool1 = true;
          label109:
          ((ahw)localObject).a(bool1);
          localObject = b;
          if ((paramInt != 2) || (E)) {
            break label378;
          }
        }
        break;
      }
      break;
    }
    label378:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      d = bool1;
      return;
      int i1;
      switch (d.n())
      {
      default: 
        i1 = -1;
      }
      for (;;)
      {
        A = i1;
        a(null);
        x.setVisibility(8);
        break;
        if (z != null)
        {
          i1 = z.a;
        }
        else
        {
          i1 = -1;
          continue;
          i1 = d.o();
        }
      }
      if (x == null)
      {
        localObject = new als(a);
        if (E)
        {
          ((als)localObject).setVisibility(0);
          d.a((als)localObject);
          x = ((als)localObject);
        }
      }
      else
      {
        x.setVisibility(0);
        if (A == -1) {
          break label88;
        }
        a(A);
        A = -1;
        break label88;
      }
      if (t() == 2)
      {
        ((als)localObject).setVisibility(0);
        if (b != null) {
          rg.s(b);
        }
      }
      for (;;)
      {
        c.a((als)localObject);
        break;
        ((als)localObject).setVisibility(8);
      }
      bool1 = false;
      break label109;
    }
  }
  
  public final void d(boolean paramBoolean)
  {
    I = paramBoolean;
    if ((!paramBoolean) && (m != null)) {
      m.b();
    }
  }
  
  public final void e()
  {
    a(16, 16);
  }
  
  public final void e(int paramInt)
  {
    d.e(paramInt);
  }
  
  public final void e(boolean paramBoolean)
  {
    if (paramBoolean == C) {}
    for (;;)
    {
      return;
      C = paramBoolean;
      int i2 = D.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((ze)D.get(i1)).a(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  public final CharSequence f()
  {
    return d.e();
  }
  
  public final void f(int paramInt)
  {
    F = paramInt;
  }
  
  public final void f(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  public final int g()
  {
    return d.m();
  }
  
  public final void g(boolean paramBoolean)
  {
    Object localObject;
    tg localtg;
    label63:
    adj localadj;
    if (paramBoolean)
    {
      if (!G)
      {
        G = true;
        if (b != null) {
          ActionBarOverlayLayout.a();
        }
        i(false);
      }
      if (!paramBoolean) {
        break label166;
      }
      localObject = d.a(4, 100L);
      localtg = e.a(0, 200L);
      localadj = new adj();
      a.add(localObject);
      localObject = (View)a.get();
      if (localObject == null) {
        break label198;
      }
    }
    label166:
    label198:
    for (long l1 = tg.e.a((View)localObject);; l1 = 0L)
    {
      localtg.b(l1);
      a.add(localtg);
      localadj.a();
      return;
      if (!G) {
        break;
      }
      G = false;
      if (b != null) {
        ActionBarOverlayLayout.a();
      }
      i(false);
      break;
      localtg = d.a(0, 200L);
      localObject = e.a(8, 100L);
      break label63;
    }
  }
  
  public final int h()
  {
    return c.getHeight();
  }
  
  public final void i()
  {
    if (k)
    {
      k = false;
      i(false);
    }
  }
  
  public final void j()
  {
    if (!k)
    {
      k = true;
      i(false);
    }
  }
  
  public final boolean k()
  {
    int i1 = c.getHeight();
    return (H) && ((i1 == 0) || (b.b() < i1));
  }
  
  public final Context l()
  {
    int i1;
    if (u == null)
    {
      TypedValue localTypedValue = new TypedValue();
      a.getTheme().resolveAttribute(aca.h, localTypedValue, true);
      i1 = resourceId;
      if (i1 == 0) {
        break label61;
      }
    }
    label61:
    for (u = new ContextThemeWrapper(a, i1);; u = a) {
      return u;
    }
  }
  
  public final boolean n()
  {
    if ((d != null) && (d.c()))
    {
      d.d();
      return true;
    }
    return false;
  }
  
  public final boolean o()
  {
    ViewGroup localViewGroup = d.a();
    if ((localViewGroup != null) && (!localViewGroup.hasFocus()))
    {
      localViewGroup.requestFocus();
      return true;
    }
    return false;
  }
  
  public final void q()
  {
    if (l)
    {
      l = false;
      i(true);
    }
  }
  
  public final void r()
  {
    if (!l)
    {
      l = true;
      i(true);
    }
  }
  
  public final void s()
  {
    if (m != null)
    {
      m.b();
      m = null;
    }
  }
}

/* Location:
 * Qualified Name:     abt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */