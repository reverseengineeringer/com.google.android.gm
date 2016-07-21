import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

public final class eju
  implements ekt
{
  final ekj a;
  final Lock b;
  final Context c;
  gdb d;
  boolean e;
  boolean f;
  eme g;
  boolean h;
  boolean i;
  private final eih j;
  private ConnectionResult k;
  private int l;
  private int m = 0;
  private boolean n = false;
  private int o;
  private final Bundle p = new Bundle();
  private final Set<eiu> q = new HashSet();
  private int r;
  private final emc s;
  private final Map<eip<?>, Integer> t;
  private final eiq<? extends gdb, gcd> u;
  private ArrayList<Future<?>> v = new ArrayList();
  
  public eju(ekj paramekj, emc paramemc, Map<eip<?>, Integer> paramMap, eih parameih, eiq<? extends gdb, gcd> parameiq, Lock paramLock, Context paramContext)
  {
    a = paramekj;
    s = paramemc;
    t = paramMap;
    j = parameih;
    u = parameiq;
    b = paramLock;
    c = paramContext;
  }
  
  private final void a(boolean paramBoolean)
  {
    if (d != null)
    {
      if ((d.d()) && (paramBoolean)) {
        d.m();
      }
      d.c();
      g = null;
    }
  }
  
  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN";
    case 0: 
      return "STEP_GETTING_SERVICE_BINDINGS";
    case 1: 
      return "STEP_VALIDATING_ACCOUNT";
    case 2: 
      return "STEP_AUTHENTICATING";
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }
  
  /* Error */
  private final void k()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 73	eju:a	Lekj;
    //   6: astore 4
    //   8: aload 4
    //   10: getfield 117	ekj:a	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 122 1 0
    //   18: aload 4
    //   20: invokevirtual 124	ekj:h	()Z
    //   23: pop
    //   24: aload 4
    //   26: new 126	ejs
    //   29: dup
    //   30: aload 4
    //   32: invokespecial 129	ejs:<init>	(Lekj;)V
    //   35: putfield 132	ekj:s	Lekt;
    //   38: aload 4
    //   40: getfield 132	ekj:s	Lekt;
    //   43: invokeinterface 134 1 0
    //   48: aload 4
    //   50: getfield 137	ekj:b	Ljava/util/concurrent/locks/Condition;
    //   53: invokeinterface 142 1 0
    //   58: aload 4
    //   60: getfield 117	ekj:a	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 145 1 0
    //   68: getstatic 150	eku:a	Ljava/util/concurrent/ExecutorService;
    //   71: new 152	ejv
    //   74: dup
    //   75: aload_0
    //   76: invokespecial 155	ejv:<init>	(Leju;)V
    //   79: invokeinterface 161 2 0
    //   84: aload_0
    //   85: getfield 91	eju:d	Lgdb;
    //   88: ifnull +32 -> 120
    //   91: aload_0
    //   92: getfield 163	eju:h	Z
    //   95: ifeq +20 -> 115
    //   98: aload_0
    //   99: getfield 91	eju:d	Lgdb;
    //   102: aload_0
    //   103: getfield 102	eju:g	Leme;
    //   106: aload_0
    //   107: getfield 165	eju:i	Z
    //   110: invokeinterface 168 3 0
    //   115: aload_0
    //   116: iconst_0
    //   117: invokespecial 170	eju:a	(Z)V
    //   120: aload_0
    //   121: getfield 73	eju:a	Lekj;
    //   124: getfield 172	ekj:n	Ljava/util/Map;
    //   127: invokeinterface 178 1 0
    //   132: invokeinterface 184 1 0
    //   137: astore 4
    //   139: aload 4
    //   141: invokeinterface 189 1 0
    //   146: ifeq +55 -> 201
    //   149: aload 4
    //   151: invokeinterface 193 1 0
    //   156: checkcast 195	eiu
    //   159: astore 5
    //   161: aload_0
    //   162: getfield 73	eju:a	Lekj;
    //   165: getfield 197	ekj:m	Ljava/util/Map;
    //   168: aload 5
    //   170: invokeinterface 201 2 0
    //   175: checkcast 203	eit
    //   178: invokeinterface 204 1 0
    //   183: goto -44 -> 139
    //   186: astore 5
    //   188: aload 4
    //   190: getfield 117	ekj:a	Ljava/util/concurrent/locks/Lock;
    //   193: invokeinterface 145 1 0
    //   198: aload 5
    //   200: athrow
    //   201: aload_0
    //   202: getfield 56	eju:n	Z
    //   205: ifeq +13 -> 218
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 56	eju:n	Z
    //   213: aload_0
    //   214: invokevirtual 206	eju:b	()V
    //   217: return
    //   218: aload_0
    //   219: getfield 61	eju:p	Landroid/os/Bundle;
    //   222: invokevirtual 209	android/os/Bundle:isEmpty	()Z
    //   225: ifeq +211 -> 436
    //   228: aconst_null
    //   229: astore 4
    //   231: aload_0
    //   232: getfield 73	eju:a	Lekj;
    //   235: getfield 212	ekj:c	Lenb;
    //   238: astore 6
    //   240: invokestatic 218	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   243: aload 6
    //   245: getfield 223	enb:h	Landroid/os/Handler;
    //   248: invokevirtual 228	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   251: if_acmpne +194 -> 445
    //   254: iconst_1
    //   255: istore_2
    //   256: iload_2
    //   257: ldc -26
    //   259: invokestatic 235	enz:a	(ZLjava/lang/Object;)V
    //   262: aload 6
    //   264: getfield 238	enb:i	Ljava/lang/Object;
    //   267: astore 5
    //   269: aload 5
    //   271: monitorenter
    //   272: aload 6
    //   274: getfield 240	enb:g	Z
    //   277: ifne +173 -> 450
    //   280: iconst_1
    //   281: istore_2
    //   282: iload_2
    //   283: invokestatic 241	enz:a	(Z)V
    //   286: aload 6
    //   288: getfield 223	enb:h	Landroid/os/Handler;
    //   291: iconst_1
    //   292: invokevirtual 245	android/os/Handler:removeMessages	(I)V
    //   295: aload 6
    //   297: iconst_1
    //   298: putfield 240	enb:g	Z
    //   301: aload 6
    //   303: getfield 247	enb:c	Ljava/util/ArrayList;
    //   306: invokevirtual 251	java/util/ArrayList:size	()I
    //   309: ifne +146 -> 455
    //   312: iload_3
    //   313: istore_2
    //   314: iload_2
    //   315: invokestatic 241	enz:a	(Z)V
    //   318: new 68	java/util/ArrayList
    //   321: dup
    //   322: aload 6
    //   324: getfield 253	enb:b	Ljava/util/ArrayList;
    //   327: invokespecial 256	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   330: astore 7
    //   332: aload 6
    //   334: getfield 259	enb:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   337: invokevirtual 263	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   340: istore_1
    //   341: aload 7
    //   343: invokevirtual 264	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   346: astore 7
    //   348: aload 7
    //   350: invokeinterface 189 1 0
    //   355: ifeq +105 -> 460
    //   358: aload 7
    //   360: invokeinterface 193 1 0
    //   365: checkcast 266	ejc
    //   368: astore 8
    //   370: aload 6
    //   372: getfield 268	enb:e	Z
    //   375: ifeq +85 -> 460
    //   378: aload 6
    //   380: getfield 271	enb:a	Lenc;
    //   383: invokeinterface 274 1 0
    //   388: ifeq +72 -> 460
    //   391: aload 6
    //   393: getfield 259	enb:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   396: invokevirtual 263	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   399: iload_1
    //   400: if_icmpne +60 -> 460
    //   403: aload 6
    //   405: getfield 247	enb:c	Ljava/util/ArrayList;
    //   408: aload 8
    //   410: invokevirtual 278	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   413: ifne -65 -> 348
    //   416: aload 8
    //   418: aload 4
    //   420: invokeinterface 281 2 0
    //   425: goto -77 -> 348
    //   428: astore 4
    //   430: aload 5
    //   432: monitorexit
    //   433: aload 4
    //   435: athrow
    //   436: aload_0
    //   437: getfield 61	eju:p	Landroid/os/Bundle;
    //   440: astore 4
    //   442: goto -211 -> 231
    //   445: iconst_0
    //   446: istore_2
    //   447: goto -191 -> 256
    //   450: iconst_0
    //   451: istore_2
    //   452: goto -170 -> 282
    //   455: iconst_0
    //   456: istore_2
    //   457: goto -143 -> 314
    //   460: aload 6
    //   462: getfield 247	enb:c	Ljava/util/ArrayList;
    //   465: invokevirtual 284	java/util/ArrayList:clear	()V
    //   468: aload 6
    //   470: iconst_0
    //   471: putfield 240	enb:g	Z
    //   474: aload 5
    //   476: monitorexit
    //   477: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	eju
    //   340	61	1	i1	int
    //   255	202	2	bool1	boolean
    //   1	312	3	bool2	boolean
    //   6	413	4	localObject1	Object
    //   428	6	4	localObject2	Object
    //   440	1	4	localBundle	Bundle
    //   159	10	5	localeiu	eiu
    //   186	13	5	localObject3	Object
    //   238	231	6	localenb	enb
    //   330	29	7	localObject5	Object
    //   368	49	8	localejc	ejc
    // Exception table:
    //   from	to	target	type
    //   18	58	186	finally
    //   272	280	428	finally
    //   282	312	428	finally
    //   314	348	428	finally
    //   348	425	428	finally
    //   430	433	428	finally
    //   460	477	428	finally
  }
  
  private final void l()
  {
    Iterator localIterator = v.iterator();
    while (localIterator.hasNext()) {
      ((Future)localIterator.next()).cancel(true);
    }
    v.clear();
  }
  
  public final <A extends eit, R extends ejk, T extends ejq<R, A>> T a(T paramT)
  {
    a.f.add(paramT);
    return paramT;
  }
  
  public final void a()
  {
    a.c.e = true;
    a.n.clear();
    n = false;
    e = false;
    k = null;
    m = 0;
    r = 2;
    f = false;
    h = false;
    HashMap localHashMap = new HashMap();
    Object localObject = t.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      eip localeip = (eip)((Iterator)localObject).next();
      eit localeit = (eit)a.m.get(localeip.b());
      int i1 = ((Integer)t.get(localeip)).intValue();
      localeip.a();
      if (localeit.e())
      {
        e = true;
        if (i1 < r) {
          r = i1;
        }
        if (i1 != 0) {
          q.add(localeip.b());
        }
      }
      localHashMap.put(localeit, new ekb(this, localeip, i1));
    }
    if (e)
    {
      s.h = Integer.valueOf(System.identityHashCode(a));
      localObject = new ekf(this);
      d = ((gdb)u.a(c, a.e, s, s.g, (ejc)localObject, (eje)localObject));
    }
    o = a.m.size();
    v.add(eku.a.submit(new ekc(this, localHashMap)));
  }
  
  public final void a(int paramInt)
  {
    b(new ConnectionResult(8, null));
  }
  
  public final void a(Bundle paramBundle)
  {
    if (!b(3)) {}
    do
    {
      return;
      if (paramBundle != null) {
        p.putAll(paramBundle);
      }
    } while (!e());
    k();
  }
  
  public final void a(ConnectionResult paramConnectionResult, eip<?> parameip, int paramInt)
  {
    if (!b(3)) {}
    do
    {
      return;
      b(paramConnectionResult, parameip, paramInt);
    } while (!e());
    k();
  }
  
  final boolean a(ConnectionResult paramConnectionResult)
  {
    return (r == 2) || ((r == 1) && (!paramConnectionResult.a()));
  }
  
  public final <A extends eit, T extends ejq<? extends ejk, A>> T b(T paramT)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }
  
  public final void b()
  {
    Iterator localIterator = a.f.iterator();
    while (localIterator.hasNext())
    {
      ((eks)localIterator.next()).b();
      localIterator.remove();
    }
    a.g();
    if ((k == null) && (!a.f.isEmpty()))
    {
      n = true;
      return;
    }
    l();
    a(true);
    a.n.clear();
    a.a(null);
    a.c.a();
  }
  
  final void b(ConnectionResult paramConnectionResult)
  {
    boolean bool2 = false;
    n = false;
    l();
    boolean bool1;
    enb localenb;
    if (!paramConnectionResult.a())
    {
      bool1 = true;
      a(bool1);
      a.n.clear();
      a.a(paramConnectionResult);
      if ((!a.g) || (!eih.a(c, c)))
      {
        a.h();
        localenb = a.c;
        bool1 = bool2;
        if (Looper.myLooper() == h.getLooper()) {
          bool1 = true;
        }
        enz.a(bool1, "onConnectionFailure must only be called on the Handler thread");
        h.removeMessages(1);
      }
    }
    for (;;)
    {
      synchronized (i)
      {
        Object localObject2 = new ArrayList(d);
        int i1 = f.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          eje localeje = (eje)((Iterator)localObject2).next();
          if ((!e) || (f.get() != i1))
          {
            a.c.a();
            return;
            bool1 = false;
            break;
          }
          if (!d.contains(localeje)) {
            continue;
          }
          localeje.a(paramConnectionResult);
        }
      }
    }
  }
  
  final void b(ConnectionResult paramConnectionResult, eip<?> parameip, int paramInt)
  {
    int i1 = 1;
    if (paramInt != 2)
    {
      parameip.a();
      if (paramInt == 1)
      {
        if (!paramConnectionResult.a()) {
          break label89;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label109;
        }
      }
      paramInt = i1;
      if (k != null) {
        if (Integer.MAX_VALUE >= l) {
          break label109;
        }
      }
    }
    label89:
    label109:
    for (paramInt = i1;; paramInt = 0)
    {
      if (paramInt != 0)
      {
        k = paramConnectionResult;
        l = Integer.MAX_VALUE;
      }
      a.n.put(parameip.b(), paramConnectionResult);
      return;
      if (eih.a(c) != null)
      {
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break;
    }
  }
  
  final boolean b(int paramInt)
  {
    if (m != paramInt)
    {
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + c(m) + " but received callback for step " + c(paramInt));
      b(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }
  
  public final void c()
  {
    n = false;
  }
  
  public final String d()
  {
    return "CONNECTING";
  }
  
  final boolean e()
  {
    o -= 1;
    if (o > 0) {
      return false;
    }
    if (o < 0)
    {
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
      b(new ConnectionResult(8, null));
      return false;
    }
    if (k != null)
    {
      b(k);
      return false;
    }
    return true;
  }
  
  final void f()
  {
    if (o != 0) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return;
        if (!e) {
          break;
        }
      } while (!f);
      localArrayList = new ArrayList();
      m = 1;
      o = a.m.size();
      Iterator localIterator = a.m.keySet().iterator();
      while (localIterator.hasNext())
      {
        eiu localeiu = (eiu)localIterator.next();
        if (a.n.containsKey(localeiu))
        {
          if (e()) {
            g();
          }
        }
        else {
          localArrayList.add(a.m.get(localeiu));
        }
      }
    } while (localArrayList.isEmpty());
    v.add(eku.a.submit(new ekg(this, localArrayList)));
    return;
    h();
  }
  
  final void g()
  {
    m = 2;
    a.o = j();
    v.add(eku.a.submit(new eka(this)));
  }
  
  final void h()
  {
    ArrayList localArrayList = new ArrayList();
    m = 3;
    o = a.m.size();
    Iterator localIterator = a.m.keySet().iterator();
    while (localIterator.hasNext())
    {
      eiu localeiu = (eiu)localIterator.next();
      if (a.n.containsKey(localeiu))
      {
        if (e()) {
          k();
        }
      }
      else {
        localArrayList.add(a.m.get(localeiu));
      }
    }
    if (!localArrayList.isEmpty()) {
      v.add(eku.a.submit(new eke(this, localArrayList)));
    }
  }
  
  final void i()
  {
    e = false;
    a.o = Collections.emptySet();
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext())
    {
      eiu localeiu = (eiu)localIterator.next();
      if (!a.n.containsKey(localeiu)) {
        a.n.put(localeiu, new ConnectionResult(17, null));
      }
    }
  }
  
  final Set<Scope> j()
  {
    HashSet localHashSet = new HashSet(s.b);
    Map localMap = s.d;
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      eip localeip = (eip)localIterator.next();
      if (!a.n.containsKey(localeip.b())) {
        localHashSet.addAll(geta);
      }
    }
    return localHashSet;
  }
}

/* Location:
 * Qualified Name:     eju
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */