import java.util.Arrays;

public final class fmy
  extends fml<fmy>
{
  public long a = 0L;
  public long b = 0L;
  public String c = "";
  public int d = 0;
  public int e = 0;
  public boolean h = false;
  public fmz[] i = fmz.e();
  public fmw j = null;
  public byte[] k = fmt.h;
  public byte[] l = fmt.h;
  public byte[] m = fmt.h;
  public fmv n = null;
  public String o = "";
  public long p = 180000L;
  public fmx q = null;
  public byte[] r = fmt.h;
  public int s = 0;
  public int[] t = fmt.a;
  
  public fmy()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    int i4 = 0;
    int i1 = super.a();
    int i2 = i1;
    if (a != 0L) {
      i2 = i1 + fmj.c(1, a);
    }
    i1 = i2;
    if (!c.equals("")) {
      i1 = i2 + fmj.b(2, c);
    }
    i2 = i1;
    if (i != null)
    {
      i2 = i1;
      if (i.length > 0)
      {
        i2 = 0;
        while (i2 < i.length)
        {
          fmz localfmz = i[i2];
          i3 = i1;
          if (localfmz != null) {
            i3 = i1 + fmj.b(3, localfmz);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if (!Arrays.equals(k, fmt.h)) {
      i1 = i2 + fmj.b(6, k);
    }
    i2 = i1;
    if (n != null) {
      i2 = i1 + fmj.b(7, n);
    }
    i1 = i2;
    if (!Arrays.equals(l, fmt.h)) {
      i1 = i2 + fmj.b(8, l);
    }
    i2 = i1;
    if (j != null) {
      i2 = i1 + fmj.b(9, j);
    }
    i1 = i2;
    if (h) {
      i1 = i2 + (fmj.b(10) + 1);
    }
    i2 = i1;
    if (d != 0) {
      i2 = i1 + fmj.b(11, d);
    }
    i1 = i2;
    if (e != 0) {
      i1 = i2 + fmj.b(12, e);
    }
    i2 = i1;
    if (!Arrays.equals(m, fmt.h)) {
      i2 = i1 + fmj.b(13, m);
    }
    i1 = i2;
    if (!o.equals("")) {
      i1 = i2 + fmj.b(14, o);
    }
    i2 = i1;
    if (p != 180000L) {
      i2 = i1 + fmj.d(15, p);
    }
    i1 = i2;
    if (q != null) {
      i1 = i2 + fmj.b(16, q);
    }
    i2 = i1;
    if (b != 0L) {
      i2 = i1 + fmj.c(17, b);
    }
    int i3 = i2;
    if (!Arrays.equals(r, fmt.h)) {
      i3 = i2 + fmj.b(18, r);
    }
    i1 = i3;
    if (s != 0) {
      i1 = i3 + fmj.b(19, s);
    }
    i2 = i1;
    if (t != null)
    {
      i2 = i1;
      if (t.length > 0)
      {
        i3 = 0;
        i2 = i4;
        while (i2 < t.length)
        {
          i3 += fmj.a(t[i2]);
          i2 += 1;
        }
        i2 = i1 + i3 + t.length * 2;
      }
    }
    return i2;
  }
  
  public final void a(fmj paramfmj)
  {
    int i2 = 0;
    if (a != 0L) {
      paramfmj.a(1, a);
    }
    if (!c.equals("")) {
      paramfmj.a(2, c);
    }
    int i1;
    if ((i != null) && (i.length > 0))
    {
      i1 = 0;
      while (i1 < i.length)
      {
        fmz localfmz = i[i1];
        if (localfmz != null) {
          paramfmj.a(3, localfmz);
        }
        i1 += 1;
      }
    }
    if (!Arrays.equals(k, fmt.h)) {
      paramfmj.a(6, k);
    }
    if (n != null) {
      paramfmj.a(7, n);
    }
    if (!Arrays.equals(l, fmt.h)) {
      paramfmj.a(8, l);
    }
    if (j != null) {
      paramfmj.a(9, j);
    }
    if (h) {
      paramfmj.a(10, h);
    }
    if (d != 0) {
      paramfmj.a(11, d);
    }
    if (e != 0) {
      paramfmj.a(12, e);
    }
    if (!Arrays.equals(m, fmt.h)) {
      paramfmj.a(13, m);
    }
    if (!o.equals("")) {
      paramfmj.a(14, o);
    }
    if (p != 180000L) {
      paramfmj.b(15, p);
    }
    if (q != null) {
      paramfmj.a(16, q);
    }
    if (b != 0L) {
      paramfmj.a(17, b);
    }
    if (!Arrays.equals(r, fmt.h)) {
      paramfmj.a(18, r);
    }
    if (s != 0) {
      paramfmj.a(19, s);
    }
    if ((t != null) && (t.length > 0))
    {
      i1 = i2;
      while (i1 < t.length)
      {
        paramfmj.a(20, t[i1]);
        i1 += 1;
      }
    }
    super.a(paramfmj);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    label69:
    label140:
    label204:
    label220:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return bool1;
                                    bool1 = bool2;
                                  } while (!(paramObject instanceof fmy));
                                  paramObject = (fmy)paramObject;
                                  bool1 = bool2;
                                } while (a != a);
                                bool1 = bool2;
                              } while (b != b);
                              if (c != null) {
                                break;
                              }
                              bool1 = bool2;
                            } while (c != null);
                            bool1 = bool2;
                          } while (d != d);
                          bool1 = bool2;
                        } while (e != e);
                        bool1 = bool2;
                      } while (h != h);
                      bool1 = bool2;
                    } while (!fmp.a(i, i));
                    if (j != null) {
                      break label317;
                    }
                    bool1 = bool2;
                  } while (j != null);
                  bool1 = bool2;
                } while (!Arrays.equals(k, k));
                bool1 = bool2;
              } while (!Arrays.equals(l, l));
              bool1 = bool2;
            } while (!Arrays.equals(m, m));
            if (n != null) {
              break label333;
            }
            bool1 = bool2;
          } while (n != null);
          if (o != null) {
            break label349;
          }
          bool1 = bool2;
        } while (o != null);
        bool1 = bool2;
      } while (p != p);
      if (q != null) {
        break label365;
      }
      bool1 = bool2;
    } while (q != null);
    label317:
    label333:
    label349:
    label365:
    while (q.equals(q))
    {
      bool1 = bool2;
      if (!Arrays.equals(r, r)) {
        break;
      }
      bool1 = bool2;
      if (s != s) {
        break;
      }
      bool1 = bool2;
      if (!fmp.a(t, t)) {
        break;
      }
      return a((fml)paramObject);
      if (c.equals(c)) {
        break label69;
      }
      return false;
      if (j.equals(j)) {
        break label140;
      }
      return false;
      if (n.equals(n)) {
        break label204;
      }
      return false;
      if (o.equals(o)) {
        break label220;
      }
      return false;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i6 = 0;
    int i7 = (int)(a ^ a >>> 32);
    int i8 = (int)(b ^ b >>> 32);
    int i1;
    int i9;
    int i10;
    int i2;
    label65:
    int i11;
    int i3;
    label83:
    int i12;
    int i13;
    int i14;
    int i4;
    label120:
    int i5;
    label130:
    int i15;
    if (c == null)
    {
      i1 = 0;
      i9 = d;
      i10 = e;
      if (!h) {
        break label289;
      }
      i2 = 1231;
      i11 = fmp.a(i);
      if (j != null) {
        break label296;
      }
      i3 = 0;
      i12 = Arrays.hashCode(k);
      i13 = Arrays.hashCode(l);
      i14 = Arrays.hashCode(m);
      if (n != null) {
        break label307;
      }
      i4 = 0;
      if (o != null) {
        break label319;
      }
      i5 = 0;
      i15 = (int)(p ^ p >>> 32);
      if (q != null) {
        break label331;
      }
    }
    for (;;)
    {
      return ((((((i5 + (i4 + ((((i3 + ((i2 + (((i1 + ((i7 + 527) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31) * 31 + i11) * 31) * 31 + i12) * 31 + i13) * 31 + i14) * 31) * 31) * 31 + i15) * 31 + i6) * 31 + Arrays.hashCode(r)) * 31 + s) * 31 + fmp.a(t)) * 31 + b();
      i1 = c.hashCode();
      break;
      label289:
      i2 = 1237;
      break label65;
      label296:
      i3 = j.hashCode();
      break label83;
      label307:
      i4 = n.hashCode();
      break label120;
      label319:
      i5 = o.hashCode();
      break label130;
      label331:
      i6 = q.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     fmy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */