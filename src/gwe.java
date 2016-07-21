public final class gwe
  extends hln<gwe>
{
  public int a = 0;
  public String b = "";
  public boolean c = false;
  
  public gwe()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + (hll.b(2) + 1);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */