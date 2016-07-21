public final class gyw
  extends hlt
{
  public byte[] a = hlw.h;
  public long b = 0L;
  public long c = 0L;
  private int d = 0;
  private byte[] e = hlw.h;
  
  public gyw()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + hll.b(1, a) + hll.c(2, b) + hll.c(3, c);
    int i = j;
    if ((d & 0x1) != 0) {
      i = j + hll.b(4, e);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    paramhll.a(1, a);
    paramhll.a(2, b);
    paramhll.a(3, c);
    if ((d & 0x1) != 0) {
      paramhll.a(4, e);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gyw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */