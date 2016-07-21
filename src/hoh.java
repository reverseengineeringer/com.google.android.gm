public final class hoh
  extends hln<hoh>
{
  public hoc a = null;
  public hog[] b = hog.b();
  private int c = 0;
  private int d = 0;
  
  public hoh()
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
          hog localhog = b[j];
          int k = i;
          if (localhog != null) {
            k = i + hll.d(2, localhog);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if ((c & 0x1) != 0) {
      i = j + hll.c(3, d);
    }
    return i;
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
        hog localhog = b[i];
        if (localhog != null) {
          paramhll.b(2, localhog);
        }
        i += 1;
      }
    }
    if ((c & 0x1) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hoh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */