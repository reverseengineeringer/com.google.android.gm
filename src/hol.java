public final class hol
  extends hln<hol>
{
  public hoc a = null;
  public hok[] b = hok.b();
  private int c = 0;
  private int d = 0;
  
  public hol()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    if (b != null)
    {
      j = i;
      if (b.length > 0)
      {
        j = 0;
        while (j < b.length)
        {
          hok localhok = b[j];
          int k = i;
          if (localhok != null) {
            k = i + hll.d(2, localhok);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((c & 0x1) != 0) {
      i = j + hll.c(3, d);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        hok localhok = b[i];
        if (localhok != null) {
          paramhll.b(2, localhok);
        }
        i += 1;
      }
    }
    if ((c & 0x1) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */