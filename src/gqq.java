import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class gqq
{
  public int a;
  public grn b;
  public boolean c;
  String d;
  public boolean e;
  private final grc f;
  private final grt g;
  private grj h;
  private long i;
  private boolean j;
  private String k;
  private grs l;
  private InputStream m;
  private long n;
  private int o;
  private Byte p;
  private long q;
  private int r;
  private byte[] s;
  
  private static grv a(grs paramgrs)
  {
    new gqg().b(paramgrs);
    p = false;
    return paramgrs.a();
  }
  
  private final grv b(grs paramgrs)
  {
    if ((!e) && (!(g instanceof grf))) {
      o = new grg();
    }
    return a(paramgrs);
  }
  
  private final boolean b()
  {
    return c() >= 0L;
  }
  
  private final long c()
  {
    if (!j)
    {
      i = f.a();
      j = true;
    }
    return i;
  }
  
  /* Error */
  private final grv c(gri paramgri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 86	gqr:b	I
    //   4: putfield 88	gqq:a	I
    //   7: aload_1
    //   8: ldc 90
    //   10: ldc 92
    //   12: invokevirtual 97	gri:d	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: getfield 99	gqq:h	Lgrj;
    //   20: ifnonnull +92 -> 112
    //   23: new 59	grf
    //   26: dup
    //   27: invokespecial 100	grf:<init>	()V
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 102	gqq:g	Lgrt;
    //   35: aload_0
    //   36: getfield 104	gqq:k	Ljava/lang/String;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 109	grt:a	(Ljava/lang/String;Lgri;Lgrj;)Lgrs;
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 111	gqq:b	Lgrn;
    //   49: ldc 113
    //   51: aload_0
    //   52: getfield 75	gqq:f	Lgrc;
    //   55: getfield 115	grc:a	Ljava/lang/String;
    //   58: invokevirtual 120	grn:a	(Ljava/lang/String;Ljava/lang/Object;)Lgrn;
    //   61: pop
    //   62: aload_0
    //   63: invokespecial 122	gqq:b	()Z
    //   66: ifeq +20 -> 86
    //   69: aload_0
    //   70: getfield 111	gqq:b	Lgrn;
    //   73: ldc 124
    //   75: aload_0
    //   76: invokespecial 71	gqq:c	()J
    //   79: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: invokevirtual 120	grn:a	(Ljava/lang/String;Ljava/lang/Object;)Lgrn;
    //   85: pop
    //   86: aload_1
    //   87: getfield 131	grs:b	Lgrn;
    //   90: aload_0
    //   91: getfield 111	gqq:b	Lgrn;
    //   94: invokevirtual 135	grn:putAll	(Ljava/util/Map;)V
    //   97: aload_0
    //   98: aload_1
    //   99: invokespecial 137	gqq:b	(Lgrs;)Lgrv;
    //   102: astore_1
    //   103: aload_0
    //   104: getstatic 139	gqr:c	I
    //   107: putfield 88	gqq:a	I
    //   110: aload_1
    //   111: areturn
    //   112: aload_0
    //   113: getfield 99	gqq:h	Lgrj;
    //   116: astore_2
    //   117: goto -86 -> 31
    //   120: astore_2
    //   121: aload_1
    //   122: invokevirtual 143	grv:c	()V
    //   125: aload_2
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	gqq
    //   0	127	1	paramgri	gri
    //   30	87	2	localObject1	Object
    //   120	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   103	110	120	finally
  }
  
  public final grv a(gri paramgri)
  {
    a = gqr.d;
    Object localObject1 = f;
    if (h != null)
    {
      localObject1 = new gsf();
      Object localObject3 = Arrays.asList(new grj[] { h, f });
      b = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        gsg localgsg = new gsg((grj)((Iterator)localObject3).next());
        b.add((gsg)hbe.a(localgsg));
      }
      paramgri.d("uploadType", "multipart");
    }
    for (;;)
    {
      paramgri = g.a(k, paramgri, (grj)localObject1);
      b.putAll(b);
      paramgri = b(paramgri);
      try
      {
        if (b()) {
          n = c();
        }
        a = gqr.e;
        return paramgri;
      }
      finally
      {
        paramgri.c();
      }
      paramgri.d("uploadType", "media");
    }
  }
  
  final void a()
  {
    hbe.a(l, "The current request should not be null");
    l.g = new grf();
    grn localgrn = l.b;
    String str = String.valueOf(d);
    if (str.length() != 0) {}
    for (str = "bytes */".concat(str);; str = new String("bytes */"))
    {
      localgrn.c(str);
      return;
    }
  }
  
  public final grv b(gri paramgri)
  {
    Object localObject2 = c(paramgri);
    if (!grz.a(c)) {}
    Object localObject1;
    label380:
    int i2;
    label398:
    int i3;
    label436:
    label622:
    label640:
    label654:
    long l1;
    long l2;
    long l3;
    label753:
    do
    {
      return (grv)localObject2;
      for (;;)
      {
        int i1;
        try
        {
          localObject1 = new gri(e.c.a());
          ((grv)localObject2).c();
          m = f.b();
          paramgri = (gri)localObject1;
          if (!m.markSupported())
          {
            paramgri = (gri)localObject1;
            if (b())
            {
              m = new BufferedInputStream(m);
              paramgri = (gri)localObject1;
            }
          }
          l = g.a("PUT", paramgri, null);
          if (b())
          {
            i1 = (int)Math.min(o, c() - n);
            if (!b()) {
              break label380;
            }
            m.mark(i1);
            localObject1 = new gtp(m, i1);
            localObject1 = new gsc(f.a, (InputStream)localObject1);
            d = true;
            c = i1;
            localObject1 = ((gsc)localObject1).b(false);
            d = String.valueOf(c());
            r = i1;
            l.g = ((grj)localObject1);
            if (i1 != 0) {
              break label654;
            }
            localObject2 = l.b;
            localObject1 = String.valueOf(d);
            if (((String)localObject1).length() == 0) {
              break label640;
            }
            localObject1 = "bytes */".concat((String)localObject1);
            ((grn)localObject2).c((String)localObject1);
            new gqs(this, l);
            if (!b()) {
              break label753;
            }
            localObject1 = a(l);
            try
            {
              if (!grz.a(c)) {
                break;
              }
              n = c();
              if (f.b) {
                m.close();
              }
              a = gqr.e;
              return (grv)localObject1;
            }
            finally
            {
              ((grv)localObject1).c();
            }
          }
          i1 = o;
        }
        finally
        {
          ((grv)localObject2).c();
        }
        continue;
        if (s == null) {
          if (p == null)
          {
            i2 = i1 + 1;
            s = new byte[i1 + 1];
            if (p == null) {
              break label988;
            }
            s[0] = p.byteValue();
            int i4 = 0;
            i3 = i2;
            i2 = i4;
            i4 = gto.a(m, s, i1 + 1 - i3, i3);
            if (i4 >= i3) {
              break label622;
            }
            i2 = Math.max(0, i4) + i2;
            i1 = i2;
            if (p != null)
            {
              i1 = i2 + 1;
              p = null;
            }
            i2 = i1;
            if (d.equals("*")) {
              d = String.valueOf(n + i1);
            }
          }
        }
        for (i2 = i1;; i2 = i1)
        {
          localObject1 = new gre(f.a, s, i2);
          q = (n + i2);
          i1 = i2;
          break;
          i2 = i1;
          break label398;
          i2 = (int)(q - n);
          System.arraycopy(s, r - i2, s, 0, i2);
          if (p != null) {
            s[i2] = p.byteValue();
          }
          i3 = i1 - i2;
          break label436;
          p = Byte.valueOf(s[i1]);
        }
        localObject1 = new String("bytes */");
        continue;
        localObject1 = l.b;
        l1 = n;
        l2 = n;
        l3 = i1;
        localObject2 = d;
        ((grn)localObject1).c(String.valueOf(localObject2).length() + 48 + "bytes " + l1 + "-" + (l2 + l3 - 1L) + "/" + (String)localObject2);
        continue;
        localObject1 = b(l);
      }
      localObject2 = localObject1;
    } while (c != 308);
    localObject2 = e.c.a();
    if (localObject2 != null)
    {
      paramgri = new gri((String)localObject2);
      label809:
      localObject2 = (String)grn.a(e.c.range);
      if (localObject2 == null)
      {
        l1 = 0L;
        label836:
        l2 = l1 - n;
        if ((l2 < 0L) || (l2 > r)) {
          break label996;
        }
        bool = true;
        label866:
        hbe.b(bool);
        l3 = r - l2;
        if (!b()) {
          break label970;
        }
        if (l3 > 0L)
        {
          m.reset();
          if (l2 != m.skip(l2)) {
            break label1002;
          }
        }
      }
    }
    label970:
    label988:
    label996:
    label1002:
    for (boolean bool = true;; bool = false)
    {
      hbe.b(bool);
      for (;;)
      {
        n = l1;
        a = gqr.d;
        ((grv)localObject1).c();
        break;
        l1 = Long.parseLong(((String)localObject2).substring(((String)localObject2).indexOf('-') + 1)) + 1L;
        break label836;
        if (l3 == 0L) {
          s = null;
        }
      }
      break label809;
      i3 = i2;
      i2 = 0;
      break label436;
      bool = false;
      break label866;
    }
  }
}

/* Location:
 * Qualified Name:     gqq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */