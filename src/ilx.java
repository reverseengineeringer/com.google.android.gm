import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class ilx
  implements Cloneable
{
  private static imw[] j = new imw[0];
  private static imt[] k = new imt[0];
  ilf a;
  List[] b = new List[4];
  int c;
  int d;
  int e;
  int f;
  private inq g;
  private ins h;
  private int i;
  
  public ilx()
  {
    this(new ilf());
  }
  
  public ilx(int paramInt)
  {
    this(new ilf(paramInt));
  }
  
  private ilx(ikr paramikr)
  {
    this(new ilf(paramikr));
    boolean bool1;
    boolean bool2;
    int m;
    if (a.d() == 5)
    {
      bool1 = true;
      bool2 = a.b(6);
      m = 0;
      label39:
      if (m >= 4) {
        break label192;
      }
    }
    for (;;)
    {
      try
      {
        i1 = a.b[m];
        if (i1 <= 0) {
          break label201;
        }
        b[m] = new ArrayList(i1);
      }
      catch (iog localiog)
      {
        int i1;
        int i2;
        imw localimw;
        if (bool2) {
          break label192;
        }
        throw localiog;
      }
      if (n < i1)
      {
        i2 = b;
        localimw = imw.a(paramikr, m, bool1);
        b[m].add(localimw);
        if (m == 3)
        {
          if (h == 250) {
            d = i2;
          }
          if ((h == 24) && (a == 0)) {
            f = i2;
          }
        }
        n += 1;
        continue;
        bool1 = false;
        break;
      }
      m += 1;
      break label39;
      label192:
      c = b;
      return;
      label201:
      int n = 0;
    }
  }
  
  private ilx(ilf paramilf)
  {
    a = paramilf;
  }
  
  public ilx(byte[] paramArrayOfByte)
  {
    this(new ikr(paramArrayOfByte));
  }
  
  private final String c(int paramInt)
  {
    if (paramInt > 3) {
      return null;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    imw[] arrayOfimw = a(paramInt);
    int m = 0;
    if (m < arrayOfimw.length)
    {
      imw localimw = arrayOfimw[m];
      String str;
      if (paramInt == 0)
      {
        str = String.valueOf(g);
        localStringBuffer.append(String.valueOf(str).length() + 3 + ";;\t" + str);
        int n = h;
        str = String.valueOf(inx.a.c(n));
        if (str.length() != 0)
        {
          str = ", type = ".concat(str);
          label123:
          localStringBuffer.append(str);
          n = i;
          str = String.valueOf(ikm.a.c(n));
          if (str.length() == 0) {
            break label203;
          }
          str = ", class = ".concat(str);
          label166:
          localStringBuffer.append(str);
        }
      }
      for (;;)
      {
        localStringBuffer.append("\n");
        m += 1;
        break;
        str = new String(", type = ");
        break label123;
        label203:
        str = new String(", class = ");
        break label166;
        localStringBuffer.append(localimw);
      }
    }
    return localStringBuffer.toString();
  }
  
  public final imw a()
  {
    List localList = b[0];
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    return (imw)localList.get(0);
  }
  
  public final void a(imw paramimw, int paramInt)
  {
    if (b[paramInt] == null) {
      b[paramInt] = new LinkedList();
    }
    a.c(paramInt);
    b[paramInt].add(paramimw);
  }
  
  public final imw[] a(int paramInt)
  {
    if (b[paramInt] == null) {
      return j;
    }
    List localList = b[paramInt];
    return (imw[])localList.toArray(new imw[localList.size()]);
  }
  
  public final ins b()
  {
    int m = a.b[3];
    if (m == 0) {
      return null;
    }
    imw localimw = (imw)b[3].get(m - 1);
    if (h != 250) {
      return null;
    }
    return (ins)localimw;
  }
  
  public final imt[] b(int paramInt)
  {
    if (b[paramInt] == null) {
      return k;
    }
    LinkedList localLinkedList = new LinkedList();
    imw[] arrayOfimw = a(paramInt);
    HashSet localHashSet = new HashSet();
    paramInt = 0;
    imj localimj;
    if (paramInt < arrayOfimw.length)
    {
      localimj = g;
      if (!localHashSet.contains(localimj)) {
        break label220;
      }
      m = localLinkedList.size() - 1;
      label76:
      if (m < 0) {
        break label220;
      }
      imt localimt = (imt)localLinkedList.get(m);
      if ((localimt.e().e() == arrayOfimw[paramInt].e()) && (ei == i) && (eg.equals(localimj))) {
        localimt.a(arrayOfimw[paramInt]);
      }
    }
    label220:
    for (int m = 0;; m = 1)
    {
      if (m != 0)
      {
        localLinkedList.add(new imt(arrayOfimw[paramInt]));
        localHashSet.add(localimj);
      }
      paramInt += 1;
      break;
      m -= 1;
      break label76;
      return (imt[])localLinkedList.toArray(new imt[localLinkedList.size()]);
    }
  }
  
  public final boolean c()
  {
    return e == 1;
  }
  
  public final Object clone()
  {
    ilx localilx = new ilx();
    int m = 0;
    while (m < b.length)
    {
      if (b[m] != null) {
        b[m] = new LinkedList(b[m]);
      }
      m += 1;
    }
    a = ((ilf)a.clone());
    c = c;
    return localilx;
  }
  
  public final iml d()
  {
    imw[] arrayOfimw = a(3);
    int m = 0;
    while (m < arrayOfimw.length)
    {
      if ((arrayOfimw[m] instanceof iml)) {
        return (iml)arrayOfimw[m];
      }
      m += 1;
    }
    return null;
  }
  
  public final int e()
  {
    int n = a.a & 0xF;
    iml localiml = d();
    int m = n;
    if (localiml != null) {
      m = n + (localiml.d() << 4);
    }
    return m;
  }
  
  public final byte[] f()
  {
    ikt localikt = new ikt((byte)0);
    int m = 65535;
    if (g != null)
    {
      localObject1 = g;
      m = h.c();
      m = 65535 - (i.c() + (m + 10) + 8 + 18 + 4 + 8);
    }
    Object localObject1 = d();
    Object localObject2 = null;
    if (localObject1 != null)
    {
      localObject2 = new ikt((byte)0);
      ((imw)localObject1).a((ikt)localObject2, 3, null);
      localObject2 = ((ikt)localObject2).a();
    }
    for (int i4 = m - localObject2.length;; i4 = m)
    {
      int i8 = a;
      a.a(localikt);
      ikk localikk = new ikk();
      int i7 = a.a;
      m = 0;
      int i5 = 0;
      int i9;
      int i1;
      int i2;
      int n;
      int i3;
      label196:
      int i6;
      imw localimw;
      if (i5 < 4)
      {
        if (b[i5] == null) {
          break label619;
        }
        i9 = b[i5].size();
        i1 = a;
        i2 = 0;
        n = 0;
        localObject1 = null;
        i3 = 0;
        i6 = n;
        if (i3 < i9)
        {
          localimw = (imw)b[i5].get(i3);
          if ((i5 == 3) && ((localimw instanceof iml))) {
            n += 1;
          }
        }
      }
      for (;;)
      {
        i3 += 1;
        break label196;
        if (localObject1 != null) {
          if ((localimw.e() == ((imw)localObject1).e()) && (i == i) && (g.equals(g)))
          {
            i6 = 1;
            label302:
            if (i6 != 0) {
              break label622;
            }
            i1 = a;
            i2 = i3;
          }
        }
        label619:
        label622:
        for (;;)
        {
          localimw.a(localikt, i5, localikk);
          if (a <= i4) {
            break label625;
          }
          if (i1 > a)
          {
            throw new IllegalArgumentException("cannot jump past end of data");
            i6 = 0;
            break label302;
          }
          a = i1;
          i6 = n + (i9 - i2);
          if ((i6 != 0) && (i5 != 3))
          {
            i2 = ilf.a(i7, 6);
            localikt.a(a.b[i5] - i6, i8 + 4 + i5 * 2);
            i1 = i5 + 1;
            for (;;)
            {
              n = i2;
              if (i1 >= 3) {
                break;
              }
              localikt.a(0, i8 + 4 + i1 * 2);
              i1 += 1;
            }
          }
          if (i5 == 3) {
            m = a.b[i5] - i6;
          }
          for (;;)
          {
            i5 += 1;
            break;
            n = i7;
            i1 = m;
            if (localObject2 != null)
            {
              localikt.a((byte[])localObject2);
              i1 = m + 1;
            }
            if (n != a.a) {
              localikt.a(n, i8 + 2);
            }
            if (i1 != a.b[3]) {
              localikt.a(i1, i8 + 10);
            }
            if (g != null)
            {
              g.a(this, localikt.a(), i, h).a(localikt, 3, localikk);
              localikt.a(i1 + 1, i8 + 10);
            }
            c = a;
            return localikt.a();
          }
        }
        label625:
        localObject1 = localimw;
      }
    }
  }
  
  public final String toString()
  {
    int n = 1;
    int i1 = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    label75:
    label106:
    label116:
    String str;
    if (d() != null)
    {
      localStringBuffer.append(String.valueOf(a.d(e())).concat("\n"));
      m = n;
      if (e != 3)
      {
        m = n;
        if (e != 1)
        {
          if (e != 4) {
            break label263;
          }
          m = n;
        }
      }
      n = i1;
      if (m != 0)
      {
        localStringBuffer.append(";; TSIG ");
        if (!c()) {
          break label268;
        }
        localStringBuffer.append("ok");
        localStringBuffer.append('\n');
        n = i1;
      }
      if (n >= 4) {
        break label340;
      }
      if (a.d() == 5) {
        break label280;
      }
      ini.a.a(n);
      str = ini.b[n];
      localStringBuffer.append(String.valueOf(str).length() + 5 + ";; " + str + ":\n");
    }
    for (;;)
    {
      localStringBuffer.append(String.valueOf(c(n)).concat("\n"));
      n += 1;
      break label116;
      str = String.valueOf(a);
      localStringBuffer.append(String.valueOf(str).length() + 1 + str + "\n");
      break;
      label263:
      m = 0;
      break label75;
      label268:
      localStringBuffer.append("invalid");
      break label106;
      label280:
      ini.a.a(n);
      str = ini.c[n];
      localStringBuffer.append(String.valueOf(str).length() + 5 + ";; " + str + ":\n");
    }
    label340:
    int m = c;
    localStringBuffer.append(34 + ";; Message size: " + m + " bytes");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ilx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */