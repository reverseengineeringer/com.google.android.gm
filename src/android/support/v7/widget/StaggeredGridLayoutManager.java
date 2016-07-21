package android.support.v7.widget;

import agb;
import ahr;
import ajg;
import akd;
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
import amc;
import amd;
import amg;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.BitSet;
import mn;
import rg;
import rt;
import ub;
import uk;
import uw;
import vk;

public final class StaggeredGridLayoutManager
  extends akw
{
  private boolean A;
  private StaggeredGridLayoutManager.SavedState B;
  private int C;
  private final Rect D;
  private final amc E;
  private boolean F;
  private boolean G;
  private final Runnable H;
  public akd a;
  akd b;
  public boolean c;
  boolean d;
  int e;
  int f;
  public StaggeredGridLayoutManager.LazySpanLookup g;
  private int s;
  private amg[] t;
  private int u;
  private int v;
  private final ajg w;
  private BitSet x;
  private int y;
  private boolean z;
  
  private final int a(ala paramala, ajg paramajg, alg paramalg)
  {
    x.set(0, s, true);
    int i;
    int n;
    label61:
    int j;
    int k;
    if (w.i) {
      if (e == 1)
      {
        i = Integer.MAX_VALUE;
        i(e, i);
        if (!d) {
          break label232;
        }
        n = a.c();
        j = 0;
        if ((c < 0) || (c >= paramalg.a())) {
          break label244;
        }
        k = 1;
      }
    }
    int i1;
    label232:
    label244:
    Object localObject2;
    Object localObject1;
    boolean bool;
    label344:
    label381:
    label497:
    label648:
    label664:
    label735:
    Object localObject3;
    for (;;)
    {
      if ((k != 0) && ((w.i) || (!x.isEmpty())))
      {
        i1 = c;
        if ((i1 < 0) || (i1 >= f.A.a()))
        {
          throw new IndexOutOfBoundsException("Invalid item position " + i1 + "(" + i1 + "). Item count:" + f.A.a());
          i = Integer.MIN_VALUE;
          break;
          if (e == 1)
          {
            i = g + b;
            break;
          }
          i = f - b;
          break;
          n = a.b();
          break label61;
          k = 0;
          continue;
        }
        k = 0;
        localObject2 = null;
        if (f.A.g)
        {
          localObject2 = paramala.b(i1);
          if (localObject2 != null)
          {
            j = 1;
            k = j;
          }
        }
        else
        {
          localObject1 = localObject2;
          j = k;
          if (localObject2 == null)
          {
            localObject2 = paramala.a(i1, false);
            localObject1 = localObject2;
            j = k;
            if (localObject2 != null)
            {
              if (!((alj)localObject2).l()) {
                break label497;
              }
              bool = f.A.g;
              if (bool) {
                break label664;
              }
              ((alj)localObject2).b(4);
              if (!((alj)localObject2).d()) {
                break label648;
              }
              f.removeDetachedView(a, false);
              ((alj)localObject2).e();
              paramala.a((alj)localObject2);
              localObject1 = null;
              j = k;
            }
          }
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            k = f.d.b(i1);
            if ((k < 0) || (k >= f.i.b()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i1 + "(offset:" + k + ")." + "state:" + f.A.a());
              j = 0;
              break;
              if ((b < 0) || (b >= f.i.b())) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
              }
              if (!f.A.g)
              {
                localObject1 = f.i;
                j = b;
                if (e != 0)
                {
                  bool = false;
                  break label344;
                }
              }
              if (f.i.a)
              {
                long l = d;
                localObject1 = f.i;
                j = b;
                if (l != -1L)
                {
                  bool = false;
                  break label344;
                }
              }
              bool = true;
              break label344;
              if (!((alj)localObject2).f()) {
                break label381;
              }
              ((alj)localObject2).g();
              break label381;
              j = 1;
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
                b = k;
                j = 1;
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
                    k = ((ArrayList)localObject2).size() - 1;
                    localObject1 = (alj)((ArrayList)localObject2).get(k);
                    ((ArrayList)localObject2).remove(k);
                    label888:
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
                    break label2600;
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
      }
    }
    for (;;)
    {
      if ((j != 0) && (!f.A.g) && (((alj)localObject1).a(8192)))
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
      k = 0;
      label1149:
      label1186:
      label1206:
      int i3;
      label1281:
      label1290:
      label1311:
      Object localObject4;
      label1337:
      label1360:
      label1405:
      label1429:
      int m;
      if ((f.A.g) && (((alj)localObject1).k()))
      {
        f = i1;
        k = 0;
        localObject2 = a.getLayoutParams();
        if (localObject2 != null) {
          break label1926;
        }
        localObject2 = (akx)f.generateDefaultLayoutParams();
        a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        a = ((alj)localObject1);
        if ((j == 0) || (k == 0)) {
          break label1975;
        }
        bool = true;
        d = bool;
        localObject2 = a;
        c += d;
        localObject3 = (amd)((View)localObject2).getLayoutParams();
        i3 = a.c();
        localObject1 = g;
        if ((a != null) && (i3 < a.length)) {
          break label1981;
        }
        j = -1;
        if (j != -1) {
          break label1994;
        }
        i1 = 1;
        if (i1 == 0) {
          break label2010;
        }
        if (!f) {
          break label2000;
        }
        localObject1 = t[0];
        localObject4 = g;
        ((StaggeredGridLayoutManager.LazySpanLookup)localObject4).c(i3);
        a[i3] = e;
        e = ((amg)localObject1);
        if (e != 1) {
          break label2022;
        }
        a((View)localObject2, -1, false);
        if (!f) {
          break label2065;
        }
        if (u != 1) {
          break label2033;
        }
        a((View)localObject2, C, a(r, p, 0, height, true), false);
        if (e != 1) {
          break label2177;
        }
        if (!f) {
          break label2165;
        }
        j = l(n);
        k = a.c((View)localObject2) + j;
        if ((i1 == 0) || (!f)) {
          break label2593;
        }
        localObject4 = i(j);
        b = -1;
        a = i3;
        g.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject4);
        m = j;
      }
      for (;;)
      {
        if ((f) && (d == -1))
        {
          if (i1 == 0)
          {
            if (e != 1) {
              break label2295;
            }
            if (s()) {
              break label2289;
            }
            j = 1;
            label1529:
            if (j == 0) {
              break label1561;
            }
            localObject4 = g.d(i3);
            if (localObject4 != null) {
              d = true;
            }
          }
          F = true;
        }
        label1561:
        if (e == 1) {
          if (f)
          {
            h((View)localObject2);
            label1583:
            if ((!r()) || (u != 1)) {
              break label2387;
            }
            if (!f) {
              break label2357;
            }
            j = b.c();
            label1615:
            i1 = j - b.c((View)localObject2);
            if (u != 1) {
              break label2452;
            }
            b((View)localObject2, i1, m, j, k);
            label1650:
            if (!f) {
              break label2468;
            }
            i(w.e, i);
            label1671:
            a(paramala, w);
            if ((w.h) && (((View)localObject2).isFocusable()))
            {
              if (!f) {
                break label2486;
              }
              x.clear();
            }
          }
        }
        for (;;)
        {
          j = 1;
          break;
          localObject1 = null;
          break label888;
          if ((!((alj)localObject1).k()) || (((alj)localObject1).j()) || (((alj)localObject1).i()))
          {
            k = f.d.b(i1);
            o = f;
            localObject2 = f.i;
            b = k;
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
            k = m;
            if (f.A.g)
            {
              f = i1;
              k = m;
            }
          }
          break label1149;
          label1926:
          if (!f.checkLayoutParams((ViewGroup.LayoutParams)localObject2))
          {
            localObject2 = (akx)f.generateLayoutParams((ViewGroup.LayoutParams)localObject2);
            a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            break label1186;
          }
          localObject2 = (akx)localObject2;
          break label1186;
          label1975:
          bool = false;
          break label1206;
          label1981:
          j = a[i3];
          break label1281;
          label1994:
          i1 = 0;
          break label1290;
          label2000:
          localObject1 = a(paramajg);
          break label1311;
          label2010:
          localObject1 = t[j];
          break label1337;
          label2022:
          super.a((View)localObject2, 0, false);
          break label1360;
          label2033:
          a((View)localObject2, a(q, o, 0, width, true), C, false);
          break label1405;
          label2065:
          if (u == 1)
          {
            a((View)localObject2, a(v, o, 0, width, false), a(r, p, 0, height, true), false);
            break label1405;
          }
          a((View)localObject2, a(q, o, 0, width, true), a(v, p, 0, height, false), false);
          break label1405;
          label2165:
          j = ((amg)localObject1).b(n);
          break label1429;
          label2177:
          if (f) {}
          int i2;
          for (j = k(n);; j = ((amg)localObject1).a(n))
          {
            i2 = j - a.c((View)localObject2);
            k = j;
            m = i2;
            if (i1 == 0) {
              break;
            }
            k = j;
            m = i2;
            if (!f) {
              break;
            }
            localObject4 = j(j);
            b = 1;
            a = i3;
            g.a((StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem)localObject4);
            k = j;
            m = i2;
            break;
          }
          label2289:
          j = 0;
          break label1529;
          label2295:
          if (!t())
          {
            j = 1;
            break label1529;
          }
          j = 0;
          break label1529;
          e.b((View)localObject2);
          break label1583;
          if (f)
          {
            i((View)localObject2);
            break label1583;
          }
          e.a((View)localObject2);
          break label1583;
          label2357:
          j = b.c() - (s - 1 - e) * v;
          break label1615;
          label2387:
          if (f) {}
          for (j = b.b();; j = e * v + b.b())
          {
            i2 = b.c((View)localObject2);
            i1 = j;
            j = i2 + j;
            break;
          }
          label2452:
          b((View)localObject2, m, i1, k, j);
          break label1650;
          label2468:
          a((amg)localObject1, w.e, i);
          break label1671;
          label2486:
          x.set(e, false);
        }
        if (j == 0) {
          a(paramala, w);
        }
        if (w.e == -1) {
          i = k(a.b());
        }
        for (i = a.b() - i; i > 0; i = l(a.c()) - a.c()) {
          return Math.min(b, i);
        }
        return 0;
        label2593:
        m = j;
      }
      label2600:
      localObject1 = localObject2;
      continue;
      localObject2 = localObject1;
      break label735;
    }
  }
  
  private final amg a(ajg paramajg)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = -1;
    int i;
    int k;
    int i1;
    int n;
    int m;
    if (m(e))
    {
      i = s - 1;
      k = -1;
      if (e != 1) {
        break label121;
      }
      i1 = a.b();
      n = Integer.MAX_VALUE;
      m = i;
      paramajg = (ajg)localObject1;
      i = n;
      label59:
      localObject1 = paramajg;
      if (m == k) {
        break label192;
      }
      localObject1 = t[m];
      n = ((amg)localObject1).b(i1);
      if (n >= i) {
        break label198;
      }
      paramajg = (ajg)localObject1;
      i = n;
    }
    label121:
    label192:
    label195:
    label198:
    for (;;)
    {
      m += j;
      break label59;
      k = s;
      i = 0;
      j = 1;
      break;
      i1 = a.c();
      n = Integer.MIN_VALUE;
      m = i;
      paramajg = (ajg)localObject2;
      i = n;
      localObject1 = paramajg;
      if (m != k)
      {
        localObject1 = t[m];
        n = ((amg)localObject1).a(i1);
        if (n <= i) {
          break label195;
        }
        paramajg = (ajg)localObject1;
        i = n;
      }
      for (;;)
      {
        m += j;
        break;
        return (amg)localObject1;
      }
    }
  }
  
  private final View a(boolean paramBoolean)
  {
    int j = a.b();
    int k = a.c();
    int m = i();
    Object localObject = null;
    int i = 0;
    if (i < m)
    {
      View localView = c(i);
      int n = a.a(localView);
      if ((a.b(localView) <= j) || (n >= k)) {
        break label104;
      }
      if ((n >= j) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label104;
      }
      localObject = localView;
    }
    label104:
    for (;;)
    {
      i += 1;
      break;
      return (View)localObject;
    }
  }
  
  private final void a(int paramInt, alg paramalg)
  {
    boolean bool2 = false;
    w.b = 0;
    w.c = paramInt;
    int i;
    boolean bool1;
    if (h())
    {
      i = a;
      if (i != -1)
      {
        boolean bool3 = d;
        if (i < paramInt)
        {
          bool1 = true;
          if (bool3 != bool1) {
            break label189;
          }
          paramInt = a.e();
          i = 0;
        }
      }
    }
    for (;;)
    {
      label67:
      int j;
      if ((this.i != null) && (ig))
      {
        j = 1;
        label87:
        if (j == 0) {
          break label208;
        }
        w.f = (a.b() - i);
        w.g = (paramInt + a.c());
      }
      for (;;)
      {
        w.h = false;
        w.a = true;
        paramalg = w;
        bool1 = bool2;
        if (a.g() == 0)
        {
          bool1 = bool2;
          if (a.d() == 0) {
            bool1 = true;
          }
        }
        i = bool1;
        return;
        bool1 = false;
        break;
        label189:
        i = a.e();
        paramInt = 0;
        break label67;
        j = 0;
        break label87;
        label208:
        w.g = (paramInt + a.d());
        w.f = (-i);
      }
      paramInt = 0;
      i = 0;
    }
  }
  
  private final void a(ala paramala, int paramInt)
  {
    for (;;)
    {
      View localView;
      amd localamd;
      if (i() > 0)
      {
        localView = c(0);
        if (a.b(localView) <= paramInt)
        {
          localamd = (amd)localView.getLayoutParams();
          if (!f) {
            break label105;
          }
          i = 0;
          if (i >= s) {
            break label79;
          }
          if (t[i].a.size() != 1) {
            break label72;
          }
        }
      }
      label72:
      label79:
      label105:
      while (e.a.size() == 1)
      {
        for (;;)
        {
          return;
          i += 1;
        }
        int i = 0;
        while (i < s)
        {
          t[i].e();
          i += 1;
        }
      }
      e.e();
      a(localView, paramala);
    }
  }
  
  private final void a(ala paramala, ajg paramajg)
  {
    int k = 1;
    int i = 1;
    if ((!a) || (i)) {
      return;
    }
    if (b == 0)
    {
      if (e == -1)
      {
        b(paramala, g);
        return;
      }
      a(paramala, f);
      return;
    }
    int m;
    if (e == -1)
    {
      n = f;
      int i1 = f;
      for (j = t[0].a(i1); i < s; j = k)
      {
        m = t[i].a(i1);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      i = n - j;
      if (i < 0) {}
      for (i = g;; i = g - Math.min(i, b))
      {
        b(paramala, i);
        return;
      }
    }
    int n = g;
    int j = t[0].b(n);
    i = k;
    while (i < s)
    {
      m = t[i].b(n);
      k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    i = j - g;
    if (i < 0) {}
    for (i = f;; i = Math.min(i, b) + j)
    {
      a(paramala, i);
      return;
      j = f;
    }
  }
  
  private final void a(ala paramala, alg paramalg, boolean paramBoolean)
  {
    int i = l(Integer.MIN_VALUE);
    if (i == Integer.MIN_VALUE) {}
    do
    {
      do
      {
        return;
        i = a.c() - i;
      } while (i <= 0);
      i -= -c(-i, paramala, paramalg);
    } while ((!paramBoolean) || (i <= 0));
    a.a(i);
  }
  
  private final void a(amg paramamg, int paramInt1, int paramInt2)
  {
    int i = d;
    if (paramInt1 == -1) {
      if (i + paramamg.a() <= paramInt2) {
        x.set(e, false);
      }
    }
    while (paramamg.b() - i < paramInt2) {
      return;
    }
    x.set(e, false);
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = D;
    if (i == null) {
      ((Rect)localObject).set(0, 0, 0, 0);
    }
    for (;;)
    {
      localObject = (amd)paramView.getLayoutParams();
      paramInt1 = c(paramInt1, leftMargin + D.left, rightMargin + D.right);
      paramInt2 = c(paramInt2, topMargin + D.top, bottomMargin + D.bottom);
      if (a(paramView, paramInt1, paramInt2, (akx)localObject)) {
        paramView.measure(paramInt1, paramInt2);
      }
      return;
      ((Rect)localObject).set(i.d(paramView));
    }
  }
  
  private final View b(boolean paramBoolean)
  {
    int j = a.b();
    int k = a.c();
    Object localObject = null;
    int i = i() - 1;
    if (i >= 0)
    {
      View localView = c(i);
      int m = a.a(localView);
      int n = a.b(localView);
      if ((n <= j) || (m >= k)) {
        break label106;
      }
      if ((n <= k) || (!paramBoolean)) {
        return localView;
      }
      if (localObject != null) {
        break label106;
      }
      localObject = localView;
    }
    label106:
    for (;;)
    {
      i -= 1;
      break;
      return (View)localObject;
    }
  }
  
  private final void b(ala paramala, int paramInt)
  {
    int i = i() - 1;
    for (;;)
    {
      View localView;
      amd localamd;
      if (i >= 0)
      {
        localView = c(i);
        if (a.a(localView) >= paramInt)
        {
          localamd = (amd)localView.getLayoutParams();
          if (!f) {
            break label119;
          }
          j = 0;
          if (j >= s) {
            break label88;
          }
          if (t[j].a.size() != 1) {
            break label79;
          }
        }
      }
      label79:
      label88:
      label119:
      while (e.a.size() == 1)
      {
        for (;;)
        {
          return;
          j += 1;
        }
        int j = 0;
        while (j < s)
        {
          t[j].d();
          j += 1;
        }
      }
      e.d();
      a(localView, paramala);
      i -= 1;
    }
  }
  
  private final void b(ala paramala, alg paramalg, boolean paramBoolean)
  {
    int i = k(Integer.MAX_VALUE);
    if (i == Integer.MAX_VALUE) {}
    do
    {
      do
      {
        return;
        i -= a.b();
      } while (i <= 0);
      i -= c(i, paramala, paramalg);
    } while ((!paramBoolean) || (i <= 0));
    a.a(-i);
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    amd localamd = (amd)paramView.getLayoutParams();
    a(paramView, leftMargin + paramInt1, topMargin + paramInt2, paramInt3 - rightMargin, paramInt4 - bottomMargin);
  }
  
  private static int c(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) && (paramInt3 == 0)) {}
    int i;
    do
    {
      return paramInt1;
      i = View.MeasureSpec.getMode(paramInt1);
    } while ((i != Integer.MIN_VALUE) && (i != 1073741824));
    return View.MeasureSpec.makeMeasureSpec(Math.max(0, View.MeasureSpec.getSize(paramInt1) - paramInt2 - paramInt3), i);
  }
  
  private final int c(int paramInt, ala paramala, alg paramalg)
  {
    int j;
    int i;
    if (paramInt > 0)
    {
      j = u();
      i = 1;
      w.a = true;
      a(j, paramalg);
      h(i);
      w.c = (w.d + j);
      j = Math.abs(paramInt);
      w.b = j;
      i = a(paramala, w, paramalg);
      if (j >= i) {
        break label116;
      }
    }
    for (;;)
    {
      a.a(-paramInt);
      z = d;
      return paramInt;
      i = -1;
      j = v();
      break;
      label116:
      if (paramInt < 0) {
        paramInt = -i;
      } else {
        paramInt = i;
      }
    }
  }
  
  private final void d(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    int j;
    int i;
    if (d)
    {
      k = u();
      if (paramInt3 != 8) {
        break label104;
      }
      if (paramInt1 >= paramInt2) {
        break label93;
      }
      j = paramInt2 + 1;
      i = paramInt1;
      label32:
      g.b(i);
      switch (paramInt3)
      {
      default: 
        label76:
        if (j > k) {
          break;
        }
      }
    }
    for (;;)
    {
      return;
      k = v();
      break;
      label93:
      j = paramInt1 + 1;
      i = paramInt2;
      break label32;
      label104:
      j = paramInt1 + paramInt2;
      i = paramInt1;
      break label32;
      g.b(paramInt1, paramInt2);
      break label76;
      g.a(paramInt1, paramInt2);
      break label76;
      g.a(paramInt1, 1);
      g.b(paramInt2, 1);
      break label76;
      if (d) {}
      for (paramInt1 = v(); i <= paramInt1; paramInt1 = u())
      {
        g();
        return;
      }
    }
  }
  
  private final int g(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    akd localakd = a;
    View localView;
    if (!G)
    {
      bool1 = true;
      localView = a(bool1);
      if (G) {
        break label70;
      }
    }
    label70:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.a(paramalg, localakd, localView, b(bool1), this, G, d);
      bool1 = false;
      break;
    }
  }
  
  private final void g(int paramInt)
  {
    v = (paramInt / s);
    C = View.MeasureSpec.makeMeasureSpec(paramInt, b.g());
  }
  
  private final int h(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    akd localakd = a;
    View localView;
    if (!G)
    {
      bool1 = true;
      localView = a(bool1);
      if (G) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.a(paramalg, localakd, localView, b(bool1), this, G);
      bool1 = false;
      break;
    }
  }
  
  private final void h(int paramInt)
  {
    int i = 1;
    w.e = paramInt;
    ajg localajg = w;
    boolean bool2 = d;
    boolean bool1;
    if (paramInt == -1)
    {
      bool1 = true;
      if (bool2 != bool1) {
        break label49;
      }
    }
    label49:
    for (paramInt = i;; paramInt = -1)
    {
      d = paramInt;
      return;
      bool1 = false;
      break;
    }
  }
  
  private final void h(View paramView)
  {
    int i = s - 1;
    while (i >= 0)
    {
      t[i].b(paramView);
      i -= 1;
    }
  }
  
  private final int i(alg paramalg)
  {
    boolean bool2 = true;
    if (i() == 0) {
      return 0;
    }
    akd localakd = a;
    View localView;
    if (!G)
    {
      bool1 = true;
      localView = a(bool1);
      if (G) {
        break label66;
      }
    }
    label66:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return alr.b(paramalg, localakd, localView, b(bool1), this, G);
      bool1 = false;
      break;
    }
  }
  
  private final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem i(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    c = new int[s];
    int i = 0;
    while (i < s)
    {
      c[i] = (paramInt - t[i].b(paramInt));
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private final void i(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < s)
    {
      if (!t[i].a.isEmpty()) {
        a(t[i], paramInt1, paramInt2);
      }
      i += 1;
    }
  }
  
  private final void i(View paramView)
  {
    int i = s - 1;
    while (i >= 0)
    {
      t[i].a(paramView);
      i -= 1;
    }
  }
  
  private final StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem j(int paramInt)
  {
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
    c = new int[s];
    int i = 0;
    while (i < s)
    {
      c[i] = (t[i].a(paramInt) - paramInt);
      i += 1;
    }
    return localFullSpanItem;
  }
  
  private final int k(int paramInt)
  {
    int j = t[0].a(paramInt);
    int i = 1;
    while (i < s)
    {
      int m = t[i].a(paramInt);
      int k = j;
      if (m < j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private final int l(int paramInt)
  {
    int j = t[0].b(paramInt);
    int i = 1;
    while (i < s)
    {
      int m = t[i].b(paramInt);
      int k = j;
      if (m > j) {
        k = m;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private final boolean m(int paramInt)
  {
    int i;
    if (u == 0) {
      if (paramInt == -1)
      {
        i = 1;
        if (i == d) {
          break label29;
        }
      }
    }
    label29:
    label63:
    label66:
    for (;;)
    {
      return true;
      i = 0;
      break;
      return false;
      if (paramInt == -1)
      {
        i = 1;
        if (i != d) {
          break label63;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == r()) {
          break label66;
        }
        return false;
        i = 0;
        break;
      }
    }
  }
  
  private final boolean o()
  {
    if ((i() == 0) || (y == 0) || (!l)) {
      return false;
    }
    int j;
    if (d) {
      j = u();
    }
    for (int i = v(); (j == 0) && (p() != null); i = u())
    {
      g.a();
      this.k = true;
      g();
      return true;
      j = v();
    }
    if (!F) {
      return false;
    }
    if (d) {}
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem1;
    for (int k = -1;; k = 1)
    {
      localFullSpanItem1 = g.a(j, i + 1, k);
      if (localFullSpanItem1 != null) {
        break;
      }
      F = false;
      g.a(i + 1);
      return false;
    }
    StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem localFullSpanItem2 = g.a(j, a, k * -1);
    if (localFullSpanItem2 == null) {
      g.a(a);
    }
    for (;;)
    {
      this.k = true;
      g();
      return true;
      g.a(a + 1);
    }
  }
  
  private final View p()
  {
    int i = i() - 1;
    BitSet localBitSet = new BitSet(s);
    localBitSet.set(0, s, true);
    int j;
    int k;
    label57:
    int m;
    label65:
    int n;
    View localView;
    amd localamd;
    Object localObject;
    if ((u == 1) && (r()))
    {
      j = 1;
      if (!d) {
        break label184;
      }
      k = -1;
      if (i >= k) {
        break label193;
      }
      m = 1;
      n = i;
      if (n == k) {
        break label458;
      }
      localView = c(n);
      localamd = (amd)localView.getLayoutParams();
      if (!localBitSet.get(e.e)) {
        break label271;
      }
      localObject = e;
      if (!d) {
        break label204;
      }
      if (((amg)localObject).b() >= a.c()) {
        break label253;
      }
      if (a.get(a.size() - 1)).getLayoutParams()).f) {
        break label199;
      }
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label258;
      }
      return localView;
      j = -1;
      break;
      label184:
      k = i + 1;
      i = 0;
      break label57;
      label193:
      m = -1;
      break label65;
      label199:
      i = 0;
      continue;
      label204:
      if (((amg)localObject).a() > a.b())
      {
        if (!a.get(0)).getLayoutParams()).f) {
          i = 1;
        } else {
          i = 0;
        }
      }
      else {
        label253:
        i = 0;
      }
    }
    label258:
    localBitSet.clear(e.e);
    label271:
    int i1;
    if ((!f) && (n + m != k))
    {
      localObject = c(n + m);
      if (d)
      {
        i = a.b(localView);
        i1 = a.b((View)localObject);
        if (i < i1) {
          return localView;
        }
        if (i != i1) {
          break label460;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = (amd)((View)localObject).getLayoutParams();
        if (e.e - e.e < 0)
        {
          i = 1;
          label380:
          if (j >= 0) {
            break label442;
          }
        }
        label442:
        for (i1 = 1;; i1 = 0)
        {
          if (i == i1) {
            break label448;
          }
          return localView;
          i = a.a(localView);
          i1 = a.a((View)localObject);
          if (i > i1) {
            return localView;
          }
          if (i != i1) {
            break label460;
          }
          i = 1;
          break;
          i = 0;
          break label380;
        }
      }
      label448:
      n += m;
      break;
      label458:
      return null;
      label460:
      i = 0;
    }
  }
  
  private final void q()
  {
    boolean bool = true;
    if ((u == 1) || (!r())) {
      bool = c;
    }
    for (;;)
    {
      d = bool;
      return;
      if (c) {
        bool = false;
      }
    }
  }
  
  private final boolean r()
  {
    return rg.g(i) == 1;
  }
  
  private final boolean s()
  {
    boolean bool2 = true;
    int j = t[0].b(Integer.MIN_VALUE);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < s)
      {
        if (t[i].b(Integer.MIN_VALUE) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private final boolean t()
  {
    boolean bool2 = true;
    int j = t[0].a(Integer.MIN_VALUE);
    int i = 1;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < s)
      {
        if (t[i].a(Integer.MIN_VALUE) != j) {
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private final int u()
  {
    int i = i();
    if (i == 0) {
      return 0;
    }
    return a(c(i - 1));
  }
  
  private final int v()
  {
    if (i() == 0) {
      return 0;
    }
    return a(c(0));
  }
  
  public final int a(int paramInt, ala paramala, alg paramalg)
  {
    return c(paramInt, paramala, paramalg);
  }
  
  public final int a(alg paramalg)
  {
    return g(paramalg);
  }
  
  public final akx a()
  {
    if (u == 0) {
      return new amd(-2, -1);
    }
    return new amd(-1, -2);
  }
  
  public final akx a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new amd(paramContext, paramAttributeSet);
  }
  
  public final akx a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new amd((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new amd(paramLayoutParams);
  }
  
  public final View a(View paramView, int paramInt, ala paramala, alg paramalg)
  {
    if (i() == 0) {
      return null;
    }
    if (this.i == null) {
      paramView = null;
    }
    while (paramView == null)
    {
      return null;
      RecyclerView localRecyclerView = this.i;
      for (localObject = paramView.getParent(); (localObject != null) && (localObject != localRecyclerView) && ((localObject instanceof View)); localObject = paramView.getParent()) {
        paramView = (View)localObject;
      }
      if (localObject == localRecyclerView) {}
      for (;;)
      {
        if (paramView != null) {
          break label92;
        }
        paramView = null;
        break;
        paramView = null;
      }
      label92:
      if (h.d(paramView)) {
        paramView = null;
      }
    }
    q();
    switch (paramInt)
    {
    default: 
      paramInt = Integer.MIN_VALUE;
    }
    while (paramInt == Integer.MIN_VALUE)
    {
      return null;
      paramInt = -1;
      continue;
      paramInt = 1;
      continue;
      if (u == 1)
      {
        paramInt = -1;
      }
      else
      {
        paramInt = Integer.MIN_VALUE;
        continue;
        if (u == 1)
        {
          paramInt = 1;
        }
        else
        {
          paramInt = Integer.MIN_VALUE;
          continue;
          if (u == 0)
          {
            paramInt = -1;
          }
          else
          {
            paramInt = Integer.MIN_VALUE;
            continue;
            if (u == 0) {
              paramInt = 1;
            } else {
              paramInt = Integer.MIN_VALUE;
            }
          }
        }
      }
    }
    Object localObject = (amd)paramView.getLayoutParams();
    boolean bool = f;
    localObject = e;
    if (paramInt == 1) {}
    for (int i = u();; i = v())
    {
      a(i, paramalg);
      h(paramInt);
      w.c = (w.d + i);
      w.b = ((int)(0.33333334F * a.e()));
      w.h = true;
      w.a = false;
      a(paramala, w, paramalg);
      z = d;
      if (bool) {
        break;
      }
      paramala = ((amg)localObject).a(i, paramInt);
      if ((paramala == null) || (paramala == paramView)) {
        break;
      }
      return paramala;
    }
    if (m(paramInt))
    {
      j = s - 1;
      while (j >= 0)
      {
        paramala = t[j].a(i, paramInt);
        if ((paramala != null) && (paramala != paramView)) {
          return paramala;
        }
        j -= 1;
      }
    }
    int j = 0;
    while (j < s)
    {
      paramala = t[j].a(i, paramInt);
      if ((paramala != null) && (paramala != paramView)) {
        return paramala;
      }
      j += 1;
    }
    return null;
  }
  
  public final void a(ala paramala, alg paramalg)
  {
    int j = 1;
    amc localamc = E;
    a = -1;
    b = Integer.MIN_VALUE;
    c = false;
    d = false;
    if (((B != null) || (e != -1)) && (paramalg.a() == 0))
    {
      c(paramala);
      label61:
      return;
    }
    int m;
    int i;
    label181:
    Object localObject;
    boolean bool;
    if (B != null)
    {
      if (B.c > 0) {
        if (B.c == s)
        {
          k = 0;
          if (k < s)
          {
            t[k].c();
            m = B.d[k];
            i = m;
            if (m != Integer.MIN_VALUE) {
              if (!B.i) {
                break label181;
              }
            }
            for (i = m + a.c();; i = m + a.b())
            {
              t[k].c(i);
              k += 1;
              break;
            }
          }
        }
        else
        {
          localObject = B;
          d = null;
          c = 0;
          e = 0;
          f = null;
          g = null;
          B.a = B.b;
        }
      }
      A = B.j;
      bool = B.h;
      a(null);
      if ((B != null) && (B.h != bool)) {
        B.h = bool;
      }
      c = bool;
      g();
      q();
      if (B.a != -1)
      {
        e = B.a;
        c = B.i;
        if (B.e > 1)
        {
          g.a = B.f;
          g.b = B.g;
        }
        label386:
        if ((!g) && (e != -1)) {
          break label635;
        }
        i = 0;
        label404:
        if (i == 0)
        {
          if (!z) {
            break label1210;
          }
          m = paramalg.a();
          i = i() - 1;
          label430:
          if (i < 0) {
            break label1204;
          }
          k = a(c(i));
          if ((k < 0) || (k >= m)) {
            break label1195;
          }
          i = k;
        }
      }
    }
    label635:
    label726:
    label792:
    label822:
    label858:
    label1004:
    label1013:
    label1041:
    label1090:
    label1096:
    label1102:
    label1195:
    label1204:
    label1210:
    int n;
    int i1;
    for (;;)
    {
      a = i;
      b = Integer.MIN_VALUE;
      if ((B == null) && ((c != z) || (r() != A)))
      {
        g.a();
        d = true;
      }
      if ((i() <= 0) || ((B != null) && (B.c > 0))) {
        break label1432;
      }
      if (!d) {
        break label1274;
      }
      i = 0;
      while (i < s)
      {
        t[i].c();
        if (b != Integer.MIN_VALUE) {
          t[i].c(b);
        }
        i += 1;
      }
      c = d;
      break;
      q();
      c = d;
      break label386;
      if ((e < 0) || (e >= paramalg.a()))
      {
        e = -1;
        f = Integer.MIN_VALUE;
        i = 0;
        break label404;
      }
      if ((B == null) || (B.a == -1) || (B.c <= 0))
      {
        localObject = a(e);
        if (localObject != null)
        {
          if (d)
          {
            i = u();
            a = i;
            if (f == Integer.MIN_VALUE) {
              break label822;
            }
            if (!c) {
              break label792;
            }
          }
          for (b = (a.c() - f - a.b((View)localObject));; b = (a.b() + f - a.a((View)localObject)))
          {
            i = 1;
            break;
            i = v();
            break label726;
          }
          if (a.c((View)localObject) > a.e()) {
            if (c)
            {
              i = a.c();
              b = i;
            }
          }
        }
      }
      for (;;)
      {
        i = 1;
        break;
        i = a.b();
        break label858;
        i = a.a((View)localObject) - a.b();
        if (i < 0)
        {
          b = (-i);
        }
        else
        {
          i = a.c() - a.b((View)localObject);
          if (i < 0)
          {
            b = i;
          }
          else
          {
            b = Integer.MIN_VALUE;
            continue;
            a = e;
            if (f == Integer.MIN_VALUE)
            {
              i = a;
              if (i() == 0)
              {
                if (d) {
                  break label1090;
                }
                i = -1;
                if (i != 1) {
                  break label1096;
                }
                bool = true;
                c = bool;
                if (!c) {
                  break label1102;
                }
                i = e.a.c();
                b = i;
              }
            }
            for (;;)
            {
              d = true;
              break;
              if (i < v()) {}
              for (bool = true;; bool = false)
              {
                if (bool == d) {
                  break label1090;
                }
                i = -1;
                break;
              }
              i = 1;
              break label1004;
              bool = false;
              break label1013;
              i = e.a.b();
              break label1041;
              i = f;
              if (c) {
                b = (e.a.c() - i);
              } else {
                b = (i + e.a.b());
              }
            }
            b = Integer.MIN_VALUE;
            a = e;
          }
        }
      }
      i -= 1;
      break label430;
      i = 0;
      continue;
      n = paramalg.a();
      i1 = i();
      k = 0;
      for (;;)
      {
        if (k >= i1) {
          break label1268;
        }
        m = a(c(k));
        if (m >= 0)
        {
          i = m;
          if (m < n) {
            break;
          }
        }
        k += 1;
      }
      label1268:
      i = 0;
    }
    label1274:
    int k = 0;
    if (k < s)
    {
      localObject = t[k];
      bool = d;
      n = b;
      if (bool)
      {
        i = ((amg)localObject).b(Integer.MIN_VALUE);
        label1322:
        ((amg)localObject).c();
        if ((i != Integer.MIN_VALUE) && ((!bool) || (i >= f.a.c())) && ((bool) || (i <= f.a.b()))) {
          break label1397;
        }
      }
      for (;;)
      {
        k += 1;
        break;
        i = ((amg)localObject).a(Integer.MIN_VALUE);
        break label1322;
        label1397:
        m = i;
        if (n != Integer.MIN_VALUE) {
          m = i + n;
        }
        c = m;
        b = m;
      }
    }
    label1432:
    a(paramala);
    w.a = false;
    F = false;
    g(b.e());
    a(a, paramalg);
    label1531:
    float f1;
    label1555:
    float f2;
    if (c)
    {
      h(-1);
      a(paramala, w, paramalg);
      h(1);
      w.c = (a + w.d);
      a(paramala, w, paramalg);
      if (b.g() == 1073741824) {
        break label1917;
      }
      f1 = 0.0F;
      m = i();
      i = 0;
      if (i >= m) {
        break label1686;
      }
      localObject = c(i);
      f2 = b.c((View)localObject);
      if (f2 < f1) {
        break label2101;
      }
      if (!getLayoutParamsf) {
        break label2104;
      }
      f2 = 1.0F * f2 / s;
    }
    label1686:
    label1855:
    label1917:
    label1945:
    label2095:
    label2101:
    label2104:
    for (;;)
    {
      f1 = Math.max(f1, f2);
      for (;;)
      {
        i += 1;
        break label1555;
        h(1);
        a(paramala, w, paramalg);
        h(-1);
        w.c = (a + w.d);
        a(paramala, w, paramalg);
        break label1531;
        n = v;
        k = Math.round(s * f1);
        i = k;
        if (b.g() == Integer.MIN_VALUE) {
          i = Math.min(k, b.e());
        }
        g(i);
        if (v != n)
        {
          i = 0;
          if (i < m)
          {
            localObject = c(i);
            amd localamd = (amd)((View)localObject).getLayoutParams();
            if (!f)
            {
              if ((!r()) || (u != 1)) {
                break label1855;
              }
              ((View)localObject).offsetLeftAndRight(-(s - 1 - e.e) * v - -(s - 1 - e.e) * n);
            }
            for (;;)
            {
              i += 1;
              break;
              k = e.e * v;
              i1 = e.e * n;
              if (u == 1) {
                ((View)localObject).offsetLeftAndRight(k - i1);
              } else {
                ((View)localObject).offsetTopAndBottom(k - i1);
              }
            }
          }
        }
        if (i() > 0)
        {
          if (d)
          {
            a(paramala, paramalg, true);
            b(paramala, paramalg, false);
          }
        }
        else
        {
          m = 0;
          k = 0;
          i = m;
          if (j != 0)
          {
            i = m;
            if (!g) {
              if ((y == 0) || (i() <= 0) || ((!F) && (p() == null))) {
                break label2095;
              }
            }
          }
        }
        for (j = 1;; j = 0)
        {
          i = k;
          if (j != 0)
          {
            a(H);
            i = k;
            if (o()) {
              i = 1;
            }
          }
          e = -1;
          f = Integer.MIN_VALUE;
          z = c;
          A = r();
          B = null;
          if (i == 0) {
            break label61;
          }
          j = 0;
          break;
          b(paramala, paramalg, true);
          a(paramala, paramalg, false);
          break label1945;
        }
      }
    }
  }
  
  public final void a(Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = j();
    int j = l() + i;
    int k = k() + m();
    if (u == 1)
    {
      i = a(paramInt2, k + paramRect.height(), rg.p(this.i));
      paramInt2 = a(paramInt1, j + v * s, rg.o(this.i));
      paramInt1 = i;
    }
    for (;;)
    {
      h(paramInt2, paramInt1);
      return;
      i = a(paramInt1, j + paramRect.width(), rg.o(this.i));
      paramInt1 = a(paramInt2, k + v * s, rg.p(this.i));
      paramInt2 = i;
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof StaggeredGridLayoutManager.SavedState))
    {
      B = ((StaggeredGridLayoutManager.SavedState)paramParcelable);
      g();
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, ala paramala)
  {
    a(H);
    int i = 0;
    while (i < s)
    {
      t[i].c();
      i += 1;
    }
  }
  
  public final void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    View localView1;
    View localView2;
    if (i() > 0)
    {
      paramAccessibilityEvent = ub.a(paramAccessibilityEvent);
      localView1 = a(false);
      localView2 = b(false);
      if ((localView1 != null) && (localView2 != null)) {}
    }
    else
    {
      return;
    }
    int i = a(localView1);
    int j = a(localView2);
    if (i < j)
    {
      paramAccessibilityEvent.b(i);
      paramAccessibilityEvent.c(j);
      return;
    }
    paramAccessibilityEvent.b(j);
    paramAccessibilityEvent.c(i);
  }
  
  public final void a(String paramString)
  {
    if (B == null) {
      super.a(paramString);
    }
  }
  
  public final boolean a(akx paramakx)
  {
    return paramakx instanceof amd;
  }
  
  public final int b(int paramInt, ala paramala, alg paramalg)
  {
    return c(paramInt, paramala, paramalg);
  }
  
  public final int b(ala paramala, alg paramalg)
  {
    if (u == 0) {
      return s;
    }
    return super.b(paramala, paramalg);
  }
  
  public final int b(alg paramalg)
  {
    return g(paramalg);
  }
  
  public final Parcelable b()
  {
    if (B != null) {
      return new StaggeredGridLayoutManager.SavedState(B);
    }
    StaggeredGridLayoutManager.SavedState localSavedState = new StaggeredGridLayoutManager.SavedState();
    h = c;
    i = z;
    j = A;
    int i;
    label126:
    View localView;
    label146:
    label153:
    int j;
    label181:
    int k;
    if ((g != null) && (g.a != null))
    {
      f = g.a;
      e = f.length;
      g = g.b;
      if (i() <= 0) {
        break label310;
      }
      if (!z) {
        break label250;
      }
      i = u();
      a = i;
      if (!d) {
        break label258;
      }
      localView = b(true);
      if (localView != null) {
        break label268;
      }
      i = -1;
      b = i;
      c = s;
      d = new int[s];
      j = 0;
      if (j >= s) {
        break label328;
      }
      if (!z) {
        break label277;
      }
      k = t[j].b(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - a.c();
      }
    }
    for (;;)
    {
      d[j] = i;
      j += 1;
      break label181;
      e = 0;
      break;
      label250:
      i = v();
      break label126;
      label258:
      localView = a(true);
      break label146;
      label268:
      i = a(localView);
      break label153;
      label277:
      k = t[j].a(Integer.MIN_VALUE);
      i = k;
      if (k != Integer.MIN_VALUE) {
        i = k - a.b();
      }
    }
    label310:
    a = -1;
    b = -1;
    c = 0;
    label328:
    return localSavedState;
  }
  
  public final void b(int paramInt)
  {
    if ((B != null) && (B.a != paramInt))
    {
      StaggeredGridLayoutManager.SavedState localSavedState = B;
      d = null;
      c = 0;
      a = -1;
      b = -1;
    }
    e = paramInt;
    f = Integer.MIN_VALUE;
    g();
  }
  
  public final void b(View paramView, uk paramuk)
  {
    int k = 1;
    int i = 1;
    int j = -1;
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof amd))
    {
      super.a(paramView, paramuk);
      return;
    }
    paramView = (amd)localLayoutParams;
    int m;
    int n;
    if (u == 0)
    {
      m = paramView.a();
      if (f) {
        i = s;
      }
      n = -1;
      k = i;
      i = n;
    }
    for (;;)
    {
      paramuk.b(uw.a(m, k, j, i, f));
      return;
      i = paramView.a();
      if (f)
      {
        n = s;
        m = -1;
        j = i;
        k = -1;
        i = n;
      }
      else
      {
        m = -1;
        j = i;
        n = -1;
        i = k;
        k = n;
      }
    }
  }
  
  public final int c(ala paramala, alg paramalg)
  {
    if (u == 1) {
      return s;
    }
    return super.c(paramala, paramalg);
  }
  
  public final int c(alg paramalg)
  {
    return h(paramalg);
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2, 1);
  }
  
  public final boolean c()
  {
    return u == 0;
  }
  
  public final int d(alg paramalg)
  {
    return h(paramalg);
  }
  
  public final void d(int paramInt)
  {
    super.d(paramInt);
    int i = 0;
    while (i < s)
    {
      t[i].d(paramInt);
      i += 1;
    }
  }
  
  public final void d(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2, 2);
  }
  
  public final boolean d()
  {
    return u == 1;
  }
  
  public final int e(alg paramalg)
  {
    return i(paramalg);
  }
  
  public final void e(int paramInt)
  {
    super.e(paramInt);
    int i = 0;
    while (i < s)
    {
      t[i].d(paramInt);
      i += 1;
    }
  }
  
  public final void e(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2, 4);
  }
  
  public final int f(alg paramalg)
  {
    return i(paramalg);
  }
  
  public final void f(int paramInt)
  {
    if (paramInt == 0) {
      o();
    }
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    d(paramInt1, paramInt2, 8);
  }
  
  public final boolean f()
  {
    return B == null;
  }
  
  public final void n()
  {
    g.a();
    g();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */