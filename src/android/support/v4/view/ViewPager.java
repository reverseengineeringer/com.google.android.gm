package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import pl;
import pp;
import qk;
import qv;
import rc;
import rg;
import rz;
import se;
import sm;
import sn;
import so;
import sp;
import sq;
import sr;
import ss;
import st;
import su;
import sv;
import sw;
import sy;
import wu;

public class ViewPager
  extends ViewGroup
{
  public static final int[] a = { 16842931 };
  private static final sy ah = new sy();
  private static final Comparator<sr> j = new sm();
  private static final Interpolator k = new sn();
  private int A;
  private boolean B;
  private boolean C;
  private boolean D;
  private int E = 1;
  private boolean F;
  private boolean G;
  private int H;
  private int I;
  private int J;
  private float K;
  private float L;
  private float M;
  private float N;
  private int O = -1;
  private VelocityTracker P;
  private int Q;
  private int R;
  private int S;
  private int T;
  private boolean U;
  private wu V;
  private wu W;
  private boolean aa = true;
  private boolean ab = false;
  private boolean ac;
  private int ad;
  private List<su> ae;
  private su af;
  private ArrayList<View> ag;
  private final Runnable ai = new so(this);
  private int aj = 0;
  public qv b;
  public int c;
  public Drawable d;
  public su e;
  public sv f;
  public Method g;
  public int h;
  private int i;
  private final ArrayList<sr> l = new ArrayList();
  private final sr m = new sr();
  private final Rect n = new Rect();
  private int o = -1;
  private Parcelable p = null;
  private ClassLoader q = null;
  private Scroller r;
  private boolean s;
  private sw t;
  private int u;
  private int v;
  private int w;
  private float x = -3.4028235E38F;
  private float y = Float.MAX_VALUE;
  private int z;
  
  public ViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private final Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null) {
      paramRect = new Rect();
    }
    for (;;)
    {
      if (paramView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return paramRect;
      }
      left = paramView.getLeft();
      right = paramView.getRight();
      top = paramView.getTop();
      bottom = paramView.getBottom();
      for (paramView = paramView.getParent(); ((paramView instanceof ViewGroup)) && (paramView != this); paramView = paramView.getParent())
      {
        paramView = (ViewGroup)paramView;
        left += paramView.getLeft();
        right += paramView.getRight();
        top += paramView.getTop();
        bottom += paramView.getBottom();
      }
      return paramRect;
    }
  }
  
  private final sr a(int paramInt1, int paramInt2)
  {
    sr localsr = new sr();
    b = paramInt1;
    a = b.a(this, paramInt1);
    d = 1.0F;
    if ((paramInt2 < 0) || (paramInt2 >= l.size()))
    {
      l.add(localsr);
      return localsr;
    }
    l.add(paramInt2, localsr);
    return localsr;
  }
  
  private final sr a(View paramView)
  {
    int i1 = 0;
    while (i1 < l.size())
    {
      sr localsr = (sr)l.get(i1);
      if (b.a(paramView, a)) {
        return localsr;
      }
      i1 += 1;
    }
    return null;
  }
  
  private final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    int i2;
    int i7;
    int i5;
    Object localObject;
    int i3;
    int i4;
    label132:
    int i9;
    if (ad > 0)
    {
      int i6 = getScrollX();
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      i7 = getWidth();
      int i8 = getChildCount();
      i5 = 0;
      if (i5 < i8)
      {
        localObject = getChildAt(i5);
        ss localss = (ss)((View)localObject).getLayoutParams();
        if (!a) {
          break label482;
        }
        switch (b & 0x7)
        {
        case 2: 
        case 4: 
        default: 
          i3 = i1;
          i4 = i2;
          i2 = i1;
          i1 = i4;
          i9 = i3 + i6 - ((View)localObject).getLeft();
          i3 = i1;
          i4 = i2;
          if (i9 != 0)
          {
            ((View)localObject).offsetLeftAndRight(i9);
            i4 = i2;
            i3 = i1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      i5 += 1;
      i1 = i4;
      i2 = i3;
      break;
      i3 = ((View)localObject).getWidth();
      i4 = i3 + i1;
      i3 = i1;
      i1 = i2;
      i2 = i4;
      break label132;
      i3 = Math.max((i7 - ((View)localObject).getMeasuredWidth()) / 2, i1);
      i4 = i1;
      i1 = i2;
      i2 = i4;
      break label132;
      i3 = i7 - i2 - ((View)localObject).getMeasuredWidth();
      i9 = ((View)localObject).getMeasuredWidth();
      i4 = i1;
      i1 = i2 + i9;
      i2 = i4;
      break label132;
      if (e != null) {
        e.a(paramInt1, paramFloat, paramInt2);
      }
      if (ae != null)
      {
        i2 = ae.size();
        i1 = 0;
        while (i1 < i2)
        {
          localObject = (su)ae.get(i1);
          if (localObject != null) {
            ((su)localObject).a(paramInt1, paramFloat, paramInt2);
          }
          i1 += 1;
        }
      }
      if (af != null) {
        af.a(paramInt1, paramFloat, paramInt2);
      }
      if (f != null)
      {
        paramInt2 = getScrollX();
        i1 = getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i1)
        {
          localObject = getChildAt(paramInt1);
          if (!getLayoutParamsa)
          {
            paramFloat = (((View)localObject).getLeft() - paramInt2) / d();
            f.a((View)localObject, paramFloat);
          }
          paramInt1 += 1;
        }
      }
      ac = true;
      return;
      label482:
      i3 = i2;
      i4 = i1;
    }
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!l.isEmpty()))
    {
      if (!r.isFinished())
      {
        r.setFinalX(c * d());
        return;
      }
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      f1 = getScrollX() / (paramInt2 - i3 - i4 + paramInt4);
      scrollTo((int)((paramInt1 - i1 - i2 + paramInt3) * f1), getScrollY());
      return;
    }
    sr localsr = e(c);
    if (localsr != null) {}
    for (float f1 = Math.min(e, y);; f1 = 0.0F)
    {
      paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (paramInt1 == getScrollX()) {
        break;
      }
      a(false);
      scrollTo(paramInt1, getScrollY());
      return;
    }
  }
  
  private final void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    sr localsr = e(paramInt1);
    if (localsr != null) {}
    for (int i2 = (int)(d() * Math.max(x, Math.min(e, y)));; i2 = 0)
    {
      if (paramBoolean1)
      {
        if (getChildCount() == 0)
        {
          b(false);
          if (paramBoolean2) {
            g(paramInt1);
          }
          return;
        }
        int i1;
        if ((r != null) && (!r.isFinished()))
        {
          i1 = 1;
          label87:
          if (i1 == 0) {
            break label184;
          }
          if (!s) {
            break label172;
          }
          i1 = r.getCurrX();
          label108:
          r.abortAnimation();
          b(false);
        }
        int i3;
        int i4;
        for (;;)
        {
          i3 = getScrollY();
          i2 -= i1;
          i4 = 0 - i3;
          if ((i2 != 0) || (i4 != 0)) {
            break label193;
          }
          a(false);
          b();
          a(0);
          break;
          i1 = 0;
          break label87;
          label172:
          i1 = r.getStartX();
          break label108;
          label184:
          i1 = getScrollX();
        }
        label193:
        b(true);
        a(2);
        int i5 = d();
        int i6 = i5 / 2;
        float f3 = Math.min(1.0F, 1.0F * Math.abs(i2) / i5);
        float f1 = i6;
        float f2 = i6;
        f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
        paramInt2 = Math.abs(paramInt2);
        if (paramInt2 > 0) {}
        for (paramInt2 = Math.round(1000.0F * Math.abs((f2 * f3 + f1) / paramInt2)) * 4;; paramInt2 = (int)((Math.abs(i2) / (f1 * 1.0F + u) + 1.0F) * 100.0F))
        {
          paramInt2 = Math.min(paramInt2, 600);
          s = false;
          r.startScroll(i1, i3, i2, i4, paramInt2);
          rg.c(this);
          break;
          f1 = i5;
        }
      }
      if (paramBoolean2) {
        g(paramInt1);
      }
      a(false);
      scrollTo(i2, 0);
      f(i2);
      return;
    }
  }
  
  private final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    boolean bool = false;
    if ((b == null) || (b.a() <= 0))
    {
      b(false);
      return;
    }
    if ((!paramBoolean2) && (c == paramInt1) && (l.size() != 0))
    {
      b(false);
      return;
    }
    int i1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    for (;;)
    {
      paramInt1 = E;
      if ((i1 <= c + paramInt1) && (i1 >= c - paramInt1)) {
        break;
      }
      paramInt1 = 0;
      while (paramInt1 < l.size())
      {
        l.get(paramInt1)).c = true;
        paramInt1 += 1;
      }
      i1 = paramInt1;
      if (paramInt1 >= b.a()) {
        i1 = b.a() - 1;
      }
    }
    paramBoolean2 = bool;
    if (c != i1) {
      paramBoolean2 = true;
    }
    if (aa)
    {
      c = i1;
      if (paramBoolean2) {
        g(i1);
      }
      requestLayout();
      return;
    }
    d(i1);
    a(i1, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    int i1 = qk.b(paramMotionEvent);
    if (qk.b(paramMotionEvent, i1) == O) {
      if (i1 != 0) {
        break label56;
      }
    }
    label56:
    for (i1 = 1;; i1 = 0)
    {
      K = qk.c(paramMotionEvent, i1);
      O = qk.b(paramMotionEvent, i1);
      if (P != null) {
        P.clear();
      }
      return;
    }
  }
  
  private final void a(sr paramsr1, int paramInt, sr paramsr2)
  {
    int i3 = b.a();
    int i1 = d();
    if (i1 > 0) {}
    float f1;
    int i2;
    for (float f2 = u / i1;; f2 = 0.0F)
    {
      if (paramsr2 == null) {
        break label365;
      }
      i1 = b;
      if (i1 >= b) {
        break;
      }
      f1 = e + d + f2;
      i2 = 0;
      i1 += 1;
      if ((i1 > b) || (i2 >= l.size())) {
        break label365;
      }
      for (paramsr2 = (sr)l.get(i2); (i1 > b) && (i2 < l.size() - 1); paramsr2 = (sr)l.get(i2)) {
        i2 += 1;
      }
    }
    for (;;)
    {
      if (i1 < b)
      {
        i1 += 1;
        f1 = 1.0F + f2 + f1;
      }
      else
      {
        e = f1;
        f1 += d + f2;
        i1 += 1;
        break;
        if (i1 > b)
        {
          i2 = l.size();
          f1 = e;
          i2 -= 1;
          i1 -= 1;
          if ((i1 >= b) && (i2 >= 0)) {
            for (paramsr2 = (sr)l.get(i2); (i1 < b) && (i2 > 0); paramsr2 = (sr)l.get(i2)) {
              i2 -= 1;
            }
          }
        }
        for (;;)
        {
          if (i1 > b)
          {
            i1 -= 1;
            f1 -= 1.0F + f2;
          }
          else
          {
            f1 -= d + f2;
            e = f1;
            i1 -= 1;
            break;
            label365:
            int i4 = l.size();
            float f3 = e;
            i1 = b - 1;
            if (b == 0)
            {
              f1 = e;
              x = f1;
              if (b != i3 - 1) {
                break label498;
              }
              f1 = e + d - 1.0F;
              label431:
              y = f1;
              i2 = paramInt - 1;
              f1 = f3;
            }
            for (;;)
            {
              if (i2 < 0) {
                break label551;
              }
              paramsr2 = (sr)l.get(i2);
              for (;;)
              {
                if (i1 > b)
                {
                  i1 -= 1;
                  f1 -= 1.0F + f2;
                  continue;
                  f1 = -3.4028235E38F;
                  break;
                  label498:
                  f1 = Float.MAX_VALUE;
                  break label431;
                }
              }
              f1 -= d + f2;
              e = f1;
              if (b == 0) {
                x = f1;
              }
              i1 -= 1;
              i2 -= 1;
            }
            label551:
            f1 = e + d + f2;
            i2 = b + 1;
            i1 = paramInt + 1;
            paramInt = i2;
            while (i1 < i4)
            {
              paramsr1 = (sr)l.get(i1);
              while (paramInt < b)
              {
                paramInt += 1;
                f1 += 1.0F + f2;
              }
              if (b == i3 - 1) {
                y = (d + f1 - 1.0F);
              }
              e = f1;
              f1 += d + f2;
              paramInt += 1;
              i1 += 1;
            }
            ab = false;
            return;
          }
        }
      }
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    int i1;
    if (aj == 2)
    {
      i1 = 1;
      if (i1 != 0)
      {
        b(false);
        if (r.isFinished()) {
          break label170;
        }
      }
    }
    label170:
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 != 0)
      {
        r.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = r.getCurrX();
        int i5 = r.getCurrY();
        if ((i2 != i4) || (i3 != i5))
        {
          scrollTo(i4, i5);
          if (i4 != i2) {
            f(i4);
          }
        }
      }
      D = false;
      int i3 = 0;
      i2 = i1;
      i1 = i3;
      while (i1 < l.size())
      {
        sr localsr = (sr)l.get(i1);
        if (c)
        {
          c = false;
          i2 = 1;
        }
        i1 += 1;
      }
      i1 = 0;
      break;
    }
    if (i2 != 0)
    {
      if (paramBoolean) {
        rg.a(this, ai);
      }
    }
    else {
      return;
    }
    ai.run();
  }
  
  private final boolean a(float paramFloat)
  {
    int i2 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    float f1 = K;
    K = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    int i3 = d();
    paramFloat = i3 * x;
    f1 = i3;
    float f3 = y;
    sr localsr1 = (sr)l.get(0);
    sr localsr2 = (sr)l.get(l.size() - 1);
    if (b != 0) {
      paramFloat = e * i3;
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (b != b.a() - 1)
      {
        f1 = e * i3;
        i2 = 0;
      }
      for (;;)
      {
        if (f2 < paramFloat)
        {
          f1 = paramFloat;
          if (i1 != 0)
          {
            bool1 = V.a(Math.abs(paramFloat - f2) / i3);
            f1 = paramFloat;
          }
        }
        for (;;)
        {
          K += f1 - (int)f1;
          scrollTo((int)f1, getScrollY());
          f((int)f1);
          return bool1;
          if (f2 > f1)
          {
            bool1 = bool2;
            if (i2 != 0) {
              bool1 = W.a(Math.abs(f2 - f1) / i3);
            }
          }
          else
          {
            f1 = f2;
          }
        }
        f1 *= f3;
      }
    }
  }
  
  private final boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      i1 = localViewGroup.getChildCount() - 1;
      if (i1 >= 0)
      {
        localView = localViewGroup.getChildAt(i1);
        if ((paramInt2 + i2 < localView.getLeft()) || (paramInt2 + i2 >= localView.getRight()) || (paramInt3 + i3 < localView.getTop()) || (paramInt3 + i3 >= localView.getBottom()) || (!a(localView, true, paramInt1, paramInt2 + i2 - localView.getLeft(), paramInt3 + i3 - localView.getTop()))) {}
      }
    }
    while ((paramBoolean) && (rg.a(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i1 -= 1;
      break;
    }
    return false;
  }
  
  private final sr b(View paramView)
  {
    for (;;)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this) {
        break;
      }
      if ((localViewParent == null) || (!(localViewParent instanceof View))) {
        return null;
      }
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }
  
  private final void b(boolean paramBoolean)
  {
    if (C != paramBoolean) {
      C = paramBoolean;
    }
  }
  
  private final void c()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    r = new Scroller(localContext, k);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = getResourcesgetDisplayMetricsdensity;
    J = rz.a.a(localViewConfiguration);
    Q = ((int)(400.0F * f1));
    R = localViewConfiguration.getScaledMaximumFlingVelocity();
    V = new wu(localContext);
    W = new wu(localContext);
    S = ((int)(25.0F * f1));
    T = ((int)(2.0F * f1));
    H = ((int)(16.0F * f1));
    rg.a(this, new st(this));
    if (rg.d(this) == 0) {
      rg.c(this, 1);
    }
    rg.a(this, new sp(this));
  }
  
  private final int d()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private final void d(int paramInt)
  {
    Object localObject2;
    if (c != paramInt)
    {
      localObject2 = e(c);
      c = paramInt;
    }
    for (;;)
    {
      if (b == null) {
        e();
      }
      do
      {
        return;
        if (D)
        {
          e();
          return;
        }
      } while (getWindowToken() == null);
      paramInt = E;
      int i7 = Math.max(0, c - paramInt);
      int i5 = b.a();
      int i6 = Math.min(i5 - 1, paramInt + c);
      Object localObject1;
      if (i5 != i) {
        try
        {
          String str = getResources().getResourceName(getId());
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + i + ", found: " + i5 + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + b.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          for (;;)
          {
            localObject1 = Integer.toHexString(getId());
          }
        }
      }
      paramInt = 0;
      if (paramInt < l.size())
      {
        localObject1 = (sr)l.get(paramInt);
        if (b >= c) {
          if (b != c) {
            break label1237;
          }
        }
      }
      for (;;)
      {
        if ((localObject1 == null) && (i5 > 0)) {}
        for (Object localObject3 = a(c, paramInt);; localObject3 = localObject1)
        {
          label310:
          int i8;
          float f2;
          label323:
          int i1;
          float f3;
          int i2;
          label345:
          float f1;
          if (localObject3 != null)
          {
            int i4 = paramInt - 1;
            int i3;
            Object localObject4;
            if (i4 >= 0)
            {
              localObject1 = (sr)l.get(i4);
              i8 = d();
              if (i8 > 0) {
                break label507;
              }
              f2 = 0.0F;
              i1 = c;
              f3 = 0.0F;
              i3 = i1 - 1;
              i2 = paramInt;
              localObject4 = localObject1;
              if (i3 < 0) {
                break label657;
              }
              if ((f3 < f2) || (i3 >= i7)) {
                break label537;
              }
              if (localObject4 == null) {
                break label657;
              }
              localObject1 = localObject4;
              paramInt = i4;
              f1 = f3;
              i1 = i2;
              if (i3 == b)
              {
                localObject1 = localObject4;
                paramInt = i4;
                f1 = f3;
                i1 = i2;
                if (!c)
                {
                  l.remove(i4);
                  b.a(this, i3, a);
                  paramInt = i4 - 1;
                  i1 = i2 - 1;
                  if (paramInt < 0) {
                    break label528;
                  }
                  localObject1 = (sr)l.get(paramInt);
                  f1 = f3;
                }
              }
            }
            for (;;)
            {
              i3 -= 1;
              localObject4 = localObject1;
              i4 = paramInt;
              f3 = f1;
              i2 = i1;
              break label345;
              paramInt += 1;
              break;
              localObject1 = null;
              break label310;
              label507:
              f2 = 2.0F - d + getPaddingLeft() / i8;
              break label323;
              label528:
              localObject1 = null;
              f1 = f3;
              continue;
              label537:
              if ((localObject4 != null) && (i3 == b))
              {
                f1 = f3 + d;
                paramInt = i4 - 1;
                if (paramInt >= 0)
                {
                  localObject1 = (sr)l.get(paramInt);
                  i1 = i2;
                }
                else
                {
                  localObject1 = null;
                  i1 = i2;
                }
              }
              else
              {
                f1 = f3 + a1d;
                i1 = i2 + 1;
                if (i4 >= 0)
                {
                  localObject1 = (sr)l.get(i4);
                  paramInt = i4;
                }
                else
                {
                  localObject1 = null;
                  paramInt = i4;
                }
              }
            }
            label657:
            f1 = d;
            paramInt = i2 + 1;
            if (f1 < 2.0F) {
              if (paramInt < l.size())
              {
                localObject1 = (sr)l.get(paramInt);
                label698:
                if (i8 > 0) {
                  break label823;
                }
                f2 = 0.0F;
                label705:
                i1 = c;
                i1 += 1;
                label717:
                if (i1 >= i5) {
                  break label966;
                }
                if ((f1 < f2) || (i1 <= i6)) {
                  break label844;
                }
                if (localObject1 == null) {
                  break label966;
                }
                if ((i1 != b) || (c)) {
                  break label1227;
                }
                l.remove(paramInt);
                b.a(this, i1, a);
                if (paramInt >= l.size()) {
                  break label838;
                }
                localObject1 = (sr)l.get(paramInt);
              }
            }
          }
          label823:
          label838:
          label844:
          label966:
          label1219:
          label1225:
          label1227:
          for (;;)
          {
            i1 += 1;
            break label717;
            localObject1 = null;
            break label698;
            f2 = getPaddingRight() / i8 + 2.0F;
            break label705;
            localObject1 = null;
            continue;
            if ((localObject1 != null) && (i1 == b))
            {
              f3 = d;
              paramInt += 1;
              if (paramInt < l.size()) {}
              for (localObject1 = (sr)l.get(paramInt);; localObject1 = null)
              {
                f1 += f3;
                break;
              }
            }
            localObject1 = a(i1, paramInt);
            paramInt += 1;
            f3 = d;
            if (paramInt < l.size()) {}
            for (localObject1 = (sr)l.get(paramInt);; localObject1 = null)
            {
              f1 += f3;
              break;
            }
            a((sr)localObject3, i2, (sr)localObject2);
            localObject2 = b;
            paramInt = c;
            if (localObject3 != null) {}
            for (localObject1 = a;; localObject1 = null)
            {
              ((qv)localObject2).b(this, paramInt, localObject1);
              b.b();
              i1 = getChildCount();
              paramInt = 0;
              while (paramInt < i1)
              {
                localObject2 = getChildAt(paramInt);
                localObject1 = (ss)((View)localObject2).getLayoutParams();
                f = paramInt;
                if ((!a) && (c == 0.0F))
                {
                  localObject2 = a((View)localObject2);
                  if (localObject2 != null)
                  {
                    c = d;
                    e = b;
                  }
                }
                paramInt += 1;
              }
            }
            e();
            if (!hasFocus()) {
              break;
            }
            localObject1 = findFocus();
            if (localObject1 != null) {}
            for (localObject1 = b((View)localObject1);; localObject1 = null)
            {
              if ((localObject1 != null) && (b == c)) {
                break label1225;
              }
              paramInt = 0;
              for (;;)
              {
                if (paramInt >= getChildCount()) {
                  break label1219;
                }
                localObject1 = getChildAt(paramInt);
                localObject2 = a((View)localObject1);
                if ((localObject2 != null) && (b == c) && (((View)localObject1).requestFocus(2))) {
                  break;
                }
                paramInt += 1;
              }
              break;
            }
            break;
          }
        }
        label1237:
        localObject1 = null;
      }
      localObject2 = null;
    }
  }
  
  private final sr e(int paramInt)
  {
    int i1 = 0;
    while (i1 < l.size())
    {
      sr localsr = (sr)l.get(i1);
      if (b == paramInt) {
        return localsr;
      }
      i1 += 1;
    }
    return null;
  }
  
  private final void e()
  {
    if (h != 0)
    {
      if (ag == null) {
        ag = new ArrayList();
      }
      for (;;)
      {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2)
        {
          View localView = getChildAt(i1);
          ag.add(localView);
          i1 += 1;
        }
        ag.clear();
      }
      Collections.sort(ag, ah);
    }
  }
  
  private final boolean f()
  {
    O = -1;
    F = false;
    G = false;
    if (P != null)
    {
      P.recycle();
      P = null;
    }
    return V.c() | W.c();
  }
  
  private final boolean f(int paramInt)
  {
    if (l.size() == 0)
    {
      if (aa) {}
      do
      {
        return false;
        ac = false;
        a(0, 0.0F, 0);
      } while (ac);
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    sr localsr = h();
    int i2 = d();
    int i3 = u;
    float f1 = u / i2;
    int i1 = b;
    f1 = (paramInt / i2 - e) / (d + f1);
    paramInt = (int)((i3 + i2) * f1);
    ac = false;
    a(i1, f1, paramInt);
    if (!ac) {
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    return true;
  }
  
  private final void g()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private final void g(int paramInt)
  {
    if (e != null) {
      e.a_(paramInt);
    }
    if (ae != null)
    {
      int i2 = ae.size();
      int i1 = 0;
      while (i1 < i2)
      {
        su localsu = (su)ae.get(i1);
        if (localsu != null) {
          localsu.a_(paramInt);
        }
        i1 += 1;
      }
    }
    if (af != null) {
      af.a_(paramInt);
    }
  }
  
  private final sr h()
  {
    int i1 = d();
    float f1;
    float f2;
    label36:
    float f4;
    float f3;
    int i3;
    int i2;
    Object localObject1;
    label53:
    Object localObject2;
    sr localsr;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0) {
        break label203;
      }
      f2 = u / i1;
      f4 = 0.0F;
      f3 = 0.0F;
      i3 = -1;
      i1 = 0;
      i2 = 1;
      localObject1 = null;
      localObject2 = localObject1;
      if (i1 < l.size())
      {
        localsr = (sr)l.get(i1);
        if ((i2 != 0) || (b == i3 + 1)) {
          break label238;
        }
        localsr = m;
        e = (f4 + f3 + f2);
        b = (i3 + 1);
        d = 1.0F;
        i1 -= 1;
      }
    }
    label203:
    label208:
    label238:
    for (;;)
    {
      f3 = e;
      f4 = d;
      if (i2 == 0)
      {
        localObject2 = localObject1;
        if (f1 < f3) {}
      }
      else
      {
        if ((f1 >= f4 + f3 + f2) && (i1 != l.size() - 1)) {
          break label208;
        }
        localObject2 = localsr;
      }
      return (sr)localObject2;
      f1 = 0.0F;
      break;
      f2 = 0.0F;
      break label36;
      i3 = b;
      f4 = d;
      i2 = 0;
      i1 += 1;
      localObject1 = localsr;
      break label53;
    }
  }
  
  private final boolean h(int paramInt)
  {
    View localView = findFocus();
    Object localObject;
    int i2;
    boolean bool;
    if (localView == this)
    {
      localObject = null;
      localView = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
      if ((localView == null) || (localView == localObject)) {
        break label317;
      }
      if (paramInt != 17) {
        break label263;
      }
      i1 = an, localView).left;
      i2 = an, (View)localObject).left;
      if ((localObject != null) && (i1 >= i2))
      {
        bool = i();
        label89:
        if (bool) {
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        }
        return bool;
      }
    }
    else
    {
      if (localView == null) {
        break label363;
      }
      localObject = localView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label370;
      }
      if (localObject != this) {}
    }
    label263:
    label317:
    label357:
    label363:
    label370:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView.getClass().getSimpleName());
        localObject = localView.getParent();
        for (;;)
        {
          if ((localObject instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localObject.getClass().getSimpleName());
            localObject = ((ViewParent)localObject).getParent();
            continue;
            localObject = ((ViewParent)localObject).getParent();
            break;
          }
        }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localObject = null;
        break;
        bool = localView.requestFocus();
        break label89;
        if (paramInt == 66)
        {
          i1 = an, localView).left;
          i2 = an, (View)localObject).left;
          if ((localObject == null) || (i1 > i2))
          {
            bool = localView.requestFocus();
            break label89;
            if ((paramInt == 17) || (paramInt == 1))
            {
              bool = i();
              break label89;
            }
            if ((paramInt != 66) && (paramInt != 2)) {
              break label357;
            }
          }
          bool = j();
          break label89;
        }
        bool = false;
        break label89;
      }
      localObject = localView;
      break;
    }
  }
  
  private final boolean i()
  {
    if (c > 0)
    {
      a(c - 1, true);
      return true;
    }
    return false;
  }
  
  private final boolean j()
  {
    if ((b != null) && (c < b.a() - 1))
    {
      a(c + 1, true);
      return true;
    }
    return false;
  }
  
  public final void a()
  {
    int i7 = b.a();
    i = i7;
    int i1;
    int i2;
    int i3;
    int i5;
    int i4;
    label67:
    Object localObject;
    if ((l.size() < E * 2 + 1) && (l.size() < i7))
    {
      i1 = 1;
      i2 = c;
      i3 = 0;
      i5 = 0;
      i4 = i1;
      i1 = i2;
      i2 = i3;
      i3 = i5;
      if (i3 >= l.size()) {
        break label270;
      }
      localObject = (sr)l.get(i3);
      i5 = b.b(a);
      if (i5 == -1) {
        break label354;
      }
      if (i5 != -2) {
        break label218;
      }
      l.remove(i3);
      i4 = i3 - 1;
      i3 = i2;
      if (i2 == 0) {
        i3 = 1;
      }
      b.a(this, b, a);
      if (c != b) {
        break label375;
      }
      i2 = Math.max(0, Math.min(c, i7 - 1));
      i1 = i3;
      i3 = 1;
    }
    for (;;)
    {
      i5 = i3;
      int i6 = i2;
      i3 = i4 + 1;
      i2 = i1;
      i1 = i6;
      i4 = i5;
      break label67;
      i1 = 0;
      break;
      label218:
      if (b != i5)
      {
        if (b == c) {
          i1 = i5;
        }
        b = i5;
        i5 = i1;
        i6 = 1;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
        label270:
        if (i2 != 0) {
          b.b();
        }
        Collections.sort(l, j);
        if (i4 != 0)
        {
          i3 = getChildCount();
          i2 = 0;
          while (i2 < i3)
          {
            localObject = (ss)getChildAt(i2).getLayoutParams();
            if (!a) {
              c = 0.0F;
            }
            i2 += 1;
          }
          a(i1, false, true);
          requestLayout();
        }
      }
      else
      {
        label354:
        i5 = i1;
        i6 = i4;
        i4 = i3;
        i1 = i2;
        i2 = i5;
        i3 = i6;
        continue;
        label375:
        i2 = i1;
        i5 = 1;
        i1 = i3;
        i3 = i5;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    int i3 = 0;
    if (aj == paramInt) {}
    for (;;)
    {
      return;
      aj = paramInt;
      int i1;
      if (f != null)
      {
        if (paramInt != 0)
        {
          paramInt = 1;
          int i4 = getChildCount();
          i1 = 0;
          label38:
          if (i1 >= i4) {
            break label77;
          }
          if (paramInt == 0) {
            break label72;
          }
        }
        label72:
        for (int i2 = 2;; i2 = 0)
        {
          rg.a(getChildAt(i1), i2, null);
          i1 += 1;
          break label38;
          paramInt = 0;
          break;
        }
      }
      label77:
      if (ae != null)
      {
        i1 = ae.size();
        paramInt = i3;
        while (paramInt < i1)
        {
          ae.get(paramInt);
          paramInt += 1;
        }
      }
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    D = false;
    a(paramInt, paramBoolean, false);
  }
  
  public final void a(qv paramqv)
  {
    if (b != null)
    {
      b.a(null);
      int i1 = 0;
      while (i1 < l.size())
      {
        sr localsr = (sr)l.get(i1);
        b.a(this, b, a);
        i1 += 1;
      }
      b.b();
      l.clear();
      int i2;
      for (i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
      {
        i2 = i1;
        if (!getChildAtgetLayoutParamsa)
        {
          removeViewAt(i1);
          i2 = i1 - 1;
        }
      }
      c = 0;
      scrollTo(0, 0);
    }
    b = paramqv;
    i = 0;
    boolean bool;
    if (b != null)
    {
      if (t == null) {
        t = new sw(this);
      }
      b.a(t);
      D = false;
      bool = aa;
      aa = true;
      i = b.a();
      if (o >= 0)
      {
        b.a(p, q);
        a(o, false, true);
        o = -1;
        p = null;
        q = null;
      }
    }
    else
    {
      return;
    }
    if (!bool)
    {
      b();
      return;
    }
    requestLayout();
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          sr localsr = a(localView);
          if ((localsr != null) && (b == c)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if (((i3 == 262144) && (i2 != paramArrayList.size())) || (!isFocusable())) {}
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null)) {
      return;
    }
    paramArrayList.add(this);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        sr localsr = a(localView);
        if ((localsr != null) && (b == c)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams)) {
      paramLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    for (;;)
    {
      ss localss = (ss)paramLayoutParams;
      a |= paramView instanceof sq;
      if (B)
      {
        if ((localss != null) && (a)) {
          throw new IllegalStateException("Cannot add pager decor view during layout");
        }
        d = true;
        addViewInLayout(paramView, paramInt, paramLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
  }
  
  public final void b()
  {
    d(c);
  }
  
  public final void b(int paramInt)
  {
    D = false;
    if (!aa) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }
  
  public final void c(int paramInt)
  {
    int i1 = u;
    u = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (b == null) {}
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
        i1 = d();
        i2 = getScrollX();
        if (paramInt >= 0) {
          break;
        }
      } while (i2 <= (int)(i1 * x));
      return true;
    } while ((paramInt <= 0) || (i2 >= (int)(i1 * y)));
    return true;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ss)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    s = true;
    if ((!r.isFinished()) && (r.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = r.getCurrX();
      int i4 = r.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!f(i3))
        {
          r.abortAnimation();
          scrollTo(0, i4);
        }
      }
      rg.c(this);
      return;
    }
    a(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0) {}
      switch (paramKeyEvent.getKeyCode())
      {
      default: 
        bool1 = false;
      }
    }
    for (;;)
    {
      if (bool1) {
        bool2 = true;
      }
      return bool2;
      bool1 = h(17);
      continue;
      bool1 = h(66);
      continue;
      if (Build.VERSION.SDK_INT < 11) {
        break;
      }
      if (pl.a.b(paramKeyEvent.getMetaState()))
      {
        bool1 = h(2);
      }
      else
      {
        if (!pl.a(paramKeyEvent, 1)) {
          break;
        }
        bool1 = h(1);
      }
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool1 = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool1;
    }
    int i2 = getChildCount();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= i2) {
        break;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        sr localsr = a(localView);
        if ((localsr != null) && (b == c) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i3 = 0;
    int i1 = 0;
    int i4 = rg.a(this);
    boolean bool;
    if ((i4 == 0) || ((i4 == 1) && (b != null) && (b.a() > 1)))
    {
      int i2;
      if (!V.a())
      {
        i3 = paramCanvas.save();
        i1 = getHeight() - getPaddingTop() - getPaddingBottom();
        i4 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i1 + getPaddingTop(), x * i4);
        V.a(i1, i4);
        i2 = V.a(paramCanvas) | false;
        paramCanvas.restoreToCount(i3);
      }
      i3 = i2;
      if (!W.a())
      {
        i4 = paramCanvas.save();
        i3 = getWidth();
        int i5 = getHeight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(y + 1.0F) * i3);
        W.a(i5 - i6 - i7, i3);
        bool = i2 | W.a(paramCanvas);
        paramCanvas.restoreToCount(i4);
      }
    }
    for (;;)
    {
      if (bool) {
        rg.c(this);
      }
      return;
      V.b();
      W.b();
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = d;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ss();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ss(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (h == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ag.get(i1)).getLayoutParams()).f;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    aa = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(ai);
    if ((r != null) && (!r.isFinished())) {
      r.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((u > 0) && (d != null) && (l.size() > 0) && (b != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f3 = u / i4;
      Object localObject = (sr)l.get(0);
      float f1 = e;
      int i5 = l.size();
      int i1 = b;
      int i6 = l.get(i5 - 1)).b;
      int i2 = 0;
      if (i1 < i6)
      {
        while ((i1 > b) && (i2 < i5))
        {
          localObject = l;
          i2 += 1;
          localObject = (sr)((ArrayList)localObject).get(i2);
        }
        float f2;
        if (i1 == b) {
          f2 = (e + d) * i4;
        }
        for (f1 = e + d + f3;; f1 += 1.0F + f3)
        {
          if (u + f2 > i3)
          {
            d.setBounds(Math.round(f2), v, Math.round(u + f2), w);
            d.draw(paramCanvas);
          }
          if (f2 > i3 + i4) {
            return;
          }
          i1 += 1;
          break;
          f2 = (1.0F + f1) * i4;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 == 3) || (i1 == 1)) {
      f();
    }
    do
    {
      return false;
      if (i1 == 0) {
        break;
      }
      if (F) {
        return true;
      }
    } while (G);
    switch (i1)
    {
    }
    for (;;)
    {
      if (P == null) {
        P = VelocityTracker.obtain();
      }
      P.addMovement(paramMotionEvent);
      return F;
      i1 = O;
      if (i1 != -1)
      {
        i1 = qk.a(paramMotionEvent, i1);
        float f2 = qk.c(paramMotionEvent, i1);
        float f1 = f2 - K;
        float f4 = Math.abs(f1);
        float f3 = qk.d(paramMotionEvent, i1);
        float f5 = Math.abs(f3 - N);
        if (f1 != 0.0F)
        {
          float f6 = K;
          if (((f6 < I) && (f1 > 0.0F)) || ((f6 > getWidth() - I) && (f1 < 0.0F))) {}
          for (i1 = 1; (i1 == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)); i1 = 0)
          {
            K = f2;
            L = f3;
            G = true;
            return false;
          }
        }
        if ((f4 > J) && (0.5F * f4 > f5))
        {
          F = true;
          g();
          a(1);
          if (f1 > 0.0F)
          {
            f1 = M + J;
            label328:
            K = f1;
            L = f3;
            b(true);
          }
        }
        while ((F) && (a(f2)))
        {
          rg.c(this);
          break;
          f1 = M - J;
          break label328;
          if (f5 > J) {
            G = true;
          }
        }
        f1 = paramMotionEvent.getX();
        M = f1;
        K = f1;
        f1 = paramMotionEvent.getY();
        N = f1;
        L = f1;
        O = qk.b(paramMotionEvent, 0);
        G = false;
        s = true;
        r.computeScrollOffset();
        if ((aj == 2) && (Math.abs(r.getFinalX() - r.getCurrX()) > T))
        {
          r.abortAnimation();
          D = false;
          b();
          F = true;
          g();
          a(1);
        }
        else
        {
          a(false);
          F = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i6 = getChildCount();
    int i8 = paramInt3 - paramInt1;
    int i7 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i1 = getPaddingRight();
    paramInt3 = getPaddingBottom();
    int i9 = getScrollX();
    int i2 = 0;
    int i4 = 0;
    View localView;
    ss localss;
    int i10;
    int i3;
    label154:
    int i5;
    if (i4 < i6)
    {
      localView = getChildAt(i4);
      if (localView.getVisibility() == 8) {
        break label671;
      }
      localss = (ss)localView.getLayoutParams();
      if (!a) {
        break label671;
      }
      paramInt4 = b;
      i10 = b;
      switch (paramInt4 & 0x7)
      {
      case 2: 
      case 4: 
      default: 
        paramInt4 = paramInt2;
        i3 = paramInt2;
        switch (i10 & 0x70)
        {
        default: 
          i5 = paramInt1;
          paramInt2 = paramInt1;
          paramInt1 = paramInt3;
          paramInt3 = i5;
          label204:
          paramInt4 += i9;
          localView.layout(paramInt4, paramInt3, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt3);
          i2 += 1;
          paramInt4 = i1;
          paramInt3 = i3;
          i1 = paramInt1;
          paramInt1 = i2;
        }
        break;
      }
    }
    for (;;)
    {
      i4 += 1;
      i3 = paramInt3;
      i2 = paramInt1;
      paramInt1 = paramInt2;
      paramInt3 = i1;
      i1 = paramInt4;
      paramInt2 = i3;
      break;
      i3 = localView.getMeasuredWidth();
      paramInt4 = paramInt2;
      i3 += paramInt2;
      break label154;
      paramInt4 = Math.max((i8 - localView.getMeasuredWidth()) / 2, paramInt2);
      i3 = paramInt2;
      break label154;
      i3 = localView.getMeasuredWidth();
      paramInt4 = i1 + localView.getMeasuredWidth();
      i5 = i8 - i1 - i3;
      i1 = paramInt4;
      i3 = paramInt2;
      paramInt4 = i5;
      break label154;
      i5 = localView.getMeasuredHeight();
      paramInt2 = paramInt3;
      i5 += paramInt1;
      paramInt3 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i5;
      break label204;
      i5 = Math.max((i7 - localView.getMeasuredHeight()) / 2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      paramInt3 = i5;
      break label204;
      i5 = i7 - paramInt3 - localView.getMeasuredHeight();
      i10 = localView.getMeasuredHeight();
      paramInt2 = paramInt1;
      paramInt1 = paramInt3 + i10;
      paramInt3 = i5;
      break label204;
      i1 = i8 - paramInt2 - i1;
      paramInt4 = 0;
      while (paramInt4 < i6)
      {
        localView = getChildAt(paramInt4);
        if (localView.getVisibility() != 8)
        {
          localss = (ss)localView.getLayoutParams();
          if (!a)
          {
            sr localsr = a(localView);
            if (localsr != null)
            {
              float f1 = i1;
              i3 = (int)(e * f1) + paramInt2;
              if (d)
              {
                d = false;
                f1 = i1;
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(c * f1), 1073741824), View.MeasureSpec.makeMeasureSpec(i7 - paramInt1 - paramInt3, 1073741824));
              }
              localView.layout(i3, paramInt1, localView.getMeasuredWidth() + i3, localView.getMeasuredHeight() + paramInt1);
            }
          }
        }
        paramInt4 += 1;
      }
      v = paramInt1;
      w = (i7 - paramInt3);
      ad = i2;
      if (aa) {
        a(c, false, 0, false);
      }
      aa = false;
      return;
      label671:
      paramInt4 = i2;
      i2 = paramInt1;
      i3 = paramInt2;
      paramInt1 = paramInt4;
      paramInt4 = i1;
      i1 = paramInt3;
      paramInt2 = i2;
      paramInt3 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    I = Math.min(paramInt1 / 10, H);
    paramInt1 = paramInt1 - getPaddingLeft() - getPaddingRight();
    paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i9 = getChildCount();
    int i3 = 0;
    View localView;
    int i1;
    int i2;
    ss localss;
    int i4;
    int i6;
    label183:
    int i5;
    if (i3 < i9)
    {
      localView = getChildAt(i3);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localss = (ss)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localss != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (a)
          {
            i1 = b & 0x7;
            i4 = b & 0x70;
            i6 = Integer.MIN_VALUE;
            i2 = Integer.MIN_VALUE;
            if ((i4 != 48) && (i4 != 80)) {
              break label333;
            }
            i4 = 1;
            if ((i1 != 3) && (i1 != 5)) {
              break label339;
            }
            i5 = 1;
            label198:
            if (i4 == 0) {
              break label345;
            }
            i1 = 1073741824;
            label208:
            if (width == -2) {
              break label528;
            }
            i6 = 1073741824;
            if (width == -1) {
              break label522;
            }
            i1 = width;
          }
        }
      }
    }
    for (;;)
    {
      int i8;
      if (height != -2)
      {
        i7 = 1073741824;
        i2 = i7;
        if (height != -1)
        {
          i8 = height;
          i2 = i7;
        }
      }
      for (int i7 = i8;; i7 = paramInt2)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(i1, i6), View.MeasureSpec.makeMeasureSpec(i7, i2));
        if (i4 != 0)
        {
          i2 = paramInt2 - localView.getMeasuredHeight();
          i1 = paramInt1;
        }
        for (;;)
        {
          i3 += 1;
          paramInt1 = i1;
          paramInt2 = i2;
          break;
          label333:
          i4 = 0;
          break label183;
          label339:
          i5 = 0;
          break label198;
          label345:
          i1 = i6;
          if (i5 == 0) {
            break label208;
          }
          i2 = 1073741824;
          i1 = i6;
          break label208;
          i1 = paramInt1;
          i2 = paramInt2;
          if (i5 != 0)
          {
            i1 = paramInt1 - localView.getMeasuredWidth();
            i2 = paramInt2;
          }
        }
        z = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
        A = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
        B = true;
        b();
        B = false;
        i1 = getChildCount();
        paramInt2 = 0;
        while (paramInt2 < i1)
        {
          localView = getChildAt(paramInt2);
          if (localView.getVisibility() != 8)
          {
            localss = (ss)localView.getLayoutParams();
            if ((localss == null) || (!a))
            {
              float f1 = paramInt1;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(c * f1), 1073741824), A);
            }
          }
          paramInt2 += 1;
        }
        return;
      }
      label522:
      i1 = paramInt1;
      continue;
      label528:
      i6 = i1;
      i1 = paramInt1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i3 = -1;
    int i2 = getChildCount();
    int i1;
    if ((paramInt & 0x2) != 0)
    {
      i3 = 1;
      i1 = 0;
    }
    while (i1 != i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        sr localsr = a(localView);
        if ((localsr != null) && (b == c) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i1 = i2 - 1;
          i2 = -1;
          continue;
        }
      }
      i1 += i3;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (b != null)
    {
      b.a(b, c);
      a(a, false, true);
      return;
    }
    o = a;
    p = b;
    q = c;
  }
  
  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    a = c;
    if (b != null) {
      b = b.d();
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      a(paramInt1, paramInt3, u, u);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (U) {
      return true;
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    if ((b == null) || (b.a() == 0)) {
      return false;
    }
    if (P == null) {
      P = VelocityTracker.obtain();
    }
    P.addMovement(paramMotionEvent);
    boolean bool1 = bool2;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1) {
        rg.c(this);
      }
      return true;
      r.abortAnimation();
      D = false;
      b();
      float f1 = paramMotionEvent.getX();
      M = f1;
      K = f1;
      f1 = paramMotionEvent.getY();
      N = f1;
      L = f1;
      O = qk.b(paramMotionEvent, 0);
      bool1 = bool2;
      continue;
      int i1;
      float f2;
      if (!F)
      {
        i1 = qk.a(paramMotionEvent, O);
        if (i1 == -1)
        {
          bool1 = f();
          continue;
        }
        f1 = qk.c(paramMotionEvent, i1);
        float f3 = Math.abs(f1 - K);
        f2 = qk.d(paramMotionEvent, i1);
        float f4 = Math.abs(f2 - L);
        if ((f3 > J) && (f3 > f4))
        {
          F = true;
          g();
          if (f1 - M <= 0.0F) {
            break label392;
          }
        }
      }
      Object localObject;
      label392:
      for (f1 = M + J;; f1 = M - J)
      {
        K = f1;
        L = f2;
        a(1);
        b(true);
        localObject = getParent();
        if (localObject != null) {
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
        }
        bool1 = bool2;
        if (!F) {
          break;
        }
        bool1 = a(qk.c(paramMotionEvent, qk.a(paramMotionEvent, O))) | false;
        break;
      }
      bool1 = bool2;
      if (F)
      {
        localObject = P;
        ((VelocityTracker)localObject).computeCurrentVelocity(1000, R);
        int i3 = (int)rc.a((VelocityTracker)localObject, O);
        D = true;
        int i2 = d();
        int i4 = getScrollX();
        localObject = h();
        f1 = u / i2;
        i1 = b;
        f2 = (i4 / i2 - e) / (d + f1);
        if ((Math.abs((int)(qk.c(paramMotionEvent, qk.a(paramMotionEvent, O)) - M)) > S) && (Math.abs(i3) > Q))
        {
          if (i3 > 0) {}
          for (;;)
          {
            i2 = i1;
            if (l.size() > 0)
            {
              paramMotionEvent = (sr)l.get(0);
              localObject = (sr)l.get(l.size() - 1);
              i2 = Math.max(b, Math.min(i1, b));
            }
            a(i2, true, true, i3);
            bool1 = f();
            break;
            i1 += 1;
          }
        }
        if (i1 >= c) {}
        for (f1 = 0.4F;; f1 = 0.6F)
        {
          i1 = (int)(i1 + f2 + f1);
          break;
        }
        bool1 = bool2;
        if (F)
        {
          a(c, true, 0, false);
          bool1 = f();
          continue;
          i1 = qk.b(paramMotionEvent);
          K = qk.c(paramMotionEvent, i1);
          O = qk.b(paramMotionEvent, i1);
          bool1 = bool2;
          continue;
          a(paramMotionEvent);
          K = qk.c(paramMotionEvent, qk.a(paramMotionEvent, O));
          bool1 = bool2;
        }
      }
    }
  }
  
  public void removeView(View paramView)
  {
    if (B)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == d);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewPager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */