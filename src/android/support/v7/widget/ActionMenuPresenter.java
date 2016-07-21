package android.support.v7.widget;

import acg;
import ach;
import acy;
import adp;
import adu;
import ady;
import aeh;
import ael;
import aem;
import aep;
import afb;
import afc;
import afd;
import afe;
import afg;
import afh;
import afl;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import java.util.ArrayList;
import oy;
import oz;
import rz;

public final class ActionMenuPresenter
  extends adp
  implements oz
{
  private final SparseBooleanArray A = new SparseBooleanArray();
  private View B;
  private afc C;
  public afe i;
  public int j;
  public boolean k;
  public boolean l;
  public afg m;
  public afb n;
  public afd o;
  public final afh p = new afh(this);
  public int q;
  private Drawable r;
  private boolean s;
  private boolean t;
  private boolean u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private int z;
  
  public ActionMenuPresenter(Context paramContext)
  {
    super(paramContext, ach.c, ach.b);
  }
  
  public final ael a(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.a(paramViewGroup);
    ((ActionMenuView)paramViewGroup).a(this);
    return paramViewGroup;
  }
  
  public final View a(ady paramady, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramady.getActionView();
    if ((localView == null) || (paramady.i())) {
      localView = super.a(paramady, paramView, paramViewGroup);
    }
    if (paramady.isActionViewExpanded()) {}
    for (int i1 = 8;; i1 = 0)
    {
      localView.setVisibility(i1);
      paramady = (ActionMenuView)paramViewGroup;
      paramView = localView.getLayoutParams();
      if (!paramady.checkLayoutParams(paramView)) {
        localView.setLayoutParams(ActionMenuView.a(paramView));
      }
      return localView;
    }
  }
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    g();
    super.a(paramadu, paramBoolean);
  }
  
  public final void a(ady paramady, aem paramaem)
  {
    paramaem.a(paramady);
    paramady = (ActionMenuView)g;
    paramaem = (ActionMenuItemView)paramaem;
    b = paramady;
    if (C == null) {
      C = new afc(this);
    }
    c = C;
  }
  
  public final void a(Context paramContext, adu paramadu)
  {
    boolean bool = true;
    super.a(paramContext, paramadu);
    paramadu = paramContext.getResources();
    paramContext = acy.a(paramContext);
    int i1;
    if (!u)
    {
      if (Build.VERSION.SDK_INT >= 19) {
        t = bool;
      }
    }
    else
    {
      if (!y) {
        v = (a.getResources().getDisplayMetrics().widthPixels / 2);
      }
      if (!k) {
        j = a.getResources().getInteger(acg.a);
      }
      i1 = v;
      if (!t) {
        break label226;
      }
      if (i == null)
      {
        i = new afe(this, a);
        if (s)
        {
          i.setImageDrawable(r);
          r = null;
          s = false;
        }
        int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        i.measure(i2, i2);
      }
      i1 -= i.getMeasuredWidth();
    }
    for (;;)
    {
      w = i1;
      z = ((int)(56.0F * getDisplayMetricsdensity));
      B = null;
      return;
      if (!rz.a(ViewConfiguration.get(a))) {
        break;
      }
      bool = false;
      break;
      label226:
      i = null;
    }
  }
  
  public final void a(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ActionMenuPresenter.SavedState)) {}
    do
    {
      do
      {
        return;
        paramParcelable = (ActionMenuPresenter.SavedState)paramParcelable;
      } while (a <= 0);
      paramParcelable = c.findItem(a);
    } while (paramParcelable == null);
    a((aep)paramParcelable.getSubMenu());
  }
  
  public final void a(ActionMenuView paramActionMenuView)
  {
    g = paramActionMenuView;
    a = c;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.a(null);
      return;
    }
    c.b(false);
  }
  
  public final boolean a()
  {
    ArrayList localArrayList = c.h();
    int i9 = localArrayList.size();
    int i1 = j;
    int i8 = w;
    int i10 = View.MeasureSpec.makeMeasureSpec(0, 0);
    ViewGroup localViewGroup = (ViewGroup)g;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i2 = 0;
    Object localObject1;
    if (i2 < i9)
    {
      localObject1 = (ady)localArrayList.get(i2);
      if (((ady)localObject1).h())
      {
        i3 += 1;
        label82:
        if ((!l) || (!((ady)localObject1).isActionViewExpanded())) {
          break label820;
        }
        i1 = 0;
      }
    }
    label304:
    label445:
    label505:
    label510:
    label549:
    label632:
    label644:
    label649:
    label797:
    label800:
    label811:
    label820:
    for (;;)
    {
      i2 += 1;
      break;
      if (((ady)localObject1).g())
      {
        i4 += 1;
        break label82;
      }
      i5 = 1;
      break label82;
      i2 = i1;
      if (t) {
        if (i5 == 0)
        {
          i2 = i1;
          if (i3 + i4 <= i1) {}
        }
        else
        {
          i2 = i1 - 1;
        }
      }
      i2 -= i3;
      localObject1 = A;
      ((SparseBooleanArray)localObject1).clear();
      i1 = 0;
      if (x)
      {
        i1 = i8 / z;
        i3 = z;
        i4 = z;
      }
      for (int i6 = i8 % i3 / i1 + i4;; i6 = 0)
      {
        int i7 = 0;
        i5 = 0;
        i3 = i1;
        i1 = i2;
        i4 = i8;
        i2 = i5;
        ady localady;
        Object localObject2;
        if (i7 < i9)
        {
          localady = (ady)localArrayList.get(i7);
          if (localady.h())
          {
            localObject2 = a(localady, B, localViewGroup);
            if (B == null) {
              B = ((View)localObject2);
            }
            if (x)
            {
              i5 = i3 - ActionMenuView.a((View)localObject2, i6, i3, i10, 0);
              i3 = ((View)localObject2).getMeasuredWidth();
              if (i2 != 0) {
                break label811;
              }
              i2 = i3;
            }
          }
        }
        for (;;)
        {
          i8 = localady.getGroupId();
          if (i8 != 0) {
            ((SparseBooleanArray)localObject1).put(i8, true);
          }
          localady.c(true);
          i4 -= i3;
          i3 = i1;
          i1 = i4;
          i8 = i7 + 1;
          i7 = i3;
          i3 = i5;
          i4 = i1;
          i1 = i7;
          i7 = i8;
          break;
          ((View)localObject2).measure(i10, i10);
          i5 = i3;
          break label304;
          int i11;
          boolean bool;
          int i12;
          if (localady.g())
          {
            i11 = localady.getGroupId();
            bool = ((SparseBooleanArray)localObject1).get(i11);
            if (((i1 > 0) || (bool)) && (i4 > 0) && ((!x) || (i3 > 0)))
            {
              i12 = 1;
              if (i12 == 0) {
                break label800;
              }
              localObject2 = a(localady, B, localViewGroup);
              if (B == null) {
                B = ((View)localObject2);
              }
              if (!x) {
                break label632;
              }
              i5 = ActionMenuView.a((View)localObject2, i6, i3, i10, 0);
              if (i5 != 0) {
                break label797;
              }
              i12 = 0;
              i3 -= i5;
              i5 = ((View)localObject2).getMeasuredWidth();
              i8 = i4 - i5;
              i4 = i2;
              if (i2 == 0) {
                i4 = i5;
              }
              if (!x) {
                break label649;
              }
              if (i8 < 0) {
                break label644;
              }
              i2 = 1;
              i12 &= i2;
              i2 = i4;
              i5 = i3;
              i4 = i8;
              i3 = i2;
              i2 = i5;
            }
          }
          for (;;)
          {
            if ((i12 != 0) && (i11 != 0)) {
              ((SparseBooleanArray)localObject1).put(i11, true);
            }
            for (;;)
            {
              i5 = i1;
              if (i12 != 0) {
                i5 = i1 - 1;
              }
              localady.c(i12);
              i1 = i4;
              i4 = i5;
              i5 = i2;
              i2 = i3;
              i3 = i4;
              break;
              int i13 = 0;
              break label445;
              ((View)localObject2).measure(i10, i10);
              break label510;
              i2 = 0;
              break label549;
              if (i8 + i4 > 0) {}
              for (i2 = 1;; i2 = 0)
              {
                i13 &= i2;
                i2 = i3;
                i3 = i4;
                i4 = i8;
                break;
              }
              if (bool)
              {
                ((SparseBooleanArray)localObject1).put(i11, false);
                i8 = 0;
                for (;;)
                {
                  if (i8 < i7)
                  {
                    localObject2 = (ady)localArrayList.get(i8);
                    i5 = i1;
                    if (((ady)localObject2).getGroupId() == i11)
                    {
                      i5 = i1;
                      if (((ady)localObject2).f()) {
                        i5 = i1 + 1;
                      }
                      ((ady)localObject2).c(false);
                    }
                    i8 += 1;
                    i1 = i5;
                    continue;
                    localady.c(false);
                    i5 = i4;
                    i4 = i1;
                    i1 = i5;
                    i5 = i3;
                    i3 = i4;
                    break;
                    return true;
                  }
                }
              }
            }
            break label505;
            i5 = i2;
            i2 = i3;
            i3 = i5;
          }
        }
      }
    }
  }
  
  public final boolean a(ady paramady)
  {
    return paramady.f();
  }
  
  public final boolean a(aep paramaep)
  {
    if (!paramaep.hasVisibleItems()) {
      return false;
    }
    for (Object localObject1 = paramaep; m != c; localObject1 = (aep)m) {}
    Object localObject2 = ((aep)localObject1).getItem();
    ViewGroup localViewGroup = (ViewGroup)g;
    int i1;
    if (localViewGroup != null)
    {
      int i2 = localViewGroup.getChildCount();
      i1 = 0;
      if (i1 < i2)
      {
        localObject1 = localViewGroup.getChildAt(i1);
        if ((!(localObject1 instanceof aem)) || (((aem)localObject1).a() != localObject2)) {}
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label139;
      }
      if (i != null) {
        break label133;
      }
      return false;
      i1 += 1;
      break;
      localObject1 = null;
    }
    label133:
    localObject2 = i;
    label139:
    q = paramaep.getItem().getItemId();
    n = new afb(this, b, paramaep);
    n.e = ((View)localObject2);
    n.c();
    super.a(paramaep);
    return true;
  }
  
  public final boolean a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramViewGroup.getChildAt(paramInt) == i) {
      return false;
    }
    return super.a(paramViewGroup, paramInt);
  }
  
  public final void b(boolean paramBoolean)
  {
    int i2 = 0;
    ((View)g).getParent();
    super.b(paramBoolean);
    ((View)g).requestLayout();
    Object localObject1;
    int i3;
    int i1;
    Object localObject2;
    if (c != null)
    {
      localObject1 = c;
      ((adu)localObject1).i();
      localObject1 = d;
      i3 = ((ArrayList)localObject1).size();
      i1 = 0;
      while (i1 < i3)
      {
        localObject2 = getd;
        if (localObject2 != null) {
          a = this;
        }
        i1 += 1;
      }
    }
    if (c != null)
    {
      localObject1 = c.j();
      i1 = i2;
      if (t)
      {
        i1 = i2;
        if (localObject1 != null)
        {
          i3 = ((ArrayList)localObject1).size();
          if (i3 != 1) {
            break label285;
          }
          if (((ady)((ArrayList)localObject1).get(0)).isActionViewExpanded()) {
            break label280;
          }
          i1 = 1;
        }
      }
      label162:
      if (i1 == 0) {
        break label297;
      }
      if (i == null) {
        i = new afe(this, a);
      }
      localObject1 = (ViewGroup)i.getParent();
      if (localObject1 != g)
      {
        if (localObject1 != null) {
          ((ViewGroup)localObject1).removeView(i);
        }
        localObject1 = (ActionMenuView)g;
        localObject2 = i;
        afl localafl = ActionMenuView.a();
        a = true;
        ((ActionMenuView)localObject1).addView((View)localObject2, localafl);
      }
    }
    for (;;)
    {
      g).b = t;
      return;
      localObject1 = null;
      break;
      label280:
      i1 = 0;
      break label162;
      label285:
      i1 = i2;
      if (i3 <= 0) {
        break label162;
      }
      i1 = 1;
      break label162;
      label297:
      if ((i != null) && (i.getParent() == g)) {
        ((ViewGroup)g).removeView(i);
      }
    }
  }
  
  public final void c()
  {
    t = true;
    u = true;
  }
  
  public final Parcelable d()
  {
    ActionMenuPresenter.SavedState localSavedState = new ActionMenuPresenter.SavedState();
    a = q;
    return localSavedState;
  }
  
  public final boolean e()
  {
    if ((t) && (!i()) && (c != null) && (g != null) && (o == null) && (!c.j().isEmpty()))
    {
      o = new afd(this, new afg(this, b, c, i));
      ((View)g).post(o);
      super.a(null);
      return true;
    }
    return false;
  }
  
  public final boolean f()
  {
    if ((o != null) && (g != null))
    {
      ((View)g).removeCallbacks(o);
      o = null;
      return true;
    }
    afg localafg = m;
    if (localafg != null)
    {
      localafg.f();
      return true;
    }
    return false;
  }
  
  public final boolean g()
  {
    return f() | h();
  }
  
  public final boolean h()
  {
    if (n != null)
    {
      n.f();
      return true;
    }
    return false;
  }
  
  public final boolean i()
  {
    return (m != null) && (m.g());
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */