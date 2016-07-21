import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class iip
{
  public static final hfd<String> a = hfd.a("a", "font", "img", "input", "span");
  private static final Set<String> j = hfd.a("action", "archive", "background", "cite", "classid", "codebase", new String[] { "data", "dsync", "formaction", "href", "icon", "longdesc", "manifest", "poster", "profile", "src", "srcset", "usemap" });
  final Map<String, Map<String, ihe>> b = hhk.d();
  public final Map<String, ihe> c = hhk.d();
  public final Set<String> d = hio.a();
  public final Map<String, Boolean> e = hhk.d();
  public transient hel<String, ihs> f;
  private final Map<String, ihu> g = hhk.d();
  private final Set<String> h = hio.a(a);
  private boolean i;
  
  public final hel<String, ihs> a()
  {
    if (f != null) {
      return f;
    }
    Object localObject3 = hhk.a(g);
    LinkedHashMap localLinkedHashMap1 = hhk.a(b);
    Object localObject1 = localLinkedHashMap1.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      ((Map.Entry)localObject2).setValue(hhk.a((Map)((Map.Entry)localObject2).getValue()));
    }
    LinkedHashMap localLinkedHashMap2 = hhk.a(c);
    Object localObject4 = hfd.a(d);
    if (i)
    {
      localObject2 = (ihu)((Map)localObject3).get("a");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ihu.b;
      }
      ((Map)localObject3).put("a", ihx.a(new ihu[] { localObject1, iit.c }));
    }
    if ((((Set)localObject4).size() == 3) && (((Set)localObject4).contains("mailto")) && (((Set)localObject4).contains("http")) && (((Set)localObject4).contains("https"))) {}
    Object localObject5;
    for (localObject1 = iji.c;; localObject1 = new iia((Iterable)localObject4))
    {
      localObject2 = hio.a(j);
      localObject4 = j.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        if (localLinkedHashMap2.containsKey(localObject5))
        {
          ((Set)localObject2).remove(localObject5);
          localLinkedHashMap2.put(localObject5, ihh.a(new ihe[] { localObject1, (ihe)localLinkedHashMap2.get(localObject5) }));
        }
      }
    }
    localObject4 = localLinkedHashMap1.entrySet().iterator();
    Object localObject6;
    Object localObject7;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Map)((Map.Entry)((Iterator)localObject4).next()).getValue();
      localObject6 = ((Set)localObject2).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        if (((Map)localObject5).containsKey(localObject7)) {
          ((Map)localObject5).put(localObject7, ihh.a(new ihe[] { localObject1, (ihe)((Map)localObject5).get(localObject7) }));
        }
      }
    }
    Object localObject2 = hel.f();
    localObject3 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = (String)((Map.Entry)localObject1).getKey();
      localObject5 = (ihu)((Map.Entry)localObject1).getValue();
      if (!ihu.b.equals(localObject5))
      {
        localObject1 = (Map)localLinkedHashMap1.get(localObject4);
        if (localObject1 != null) {
          break label793;
        }
        localObject1 = hel.e();
      }
    }
    label793:
    for (;;)
    {
      localObject6 = hel.f();
      localObject7 = ((Map)localObject1).entrySet().iterator();
      Object localObject8;
      String str;
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (Map.Entry)((Iterator)localObject7).next();
        str = (String)((Map.Entry)localObject8).getKey();
        if (!localLinkedHashMap2.containsKey(str))
        {
          localObject8 = (ihe)((Map.Entry)localObject8).getValue();
          if (!ihe.b.equals(localObject8)) {
            ((hen)localObject6).b(str, localObject8);
          }
        }
      }
      localObject7 = localLinkedHashMap2.entrySet().iterator();
      while (((Iterator)localObject7).hasNext())
      {
        localObject8 = (Map.Entry)((Iterator)localObject7).next();
        str = (String)((Map.Entry)localObject8).getKey();
        localObject8 = ihh.a(new ihe[] { (ihe)((Map)localObject1).get(str), (ihe)((Map.Entry)localObject8).getValue() });
        if (!ihe.b.equals(localObject8)) {
          ((hen)localObject6).b(str, localObject8);
        }
      }
      ((hen)localObject2).b(localObject4, new ihs((String)localObject4, (ihu)localObject5, ((hen)localObject6).b(), h.contains(localObject4)));
      break;
      localObject1 = ((hen)localObject2).b();
      f = ((hel)localObject1);
      return (hel<String, ihs>)localObject1;
    }
  }
  
  public final iip a(ihe paramihe, List<String> paramList)
  {
    f = null;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ihe localihe = (ihe)c.get(str);
      c.put(str, ihh.a(new ihe[] { localihe, paramihe }));
    }
    return this;
  }
  
  public final iip a(ihu paramihu, String... paramVarArgs)
  {
    f = null;
    int n = paramVarArgs.length;
    int m = 0;
    if (m < n)
    {
      String str = iim.a(paramVarArgs[m]);
      Object localObject = ihx.a(new ihu[] { (ihu)g.get(str), paramihu });
      g.put(str, localObject);
      int k;
      if (!e.containsKey(str))
      {
        localObject = (ijo)ijm.c.get(str);
        if ((localObject == null) || ((d & bc) != 0)) {}
        switch (ijn.a[ijc.a(str).ordinal()])
        {
        default: 
          k = 0;
        }
      }
      for (;;)
      {
        if (k != 0) {
          e.put(str, Boolean.valueOf(true));
        }
        m += 1;
        break;
        k = 1;
        continue;
        k = 1;
        continue;
        k = 1;
        continue;
        k = 0;
        continue;
        if (("xmp".equals(str)) || ("listing".equals(str))) {
          k = 1;
        } else {
          k = 0;
        }
      }
    }
    return this;
  }
  
  public final iip a(String... paramVarArgs)
  {
    return a(ihu.a, paramVarArgs);
  }
  
  public final iiq b(String... paramVarArgs)
  {
    heh localheh = hef.d();
    int m = paramVarArgs.length;
    int k = 0;
    while (k < m)
    {
      localheh.c(iim.a(paramVarArgs[k]));
      k += 1;
    }
    return new iiq(this, localheh.a());
  }
}

/* Location:
 * Qualified Name:     iip
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */