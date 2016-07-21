package android.support.v7.widget;

import act;
import acu;
import aim;
import ain;
import aio;
import aip;
import aiq;
import air;
import ais;
import aiu;
import aiv;
import aiy;
import aja;
import ajb;
import ajc;
import aje;
import ajf;
import amb;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.LogPrinter;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Array;
import java.util.Arrays;
import rg;

public class GridLayout
  extends ViewGroup
{
  private static final int A;
  private static final aiv B = new aio();
  private static final aiv C = new aip();
  static final Printer a = new LogPrinter(3, GridLayout.class.getName());
  static final Printer b = new aim();
  public static final aiv k;
  public static final aiv l = B;
  public static final aiv m = C;
  public static final aiv n = B;
  public static final aiv o = C;
  public static final aiv p = a(n, o);
  public static final aiv q = a(o, n);
  public static final aiv r = new air();
  public static final aiv s = new ais();
  public static final aiv t = new aiu();
  private static final int u = acu.P;
  private static final int v = acu.Q;
  private static final int w = acu.N;
  private static final int x = acu.S;
  private static final int y = acu.M;
  private static final int z = acu.R;
  final aiy c = new aiy(this, true);
  final aiy d = new aiy(this, false);
  int e = 0;
  boolean f = false;
  int g = 1;
  int h;
  int i = 0;
  public Printer j = a;
  
  static
  {
    A = acu.O;
    k = new ain();
  }
  
  public GridLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GridLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h = paramContext.getResources().getDimensionPixelOffset(act.a);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, acu.L);
    try
    {
      paramInt = paramContext.getInt(v, Integer.MIN_VALUE);
      d.a(paramInt);
      c();
      requestLayout();
      paramInt = paramContext.getInt(w, Integer.MIN_VALUE);
      c.a(paramInt);
      c();
      requestLayout();
      paramInt = paramContext.getInt(u, 0);
      if (e != paramInt)
      {
        e = paramInt;
        c();
        requestLayout();
      }
      f = paramContext.getBoolean(x, false);
      requestLayout();
      g = paramContext.getInt(y, 1);
      requestLayout();
      boolean bool = paramContext.getBoolean(z, true);
      d.a(bool);
      c();
      requestLayout();
      bool = paramContext.getBoolean(A, true);
      c.a(bool);
      c();
      requestLayout();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1 + paramInt2), View.MeasureSpec.getMode(paramInt1));
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int i2 = -1;
    int i1 = 0;
    int i3 = paramArrayOfInt.length;
    while (i1 < i3)
    {
      i2 = Math.max(i2, paramArrayOfInt[i1]);
      i1 += 1;
    }
    return i2;
  }
  
  public static aiv a(int paramInt, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = 7;
      label7:
      if (!paramBoolean) {
        break label86;
      }
    }
    label86:
    for (int i2 = 0;; i2 = 4) {
      switch ((i1 & paramInt) >> i2)
      {
      default: 
        return k;
        i1 = 112;
        break label7;
      }
    }
    if (paramBoolean) {
      return p;
    }
    return l;
    if (paramBoolean) {
      return q;
    }
    return m;
    return t;
    return r;
    return n;
    return o;
  }
  
  private static aiv a(aiv paramaiv1, aiv paramaiv2)
  {
    return new aiq(paramaiv1, paramaiv2);
  }
  
  public static ajc a(View paramView)
  {
    return (ajc)paramView.getLayoutParams();
  }
  
  public static ajf a()
  {
    return a(Integer.MIN_VALUE, 1, k, 0.0F);
  }
  
  public static ajf a(int paramInt1, int paramInt2, aiv paramaiv, float paramFloat)
  {
    if (paramInt1 != Integer.MIN_VALUE) {}
    for (boolean bool = true;; bool = false) {
      return new ajf(bool, paramInt1, paramInt2, paramaiv, paramFloat);
    }
  }
  
  private final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = getChildAt(i1);
      ajc localajc;
      if (localView.getVisibility() != 8)
      {
        localajc = (ajc)localView.getLayoutParams();
        if (!paramBoolean) {
          break label75;
        }
        a(localView, paramInt1, paramInt2, width, height);
      }
      for (;;)
      {
        i1 += 1;
        break;
        label75:
        boolean bool;
        label85:
        label97:
        ajb localajb;
        if (e == 0)
        {
          bool = true;
          if (!bool) {
            break label192;
          }
          localObject = b;
          if (((ajf)localObject).a(bool) != t) {
            break label200;
          }
          localajb = c;
          if (!bool) {
            break label202;
          }
        }
        int i3;
        label192:
        label200:
        label202:
        for (Object localObject = c;; localObject = d)
        {
          localObject = ((aiy)localObject).c();
          i3 = localObject[b] - localObject[a] - a(localView, bool);
          if (!bool) {
            break label211;
          }
          a(localView, paramInt1, paramInt2, i3, height);
          break;
          bool = false;
          break label85;
          localObject = a;
          break label97;
          break;
        }
        label211:
        a(localView, paramInt1, paramInt2, width, i3);
      }
    }
  }
  
  private static void a(ajc paramajc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ajb localajb = new ajb(paramInt1, paramInt1 + paramInt2);
    a = a.a(localajb);
    localajb = new ajb(paramInt3, paramInt3 + paramInt4);
    b = b.a(localajb);
  }
  
  private final void a(ajc paramajc, boolean paramBoolean)
  {
    String str;
    label18:
    ajb localajb;
    if (paramBoolean)
    {
      str = "column";
      if (!paramBoolean) {
        break label183;
      }
      paramajc = b;
      localajb = c;
      if ((a != Integer.MIN_VALUE) && (a < 0)) {
        a(str + " indices must be positive");
      }
      if (!paramBoolean) {
        break label191;
      }
    }
    label183:
    label191:
    for (paramajc = c;; paramajc = d)
    {
      int i1 = b;
      if (i1 != Integer.MIN_VALUE)
      {
        if (b > i1) {
          a(str + " indices (start + span) mustn't exceed the " + str + " count");
        }
        if (localajb.a() > i1) {
          a(str + " span mustn't exceed the " + str + " count");
        }
      }
      return;
      str = "row";
      break;
      paramajc = a;
      break label18;
    }
  }
  
  private final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.measure(getChildMeasureSpec(paramInt1, a(paramView, true), paramInt3), getChildMeasureSpec(paramInt2, a(paramView, false), paramInt4));
  }
  
  public static void a(String paramString)
  {
    throw new IllegalArgumentException(paramString + ". ");
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, paramArrayOfT1.length, paramArrayOfT2.length);
    return arrayOfObject;
  }
  
  public static int b(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramView.getMeasuredWidth();
    }
    return paramView.getMeasuredHeight();
  }
  
  private final int b(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (g == 1) {
      return a(paramView, paramBoolean1, paramBoolean2);
    }
    Object localObject;
    if (paramBoolean1)
    {
      localObject = c;
      if (!paramBoolean2) {
        break label124;
      }
      if (i == null) {
        i = new int[((aiy)localObject).a() + 1];
      }
      if (!j)
      {
        ((aiy)localObject).b(true);
        j = true;
      }
      localObject = i;
      label79:
      paramView = (ajc)paramView.getLayoutParams();
      if (!paramBoolean1) {
        break label176;
      }
      paramView = b;
      label96:
      if (!paramBoolean2) {
        break label184;
      }
    }
    label124:
    label176:
    label184:
    for (int i1 = c.a;; i1 = c.b)
    {
      return localObject[i1];
      localObject = d;
      break;
      if (k == null) {
        k = new int[((aiy)localObject).a() + 1];
      }
      if (!l)
      {
        ((aiy)localObject).b(false);
        l = true;
      }
      localObject = k;
      break label79;
      paramView = a;
      break label96;
    }
  }
  
  private final boolean b()
  {
    return rg.g(this) == 1;
  }
  
  private final void c()
  {
    i = 0;
    if (c != null) {
      c.d();
    }
    if (d != null) {
      d.d();
    }
    d();
  }
  
  private final void d()
  {
    if ((c != null) && (d != null))
    {
      c.e();
      d.e();
    }
  }
  
  private final int e()
  {
    int i1 = 1;
    int i3 = getChildCount();
    int i2 = 0;
    if (i2 < i3)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 8) {
        break label57;
      }
      i1 = ((ajc)localView.getLayoutParams()).hashCode() + i1 * 31;
    }
    label57:
    for (;;)
    {
      i2 += 1;
      break;
      return i1;
    }
  }
  
  private final void f()
  {
    int i7;
    Object localObject;
    label28:
    int i8;
    label45:
    int i1;
    int i2;
    int[] arrayOfInt;
    int i9;
    ajc localajc;
    label97:
    ajb localajb;
    boolean bool1;
    int i12;
    label141:
    boolean bool2;
    int i10;
    if (i == 0) {
      if (e == 0)
      {
        i7 = 1;
        if (i7 == 0) {
          break label260;
        }
        localObject = c;
        if (b == Integer.MIN_VALUE) {
          break label269;
        }
        i8 = b;
        i1 = 0;
        i2 = 0;
        arrayOfInt = new int[i8];
        int i11 = getChildCount();
        i9 = 0;
        if (i9 >= i11) {
          break label471;
        }
        localajc = (ajc)getChildAt(i9).getLayoutParams();
        if (i7 == 0) {
          break label275;
        }
        localObject = a;
        localajb = c;
        bool1 = b;
        i12 = localajb.a();
        if (bool1) {
          i1 = a;
        }
        if (i7 == 0) {
          break label285;
        }
        localObject = b;
        localajb = c;
        bool2 = b;
        i10 = localajb.a();
        if (i8 != 0) {
          break label295;
        }
        if (!bool2) {
          break label510;
        }
      }
    }
    label215:
    label260:
    label269:
    label275:
    label285:
    label295:
    label358:
    label363:
    label390:
    label471:
    label510:
    for (int i3 = a;; i3 = i2)
    {
      int i5 = i3;
      int i6 = i1;
      if (i8 != 0)
      {
        i2 = i3;
        int i4 = i1;
        if (bool1)
        {
          i5 = i3;
          i6 = i1;
          if (!bool2)
          {
            i4 = i1;
            i2 = i3;
          }
        }
        else
        {
          for (;;)
          {
            i3 = i2 + i10;
            if (i3 > arrayOfInt.length) {
              i1 = 0;
            }
            for (;;)
            {
              i5 = i2;
              i6 = i4;
              if (i1 != 0) {
                break label390;
              }
              if (!bool2) {
                break label363;
              }
              i4 += 1;
              break label215;
              i7 = 0;
              break;
              localObject = d;
              break label28;
              i8 = 0;
              break label45;
              localObject = b;
              break label97;
              localObject = a;
              break label141;
              if (bool2) {}
              for (i3 = Math.min(a, i8);; i3 = 0)
              {
                i10 = Math.min(i10, i8 - i3);
                break;
              }
              i1 = i2;
              for (;;)
              {
                if (i1 >= i3) {
                  break label358;
                }
                if (arrayOfInt[i1] > i4)
                {
                  i1 = 0;
                  break;
                }
                i1 += 1;
              }
              i1 = 1;
            }
            if (i2 + i10 <= i8)
            {
              i2 += 1;
            }
            else
            {
              i2 = 0;
              i4 += 1;
            }
          }
        }
        i1 = arrayOfInt.length;
        Arrays.fill(arrayOfInt, Math.min(i5, i1), Math.min(i5 + i10, i1), i6 + i12);
      }
      if (i7 != 0) {
        a(localajc, i6, i12, i5, i10);
      }
      for (;;)
      {
        i2 = i5 + i10;
        i9 += 1;
        i1 = i6;
        break;
        a(localajc, i5, i10, i6, i12);
      }
      i = e();
      do
      {
        return;
      } while (i == e());
      j.println("The fields of some layout parameters were modified in between layout operations. Check the javadoc for GridLayout.LayoutParams#rowSpec.");
      c();
      break;
    }
  }
  
  public final int a(View paramView, boolean paramBoolean)
  {
    return b(paramView, paramBoolean, true) + b(paramView, paramBoolean, false);
  }
  
  public final int a(View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (ajc)paramView.getLayoutParams();
    int i1;
    if (paramBoolean1) {
      if (paramBoolean2) {
        i1 = leftMargin;
      }
    }
    while (i1 == Integer.MIN_VALUE) {
      if (!f)
      {
        return 0;
        i1 = rightMargin;
        continue;
        if (paramBoolean2) {
          i1 = topMargin;
        } else {
          i1 = bottomMargin;
        }
      }
      else
      {
        aiy localaiy;
        label95:
        boolean bool;
        if (paramBoolean1)
        {
          localObject = b;
          if (!paramBoolean1) {
            break label161;
          }
          localaiy = c;
          localObject = c;
          bool = paramBoolean2;
          if (paramBoolean1)
          {
            bool = paramBoolean2;
            if (b())
            {
              if (paramBoolean2) {
                break label170;
              }
              bool = true;
            }
          }
          label126:
          if (!bool) {
            break label176;
          }
          if (a == 0) {}
        }
        for (;;)
        {
          if (paramView.getClass() != amb.class) {
            break label185;
          }
          return 0;
          localObject = a;
          break;
          label161:
          localaiy = d;
          break label95;
          label170:
          bool = false;
          break label126;
          label176:
          localaiy.a();
        }
        label185:
        return h / 2;
      }
    }
    return i1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramLayoutParams instanceof ajc)) {
      return false;
    }
    paramLayoutParams = (ajc)paramLayoutParams;
    a(paramLayoutParams, true);
    a(paramLayoutParams, false);
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    f();
    paramInt3 -= paramInt1;
    int i1 = getPaddingLeft();
    int i2 = getPaddingTop();
    int i3 = getPaddingRight();
    paramInt1 = getPaddingBottom();
    c.c(paramInt3 - i1 - i3);
    d.c(paramInt4 - paramInt2 - i2 - paramInt1);
    int[] arrayOfInt1 = c.c();
    int[] arrayOfInt2 = d.c();
    paramInt4 = getChildCount();
    paramInt1 = 0;
    if (paramInt1 < paramInt4)
    {
      View localView = getChildAt(paramInt1);
      int i4;
      int i6;
      int i5;
      int i10;
      int i12;
      int i9;
      int i7;
      if (localView.getVisibility() != 8)
      {
        Object localObject2 = (ajc)localView.getLayoutParams();
        Object localObject1 = b;
        localObject2 = a;
        Object localObject3 = c;
        Object localObject4 = c;
        paramInt2 = arrayOfInt1[a];
        i4 = arrayOfInt2[a];
        i6 = arrayOfInt1[b];
        i5 = arrayOfInt2[b];
        i10 = i6 - paramInt2;
        i12 = i5 - i4;
        int i15 = b(localView, true);
        int i13 = b(localView, false);
        localObject1 = ((ajf)localObject1).a(true);
        localObject2 = ((ajf)localObject2).a(false);
        localObject3 = (aja)c.b().a(paramInt1);
        localObject4 = (aja)d.b().a(paramInt1);
        int i11 = ((aiv)localObject1).a(localView, i10 - ((aja)localObject3).a(true));
        i5 = ((aiv)localObject2).a(localView, i12 - ((aja)localObject4).a(true));
        int i8 = b(localView, true, true);
        i6 = b(localView, false, true);
        i9 = b(localView, true, false);
        i7 = b(localView, false, false);
        int i16 = i8 + i9;
        int i17 = i6 + i7;
        int i14 = ((aja)localObject3).a(this, localView, (aiv)localObject1, i15 + i16, true);
        i7 = ((aja)localObject4).a(this, localView, (aiv)localObject2, i13 + i17, false);
        i10 = ((aiv)localObject1).a(i15, i10 - i16);
        i12 = ((aiv)localObject2).a(i13, i12 - i17);
        paramInt2 = i14 + (paramInt2 + i11);
        if (b()) {
          break label525;
        }
        paramInt2 += i1 + i8;
      }
      for (;;)
      {
        i4 = i7 + (i2 + i4 + i5) + i6;
        if ((i10 != localView.getMeasuredWidth()) || (i12 != localView.getMeasuredHeight())) {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
        }
        localView.layout(paramInt2, i4, i10 + paramInt2, i12 + i4);
        paramInt1 += 1;
        break;
        label525:
        paramInt2 = paramInt3 - i10 - i3 - i9 - paramInt2;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    f();
    d();
    int i4 = getPaddingLeft() + getPaddingRight();
    int i3 = getPaddingTop() + getPaddingBottom();
    int i5 = a(paramInt1, -i4);
    int i6 = a(paramInt2, -i3);
    a(i5, i6, true);
    int i2;
    int i1;
    if (e == 0)
    {
      i2 = c.b(i5);
      a(i5, i6, false);
      i1 = d.b(i6);
    }
    for (;;)
    {
      i2 = Math.max(i2 + i4, getSuggestedMinimumWidth());
      i1 = Math.max(i1 + i3, getSuggestedMinimumHeight());
      setMeasuredDimension(rg.a(i2, paramInt1, 0), rg.a(i1, paramInt2, 0));
      return;
      i1 = d.b(i6);
      a(i5, i6, false);
      i2 = c.b(i5);
    }
  }
  
  public void requestLayout()
  {
    super.requestLayout();
    c();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */