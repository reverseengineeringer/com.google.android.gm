public final class hoi
  extends hln<hoi>
{
  public hoc a = null;
  public hoj[] b = hoj.b();
  private int c = 0;
  private int d = 0;
  private String e = "";
  private int f = 0;
  
  public hoi()
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
          hoj localhoj = b[j];
          int k = i;
          if (localhoj != null) {
            k = i + hll.d(2, localhoj);
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
    j = i;
    if ((c & 0x2) != 0) {
      j = i + hll.b(4, e);
    }
    i = j;
    if ((c & 0x4) != 0) {
      i = j + hll.c(5, f);
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
        hoj localhoj = b[i];
        if (localhoj != null) {
          paramhll.b(2, localhoj);
        }
        i += 1;
      }
    }
    if ((c & 0x1) != 0) {
      paramhll.a(3, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(4, e);
    }
    if ((c & 0x4) != 0) {
      paramhll.a(5, f);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hoi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */