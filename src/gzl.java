public final class gzl
  extends hlt
{
  private static volatile gzl[] c;
  public long a = 0L;
  public String b = "";
  private int d = 0;
  
  public gzl()
  {
    E = -1;
  }
  
  public static gzl[] b()
  {
    if (c == null) {}
    synchronized (hlr.c)
    {
      if (c == null) {
        c = new gzl[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((d & 0x1) != 0) {
      i = j + hll.c(1, a);
    }
    j = i;
    if ((d & 0x2) != 0) {
      j = i + hll.b(2, b);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((d & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */