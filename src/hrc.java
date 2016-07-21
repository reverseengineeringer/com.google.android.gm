public final class hrc
  extends hln<hrc>
{
  private static volatile hrc[] d;
  public String a = null;
  public Integer b = null;
  public Integer c = null;
  
  public hrc()
  {
    E = -1;
  }
  
  public static hrc[] b()
  {
    if (d == null) {}
    synchronized (hlr.c)
    {
      if (d == null) {
        d = new hrc[0];
      }
      return d;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.b(1, a);
    }
    j = i;
    if (b != null) {
      j = i + hll.c(2, b.intValue());
    }
    i = j;
    if (c != null) {
      i = j + hll.c(3, c.intValue());
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a);
    }
    if (b != null) {
      paramhll.a(2, b.intValue());
    }
    if (c != null) {
      paramhll.a(3, c.intValue());
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hrc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */