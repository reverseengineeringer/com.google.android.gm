public final class hnt
  extends hln<hnt>
{
  public hnw[] a = hnw.b();
  private int b = 0;
  private byte[] c = hlw.h;
  
  public hnt()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + hll.b(1, c);
    }
    j = i;
    if (a != null)
    {
      j = i;
      if (a.length > 0)
      {
        j = 0;
        while (j < a.length)
        {
          hnw localhnw = a[j];
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
    if ((b & 0x1) != 0) {
      paramhll.a(1, c);
    }
    if ((a != null) && (a.length > 0))
    {
      int i = 0;
      while (i < a.length)
      {
        hnw localhnw = a[i];
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
 * Qualified Name:     hnt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */