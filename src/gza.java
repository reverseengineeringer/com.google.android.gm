public final class gza
  extends hlt
{
  public gwv[] a = gwv.b();
  
  public gza()
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
          gwv localgwv = a[j];
          k = i;
          if (localgwv != null) {
            k = i + hll.d(1, localgwv);
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
        gwv localgwv = a[i];
        if (localgwv != null) {
          paramhll.b(1, localgwv);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */