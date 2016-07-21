package android.support.v7.widget;

import agb;
import ahr;
import ajj;
import ajk;
import ajl;
import akd;
import ake;
import akf;
import akp;
import aks;
import aku;
import akw;
import akx;
import akz;
import ala;
import alg;
import alh;
import alj;
import alk;
import alr;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import mn;
import rg;
import rt;
import ub;
import vk;

public final class LinearLayoutManager
  extends akw
{
  int a;
  public akd b;
  boolean c = false;
  int d = -1;
  int e = Integer.MIN_VALUE;
  LinearLayoutManager.SavedState f = null;
  final ajj g = new ajj(this);
  private ajl s;
  private boolean t;
  private boolean u = false;
  private boolean v = false;
  private boolean w = true;
  private boolean x;
  
  public LinearLayoutManager()
  {
    a(null);
    if (1 != a)
    {
      a = 1;
      b = null;
      g();
    }
    a(null);
    if (u)
    {
      u = false;
      g();
    }
    m = true;
  }
  
  private final int a(int paramInt, ala paramala, alg paramalg, boolean paramBoolean)
  {
    int i = b.c() - paramInt;
    if (i > 0)
    {
      int j = -c(-i, paramala, paramalg);
      i = j;
      if (paramBoolean)
      {
        paramInt = b.c() - (paramInt + j);
        i = j;
        if (paramInt > 0)
        {
          b.a(paramInt);
          i = j + paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private final int a(ala paramala, ajl paramajl, alg paramalg, boolean paramBoolean)
  {
    int i1 = c;
    if (g != Integer.MIN_VALUE)
    {
      if (c < 0) {
        g += c;
      }
      a(paramala, paramajl);
    }
    int i = c;
    int j = h;
    ajk localajk = new ajk();
    int k = i + j;
    label152:
    Object localObject1;
    if ((l) || (k > 0))
    {
      if ((d < 0) || (d >= paramalg.a())) {
        break label377;
      }
      i = 1;
      if (i != 0)
      {
        a = 0;
        b = false;
        c = false;
        d = false;
        if (k == null) {
          break label398;
        }
        j = k.size();
        i = 0;
        if (i >= j) {
          break label392;
        }
        localObject1 = k.get(i)).a;
        localObject2 = (akx)((View)localObject1).getLayoutParams();
        if ((a.l()) || (d != a.c())) {
          break label383;
        }
        paramajl.a((View)localObject1);
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label1728;
      }
      b = true;
      if (!b)
      {
        b += a * f;
        if ((c) && (s.k == null) && (g)) {
          break label2308;
        }
        c -= a;
        i = k - a;
        label307:
        if (g != Integer.MIN_VALUE)
        {
          g += a;
          if (c < 0) {
            g += c;
          }
          a(paramala, paramajl);
        }
        if ((!paramBoolean) || (!d)) {
          break label2301;
        }
      }
      return i1 - c;
      label377:
      i = 0;
      break;
      label383:
      i += 1;
      break label152;
      label392:
      localObject1 = null;
    }
    label398:
    int n = d;
    if ((n < 0) || (n >= f.A.a())) {
      throw new IndexOutOfBoundsException("Invalid item position " + n + "(" + n + "). Item count:" + f.A.a());
    }
    j = 0;
    Object localObject2 = null;
    boolean bool1;
    if (f.A.g)
    {
      localObject2 = paramala.b(n);
      if (localObject2 != null)
      {
        i = 1;
        j = i;
      }
    }
    else
    {
      localObject1 = localObject2;
      i = j;
      if (localObject2 == null)
      {
        localObject2 = paramala.a(n, false);
        localObject1 = localObject2;
        i = j;
        if (localObject2 != null)
        {
          if (!((alj)localObject2).l()) {
            break label724;
          }
          bool1 = f.A.g;
          label571:
          if (bool1) {
            break label891;
          }
          ((alj)localObject2).b(4);
          if (!((alj)localObject2).d()) {
            break label875;
          }
          f.removeDetachedView(a, false);
          ((alj)localObject2).e();
          label608:
          paramala.a((alj)localObject2);
          localObject1 = null;
          i = j;
        }
      }
    }
    label724:
    label875:
    label891:
    label962:
    Object localObject3;
    for (;;)
    {
      if (localObject1 == null)
      {
        j = f.d.b(n);
        if ((j < 0) || (j >= f.i.b()))
        {
          throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + n + "(offset:" + j + ")." + "state:" + f.A.a());
          i = 0;
          break;
          if ((b < 0) || (b >= f.i.b())) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
          }
          if (!f.A.g)
          {
            localObject1 = f.i;
            i = b;
            if (e != 0)
            {
              bool1 = false;
              break label571;
            }
          }
          if (f.i.a)
          {
            long l = d;
            localObject1 = f.i;
            i = b;
            if (l != -1L)
            {
              bool1 = false;
              break label571;
            }
          }
          bool1 = true;
          break label571;
          if (!((alj)localObject2).f()) {
            break label608;
          }
          ((alj)localObject2).g();
          break label608;
          i = 1;
          localObject1 = localObject2;
          continue;
        }
        localObject2 = f.i;
        if (f.i.a)
        {
          localObject1 = f.i;
          localObject2 = paramala.a(-1L, 0, false);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            b = j;
            i = 1;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (e != null)
              {
                localObject3 = e.a();
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject2 = f.a((View)localObject3);
                  if (localObject2 == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                  }
                  localObject1 = localObject2;
                  if (((alj)localObject2).b()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = (ArrayList)ca.get(0);
              if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
              {
                j = ((ArrayList)localObject2).size() - 1;
                localObject1 = (alj)((ArrayList)localObject2).get(j);
                ((ArrayList)localObject2).remove(j);
                label1117:
                if (localObject1 != null)
                {
                  ((alj)localObject1).p();
                  if ((RecyclerView.a) && ((a instanceof ViewGroup))) {
                    paramala.a((ViewGroup)a, false);
                  }
                }
                localObject2 = localObject1;
              }
            }
            else
            {
              if (localObject2 != null) {
                break label2315;
              }
              localObject1 = f.i;
              mn.a("RV CreateView");
              localObject1 = ((akp)localObject1).a();
              e = 0;
              mn.a();
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (!f.A.g) && (((alj)localObject1).a(8192)))
      {
        ((alj)localObject1).a(0, 8192);
        if (f.A.h)
        {
          aks.d((alj)localObject1);
          localObject2 = f.x;
          localObject2 = f.A;
          ((alj)localObject1).o();
          localObject2 = new aku();
          localObject3 = a;
          a = ((View)localObject3).getLeft();
          b = ((View)localObject3).getTop();
          c = ((View)localObject3).getRight();
          d = ((View)localObject3).getBottom();
          f.a((alj)localObject1, (aku)localObject2);
        }
      }
      j = 0;
      if ((f.A.g) && (((alj)localObject1).k()))
      {
        f = n;
        j = 0;
        label1379:
        localObject2 = a.getLayoutParams();
        if (localObject2 != null) {
          break label1673;
        }
        localObject2 = (akx)f.generateDefaultLayoutParams();
        a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        label1416:
        a = ((alj)localObject1);
        if ((i == 0) || (j == 0)) {
          break label1722;
        }
      }
      int m;
      label1673:
      label1722:
      for (bool1 = true;; bool1 = false)
      {
        d = bool1;
        localObject1 = a;
        d += e;
        break;
        localObject1 = null;
        break label1117;
        if ((!((alj)localObject1).k()) || (((alj)localObject1).j()) || (((alj)localObject1).i()))
        {
          j = f.d.b(n);
          o = f;
          localObject2 = f.i;
          b = j;
          if (a) {
            d = -1L;
          }
          ((alj)localObject1).a(1, 519);
          mn.a("RV OnBindView");
          ((alj)localObject1).o();
          ((alj)localObject1).n();
          mn.a();
          localObject2 = a;
          if (f.i())
          {
            if (rg.d((View)localObject2) == 0) {
              rg.c((View)localObject2, 1);
            }
            if (!rg.a.b((View)localObject2)) {
              rg.a((View)localObject2, f.E.c);
            }
          }
          m = 1;
          j = m;
          if (f.A.g)
          {
            f = n;
            j = m;
          }
        }
        break label1379;
        if (!f.checkLayoutParams((ViewGroup.LayoutParams)localObject2))
        {
          localObject2 = (akx)f.generateLayoutParams((ViewGroup.LayoutParams)localObject2);
          a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          break label1416;
        }
        localObject2 = (akx)localObject2;
        break label1416;
      }
      label1728:
      localObject2 = (akx)((View)localObject1).getLayoutParams();
      boolean bool2;
      if (k == null)
      {
        bool2 = c;
        if (f == -1)
        {
          bool1 = true;
          label1762:
          if (bool2 != bool1) {
            break label2116;
          }
          super.a((View)localObject1, -1, false);
          label1777:
          localObject3 = (akx)((View)localObject1).getLayoutParams();
          Rect localRect = this.i.d((View)localObject1);
          m = left;
          n = right;
          i = top;
          j = bottom;
          m = akw.a(q, o, m + n + 0 + (j() + l() + leftMargin + rightMargin), width, c());
          i = akw.a(r, p, j + i + 0 + (k() + m() + topMargin + bottomMargin), height, d());
          if (a((View)localObject1, m, i, (akx)localObject3)) {
            ((View)localObject1).measure(m, i);
          }
          a = b.c((View)localObject1);
          if (a != 1) {
            break label2231;
          }
          if (!p()) {
            break label2179;
          }
          i = q - l();
          j = i - b.d((View)localObject1);
          label2006:
          if (f != -1) {
            break label2202;
          }
          m = b;
          n = b - a;
        }
      }
      for (;;)
      {
        a((View)localObject1, j + leftMargin, n + topMargin, i - rightMargin, m - bottomMargin);
        if ((a.l()) || (a.r())) {
          c = true;
        }
        d = ((View)localObject1).isFocusable();
        break;
        bool1 = false;
        break label1762;
        label2116:
        super.a((View)localObject1, 0, false);
        break label1777;
        bool2 = c;
        if (f == -1) {}
        for (bool1 = true;; bool1 = false)
        {
          if (bool2 != bool1) {
            break label2168;
          }
          super.a((View)localObject1, -1, true);
          break;
        }
        label2168:
        super.a((View)localObject1, 0, true);
        break label1777;
        label2179:
        j = j();
        i = b.d((View)localObject1) + j;
        break label2006;
        label2202:
        n = b;
        m = b;
        int i2 = a;
        m += i2;
        continue;
        label2231:
        n = k();
        m = b.d((View)localObject1) + n;
        if (f == -1)
        {
          i = b;
          j = b - a;
        }
        else
        {
          j = b;
          i = b + a;
        }
      }
      label2301:
      k = i;
      break;
      label2308:
      i = k;
      break label307;
      label2315:
      localObject1 = localObject2;
      continue;
      localObject2 = localObject1;
      break label962;
    }
  }
  
  private final View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    q();
    int j = b.b();
    int k = b.c();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label125;
      }
      localView = c(paramInt1);
      int m = b.a(localView);
      int n = b.b(localView);
      if ((m >= k) || (n <= j)) {
        break label128;
      }
      if ((paramBoolean1) && ((m < j) || (n > k))) {
        break;
      }
      return localView;
    }
    if (localObject == null) {
      localObject = localView;
    }
    label125:
    label128:
    for (;;)
    {
      paramInt1 += i;
      break;
      return (View)localObject;
    }
  }
  
  private final View a(boolean paramBoolean)
  {
    if (c) {
      return a(i() - 1, -1, paramBoolean, true);
    }
    return a(0, i(), paramBoolean, true);
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean, alg paramalg)
  {
    int i = -1;
    int j = 1;
    s.l = r();
    s.h = g(paramalg);
    s.f = paramInt1;
    if (paramInt1 == 1)
    {
      paramalg = s;
      h += b.f();
      paramalg = t();
      localajl = s;
      if (c) {}
      for (paramInt1 = i;; paramInt1 = 1)
      {
        e = paramInt1;
        s.d = (a(paramalg) + s.e);
        s.b = b.b(paramalg);
        paramInt1 = b.b(paramalg) - b.c();
        s.c = paramInt2;
        if (paramBoolean)
        {
          paramalg = s;
          c -= paramInt1;
        }
        s.g = paramInt1;
        return;
      }
    }
    paramalg = s();
    ajl localajl = s;
    h += b.b();
    localajl = s;
    if (c) {}
    for (paramInt1 = j;; paramInt1 = -1)
    {
      e = paramInt1;
      s.d = (a(paramalg) + s.e);
      s.b = b.a(paramalg);
      paramInt1 = -b.a(paramalg) + b.b();
      break;
    }
  }
  
  private final void a(ajj paramajj)
  {
    i(a, b);
  }
  
  private final void a(ala paramala, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {}
    for (;;)
    {
      return;
      int i = paramInt1;
      if (paramInt2 > paramInt1)
      {
        paramInt2 -= 1;
        while (paramInt2 >= paramInt1)
        {
          a(paramInt2, paramala);
          paramInt2 -= 1;
        }
      }
      else
      {
        while (i > paramInt2)
        {
          a(i, paramala);
          i -= 1;
        }
      }
    }
  }
  
  private final void a(ala paramala, ajl paramajl)
  {
    if ((!a) || (l)) {}
    for (;;)
    {
      return;
      int i;
      int j;
      int k;
      if (f == -1)
      {
        i = g;
        j = i();
        if (i >= 0)
        {
          k = b.d() - i;
          if (c)
          {
            i = 0;
            while (i < j)
            {
              paramajl = c(i);
              if (b.a(paramajl) < k)
              {
                a(paramala, 0, i);
                return;
              }
              i += 1;
            }
          }
          else
          {
            i = j - 1;
            while (i >= 0)
            {
              paramajl = c(i);
              if (b.a(paramajl) < k)
              {
                a(paramala, j - 1, i);
                return;
              }
              i -= 1;
            }
          }
        }
      }
      else
      {
        j = g;
        if (j >= 0)
        {
          k = i();
          if (c)
          {
            i = k - 1;
            while (i >= 0)
            {
              paramajl = c(i);
              if (b.b(paramajl) > j)
              {
                a(paramala, k - 1, i);
                return;
              }
              i -= 1;
            }
          }
          else
          {
            i = 0;
            while (i < k)
            {
              paramajl = c(i);
              if (b.b(paramajl) > j)
              {
                a(paramala, 0, i);
                return;
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private final int b(int paramInt, ala paramala, alg paramalg, boolean paramBoolean)
  {
    int i = paramInt - b.b();
    if (i > 0)
    {
      int j = -c(i, paramala, paramalg);
      i = j;
      if (paramBoolean)
      {
        paramInt = paramInt + j - b.b();
        i = j;
        if (paramInt > 0)
        {
          b.a(-paramInt);
          i = j - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private final View b(boolean paramBoolean)
  {
    if (c) {
      return a(0, i(), paramBoolean, true);
    }
    return a(i() - 1, -1, paramBoolean, true);
  }
  
  private final void b(ajj paramajj)
  {
    j(a, b);
  }
  
  private final int c(int paramInt, ala paramala, alg paramalg)
  {
    if ((i() == 0) || (paramInt == 0)) {
      return 0;
    }
    s.a = true;
    q();
    if (paramInt > 0) {}
    int j;
    int k;
    for (int i = 1;; i = -1)
    {
      j = Math.abs(paramInt);
      a(i, j, true, paramalg);
      k = s.g + a(paramala, s, paramalg, false);
      if (k >= 0) {
        break;
      }
      return 0;
    }
    if (j > k) {
      paramInt = i * k;
    }
    b.a(-paramInt);
    s.j = paramInt;
    return paramInt;
  }
  
  private final View c(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = null;
    q();
    int j = b.b();
    int k = b.c();
    int i;
    Object localObject2;
    label36:
    View localView;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      localObject2 = null;
      if (paramInt1 == paramInt2) {
        break label150;
      }
      localView = c(paramInt1);
      int m = a(localView);
      if ((m < 0) || (m >= paramInt3)) {
        break label165;
      }
      if (!getLayoutParamsa.l()) {
        break label106;
      }
      if (localObject2 != null) {
        break label165;
      }
      localObject2 = localView;
    }
    label106:
    label150:
    label162:
    label165:
    for (;;)
    {
      paramInt1 += i;
      break label36;
      i = -1;
      break;
      Object localObject3;
      if (b.a(localView) < k)
      {
        localObject3 = localView;
        if (b.b(localView) >= j) {}
      }
      else
      {
        if (localObject1 != null) {
          break label165;
        }
        localObject1 = localView;
        continue;
        if (localObject1 == null) {
          break label162;
        }
        localObject3 = localObject1;
      }
      return (View)localObject3;
      return (View)localObject2;
    }
  }
  
  private final View d(ala paramala, alg paramalg)
  {
    if (c) {
      return k(paramalg);
    }
    return l(paramalg);
  }
  
  private final View e(ala paramala, alg paramalg)
  {
    if (c) {
      return l(paramalg);
    }
    return k(paramalg);
  }
  
  private final int g(alg paramalg)
  {
    int j = 0;
    if (a != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = b.e();
      }
      return j;
    }
  }
  
  private final int h(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    q();
    akd localakd = b;
    View localView;
    if (!w)
    {
      bool1 = true;
      localView = a(bool1);
      if (w) {
        break label74;
      }
    }
    label74:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.a(paramalg, localakd, localView, b(bool1), this, w, c);
      bool1 = false;
      break;
    }
  }
  
  private final int i(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    q();
    akd localakd = b;
    View localView;
    if (!w)
    {
      bool1 = true;
      localView = a(bool1);
      if (w) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.a(paramalg, localakd, localView, b(bool1), this, w);
      bool1 = false;
      break;
    }
  }
  
  private final void i(int paramInt1, int paramInt2)
  {
    s.c = (b.c() - paramInt2);
    ajl localajl = s;
    if (c) {}
    for (int i = -1;; i = 1)
    {
      e = i;
      s.d = paramInt1;
      s.f = 1;
      s.b = paramInt2;
      s.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private final int j(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    q();
    akd localakd = b;
    View localView;
    if (!w)
    {
      bool1 = true;
      localView = a(bool1);
      if (w) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.b(paramalg, localakd, localView, b(bool1), this, w);
      bool1 = false;
      break;
    }
  }
  
  private final void j(int paramInt1, int paramInt2)
  {
    s.c = (paramInt2 - b.b());
    s.d = paramInt1;
    ajl localajl = s;
    if (c) {}
    for (paramInt1 = 1;; paramInt1 = -1)
    {
      e = paramInt1;
      s.f = -1;
      s.b = paramInt2;
      s.g = Integer.MIN_VALUE;
      return;
    }
  }
  
  private final View k(alg paramalg)
  {
    return c(0, i(), paramalg.a());
  }
  
  private final View l(alg paramalg)
  {
    return c(i() - 1, -1, paramalg.a());
  }
  
  private final void o()
  {
    boolean bool = true;
    if ((a == 1) || (!p())) {
      bool = u;
    }
    for (;;)
    {
      c = bool;
      return;
      if (u) {
        bool = false;
      }
    }
  }
  
  private final boolean p()
  {
    return rg.g(i) == 1;
  }
  
  private final void q()
  {
    if (s == null) {
      s = new ajl();
    }
    if (b == null) {
      switch (a)
      {
      default: 
        throw new IllegalArgumentException("invalid orientation");
      }
    }
    for (Object localObject = new ake(this);; localObject = new akf(this))
    {
      b = ((akd)localObject);
      return;
    }
  }
  
  private final boolean r()
  {
    return (b.g() == 0) && (b.d() == 0);
  }
  
  private final View s()
  {
    if (c) {}
    for (int i = i() - 1;; i = 0) {
      return c(i);
    }
  }
  
  private final View t()
  {
    if (c) {}
    for (int i = 0;; i = i() - 1) {
      return c(i);
    }
  }
  
  public final int a(int paramInt, ala paramala, alg paramalg)
  {
    if (a == 1) {
      return 0;
    }
    return c(paramInt, paramala, paramalg);
  }
  
  public final int a(alg paramalg)
  {
    return h(paramalg);
  }
  
  public final akx a()
  {
    return new akx(-2, -2);
  }
  
  public final View a(int paramInt)
  {
    int i = i();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    View localView;
    do
    {
      return (View)localObject;
      int j = paramInt - a(c(0));
      if ((j < 0) || (j >= i)) {
        break;
      }
      localView = c(j);
      localObject = localView;
    } while (a(localView) == paramInt);
    return super.a(paramInt);
  }
  
  public final View a(View paramView, int paramInt, ala paramala, alg paramalg)
  {
    o();
    if (i() == 0) {}
    label75:
    label98:
    do
    {
      do
      {
        return null;
        switch (paramInt)
        {
        default: 
          paramInt = Integer.MIN_VALUE;
        }
      } while (paramInt == Integer.MIN_VALUE);
      q();
      if (paramInt != -1) {
        break;
      }
      paramView = e(paramala, paramalg);
    } while (paramView == null);
    q();
    a(paramInt, (int)(0.33333334F * b.e()), false, paramalg);
    s.g = Integer.MIN_VALUE;
    s.a = false;
    a(paramala, s, paramalg, true);
    if (paramInt == -1) {}
    for (paramala = s(); (paramala != paramView) && (paramala.isFocusable()); paramala = t())
    {
      return paramala;
      paramInt = -1;
      break label75;
      paramInt = 1;
      break label75;
      if (a == 1)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = Integer.MIN_VALUE;
      break label75;
      if (a == 1)
      {
        paramInt = 1;
        break label75;
      }
      paramInt = Integer.MIN_VALUE;
      break label75;
      if (a == 0)
      {
        paramInt = -1;
        break label75;
      }
      paramInt = Integer.MIN_VALUE;
      break label75;
      if (a == 0)
      {
        paramInt = 1;
        break label75;
      }
      paramInt = Integer.MIN_VALUE;
      break label75;
      paramView = d(paramala, paramalg);
      break label98;
    }
  }
  
  public final void a(ala paramala, alg paramalg)
  {
    if (((f != null) || (d != -1)) && (paramalg.a() == 0))
    {
      c(paramala);
      return;
    }
    if ((f != null) && (f.a())) {
      d = f.a;
    }
    q();
    s.a = false;
    o();
    Object localObject1 = g;
    a = -1;
    b = Integer.MIN_VALUE;
    c = false;
    g.c = (c ^ v);
    Object localObject2 = g;
    label157:
    label211:
    int j;
    label240:
    label242:
    label265:
    label290:
    int k;
    int m;
    label410:
    label423:
    int n;
    if ((g) || (d == -1))
    {
      i = 0;
      if (i == 0)
      {
        if (i() == 0) {
          break label1722;
        }
        if (this.i != null) {
          break label1224;
        }
        localObject1 = null;
        if (localObject1 == null) {
          break label1571;
        }
        akx localakx = (akx)((View)localObject1).getLayoutParams();
        if ((a.l()) || (a.c() < 0) || (a.c() >= paramalg.a())) {
          break label1259;
        }
        i = 1;
        if (i == 0) {
          break label1571;
        }
        j = d.b.a();
        if (j < 0) {
          break label1264;
        }
        ((ajj)localObject2).a((View)localObject1);
        i = 1;
        if (i == 0)
        {
          ((ajj)localObject2).a();
          if (!v) {
            break label1727;
          }
          i = paramalg.a() - 1;
          a = i;
        }
      }
      i = g(paramalg);
      if (s.j < 0) {
        break label1732;
      }
      j = 0;
      k = j + b.b();
      m = i + b.f();
      i = m;
      j = k;
      if (g)
      {
        i = m;
        j = k;
        if (d != -1)
        {
          i = m;
          j = k;
          if (e != Integer.MIN_VALUE)
          {
            localObject1 = a(d);
            i = m;
            j = k;
            if (localObject1 != null)
            {
              if (!c) {
                break label1740;
              }
              i = b.c() - b.b((View)localObject1) - e;
              if (i <= 0) {
                break label1772;
              }
              j = k + i;
              i = m;
            }
          }
        }
      }
      a(paramala);
      s.l = r();
      s.i = g;
      if (!g.c) {
        break label1784;
      }
      b(g);
      s.h = j;
      a(paramala, s, paramalg, false);
      m = s.b;
      n = s.d;
      j = i;
      if (s.c > 0) {
        j = i + s.c;
      }
      a(g);
      s.h = j;
      localObject1 = s;
      d += s.e;
      a(paramala, s, paramalg, false);
      k = s.b;
      if (s.c <= 0) {
        break label2356;
      }
      i = s.c;
      j(n, m);
      s.h = i;
      a(paramala, s, paramalg, false);
    }
    label653:
    label1129:
    label1156:
    label1162:
    label1224:
    label1259:
    label1264:
    label1571:
    label1598:
    label1664:
    label1706:
    label1711:
    label1722:
    label1727:
    label1732:
    label1740:
    label1772:
    label1784:
    label2061:
    label2103:
    label2115:
    label2173:
    label2179:
    label2333:
    label2356:
    for (int i = s.b;; i = m)
    {
      j = i;
      i = k;
      if (i() > 0) {
        if ((c ^ v))
        {
          k = a(i, paramala, paramalg, true);
          m = j + k;
          j = b(m, paramala, paramalg, false);
          m += j;
          k = i + k + j;
        }
      }
      for (;;)
      {
        boolean bool;
        int i1;
        if ((!i) || (i() == 0) || (g) || (!f()))
        {
          if (!g)
          {
            d = -1;
            e = Integer.MIN_VALUE;
            paramala = b;
            b = paramala.e();
          }
          t = v;
          f = null;
          return;
          if ((d < 0) || (d >= paramalg.a()))
          {
            d = -1;
            e = Integer.MIN_VALUE;
            i = 0;
            break;
          }
          a = d;
          if ((f != null) && (f.a()))
          {
            c = f.c;
            if (c) {}
            for (b = (b.c() - f.b);; b = (b.b() + f.b))
            {
              i = 1;
              break;
            }
          }
          if (e == Integer.MIN_VALUE)
          {
            localObject1 = a(d);
            if (localObject1 != null) {
              if (b.c((View)localObject1) > b.e()) {
                ((ajj)localObject2).a();
              }
            }
          }
          for (;;)
          {
            i = 1;
            break;
            if (b.a((View)localObject1) - b.b() < 0)
            {
              b = b.b();
              c = false;
            }
            else if (b.c() - b.b((View)localObject1) < 0)
            {
              b = b.c();
              c = true;
            }
            else
            {
              if (c) {}
              for (i = b.b((View)localObject1) + b.a();; i = b.a((View)localObject1))
              {
                b = i;
                i = 1;
                break;
              }
              if (i() > 0)
              {
                i = a(c(0));
                if (d >= i) {
                  break label1156;
                }
                bool = true;
                if (bool != c) {
                  break label1162;
                }
              }
              for (bool = true;; bool = false)
              {
                c = bool;
                ((ajj)localObject2).a();
                break;
                bool = false;
                break label1129;
              }
              c = c;
              if (c) {
                b = (b.c() - e);
              } else {
                b = (b.b() + e);
              }
            }
          }
          localObject1 = this.i.getFocusedChild();
          if ((localObject1 == null) || (h.d((View)localObject1)))
          {
            localObject1 = null;
            break label157;
          }
          break label157;
          i = 0;
          break label211;
          a = a((View)localObject1);
          if (c)
          {
            i = d.b.c() - j - d.b.b((View)localObject1);
            b = (d.b.c() - i);
            if (i <= 0) {
              break label240;
            }
            j = d.b.c((View)localObject1);
            k = b;
            m = d.b.b();
            j = k - j - (Math.min(d.b.a((View)localObject1) - m, 0) + m);
            if (j >= 0) {
              break label240;
            }
            k = b;
            b = (Math.min(i, -j) + k);
            break label240;
          }
          k = d.b.a((View)localObject1);
          i = k - d.b.b();
          b = k;
          if (i <= 0) {
            break label240;
          }
          m = d.b.c((View)localObject1);
          n = d.b.c();
          i1 = d.b.b((View)localObject1);
          j = d.b.c() - Math.min(0, n - j - i1) - (k + m);
          if (j >= 0) {
            break label240;
          }
          b -= Math.min(i, -j);
          break label240;
          if (t == v)
          {
            if (c)
            {
              localObject1 = d(paramala, paramalg);
              if (localObject1 == null) {
                break label1722;
              }
              ((ajj)localObject2).a((View)localObject1);
              if ((!g) && (f()))
              {
                if ((b.a((View)localObject1) < b.c()) && (b.b((View)localObject1) >= b.b())) {
                  break label1706;
                }
                i = 1;
                if (i != 0) {
                  if (!c) {
                    break label1711;
                  }
                }
              }
            }
            for (i = b.c();; i = b.b())
            {
              b = i;
              i = 1;
              break;
              localObject1 = e(paramala, paramalg);
              break label1598;
              i = 0;
              break label1664;
            }
          }
          i = 0;
          break label242;
          i = 0;
          break label265;
          j = i;
          i = 0;
          break label290;
          i = b.a((View)localObject1);
          j = b.b();
          i = e - (i - j);
          break label410;
          i = m - i;
          j = k;
          break label423;
          a(g);
          s.h = i;
          a(paramala, s, paramalg, false);
          k = s.b;
          n = s.d;
          i = j;
          if (s.c > 0) {
            i = j + s.c;
          }
          b(g);
          s.h = i;
          localObject1 = s;
          d += s.e;
          a(paramala, s, paramalg, false);
          m = s.b;
          i = k;
          j = m;
          if (s.c <= 0) {
            break label653;
          }
          i = s.c;
          i(n, k);
          s.h = i;
          a(paramala, s, paramalg, false);
          i = s.b;
          j = m;
          break label653;
          k = b(j, paramala, paramalg, true);
          i += k;
          n = a(i, paramala, paramalg, false);
          m = j + k + n;
          k = i + n;
          continue;
        }
        i = 0;
        j = 0;
        localObject1 = d;
        int i2 = ((List)localObject1).size();
        int i3 = a(c(0));
        n = 0;
        if (n < i2)
        {
          localObject2 = (alj)((List)localObject1).get(n);
          if (((alj)localObject2).l()) {
            break label2333;
          }
          if (((alj)localObject2).c() < i3)
          {
            bool = true;
            if (bool == c) {
              break label2173;
            }
            i1 = -1;
            if (i1 != -1) {
              break label2179;
            }
            i1 = b.c(a) + i;
            i = j;
            j = i1;
          }
        }
        for (;;)
        {
          i1 = n + 1;
          n = j;
          j = i;
          i = n;
          n = i1;
          break label2061;
          bool = false;
          break label2103;
          i1 = 1;
          break label2115;
          i1 = b.c(a) + j;
          j = i;
          i = i1;
          continue;
          s.k = ((List)localObject1);
          if (i > 0)
          {
            j(a(s()), m);
            s.h = i;
            s.c = 0;
            s.a(null);
            a(paramala, s, paramalg, false);
          }
          if (j > 0)
          {
            i(a(t()), k);
            s.h = j;
            s.c = 0;
            s.a(null);
            a(paramala, s, paramalg, false);
          }
          s.k = null;
          break;
          i1 = i;
          i = j;
          j = i1;
        }
        k = i;
        m = j;
      }
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof LinearLayoutManager.SavedState))
    {
      f = ((LinearLayoutManager.SavedState)paramParcelable);
      g();
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, ala paramala)
  {
    super.a(paramRecyclerView, paramala);
    if (x)
    {
      c(paramala);
      paramala.a();
    }
  }
  
  public final void a(AccessibilityEvent paramAccessibilityEvent)
  {
    int j = -1;
    super.a(paramAccessibilityEvent);
    View localView;
    if (i() > 0)
    {
      paramAccessibilityEvent = ub.a(paramAccessibilityEvent);
      localView = a(0, i(), false, true);
      if (localView != null) {
        break label72;
      }
      i = -1;
      paramAccessibilityEvent.b(i);
      localView = a(i() - 1, -1, false, true);
      if (localView != null) {
        break label81;
      }
    }
    label72:
    label81:
    for (int i = j;; i = a(localView))
    {
      paramAccessibilityEvent.c(i);
      return;
      i = a(localView);
      break;
    }
  }
  
  public final void a(String paramString)
  {
    if (f == null) {
      super.a(paramString);
    }
  }
  
  public final int b(int paramInt, ala paramala, alg paramalg)
  {
    if (a == 0) {
      return 0;
    }
    return c(paramInt, paramala, paramalg);
  }
  
  public final int b(alg paramalg)
  {
    return h(paramalg);
  }
  
  public final Parcelable b()
  {
    if (f != null) {
      return new LinearLayoutManager.SavedState(f);
    }
    LinearLayoutManager.SavedState localSavedState = new LinearLayoutManager.SavedState();
    if (i() > 0)
    {
      q();
      boolean bool = t ^ c;
      c = bool;
      if (bool)
      {
        localView = t();
        b = (b.c() - b.b(localView));
        a = a(localView);
        return localSavedState;
      }
      View localView = s();
      a = a(localView);
      b = (b.a(localView) - b.b());
      return localSavedState;
    }
    a = -1;
    return localSavedState;
  }
  
  public final void b(int paramInt)
  {
    d = paramInt;
    e = Integer.MIN_VALUE;
    if (f != null) {
      f.a = -1;
    }
    g();
  }
  
  public final int c(alg paramalg)
  {
    return i(paramalg);
  }
  
  public final boolean c()
  {
    return a == 0;
  }
  
  public final int d(alg paramalg)
  {
    return i(paramalg);
  }
  
  public final boolean d()
  {
    return a == 1;
  }
  
  public final int e(alg paramalg)
  {
    return j(paramalg);
  }
  
  final boolean e()
  {
    if ((p != 1073741824) && (o != 1073741824))
    {
      int j = i();
      int i = 0;
      if (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = c(i).getLayoutParams();
        if ((width >= 0) || (height >= 0)) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label75;
        }
        return true;
        i += 1;
        break;
      }
    }
    label75:
    return false;
  }
  
  public final int f(alg paramalg)
  {
    return j(paramalg);
  }
  
  public final boolean f()
  {
    return (f == null) && (t == v);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */