public final class hnu
  extends hln<hnu>
{
  public byte[][] a = hlw.g;
  
  public hnu()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int i = 0;
    int i1 = super.a();
    if ((a != null) && (a.length > 0))
    {
      int j = 0;
      int m;
      for (int k = 0; i < a.length; k = m)
      {
        byte[] arrayOfByte = a[i];
        int n = j;
        m = k;
        if (arrayOfByte != null)
        {
          m = k + 1;
          n = j + hll.a(arrayOfByte);
        }
        i += 1;
        j = n;
      }
      return i1 + j + k * 1;
    }
    return i1;
  }
  
  public final void a(hll paramhll)
  {
    if ((a != null) && (a.length > 0))
    {
      int i = 0;
      while (i < a.length)
      {
        byte[] arrayOfByte = a[i];
        if (arrayOfByte != null) {
          paramhll.a(1, arrayOfByte);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */