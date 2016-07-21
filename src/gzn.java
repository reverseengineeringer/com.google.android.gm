public final class gzn
  extends hlt
{
  public int a = 0;
  public int b = 0;
  public gzo[] c = gzo.b();
  private int d = 0;
  
  public gzn()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if ((d & 0x1) != 0) {
      j = i + hll.c(1, a);
    }
    i = j;
    if ((d & 0x2) != 0) {
      i = j + hll.c(2, b);
    }
    j = i;
    if (c != null)
    {
      j = i;
      if (c.length > 0)
      {
        j = 0;
        while (j < c.length)
        {
          gzo localgzo = c[j];
          int k = i;
          if (localgzo != null) {
            k = i + hll.c(3, localgzo);
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
    if ((d & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(2, b);
    }
    if ((c != null) && (c.length > 0))
    {
      int i = 0;
      while (i < c.length)
      {
        gzo localgzo = c[i];
        if (localgzo != null) {
          paramhll.a(3, localgzo);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */