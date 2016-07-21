public final class gzs
  extends hlt
{
  public int a = 0;
  public int[] b = hlw.a;
  public boolean c = true;
  
  public gzs()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = 0;
    int k = super.a();
    int j;
    if ((b != null) && (b.length > 0))
    {
      j = 0;
      while (i < b.length)
      {
        j += hll.a(b[i]);
        i += 1;
      }
    }
    for (i = k + j + b.length * 1;; i = k)
    {
      j = i;
      if ((a & 0x1) != 0) {
        j = i + (hll.b(2) + 1);
      }
      return j;
    }
  }
  
  public final void a(hll paramhll)
  {
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        paramhll.a(1, b[i]);
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
 * Qualified Name:     gzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */