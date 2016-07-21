import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class agj
{
  private static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
  private static agj b;
  private static final agl c = new agl();
  private static final int[] d = { ace.N, ace.L, ace.a };
  private static final int[] e = { ace.k, ace.n, ace.u, ace.m, ace.l, ace.t, ace.o, ace.p, ace.s, ace.r, ace.q, ace.v };
  private static final int[] f = { ace.K, ace.M, ace.i, ace.J };
  private static final int[] g = { ace.y, ace.g, ace.x };
  private static final int[] h = { ace.j, ace.I, ace.O, ace.E, ace.F, ace.z, ace.H, ace.G, ace.e, ace.b };
  private static final int[] i = { ace.c, ace.f };
  private WeakHashMap<Context, SparseArray<ColorStateList>> j;
  private ns<String, agm> k;
  private SparseArray<String> l;
  private final Object m = new Object();
  private final WeakHashMap<Context, nx<WeakReference<Drawable.ConstantState>>> n = new WeakHashMap(0);
  private TypedValue o;
  
  private static long a(TypedValue paramTypedValue)
  {
    return assetCookie << 32 | data;
  }
  
  public static agj a()
  {
    if (b == null)
    {
      agj localagj = new agj();
      b = localagj;
      int i1 = Build.VERSION.SDK_INT;
      if (i1 < 23)
      {
        localagj.a("vector", new agn());
        if (i1 >= 11) {
          localagj.a("animated-vector", new agk());
        }
      }
    }
    return b;
  }
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    PorterDuffColorFilter localPorterDuffColorFilter2 = (PorterDuffColorFilter)c.a(Integer.valueOf(agl.a(paramInt, paramMode)));
    PorterDuffColorFilter localPorterDuffColorFilter1 = localPorterDuffColorFilter2;
    if (localPorterDuffColorFilter2 == null)
    {
      localPorterDuffColorFilter1 = new PorterDuffColorFilter(paramInt, paramMode);
      c.a(Integer.valueOf(agl.a(paramInt, paramMode)), localPorterDuffColorFilter1);
    }
    return localPorterDuffColorFilter1;
  }
  
  private final Drawable a(Context paramContext, long paramLong)
  {
    nx localnx;
    synchronized (m)
    {
      localnx = (nx)n.get(paramContext);
      if (localnx == null) {
        return null;
      }
      Object localObject2 = (WeakReference)localnx.a(paramLong, null);
      if (localObject2 == null) {
        break label91;
      }
      localObject2 = (Drawable.ConstantState)((WeakReference)localObject2).get();
      if (localObject2 != null)
      {
        paramContext = ((Drawable.ConstantState)localObject2).newDrawable(paramContext.getResources());
        return paramContext;
      }
    }
    localnx.a(paramLong);
    label91:
    return null;
  }
  
  private static void a(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    Drawable localDrawable = paramDrawable;
    if (aij.c(paramDrawable)) {
      localDrawable = paramDrawable.mutate();
    }
    paramDrawable = paramMode;
    if (paramMode == null) {
      paramDrawable = a;
    }
    localDrawable.setColorFilter(a(paramInt, paramDrawable));
  }
  
  public static void a(Drawable paramDrawable, amn paramamn, int[] paramArrayOfInt)
  {
    Object localObject2 = null;
    if ((aij.c(paramDrawable)) && (paramDrawable.mutate() != paramDrawable)) {}
    label57:
    label73:
    label97:
    label104:
    label124:
    for (;;)
    {
      return;
      ColorStateList localColorStateList;
      Object localObject1;
      if ((d) || (c)) {
        if (d)
        {
          localColorStateList = a;
          if (!c) {
            break label97;
          }
          paramamn = b;
          localObject1 = localObject2;
          if (localColorStateList != null)
          {
            if (paramamn != null) {
              break label104;
            }
            localObject1 = localObject2;
          }
          paramDrawable.setColorFilter((ColorFilter)localObject1);
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT > 23) {
          break label124;
        }
        paramDrawable.invalidateSelf();
        return;
        localColorStateList = null;
        break;
        paramamn = a;
        break label57;
        localObject1 = a(localColorStateList.getColorForState(paramArrayOfInt, 0), paramamn);
        break label73;
        paramDrawable.clearColorFilter();
      }
    }
  }
  
  private final void a(String paramString, agm paramagm)
  {
    if (k == null) {
      k = new ns();
    }
    k.put(paramString, paramagm);
  }
  
  static boolean a(Context paramContext, int paramInt, Drawable paramDrawable)
  {
    PorterDuff.Mode localMode = a;
    int i1;
    int i2;
    if (a(d, paramInt))
    {
      i1 = aca.x;
      i2 = 1;
      paramInt = -1;
    }
    for (;;)
    {
      if (i2 != 0)
      {
        Drawable localDrawable = paramDrawable;
        if (aij.c(paramDrawable)) {
          localDrawable = paramDrawable.mutate();
        }
        localDrawable.setColorFilter(a(amj.a(paramContext, i1), localMode));
        if (paramInt != -1) {
          localDrawable.setAlpha(paramInt);
        }
        return true;
        if (a(f, paramInt))
        {
          i1 = aca.v;
          i2 = 1;
          paramInt = -1;
          continue;
        }
        if (a(g, paramInt))
        {
          localMode = PorterDuff.Mode.MULTIPLY;
          i2 = 1;
          i1 = 16842801;
          paramInt = -1;
          continue;
        }
        if (paramInt == ace.w)
        {
          i1 = 16842800;
          paramInt = Math.round(40.8F);
          i2 = 1;
        }
      }
      else
      {
        return false;
      }
      paramInt = -1;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private final boolean a(Context paramContext, long paramLong, Drawable paramDrawable)
  {
    Drawable.ConstantState localConstantState = paramDrawable.getConstantState();
    if (localConstantState != null) {
      synchronized (m)
      {
        nx localnx = (nx)n.get(paramContext);
        paramDrawable = localnx;
        if (localnx == null)
        {
          paramDrawable = new nx();
          n.put(paramContext, paramDrawable);
        }
        paramDrawable.b(paramLong, new WeakReference(localConstantState));
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int i2 = paramArrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < i2)
      {
        if (paramArrayOfInt[i1] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private static ColorStateList c(Context paramContext, int paramInt)
  {
    int i3 = amj.a(paramContext, aca.w);
    int[] arrayOfInt1 = amj.a;
    int i1 = amj.c(paramContext, aca.u);
    paramContext = amj.d;
    int i2 = km.a(i3, paramInt);
    int[] arrayOfInt2 = amj.b;
    i3 = km.a(i3, paramInt);
    return new ColorStateList(new int[][] { arrayOfInt1, paramContext, arrayOfInt2, amj.h }, new int[] { i1, i2, i3, paramInt });
  }
  
  final Drawable a(Context paramContext, int paramInt)
  {
    if ((k != null) && (!k.isEmpty()))
    {
      if (l != null)
      {
        localObject1 = (String)l.get(paramInt);
        if (("appcompat_skip_skip".equals(localObject1)) || ((localObject1 != null) && (k.get(localObject1) == null)))
        {
          localObject1 = null;
          return (Drawable)localObject1;
        }
      }
      else
      {
        l = new SparseArray();
      }
      if (o == null) {
        o = new TypedValue();
      }
      TypedValue localTypedValue = o;
      Object localObject1 = paramContext.getResources();
      ((Resources)localObject1).getValue(paramInt, localTypedValue, true);
      long l1 = a(localTypedValue);
      Drawable localDrawable = a(paramContext, l1);
      if (localDrawable != null) {
        return localDrawable;
      }
      Object localObject2 = localDrawable;
      XmlResourceParser localXmlResourceParser;
      AttributeSet localAttributeSet;
      if (string != null)
      {
        localObject2 = localDrawable;
        if (string.toString().endsWith(".xml"))
        {
          localObject2 = localDrawable;
          try
          {
            localXmlResourceParser = ((Resources)localObject1).getXml(paramInt);
            localObject2 = localDrawable;
            localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
            int i1;
            do
            {
              localObject2 = localDrawable;
              i1 = localXmlResourceParser.next();
            } while ((i1 != 2) && (i1 != 1));
            if (i1 != 2)
            {
              localObject2 = localDrawable;
              throw new XmlPullParserException("No start tag found");
            }
          }
          catch (Exception paramContext)
          {
            Log.e("AppCompatDrawableManager", "Exception while inflating drawable", paramContext);
          }
        }
      }
      for (paramContext = (Context)localObject2;; paramContext = (Context)localObject1)
      {
        localObject1 = paramContext;
        if (paramContext != null) {
          break;
        }
        l.append(paramInt, "appcompat_skip_skip");
        return paramContext;
        localObject2 = localDrawable;
        localObject1 = localXmlResourceParser.getName();
        localObject2 = localDrawable;
        l.append(paramInt, localObject1);
        localObject2 = localDrawable;
        agm localagm = (agm)k.get(localObject1);
        localObject1 = localDrawable;
        if (localagm != null)
        {
          localObject2 = localDrawable;
          localObject1 = localagm.a(paramContext, localXmlResourceParser, localAttributeSet, paramContext.getTheme());
        }
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          ((Drawable)localObject1).setChangingConfigurations(changingConfigurations);
          localObject2 = localObject1;
          a(paramContext, l1, (Drawable)localObject1);
        }
      }
    }
    return null;
  }
  
  public final Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    Object localObject2 = a(paramContext, paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (o == null) {
        o = new TypedValue();
      }
      TypedValue localTypedValue = o;
      paramContext.getResources().getValue(paramInt, localTypedValue, true);
      long l1 = a(localTypedValue);
      localObject2 = a(paramContext, l1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        if (paramInt == ace.h) {
          localObject2 = new LayerDrawable(new Drawable[] { a(paramContext, ace.g, false), a(paramContext, ace.i, false) });
        }
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Drawable)localObject2).setChangingConfigurations(changingConfigurations);
          a(paramContext, l1, (Drawable)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = jr.a(paramContext, paramInt);
    }
    localObject1 = localObject2;
    if (localObject2 != null) {
      localObject1 = a(paramContext, paramInt, paramBoolean, (Drawable)localObject2);
    }
    if (localObject1 != null) {
      aij.b((Drawable)localObject1);
    }
    return (Drawable)localObject1;
  }
  
  final Drawable a(Context paramContext, int paramInt, boolean paramBoolean, Drawable paramDrawable)
  {
    Object localObject = null;
    ColorStateList localColorStateList = b(paramContext, paramInt);
    if (localColorStateList != null)
    {
      paramContext = paramDrawable;
      if (aij.c(paramDrawable)) {
        paramContext = paramDrawable.mutate();
      }
      paramDrawable = kn.e(paramContext);
      kn.a(paramDrawable, localColorStateList);
      paramContext = (Context)localObject;
      if (paramInt == ace.G) {
        paramContext = PorterDuff.Mode.MULTIPLY;
      }
      localObject = paramDrawable;
      if (paramContext != null)
      {
        kn.a(paramDrawable, paramContext);
        localObject = paramDrawable;
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
        if (paramInt == ace.D)
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), amj.a(paramContext, aca.x), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), amj.a(paramContext, aca.x), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), amj.a(paramContext, aca.v), a);
          return paramDrawable;
        }
        if ((paramInt == ace.A) || (paramInt == ace.B))
        {
          localObject = (LayerDrawable)paramDrawable;
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908288), amj.c(paramContext, aca.x), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908303), amj.a(paramContext, aca.v), a);
          a(((LayerDrawable)localObject).findDrawableByLayerId(16908301), amj.a(paramContext, aca.v), a);
          return paramDrawable;
        }
        localObject = paramDrawable;
      } while (a(paramContext, paramInt, paramDrawable));
      localObject = paramDrawable;
    } while (!paramBoolean);
    return null;
  }
  
  public final ColorStateList b(Context paramContext, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int i1;
    int i2;
    Object localObject3;
    int i3;
    if (j != null)
    {
      localObject1 = (SparseArray)j.get(paramContext);
      if (localObject1 != null)
      {
        localObject1 = (ColorStateList)((SparseArray)localObject1).get(paramInt);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          if (paramInt != ace.j) {
            break label230;
          }
          localObject1 = amj.a;
          i1 = amj.c(paramContext, aca.x);
          localObject2 = amj.g;
          i2 = amj.a(paramContext, aca.x);
          localObject3 = amj.h;
          i3 = amj.a(paramContext, aca.v);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i1, i2, i3 });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (j == null) {
          j = new WeakHashMap();
        }
        localObject3 = (SparseArray)j.get(paramContext);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new SparseArray();
          j.put(paramContext, localObject2);
        }
        ((SparseArray)localObject2).append(paramInt, localObject1);
      }
      localObject2 = localObject1;
      return (ColorStateList)localObject2;
      localObject1 = null;
      break;
      localObject1 = null;
      break;
      label230:
      if (paramInt == ace.H)
      {
        localObject1 = amj.a;
        i1 = amj.a(paramContext, 16842800, 0.1F);
        localObject2 = amj.e;
        i2 = amj.a(paramContext, aca.v, 0.3F);
        localObject3 = amj.h;
        i3 = amj.a(paramContext, 16842800, 0.3F);
        localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i1, i2, i3 });
      }
      else
      {
        if (paramInt == ace.G)
        {
          localObject1 = new int[3][];
          localObject2 = new int[3];
          localObject3 = amj.b(paramContext, aca.y);
          if ((localObject3 != null) && (((ColorStateList)localObject3).isStateful()))
          {
            localObject1[0] = amj.a;
            localObject2[0] = ((ColorStateList)localObject3).getColorForState(localObject1[0], 0);
            localObject1[1] = amj.e;
            localObject2[1] = amj.a(paramContext, aca.v);
            localObject1[2] = amj.h;
            localObject2[2] = ((ColorStateList)localObject3).getDefaultColor();
          }
          for (;;)
          {
            localObject1 = new ColorStateList((int[][])localObject1, (int[])localObject2);
            break;
            localObject1[0] = amj.a;
            localObject2[0] = amj.c(paramContext, aca.y);
            localObject1[1] = amj.e;
            localObject2[1] = amj.a(paramContext, aca.v);
            localObject1[2] = amj.h;
            localObject2[2] = amj.a(paramContext, aca.y);
          }
        }
        if (paramInt == ace.e)
        {
          localObject1 = c(paramContext, amj.a(paramContext, aca.u));
        }
        else if (paramInt == ace.b)
        {
          localObject1 = c(paramContext, 0);
        }
        else if (paramInt == ace.d)
        {
          localObject1 = c(paramContext, amj.a(paramContext, aca.t));
        }
        else if ((paramInt == ace.E) || (paramInt == ace.F))
        {
          localObject1 = amj.a;
          i1 = amj.c(paramContext, aca.x);
          localObject2 = amj.g;
          i2 = amj.a(paramContext, aca.x);
          localObject3 = amj.h;
          i3 = amj.a(paramContext, aca.v);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i1, i2, i3 });
        }
        else if (a(e, paramInt))
        {
          localObject1 = amj.b(paramContext, aca.x);
        }
        else if (a(h, paramInt))
        {
          i1 = amj.a(paramContext, aca.x);
          i2 = amj.a(paramContext, aca.v);
          localObject1 = amj.a;
          i3 = amj.c(paramContext, aca.x);
          localObject1 = new ColorStateList(new int[][] { localObject1, amj.b, amj.c, amj.d, amj.e, amj.f, amj.h }, new int[] { i3, i2, i2, i2, i2, i2, i1 });
        }
        else if (a(i, paramInt))
        {
          localObject1 = amj.a;
          i1 = amj.c(paramContext, aca.x);
          localObject2 = amj.e;
          i2 = amj.a(paramContext, aca.v);
          localObject3 = amj.h;
          i3 = amj.a(paramContext, aca.x);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2, localObject3 }, new int[] { i1, i2, i3 });
        }
        else if (paramInt == ace.C)
        {
          localObject1 = amj.a;
          i1 = amj.c(paramContext, aca.v);
          localObject2 = amj.h;
          i2 = amj.a(paramContext, aca.v);
          localObject1 = new ColorStateList(new int[][] { localObject1, localObject2 }, new int[] { i1, i2 });
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     agj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */