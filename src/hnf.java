public final class hnf
  extends hln<hnf>
{
  public hoc a = null;
  public hng[] b = hng.b();
  private int c = 0;
  private String d = "";
  
  public hnf()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int i = super.a();
    int j = i;
    if (a != null) {
      j = i + hll.d(1, a);
    }
    i = j;
    if ((c & 0x1) != 0) {
      i = j + hll.b(2, d);
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
          hng localhng = b[j];
          int k = i;
          if (localhng != null) {
            k = i + hll.d(3, localhng);
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
    if ((c & 0x1) != 0) {
      paramhll.a(2, d);
    }
    if ((b != null) && (b.length > 0))
    {
      int i = 0;
      while (i < b.length)
      {
        hng localhng = b[i];
        if (localhng != null) {
          paramhll.b(3, localhng);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */