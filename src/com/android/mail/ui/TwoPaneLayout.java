package com.android.mail.ui;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import bty;
import bua;
import bub;
import buc;
import bud;
import bxl;
import cht;
import cjf;
import coh;
import coi;
import coq;
import cqw;
import crb;
import crd;
import cre;
import crf;
import crg;
import crj;
import crk;
import cvm;
import cxd;
import cxe;
import java.util.Iterator;
import java.util.List;

public final class TwoPaneLayout
  extends FrameLayout
  implements coi, crk
{
  public static final int a = buc.cP;
  private boolean A;
  private boolean B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private final Drawable I;
  private final crg J = new crg(this);
  private ObjectAnimator K;
  private boolean L;
  public final int b;
  public final boolean c;
  public cqw d;
  public coq e;
  public View f;
  public View g;
  public View h;
  public View i;
  public boolean j;
  public final int k;
  public final ValueAnimator.AnimatorUpdateListener l = new crd(this);
  private final int m;
  private final int n;
  private final int o;
  private final double p;
  private final TimeInterpolator q;
  private int r = 0;
  private int s = 0;
  private final coh t;
  private int u;
  private Float v;
  private View w;
  private View x;
  private boolean y;
  private boolean z;
  
  public TwoPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TwoPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = getResources();
    c = paramAttributeSet.getBoolean(bty.c);
    m = paramAttributeSet.getDimensionPixelSize(bua.aa);
    n = paramAttributeSet.getDimensionPixelSize(bua.ab);
    b = (n - m);
    o = paramAttributeSet.getDimensionPixelOffset(bua.s);
    q = AnimationUtils.loadInterpolator(paramContext, 17563651);
    int i1 = paramAttributeSet.getInteger(bud.d);
    int i2 = paramAttributeSet.getInteger(bud.f);
    p = (i1 / (i2 + i1));
    I = getResources().getDrawable(bub.at);
    k = I.getMinimumWidth();
    t = new coh(paramContext, this);
  }
  
  private final int a(int paramInt)
  {
    int i1 = paramInt - m;
    paramInt = i1;
    if (c) {
      paramInt = (int)(i1 * p);
    }
    return paramInt;
  }
  
  private final void a(int paramInt, boolean paramBoolean)
  {
    if ((crj.b(r)) || (crj.e(r)))
    {
      if (j) {}
      for (;;)
      {
        b(paramInt, paramInt, paramBoolean);
        a(false, false, true);
        if (!paramBoolean) {
          d();
        }
        return;
        paramInt = -paramInt;
      }
    }
    if (f()) {}
    for (paramInt = b;; paramInt = 0)
    {
      int i1 = paramInt;
      if (j) {
        i1 = -paramInt;
      }
      b(i1, 0.0F, paramBoolean);
      a(true, true, false);
      break;
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1) {
      f.setVisibility(paramInt);
    }
    if (paramBoolean2) {
      g.setVisibility(paramInt);
    }
    if (paramBoolean3)
    {
      if (w.getVisibility() != 8) {
        w.setVisibility(paramInt);
      }
      if (x.getVisibility() != 8) {
        x.setVisibility(paramInt);
      }
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (width == paramInt) {}
    do
    {
      return;
      width = paramInt;
      paramView.setLayoutParams(localLayoutParams);
    } while (!cvm.a("TwoPaneLayout", 3));
    if (paramView == f) {
      paramView = "folders";
    }
    for (;;)
    {
      cvm.b("TwoPaneLayout", "TPL: setPaneWidth, w=%spx pane=%s", new Object[] { Integer.valueOf(paramInt), paramView });
      return;
      if (paramView == g)
      {
        paramView = "conv-list";
      }
      else if (paramView == w)
      {
        paramView = "conv-view";
      }
      else if (paramView == x)
      {
        paramView = "misc-view";
      }
      else if (paramView == h)
      {
        paramView = "conv-misc-wrapper";
      }
      else
      {
        paramView = String.valueOf(paramView);
        paramView = String.valueOf(paramView).length() + 4 + "???:" + paramView;
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    if (e != null) {
      e.b(paramBoolean);
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool = true;
    a(0, paramBoolean1, paramBoolean2, paramBoolean3);
    y = true;
    if (!paramBoolean1)
    {
      paramBoolean1 = true;
      z = paramBoolean1;
      if (paramBoolean2) {
        break label56;
      }
      paramBoolean1 = true;
      label33:
      A = paramBoolean1;
      if (paramBoolean3) {
        break label61;
      }
    }
    label56:
    label61:
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      B = paramBoolean1;
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label33;
    }
  }
  
  private final void a(View... paramVarArgs)
  {
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramVarArgs[i1].animate().setInterpolator(q).setDuration(250L);
      i1 += 1;
    }
  }
  
  private final float b(float paramFloat)
  {
    if (j) {
      if (u == 0) {
        paramFloat = (b - paramFloat) / b;
      }
    }
    while (paramFloat < 0.0F)
    {
      return 0.0F;
      paramFloat = -paramFloat / b;
      continue;
      if (u == 0) {
        paramFloat /= b;
      } else {
        paramFloat = (b + paramFloat) / b;
      }
    }
    if (paramFloat > 1.0F) {
      return 1.0F;
    }
    return paramFloat;
  }
  
  private final void b(boolean paramBoolean)
  {
    if (e != null) {
      e.c(paramBoolean);
    }
  }
  
  private final boolean f()
  {
    return (d != null) && (d.au());
  }
  
  @Deprecated
  private final boolean g()
  {
    return (!crj.a(r)) && (!c);
  }
  
  public final void a()
  {
    d.av();
  }
  
  public final void a(float paramFloat)
  {
    paramFloat = b(paramFloat);
    d.a(paramFloat);
  }
  
  public final void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    if (paramBoolean)
    {
      if (j)
      {
        localcqw = d;
        if (paramFloat2 >= 0.0F) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          localcqw.a(paramBoolean, null);
          return;
        }
      }
      localcqw = d;
      if (paramFloat2 < 0.0F) {}
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        localcqw.a(paramBoolean, null);
        return;
      }
    }
    cqw localcqw = d;
    if (b(paramFloat1) < 0.5F) {}
    for (paramBoolean = bool3;; paramBoolean = false)
    {
      localcqw.a(paramBoolean, null);
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (r == 0)
    {
      f.setVisibility(0);
      g.setVisibility(0);
    }
    if (crj.e(paramInt2))
    {
      x.setVisibility(0);
      w.setVisibility(8);
      if (crj.b(r))
      {
        d.F();
        if (!c)
        {
          cjf localcjf = d.G.a();
          if (localcjf != null) {
            localcjf.v();
          }
        }
      }
      if (paramInt2 == 2) {
        a(true);
      }
      if (!crj.d(paramInt2)) {
        break label138;
      }
      r = paramInt2;
      s = paramInt2;
    }
    label138:
    do
    {
      return;
      w.setVisibility(0);
      x.setVisibility(8);
      break;
      r = paramInt2;
      cvm.c("TwoPaneLayout", "onViewModeChanged(%d)", new Object[] { Integer.valueOf(paramInt2) });
      paramInt1 = getMeasuredWidth();
    } while (paramInt1 == 0);
    if (c)
    {
      d();
      return;
    }
    a(paramInt1, true);
  }
  
  public final void b()
  {
    if (j) {}
    for (int i1 = E;; i1 = F)
    {
      i1 = (int)(i1 + g.getTranslationX());
      cqw localcqw = d;
      if (Y == i1) {
        break;
      }
      Y = i1;
      if (!Z) {
        break;
      }
      Iterator localIterator = X.iterator();
      while (localIterator.hasNext()) {
        ((crb)localIterator.next()).c(Y);
      }
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    ViewPropertyAnimator localViewPropertyAnimator;
    if (paramBoolean) {
      if (!c)
      {
        if (K != null) {
          K.cancel();
        }
        K = ObjectAnimator.ofFloat(h, "alpha", new float[] { h.getAlpha(), 0.0F });
        K.setInterpolator(new LinearInterpolator());
        K.setDuration(150L);
        K.addListener(new crf(this));
        if (paramFloat1 == 0.0F)
        {
          cxe.c(h);
          K.start();
        }
      }
      else
      {
        h.animate().translationX(paramFloat1);
        localViewPropertyAnimator = g.animate().translationX(paramFloat1).setListener(J);
        f.animate().translationX(paramFloat2);
        if (cxd.c()) {
          localViewPropertyAnimator.setUpdateListener(l);
        }
        if (i == null) {
          break label324;
        }
        if (!crj.b(r)) {
          break label261;
        }
        i.setVisibility(0);
        i.animate().translationX(0.0F);
        label213:
        a(new View[] { f, g, h, i });
      }
    }
    label261:
    label324:
    do
    {
      return;
      h.setAlpha(1.0F);
      break;
      if (i.getVisibility() != 0) {
        break label213;
      }
      localViewPropertyAnimator = i.animate();
      if (j) {}
      for (paramFloat1 = -getMeasuredWidth();; paramFloat1 = getMeasuredWidth())
      {
        localViewPropertyAnimator.translationX(paramFloat1).setListener(new cre(this));
        break;
      }
      a(new View[] { f, g, h });
      return;
      f.setTranslationX(paramFloat2);
      g.setTranslationX(paramFloat1);
      h.setTranslationX(paramFloat1);
    } while ((i == null) || (crj.b(r)));
    c();
  }
  
  public final void c()
  {
    if (i != null)
    {
      i.animate().cancel();
      i.setVisibility(4);
    }
  }
  
  public final void d()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (d.r)
    {
      cvm.c("TwoPaneLayout", "IN TPL.onTransitionComplete, activity destroyed->quitting early", new Object[0]);
      return;
    }
    if (y)
    {
      a(4, z, A, B);
      y = false;
    }
    s = r;
    switch (r)
    {
    default: 
      return;
    case 1: 
    case 4: 
      b(true);
      if (!g()) {}
      for (;;)
      {
        a(bool1);
        return;
        bool1 = false;
      }
    case 2: 
    case 3: 
    case 5: 
      b(false);
      bool1 = bool2;
    }
    for (;;)
    {
      a(bool1);
      return;
      b(false);
      bool1 = bool2;
      if (g()) {
        bool1 = false;
      }
    }
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i1;
    if (cxe.a(this))
    {
      i1 = (int)g.getX() + g.getWidth();
      I.setBounds(i1, 0, k + i1, g.getBottom());
    }
    for (;;)
    {
      I.draw(paramCanvas);
      return;
      i1 = (int)g.getX();
      I.setBounds(i1 - k, 0, i1, g.getBottom());
    }
  }
  
  public final boolean e()
  {
    return s != r;
  }
  
  protected final void onFinishInflate()
  {
    super.onFinishInflate();
    f = findViewById(buc.bg);
    g = findViewById(buc.ay);
    h = findViewById(buc.at);
    w = h.findViewById(buc.aD);
    x = h.findViewById(a);
    r = 0;
    f.setVisibility(8);
    g.setVisibility(8);
    w.setVisibility(8);
    x.setVisibility(8);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (e()) {}
    for (;;)
    {
      return false;
      switch (paramMotionEvent.getAction())
      {
      }
      while ((L) && (t.a(paramMotionEvent, u, v)))
      {
        return true;
        float f3 = paramMotionEvent.getX();
        float f1;
        label95:
        float f2;
        label119:
        boolean bool;
        if (f())
        {
          if (c) {
            if (j)
            {
              f1 = h.getX();
              if (!j) {
                break label173;
              }
              f2 = g.getX() + g.getWidth();
              if ((f3 < f1) || (f3 > f2)) {
                break label215;
              }
            }
          }
          label173:
          label215:
          for (bool = true;; bool = false)
          {
            L = bool;
            v = null;
            if (!j) {
              break label221;
            }
            u = 0;
            break;
            f1 = g.getX();
            break label95;
            f2 = h.getX() + h.getWidth();
            break label119;
            f1 = g.getX();
            f2 = g.getWidth() + f1;
            break label119;
          }
          label221:
          u = 1;
        }
        else
        {
          if (j)
          {
            f1 = f.getX() + b - o;
            label256:
            f2 = m;
            float f4 = o;
            if ((f3 < f1) || (f3 > f2 + f1 + f4)) {
              break label341;
            }
          }
          label341:
          for (bool = true;; bool = false)
          {
            L = bool;
            if (!j) {
              break label347;
            }
            u = 1;
            v = Float.valueOf(C + b);
            break;
            f1 = f.getX();
            break label256;
          }
          label347:
          u = 0;
          v = Float.valueOf(C + m);
        }
      }
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 1;
    cvm.b("MailBlankFragment", "TPL(%s).onLayout()", new Object[] { this });
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    j = cxe.a(this);
    if (paramBoolean)
    {
      paramInt2 = getMeasuredWidth();
      paramInt1 = m;
      paramInt3 = g.getLayoutParams().width;
      paramInt4 = h.getLayoutParams().width;
      if (!j) {
        break label273;
      }
      C = (paramInt2 - n);
      E = (paramInt2 - paramInt1 - paramInt3);
      G = (E - paramInt4);
      if ((!cxd.a()) && (!c))
      {
        int i2 = G;
        if (!j) {
          break label297;
        }
        paramInt1 = i1;
        label145:
        G = (paramInt1 + i2);
      }
      D = (C + n);
      F = (E + paramInt3);
      H = (G + paramInt4);
      if ((s == r) || (c)) {
        break label302;
      }
      a(paramInt2, false);
    }
    for (;;)
    {
      b();
      paramInt1 = getMeasuredHeight();
      f.layout(C, 0, D, paramInt1);
      g.layout(E, 0, F, paramInt1);
      h.layout(G, 0, H, paramInt1);
      return;
      label273:
      C = 0;
      E = paramInt1;
      G = (E + paramInt3);
      break;
      label297:
      paramInt1 = -1;
      break label145;
      label302:
      d();
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    cvm.b("MailBlankFragment", "TPL(%s).onMeasure()", new Object[] { this });
    int i2 = View.MeasureSpec.getSize(paramInt1);
    if (i2 != getMeasuredWidth()) {
      if (!c) {
        break label85;
      }
    }
    label85:
    for (int i1 = i2 - a(i2) - m;; i1 = i2)
    {
      a(h, i1);
      a(g, a(i2));
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (L)
    {
      t.a(paramMotionEvent, u, v);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("{mTranslatedMode=");
    localStringBuilder.append(s);
    localStringBuilder.append(" mCurrDragMode=");
    localStringBuilder.append(u);
    localStringBuilder.append(" mShouldInterceptCurrentTouch=");
    localStringBuilder.append(L);
    localStringBuilder.append(" mHideDrawerAfterTransition=");
    localStringBuilder.append(z);
    localStringBuilder.append(" mHideListAfterTransition=");
    localStringBuilder.append(A);
    localStringBuilder.append(" mHideCvAfterTransition=");
    localStringBuilder.append(B);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.TwoPaneLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */