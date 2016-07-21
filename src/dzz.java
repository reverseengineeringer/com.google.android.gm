public final class dzz
  extends hlt
{
  public String a = "";
  public String b = "";
  public boolean c = false;
  
  public dzz()
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
    if (c) {
      i = j + (hll.b(3) + 1);
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
    if (c) {
      paramhll.a(3, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */