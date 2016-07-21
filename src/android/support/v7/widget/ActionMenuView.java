package android.support.v7.widget;

import adu;
import adv;
import adw;
import ady;
import aek;
import ael;
import afj;
import afk;
import afl;
import afm;
import afn;
import ajh;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import ane;

public class ActionMenuView
  extends ajh
  implements adw, ael
{
  public adu a;
  public boolean b;
  public ActionMenuPresenter c;
  public adv d;
  public afn e;
  private Context i;
  private int j;
  private aek k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = false;
    float f = getResourcesgetDisplayMetricsdensity;
    n = ((int)(56.0F * f));
    o = ((int)(f * 4.0F));
    i = paramContext;
    j = 0;
  }
  
  static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool2 = false;
    afl localafl = (afl)paramView.getLayoutParams();
    int i1 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.e())) {
        break label184;
      }
      paramInt4 = 1;
      label57:
      if ((paramInt2 <= 0) || ((paramInt4 != 0) && (paramInt2 < 2))) {
        break label190;
      }
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), i1);
      int i2 = paramView.getMeasuredWidth();
      paramInt3 = i2 / paramInt1;
      paramInt2 = paramInt3;
      if (i2 % paramInt1 != 0) {
        paramInt2 = paramInt3 + 1;
      }
      paramInt3 = paramInt2;
      if (paramInt4 != 0)
      {
        paramInt3 = paramInt2;
        if (paramInt2 >= 2) {}
      }
    }
    label184:
    label190:
    for (paramInt3 = 2;; paramInt3 = 0)
    {
      boolean bool1 = bool2;
      if (!a)
      {
        bool1 = bool2;
        if (paramInt4 != 0) {
          bool1 = true;
        }
      }
      d = bool1;
      b = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), i1);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label57;
    }
  }
  
  protected static afl a()
  {
    afl localafl = new afl();
    h = 16;
    return localafl;
  }
  
  protected static afl a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof afl)) {}
      for (paramLayoutParams = new afl((afl)paramLayoutParams);; paramLayoutParams = new afl(paramLayoutParams))
      {
        if (h <= 0) {
          h = 16;
        }
        return paramLayoutParams;
      }
    }
    return a();
  }
  
  private final afl b(AttributeSet paramAttributeSet)
  {
    return new afl(getContext(), paramAttributeSet);
  }
  
  private final boolean d(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof afj)) {
        bool1 = ((afj)localView1).g() | false;
      }
    }
    if ((paramInt > 0) && ((localView2 instanceof afj))) {
      return ((afj)localView2).f() | bool1;
    }
    return bool1;
  }
  
  public final void a(int paramInt)
  {
    if (j != paramInt)
    {
      j = paramInt;
      if (paramInt == 0) {
        i = getContext();
      }
    }
    else
    {
      return;
    }
    i = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public final void a(adu paramadu)
  {
    a = paramadu;
  }
  
  public final void a(aek paramaek, adv paramadv)
  {
    k = paramaek;
    d = paramadv;
  }
  
  public final void a(ActionMenuPresenter paramActionMenuPresenter)
  {
    c = paramActionMenuPresenter;
    c.a(this);
  }
  
  public final boolean a(ady paramady)
  {
    return a.a(paramady, null, 0);
  }
  
  public final Menu b()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (a == null)
    {
      localObject = getContext();
      a = new adu((Context)localObject);
      a.a(new afm(this));
      c = new ActionMenuPresenter((Context)localObject);
      c.c();
      localActionMenuPresenter = c;
      if (k == null) {
        break label108;
      }
    }
    label108:
    for (Object localObject = k;; localObject = new afk(this))
    {
      f = ((aek)localObject);
      a.a(c, i);
      c.a(this);
      return a;
    }
  }
  
  public final void c()
  {
    if (c != null) {
      c.g();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof afl));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    if (c != null)
    {
      c.b(false);
      if (c.i())
      {
        c.f();
        c.e();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!l)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i6 = getChildCount();
    int i5 = (paramInt4 - paramInt2) / 2;
    int i7 = h;
    paramInt2 = 0;
    int i1 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    paramInt4 = 0;
    paramBoolean = ane.a(this);
    int i2 = 0;
    label68:
    View localView;
    afl localafl;
    int i3;
    int i8;
    int i4;
    label172:
    int i9;
    if (i2 < i6)
    {
      localView = getChildAt(i2);
      if (localView.getVisibility() == 8) {
        break label681;
      }
      localafl = (afl)localView.getLayoutParams();
      if (a)
      {
        i3 = localView.getMeasuredWidth();
        paramInt4 = i3;
        if (d(i2)) {
          paramInt4 = i3 + i7;
        }
        i8 = localView.getMeasuredHeight();
        if (paramBoolean)
        {
          i3 = getPaddingLeft();
          i3 = leftMargin + i3;
          i4 = i3 + paramInt4;
          i9 = i5 - i8 / 2;
          localView.layout(i3, i9, i4, i8 + i9);
          paramInt4 = i1 - paramInt4;
          i3 = 1;
          i1 = paramInt2;
          paramInt2 = i3;
        }
      }
    }
    for (;;)
    {
      i3 = i2 + 1;
      i2 = i1;
      i1 = paramInt4;
      paramInt4 = paramInt2;
      paramInt2 = i2;
      i2 = i3;
      break label68;
      i4 = getWidth() - getPaddingRight() - rightMargin;
      i3 = i4 - paramInt4;
      break label172;
      i4 = localView.getMeasuredWidth();
      i8 = leftMargin;
      i9 = rightMargin;
      d(i2);
      i3 = paramInt2 + 1;
      i1 -= i9 + (i4 + i8);
      paramInt2 = paramInt4;
      paramInt4 = i1;
      i1 = i3;
      continue;
      if ((i6 == 1) && (paramInt4 == 0))
      {
        localView = getChildAt(0);
        paramInt2 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
        paramInt3 = i5 - paramInt4 / 2;
        localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt4 + paramInt3);
        return;
      }
      if (paramInt4 != 0)
      {
        paramInt1 = 0;
        label402:
        paramInt1 = paramInt2 - paramInt1;
        if (paramInt1 <= 0) {
          break label553;
        }
        paramInt1 = i1 / paramInt1;
        label415:
        paramInt3 = Math.max(0, paramInt1);
        if (!paramBoolean) {
          break label558;
        }
        paramInt1 = getWidth() - getPaddingRight();
        paramInt2 = 0;
        label438:
        if (paramInt2 < i6)
        {
          localView = getChildAt(paramInt2);
          localafl = (afl)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (a)) {
            break label678;
          }
          paramInt1 -= rightMargin;
          paramInt4 = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          i2 = i5 - i1 / 2;
          localView.layout(paramInt1 - paramInt4, i2, paramInt1, i1 + i2);
          paramInt1 -= leftMargin + paramInt4 + paramInt3;
        }
      }
      label553:
      label558:
      label565:
      label675:
      label678:
      for (;;)
      {
        paramInt2 += 1;
        break label438;
        break;
        paramInt1 = 1;
        break label402;
        paramInt1 = 0;
        break label415;
        paramInt1 = getPaddingLeft();
        paramInt2 = 0;
        if (paramInt2 < i6)
        {
          localView = getChildAt(paramInt2);
          localafl = (afl)localView.getLayoutParams();
          if ((localView.getVisibility() == 8) || (a)) {
            break label675;
          }
          paramInt1 += leftMargin;
          paramInt4 = localView.getMeasuredWidth();
          i1 = localView.getMeasuredHeight();
          i2 = i5 - i1 / 2;
          localView.layout(paramInt1, i2, paramInt1 + paramInt4, i1 + i2);
          paramInt1 = rightMargin + paramInt4 + paramInt3 + paramInt1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break label565;
          break;
        }
      }
      label681:
      i3 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i1;
      i1 = i3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = l;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i1;
    int i2;
    int i12;
    int i11;
    int i9;
    int i13;
    int i14;
    for (boolean bool1 = true;; bool1 = false)
    {
      l = bool1;
      if (bool2 != l) {
        m = 0;
      }
      i1 = View.MeasureSpec.getSize(paramInt1);
      if ((l) && (a != null) && (i1 != m))
      {
        m = i1;
        a.a(true);
      }
      i2 = getChildCount();
      if ((!l) || (i2 <= 0)) {
        break label1304;
      }
      i12 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i11 = View.MeasureSpec.getSize(paramInt2);
      i1 = getPaddingLeft();
      i2 = getPaddingRight();
      i9 = getPaddingTop() + getPaddingBottom();
      i13 = getChildMeasureSpec(paramInt2, i9, -2);
      i14 = paramInt1 - (i1 + i2);
      paramInt1 = i14 / n;
      paramInt2 = n;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i14, 0);
      return;
    }
    int i15 = n + i14 % paramInt2 / paramInt1;
    paramInt2 = 0;
    int i5 = 0;
    int i4 = 0;
    int i6 = 0;
    int i3 = 0;
    long l1 = 0L;
    int i16 = getChildCount();
    int i7 = 0;
    Object localObject;
    afl localafl;
    label351:
    label369:
    int i8;
    label407:
    label418:
    long l2;
    if (i7 < i16)
    {
      localObject = getChildAt(i7);
      if (((View)localObject).getVisibility() == 8) {
        break label1438;
      }
      bool1 = localObject instanceof ActionMenuItemView;
      i6 += 1;
      if (bool1) {
        ((View)localObject).setPadding(o, 0, o, 0);
      }
      localafl = (afl)((View)localObject).getLayoutParams();
      f = false;
      c = 0;
      b = 0;
      d = false;
      leftMargin = 0;
      rightMargin = 0;
      if ((bool1) && (((ActionMenuItemView)localObject).e()))
      {
        bool1 = true;
        e = bool1;
        if (!a) {
          break label512;
        }
        i1 = 1;
        i8 = a((View)localObject, i15, i1, i13, i9);
        i5 = Math.max(i5, i8);
        if (!d) {
          break label1431;
        }
        i1 = i4 + 1;
        if (!a) {
          break label1424;
        }
        i2 = 1;
        paramInt1 -= i8;
        i4 = Math.max(paramInt2, ((View)localObject).getMeasuredHeight());
        if (i8 != 1) {
          break label1386;
        }
        l2 = 1 << i7;
        paramInt2 = i4;
        i3 = paramInt1;
        i4 = i1;
        i8 = i2;
        l1 = l2 | l1;
        paramInt1 = i6;
        i2 = i3;
        i1 = paramInt2;
        i3 = i8;
        paramInt2 = i5;
      }
    }
    for (;;)
    {
      i7 += 1;
      i6 = paramInt1;
      paramInt1 = i2;
      i5 = paramInt2;
      paramInt2 = i1;
      break;
      bool1 = false;
      break label351;
      label512:
      i1 = paramInt1;
      break label369;
      long l3;
      if ((i3 != 0) && (i6 == 2))
      {
        i8 = 1;
        i1 = 0;
        i7 = paramInt1;
        paramInt1 = i1;
        l3 = l1;
        if (i4 <= 0) {
          break label863;
        }
        l3 = l1;
        if (i7 <= 0) {
          break label863;
        }
        i1 = Integer.MAX_VALUE;
        l2 = 0L;
        i2 = 0;
        i9 = 0;
        label573:
        if (i9 >= i16) {
          break label697;
        }
        localObject = (afl)getChildAt(i9).getLayoutParams();
        if (!d) {
          break label1371;
        }
        if (b >= i1) {
          break label660;
        }
        i2 = b;
        l2 = 1 << i9;
        i1 = 1;
      }
      for (;;)
      {
        int i10 = i9 + 1;
        i9 = i2;
        i2 = i1;
        i1 = i9;
        i9 = i10;
        break label573;
        i8 = 0;
        break;
        label660:
        if (b == i1)
        {
          l2 |= 1 << i9;
          i10 = i2 + 1;
          i2 = i1;
          i1 = i10;
          continue;
          label697:
          l1 |= l2;
          l3 = l1;
          if (i2 <= i7)
          {
            i2 = 0;
            paramInt1 = i7;
            label721:
            if (i2 < i16)
            {
              localObject = getChildAt(i2);
              localafl = (afl)((View)localObject).getLayoutParams();
              if ((1 << i2 & l2) == 0L)
              {
                if (b != i1 + 1) {
                  break label1368;
                }
                l1 |= 1 << i2;
              }
            }
          }
          label863:
          label1029:
          label1032:
          label1140:
          label1208:
          label1211:
          label1214:
          label1304:
          label1362:
          label1368:
          for (;;)
          {
            i2 += 1;
            break label721;
            if ((i8 != 0) && (e) && (paramInt1 == 1)) {
              ((View)localObject).setPadding(o + i15, 0, o, 0);
            }
            b += 1;
            f = true;
            paramInt1 -= 1;
            continue;
            i1 = 1;
            i7 = paramInt1;
            paramInt1 = i1;
            break;
            float f2;
            float f1;
            if ((i3 == 0) && (i6 == 1))
            {
              i1 = 1;
              if ((i7 <= 0) || (l3 == 0L) || ((i7 >= i6 - 1) && (i1 == 0) && (i5 <= 1))) {
                break label1211;
              }
              float f3 = Long.bitCount(l3);
              f2 = f3;
              if (i1 != 0) {
                break label1362;
              }
              f1 = f3;
              if ((1L & l3) != 0L)
              {
                f1 = f3;
                if (!getChildAt0getLayoutParamse) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i16 - 1 & l3) == 0L) {
                break label1362;
              }
              f2 = f1;
              if (getChildAt1getLayoutParamse) {
                break label1362;
              }
            }
            for (f1 -= 0.5F;; f1 = f2)
            {
              if (f1 > 0.0F)
              {
                i1 = (int)(i7 * i15 / f1);
                i2 = 0;
                i3 = paramInt1;
                if (i2 >= i16) {
                  break label1214;
                }
                if ((1 << i2 & l3) == 0L) {
                  break label1208;
                }
                localObject = getChildAt(i2);
                localafl = (afl)((View)localObject).getLayoutParams();
                if (!(localObject instanceof ActionMenuItemView)) {
                  break label1140;
                }
                c = i1;
                f = true;
                if ((i2 == 0) && (!e)) {
                  leftMargin = (-i1 / 2);
                }
                paramInt1 = 1;
              }
              for (;;)
              {
                i2 += 1;
                break label1032;
                i1 = 0;
                break;
                i1 = 0;
                break label1029;
                if (a)
                {
                  c = i1;
                  f = true;
                  rightMargin = (-i1 / 2);
                  paramInt1 = 1;
                }
                else
                {
                  if (i2 != 0) {
                    leftMargin = (i1 / 2);
                  }
                  if (i2 != i16 - 1) {
                    rightMargin = (i1 / 2);
                  }
                }
              }
              i3 = paramInt1;
              if (i3 != 0)
              {
                paramInt1 = 0;
                while (paramInt1 < i16)
                {
                  localObject = getChildAt(paramInt1);
                  localafl = (afl)((View)localObject).getLayoutParams();
                  if (f)
                  {
                    i1 = b;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(c + i1 * i15, 1073741824), i13);
                  }
                  paramInt1 += 1;
                }
              }
              if (i12 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i14, paramInt2);
                return;
                i1 = 0;
                while (i1 < i2)
                {
                  localObject = (afl)getChildAt(i1).getLayoutParams();
                  rightMargin = 0;
                  leftMargin = 0;
                  i1 += 1;
                }
                super.onMeasure(paramInt1, paramInt2);
                return;
                paramInt2 = i11;
              }
            }
          }
        }
        else
        {
          label1371:
          i10 = i1;
          i1 = i2;
          i2 = i10;
        }
      }
      label1386:
      paramInt2 = i6;
      i3 = i5;
      i5 = i4;
      i6 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i3;
      i4 = i1;
      i3 = i2;
      i1 = i5;
      i2 = i6;
      continue;
      label1424:
      i2 = i3;
      break label418;
      label1431:
      i1 = i4;
      break label407;
      label1438:
      i1 = paramInt2;
      i2 = paramInt1;
      paramInt2 = i5;
      paramInt1 = i6;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */