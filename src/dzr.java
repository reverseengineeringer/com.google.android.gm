public final class dzr
  extends hlt
{
  public long a = 0L;
  public String b = "";
  public String c = "";
  public String d = "";
  public long e = 0L;
  public boolean f = false;
  public boolean g = false;
  public dzx[] h = dzx.b();
  public String i = "";
  public dzu[] j = dzu.b();
  public int k = 0;
  public String l = "";
  
  public dzr()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i2 = 0;
    int n = super.a();
    int m = n;
    if (a != 0L) {
      m = n + hll.c(1, a);
    }
    n = m;
    if (!b.equals("")) {
      n = m + hll.b(2, b);
    }
    m = n;
    if (!d.equals("")) {
      m = n + hll.b(3, d);
    }
    n = m;
    if (e != 0L) {
      n = m + hll.c(4, e);
    }
    int i1 = n;
    if (f) {
      i1 = n + (hll.b(5) + 1);
    }
    m = i1;
    if (g) {
      m = i1 + (hll.b(6) + 1);
    }
    n = m;
    Object localObject;
    if (h != null)
    {
      n = m;
      if (h.length > 0)
      {
        n = 0;
        while (n < h.length)
        {
          localObject = h[n];
          i1 = m;
          if (localObject != null) {
            i1 = m + hll.d(7, (hlt)localObject);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    m = n;
    if (!i.equals("")) {
      m = n + hll.b(8, i);
    }
    n = m;
    if (j != null)
    {
      n = m;
      if (j.length > 0)
      {
        i1 = i2;
        for (;;)
        {
          n = m;
          if (i1 >= j.length) {
            break;
          }
          localObject = j[i1];
          n = m;
          if (localObject != null) {
            n = m + hll.d(9, (hlt)localObject);
          }
          i1 += 1;
          m = n;
        }
      }
    }
    m = n;
    if (!l.equals("")) {
      m = n + hll.b(10, l);
    }
    n = m;
    if (!c.equals("")) {
      n = m + hll.b(11, c);
    }
    m = n;
    if (k != 0) {
      m = n + hll.c(12, k);
    }
    return m;
  }
  
  public final void a(hll paramhll)
  {
    int n = 0;
    if (a != 0L) {
      paramhll.a(1, a);
    }
    if (!b.equals("")) {
      paramhll.a(2, b);
    }
    if (!d.equals("")) {
      paramhll.a(3, d);
    }
    if (e != 0L) {
      paramhll.a(4, e);
    }
    if (f) {
      paramhll.a(5, f);
    }
    if (g) {
      paramhll.a(6, g);
    }
    int m;
    Object localObject;
    if ((h != null) && (h.length > 0))
    {
      m = 0;
      while (m < h.length)
      {
        localObject = h[m];
        if (localObject != null) {
          paramhll.b(7, (hlt)localObject);
        }
        m += 1;
      }
    }
    if (!i.equals("")) {
      paramhll.a(8, i);
    }
    if ((j != null) && (j.length > 0))
    {
      m = n;
      while (m < j.length)
      {
        localObject = j[m];
        if (localObject != null) {
          paramhll.b(9, (hlt)localObject);
        }
        m += 1;
      }
    }
    if (!l.equals("")) {
      paramhll.a(10, l);
    }
    if (!c.equals("")) {
      paramhll.a(11, c);
    }
    if (k != 0) {
      paramhll.a(12, k);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */