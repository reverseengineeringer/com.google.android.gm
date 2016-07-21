public final class hrb
  extends hln<hrb>
{
  public hra[] a = hra.b();
  public hql b;
  
  public hrb()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if (a != null)
    {
      j = i;
      if (a.length > 0)
      {
        int k = 0;
        for (;;)
        {
          j = i;
          if (k >= a.length) {
            break;
          }
          hra localhra = a[k];
          j = i;
          if (localhra != null) {
            j = i + hll.d(1, localhra);
          }
          k += 1;
          i = j;
        }
      }
    }
    i = j;
    if (b != null) {
      i = j + hll.d(2, b);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((a != null) && (a.length > 0))
    {
      int i = 0;
      while (i < a.length)
      {
        hra localhra = a[i];
        if (localhra != null) {
          paramhll.b(1, localhra);
        }
        i += 1;
      }
    }
    if (b != null) {
      paramhll.b(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hrb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */