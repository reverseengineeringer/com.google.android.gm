public final class hmq
  extends hln<hmq>
{
  public hoc a = null;
  public hmr[] b = hmr.b();
  
  public hmq()
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
          hmr localhmr = b[j];
          int k = i;
          if (localhmr != null) {
            k = i + hll.d(2, localhmr);
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
        hmr localhmr = b[i];
        if (localhmr != null) {
          paramhll.b(2, localhmr);
        }
        i += 1;
      }
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */