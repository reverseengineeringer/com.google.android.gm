public final class gyt
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  public int c = 0;
  public int d = 0;
  public long[] e = hlw.b;
  private int f = 0;
  
  public gyt()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int k = 0;
    int j = super.a();
    int i = j;
    if ((f & 0x1) != 0) {
      i = j + hll.c(1, a);
    }
    j = i;
    if ((f & 0x2) != 0) {
      j = i + hll.c(2, b);
    }
    i = j;
    if ((f & 0x4) != 0) {
      i = j + hll.c(3, c);
    }
    j = i;
    if ((f & 0x8) != 0) {
      j = i + hll.c(4, d);
    }
    i = j;
    if (e != null)
    {
      i = j;
      if (e.length > 0)
      {
        int m = 0;
        if (k < e.length)
        {
          long l = e[k];
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
        i = j + m + e.length * 1;
      }
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((f & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((f & 0x2) != 0) {
      paramhll.a(2, b);
    }
    if ((f & 0x4) != 0) {
      paramhll.a(3, c);
    }
    if ((f & 0x8) != 0) {
      paramhll.a(4, d);
    }
    if ((e != null) && (e.length > 0))
    {
      int i = 0;
      while (i < e.length)
      {
        paramhll.a(5, e[i]);
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */