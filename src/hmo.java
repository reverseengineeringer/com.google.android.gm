public final class hmo
  extends hln<hmo>
{
  public hmn[] a = hmn.b();
  
  public hmo()
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
          hmn localhmn = a[j];
          k = i;
          if (localhmn != null) {
            k = i + hll.d(1, localhmn);
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
        hmn localhmn = a[i];
        if (localhmn != null) {
          paramhll.b(1, localhmn);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */