public final class gxp
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String[] i = hlw.f;
  public gxq[] j = gxq.b();
  public boolean k = false;
  public boolean l = false;
  public int m = 0;
  public boolean n = false;
  public String o = "";
  public String p = "";
  public String q = "";
  public String[] r = hlw.f;
  public String s = "";
  private boolean t = false;
  private boolean u = false;
  
  public gxp()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i7 = 0;
    int i2 = super.a();
    int i1 = i2;
    if ((a & 0x1) != 0) {
      i1 = i2 + hll.c(1, b);
    }
    i2 = i1;
    if ((a & 0x2) != 0) {
      i2 = i1 + hll.c(2, c);
    }
    i1 = i2;
    if ((a & 0x4) != 0) {
      i1 = i2 + hll.b(3, d);
    }
    i2 = i1;
    if ((a & 0x8) != 0) {
      i2 = i1 + hll.b(4, e);
    }
    i1 = i2;
    if ((a & 0x10) != 0) {
      i1 = i2 + hll.b(5, f);
    }
    int i3 = i1;
    if ((a & 0x20) != 0) {
      i3 = i1 + hll.b(6, g);
    }
    i2 = i3;
    if ((a & 0x40) != 0) {
      i2 = i3 + hll.b(7, h);
    }
    i1 = i2;
    int i4;
    Object localObject;
    int i6;
    int i5;
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
    if (j != null)
    {
      i2 = i1;
      if (j.length > 0)
      {
        i2 = 0;
        while (i2 < j.length)
        {
          localObject = j[i2];
          i3 = i1;
          if (localObject != null) {
            i3 = i1 + hll.c(9, (hlt)localObject);
          }
          i2 += 1;
          i1 = i3;
        }
        i2 = i1;
      }
    }
    i1 = i2;
    if ((a & 0x80) != 0) {
      i1 = i2 + (hll.b(10) + 1);
    }
    i2 = i1;
    if ((a & 0x100) != 0) {
      i2 = i1 + (hll.b(11) + 1);
    }
    i1 = i2;
    if ((a & 0x200) != 0) {
      i1 = i2 + (hll.b(12) + 1);
    }
    i2 = i1;
    if ((a & 0x400) != 0) {
      i2 = i1 + hll.c(13, m);
    }
    i1 = i2;
    if ((a & 0x800) != 0) {
      i1 = i2 + (hll.b(14) + 1);
    }
    i2 = i1;
    if ((a & 0x1000) != 0) {
      i2 = i1 + hll.b(15, o);
    }
    i3 = i2;
    if ((a & 0x2000) != 0) {
      i3 = i2 + hll.b(16, p);
    }
    i1 = i3;
    if ((a & 0x4000) != 0) {
      i1 = i3 + hll.b(17, q);
    }
    i2 = i1;
    if (r != null)
    {
      i2 = i1;
      if (r.length > 0)
      {
        i3 = 0;
        i4 = 0;
        i2 = i7;
        while (i2 < r.length)
        {
          localObject = r[i2];
          i6 = i3;
          i5 = i4;
          if (localObject != null)
          {
            i5 = i4 + 1;
            i6 = i3 + hll.a((String)localObject);
          }
          i2 += 1;
          i3 = i6;
          i4 = i5;
        }
        i2 = i1 + i3 + i4 * 2;
      }
    }
    i1 = i2;
    if ((a & 0x8000) != 0) {
      i1 = i2 + (hll.b(19) + 1);
    }
    i2 = i1;
    if ((a & 0x10000) != 0) {
      i2 = i1 + hll.b(20, s);
    }
    return i2;
  }
  
  public final gxp a(boolean paramBoolean)
  {
    t = paramBoolean;
    a |= 0x100;
    return this;
  }
  
  public final void a(hll paramhll)
  {
    int i2 = 0;
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, d);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x10) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x20) != 0) {
      paramhll.a(6, g);
    }
    if ((a & 0x40) != 0) {
      paramhll.a(7, h);
    }
    int i1;
    Object localObject;
    if ((i != null) && (i.length > 0))
    {
      i1 = 0;
      while (i1 < i.length)
      {
        localObject = i[i1];
        if (localObject != null) {
          paramhll.a(8, (String)localObject);
        }
        i1 += 1;
      }
    }
    if ((j != null) && (j.length > 0))
    {
      i1 = 0;
      while (i1 < j.length)
      {
        localObject = j[i1];
        if (localObject != null) {
          paramhll.a(9, (hlt)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x80) != 0) {
      paramhll.a(10, k);
    }
    if ((a & 0x100) != 0) {
      paramhll.a(11, t);
    }
    if ((a & 0x200) != 0) {
      paramhll.a(12, l);
    }
    if ((a & 0x400) != 0) {
      paramhll.a(13, m);
    }
    if ((a & 0x800) != 0) {
      paramhll.a(14, n);
    }
    if ((a & 0x1000) != 0) {
      paramhll.a(15, o);
    }
    if ((a & 0x2000) != 0) {
      paramhll.a(16, p);
    }
    if ((a & 0x4000) != 0) {
      paramhll.a(17, q);
    }
    if ((r != null) && (r.length > 0))
    {
      i1 = i2;
      while (i1 < r.length)
      {
        localObject = r[i1];
        if (localObject != null) {
          paramhll.a(18, (String)localObject);
        }
        i1 += 1;
      }
    }
    if ((a & 0x8000) != 0) {
      paramhll.a(19, u);
    }
    if ((a & 0x10000) != 0) {
      paramhll.a(20, s);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */