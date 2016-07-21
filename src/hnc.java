public final class hnc
  extends hln<hnc>
{
  public int a = 0;
  public hoc b = null;
  public String c = "";
  public hnd[] d = hnd.b();
  private String e = "";
  private String f = "";
  private String g = "";
  
  public hnc()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if (b != null) {
      j = i + hll.d(1, b);
    }
    i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(2, c);
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
          hnd localhnd = d[j];
          int k = i;
          if (localhnd != null) {
            k = i + hll.d(3, localhnd);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((a & 0x2) != 0) {
      i = j + hll.b(4, e);
    }
    j = i;
    if ((a & 0x4) != 0) {
      j = i + hll.b(5, f);
    }
    i = j;
    if ((a & 0x8) != 0) {
      i = j + hll.b(6, g);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (b != null) {
      paramhll.b(1, b);
    }
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((d != null) && (d.length > 0))
    {
      int i = 0;
      while (i < d.length)
      {
        hnd localhnd = d[i];
        if (localhnd != null) {
          paramhll.b(3, localhnd);
        }
        i += 1;
      }
    }
    if ((a & 0x2) != 0) {
      paramhll.a(4, e);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(5, f);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(6, g);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */