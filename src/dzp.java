public final class dzp
  extends hlt
{
  private static volatile dzp[] d;
  public String a = "";
  public String b = "";
  public String c = "";
  
  public dzp()
  {
    E = -1;
  }
  
  public static dzp[] b()
  {
    if (d == null) {}
    synchronized (hlr.c)
    {
      if (d == null) {
        d = new dzp[0];
      }
      return d;
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
    return i;
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
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */