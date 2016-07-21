package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import bc;
import bf;
import cm;
import cq;
import dd;
import java.lang.ref.WeakReference;
import java.util.List;
import p;
import r;
import rg;
import s;
import u;

public class AppBarLayout$Behavior
  extends bc<AppBarLayout>
{
  int a;
  private boolean c;
  private boolean d;
  private cm e;
  private int f = -1;
  private boolean g;
  private float h;
  private WeakReference<View> i;
  private s j;
  
  public AppBarLayout$Behavior() {}
  
  public AppBarLayout$Behavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static void a(AppBarLayout paramAppBarLayout)
  {
    paramAppBarLayout = e;
    int k = 0;
    int m = paramAppBarLayout.size();
    while (k < m)
    {
      paramAppBarLayout.get(k);
      k += 1;
    }
  }
  
  private final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout)
  {
    int i2 = a();
    int m = paramAppBarLayout.getChildCount();
    int k = 0;
    View localView;
    label49:
    int i3;
    int n;
    int i1;
    if (k < m)
    {
      localView = paramAppBarLayout.getChildAt(k);
      if ((localView.getTop() <= -i2) && (localView.getBottom() >= -i2)) {
        if (k >= 0)
        {
          localView = paramAppBarLayout.getChildAt(k);
          i3 = getLayoutParamsa;
          if ((i3 & 0x11) == 17)
          {
            n = -localView.getTop();
            i1 = -localView.getBottom();
            m = i1;
            if (k == paramAppBarLayout.getChildCount() - 1) {
              m = i1 + paramAppBarLayout.b();
            }
            if (!a(i3, 2)) {
              break label185;
            }
            m += rg.p(localView);
            k = n;
          }
        }
      }
    }
    for (;;)
    {
      label144:
      if (i2 < (m + k) / 2) {}
      for (;;)
      {
        a(paramCoordinatorLayout, paramAppBarLayout, bf.a(m, -paramAppBarLayout.a(), 0));
        return;
        k += 1;
        break;
        k = -1;
        break label49;
        label185:
        if (!a(i3, 5)) {
          break label230;
        }
        i1 = rg.p(localView) + m;
        k = i1;
        if (i2 < i1) {
          break label144;
        }
        m = i1;
        k = n;
        break label144;
        m = k;
      }
      label230:
      k = n;
    }
  }
  
  private final void a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, int paramInt)
  {
    int k = a();
    if (k == paramInt)
    {
      if ((e != null) && (e.a.b())) {
        e.a.e();
      }
      return;
    }
    if (e == null)
    {
      e = dd.a();
      e.a(p.e);
      e.a(new r(this, paramCoordinatorLayout, paramAppBarLayout));
    }
    for (;;)
    {
      float f1 = Math.abs(k - paramInt) / getResourcesgetDisplayMetricsdensity;
      e.a(Math.round(f1 * 1000.0F / 300.0F));
      e.a.a(k, paramInt);
      e.a.a();
      return;
      e.a.e();
    }
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  final int a()
  {
    return super.b() + a;
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */