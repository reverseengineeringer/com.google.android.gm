public final class hmm
  extends hln<hmm>
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  
  public hmm()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + hll.c(3, d);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, c);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, d);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */