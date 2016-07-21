public final class gzh
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public boolean d = false;
  public long e = 0L;
  public gzi[] f = gzi.b();
  public long g = 0L;
  
  public gzh()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(2, c);
    }
    int k = j;
    if ((a & 0x4) != 0) {
      k = j + (hll.b(3) + 1);
    }
    i = k;
    if ((a & 0x8) != 0) {
      i = k + hll.c(4, e);
    }
    j = i;
    if (f != null)
    {
      j = i;
      if (f.length > 0)
      {
        j = 0;
        while (j < f.length)
        {
          gzi localgzi = f[j];
          k = i;
          if (localgzi != null) {
            k = i + hll.c(5, localgzi);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((a & 0x10) != 0) {
      i = j + hll.c(6, g);
    }
    return i;
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
    if ((a & 0x8) != 0) {
      paramhll.a(4, e);
    }
    if ((f != null) && (f.length > 0))
    {
      int i = 0;
      while (i < f.length)
      {
        gzi localgzi = f[i];
        if (localgzi != null) {
          paramhll.a(5, localgzi);
        }
        i += 1;
      }
    }
    if ((a & 0x10) != 0) {
      paramhll.a(6, g);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */