public final class hpc
  extends hln<hpc>
{
  private static volatile hpc[] b;
  public hpd a = null;
  private int c = 0;
  private String d = "";
  private boolean e = false;
  
  public hpc()
  {
    q = null;
    E = -1;
  }
  
  public static hpc[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hpc[0];
      }
      return b;
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
    if ((c & 0x1) != 0) {
      j = i + hll.b(2, d);
    }
    i = j;
    if ((c & 0x2) != 0) {
      i = j + (hll.b(3) + 1);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((c & 0x1) != 0) {
      paramhll.a(2, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(3, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hpc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */