public final class gze
  extends hlt
{
  public gzf[] a = gzf.b();
  
  public gze()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int k = i;
    if (a != null)
    {
      k = i;
      if (a.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= a.length) {
            break;
          }
          gzf localgzf = a[j];
          k = i;
          if (localgzf != null) {
            k = i + hll.c(1, localgzf);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public final void a(hll paramhll)
  {
    if ((a != null) && (a.length > 0))
    {
      int i = 0;
      while (i < a.length)
      {
        gzf localgzf = a[i];
        if (localgzf != null) {
          paramhll.a(1, localgzf);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */