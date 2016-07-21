package android.support.design.widget;

import ad;
import ag;
import an;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import ay;
import cm;
import cq;
import cw;
import dd;
import di;
import java.util.List;
import p;
import rg;

public class FloatingActionButton$Behavior
  extends ad<FloatingActionButton>
{
  private static final boolean a;
  private cm b;
  private float c;
  private Rect d;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private final void a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
  {
    float f1 = 0.0F;
    List localList = paramCoordinatorLayout.a(paramFloatingActionButton);
    int k = localList.size();
    int j = 0;
    boolean bool;
    label82:
    label109:
    int i;
    if (j < k)
    {
      View localView = (View)localList.get(j);
      if (!(localView instanceof Snackbar.SnackbarLayout)) {
        break label375;
      }
      if ((paramFloatingActionButton.getVisibility() == 0) && (localView.getVisibility() == 0))
      {
        Rect localRect1 = h;
        if (paramFloatingActionButton.getParent() != paramCoordinatorLayout)
        {
          bool = true;
          paramCoordinatorLayout.a(paramFloatingActionButton, bool, localRect1);
          Rect localRect2 = i;
          if (localView.getParent() == paramCoordinatorLayout) {
            break label211;
          }
          bool = true;
          paramCoordinatorLayout.a(localView, bool, localRect2);
          if ((left > right) || (top > bottom) || (right < left) || (bottom < top)) {
            break label217;
          }
          i = 1;
          label174:
          if (i == 0) {
            break label375;
          }
          f1 = Math.min(f1, rg.n(localView) - localView.getHeight());
        }
      }
    }
    label211:
    label217:
    label375:
    for (;;)
    {
      j += 1;
      break;
      bool = false;
      break label82;
      bool = false;
      break label109;
      i = 0;
      break label174;
      i = 0;
      break label174;
      if (c == f1) {
        return;
      }
      float f2 = rg.n(paramFloatingActionButton);
      if ((b != null) && (b.a.b())) {
        b.a.e();
      }
      if ((paramFloatingActionButton.isShown()) && (Math.abs(f2 - f1) > paramFloatingActionButton.getHeight() * 0.667F))
      {
        if (b == null)
        {
          b = dd.a();
          b.a(p.b);
          b.a(new an(this, paramFloatingActionButton));
        }
        b.a(f2, f1);
        b.a.a();
      }
      for (;;)
      {
        c = f1;
        return;
        rg.b(paramFloatingActionButton, f1);
      }
    }
  }
  
  private final boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
  {
    if (getLayoutParamsf != paramAppBarLayout.getId()) {
      return false;
    }
    if (d != 0) {
      return false;
    }
    if (d == null) {
      d = new Rect();
    }
    Rect localRect = d;
    cw.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
    int j = bottom;
    int i = paramAppBarLayout.b();
    int k = rg.p(paramAppBarLayout);
    if (k != 0)
    {
      i += k * 2;
      if (j > i) {
        break label148;
      }
      paramFloatingActionButton.b().a(null, false);
    }
    for (;;)
    {
      return true;
      k = paramAppBarLayout.getChildCount();
      if (k > 0)
      {
        i += rg.p(paramAppBarLayout.getChildAt(k - 1)) * 2;
        break;
      }
      i = 0;
      break;
      label148:
      paramFloatingActionButton.b().b(null, false);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton.Behavior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */