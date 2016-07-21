public final class hkd
  extends hln<hkd>
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int[] d = hlw.a;
  public int e = 0;
  private int f = 0;
  
  public hkd()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int i = super.a();
    int j = i;
    if ((a & 0x1) != 0) {
      j = i + hll.c(1, b);
    }
    i = j;
    if ((a & 0x2) != 0) {
      i = j + hll.c(2, c);
    }
    j = i;
    if (d != null)
    {
      j = i;
      if (d.length > 0)
      {
        int k = 0;
        j = m;
        while (j < d.length)
        {
          k += hll.a(d[j]);
          j += 1;
        }
        j = i + k + d.length * 1;
      }
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(4, e);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.c(7, f);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((d != null) && (d.length > 0))
    {
      int i = 0;
      while (i < d.length)
      {
        paramhll.a(3, d[i]);
        i += 1;
      }
    }
    if ((a & 0x4) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(7, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */