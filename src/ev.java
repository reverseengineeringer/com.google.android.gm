import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public final class ev
  extends gd
  implements Runnable
{
  static final boolean a;
  final fr b;
  public ez c;
  ez d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public boolean l;
  boolean m = true;
  public String n;
  boolean o;
  public int p = -1;
  public int q;
  public CharSequence r;
  public int s;
  public CharSequence t;
  public ArrayList<String> u;
  public ArrayList<String> v;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public ev(fr paramfr)
  {
    b = paramfr;
  }
  
  private final int a(boolean paramBoolean)
  {
    if (o) {
      throw new IllegalStateException("commit already called");
    }
    if (fr.a)
    {
      new StringBuilder("Commit: ").append(this);
      a("  ", new PrintWriter(new nw("FragmentManager")));
    }
    o = true;
    if (l) {}
    for (p = b.a(this);; p = -1)
    {
      b.a(this, paramBoolean);
      return p;
    }
  }
  
  private final fa a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, boolean paramBoolean)
  {
    int i5 = 0;
    fa localfa = new fa(this);
    d = new View(b.o.c);
    int i2 = 0;
    int i1 = 0;
    int i3 = i5;
    int i4 = i1;
    if (i2 < paramSparseArray1.size())
    {
      if (!a(paramSparseArray1.keyAt(i2), localfa, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        break label164;
      }
      i1 = 1;
    }
    label164:
    for (;;)
    {
      i2 += 1;
      break;
      while (i3 < paramSparseArray2.size())
      {
        i2 = paramSparseArray2.keyAt(i3);
        i1 = i4;
        if (paramSparseArray1.get(i2) == null)
        {
          i1 = i4;
          if (a(i2, localfa, paramBoolean, paramSparseArray1, paramSparseArray2)) {
            i1 = 1;
          }
        }
        i3 += 1;
        i4 = i1;
      }
      paramSparseArray1 = localfa;
      if (i4 == 0) {
        paramSparseArray1 = null;
      }
      return paramSparseArray1;
    }
  }
  
  private static Object a(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, ns<String, View> paramns, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      paramFragment = R;
      localObject = paramObject;
      if (paramObject != null)
      {
        ge.a(paramArrayList, paramFragment);
        if (paramns != null) {
          paramArrayList.removeAll(paramns.values());
        }
        if (!paramArrayList.isEmpty()) {
          break label52;
        }
        localObject = null;
      }
    }
    return localObject;
    label52:
    paramArrayList.add(paramView);
    ge.b((Transition)paramObject, paramArrayList);
    return paramObject;
  }
  
  private final ns<String, View> a(fa paramfa, Fragment paramFragment, boolean paramBoolean)
  {
    ns localns2 = new ns();
    ns localns1 = localns2;
    if (u != null)
    {
      ge.a(localns2, R);
      if (!paramBoolean) {
        break label74;
      }
      nz.a(localns2, v);
    }
    label74:
    for (localns1 = localns2; paramBoolean; localns1 = a(u, v, localns2))
    {
      if (ag != null) {
        paramFragment = ag;
      }
      a(paramfa, localns1, false);
      return localns1;
    }
    if (ah != null) {
      paramFragment = ah;
    }
    b(paramfa, localns1, false);
    return localns1;
  }
  
  static ns<String, View> a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ns<String, View> paramns)
  {
    if (paramns.isEmpty()) {
      return paramns;
    }
    ns localns = new ns();
    int i2 = paramArrayList1.size();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = (View)paramns.get(paramArrayList1.get(i1));
      if (localView != null) {
        localns.put(paramArrayList2.get(i1), localView);
      }
      i1 += 1;
    }
    return localns;
  }
  
  static void a(fa paramfa, Fragment paramFragment)
  {
    ;
    if (i1 != 0) {}
    for (paramfa = ag;; paramfa = ag)
    {
      if (paramfa != null)
      {
        Object localObject;
        new ArrayList(((ns)localObject).keySet());
        new ArrayList(((ns)localObject).values());
      }
      return;
    }
  }
  
  private static void a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = G;
      if ((i1 != 0) && (!I))
      {
        if ((paramFragment.h()) && (R != null) && (paramSparseArray1.get(i1) == null)) {
          paramSparseArray1.put(i1, paramFragment);
        }
        if (paramSparseArray2.get(i1) == paramFragment) {
          paramSparseArray2.remove(i1);
        }
      }
    }
  }
  
  private static void a(fa paramfa, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i1 = 0;
      while (i1 < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i1);
        String str2 = (String)paramArrayList2.get(i1);
        a(a, str1, str2);
        i1 += 1;
      }
    }
  }
  
  private static void a(ns<String, String> paramns, String paramString1, String paramString2)
  {
    int i1;
    if ((paramString1 != null) && (paramString2 != null)) {
      i1 = 0;
    }
    while (i1 < paramns.size())
    {
      if (paramString1.equals(paramns.c(i1)))
      {
        paramns.a(i1, paramString2);
        return;
      }
      i1 += 1;
    }
    paramns.put(paramString1, paramString2);
  }
  
  private final boolean a(int paramInt, fa paramfa, boolean paramBoolean, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    ViewGroup localViewGroup = (ViewGroup)b.p.a(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    Object localObject4 = (Fragment)paramSparseArray2.get(paramInt);
    Object localObject5 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject2;
    label66:
    Object localObject3;
    ArrayList localArrayList1;
    Object localObject1;
    if (localObject4 == null)
    {
      localObject2 = null;
      if ((localObject4 != null) && (localObject5 != null)) {
        break label181;
      }
      paramSparseArray1 = null;
      if (localObject5 != null) {
        break label272;
      }
      localObject3 = null;
      localArrayList1 = new ArrayList();
      if (paramSparseArray1 == null) {
        break label1036;
      }
      localObject1 = a(paramfa, (Fragment)localObject5, paramBoolean);
      if (!((ns)localObject1).isEmpty()) {
        break label324;
      }
      localObject1 = null;
      paramSparseArray2 = null;
    }
    for (;;)
    {
      if ((localObject2 == null) && (paramSparseArray2 == null) && (localObject3 == null))
      {
        return false;
        if (paramBoolean) {
          if (ab == Fragment.j) {
            paramSparseArray1 = aa;
          }
        }
        for (;;)
        {
          localObject2 = ge.a(paramSparseArray1);
          break;
          paramSparseArray1 = ab;
          continue;
          paramSparseArray1 = Y;
        }
        label181:
        if (paramBoolean) {
          if (ad == Fragment.j) {
            paramSparseArray1 = ac;
          }
        }
        for (;;)
        {
          if (paramSparseArray1 != null) {
            break label234;
          }
          paramSparseArray1 = null;
          break;
          paramSparseArray1 = ad;
          continue;
          paramSparseArray1 = ac;
        }
        label234:
        paramSparseArray2 = (Transition)paramSparseArray1;
        if (paramSparseArray2 == null)
        {
          paramSparseArray1 = null;
          break label66;
        }
        paramSparseArray1 = new TransitionSet();
        paramSparseArray1.addTransition(paramSparseArray2);
        break label66;
        label272:
        if (paramBoolean) {
          if (Z == Fragment.j) {
            paramSparseArray2 = Y;
          }
        }
        for (;;)
        {
          localObject3 = ge.a(paramSparseArray2);
          break;
          paramSparseArray2 = Z;
          continue;
          paramSparseArray2 = aa;
        }
        label324:
        if (paramBoolean) {}
        for (paramSparseArray2 = ag;; paramSparseArray2 = ag)
        {
          if (paramSparseArray2 != null)
          {
            new ArrayList(((ns)localObject1).keySet());
            new ArrayList(((ns)localObject1).values());
          }
          localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ex(this, localViewGroup, paramSparseArray1, localArrayList1, paramfa, paramBoolean, (Fragment)localObject4, (Fragment)localObject5));
          paramSparseArray2 = paramSparseArray1;
          break;
        }
      }
      ArrayList localArrayList2 = new ArrayList();
      Object localObject6 = a(localObject3, (Fragment)localObject5, localArrayList2, (ns)localObject1, d);
      if ((v != null) && (localObject1 != null))
      {
        paramSparseArray1 = (View)((ns)localObject1).get(v.get(0));
        if (paramSparseArray1 != null)
        {
          if (localObject6 != null) {
            ge.a(localObject6, paramSparseArray1);
          }
          if (paramSparseArray2 != null) {
            ge.a(paramSparseArray2, paramSparseArray1);
          }
        }
      }
      ew localew = new ew(this, (Fragment)localObject4);
      localObject5 = new ArrayList();
      ns localns = new ns();
      if (localObject4 != null) {
        if (paramBoolean) {
          if (ae == null) {
            paramBoolean = true;
          }
        }
      }
      for (;;)
      {
        localObject3 = (Transition)localObject2;
        paramSparseArray1 = (Transition)localObject6;
        Object localObject7 = (Transition)paramSparseArray2;
        if ((localObject3 != null) && (paramSparseArray1 != null)) {}
        for (;;)
        {
          if (paramBoolean)
          {
            localObject4 = new TransitionSet();
            if (localObject3 != null) {
              ((TransitionSet)localObject4).addTransition((Transition)localObject3);
            }
            if (paramSparseArray1 != null) {
              ((TransitionSet)localObject4).addTransition(paramSparseArray1);
            }
            if (localObject7 != null) {
              ((TransitionSet)localObject4).addTransition((Transition)localObject7);
            }
            paramSparseArray1 = (SparseArray<Fragment>)localObject4;
          }
          label1021:
          for (;;)
          {
            if (paramSparseArray1 != null)
            {
              localObject3 = d;
              localObject4 = c;
              localObject7 = a;
              if ((localObject2 != null) || (paramSparseArray2 != null))
              {
                Transition localTransition = (Transition)localObject2;
                if (localTransition != null) {
                  localTransition.addTarget((View)localObject3);
                }
                if (paramSparseArray2 != null) {
                  ge.a(paramSparseArray2, (View)localObject3, (Map)localObject1, localArrayList1);
                }
                localViewGroup.getViewTreeObserver().addOnPreDrawListener(new gg(localViewGroup, localTransition, (View)localObject3, localew, (Map)localObject7, localns, (ArrayList)localObject5));
                if (localTransition != null) {
                  localTransition.setEpicenterCallback(new gh((gj)localObject4));
                }
              }
              localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ey(this, localViewGroup, paramfa, paramInt, paramSparseArray1));
              ge.a(paramSparseArray1, d, true);
              a(paramfa, paramInt, paramSparseArray1);
              TransitionManager.beginDelayedTransition(localViewGroup, (Transition)paramSparseArray1);
              localObject1 = d;
              paramfa = b;
              localObject2 = (Transition)localObject2;
              localObject3 = (Transition)localObject6;
              paramSparseArray2 = (Transition)paramSparseArray2;
              localObject4 = (Transition)paramSparseArray1;
              if (localObject4 != null) {
                localViewGroup.getViewTreeObserver().addOnPreDrawListener(new gi(localViewGroup, (Transition)localObject2, (ArrayList)localObject5, (Transition)localObject3, localArrayList2, paramSparseArray2, localArrayList1, localns, paramfa, (Transition)localObject4, (View)localObject1));
              }
            }
            if (paramSparseArray1 == null) {
              break label1024;
            }
            return true;
            paramBoolean = ae.booleanValue();
            break;
            if (af == null)
            {
              paramBoolean = true;
              break;
            }
            paramBoolean = af.booleanValue();
            break;
            if ((paramSparseArray1 != null) && (localObject3 != null)) {
              paramSparseArray1 = new TransitionSet().addTransition(paramSparseArray1).addTransition((Transition)localObject3).setOrdering(1);
            }
            for (;;)
            {
              if (localObject7 == null) {
                break label1021;
              }
              localObject3 = new TransitionSet();
              if (paramSparseArray1 != null) {
                ((TransitionSet)localObject3).addTransition(paramSparseArray1);
              }
              ((TransitionSet)localObject3).addTransition((Transition)localObject7);
              paramSparseArray1 = (SparseArray<Fragment>)localObject3;
              break;
              if (paramSparseArray1 == null)
              {
                paramSparseArray1 = (SparseArray<Fragment>)localObject3;
                if (localObject3 == null) {
                  paramSparseArray1 = null;
                }
              }
            }
          }
          label1024:
          return false;
          paramBoolean = true;
        }
        paramBoolean = true;
      }
      label1036:
      localObject1 = null;
      paramSparseArray2 = paramSparseArray1;
    }
  }
  
  private final void b(int paramInt, Fragment paramFragment, String paramString)
  {
    B = b;
    if (paramString != null)
    {
      if ((H != null) && (!paramString.equals(H))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + H + " now " + paramString);
      }
      H = paramString;
    }
    if (paramInt != 0)
    {
      if ((F != 0) && (F != paramInt)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + F + " now " + paramInt);
      }
      F = paramInt;
      G = paramInt;
    }
    paramString = new ez();
    c = 1;
    d = paramFragment;
    a(paramString);
  }
  
  private final void b(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!b.p.a()) {}
    ez localez;
    do
    {
      return;
      localez = c;
    } while (localez == null);
    switch (c)
    {
    }
    for (;;)
    {
      localez = a;
      break;
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      Object localObject1 = d;
      if (b.g != null)
      {
        int i1 = 0;
        if (i1 < b.g.size())
        {
          Fragment localFragment = (Fragment)b.g.get(i1);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (G != G) {}
          }
          else
          {
            if (localFragment != localObject1) {
              break label197;
            }
            localObject2 = null;
            paramSparseArray2.remove(G);
          }
          for (;;)
          {
            i1 += 1;
            localObject1 = localObject2;
            break;
            label197:
            a(paramSparseArray1, paramSparseArray2, localFragment);
            localObject2 = localObject1;
          }
        }
      }
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      b(paramSparseArray1, paramSparseArray2, d);
    }
  }
  
  private final void b(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i1 = G;
      if (i1 != 0)
      {
        if (!paramFragment.h()) {
          paramSparseArray2.put(i1, paramFragment);
        }
        if (paramSparseArray1.get(i1) == paramFragment) {
          paramSparseArray1.remove(i1);
        }
      }
      if ((k <= 0) && (b.n > 0))
      {
        b.a(paramFragment);
        b.a(paramFragment, 1, 0, 0, false);
      }
    }
  }
  
  static void b(fa paramfa, ns<String, View> paramns, boolean paramBoolean)
  {
    int i2 = paramns.size();
    int i1 = 0;
    if (i1 < i2)
    {
      String str1 = (String)paramns.b(i1);
      String str2 = ((View)paramns.c(i1)).getTransitionName();
      if (paramBoolean) {
        a(a, str1, str2);
      }
      for (;;)
      {
        i1 += 1;
        break;
        a(a, str2, str1);
      }
    }
  }
  
  public final fa a(boolean paramBoolean, fa paramfa, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (fr.a)
    {
      new StringBuilder("popFromBackStack: ").append(this);
      a("  ", new PrintWriter(new nw("FragmentManager")));
    }
    fa localfa = paramfa;
    if (a)
    {
      localfa = paramfa;
      if (b.n > 0)
      {
        if (paramfa != null) {
          break label216;
        }
        if (paramSparseArray1.size() == 0)
        {
          localfa = paramfa;
          if (paramSparseArray2.size() == 0) {}
        }
        else
        {
          localfa = a(paramSparseArray1, paramSparseArray2, true);
        }
      }
    }
    label97:
    a(-1);
    int i1;
    label110:
    int i2;
    label118:
    int i3;
    if (localfa != null)
    {
      i1 = 0;
      if (localfa == null) {
        break label250;
      }
      i2 = 0;
      paramfa = d;
      if (paramfa == null) {
        break label539;
      }
      if (localfa == null) {
        break label259;
      }
      i3 = 0;
      label135:
      if (localfa == null) {
        break label268;
      }
    }
    label216:
    label250:
    label259:
    label268:
    for (int i4 = 0;; i4 = h) {
      switch (c)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + c);
        localfa = paramfa;
        if (paramBoolean) {
          break label97;
        }
        a(paramfa, v, u);
        localfa = paramfa;
        break label97;
        i1 = k;
        break label110;
        i2 = j;
        break label118;
        i3 = g;
        break label135;
      }
    }
    paramSparseArray1 = d;
    P = i4;
    b.a(paramSparseArray1, fr.c(i2), i1);
    for (;;)
    {
      paramfa = b;
      break;
      paramSparseArray1 = d;
      if (paramSparseArray1 != null)
      {
        P = i4;
        b.a(paramSparseArray1, fr.c(i2), i1);
      }
      if (i != null)
      {
        i4 = 0;
        while (i4 < i.size())
        {
          paramSparseArray1 = (Fragment)i.get(i4);
          P = i3;
          b.a(paramSparseArray1, false);
          i4 += 1;
        }
        paramSparseArray1 = d;
        P = i3;
        b.a(paramSparseArray1, false);
        continue;
        paramSparseArray1 = d;
        P = i3;
        b.c(paramSparseArray1, fr.c(i2), i1);
        continue;
        paramSparseArray1 = d;
        P = i4;
        b.b(paramSparseArray1, fr.c(i2), i1);
        continue;
        paramSparseArray1 = d;
        P = i3;
        b.e(paramSparseArray1, fr.c(i2), i1);
        continue;
        paramSparseArray1 = d;
        P = i3;
        b.d(paramSparseArray1, fr.c(i2), i1);
      }
    }
    label539:
    if (paramBoolean)
    {
      b.a(b.n, fr.c(i2), i1, true);
      localfa = null;
    }
    if (p >= 0)
    {
      paramfa = b;
      i1 = p;
    }
    try
    {
      k.set(i1, null);
      if (l == null) {
        l = new ArrayList();
      }
      if (fr.a) {
        new StringBuilder("Freeing back stack index ").append(i1);
      }
      l.add(Integer.valueOf(i1));
      p = -1;
      return localfa;
    }
    finally {}
  }
  
  public final gd a()
  {
    if (l) {
      throw new IllegalStateException("This transaction is already being added to the back stack");
    }
    m = false;
    return this;
  }
  
  public final gd a(int paramInt, Fragment paramFragment, String paramString)
  {
    b(paramInt, paramFragment, paramString);
    return this;
  }
  
  public final gd a(Fragment paramFragment)
  {
    ez localez = new ez();
    c = 3;
    d = paramFragment;
    a(localez);
    return this;
  }
  
  public final gd a(Fragment paramFragment, String paramString)
  {
    b(0, paramFragment, paramString);
    return this;
  }
  
  public final void a(int paramInt)
  {
    if (!l) {}
    for (;;)
    {
      return;
      if (fr.a) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      for (ez localez = c; localez != null; localez = a)
      {
        Fragment localFragment;
        if (d != null)
        {
          localFragment = d;
          A += paramInt;
          if (fr.a) {
            new StringBuilder("Bump nesting of ").append(d).append(" to ").append(d.A);
          }
        }
        if (i != null)
        {
          int i1 = i.size() - 1;
          while (i1 >= 0)
          {
            localFragment = (Fragment)i.get(i1);
            A += paramInt;
            if (fr.a) {
              new StringBuilder("Bump nesting of ").append(localFragment).append(" to ").append(A);
            }
            i1 -= 1;
          }
        }
      }
    }
  }
  
  public final void a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!b.p.a()) {}
    ez localez;
    do
    {
      return;
      localez = d;
    } while (localez == null);
    switch (c)
    {
    }
    for (;;)
    {
      localez = b;
      break;
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      if (i != null)
      {
        int i1 = i.size() - 1;
        while (i1 >= 0)
        {
          b(paramSparseArray1, paramSparseArray2, (Fragment)i.get(i1));
          i1 -= 1;
        }
      }
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      a(paramSparseArray1, paramSparseArray2, d);
      continue;
      b(paramSparseArray1, paramSparseArray2, d);
      continue;
      a(paramSparseArray1, paramSparseArray2, d);
    }
  }
  
  public final void a(ez paramez)
  {
    if (c == null)
    {
      d = paramez;
      c = paramez;
    }
    for (;;)
    {
      e = f;
      f = g;
      g = h;
      h = i;
      e += 1;
      return;
      b = d;
      d.a = paramez;
      d = paramez;
    }
  }
  
  final void a(fa paramfa, int paramInt, Object paramObject)
  {
    if (b.g != null)
    {
      int i1 = 0;
      if (i1 < b.g.size())
      {
        Fragment localFragment = (Fragment)b.g.get(i1);
        if ((R != null) && (Q != null) && (G == paramInt))
        {
          if (!I) {
            break label125;
          }
          if (!b.contains(R))
          {
            ge.a(paramObject, R, true);
            b.add(R);
          }
        }
        for (;;)
        {
          i1 += 1;
          break;
          label125:
          ge.a(paramObject, R, false);
          b.remove(R);
        }
      }
    }
  }
  
  final void a(fa paramfa, ns<String, View> paramns, boolean paramBoolean)
  {
    int i1;
    int i2;
    label13:
    String str;
    Object localObject;
    if (v == null)
    {
      i1 = 0;
      i2 = 0;
      if (i2 >= i1) {
        return;
      }
      str = (String)u.get(i2);
      localObject = (View)paramns.get((String)v.get(i2));
      if (localObject != null)
      {
        localObject = ((View)localObject).getTransitionName();
        if (!paramBoolean) {
          break label103;
        }
        a(a, str, (String)localObject);
      }
    }
    for (;;)
    {
      i2 += 1;
      break label13;
      i1 = v.size();
      break;
      label103:
      a(a, (String)localObject, str);
    }
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(n);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(p);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(o);
      if (j != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(j));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(k));
      }
      if ((f != 0) || (g != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(f));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(g));
      }
      if ((h != 0) || (i != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(h));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(i));
      }
      if ((q != 0) || (r != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(q));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(r);
      }
      if ((s != 0) || (t != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(s));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(t);
      }
    }
    if (c != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      ez localez = c;
      int i1 = 0;
      while (localez != null)
      {
        String str1;
        int i2;
        switch (c)
        {
        default: 
          str1 = "cmd=" + c;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(d);
          if (paramBoolean)
          {
            if ((e != 0) || (f != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(e));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(f));
            }
            if ((g != 0) || (h != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(g));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(h));
            }
          }
          if ((i == null) || (i.size() <= 0)) {
            break label804;
          }
          i2 = 0;
          label638:
          if (i2 >= i.size()) {
            break label804;
          }
          paramPrintWriter.print(str2);
          if (i.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(i.get(i2));
          i2 += 1;
          break label638;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (i2 == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i2);
          paramPrintWriter.print(": ");
        }
        label804:
        localez = a;
        i1 += 1;
      }
    }
  }
  
  public final int b()
  {
    return a(false);
  }
  
  public final gd b(Fragment paramFragment)
  {
    ez localez = new ez();
    c = 6;
    d = paramFragment;
    a(localez);
    return this;
  }
  
  public final int c()
  {
    return a(true);
  }
  
  public final gd c(Fragment paramFragment)
  {
    ez localez = new ez();
    c = 7;
    d = paramFragment;
    a(localez);
    return this;
  }
  
  public final boolean d()
  {
    return e == 0;
  }
  
  public final void run()
  {
    if (fr.a) {
      new StringBuilder("Run: ").append(this);
    }
    if ((l) && (p < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    a(1);
    Object localObject1;
    if ((a) && (b.n > 0))
    {
      localObject1 = new SparseArray();
      localObject2 = new SparseArray();
      b((SparseArray)localObject1, (SparseArray)localObject2);
    }
    for (Object localObject2 = a((SparseArray)localObject1, (SparseArray)localObject2, false);; localObject2 = null)
    {
      int i1;
      label111:
      int i2;
      label118:
      ez localez;
      int i3;
      if (localObject2 != null)
      {
        i1 = 0;
        if (localObject2 == null) {
          break label229;
        }
        i2 = 0;
        localez = c;
        if (localez == null) {
          break label694;
        }
        if (localObject2 == null) {
          break label237;
        }
        i3 = 0;
        label136:
        if (localObject2 == null) {
          break label246;
        }
      }
      label229:
      label237:
      label246:
      for (int i4 = 0;; i4 = f) {
        switch (c)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + c);
          i1 = k;
          break label111;
          i2 = j;
          break label118;
          i3 = e;
          break label136;
        }
      }
      localObject1 = d;
      P = i3;
      b.a((Fragment)localObject1, false);
      for (;;)
      {
        localez = a;
        break;
        localObject1 = d;
        int i6 = G;
        Object localObject3 = localObject1;
        if (b.g != null)
        {
          int i5 = b.g.size() - 1;
          localObject3 = localObject1;
          if (i5 >= 0)
          {
            localObject3 = (Fragment)b.g.get(i5);
            if (fr.a) {
              new StringBuilder("OP_REPLACE: adding=").append(localObject1).append(" old=").append(localObject3);
            }
            if (G == i6) {
              if (localObject3 == localObject1)
              {
                d = null;
                localObject1 = null;
              }
            }
            for (;;)
            {
              i5 -= 1;
              break;
              if (i == null) {
                i = new ArrayList();
              }
              i.add(localObject3);
              P = i4;
              if (l)
              {
                A += 1;
                if (fr.a) {
                  new StringBuilder("Bump nesting of ").append(localObject3).append(" to ").append(A);
                }
              }
              b.a((Fragment)localObject3, i2, i1);
            }
          }
        }
        if (localObject3 != null)
        {
          P = i3;
          b.a((Fragment)localObject3, false);
          continue;
          localObject1 = d;
          P = i4;
          b.a((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = d;
          P = i4;
          b.b((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = d;
          P = i3;
          b.c((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = d;
          P = i4;
          b.d((Fragment)localObject1, i2, i1);
          continue;
          localObject1 = d;
          P = i3;
          b.e((Fragment)localObject1, i2, i1);
        }
      }
      label694:
      b.a(b.n, i2, i1, true);
      if (l)
      {
        localObject1 = b;
        if (i == null) {
          i = new ArrayList();
        }
        i.add(this);
        ((fr)localObject1).h();
      }
      return;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (p >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(p);
    }
    if (n != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(n);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     ev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */