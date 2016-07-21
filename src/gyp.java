public final class gyp
  extends hlt
{
  public int a = 0;
  public String b = "";
  public String c = "";
  private int d = 0;
  
  public gyp()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((d & 0x1) != 0) {
      i = j + hll.c(1, a);
    }
    j = i;
    if ((d & 0x2) != 0) {
      j = i + hll.b(2, b);
    }
    i = j;
    if ((d & 0x4) != 0) {
      i = j + hll.b(3, c);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((d & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(2, b);
    }
    if ((d & 0x4) != 0) {
      paramhll.a(3, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */