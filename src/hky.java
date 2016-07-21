public final class hky
  extends hlt
{
  public int a = 0;
  public String b = "";
  public boolean c = false;
  
  public hky()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + hll.b(1, b);
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + (hll.b(2) + 1);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, b);
    if ((a & 0x1) != 0) {
      paramhll.a(2, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */