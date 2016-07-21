public final class dzu
  extends hlt
{
  private static volatile dzu[] o;
  public String a = "";
  public String b = "";
  public long c = 0L;
  public String d = "";
  public String e = "";
  public boolean f = false;
  public boolean g = false;
  public String[] h = hlw.f;
  public String[] i = hlw.f;
  public String[] j = hlw.f;
  public String[] k = hlw.f;
  public String l = "";
  public dzp[] m = dzp.b();
  public boolean n = false;
  
  public dzu()
  {
    E = -1;
  }
  
  public static dzu[] b()
  {
    if (o == null) {}
    synchronized (hlr.c)
    {
      if (o == null) {
        o = new dzu[0];
      }
      return o;
    }
  }
  
  protected final int a()
  {
    int i7 = 0;
    int i2 = super.a();
    int i1 = i2;
    if (!a.equals("")) {
      i1 = i2 + hll.b(1, a);
    }
    i2 = i1;
    if (!b.equals("")) {
      i2 = i1 + hll.b(2, b);
    }
    i1 = i2;
    if (c != 0L) {
      i1 = i2 + hll.c(3, c);
    }
    i2 = i1;
    if (!d.equals("")) {
      i2 = i1 + hll.b(4, d);
    }
    i1 = i2;
    if (!e.equals("")) {
      i1 = i2 + hll.b(5, e);
    }
    i2 = i1;
    if (f) {
      i2 = i1 + (hll.b(6) + 1);
    }
    i1 = i2;
    if (g) {
      i1 = i2 + (hll.b(7) + 1);
    }
    i2 = i1;
    int i4;
    Object localObject;
    int i6;
    int i5;
    if (j != null)
    {
      i2 = i1;
      if (j.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0; i2 < j.length; i4 = i5)
        {
          localObject = j[i2];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a((String)localObject);
          }
          i2 += 1;
          i3 = i6;
        }
        i2 = i1 + i3 + i4 * 1;
      }
    }
    int i3 = i2;
    if (k != null)
    {
      i3 = i2;
      if (k.length > 0)
      {
        i1 = 0;
        i3 = 0;
        for (i4 = 0; i1 < k.length; i4 = i5)
        {
          localObject = k[i1];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a((String)localObject);
          }
          i1 += 1;
          i3 = i6;
        }
        i3 = i2 + i3 + i4 * 1;
      }
    }
    i1 = i3;
    if (!l.equals("")) {
      i1 = i3 + hll.b(10, l);
    }
    i2 = i1;
    if (h != null)
    {
      i2 = i1;
      if (h.length > 0)
      {
        i2 = 0;
        i3 = 0;
        for (i4 = 0; i2 < h.length; i4 = i5)
        {
          localObject = h[i2];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a((String)localObject);
          }
          i2 += 1;
          i3 = i6;
        }
        i2 = i1 + i3 + i4 * 1;
      }
    }
    i1 = i2;
    if (i != null)
    {
      i1 = i2;
      if (i.length > 0)
      {
        i1 = 0;
        i3 = 0;
        for (i4 = 0; i1 < i.length; i4 = i5)
        {
          localObject = i[i1];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a((String)localObject);
          }
          i1 += 1;
          i3 = i6;
        }
        i1 = i2 + i3 + i4 * 1;
      }
    }
    i2 = i1;
    if (m != null)
    {
      i2 = i1;
      if (m.length > 0)
      {
        i3 = i7;
        for (;;)
        {
          i2 = i1;
          if (i3 >= m.length) {
            break;
          }
          localObject = m[i3];
          i2 = i1;
          if (localObject != null) {
            i2 = i1 + hll.d(13, (hlt)localObject);
          }
          i3 += 1;
          i1 = i2;
        }
      }
    }
    i1 = i2;
    if (n) {
      i1 = i2 + (hll.b(14) + 1);
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    int i2 = 0;
    if (!a.equals("")) {
      paramhll.a(1, a);
    }
    if (!b.equals("")) {
      paramhll.a(2, b);
    }
    if (c != 0L) {
      paramhll.a(3, c);
    }
    if (!d.equals("")) {
      paramhll.a(4, d);
    }
    if (!e.equals("")) {
      paramhll.a(5, e);
    }
    if (f) {
      paramhll.a(6, f);
    }
    if (g) {
      paramhll.a(7, g);
    }
    int i1;
    Object localObject;
    if ((j != null) && (j.length > 0))
    {
      i1 = 0;
      while (i1 < j.length)
      {
        localObject = j[i1];
        if (localObject != null) {
          paramhll.a(8, (String)localObject);
        }
        i1 += 1;
      }
    }
    if ((k != null) && (k.length > 0))
    {
      i1 = 0;
      while (i1 < k.length)
      {
        localObject = k[i1];
        if (localObject != null) {
          paramhll.a(9, (String)localObject);
        }
        i1 += 1;
      }
    }
    if (!l.equals("")) {
      paramhll.a(10, l);
    }
    if ((h != null) && (h.length > 0))
    {
      i1 = 0;
      while (i1 < h.length)
      {
        localObject = h[i1];
        if (localObject != null) {
          paramhll.a(11, (String)localObject);
        }
        i1 += 1;
      }
    }
    if ((i != null) && (i.length > 0))
    {
      i1 = 0;
      while (i1 < i.length)
      {
        localObject = i[i1];
        if (localObject != null) {
          paramhll.a(12, (String)localObject);
        }
        i1 += 1;
      }
    }
    if ((m != null) && (m.length > 0))
    {
      i1 = i2;
      while (i1 < m.length)
      {
        localObject = m[i1];
        if (localObject != null) {
          paramhll.b(13, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if (n) {
      paramhll.a(14, n);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */