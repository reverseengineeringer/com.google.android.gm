public final class dzl
  extends hlt
{
  private static volatile dzl[] e;
  public String a = "";
  public String b = "";
  public String c = "";
  public int d = 0;
  
  public dzl()
  {
    E = -1;
  }
  
  public static dzl[] b()
  {
    if (e == null) {}
    synchronized (hlr.c)
    {
      if (e == null) {
        e = new dzl[0];
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
    if (!c.equals("")) {
      i = j + hll.b(3, c);
    }
    j = i;
    if (d != 0) {
      j = i + hll.c(4, d);
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
    if (!c.equals("")) {
      paramhll.a(3, c);
    }
    if (d != 0) {
      paramhll.a(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */