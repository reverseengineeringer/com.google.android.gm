public final class gye
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public long d = 0L;
  public int[] e = hlw.a;
  
  public gye()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int m = 0;
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(3, d);
    }
    j = i;
    if (e != null)
    {
      j = i;
      if (e.length > 0)
      {
        int k = 0;
        j = m;
        while (j < e.length)
        {
          k += hll.a(e[j]);
          j += 1;
        }
        j = i + k + e.length * 1;
      }
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
    if ((a & 0x4) != 0) {
      paramhll.a(3, d);
    }
    if ((e != null) && (e.length > 0))
    {
      int i = 0;
      while (i < e.length)
      {
        paramhll.a(4, e[i]);
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */