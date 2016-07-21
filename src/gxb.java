public final class gxb
  extends hlt
{
  public gxc[] a = gxc.b();
  public long[] b = hlw.b;
  public long[] c = hlw.b;
  private int d = 0;
  private boolean e = false;
  
  public gxb()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int n = 0;
    int i = super.a();
    int j = i;
    int k;
    if (a != null)
    {
      j = i;
      if (a.length > 0)
      {
        j = 0;
        while (j < a.length)
        {
          gxc localgxc = a[j];
          k = i;
          if (localgxc != null) {
            k = i + hll.c(1, localgxc);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    int m;
    long l;
    if (b != null)
    {
      i = j;
      if (b.length > 0)
      {
        k = 0;
        m = 0;
        if (k < b.length)
        {
          l = b[k];
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
        i = j + m + b.length * 1;
      }
    }
    j = i;
    if ((d & 0x1) != 0) {
      j = i + (hll.b(3) + 1);
    }
    i = j;
    if (c != null)
    {
      i = j;
      if (c.length > 0)
      {
        m = 0;
        k = n;
        if (k < c.length)
        {
          l = c[k];
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
        i = j + m + c.length * 1;
      }
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    int j = 0;
    int i;
    if ((a != null) && (a.length > 0))
    {
      i = 0;
      while (i < a.length)
      {
        gxc localgxc = a[i];
        if (localgxc != null) {
          paramhll.a(1, localgxc);
        }
        i += 1;
      }
    }
    if ((b != null) && (b.length > 0))
    {
      i = 0;
      while (i < b.length)
      {
        paramhll.a(2, b[i]);
        i += 1;
      }
    }
    if ((d & 0x1) != 0) {
      paramhll.a(3, e);
    }
    if ((c != null) && (c.length > 0))
    {
      i = j;
      while (i < c.length)
      {
        paramhll.a(4, c[i]);
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */