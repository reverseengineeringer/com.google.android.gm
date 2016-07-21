public final class hny
  extends hln<hny>
{
  public hnz[] a = hnz.b();
  
  public hny()
  {
    q = null;
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
          hnz localhnz = a[j];
          k = i;
          if (localhnz != null) {
            k = i + hll.d(2, localhnz);
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
        hnz localhnz = a[i];
        if (localhnz != null) {
          paramhll.b(2, localhnz);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hny
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */