public final class gxc
  extends hlt
{
  private static volatile gxc[] e;
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public long[] d = hlw.b;
  
  public gxc()
  {
    E = -1;
  }
  
  public static gxc[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new gxc[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int k = 0;
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
    if (d != null)
    {
      i = j;
      if (d.length > 0)
      {
        int m = 0;
        if (k < d.length)
        {
          long l = d[k];
          if ((0xFFFFFFFFFFFFFF80 & l) == 0L) {
            i = 1;
          }
          for (;;)
          {
            m += i;
            k += 1;
            break;
            if ((0xFFFFFFFFFFFFC000 & l) == 0L) {
              i = 2;
            } else if ((0xFFFFFFFFFFE00000 & l) == 0L) {
              i = 3;
            } else if ((0xFFFFFFFFF0000000 & l) == 0L) {
              i = 4;
            } else if ((0xFFFFFFF800000000 & l) == 0L) {
              i = 5;
            } else if ((0xFFFFFC0000000000 & l) == 0L) {
              i = 6;
            } else if ((0xFFFE000000000000 & l) == 0L) {
              i = 7;
            } else if ((0xFF00000000000000 & l) == 0L) {
              i = 8;
            } else if ((l & 0x8000000000000000) == 0L) {
              i = 9;
            } else {
              i = 10;
            }
          }
        }
        i = j + m + d.length * 1;
      }
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
    if ((d != null) && (d.length > 0))
    {
      int i = 0;
      while (i < d.length)
      {
        paramhll.a(3, d[i]);
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */