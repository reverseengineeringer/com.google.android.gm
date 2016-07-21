import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;

public final class ali
  implements Runnable
{
  public int a;
  public int b;
  public xu c;
  private Interpolator e = RecyclerView.F;
  private boolean f = false;
  private boolean g = false;
  
  public ali(RecyclerView paramRecyclerView)
  {
    c = xu.a(paramRecyclerView.getContext(), RecyclerView.F);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, RecyclerView.F);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
  {
    if (e != paramInterpolator)
    {
      e = paramInterpolator;
      c = xu.a(d.getContext(), paramInterpolator);
    }
    d.a(2);
    b = 0;
    a = 0;
    c.a(0, 0, paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public final void a()
  {
    if (f)
    {
      g = true;
      return;
    }
    d.removeCallbacks(this);
    rg.a(d, this);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    int k = Math.abs(paramInt1);
    int m = Math.abs(paramInt2);
    int n;
    int i1;
    if (k > m)
    {
      j = 1;
      n = (int)Math.sqrt(0.0D);
      i1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (j == 0) {
        break label155;
      }
    }
    label155:
    for (int i = d.getWidth();; i = d.getHeight())
    {
      int i2 = i / 2;
      float f3 = Math.min(1.0F, i1 * 1.0F / i);
      float f1 = i2;
      float f2 = i2;
      f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
      if (n <= 0) {
        break label167;
      }
      i = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / n)) * 4;
      a(paramInt1, paramInt2, Math.min(i, 2000));
      return;
      j = 0;
      break;
    }
    label167:
    if (j != 0) {}
    for (int j = k;; j = m)
    {
      i = (int)((j / i + 1.0F) * 300.0F);
      break;
    }
  }
  
  public final void b()
  {
    d.removeCallbacks(this);
    c.h();
  }
  
  public final void run()
  {
    if (d.j == null)
    {
      b();
      return;
    }
    g = false;
    f = true;
    d.a();
    Object localObject1 = c;
    ale localale = d.j.j;
    int i5;
    int i6;
    int i3;
    int i4;
    int i1;
    int k;
    int n;
    int m;
    int i;
    int j;
    if (((xu)localObject1).g())
    {
      i5 = ((xu)localObject1).b();
      i6 = ((xu)localObject1).c();
      i3 = i5 - a;
      i4 = i6 - b;
      i1 = 0;
      k = 0;
      a = i5;
      b = i6;
      n = 0;
      m = 0;
      if (d.i == null) {
        break label2808;
      }
      d.b();
      d.g();
      mn.a("RV Scroll");
      if (i3 == 0) {
        break label2801;
      }
      i = d.j.a(i3, d.c, d.A);
      j = i3 - i;
      label179:
      if (i4 != 0)
      {
        k = d.j.b(i4, d.c, d.A);
        m = i4 - k;
      }
      mn.a();
      d.l();
      d.h();
      d.a(false);
      if ((localale == null) || (c) || (!d)) {
        break label2242;
      }
      n = d.A.a();
      if (n != 0) {
        break label892;
      }
      localale.a();
      n = k;
      i1 = j;
      k = i;
      j = n;
      i = i1;
      n = m;
    }
    for (;;)
    {
      label303:
      if (!d.l.isEmpty()) {
        d.invalidate();
      }
      if (rg.a(d) != 2) {
        d.a(i3, i4);
      }
      if ((i != 0) || (n != 0))
      {
        i1 = (int)((xu)localObject1).f();
        if (i == i5) {
          break label2795;
        }
        if (i >= 0) {
          break label2259;
        }
        m = -i1;
      }
      label377:
      label398:
      label437:
      label459:
      label576:
      label602:
      label622:
      label642:
      label765:
      label770:
      label798:
      label837:
      label892:
      label1023:
      label1028:
      label1057:
      label1340:
      label1359:
      label1365:
      label1568:
      label1697:
      label1702:
      label1731:
      label2014:
      label2033:
      label2039:
      label2242:
      label2259:
      label2291:
      label2315:
      label2344:
      label2349:
      label2354:
      label2361:
      label2559:
      label2578:
      label2583:
      label2781:
      label2795:
      for (int i2 = m;; i2 = 0)
      {
        if (n != i6) {
          if (n < 0) {
            m = -i1;
          }
        }
        for (;;)
        {
          Object localObject2;
          if (rg.a(d) != 2)
          {
            localObject2 = d;
            if (i2 >= 0) {
              break label2291;
            }
            ((RecyclerView)localObject2).c();
            t.a(-i2);
            if (m >= 0) {
              break label2315;
            }
            ((RecyclerView)localObject2).e();
            u.a(-m);
            if ((i2 != 0) || (m != 0)) {
              rg.c((View)localObject2);
            }
          }
          if (((i2 != 0) || (i == i5) || (((xu)localObject1).d() == 0)) && ((m != 0) || (n == i6) || (((xu)localObject1).e() == 0))) {
            ((xu)localObject1).h();
          }
          if ((k != 0) || (j != 0)) {
            d.k();
          }
          if (!RecyclerView.a(d)) {
            d.invalidate();
          }
          if ((i4 != 0) && (d.j.d()) && (j == i4))
          {
            i = 1;
            if ((i3 == 0) || (!d.j.c()) || (k != i3)) {
              break label2344;
            }
            j = 1;
            if (((i3 != 0) || (i4 != 0)) && (j == 0) && (i == 0)) {
              break label2349;
            }
            i = 1;
            if ((!((xu)localObject1).a()) && (i != 0)) {
              break label2354;
            }
            d.a(0);
            if (localale != null) {
              if (c)
              {
                localObject1 = b;
                if ((!d) || (a == -1) || (localObject1 == null)) {
                  localale.a();
                }
                c = false;
                if (e != null)
                {
                  if (RecyclerView.c(e) != a) {
                    break label2559;
                  }
                  localObject2 = A;
                  localObject2 = f;
                  if (d < 0) {
                    break label2361;
                  }
                  i = d;
                  d = -1;
                  ((RecyclerView)localObject1).b(i);
                  f = false;
                  localale.a();
                }
                if (d)
                {
                  localObject2 = A;
                  if (f.d < 0) {
                    break label2578;
                  }
                  i = 1;
                  localObject2 = f;
                  if (d < 0) {
                    break label2583;
                  }
                  j = d;
                  d = -1;
                  ((RecyclerView)localObject1).b(j);
                  f = false;
                  if (i != 0)
                  {
                    if (!d) {
                      break label2781;
                    }
                    c = true;
                    z.a();
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (!g) {
              localale.a();
            }
            f = false;
            if (!g) {
              break;
            }
            a();
            return;
            Object localObject3;
            if (a >= n)
            {
              a = (n - 1);
              localObject2 = b;
              if ((!d) || (a == -1) || (localObject2 == null)) {
                localale.a();
              }
              c = false;
              if (e != null)
              {
                if (RecyclerView.c(e) != a) {
                  break label1340;
                }
                localObject3 = A;
                localObject3 = f;
                if (d >= 0)
                {
                  n = d;
                  d = -1;
                  ((RecyclerView)localObject2).b(n);
                  f = false;
                  localale.a();
                }
              }
              else
              {
                if (!d) {
                  break label1568;
                }
                localObject3 = A;
                if (f.d < 0) {
                  break label1359;
                }
                n = 1;
                localObject3 = f;
                if (d < 0) {
                  break label1365;
                }
                i1 = d;
                d = -1;
                ((RecyclerView)localObject2).b(i1);
                f = false;
              }
              for (;;)
              {
                if (n != 0)
                {
                  if (d)
                  {
                    c = true;
                    z.a();
                    i1 = i;
                    n = m;
                    i = j;
                    j = k;
                    k = i1;
                    break;
                    if (f)
                    {
                      if ((e != null) && (c <= 0)) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                      }
                      if (c <= 0) {
                        throw new IllegalStateException("Scroll duration must be a positive number");
                      }
                      if (e == null) {
                        if (c == Integer.MIN_VALUE) {
                          z.a(a, b);
                        }
                      }
                      for (;;)
                      {
                        g += 1;
                        if (g > 10) {
                          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        f = false;
                        break;
                        z.a(a, b, c);
                        continue;
                        z.a(a, b, c, e);
                      }
                    }
                    g = 0;
                    break label1023;
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    e = null;
                    break label1028;
                    n = 0;
                    break label1057;
                    if (f)
                    {
                      if ((e != null) && (c <= 0)) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                      }
                      if (c <= 0) {
                        throw new IllegalStateException("Scroll duration must be a positive number");
                      }
                      if (e == null) {
                        if (c == Integer.MIN_VALUE) {
                          z.a(a, b);
                        }
                      }
                      for (;;)
                      {
                        g += 1;
                        if (g > 10) {
                          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        f = false;
                        break;
                        z.a(a, b, c);
                        continue;
                        z.a(a, b, c, e);
                      }
                    }
                    g = 0;
                    continue;
                  }
                  localale.a();
                }
              }
              i1 = i;
              n = m;
              i = j;
              j = k;
              k = i1;
              break label303;
            }
            localObject2 = b;
            if ((!d) || (a == -1) || (localObject2 == null)) {
              localale.a();
            }
            c = false;
            if (e != null)
            {
              if (RecyclerView.c(e) != a) {
                break label2014;
              }
              localObject3 = A;
              localObject3 = f;
              if (d >= 0)
              {
                n = d;
                d = -1;
                ((RecyclerView)localObject2).b(n);
                f = false;
                localale.a();
              }
            }
            else
            {
              if (!d) {
                break label2242;
              }
              localObject3 = A;
              if (f.d < 0) {
                break label2033;
              }
              n = 1;
              localObject3 = f;
              if (d < 0) {
                break label2039;
              }
              i1 = d;
              d = -1;
              ((RecyclerView)localObject2).b(i1);
              f = false;
            }
            for (;;)
            {
              if (n != 0)
              {
                if (d)
                {
                  c = true;
                  z.a();
                  i1 = i;
                  n = m;
                  i = j;
                  j = k;
                  k = i1;
                  break;
                  if (f)
                  {
                    if ((e != null) && (c <= 0)) {
                      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    if (c <= 0) {
                      throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    if (e == null) {
                      if (c == Integer.MIN_VALUE) {
                        z.a(a, b);
                      }
                    }
                    for (;;)
                    {
                      g += 1;
                      if (g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                      }
                      f = false;
                      break;
                      z.a(a, b, c);
                      continue;
                      z.a(a, b, c, e);
                    }
                  }
                  g = 0;
                  break label1697;
                  Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                  e = null;
                  break label1702;
                  n = 0;
                  break label1731;
                  if (f)
                  {
                    if ((e != null) && (c <= 0)) {
                      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    if (c <= 0) {
                      throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    if (e == null) {
                      if (c == Integer.MIN_VALUE) {
                        z.a(a, b);
                      }
                    }
                    for (;;)
                    {
                      g += 1;
                      if (g > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                      }
                      f = false;
                      break;
                      z.a(a, b, c);
                      continue;
                      z.a(a, b, c, e);
                    }
                  }
                  g = 0;
                  continue;
                }
                localale.a();
              }
            }
            i1 = i;
            n = m;
            i = j;
            j = k;
            k = i1;
            break label303;
            if (i > 0)
            {
              m = i1;
              break label377;
            }
            m = 0;
            break label377;
            m = i1;
            if (n > 0) {
              break label398;
            }
            m = 0;
            break label398;
            if (i2 <= 0) {
              break label437;
            }
            ((RecyclerView)localObject2).d();
            v.a(i2);
            break label437;
            if (m <= 0) {
              break label459;
            }
            ((RecyclerView)localObject2).f();
            w.a(m);
            break label459;
            i = 0;
            break label576;
            j = 0;
            break label602;
            i = 0;
            break label622;
            a();
            break label642;
            if (f)
            {
              if ((e != null) && (c <= 0)) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
              }
              if (c <= 0) {
                throw new IllegalStateException("Scroll duration must be a positive number");
              }
              if (e == null) {
                if (c == Integer.MIN_VALUE) {
                  z.a(a, b);
                }
              }
              for (;;)
              {
                g += 1;
                if (g > 10) {
                  Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                f = false;
                break;
                z.a(a, b, c);
                continue;
                z.a(a, b, c, e);
              }
            }
            g = 0;
            break label765;
            Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
            e = null;
            break label770;
            i = 0;
            break label798;
            if (f)
            {
              if ((e != null) && (c <= 0)) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
              }
              if (c <= 0) {
                throw new IllegalStateException("Scroll duration must be a positive number");
              }
              if (e == null) {
                if (c == Integer.MIN_VALUE) {
                  z.a(a, b);
                }
              }
              for (;;)
              {
                g += 1;
                if (g > 10) {
                  Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                f = false;
                break;
                z.a(a, b, c);
                continue;
                z.a(a, b, c, e);
              }
            }
            g = 0;
            break label837;
            localale.a();
          }
          m = 0;
        }
      }
      label2801:
      i = 0;
      j = 0;
      break label179;
      label2808:
      j = 0;
      i = 0;
      k = i1;
    }
  }
}

/* Location:
 * Qualified Name:     ali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */