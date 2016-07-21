import java.io.IOException;
import java.io.PrintStream;
import java.net.SocketAddress;
import java.security.MessageDigest;
import java.util.Date;

public final class ioj
{
  iom a;
  SocketAddress b;
  SocketAddress c;
  inn d;
  long e = 900000L;
  private imj f;
  private int g;
  private int h;
  private long i;
  private boolean j;
  private inq k;
  private inr l;
  private int m;
  private long n;
  private long o;
  private imw p;
  private int q;
  
  private ioj() {}
  
  ioj(imj paramimj, SocketAddress paramSocketAddress, inq paraminq)
  {
    c = paramSocketAddress;
    k = paraminq;
    if (paramimj.b()) {
      f = paramimj;
    }
    for (;;)
    {
      g = 252;
      h = 1;
      i = 0L;
      j = false;
      m = 0;
      return;
      try
      {
        f = imj.a(paramimj, imj.a);
      }
      catch (imk paramimj)
      {
        throw new IllegalArgumentException("ZoneTransferIn: name too long");
      }
    }
  }
  
  private static ilx a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new ilx(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      if ((paramArrayOfByte instanceof iog)) {
        throw ((iog)paramArrayOfByte);
      }
      throw new iog("Error parsing message");
    }
  }
  
  private final void a(String paramString)
  {
    if (imn.a("verbose"))
    {
      PrintStream localPrintStream = System.out;
      String str = String.valueOf(f);
      localPrintStream.println(String.valueOf(str).length() + 2 + String.valueOf(paramString).length() + str + ": " + paramString);
    }
  }
  
  private static void b(String paramString)
  {
    throw new ioi(paramString);
  }
  
  private final void c()
  {
    if (!j) {
      b("server doesn't support IXFR");
    }
    a("falling back to AXFR");
    g = 252;
    m = 0;
  }
  
  final void a()
  {
    try
    {
      if (d != null) {
        d.a();
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  final void b()
  {
    Object localObject1 = imw.a(f, g, h);
    Object localObject2 = new ilx();
    a.c();
    ((ilx)localObject2).a((imw)localObject1, 0);
    if (g == 251) {
      ((ilx)localObject2).a(new ine(f, h, imj.a, imj.a, i), 2);
    }
    if (k != null)
    {
      k.apply((ilx)localObject2, null);
      l = new inr(k, ((ilx)localObject2).b());
    }
    localObject1 = ((ilx)localObject2).f();
    d.a((byte[])localObject1);
    for (;;)
    {
      if (m == 7) {
        return;
      }
      Object localObject6 = d.b();
      localObject1 = a((byte[])localObject6);
      Object localObject4;
      Object localObject7;
      ins localins;
      Object localObject5;
      if (((a.a & 0xF) == 0) && (l != null))
      {
        ((ilx)localObject1).b();
        localObject2 = l;
        localObject3 = ((ilx)localObject1).b();
        c += 1;
        if (c != 1) {
          break label931;
        }
        localObject4 = a;
        localObject7 = e;
        e = 4;
        localins = ((ilx)localObject1).b();
        localObject5 = new ion(j, k, l);
        if (localins != null) {
          break label395;
        }
        i1 = 1;
        label280:
        if (i1 == 0)
        {
          localObject4 = d;
          localObject5 = new ikt((byte)0);
          ((ikt)localObject5).b(localObject4.length);
          b.a(((ikt)localObject5).a());
          b.a((byte[])localObject4);
        }
        e = ((ins)localObject3);
      }
      label395:
      long l1;
      long l2;
      int i2;
      for (;;)
      {
        if (i1 != 0) {
          b("TSIG failure");
        }
        localObject2 = ((ilx)localObject1).a(1);
        if (m != 0) {
          break label1417;
        }
        i1 = ((ilx)localObject1).e();
        if (i1 == 0) {
          break label1364;
        }
        if ((g != 251) || (i1 != 4)) {
          break label1354;
        }
        c();
        break;
        if ((!g.equals(h)) || (!a.equals(i)))
        {
          if (imn.a("verbose")) {
            System.err.println("BADKEY failure");
          }
          i1 = 17;
          break label280;
        }
        l1 = System.currentTimeMillis();
        l2 = b.getTime();
        long l3 = c;
        if (Math.abs(l1 - l2) > 1000L * l3)
        {
          if (imn.a("verbose")) {
            System.err.println("BADTIME failure");
          }
          i1 = 18;
          break label280;
        }
        if ((localObject7 != null) && (e != 17) && (e != 16))
        {
          ikt localikt = new ikt((byte)0);
          localikt.b(d.length);
          ((ion)localObject5).a(localikt.a());
          ((ion)localObject5).a(d);
        }
        a.e();
        localObject7 = a.a();
        a.c(3);
        ((ion)localObject5).a((byte[])localObject7);
        i1 = d;
        i2 = localObject7.length;
        ((ion)localObject5).a((byte[])localObject6, localObject7.length, i1 - i2);
        localObject6 = new ikt((byte)0);
        g.a((ikt)localObject6);
        ((ikt)localObject6).b(i);
        ((ikt)localObject6).a(j);
        a.a((ikt)localObject6);
        l1 = b.getTime() / 1000L;
        ((ikt)localObject6).b((int)(l1 >> 32));
        ((ikt)localObject6).a(l1 & 0xFFFFFFFF);
        ((ikt)localObject6).b(c);
        ((ikt)localObject6).b(e);
        if (f != null)
        {
          ((ikt)localObject6).b(f.length);
          ((ikt)localObject6).a(f);
          label767:
          ((ion)localObject5).a(((ikt)localObject6).a());
          localObject6 = d;
          i2 = a.getDigestLength();
          if (!j.equals("md5")) {
            break label849;
          }
        }
        label849:
        for (i1 = 10;; i1 = i2 / 2)
        {
          if (localObject6.length <= i2) {
            break label856;
          }
          if (imn.a("verbose")) {
            System.err.println("BADSIG: signature too long");
          }
          i1 = 16;
          break;
          ((ikt)localObject6).b(0);
          break label767;
        }
        label856:
        if (localObject6.length < i1)
        {
          if (imn.a("verbose")) {
            System.err.println("BADSIG: signature too short");
          }
          i1 = 16;
          break label280;
        }
        if (!((ion)localObject5).a((byte[])localObject6, true))
        {
          if (imn.a("verbose")) {
            System.err.println("BADSIG: signature verification");
          }
          i1 = 16;
          break label280;
        }
        e = 1;
        i1 = 0;
        break label280;
        label931:
        if (localObject3 != null) {
          a.e();
        }
        localObject4 = a.a();
        if (localObject3 != null) {
          a.c(3);
        }
        b.a((byte[])localObject4);
        if (localObject3 == null) {}
        for (i1 = localObject6.length - localObject4.length;; i1 = d - localObject4.length)
        {
          b.a((byte[])localObject6, localObject4.length, i1);
          if (localObject3 == null) {
            break label1107;
          }
          d = c;
          e = ((ins)localObject3);
          if ((g.equals(inq.d(a))) && (a.equals(inq.e(a)))) {
            break label1156;
          }
          if (imn.a("verbose")) {
            System.err.println("BADKEY failure");
          }
          e = 4;
          i1 = 17;
          break;
        }
        label1107:
        if (c - d >= 100) {}
        for (i1 = 1;; i1 = 0)
        {
          if (i1 == 0) {
            break label1145;
          }
          e = 4;
          i1 = 1;
          break;
        }
        label1145:
        e = 2;
        i1 = 0;
        continue;
        label1156:
        localObject4 = new ikt((byte)0);
        l1 = b.getTime() / 1000L;
        ((ikt)localObject4).b((int)(l1 >> 32));
        ((ikt)localObject4).a(l1 & 0xFFFFFFFF);
        ((ikt)localObject4).b(c);
        b.a(((ikt)localObject4).a());
        if (!b.a(d, false))
        {
          if (imn.a("verbose")) {
            System.err.println("BADSIG failure");
          }
          e = 4;
          i1 = 16;
        }
        else
        {
          localObject4 = b;
          a.reset();
          a.update(b);
          localObject4 = new ikt((byte)0);
          ((ikt)localObject4).b(d.length);
          b.a(((ikt)localObject4).a());
          b.a(d);
          e = 1;
          i1 = 0;
        }
      }
      label1354:
      b(imv.a.c(i1));
      label1364:
      Object localObject3 = ((ilx)localObject1).a();
      if ((localObject3 != null) && (h != g)) {
        b("invalid question section");
      }
      if ((localObject2.length == 0) && (g == 251))
      {
        c();
        break;
      }
      label1417:
      int i1 = 0;
      if (i1 < localObject2.length)
      {
        localObject3 = localObject2[i1];
        label1432:
        i2 = h;
        switch (m)
        {
        default: 
          b("invalid state");
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (i2 != 6) {
            b("missing initial SOA");
          }
          p = ((imw)localObject3);
          n = a;
          if (g == 251)
          {
            l1 = n;
            l2 = i;
            if ((l1 < 0L) || (l1 > 4294967295L)) {
              throw new IllegalArgumentException(33 + l1 + " out of range");
            }
            if ((l2 < 0L) || (l2 > 4294967295L)) {
              throw new IllegalArgumentException(33 + l2 + " out of range");
            }
            l2 = l1 - l2;
            if (l2 >= 4294967295L) {
              l1 = l2 - 4294967296L;
            }
            for (;;)
            {
              if ((int)l1 > 0) {
                break label1708;
              }
              a("up to date");
              m = 7;
              break;
              l1 = l2;
              if (l2 < -4294967295L) {
                l1 = l2 + 4294967296L;
              }
            }
          }
          label1708:
          m = 1;
          continue;
          if ((g == 251) && (i2 == 6) && (a == i))
          {
            q = 251;
            a.b();
            a("got incremental response");
            m = 2;
            break label1432;
          }
          q = 252;
          a.a();
          a.c(p);
          a("got nonincremental response");
          m = 6;
          break label1432;
          a.a((imw)localObject3);
          m = 3;
          continue;
          if (i2 == 6)
          {
            o = a;
            m = 4;
            break label1432;
          }
          a.c((imw)localObject3);
          continue;
          a.b((imw)localObject3);
          m = 5;
          continue;
          if (i2 == 6)
          {
            l1 = a;
            if (l1 == n)
            {
              m = 7;
              continue;
            }
            if (l1 != o)
            {
              l2 = o;
              b(81 + "IXFR out of sync: expected serial " + l2 + " , got " + l1);
            }
          }
          else
          {
            a.c((imw)localObject3);
            continue;
          }
          m = 2;
          break label1432;
          if ((i2 != 1) || (i == h))
          {
            a.c((imw)localObject3);
            if (i2 == 6)
            {
              m = 7;
              continue;
              b("extra data");
            }
          }
        }
      }
      if ((m == 7) && (l != null) && (!((ilx)localObject1).c())) {
        b("last message must be signed");
      }
    }
  }
}

/* Location:
 * Qualified Name:     ioj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */