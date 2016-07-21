import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ilp
{
  private static final imj[] E = new imj[0];
  static Class g;
  private static imz h;
  private static imj[] i;
  private static Map j;
  private static int k;
  private boolean A;
  private boolean B;
  private boolean C;
  private boolean D;
  public imj a;
  public int b;
  public int c;
  public boolean d;
  public int e;
  public String f;
  private imz l;
  private imj[] m;
  private ikc n;
  private iml o;
  private boolean p;
  private int q;
  private boolean r;
  private int s;
  private boolean t;
  private boolean u;
  private List v;
  private imw[] w;
  private boolean x;
  private boolean y;
  private String z;
  
  static
  {
    b();
  }
  
  private ilp(imj paramimj, int paramInt)
  {
    inx.a(33);
    ikm.a(1);
    if (!inx.b(33)) {
      throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
    }
    a = paramimj;
    b = 33;
    c = 1;
    if (g == null)
    {
      paramimj = a("ilp");
      g = paramimj;
    }
    for (;;)
    {
      try
      {
        l = c();
        m = d();
        n = a(1);
        q = 3;
        r = imn.a("verbose");
        e = -1;
        return;
      }
      finally {}
      paramimj = g;
    }
  }
  
  public ilp(String paramString)
  {
    this(imj.a(paramString), 33);
  }
  
  private static ikc a(int paramInt)
  {
    try
    {
      ikm.a(1);
      ikc localikc2 = (ikc)j.get(ily.b(1));
      ikc localikc1 = localikc2;
      if (localikc2 == null)
      {
        localikc1 = new ikc(1);
        j.put(ily.b(1), localikc1);
      }
      return localikc1;
    }
    finally {}
  }
  
  private static Class a(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError().initCause(paramString);
    }
  }
  
  private final void a(imj paramimj)
  {
    Object localObject1 = n.a(paramimj, b, q);
    String str1;
    int i1;
    String str2;
    if (r)
    {
      localObject2 = System.err;
      str1 = String.valueOf(paramimj);
      i1 = b;
      str2 = String.valueOf(inx.a.c(i1));
      ((PrintStream)localObject2).println(String.valueOf(str1).length() + 8 + String.valueOf(str2).length() + "lookup " + str1 + " " + str2);
      System.err.println(localObject1);
    }
    a(paramimj, (inj)localObject1);
    if ((d) || (u)) {
      return;
    }
    Object localObject2 = imw.a(paramimj, b, c);
    localObject1 = new ilx();
    a.c();
    a.a(7);
    ((ilx)localObject1).a((imw)localObject2, 0);
    if (o != null) {
      ((ilx)localObject1).a(o, 3);
    }
    try
    {
      localObject2 = l.a((ilx)localObject1);
      i1 = a.a & 0xF;
      if ((i1 != 0) && (i1 != 3))
      {
        y = true;
        z = imv.a.c(i1);
        return;
      }
    }
    catch (IOException paramimj)
    {
      if ((paramimj instanceof InterruptedIOException))
      {
        B = true;
        return;
      }
      A = true;
      return;
    }
    if (!((ilx)localObject1).a().equals(((ilx)localObject2).a()))
    {
      y = true;
      z = "response does not match query";
      return;
    }
    localObject2 = n.a((ilx)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = n.a(paramimj, b, q);
    }
    if (r)
    {
      localObject2 = System.err;
      str1 = String.valueOf(paramimj);
      i1 = b;
      str2 = String.valueOf(inx.a.c(i1));
      ((PrintStream)localObject2).println(String.valueOf(str1).length() + 9 + String.valueOf(str2).length() + "queried " + str1 + " " + str2);
      System.err.println(localObject1);
    }
    a(paramimj, (inj)localObject1);
  }
  
  private final void a(imj paramimj1, imj paramimj2)
  {
    t = true;
    y = false;
    A = false;
    B = false;
    x = false;
    D = false;
    s += 1;
    if ((s >= 6) || (paramimj1.equals(paramimj2)))
    {
      e = 1;
      f = "CNAME loop";
      d = true;
      return;
    }
    if (v == null) {
      v = new ArrayList();
    }
    v.add(paramimj2);
    a(paramimj1);
  }
  
  private final void a(imj paramimj, inj paraminj)
  {
    int i2 = 0;
    int i1;
    if (a == 6)
    {
      i1 = 1;
      if (i1 == 0) {
        break label155;
      }
      if (a == 6) {
        break label85;
      }
      paramimj = null;
      label29:
      paraminj = new ArrayList();
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= paramimj.length) {
        break label122;
      }
      Iterator localIterator = paramimj[i1].c();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paraminj.add(localIterator.next());
          continue;
          i1 = 0;
          break;
          label85:
          paramimj = (List)b;
          paramimj = (imt[])paramimj.toArray(new imt[paramimj.size()]);
          break label29;
        }
      }
      i1 += 1;
    }
    label122:
    e = 0;
    w = ((imw[])paraminj.toArray(new imw[paraminj.size()]));
    d = true;
    label155:
    label202:
    do
    {
      return;
      if (a == 1) {}
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0) {
          break label202;
        }
        x = true;
        u = true;
        if (s <= 0) {
          break;
        }
        e = 3;
        d = true;
        return;
      }
      if (a == 2) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        e = 4;
        w = null;
        d = true;
        return;
      }
      if (a == 4) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        a(b).e()).a, paramimj);
        return;
      }
      if (a == 5) {}
      for (i1 = 1; i1 != 0; i1 = 0)
      {
        paraminj = (ikq)((imt)b).e();
        try
        {
          a(paramimj.a(paraminj), paramimj);
          return;
        }
        catch (imk paramimj)
        {
          e = 1;
          f = "Invalid DNAME target";
          d = true;
          return;
        }
      }
      i1 = i2;
      if (a == 3) {
        i1 = 1;
      }
    } while (i1 == 0);
    D = true;
  }
  
  private static void b()
  {
    for (;;)
    {
      try
      {
        h = new iky();
        i = ab;
        j = new HashMap();
        ina localina = ina.a();
        if (c < 0)
        {
          i1 = 1;
          k = i1;
          return;
        }
      }
      catch (UnknownHostException localUnknownHostException)
      {
        throw new RuntimeException("Failed to initialize resolver");
      }
      finally {}
      int i1 = c;
    }
  }
  
  private final void b(imj paramimj1, imj paramimj2)
  {
    u = false;
    if (paramimj2 == null) {}
    for (;;)
    {
      a(paramimj1);
      return;
      try
      {
        paramimj1 = imj.a(paramimj1, paramimj2);
      }
      catch (imk paramimj1)
      {
        C = true;
      }
    }
  }
  
  private static imz c()
  {
    try
    {
      imz localimz = h;
      return localimz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static imj[] d()
  {
    try
    {
      imj[] arrayOfimj = i;
      return arrayOfimj;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final imw[] a()
  {
    int i1 = 0;
    if (d)
    {
      s = 0;
      t = false;
      d = false;
      u = false;
      v = null;
      w = null;
      e = -1;
      f = null;
      x = false;
      y = false;
      z = null;
      A = false;
      B = false;
      C = false;
      D = false;
      if (p) {
        n.a();
      }
    }
    if (a.b())
    {
      b(a, null);
      break label211;
      label117:
      if (!d)
      {
        if (!y) {
          break label257;
        }
        e = 2;
        f = z;
        d = true;
      }
    }
    for (;;)
    {
      return w;
      if (m == null)
      {
        b(a, imj.a);
        break label117;
      }
      if (a.a() > k) {
        b(a, imj.a);
      }
      if (d)
      {
        return w;
        label211:
        if (t) {
          break label117;
        }
        i1 += 1;
      }
      if (i1 >= m.length) {
        break label117;
      }
      b(a, m[i1]);
      if (!d) {
        break;
      }
      return w;
      label257:
      if (B)
      {
        e = 2;
        f = "timed out";
        d = true;
      }
      else if (A)
      {
        e = 2;
        f = "network error";
        d = true;
      }
      else if (x)
      {
        e = 3;
        d = true;
      }
      else if (D)
      {
        e = 1;
        f = "referral";
        d = true;
      }
      else if (C)
      {
        e = 1;
        f = "name too long";
        d = true;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ilp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */