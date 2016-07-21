public final class hkx
  extends hlt
{
  public boolean a = false;
  public boolean b = false;
  private int c = 0;
  private boolean d = false;
  
  public hkx()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + (hll.b(1) + 1);
    int i = j;
    if ((c & 0x1) != 0) {
      i = j + (hll.b(2) + 1);
    }
    j = i;
    if ((c & 0x2) != 0) {
      j = i + (hll.b(3) + 1);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, a);
    if ((c & 0x1) != 0) {
      paramhll.a(2, b);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */