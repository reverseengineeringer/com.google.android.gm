public final class dzy
  extends hlt
{
  public int a = 1;
  public boolean b = false;
  public boolean c = false;
  
  public dzy()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != 1) {
      i = j + hll.c(1, a);
    }
    j = i;
    if (b) {
      j = i + (hll.b(2) + 1);
    }
    i = j;
    if (c) {
      i = j + (hll.b(3) + 1);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != 1) {
      paramhll.a(1, a);
    }
    if (b) {
      paramhll.a(2, b);
    }
    if (c) {
      paramhll.a(3, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     dzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */