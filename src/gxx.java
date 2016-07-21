public final class gxx
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public gxy[] d = gxy.b();
  
  public gxx()
  {
    E = -1;
  }
  
  protected final int a()
  {
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
        j = 0;
        while (j < d.length)
        {
          gxy localgxy = d[j];
          int k = i;
          if (localgxy != null) {
            k = i + hll.c(3, localgxy);
          }
          j += 1;
          i = k;
        }
        j = i;
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
    if ((d != null) && (d.length > 0))
    {
      int i = 0;
      while (i < d.length)
      {
        gxy localgxy = d[i];
        if (localgxy != null) {
          paramhll.a(3, localgxy);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */