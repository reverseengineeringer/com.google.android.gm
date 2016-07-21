public final class hnz
  extends hln<hnz>
{
  private static volatile hnz[] c;
  public hnu a = null;
  public hnw[] b = hnw.b();
  
  public hnz()
  {
    q = null;
    E = -1;
  }
  
  public static hnz[] b()
  {
    if (c == null) {}
    synchronized (hlr.c)
    {
      if (c == null) {
        c = new hnz[0];
      }
      return c;
    }
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
          hnw localhnw = b[j];
          int k = i;
          if (localhnw != null) {
            k = i + hll.d(2, localhnw);
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
        hnw localhnw = b[i];
        if (localhnw != null) {
          paramhll.b(2, localhnw);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */