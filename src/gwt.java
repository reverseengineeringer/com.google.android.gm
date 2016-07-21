public final class gwt
  extends hlt
{
  public int a = 0;
  public gzq[] b = gzq.b();
  public boolean c = true;
  
  public gwt()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if (b != null)
    {
      j = i;
      if (b.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= b.length) {
            break;
          }
          gzq localgzq = b[k];
          j = i;
          if (localgzq != null) {
            j = i + hll.d(1, localgzq);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if ((a & 0x1) != 0) {
      i = j + (hll.b(2) + 1);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        gzq localgzq = b[i];
        if (localgzq != null) {
          paramhll.b(1, localgzq);
        }
        i += 1;
      }
    }
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */