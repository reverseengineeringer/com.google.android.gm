public final class hnk
  extends hln<hnk>
{
  public hoc a = null;
  public hni[] b = hni.b();
  
  public hnk()
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
          hni localhni = b[j];
          int k = i;
          if (localhni != null) {
            k = i + hll.d(2, localhni);
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
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        hni localhni = b[i];
        if (localhni != null) {
          paramhll.b(2, localhni);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */