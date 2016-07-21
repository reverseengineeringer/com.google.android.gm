public final class hra
  extends hln<hra>
{
  private static volatile hra[] l;
  public String a = null;
  public String b = null;
  public Integer c = null;
  public Integer d = null;
  public Integer e = null;
  public Integer f = null;
  public Integer g = null;
  public int h = Integer.MIN_VALUE;
  public hrg[] i = hrg.b();
  public hql j;
  public hqz k;
  
  public hra()
  {
    E = -1;
  }
  
  public static hra[] b()
  {
    if (l == null) {}
    synchronized (hlr.c)
    {
      if (l == null) {
        l = new hra[0];
      }
      return l;
    }
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if (a != null) {
      m = n + hll.b(1, a);
    }
    n = m;
    if (b != null) {
      n = m + hll.b(2, b);
    }
    m = n;
    if (c != null) {
      m = n + hll.c(3, c.intValue());
    }
    n = m;
    if (d != null) {
      n = m + hll.c(4, d.intValue());
    }
    m = n;
    if (e != null) {
      m = n + hll.c(5, e.intValue());
    }
    n = m;
    if (f != null) {
      n = m + hll.d(6, f.intValue());
    }
    int i1 = n;
    if (g != null) {
      i1 = n + hll.d(7, g.intValue());
    }
    m = i1;
    if (h != Integer.MIN_VALUE) {
      m = i1 + hll.c(8, h);
    }
    n = m;
    if (i != null)
    {
      n = m;
      if (i.length > 0)
      {
        n = 0;
        while (n < i.length)
        {
          hrg localhrg = i[n];
          i1 = m;
          if (localhrg != null) {
            i1 = m + hll.d(9, localhrg);
          }
          n += 1;
          m = i1;
        }
        n = m;
      }
    }
    m = n;
    if (j != null) {
      m = n + hll.d(10, j);
    }
    n = m;
    if (k != null) {
      n = m + hll.d(11, k);
    }
    return n;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a);
    }
    if (b != null) {
      paramhll.a(2, b);
    }
    if (c != null) {
      paramhll.a(3, c.intValue());
    }
    if (d != null) {
      paramhll.a(4, d.intValue());
    }
    if (e != null) {
      paramhll.a(5, e.intValue());
    }
    if (f != null) {
      paramhll.b(6, f.intValue());
    }
    if (g != null) {
      paramhll.b(7, g.intValue());
    }
    if (h != Integer.MIN_VALUE) {
      paramhll.a(8, h);
    }
    if ((i != null) && (i.length > 0))
    {
      int m = 0;
      while (m < i.length)
      {
        hrg localhrg = i[m];
        if (localhrg != null) {
          paramhll.b(9, localhrg);
        }
        m += 1;
      }
    }
    if (j != null) {
      paramhll.b(10, j);
    }
    if (k != null) {
      paramhll.b(11, k);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */