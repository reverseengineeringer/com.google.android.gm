public final class dzx
  extends hlt
{
  private static volatile dzx[] e;
  public String a = "";
  public String b = "";
  public int c = 0;
  public boolean d = false;
  
  public dzx()
  {
    E = -1;
  }
  
  public static dzx[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new dzx[0];
      }
      return e;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (!a.equals("")) {
      i = j + hll.b(1, a);
    }
    j = i;
    if (!b.equals("")) {
      j = i + hll.b(2, b);
    }
    i = j;
    if (c != 0) {
      i = j + hll.c(3, c);
    }
    j = i;
    if (d) {
      j = i + (hll.b(4) + 1);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (!a.equals("")) {
      paramhll.a(1, a);
    }
    if (!b.equals("")) {
      paramhll.a(2, b);
    }
    if (c != 0) {
      paramhll.a(3, c);
    }
    if (d) {
      paramhll.a(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */