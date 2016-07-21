import java.io.IOException;

public class gqv<T>
  extends gua
{
  private final gqt a;
  private final String d;
  private final String e;
  private final grj f;
  private grn g = new grn();
  private grn h;
  private int i = -1;
  private String j;
  private boolean k;
  private Class<T> l;
  private gqq m;
  
  public gqv(gqt paramgqt, String paramString1, String paramString2, grj paramgrj, Class<T> paramClass)
  {
    l = ((Class)hbe.a(paramClass));
    a = ((gqt)hbe.a(paramgqt));
    d = ((String)hbe.a(paramString1));
    e = ((String)hbe.a(paramString2));
    f = paramgrj;
    paramgqt = e;
    if (paramgqt != null)
    {
      paramString1 = g;
      paramString2 = String.valueOf("Google-API-Java-Client");
      paramString1.f(String.valueOf(paramgqt).length() + 1 + String.valueOf(paramString2).length() + paramgqt + " " + paramString2);
      return;
    }
    g.f("Google-API-Java-Client");
  }
  
  private final grs a(boolean paramBoolean)
  {
    if (m == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      hbe.a(paramBoolean);
      hbe.a(true);
      Object localObject = d;
      localObject = ab.a((String)localObject, d(), f);
      new gqg().b((grs)localObject);
      n = a().a();
      if ((f == null) && ((d.equals("POST")) || (d.equals("PUT")) || (d.equals("PATCH")))) {
        g = new grf();
      }
      b.putAll(g);
      if (!k) {
        o = new grg();
      }
      m = new gqw(this, m, (grs)localObject);
      return (grs)localObject;
    }
  }
  
  private final gri d()
  {
    Object localObject = a;
    String str = String.valueOf(c);
    localObject = String.valueOf(d);
    if (((String)localObject).length() != 0) {}
    for (str = str.concat((String)localObject);; str = new String(str)) {
      return new gri(gsh.a(str, e, this));
    }
  }
  
  public gqt a()
  {
    return a;
  }
  
  public gqv<T> a(String paramString, Object paramObject)
  {
    return (gqv)super.b(paramString, paramObject);
  }
  
  public IOException a(grv paramgrv)
  {
    return new grw(paramgrv);
  }
  
  public final T c()
  {
    int n = 1;
    Object localObject2;
    Object localObject1;
    if (m == null)
    {
      localObject2 = a(false).a();
      h = e.c;
      i = c;
      j = d;
      localObject1 = l;
      int i1 = c;
      if ((e.i.equals("HEAD")) || (i1 / 100 == 1) || (i1 == 204) || (i1 == 304))
      {
        ((grv)localObject2).b();
        n = 0;
      }
      if (n == 0) {
        return null;
      }
    }
    else
    {
      localObject1 = d();
      boolean bool2 = ab.a(d, (gri)localObject1, f).p;
      localObject2 = m;
      b = g;
      e = k;
      boolean bool1;
      if (a == gqr.a)
      {
        bool1 = true;
        label180:
        hbe.a(bool1);
        if (!c) {
          break label252;
        }
      }
      label252:
      for (localObject1 = ((gqq)localObject2).a((gri)localObject1);; localObject1 = ((gqq)localObject2).b((gri)localObject1))
      {
        e.n = a().a();
        localObject2 = localObject1;
        if (!bool2) {
          break;
        }
        localObject2 = localObject1;
        if (grz.a(c)) {
          break;
        }
        throw a((grv)localObject1);
        bool1 = false;
        break label180;
      }
    }
    return (T)e.n.a(((grv)localObject2).a(), ((grv)localObject2).e(), (Class)localObject1);
  }
}

/* Location:
 * Qualified Name:     gqv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */