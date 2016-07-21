public final class gxi
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public gxj[] c = gxj.b();
  
  public gxi()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if (c != null)
    {
      j = i;
      if (c.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= c.length) {
            break;
          }
          gxj localgxj = c[k];
          j = i;
          if (localgxj != null) {
            j = i + hll.c(1, localgxj);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(2, b);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((c != null) && (c.length > 0))
    {
      int i = 0;
      while (i < c.length)
      {
        gxj localgxj = c[i];
        if (localgxj != null) {
          paramhll.a(1, localgxj);
        }
        i += 1;
      }
    }
    if ((a & 0x1) != 0) {
      paramhll.a(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */