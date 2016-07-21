import android.support.v7.widget.GridLayout;
import android.util.Printer;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class aiy
{
  public final boolean a;
  public int b = Integer.MIN_VALUE;
  aje<ajf, aja> c;
  public boolean d = false;
  aje<ajb, ajd> e;
  public boolean f = false;
  aje<ajb, ajd> g;
  public boolean h = false;
  public int[] i;
  public boolean j = false;
  public int[] k;
  public boolean l = false;
  public aiw[] m;
  public boolean n = false;
  public int[] o;
  public boolean p = false;
  public boolean q;
  public boolean r = false;
  public int[] s;
  boolean t = true;
  private int v = Integer.MIN_VALUE;
  private ajd w = new ajd(0);
  private ajd x = new ajd(-100000);
  
  public aiy(GridLayout paramGridLayout, boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  private final void a(int paramInt, float paramFloat)
  {
    Arrays.fill(s, 0);
    int i2 = u.getChildCount();
    int i1 = 0;
    Object localObject;
    if (i1 < i2)
    {
      localObject = u.getChildAt(i1);
      if (((View)localObject).getVisibility() == 8) {
        break label130;
      }
      localObject = GridLayout.a((View)localObject);
      if (a)
      {
        localObject = b;
        label69:
        float f1 = e;
        if (f1 == 0.0F) {
          break label130;
        }
        int i3 = Math.round(paramInt * f1 / paramFloat);
        s[i1] = i3;
        paramFloat -= f1;
        paramInt -= i3;
      }
    }
    label130:
    for (;;)
    {
      i1 += 1;
      break;
      localObject = a;
      break label69;
      return;
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    w.a = paramInt1;
    x.a = (-paramInt2);
    p = false;
  }
  
  private final void a(aje<ajb, ajd> paramaje, boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject = (ajd[])c;
    int i1 = 0;
    while (i1 < localObject.length)
    {
      a = Integer.MIN_VALUE;
      i1 += 1;
    }
    localObject = (aja[])bc;
    i1 = i2;
    if (i1 < localObject.length)
    {
      i2 = localObject[i1].a(paramBoolean);
      ajd localajd = (ajd)paramaje.a(i1);
      int i3 = a;
      if (paramBoolean) {}
      for (;;)
      {
        a = Math.max(i3, i2);
        i1 += 1;
        break;
        i2 = -i2;
      }
    }
  }
  
  private static void a(List<aiw> paramList, ajb paramajb, ajd paramajd)
  {
    a(paramList, paramajb, paramajd, true);
  }
  
  private static void a(List<aiw> paramList, ajb paramajb, ajd paramajd, boolean paramBoolean)
  {
    if (paramajb.a() == 0) {
      return;
    }
    if (paramBoolean)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        if (nexta.equals(paramajb)) {
          return;
        }
      }
    }
    paramList.add(new aiw(paramajb, paramajd));
  }
  
  private static void a(List<aiw> paramList, aje<ajb, ajd> paramaje)
  {
    int i1 = 0;
    while (i1 < ((ajb[])b).length)
    {
      a(paramList, ((ajb[])b)[i1], ((ajd[])c)[i1], false);
      i1 += 1;
    }
  }
  
  private final boolean a(int[] paramArrayOfInt)
  {
    return a(j(), paramArrayOfInt, true);
  }
  
  private static boolean a(int[] paramArrayOfInt, aiw paramaiw)
  {
    if (!c) {}
    int i2;
    int i1;
    do
    {
      return false;
      ajb localajb = a;
      i2 = a;
      i1 = b;
      int i3 = b.a;
      i2 = paramArrayOfInt[i2] + i3;
    } while (i2 <= paramArrayOfInt[i1]);
    paramArrayOfInt[i1] = i2;
    return true;
  }
  
  private final boolean a(aiw[] paramArrayOfaiw, int[] paramArrayOfInt, boolean paramBoolean)
  {
    boolean bool3 = false;
    int i5 = 0;
    if (a) {}
    int i6;
    Object localObject1;
    int i1;
    int i3;
    boolean bool1;
    for (String str = "horizontal";; str = "vertical")
    {
      i6 = a() + 1;
      localObject1 = null;
      i1 = 0;
      if (i1 >= paramArrayOfaiw.length) {
        break label412;
      }
      Arrays.fill(paramArrayOfInt, 0);
      i2 = 0;
      if (i2 >= i6) {
        break label261;
      }
      int i7 = paramArrayOfaiw.length;
      i3 = 0;
      bool1 = false;
      while (i3 < i7)
      {
        bool1 |= a(paramArrayOfInt, paramArrayOfaiw[i3]);
        i3 += 1;
      }
    }
    aiw localaiw;
    boolean bool2;
    if (!bool1)
    {
      if (localObject1 != null)
      {
        paramArrayOfInt = new ArrayList();
        localObject2 = new ArrayList();
        i1 = i5;
        while (i1 < paramArrayOfaiw.length)
        {
          localaiw = paramArrayOfaiw[i1];
          if (localObject1[i1] != 0) {
            paramArrayOfInt.add(localaiw);
          }
          if (!c) {
            ((List)localObject2).add(localaiw);
          }
          i1 += 1;
        }
        u.j.println(str + " constraints: " + b(paramArrayOfInt) + " are inconsistent; permanently removing: " + b((List)localObject2) + ". ");
      }
      bool2 = true;
    }
    label261:
    do
    {
      return bool2;
      i2 += 1;
      break;
      bool2 = bool3;
    } while (!paramBoolean);
    Object localObject2 = new boolean[paramArrayOfaiw.length];
    int i2 = 0;
    while (i2 < i6)
    {
      int i4 = paramArrayOfaiw.length;
      i3 = 0;
      while (i3 < i4)
      {
        localObject2[i3] |= a(paramArrayOfInt, paramArrayOfaiw[i3]);
        i3 += 1;
      }
      i2 += 1;
    }
    if (i1 == 0) {
      localObject1 = localObject2;
    }
    i2 = 0;
    for (;;)
    {
      if (i2 < paramArrayOfaiw.length)
      {
        if (localObject2[i2] != 0)
        {
          localaiw = paramArrayOfaiw[i2];
          if (a.a >= a.b) {
            c = false;
          }
        }
      }
      else
      {
        i1 += 1;
        break;
      }
      i2 += 1;
    }
    label412:
    return true;
  }
  
  private final aiw[] a(List<aiw> paramList)
  {
    paramList = new aiz(this, (aiw[])paramList.toArray(new aiw[paramList.size()]));
    int i1 = 0;
    int i2 = c.length;
    while (i1 < i2)
    {
      paramList.a(i1);
      i1 += 1;
    }
    return a;
  }
  
  private final int b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    return c()[a()];
  }
  
  private final String b(List<aiw> paramList)
  {
    String str;
    label34:
    label62:
    int i2;
    int i3;
    int i4;
    if (a)
    {
      str = "x";
      localObject = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      paramList = (List<aiw>)localObject;
      int i1 = 1;
      if (!localIterator.hasNext()) {
        break label226;
      }
      localObject = (aiw)localIterator.next();
      if (i1 == 0) {
        break label163;
      }
      i1 = 0;
      i2 = a.a;
      i3 = a.b;
      i4 = b.a;
      if (i2 >= i3) {
        break label174;
      }
    }
    label163:
    label174:
    for (Object localObject = str + i3 + "-" + str + i2 + ">=" + i4;; localObject = str + i2 + "-" + str + i3 + "<=" + -i4)
    {
      paramList.append((String)localObject);
      break label34;
      str = "y";
      break;
      paramList = paramList.append(", ");
      break label62;
    }
    label226:
    return paramList.toString();
  }
  
  private final aje<ajb, ajd> c(boolean paramBoolean)
  {
    aix localaix = aix.a(ajb.class, ajd.class);
    ajf[] arrayOfajf = (ajf[])bb;
    int i2 = arrayOfajf.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (paramBoolean) {}
      for (ajb localajb = c;; localajb = new ajb(b, a))
      {
        localaix.a(localajb, new ajd());
        i1 += 1;
        break;
        localajb = c;
      }
    }
    return localaix.a();
  }
  
  private final int f()
  {
    int i1;
    if (v == Integer.MIN_VALUE)
    {
      int i3 = u.getChildCount();
      int i2 = 0;
      i1 = -1;
      if (i2 < i3)
      {
        Object localObject = GridLayout.a(u.getChildAt(i2));
        if (a) {}
        for (localObject = b;; localObject = a)
        {
          localObject = c;
          i1 = Math.max(Math.max(Math.max(i1, a), b), ((ajb)localObject).a());
          i2 += 1;
          break;
        }
      }
      if (i1 != -1) {
        break label125;
      }
      i1 = Integer.MIN_VALUE;
    }
    label125:
    for (;;)
    {
      v = Math.max(0, i1);
      return v;
    }
  }
  
  private final aje<ajb, ajd> g()
  {
    if (e == null) {
      e = c(true);
    }
    if (!f)
    {
      a(e, true);
      f = true;
    }
    return e;
  }
  
  private final aje<ajb, ajd> h()
  {
    if (g == null) {
      g = c(false);
    }
    if (!h)
    {
      a(g, false);
      h = true;
    }
    return g;
  }
  
  private final void i()
  {
    g();
    h();
  }
  
  private final aiw[] j()
  {
    if (m == null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      a(localArrayList1, g());
      a(localArrayList2, h());
      if (t)
      {
        i1 = 0;
        while (i1 < a())
        {
          a(localArrayList1, new ajb(i1, i1 + 1), new ajd(0));
          i1 += 1;
        }
      }
      int i1 = a();
      a(localArrayList1, new ajb(0, i1), w, false);
      a(localArrayList2, new ajb(i1, 0), x, false);
      m = ((aiw[])GridLayout.a(a(localArrayList1), a(localArrayList2)));
    }
    if (!n)
    {
      i();
      n = true;
    }
    return m;
  }
  
  private final int[] k()
  {
    if (s == null) {
      s = new int[u.getChildCount()];
    }
    return s;
  }
  
  public final int a()
  {
    return Math.max(b, f());
  }
  
  public final void a(int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((paramInt != Integer.MIN_VALUE) && (paramInt < f()))
    {
      localStringBuilder = new StringBuilder();
      if (!a) {
        break label56;
      }
    }
    label56:
    for (String str = "column";; str = "row")
    {
      GridLayout.a(str + "Count must be greater than or equal to the maximum of all grid indices (and spans) defined in the LayoutParams of each child");
      b = paramInt;
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    t = paramBoolean;
    d();
  }
  
  final aiw[][] a(aiw[] paramArrayOfaiw)
  {
    int i2 = 0;
    int i1 = a() + 1;
    aiw[][] arrayOfaiw = new aiw[i1][];
    int[] arrayOfInt = new int[i1];
    int i3 = paramArrayOfaiw.length;
    i1 = 0;
    int i4;
    while (i1 < i3)
    {
      i4 = a.a;
      arrayOfInt[i4] += 1;
      i1 += 1;
    }
    i1 = 0;
    while (i1 < arrayOfInt.length)
    {
      arrayOfaiw[i1] = new aiw[arrayOfInt[i1]];
      i1 += 1;
    }
    Arrays.fill(arrayOfInt, 0);
    i3 = paramArrayOfaiw.length;
    i1 = i2;
    while (i1 < i3)
    {
      aiw localaiw = paramArrayOfaiw[i1];
      i2 = a.a;
      aiw[] arrayOfaiw1 = arrayOfaiw[i2];
      i4 = arrayOfInt[i2];
      arrayOfInt[i2] = (i4 + 1);
      arrayOfaiw1[i4] = localaiw;
      i1 += 1;
    }
    return arrayOfaiw;
  }
  
  public final int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    switch (i1)
    {
    default: 
      return 0;
    case 0: 
      return b(0, 100000);
    case 1073741824: 
      return b(paramInt, paramInt);
    }
    return b(0, paramInt);
  }
  
  public final aje<ajf, aja> b()
  {
    Object localObject2;
    int i2;
    int i1;
    Object localObject1;
    if (c == null)
    {
      localObject2 = aix.a(ajf.class, aja.class);
      i2 = u.getChildCount();
      i1 = 0;
      if (i1 < i2)
      {
        localObject1 = GridLayout.a(u.getChildAt(i1));
        if (a) {}
        for (localObject1 = b;; localObject1 = a)
        {
          ((aix)localObject2).a(localObject1, ((ajf)localObject1).a(a).b());
          i1 += 1;
          break;
        }
      }
      c = ((aix)localObject2).a();
    }
    if (!d)
    {
      localObject1 = (aja[])c.c;
      i1 = 0;
      while (i1 < localObject1.length)
      {
        localObject1[i1].a();
        i1 += 1;
      }
      int i4 = u.getChildCount();
      i1 = 0;
      if (i1 < i4)
      {
        localObject2 = u.getChildAt(i1);
        localObject1 = GridLayout.a((View)localObject2);
        label193:
        Object localObject3;
        boolean bool;
        label217:
        int i3;
        label229:
        GridLayout localGridLayout;
        int i5;
        if (a)
        {
          localObject1 = b;
          localObject3 = u;
          bool = a;
          if (((View)localObject2).getVisibility() != 8) {
            break label338;
          }
          i2 = 0;
          if (e != 0.0F) {
            break label361;
          }
          i3 = 0;
          i3 = i2 + i3;
          localObject3 = (aja)c.a(i1);
          localGridLayout = u;
          i5 = d;
          if ((d != GridLayout.k) || (e != 0.0F)) {
            break label371;
          }
        }
        label338:
        label361:
        label371:
        for (i2 = 0;; i2 = 2)
        {
          d = (i2 & i5);
          i2 = ((ajf)localObject1).a(a).a((View)localObject2, i3, sf.a(localGridLayout));
          ((aja)localObject3).a(i2, i3 - i2);
          i1 += 1;
          break;
          localObject1 = a;
          break label193;
          i2 = GridLayout.b((View)localObject2, bool);
          i2 = ((GridLayout)localObject3).a((View)localObject2, bool) + i2;
          break label217;
          i3 = k()[i1];
          break label229;
        }
      }
      d = true;
    }
    return c;
  }
  
  public final void b(boolean paramBoolean)
  {
    int[] arrayOfInt;
    int i1;
    label21:
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      arrayOfInt = i;
      int i3 = u.getChildCount();
      i1 = 0;
      if (i1 >= i3) {
        return;
      }
      localView = u.getChildAt(i1);
      if (localView.getVisibility() != 8)
      {
        localObject = GridLayout.a(localView);
        if (!a) {
          break label126;
        }
        localObject = b;
        label68:
        localObject = c;
        if (!paramBoolean) {
          break label136;
        }
      }
    }
    label126:
    label136:
    for (int i2 = a;; i2 = b)
    {
      arrayOfInt[i2] = Math.max(arrayOfInt[i2], u.a(localView, a, paramBoolean));
      i1 += 1;
      break label21;
      arrayOfInt = k;
      break;
      localObject = a;
      break label68;
    }
  }
  
  public final void c(int paramInt)
  {
    a(paramInt, paramInt);
    c();
  }
  
  public final int[] c()
  {
    float f1 = 0.0F;
    int i5 = 0;
    if (o == null) {
      o = new int[a() + 1];
    }
    int[] arrayOfInt;
    int i2;
    int i1;
    Object localObject;
    label100:
    boolean bool;
    label113:
    label138:
    int i3;
    if (!p)
    {
      arrayOfInt = o;
      if (!r)
      {
        i2 = u.getChildCount();
        i1 = 0;
        if (i1 >= i2) {
          break label198;
        }
        localObject = u.getChildAt(i1);
        if (((View)localObject).getVisibility() == 8) {
          break label191;
        }
        localObject = GridLayout.a((View)localObject);
        if (a)
        {
          localObject = b;
          if (e == 0.0F) {
            break label191;
          }
          bool = true;
          q = bool;
          r = true;
        }
      }
      else
      {
        if (q) {
          break label204;
        }
        a(arrayOfInt);
      }
      for (;;)
      {
        if (!t)
        {
          i2 = arrayOfInt[0];
          i3 = arrayOfInt.length;
          i1 = i5;
          for (;;)
          {
            if (i1 < i3)
            {
              arrayOfInt[i1] -= i2;
              i1 += 1;
              continue;
              localObject = a;
              break label100;
              label191:
              i1 += 1;
              break;
              label198:
              bool = false;
              break label113;
              label204:
              Arrays.fill(k(), 0);
              a(arrayOfInt);
              i2 = w.a * u.getChildCount() + 1;
              if (i2 < 2) {
                break label138;
              }
              i3 = u.getChildCount();
              i1 = 0;
              label253:
              if (i1 < i3)
              {
                localObject = u.getChildAt(i1);
                if (((View)localObject).getVisibility() == 8) {
                  break label444;
                }
                localObject = GridLayout.a((View)localObject);
                if (a)
                {
                  localObject = b;
                  label300:
                  f1 = e + f1;
                }
              }
            }
          }
        }
      }
    }
    label444:
    for (;;)
    {
      i1 += 1;
      break label253;
      localObject = a;
      break label300;
      int i4 = -1;
      i3 = 0;
      i1 = i2;
      bool = true;
      i2 = i4;
      while (i3 < i1)
      {
        i4 = (int)((i3 + i1) / 2L);
        e();
        a(i4, f1);
        bool = a(j(), arrayOfInt, false);
        if (bool)
        {
          i3 = i4 + 1;
          i2 = i4;
        }
        else
        {
          i1 = i4;
        }
      }
      if ((i2 <= 0) || (bool)) {
        break;
      }
      e();
      a(i2, f1);
      a(arrayOfInt);
      break;
      p = true;
      return o;
    }
  }
  
  public final void d()
  {
    v = Integer.MIN_VALUE;
    c = null;
    e = null;
    g = null;
    i = null;
    k = null;
    m = null;
    o = null;
    s = null;
    r = false;
    e();
  }
  
  public final void e()
  {
    d = false;
    f = false;
    h = false;
    j = false;
    l = false;
    n = false;
    p = false;
  }
}

/* Location:
 * Qualified Name:     aiy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */