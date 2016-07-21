package com.google.android.gms.people.accountswitcherview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import eiz;
import frx;
import frz;
import fsc;
import fsf;
import fsg;
import fss;
import fsw;
import fsx;
import fsz;
import ftb;
import ftc;
import ftd;
import fte;
import ftf;
import ftg;
import fth;
import fti;
import ftj;
import ftk;
import ftl;
import ftm;
import ftn;
import fto;
import fyb;
import java.util.ArrayList;
import rg;

public class SelectedAccountNavigationView
  extends FrameLayout
{
  private int A;
  private VelocityTracker B;
  private int C;
  private boolean D;
  private int E;
  private float F;
  private int G;
  private int H;
  private int I;
  private int J;
  private int K;
  private fyb L;
  private int M;
  private int N;
  public ftk a;
  public int b = 0;
  public ftn c;
  public eiz d;
  public fsf e;
  public fsc f;
  public ArrayList<fyb> g = new ArrayList(2);
  public fyb h;
  public fth i;
  public ftm j;
  public int k = -1;
  public ftl l;
  public float m;
  public float n;
  public boolean o = frx.a(21);
  public boolean p;
  public frz q;
  public boolean r;
  public Interpolator s;
  public AnimatorSet t;
  public fyb u;
  public fyb v;
  public fyb w;
  private ftj x;
  private float y;
  private float z;
  
  public SelectedAccountNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    A = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    B = VelocityTracker.obtain();
    C = ViewConfiguration.getMinimumFlingVelocity();
    paramAttributeSet = paramContext.getResources();
    m = paramAttributeSet.getDimensionPixelSize(fss.b);
    int i1;
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (getResources().getConfiguration().getLayoutDirection() == 1) {
        r = bool;
      }
    }
    else
    {
      if (!frx.a(21)) {
        break label167;
      }
      i1 = 17563661;
      label121:
      if (i1 == -1) {
        break label172;
      }
    }
    label167:
    label172:
    for (paramContext = AnimationUtils.loadInterpolator(paramContext, 17563661);; paramContext = new DecelerateInterpolator())
    {
      s = paramContext;
      N = paramAttributeSet.getDimensionPixelSize(fss.c);
      M = paramAttributeSet.getDimensionPixelSize(fss.a);
      return;
      bool = false;
      break;
      i1 = -1;
      break label121;
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == E) {
      if (i1 != 0) {
        break label33;
      }
    }
    label33:
    for (i1 = 1;; i1 = 0)
    {
      E = paramMotionEvent.getPointerId(i1);
      return;
    }
  }
  
  private static void a(View paramView)
  {
    if (paramView != null)
    {
      rg.a(paramView, 0.0F);
      rg.b(paramView, 0.0F);
      rg.d(paramView, 1.0F);
      rg.e(paramView, 1.0F);
      rg.c(paramView, 1.0F);
    }
  }
  
  private final void a(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      topMargin = (M + paramInt);
      paramView.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  private final void a(ImageView paramImageView, fyb paramfyb)
  {
    if ((paramImageView != null) && (f != null) && (fto.a(paramfyb)))
    {
      paramImageView.setImageBitmap(f.a(paramImageView.getContext(), paramfyb, 1));
      if (TextUtils.isEmpty(paramfyb.f())) {
        break label98;
      }
      f.a(paramImageView);
      f.a(paramImageView, paramfyb, 2);
    }
    for (;;)
    {
      paramImageView.setVisibility(0);
      paramImageView.setContentDescription(getContext().getString(fsx.a, new Object[] { paramfyb.b() }));
      return;
      label98:
      f.a(paramImageView);
    }
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, fyb paramfyb)
  {
    int i1;
    if ((paramTextView1 != null) && (fto.a(paramfyb))) {
      if (TextUtils.isEmpty(paramfyb.c()))
      {
        paramTextView1.setText(paramfyb.b());
        i1 = 0;
      }
    }
    for (;;)
    {
      if (paramTextView2 != null)
      {
        if ((i1 != 0) && (fto.a(paramfyb)))
        {
          paramTextView2.setVisibility(0);
          paramTextView2.setText(paramfyb.b());
        }
      }
      else
      {
        return;
        i1 = 1;
        paramTextView1.setText(paramfyb.c());
        continue;
      }
      paramTextView2.setVisibility(8);
      return;
      i1 = 0;
    }
  }
  
  private final void d()
  {
    Context localContext = getContext();
    int i1;
    if (k == -1)
    {
      if (!p) {
        break label159;
      }
      i1 = fsw.e;
    }
    for (;;)
    {
      k = i1;
      if (c == null) {
        c = new fti(this);
      }
      LayoutInflater.from(localContext).inflate(k, this);
      j = c.a(this);
      if (o)
      {
        j.l.setOnClickListener(new ftd(this));
        j.m.setOnClickListener(new fte(this));
      }
      if (j.g != null) {
        j.g.setOnClickListener(new ftf(this));
      }
      setOnClickListener(new ftg(this));
      return;
      label159:
      if (frx.a(21)) {
        i1 = fsw.e;
      } else {
        i1 = fsw.f;
      }
    }
  }
  
  public final void a()
  {
    if (j == null) {
      d();
    }
    if (o)
    {
      a(j.i);
      a(j.l);
      a(j.m);
      a(j.f);
      a(j.n);
      a(j.v);
      a(j.u);
    }
    ftm localftm = j;
    fyb localfyb = h;
    if ((e != null) && (fto.a(h))) {
      e.setContentDescription(getContext().getResources().getString(fsx.c, new Object[] { h.b() }));
    }
    if ((o != null) && (fto.a(localfyb)))
    {
      o.setImageBitmap(f.a(getContext(), localfyb, 2));
      if (TextUtils.isEmpty(localfyb.f())) {
        break label482;
      }
      f.a(o);
      f.a(o, localfyb, 2);
    }
    for (;;)
    {
      a(j, k, localfyb);
      a(localftm, n, localfyb);
      b();
      if (l != null) {
        l.a(j, h, g);
      }
      if (o)
      {
        n = j.p.getWidth();
        if (j.u != null) {
          j.u.setVisibility(8);
        }
        if (j.v != null) {
          j.v.setVisibility(8);
        }
        if (j.r != null) {
          j.r.setVisibility(8);
        }
        if (j.w != null)
        {
          rg.c(j.w, 0.0F);
          rg.d(j.w, 0.8F);
          rg.e(j.w, 0.8F);
          j.w.setVisibility(8);
        }
        if (j.x != null)
        {
          rg.c(j.x, 0.0F);
          rg.d(j.x, 0.8F);
          rg.e(j.x, 0.8F);
          j.x.setVisibility(8);
        }
      }
      return;
      label482:
      f.a(o);
    }
  }
  
  public final void a(int paramInt)
  {
    if (j == null) {
      d();
    }
    int i1 = N + paramInt;
    setMinimumHeight(i1);
    ViewGroup.LayoutParams localLayoutParams = j.B.getLayoutParams();
    if (localLayoutParams == null) {
      localLayoutParams = new ViewGroup.LayoutParams(-1, i1);
    }
    for (;;)
    {
      j.B.setLayoutParams(localLayoutParams);
      a(j.i, paramInt);
      a(j.u, paramInt);
      a(j.l, paramInt);
      a(j.m, paramInt);
      a(j.w, paramInt);
      a(j.x, paramInt);
      return;
      height = i1;
    }
  }
  
  public final void a(ftm paramftm, ImageView paramImageView, fyb paramfyb)
  {
    if ((paramImageView == null) || (!fto.a(paramfyb))) {
      return;
    }
    if (!TextUtils.isEmpty(paramfyb.i()))
    {
      e.a(paramImageView);
      fsf localfsf = e;
      int i1 = n.getMeasuredWidth();
      if (!fto.a(paramfyb))
      {
        Log.w("CoverPhotoManager", "Unable to load coverphoto, owner not valid");
        return;
      }
      localfsf.a(new fsg(localfsf, paramImageView, paramfyb.b(), paramfyb.d(), i1));
      return;
    }
    e.a(paramImageView);
    paramImageView.setImageBitmap(fsf.a(getContext()));
  }
  
  public final void a(fyb paramfyb)
  {
    if (j == null) {
      d();
    }
    if (!fto.a(paramfyb))
    {
      h = null;
      u = null;
      L = null;
      return;
    }
    if ((t != null) && (t.isRunning()))
    {
      u = paramfyb;
      return;
    }
    if ((j.n != null) && (j.n.getMeasuredWidth() == 0))
    {
      L = paramfyb;
      forceLayout();
      return;
    }
    fyb localfyb1;
    int i1;
    if ((!fto.a(h)) || (!h.b().equals(paramfyb.b())))
    {
      localfyb1 = h;
      h = paramfyb;
      paramfyb = h.b();
      i1 = 0;
      if (i1 >= g.size()) {
        break label278;
      }
      fyb localfyb2 = (fyb)g.get(i1);
      if ((!fto.a(localfyb2)) || (localfyb2.b() == null) || (!localfyb2.b().equals(paramfyb))) {}
    }
    for (;;)
    {
      if (i1 >= 0) {
        g.remove(i1);
      }
      if (localfyb1 != null)
      {
        g.add(0, localfyb1);
        for (;;)
        {
          if (g.size() > 2)
          {
            g.remove(g.size() - 1);
            continue;
            i1 += 1;
            break;
          }
        }
      }
      a();
      return;
      h = paramfyb;
      a();
      return;
      label278:
      i1 = -1;
    }
  }
  
  public final void a(fyb paramfyb, AnimatorSet.Builder paramBuilder, int paramInt)
  {
    a(j.s, j.t, paramfyb);
    j.r.setVisibility(0);
    paramfyb = ObjectAnimator.ofFloat(j.r, "alpha", new float[] { 1.0F });
    paramfyb.setStartDelay(paramInt);
    paramfyb.setDuration(150L);
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(j.f, "alpha", new float[] { 0.0F });
    localObjectAnimator.setStartDelay(0L);
    localObjectAnimator.setDuration(150L);
    paramBuilder.with(paramfyb).with(localObjectAnimator);
  }
  
  public final void b()
  {
    if (!o) {
      return;
    }
    if (j == null) {
      d();
    }
    if ((j.n != null) && (j.n.getMeasuredWidth() == 0))
    {
      forceLayout();
      return;
    }
    if (g.size() > 0)
    {
      fyb localfyb = (fyb)g.get(0);
      ftm localftm = j;
      j.l.setVisibility(0);
      a(j.p, localfyb);
      a(localftm, v, localfyb);
      if (g.size() <= 1) {
        break label174;
      }
      j.m.setVisibility(0);
      a(j.q, (fyb)g.get(1));
    }
    for (;;)
    {
      F = -1.0F;
      return;
      j.l.setVisibility(8);
      break;
      label174:
      j.m.setVisibility(8);
    }
  }
  
  public final void b(int paramInt)
  {
    if (x != null) {
      getHandler().postDelayed(new ftb(this), paramInt);
    }
  }
  
  public final void c()
  {
    boolean bool = true;
    int i1;
    ExpanderView localExpanderView;
    if (b == 1)
    {
      i1 = 0;
      c(i1);
      if (a != null) {
        a.a(this);
      }
      localExpanderView = j.g;
      if (b != 1) {
        break label61;
      }
    }
    for (;;)
    {
      localExpanderView.a(bool);
      return;
      i1 = 1;
      break;
      label61:
      bool = false;
    }
  }
  
  public final void c(int paramInt)
  {
    boolean bool = true;
    if (b != paramInt)
    {
      b = paramInt;
      if (j == null) {
        d();
      }
      if (b != 1) {
        break label46;
      }
    }
    for (;;)
    {
      j.g.a(bool);
      return;
      label46:
      bool = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return D;
      D = false;
      E = paramMotionEvent.getPointerId(0);
      D = false;
      continue;
      a(paramMotionEvent);
      E = -1;
      D = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (j == null) {
      d();
    }
    if (j.n != null) {
      j.n.measure(paramInt1, paramInt2);
    }
    if (j.d != null) {
      j.d.measure(paramInt1, paramInt2);
    }
    if (L != null)
    {
      a(L);
      L = null;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    if (q != null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    int i1 = paramMotionEvent.getAction();
    Object localObject1 = getParent();
    switch (i1)
    {
    }
    for (;;)
    {
      return true;
      y = paramMotionEvent.getX();
      z = paramMotionEvent.getY();
      continue;
      i1 = paramMotionEvent.findPointerIndex(E);
      if (i1 < 0)
      {
        Log.e("SelectedAccountNavigationView", "Got ACTION_MOVE event but have an invalid active pointer id.");
        return false;
      }
      float f1 = paramMotionEvent.getX(i1);
      float f3 = paramMotionEvent.getY(i1);
      float f2 = f1 - y;
      f3 -= z;
      if ((o) && (g.size() > 0) && (!D) && (f2 * f2 + f3 * f3 > A * A) && (Math.abs(f2) > Math.abs(f3)))
      {
        D = true;
        if (localObject1 != null) {
          ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
        }
      }
      if (D)
      {
        f1 -= y;
        Object localObject2;
        label302:
        int i2;
        label316:
        label403:
        float f4;
        if (F == -1.0F)
        {
          localObject1 = (ViewGroup.MarginLayoutParams)j.p.getLayoutParams();
          localObject2 = (ViewGroup.MarginLayoutParams)j.q.getLayoutParams();
          if (r)
          {
            i1 = ((ViewGroup.MarginLayoutParams)localObject1).getMarginStart();
            if (!r) {
              break label1032;
            }
            i2 = ((ViewGroup.MarginLayoutParams)localObject2).getMarginStart();
            F = (i1 + j.l.getLeft());
            G = (j.m.getLeft() + i2);
            I = (j.i.getLeft() + j.i.getPaddingLeft());
            J = j.i.getWidth();
          }
        }
        else
        {
          if (!r) {
            break label1042;
          }
          f1 = Math.min(f1, 0.0F);
          if (n == 0.0F) {
            n = j.p.getWidth();
          }
          f4 = n / m;
          f3 = n;
          float f5 = m;
          if (g.size() <= 1) {
            break label1051;
          }
          f2 = G;
          label467:
          float f6 = f2 - I + (n - m) * 0.5F;
          f2 = Math.min(1.0F, f1 / f6);
          f1 = Math.abs((f3 - f5) * 0.5F);
          f3 = Math.max(0.0F, 1.0F - f2);
          j.i.setTranslationX(f6 * f2);
          j.i.setTranslationY(Math.abs(f1 * f2) * -1.0F);
          f1 = Math.min(1.0F, Math.max(f4, 1.0F - f2 * f4));
          j.i.setScaleX(f1);
          j.i.setScaleY(f1);
          if (j.u != null)
          {
            if (j.u.getVisibility() == 0) {
              break label1074;
            }
            if (!r) {
              break label1059;
            }
            i1 = getWidth() - I;
            label634:
            K = i1;
            j.u.setTranslationX(K);
            j.y.setImageDrawable(j.p.getDrawable());
            j.u.setVisibility(0);
          }
          label686:
          if (g.size() > 1)
          {
            f1 = F;
            f4 = G;
            j.m.setTranslationX((f1 - f4) * f2);
          }
          if (g.size() > 0)
          {
            if (j.v != null)
            {
              if (j.v.getVisibility() == 0) {
                break label1103;
              }
              j.v.setAlpha(0.0F);
              j.v.setVisibility(0);
            }
            label780:
            if (j.n != null) {
              j.n.setAlpha(1.0F - f2);
            }
            if (!r) {
              break label1117;
            }
            f1 = getLeft() - (j.l.getWidth() + F);
            label833:
            j.l.setTranslationX(f1 * f2);
            j.l.setAlpha(f3);
            if (j.r != null)
            {
              if (j.r.getVisibility() == 0) {
                break label1131;
              }
              localObject1 = (fyb)g.get(0);
              H = K;
              j.r.setTranslationX(H);
              a(j.s, j.t, (fyb)localObject1);
              j.r.setAlpha(0.0F);
              j.r.setVisibility(0);
            }
          }
        }
        for (;;)
        {
          if (j.f != null)
          {
            j.f.setTranslationX(j.i.getTranslationX());
            f1 = Math.max(0.0F, 1.0F - 3.0F * f2);
            j.f.setAlpha(f1);
          }
          B.addMovement(paramMotionEvent);
          break;
          i1 = leftMargin;
          break label302;
          label1032:
          i2 = leftMargin;
          break label316;
          label1042:
          f1 = Math.max(f1, 0.0F);
          break label403;
          label1051:
          f2 = F;
          break label467;
          label1059:
          i1 = -J - I;
          break label634;
          label1074:
          f1 = -K;
          j.u.setTranslationX(f1 * f2 + K);
          break label686;
          label1103:
          j.v.setAlpha(f2);
          break label780;
          label1117:
          f1 = getWidth() - F;
          break label833;
          label1131:
          if (f2 > 0.33333334F)
          {
            f1 = Math.min(1.0F, (f2 - 0.33333334F) * 3.0F);
            j.r.setAlpha(f1);
          }
          j.r.setTranslationX(H + -H * f2);
        }
        int i3 = paramMotionEvent.findPointerIndex(E);
        if (i3 < 0)
        {
          Log.e("SelectedAccountNavigationView", "Got ACTION_UP event but have an invalid active pointer id.");
          return false;
        }
        label1283:
        label1348:
        Object localObject3;
        label1405:
        label1419:
        label1491:
        ObjectAnimator localObjectAnimator1;
        ObjectAnimator localObjectAnimator2;
        if (D) {
          if (g.size() > 1)
          {
            f1 = G;
            f3 = j.i.getTranslationX();
            f2 = f3;
            if (r) {
              f2 = Math.abs(f3);
            }
            if (f2 < f1 * 0.5F) {
              break label1997;
            }
            i1 = 1;
            i2 = i1;
            if (i1 == 0)
            {
              i2 = i1;
              if (paramMotionEvent.getX(i3) - y > A)
              {
                B.computeCurrentVelocity(1000);
                if (Math.abs(B.getXVelocity()) <= C) {
                  break label2003;
                }
                i2 = 1;
              }
            }
            if (i2 == 0) {
              break label2067;
            }
            paramMotionEvent = new AnimatorSet();
            localObject2 = (ViewGroup.MarginLayoutParams)j.p.getLayoutParams();
            localObject3 = (ViewGroup.MarginLayoutParams)j.q.getLayoutParams();
            if (!r) {
              break label2009;
            }
            i1 = ((ViewGroup.MarginLayoutParams)localObject2).getMarginStart();
            if (!r) {
              break label2019;
            }
            i2 = ((ViewGroup.MarginLayoutParams)localObject3).getMarginStart();
            if (n == 0.0F) {
              n = j.p.getWidth();
            }
            f1 = n / m;
            f3 = n;
            f4 = m;
            if (g.size() <= 1) {
              break label2029;
            }
            i1 = j.m.getLeft() + i2;
            f2 = i1 - j.i.getLeft();
            f2 = (n - m) * 0.5F + f2;
            localObject2 = ObjectAnimator.ofFloat(j.i, "translationX", new float[] { f2 });
            localObject3 = ObjectAnimator.ofFloat(j.i, "translationY", new float[] { (f3 - f4) * 0.5F });
            localObjectAnimator1 = ObjectAnimator.ofFloat(j.i, "scaleY", new float[] { f1 });
            localObjectAnimator2 = ObjectAnimator.ofFloat(j.i, "scaleX", new float[] { f1 });
            localObject2 = paramMotionEvent.play((Animator)localObject2).with((Animator)localObject3).with(localObjectAnimator2).with(localObjectAnimator1);
            if ((o) && (g.size() > 0))
            {
              if (g.size() > 1)
              {
                f1 = j.l.getLeft() - j.m.getLeft();
                ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.m, "translationX", new float[] { f1 }));
              }
              if (!r) {
                break label2047;
              }
              f1 = getLeft() - (j.l.getWidth() + F);
              label1748:
              localObject3 = ObjectAnimator.ofFloat(j.l, "translationX", new float[] { f1 });
              localObjectAnimator1 = ObjectAnimator.ofFloat(j.l, "alpha", new float[] { 0.0F });
              ((AnimatorSet.Builder)localObject2).with((Animator)localObject3).with(localObjectAnimator1);
              if (j.u != null) {
                ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.u, "translationX", new float[] { 0.0F }));
              }
              if (j.r != null) {
                a((fyb)g.get(0), (AnimatorSet.Builder)localObject2, 0);
              }
            }
            paramMotionEvent.addListener(new ftc(this));
            localObject2 = h;
            h = ((fyb)g.remove(0));
            g.add(localObject2);
            b(100);
            paramMotionEvent.setDuration(((1.0F - j.i.getTranslationX() / f2) * 450.0F));
            paramMotionEvent.setInterpolator(s);
            t = paramMotionEvent;
            t.start();
          }
        }
        for (;;)
        {
          D = false;
          if (localObject1 != null) {
            ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
          }
          B.clear();
          return false;
          f1 = F;
          break;
          label1997:
          i1 = 0;
          break label1283;
          label2003:
          i2 = 0;
          break label1348;
          label2009:
          i1 = leftMargin;
          break label1405;
          label2019:
          i2 = leftMargin;
          break label1419;
          label2029:
          i1 += j.l.getLeft();
          break label1491;
          label2047:
          f1 = getWidth() - j.l.getLeft();
          break label1748;
          label2067:
          paramMotionEvent = new AnimatorSet();
          localObject2 = paramMotionEvent.play(ObjectAnimator.ofFloat(j.i, "alpha", new float[] { 1.0F }));
          localObject3 = ObjectAnimator.ofFloat(j.i, "translationX", new float[] { 0.0F });
          localObjectAnimator1 = ObjectAnimator.ofFloat(j.i, "translationY", new float[] { 0.0F });
          localObjectAnimator2 = ObjectAnimator.ofFloat(j.i, "scaleX", new float[] { 1.0F });
          ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(j.i, "scaleY", new float[] { 1.0F });
          ((AnimatorSet.Builder)localObject2).with((Animator)localObject3).with(localObjectAnimator1).with(localObjectAnimator2).with(localObjectAnimator3);
          ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.u, "translationX", new float[] { K }));
          if (j.v != null) {
            ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.v, "alpha", new float[] { 0.0F }));
          }
          if (j.n != null) {
            ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.n, "alpha", new float[] { 1.0F }));
          }
          ((AnimatorSet.Builder)localObject2).with(ObjectAnimator.ofFloat(j.m, "translationX", new float[] { 0.0F }));
          localObjectAnimator2 = ObjectAnimator.ofFloat(j.l, "translationX", new float[] { 0.0F });
          localObject3 = ObjectAnimator.ofFloat(j.r, "translationX", new float[] { -getWidth() });
          localObjectAnimator3 = ObjectAnimator.ofFloat(j.l, "alpha", new float[] { 1.0F });
          localObjectAnimator1 = ObjectAnimator.ofFloat(j.f, "translationX", new float[] { 0.0F });
          ((AnimatorSet.Builder)localObject2).with(localObjectAnimator2).with(localObjectAnimator3);
          localObjectAnimator2 = ObjectAnimator.ofFloat(j.r, "alpha", new float[] { 0.0F });
          localObjectAnimator3 = ObjectAnimator.ofFloat(j.f, "alpha", new float[] { 1.0F });
          ((AnimatorSet.Builder)localObject2).with((Animator)localObject3).with(localObjectAnimator2).with(localObjectAnimator1).with(localObjectAnimator3);
          paramMotionEvent.setDuration(100L);
          paramMotionEvent.addListener(new fsz(this));
          paramMotionEvent.setInterpolator(s);
          t = paramMotionEvent;
          t.start();
          continue;
          c();
        }
        if (localObject1 == null) {
          break;
        }
        ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(false);
        return false;
        E = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
        continue;
        a(paramMotionEvent);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.people.accountswitcherview.SelectedAccountNavigationView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */