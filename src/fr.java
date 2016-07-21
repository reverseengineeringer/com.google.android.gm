import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.BackStackState;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerState;
import android.support.v4.app.FragmentState;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class fr
  extends fq
  implements pz
{
  static final Interpolator A = new DecelerateInterpolator(2.5F);
  static final Interpolator B = new DecelerateInterpolator(1.5F);
  static final Interpolator C = new AccelerateInterpolator(2.5F);
  static final Interpolator D = new AccelerateInterpolator(1.5F);
  public static boolean a;
  static final boolean b;
  static Field r;
  ArrayList<Runnable> c;
  Runnable[] d;
  boolean e;
  public ArrayList<Fragment> f;
  ArrayList<Fragment> g;
  ArrayList<Integer> h;
  ArrayList<ev> i;
  ArrayList<Fragment> j;
  ArrayList<ev> k;
  ArrayList<Integer> l;
  ArrayList<Object> m;
  int n = 0;
  fp o;
  fn p;
  Fragment q;
  boolean s;
  public boolean t;
  boolean u;
  String v;
  boolean w;
  Bundle x = null;
  SparseArray<Parcelable> y = null;
  Runnable z = new fs(this);
  
  static
  {
    boolean bool = false;
    a = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    b = bool;
    r = null;
  }
  
  private final Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    if (i1 == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i1 >= f.size()) {
        a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i1));
      }
      localFragment = (Fragment)f.get(i1);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i1));
    return localFragment;
  }
  
  private static Animation a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(B);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }
  
  private static Animation a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(A);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(B);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  private final Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i1 = P;
    Fragment.m();
    if (P != 0)
    {
      paramFragment = AnimationUtils.loadAnimation(o.c, P);
      if (paramFragment != null) {
        return paramFragment;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    i1 = -1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i1;
    }
    while (paramInt1 < 0)
    {
      return null;
      if (paramBoolean)
      {
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 2;
        continue;
        if (paramBoolean)
        {
          paramInt1 = 3;
        }
        else
        {
          paramInt1 = 4;
          continue;
          if (paramBoolean) {
            paramInt1 = 5;
          } else {
            paramInt1 = 6;
          }
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (o.e()) {
          paramInt1 = o.f();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return a(1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return a(1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return a(0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return a(1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return a(0.0F, 1.0F);
    case 6: 
      return a(1.0F, 0.0F);
    }
    return null;
  }
  
  /* Error */
  private final void a(int paramInt, ev paramev)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 219	fr:k	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 114	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 220	java/util/ArrayList:<init>	()V
    //   17: putfield 219	fr:k	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 219	fr:k	Ljava/util/ArrayList;
    //   24: invokevirtual 118	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +45 -> 80
    //   38: getstatic 59	fr:a	Z
    //   41: ifeq +26 -> 67
    //   44: new 122	java/lang/StringBuilder
    //   47: dup
    //   48: ldc -34
    //   50: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_1
    //   54: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc -32
    //   59: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_2
    //   63: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: getfield 219	fr:k	Ljava/util/ArrayList;
    //   71: iload_1
    //   72: aload_2
    //   73: invokevirtual 231	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: iload_3
    //   81: iload_1
    //   82: if_icmpge +69 -> 151
    //   85: aload_0
    //   86: getfield 219	fr:k	Ljava/util/ArrayList;
    //   89: aconst_null
    //   90: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_0
    //   95: getfield 237	fr:l	Ljava/util/ArrayList;
    //   98: ifnonnull +14 -> 112
    //   101: aload_0
    //   102: new 114	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 220	java/util/ArrayList:<init>	()V
    //   109: putfield 237	fr:l	Ljava/util/ArrayList;
    //   112: getstatic 59	fr:a	Z
    //   115: ifeq +17 -> 132
    //   118: new 122	java/lang/StringBuilder
    //   121: dup
    //   122: ldc -17
    //   124: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: iload_3
    //   128: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_0
    //   133: getfield 237	fr:l	Ljava/util/ArrayList;
    //   136: iload_3
    //   137: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   143: pop
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -68 -> 80
    //   151: getstatic 59	fr:a	Z
    //   154: ifeq +26 -> 180
    //   157: new 122	java/lang/StringBuilder
    //   160: dup
    //   161: ldc -9
    //   163: invokespecial 127	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: iload_1
    //   167: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc -7
    //   172: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload_2
    //   176: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_0
    //   181: getfield 219	fr:k	Ljava/util/ArrayList;
    //   184: aload_2
    //   185: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   188: pop
    //   189: goto -112 -> 77
    //   192: astore_2
    //   193: aload_0
    //   194: monitorexit
    //   195: aload_2
    //   196: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	fr
    //   0	197	1	paramInt	int
    //   0	197	2	paramev	ev
    //   31	117	3	i1	int
    //   27	9	4	i2	int
    // Exception table:
    //   from	to	target	type
    //   2	20	192	finally
    //   20	29	192	finally
    //   38	67	192	finally
    //   67	77	192	finally
    //   77	79	192	finally
    //   85	112	192	finally
    //   112	132	192	finally
    //   132	144	192	finally
    //   151	180	192	finally
    //   180	189	192	finally
    //   193	195	192	finally
  }
  
  private final void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new nw("FragmentManager"));
    if (o != null) {}
    for (;;)
    {
      try
      {
        o.a("  ", localPrintWriter, new String[0]);
        throw paramRuntimeException;
      }
      catch (Exception localException1)
      {
        Log.e("FragmentManager", "Failed dumping state", localException1);
        continue;
      }
      try
      {
        a("  ", null, localException1, new String[0]);
      }
      catch (Exception localException2)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  static boolean a(View paramView, Animation paramAnimation)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = bool2;
      if (rg.f(paramView) == 0)
      {
        bool1 = bool2;
        if (rg.a.o(paramView))
        {
          if (!(paramAnimation instanceof AlphaAnimation)) {
            break label59;
          }
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
      return bool1;
      label59:
      if ((paramAnimation instanceof AnimationSet))
      {
        paramView = ((AnimationSet)paramAnimation).getAnimations();
        i1 = 0;
        for (;;)
        {
          if (i1 >= paramView.size()) {
            break label111;
          }
          if ((paramView.get(i1) instanceof AlphaAnimation))
          {
            i1 = 1;
            break;
          }
          i1 += 1;
        }
      }
      label111:
      i1 = 0;
    }
  }
  
  private final void b(Fragment paramFragment)
  {
    a(paramFragment, n, 0, 0, false);
  }
  
  private static void b(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {}
    while (!a(paramView, paramAnimation)) {
      return;
    }
    try
    {
      if (r == null)
      {
        localObject1 = Animation.class.getDeclaredField("mListener");
        r = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = (Animation.AnimationListener)r.get(paramAnimation);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Object localObject1;
        Log.e("FragmentManager", "No field with the name mListener is found in Animation class", localNoSuchFieldException);
        Object localObject2 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("FragmentManager", "Cannot access Animation's mListener field", localIllegalAccessException);
        Object localObject3 = null;
      }
    }
    paramAnimation.setAnimationListener(new fv(paramView, paramAnimation, (Animation.AnimationListener)localObject1));
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private final void c(Fragment paramFragment)
  {
    if (S == null) {
      return;
    }
    if (y == null) {
      y = new SparseArray();
    }
    for (;;)
    {
      S.saveHierarchyState(y);
      if (y.size() <= 0) {
        break;
      }
      o = y;
      y = null;
      return;
      y.clear();
    }
  }
  
  private final Fragment d(int paramInt)
  {
    int i1;
    Object localObject;
    if (g != null)
    {
      i1 = g.size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)g.get(i1);
        if ((localObject != null) && (F == paramInt)) {
          return (Fragment)localObject;
        }
        i1 -= 1;
      }
    }
    if (f != null)
    {
      i1 = f.size() - 1;
      for (;;)
      {
        if (i1 < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)f.get(i1);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (F == paramInt) {
            break;
          }
        }
        i1 -= 1;
      }
    }
    label112:
    return null;
  }
  
  private final void q()
  {
    if (t) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (v != null) {
      throw new IllegalStateException("Can not perform this action inside of " + v);
    }
  }
  
  public final int a(ev paramev)
  {
    try
    {
      if ((l == null) || (l.size() <= 0))
      {
        if (k == null) {
          k = new ArrayList();
        }
        i1 = k.size();
        if (a) {
          new StringBuilder("Setting back stack index ").append(i1).append(" to ").append(paramev);
        }
        k.add(paramev);
        return i1;
      }
      int i1 = ((Integer)l.remove(l.size() - 1)).intValue();
      if (a) {
        new StringBuilder("Adding back stack index ").append(i1).append(" with ").append(paramev);
      }
      k.set(i1, paramev);
      return i1;
    }
    finally {}
  }
  
  public final Fragment a(String paramString)
  {
    int i1;
    Object localObject;
    if ((g != null) && (paramString != null))
    {
      i1 = g.size() - 1;
      while (i1 >= 0)
      {
        localObject = (Fragment)g.get(i1);
        if ((localObject != null) && (paramString.equals(H))) {
          return (Fragment)localObject;
        }
        i1 -= 1;
      }
    }
    if ((f != null) && (paramString != null))
    {
      i1 = f.size() - 1;
      for (;;)
      {
        if (i1 < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)f.get(i1);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(H)) {
            break;
          }
        }
        i1 -= 1;
      }
    }
    label126:
    return null;
  }
  
  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, fy.a);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int i3 = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.b(o.c, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i1 = paramView.getId(); (i1 == -1) && (i3 == -1) && (str2 == null); i1 = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int i2;
      if (i3 != -1)
      {
        paramString = d(i3);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = a(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i1 != -1) {
            paramString = d(i1);
          }
        }
        if (a) {
          new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(i3)).append(" fname=").append(str1).append(" existing=").append(paramString);
        }
        if (paramString != null) {
          break label405;
        }
        paramView = Fragment.a(paramContext, str1);
        x = true;
        if (i3 == 0) {
          break label398;
        }
        i2 = i3;
        label280:
        F = i2;
        G = i1;
        H = str2;
        y = true;
        B = this;
        C = o;
        paramString = n;
        paramView.l();
        a(paramView, true);
        label331:
        if ((n > 0) || (!x)) {
          break label524;
        }
        a(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (R != null) {
          break label532;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label398:
        i2 = i1;
        break label280;
        label405:
        if (y) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i3) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i1) + " with another fragment for " + str1);
        }
        y = true;
        C = o;
        if (!L)
        {
          paramView = n;
          paramString.l();
        }
        paramView = paramString;
        break label331;
        label524:
        b(paramView);
      }
      label532:
      if (i3 != 0) {
        R.setId(i3);
      }
      if (R.getTag() == null) {
        R.setTag(str2);
      }
      return R;
    }
  }
  
  public final gd a()
  {
    return new ev(this);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt);
    }
    a(new ft(this, paramInt, 1), false);
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((o == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No host");
    }
    if ((!paramBoolean) && (n == paramInt1)) {}
    do
    {
      return;
      n = paramInt1;
    } while (f == null);
    int i1 = 0;
    boolean bool = false;
    label54:
    if (i1 < f.size())
    {
      Fragment localFragment = (Fragment)f.get(i1);
      if (localFragment == null) {
        break label169;
      }
      a(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (V == null) {
        break label169;
      }
      bool |= V.a();
    }
    label169:
    for (;;)
    {
      i1 += 1;
      break label54;
      if (!bool) {
        f();
      }
      if ((!s) || (o == null) || (n != 5)) {
        break;
      }
      o.d();
      s = false;
      return;
    }
  }
  
  public final void a(Configuration paramConfiguration)
  {
    if (g != null)
    {
      int i1 = 0;
      while (i1 < g.size())
      {
        Fragment localFragment = (Fragment)g.get(i1);
        if (localFragment != null)
        {
          localFragment.onConfigurationChanged(paramConfiguration);
          if (D != null) {
            D.a(paramConfiguration);
          }
        }
        i1 += 1;
      }
    }
  }
  
  final void a(Parcelable paramParcelable, List<Fragment> paramList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      FragmentManagerState localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (a != null)
      {
        FragmentState localFragmentState;
        if (paramList != null)
        {
          i1 = 0;
          while (i1 < paramList.size())
          {
            paramParcelable = (Fragment)paramList.get(i1);
            if (a) {
              new StringBuilder("restoreAllState: re-attaching retained ").append(paramParcelable);
            }
            localFragmentState = a[p];
            k = paramParcelable;
            o = null;
            A = 0;
            y = false;
            v = false;
            s = null;
            if (j != null)
            {
              j.setClassLoader(o.c.getClassLoader());
              o = j.getSparseParcelableArray("android:view_state");
              n = j;
            }
            i1 += 1;
          }
        }
        f = new ArrayList(a.length);
        if (h != null) {
          h.clear();
        }
        int i1 = 0;
        if (i1 < a.length)
        {
          localFragmentState = a[i1];
          Fragment localFragment;
          if (localFragmentState != null)
          {
            paramParcelable = o;
            localFragment = q;
            if (k != null)
            {
              paramParcelable = k;
              label249:
              if (a) {
                new StringBuilder("restoreAllState: active #").append(i1).append(": ").append(paramParcelable);
              }
              f.add(paramParcelable);
              k = null;
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            Context localContext = c;
            if (i != null) {
              i.setClassLoader(localContext.getClassLoader());
            }
            k = Fragment.a(localContext, a, i);
            if (j != null)
            {
              j.setClassLoader(localContext.getClassLoader());
              k.n = j;
            }
            k.a(b, localFragment);
            k.x = c;
            k.z = true;
            k.F = d;
            k.G = e;
            k.H = f;
            k.K = g;
            k.J = h;
            k.B = f;
            if (a) {
              new StringBuilder("Instantiated fragment ").append(k);
            }
            paramParcelable = k;
            break label249;
            f.add(null);
            if (h == null) {
              h = new ArrayList();
            }
            if (a) {
              new StringBuilder("restoreAllState: avail #").append(i1);
            }
            h.add(Integer.valueOf(i1));
          }
        }
        if (paramList != null)
        {
          i1 = 0;
          if (i1 < paramList.size())
          {
            paramParcelable = (Fragment)paramList.get(i1);
            if (t >= 0) {
              if (t >= f.size()) {
                break label667;
              }
            }
            for (s = ((Fragment)f.get(t));; s = null)
            {
              i1 += 1;
              break;
              label667:
              Log.w("FragmentManager", "Re-attaching retained fragment " + paramParcelable + " target no longer exists: " + t);
            }
          }
        }
        if (b != null)
        {
          g = new ArrayList(b.length);
          i1 = 0;
          while (i1 < b.length)
          {
            paramParcelable = (Fragment)f.get(b[i1]);
            if (paramParcelable == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + b[i1]));
            }
            v = true;
            if (a) {
              new StringBuilder("restoreAllState: added #").append(i1).append(": ").append(paramParcelable);
            }
            if (g.contains(paramParcelable)) {
              throw new IllegalStateException("Already added!");
            }
            g.add(paramParcelable);
            i1 += 1;
          }
        }
        g = null;
        if (c == null) {
          break;
        }
        i = new ArrayList(c.length);
        i1 = 0;
        while (i1 < c.length)
        {
          paramParcelable = c[i1].a(this);
          if (a)
          {
            new StringBuilder("restoreAllState: back stack #").append(i1).append(" (index ").append(p).append("): ").append(paramParcelable);
            paramParcelable.a("  ", new PrintWriter(new nw("FragmentManager")), false);
          }
          i.add(paramParcelable);
          if (p >= 0) {
            a(p, paramParcelable);
          }
          i1 += 1;
        }
      }
    }
    i = null;
  }
  
  final void a(Fragment paramFragment)
  {
    if (p >= 0) {}
    for (;;)
    {
      return;
      if ((h == null) || (h.size() <= 0))
      {
        if (f == null) {
          f = new ArrayList();
        }
        paramFragment.a(f.size(), q);
        f.add(paramFragment);
      }
      while (a)
      {
        new StringBuilder("Allocated fragment index ").append(paramFragment);
        return;
        paramFragment.a(((Integer)h.remove(h.size() - 1)).intValue(), q);
        f.set(p, paramFragment);
      }
    }
  }
  
  public final void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      new StringBuilder("remove: ").append(paramFragment).append(" nesting=").append(A);
    }
    if (A > 0)
    {
      i1 = 1;
      if (i1 != 0) {
        break label134;
      }
      i1 = 1;
      label52:
      if ((!J) || (i1 != 0))
      {
        if (g != null) {
          g.remove(paramFragment);
        }
        if ((M) && (N)) {
          s = true;
        }
        v = false;
        w = true;
        if (i1 == 0) {
          break label140;
        }
      }
    }
    label134:
    label140:
    for (int i1 = 0;; i1 = 1)
    {
      a(paramFragment, i1, paramInt1, paramInt2, false);
      return;
      i1 = 0;
      break;
      i1 = 0;
      break label52;
    }
  }
  
  final void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i1;
    if (v)
    {
      i1 = paramInt1;
      if (!J) {}
    }
    else
    {
      i1 = paramInt1;
      if (paramInt1 > 1) {
        i1 = 1;
      }
    }
    int i2 = i1;
    if (w)
    {
      i2 = i1;
      if (i1 > k) {
        i2 = k;
      }
    }
    paramInt1 = i2;
    if (T)
    {
      paramInt1 = i2;
      if (k < 4)
      {
        paramInt1 = i2;
        if (i2 > 3) {
          paramInt1 = 3;
        }
      }
    }
    int i3;
    label514:
    label526:
    Object localObject2;
    if (k < paramInt1)
    {
      if ((x) && (!y)) {}
      do
      {
        return;
        if (l != null)
        {
          l = null;
          a(paramFragment, m, 0, 0, true);
        }
        i1 = paramInt1;
        i3 = paramInt1;
        i2 = paramInt1;
        switch (k)
        {
        default: 
          i1 = paramInt1;
        }
      } while (k == i1);
      Log.w("FragmentManager", "moveToState: Fragment state for " + paramFragment + " not updated inline; expected state " + i1 + " found " + k);
      k = i1;
      return;
      if (a) {
        new StringBuilder("moveto CREATED: ").append(paramFragment);
      }
      i2 = paramInt1;
      if (n != null)
      {
        n.setClassLoader(o.c.getClassLoader());
        o = n.getSparseParcelableArray("android:view_state");
        s = a(n, "android:target_state");
        if (s != null) {
          u = n.getInt("android:target_req_state", 0);
        }
        U = n.getBoolean("android:user_visible_hint", true);
        i2 = paramInt1;
        if (!U)
        {
          T = true;
          i2 = paramInt1;
          if (paramInt1 > 3) {
            i2 = 3;
          }
        }
      }
      C = o;
      E = q;
      if (q != null)
      {
        localObject1 = q.D;
        B = ((fr)localObject1);
        O = false;
        O = true;
        if (C != null) {
          break label514;
        }
      }
      for (localObject1 = null;; localObject1 = C.b)
      {
        if (localObject1 != null)
        {
          O = false;
          paramFragment.a((Activity)localObject1);
        }
        if (O) {
          break label526;
        }
        throw new jf("Fragment " + paramFragment + " did not call through to super.onAttach()");
        localObject1 = o.f;
        break;
      }
      localObject1 = E;
      if (!L)
      {
        localObject1 = n;
        if (D != null) {
          D.t = false;
        }
        k = 1;
        O = false;
        paramFragment.a((Bundle)localObject1);
        if (!O) {
          throw new jf("Fragment " + paramFragment + " did not call through to super.onCreate()");
        }
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getParcelable("android:support:fragments");
          if (localObject1 != null)
          {
            if (D == null) {
              paramFragment.r();
            }
            D.a((Parcelable)localObject1, null);
            D.j();
          }
        }
      }
      L = false;
      i1 = i2;
      if (x)
      {
        localObject1 = paramFragment.b(n);
        localObject2 = n;
        R = paramFragment.b((LayoutInflater)localObject1, null);
        if (R == null) {
          break label1151;
        }
        S = R;
        if (Build.VERSION.SDK_INT >= 11)
        {
          rg.v(R);
          if (I) {
            R.setVisibility(8);
          }
          localObject1 = R;
          localObject1 = n;
          Fragment.n();
          i1 = i2;
        }
      }
      else
      {
        label770:
        i3 = i1;
        if (i1 <= 1) {
          break label1292;
        }
        if (a) {
          new StringBuilder("moveto ACTIVITY_CREATED: ").append(paramFragment);
        }
        if (!x)
        {
          if (G == 0) {
            break label2483;
          }
          localObject2 = (ViewGroup)p.a(G);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (!z) {
              a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(G) + " (" + paramFragment.g().getResourceName(G) + ") for fragment " + paramFragment));
            }
          }
        }
      }
    }
    label983:
    label1151:
    label1185:
    label1292:
    label1634:
    label2155:
    label2477:
    label2483:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      Q = ((ViewGroup)localObject1);
      localObject2 = paramFragment.b(n);
      Bundle localBundle = n;
      R = paramFragment.b((LayoutInflater)localObject2, (ViewGroup)localObject1);
      if (R != null)
      {
        S = R;
        if (Build.VERSION.SDK_INT >= 11)
        {
          rg.v(R);
          if (localObject1 != null)
          {
            localObject2 = a(paramFragment, paramInt2, true, paramInt3);
            if (localObject2 != null)
            {
              b(R, (Animation)localObject2);
              R.startAnimation((Animation)localObject2);
            }
            ((ViewGroup)localObject1).addView(R);
          }
          if (I) {
            R.setVisibility(8);
          }
          localObject1 = R;
          localObject1 = n;
          Fragment.n();
        }
      }
      for (;;)
      {
        localObject1 = n;
        if (D != null) {
          D.t = false;
        }
        k = 2;
        O = false;
        paramFragment.c((Bundle)localObject1);
        if (O) {
          break label1185;
        }
        throw new jf("Fragment " + paramFragment + " did not call through to super.onActivityCreated()");
        R = gw.a(R);
        break;
        S = null;
        i1 = i2;
        break label770;
        R = gw.a(R);
        break label983;
        S = null;
      }
      if (D != null) {
        D.k();
      }
      if (R != null)
      {
        localObject1 = n;
        if (o != null)
        {
          S.restoreHierarchyState(o);
          o = null;
        }
        O = false;
        O = true;
        if (!O) {
          throw new jf("Fragment " + paramFragment + " did not call through to super.onViewStateRestored()");
        }
      }
      n = null;
      i3 = i1;
      i2 = i3;
      if (i3 > 3)
      {
        if (a) {
          new StringBuilder("moveto STARTED: ").append(paramFragment);
        }
        if (D != null)
        {
          D.t = false;
          D.g();
        }
        k = 4;
        O = false;
        paramFragment.n_();
        if (!O) {
          throw new jf("Fragment " + paramFragment + " did not call through to super.onStart()");
        }
        if (D != null) {
          D.l();
        }
        i2 = i3;
        if (V != null)
        {
          V.f();
          i2 = i3;
        }
      }
      i1 = i2;
      if (i2 <= 4) {
        break;
      }
      if (a) {
        new StringBuilder("moveto RESUMED: ").append(paramFragment);
      }
      if (D != null)
      {
        D.t = false;
        D.g();
      }
      k = 5;
      O = false;
      paramFragment.o();
      if (!O) {
        throw new jf("Fragment " + paramFragment + " did not call through to super.onResume()");
      }
      if (D != null)
      {
        D.m();
        D.g();
      }
      n = null;
      o = null;
      i1 = i2;
      break;
      i1 = paramInt1;
      if (k <= paramInt1) {
        break;
      }
      switch (k)
      {
      default: 
        i1 = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          i1 = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if ((u) && (l != null))
          {
            localObject1 = l;
            l = null;
            ((View)localObject1).clearAnimation();
          }
          if (l == null) {
            break label2155;
          }
          m = paramInt1;
          i1 = 1;
          break;
          if (paramInt1 < 5)
          {
            if (a) {
              new StringBuilder("movefrom RESUMED: ").append(paramFragment);
            }
            if (D != null) {
              D.b(4);
            }
            k = 4;
            O = false;
            paramFragment.p();
            if (!O) {
              throw new jf("Fragment " + paramFragment + " did not call through to super.onPause()");
            }
          }
          if (paramInt1 < 4)
          {
            if (a) {
              new StringBuilder("movefrom STARTED: ").append(paramFragment);
            }
            if (D != null) {
              D.n();
            }
            k = 3;
            O = false;
            paramFragment.d();
            if (!O) {
              throw new jf("Fragment " + paramFragment + " did not call through to super.onStop()");
            }
          }
          if (paramInt1 < 3)
          {
            if (a) {
              new StringBuilder("movefrom STOPPED: ").append(paramFragment);
            }
            paramFragment.s();
          }
        } while (paramInt1 >= 2);
        if (a) {
          new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
        }
        if ((R != null) && (o.b()) && (o == null)) {
          c(paramFragment);
        }
        if (D != null) {
          D.b(1);
        }
        k = 1;
        O = false;
        paramFragment.e();
        if (!O) {
          throw new jf("Fragment " + paramFragment + " did not call through to super.onDestroyView()");
        }
        if (V != null) {
          V.e();
        }
        if ((R != null) && (Q != null)) {
          if ((n <= 0) || (u)) {
            break label2477;
          }
        }
        for (localObject1 = a(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            l = R;
            m = paramInt1;
            ((Animation)localObject1).setAnimationListener(new fu(this, R, (Animation)localObject1, paramFragment));
            R.startAnimation((Animation)localObject1);
          }
          Q.removeView(R);
          Q = null;
          R = null;
          S = null;
          break label1634;
          if (a) {
            new StringBuilder("movefrom CREATED: ").append(paramFragment);
          }
          if (!L) {
            paramFragment.t();
          }
          for (;;)
          {
            O = false;
            paramFragment.a();
            if (O) {
              break;
            }
            throw new jf("Fragment " + paramFragment + " did not call through to super.onDetach()");
            k = 0;
          }
          i1 = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!L)
          {
            i1 = paramInt1;
            if (p < 0) {
              break;
            }
            if (a) {
              new StringBuilder("Freeing fragment index ").append(paramFragment);
            }
            f.set(p, null);
            if (h == null) {
              h = new ArrayList();
            }
            h.add(Integer.valueOf(p));
            o.a(q);
            p = -1;
            q = null;
            v = false;
            w = false;
            x = false;
            y = false;
            z = false;
            A = 0;
            B = null;
            D = null;
            C = null;
            F = 0;
            G = 0;
            H = null;
            I = false;
            J = false;
            L = false;
            V = null;
            W = false;
            X = false;
            i1 = paramInt1;
            break;
          }
          C = null;
          E = null;
          B = null;
          D = null;
          i1 = paramInt1;
          break;
        }
      }
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (g == null) {
      g = new ArrayList();
    }
    if (a) {
      new StringBuilder("add: ").append(paramFragment);
    }
    a(paramFragment);
    if (!J)
    {
      if (g.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      g.add(paramFragment);
      v = true;
      w = false;
      if ((M) && (N)) {
        s = true;
      }
      if (paramBoolean) {
        b(paramFragment);
      }
    }
  }
  
  public final void a(fp paramfp, fn paramfn, Fragment paramFragment)
  {
    if (o != null) {
      throw new IllegalStateException("Already attached");
    }
    o = paramfp;
    p = paramfn;
    q = paramFragment;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      q();
    }
    try
    {
      if ((u) || (o == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramRunnable;
      if (c == null) {
        c = new ArrayList();
      }
      c.add(paramRunnable);
      if (c.size() == 1) {
        o.d.removeCallbacks(z);
      }
    }
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i2 = 0;
    String str = paramString + "    ";
    int i3;
    int i1;
    if (f != null)
    {
      i3 = f.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i1 = 0;
        while (i1 < i3)
        {
          Fragment localFragment = (Fragment)f.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i1 += 1;
        }
      }
    }
    if (g != null)
    {
      i3 = g.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i1 = 0;
        while (i1 < i3)
        {
          paramFileDescriptor = (Fragment)g.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i1 += 1;
        }
      }
    }
    if (j != null)
    {
      i3 = j.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i1 = 0;
        while (i1 < i3)
        {
          paramFileDescriptor = (Fragment)j.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i1 += 1;
        }
      }
    }
    if (i != null)
    {
      i3 = i.size();
      if (i3 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i1 = 0;
        while (i1 < i3)
        {
          paramFileDescriptor = (ev)i.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a(str, paramPrintWriter);
          i1 += 1;
        }
      }
    }
    try
    {
      if (k != null)
      {
        i3 = k.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i1 = 0;
          while (i1 < i3)
          {
            paramFileDescriptor = (ev)k.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      if ((l != null) && (l.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(l.toArray()));
      }
      if (c != null)
      {
        i3 = c.size();
        if (i3 > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i1 = i2;
          while (i1 < i3)
          {
            paramFileDescriptor = (Runnable)c.get(i1);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i1);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i1 += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(o);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(p);
    if (q != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(q);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(n);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(t);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(u);
    if (s)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(s);
    }
    if (v != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(v);
    }
    if ((h != null) && (h.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(h.toArray()));
    }
  }
  
  final boolean a(int paramInt1, int paramInt2)
  {
    if (i == null) {}
    int i1;
    do
    {
      int i2;
      do
      {
        do
        {
          return false;
          if ((paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
            break;
          }
          paramInt1 = i.size() - 1;
        } while (paramInt1 < 0);
        localObject1 = (ev)i.remove(paramInt1);
        localObject2 = new SparseArray();
        localSparseArray1 = new SparseArray();
        ((ev)localObject1).a((SparseArray)localObject2, localSparseArray1);
        ((ev)localObject1).a(true, null, (SparseArray)localObject2, localSparseArray1);
        h();
        return true;
        i1 = -1;
        if (paramInt1 < 0) {
          break;
        }
        i2 = i.size() - 1;
        while (i2 >= 0)
        {
          localObject1 = (ev)i.get(i2);
          if ((paramInt1 >= 0) && (paramInt1 == p)) {
            break;
          }
          i2 -= 1;
        }
      } while (i2 < 0);
      i1 = i2;
      if ((paramInt2 & 0x1) != 0)
      {
        paramInt2 = i2 - 1;
        for (;;)
        {
          i1 = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject1 = (ev)i.get(paramInt2);
          i1 = paramInt2;
          if (paramInt1 < 0) {
            break;
          }
          i1 = paramInt2;
          if (paramInt1 != p) {
            break;
          }
          paramInt2 -= 1;
        }
      }
    } while (i1 == i.size() - 1);
    Object localObject2 = new ArrayList();
    paramInt1 = i.size() - 1;
    while (paramInt1 > i1)
    {
      ((ArrayList)localObject2).add(i.remove(paramInt1));
      paramInt1 -= 1;
    }
    paramInt2 = ((ArrayList)localObject2).size() - 1;
    SparseArray localSparseArray1 = new SparseArray();
    SparseArray localSparseArray2 = new SparseArray();
    paramInt1 = 0;
    while (paramInt1 <= paramInt2)
    {
      ((ev)((ArrayList)localObject2).get(paramInt1)).a(localSparseArray1, localSparseArray2);
      paramInt1 += 1;
    }
    Object localObject1 = null;
    paramInt1 = 0;
    label330:
    ev localev;
    if (paramInt1 <= paramInt2)
    {
      if (a) {
        new StringBuilder("Popping back stack state: ").append(((ArrayList)localObject2).get(paramInt1));
      }
      localev = (ev)((ArrayList)localObject2).get(paramInt1);
      if (paramInt1 != paramInt2) {
        break label402;
      }
    }
    label402:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = localev.a(bool, (fa)localObject1, localSparseArray1, localSparseArray2);
      paramInt1 += 1;
      break label330;
      break;
    }
  }
  
  public final boolean a(Menu paramMenu)
  {
    int i1;
    boolean bool3;
    boolean bool4;
    Fragment localFragment;
    boolean bool1;
    if (g != null)
    {
      i1 = 0;
      bool3 = false;
      bool4 = bool3;
      if (i1 >= g.size()) {
        break label127;
      }
      localFragment = (Fragment)g.get(i1);
      bool4 = bool3;
      if (localFragment != null)
      {
        if (I) {
          break label135;
        }
        if ((!M) || (!N)) {
          break label130;
        }
        bool1 = true;
        label78:
        bool2 = bool1;
        if (D == null) {}
      }
    }
    label127:
    label130:
    label135:
    for (boolean bool2 = bool1 | D.a(paramMenu);; bool2 = false)
    {
      bool4 = bool3;
      if (bool2) {
        bool4 = true;
      }
      i1 += 1;
      bool3 = bool4;
      break;
      bool4 = false;
      return bool4;
      bool1 = false;
      break label78;
    }
  }
  
  public final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i4 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int i3;
    boolean bool2;
    boolean bool3;
    Fragment localFragment;
    int i1;
    if (g != null)
    {
      i3 = 0;
      bool2 = false;
      localObject2 = localObject1;
      bool3 = bool2;
      if (i3 >= g.size()) {
        break label162;
      }
      localFragment = (Fragment)g.get(i3);
      if (localFragment == null) {
        break label228;
      }
      if (I) {
        break label236;
      }
      if ((!M) || (!N)) {
        break label231;
      }
      i1 = 1;
      label87:
      int i2 = i1;
      if (D == null) {}
    }
    label162:
    label228:
    label231:
    label236:
    for (boolean bool1 = i1 | D.a(paramMenu, paramMenuInflater);; bool1 = false)
    {
      if (bool1)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool2 = true;
        localObject1 = localObject2;
      }
      for (;;)
      {
        i3 += 1;
        break;
        bool3 = false;
        if (j != null)
        {
          i1 = i4;
          while (i1 < j.size())
          {
            paramMenu = (Fragment)j.get(i1);
            if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
              Fragment.q();
            }
            i1 += 1;
          }
        }
        j = ((ArrayList)localObject2);
        return bool3;
      }
      i1 = 0;
      break label87;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (g != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < g.size())
      {
        Fragment localFragment = (Fragment)g.get(i1);
        if (localFragment == null) {
          break label94;
        }
        if ((I) || (D == null) || (!D.a(paramMenuItem))) {
          break label89;
        }
      }
      label89:
      for (int i2 = 1; i2 != 0; i2 = 0)
      {
        bool1 = true;
        return bool1;
      }
      label94:
      i1 += 1;
    }
  }
  
  public final Fragment b(String paramString)
  {
    if ((f != null) && (paramString != null))
    {
      int i1 = f.size() - 1;
      while (i1 >= 0)
      {
        Fragment localFragment = (Fragment)f.get(i1);
        if (localFragment != null)
        {
          if (paramString.equals(q)) {}
          while (localFragment != null)
          {
            return localFragment;
            if (D != null) {
              localFragment = D.b(paramString);
            } else {
              localFragment = null;
            }
          }
        }
        i1 -= 1;
      }
    }
    return null;
  }
  
  public final void b(int paramInt)
  {
    a(paramInt, 0, 0, false);
  }
  
  public final void b(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!I)
    {
      I = true;
      if (R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null)
        {
          b(R, localAnimation);
          R.startAnimation(localAnimation);
        }
        R.setVisibility(8);
      }
      if ((v) && (M) && (N)) {
        s = true;
      }
      Fragment.i();
    }
  }
  
  public final void b(Menu paramMenu)
  {
    if (g != null)
    {
      int i1 = 0;
      while (i1 < g.size())
      {
        Fragment localFragment = (Fragment)g.get(i1);
        if ((localFragment != null) && (!I) && (D != null)) {
          D.b(paramMenu);
        }
        i1 += 1;
      }
    }
  }
  
  public final boolean b()
  {
    return g();
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    if (g != null) {
      i1 = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < g.size())
      {
        Fragment localFragment = (Fragment)g.get(i1);
        if (localFragment == null) {
          break label94;
        }
        if ((I) || (D == null) || (!D.b(paramMenuItem))) {
          break label89;
        }
      }
      label89:
      for (int i2 = 1; i2 != 0; i2 = 0)
      {
        bool1 = true;
        return bool1;
      }
      label94:
      i1 += 1;
    }
  }
  
  public final void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      new StringBuilder("show: ").append(paramFragment);
    }
    if (I)
    {
      I = false;
      if (R != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
        {
          b(R, localAnimation);
          R.startAnimation(localAnimation);
        }
        R.setVisibility(0);
      }
      if ((v) && (M) && (N)) {
        s = true;
      }
      Fragment.i();
    }
  }
  
  public final boolean c()
  {
    q();
    g();
    return a(-1, 0);
  }
  
  public final List<Fragment> d()
  {
    return f;
  }
  
  public final void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!J)
    {
      J = true;
      if (v)
      {
        if (g != null)
        {
          if (a) {
            new StringBuilder("remove from detach: ").append(paramFragment);
          }
          g.remove(paramFragment);
        }
        if ((M) && (N)) {
          s = true;
        }
        v = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final void e(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (a) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (J)
    {
      J = false;
      if (!v)
      {
        if (g == null) {
          g = new ArrayList();
        }
        if (g.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (a) {
          new StringBuilder("add from attach: ").append(paramFragment);
        }
        g.add(paramFragment);
        v = true;
        if ((M) && (N)) {
          s = true;
        }
        a(paramFragment, n, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final boolean e()
  {
    return u;
  }
  
  final void f()
  {
    if (f == null) {
      return;
    }
    int i1 = 0;
    label10:
    Fragment localFragment;
    if (i1 < f.size())
    {
      localFragment = (Fragment)f.get(i1);
      if ((localFragment != null) && (T))
      {
        if (!e) {
          break label63;
        }
        w = true;
      }
    }
    for (;;)
    {
      i1 += 1;
      break label10;
      break;
      label63:
      T = false;
      a(localFragment, n, 0, 0, false);
    }
  }
  
  public final boolean g()
  {
    if (e) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != o.d.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    int i2;
    for (boolean bool = false;; bool = true) {
      try
      {
        if ((c == null) || (c.size() == 0))
        {
          if (!w) {
            break label276;
          }
          i1 = 0;
          int i4;
          for (i2 = 0; i1 < f.size(); i2 = i4)
          {
            Fragment localFragment = (Fragment)f.get(i1);
            int i3 = i2;
            if (localFragment != null)
            {
              i3 = i2;
              if (V != null) {
                i4 = i2 | V.a();
              }
            }
            i1 += 1;
          }
        }
        i2 = c.size();
        if ((d == null) || (d.length < i2)) {
          d = new Runnable[i2];
        }
        c.toArray(d);
        c.clear();
        o.d.removeCallbacks(z);
        e = true;
        int i1 = 0;
        while (i1 < i2)
        {
          d[i1].run();
          d[i1] = null;
          i1 += 1;
        }
        e = false;
      }
      finally {}
    }
    if (i2 == 0)
    {
      w = false;
      f();
    }
    label276:
    return bool;
  }
  
  final void h()
  {
    if (m != null)
    {
      int i1 = 0;
      while (i1 < m.size())
      {
        m.get(i1);
        i1 += 1;
      }
    }
  }
  
  public final Parcelable i()
  {
    Object localObject3 = null;
    g();
    if (b) {
      t = true;
    }
    if ((f == null) || (f.size() <= 0)) {
      return null;
    }
    int i3 = f.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[i3];
    int i2 = 0;
    int i1 = 0;
    label56:
    Fragment localFragment;
    FragmentState localFragmentState;
    Object localObject2;
    label211:
    Object localObject1;
    if (i2 < i3)
    {
      localFragment = (Fragment)f.get(i2);
      if (localFragment == null) {
        break label862;
      }
      if (p < 0) {
        a(new IllegalStateException("Failure saving state: active " + localFragment + " has cleared index: " + p));
      }
      localFragmentState = new FragmentState(localFragment);
      arrayOfFragmentState[i2] = localFragmentState;
      if ((k > 0) && (j == null))
      {
        if (x == null) {
          x = new Bundle();
        }
        localFragment.e(x);
        if (x.isEmpty()) {
          break label856;
        }
        localObject2 = x;
        x = null;
        if (R != null) {
          c(localFragment);
        }
        localObject1 = localObject2;
        if (o != null)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          ((Bundle)localObject1).putSparseParcelableArray("android:view_state", o);
        }
        localObject2 = localObject1;
        if (!U)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new Bundle();
          }
          ((Bundle)localObject2).putBoolean("android:user_visible_hint", U);
        }
        j = ((Bundle)localObject2);
        if (s != null)
        {
          if (s.p < 0) {
            a(new IllegalStateException("Failure saving state: " + localFragment + " has target not in fragment manager: " + s));
          }
          if (j == null) {
            j = new Bundle();
          }
          localObject1 = j;
          localObject2 = s;
          if (p < 0) {
            a(new IllegalStateException("Fragment " + localObject2 + " is not currently in the FragmentManager"));
          }
          ((Bundle)localObject1).putInt("android:target_state", p);
          if (u != 0) {
            j.putInt("android:target_req_state", u);
          }
        }
        label494:
        if (a) {
          new StringBuilder("Saved state of ").append(localFragment).append(": ").append(j);
        }
        i1 = 1;
      }
    }
    label856:
    label862:
    for (;;)
    {
      i2 += 1;
      break label56;
      j = n;
      break label494;
      if (i1 == 0) {
        break;
      }
      if (g != null)
      {
        i2 = g.size();
        if (i2 > 0)
        {
          localObject2 = new int[i2];
          i1 = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i1 >= i2) {
              break;
            }
            localObject2[i1] = g.get(i1)).p;
            if (localObject2[i1] < 0) {
              a(new IllegalStateException("Failure saving state: active " + g.get(i1) + " has cleared index: " + localObject2[i1]));
            }
            if (a) {
              new StringBuilder("saveAllState: adding fragment #").append(i1).append(": ").append(g.get(i1));
            }
            i1 += 1;
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (i != null)
      {
        i2 = i.size();
        localObject2 = localObject3;
        if (i2 > 0)
        {
          localObject3 = new BackStackState[i2];
          i1 = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i1 >= i2) {
              break;
            }
            localObject3[i1] = new BackStackState((ev)i.get(i1));
            if (a) {
              new StringBuilder("saveAllState: adding back stack #").append(i1).append(": ").append(i.get(i1));
            }
            i1 += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      a = arrayOfFragmentState;
      b = ((int[])localObject1);
      c = ((BackStackState[])localObject2);
      return (Parcelable)localObject3;
      localObject2 = null;
      break label211;
    }
  }
  
  public final void j()
  {
    t = false;
    b(1);
  }
  
  public final void k()
  {
    t = false;
    b(2);
  }
  
  public final void l()
  {
    t = false;
    b(4);
  }
  
  public final void m()
  {
    t = false;
    b(5);
  }
  
  public final void n()
  {
    t = true;
    b(3);
  }
  
  public final void o()
  {
    u = true;
    g();
    b(0);
    o = null;
    p = null;
    q = null;
  }
  
  public final void p()
  {
    if (g != null)
    {
      int i1 = 0;
      while (i1 < g.size())
      {
        Fragment localFragment = (Fragment)g.get(i1);
        if (localFragment != null)
        {
          localFragment.onLowMemory();
          if (D != null) {
            D.p();
          }
        }
        i1 += 1;
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (q != null) {
      nv.a(q, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      nv.a(o, localStringBuilder);
    }
  }
}

/* Location:
 * Qualified Name:     fr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */