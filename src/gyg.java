public final class gyg
  extends hlt
{
  public long a = 0L;
  public long b = 0L;
  public gwp c = null;
  private int d = 0;
  
  public gyg()
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
      j = i + hll.c(2, b);
    }
    i = j;
    if (c != null) {
      i = j + hll.d(3, c);
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
    if (c != null) {
      paramhll.b(3, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */