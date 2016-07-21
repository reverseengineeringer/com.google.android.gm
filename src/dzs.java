public final class dzs
  extends hlt
{
  public String a = "";
  public String b = "";
  public long c = 0L;
  public String d = "";
  
  public dzs()
  {
    E = -1;
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
    if (c != 0L) {
      i = j + hll.c(3, c);
    }
    j = i;
    if (!d.equals("")) {
      j = i + hll.b(4, d);
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
    if (c != 0L) {
      paramhll.a(3, c);
    }
    if (!d.equals("")) {
      paramhll.a(4, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */