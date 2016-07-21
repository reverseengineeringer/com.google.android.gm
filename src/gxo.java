public final class gxo
  extends hlt
{
  public int a = 0;
  public String b = "";
  private long c = 0L;
  private int d = 0;
  private boolean e = false;
  
  public gxo()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, c);
    }
    j = i;
    if ((a & 0x2) != 0) {
      j = i + hll.c(2, d);
    }
    i = j;
    if ((a & 0x4) != 0) {
      i = j + (hll.b(3) + 1);
    }
    j = i;
    if ((a & 0x8) != 0) {
      j = i + hll.b(4, b);
    }
    return j;
  }
  
  public final gxo a(int paramInt)
  {
    d = paramInt;
    a |= 0x2;
    return this;
  }
  
  public final gxo a(long paramLong)
  {
    c = paramLong;
    a |= 0x1;
    return this;
  }
  
  public final gxo a(boolean paramBoolean)
  {
    e = paramBoolean;
    a |= 0x4;
    return this;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, c);
    }
    if ((a & 0x2) != 0) {
      paramhll.a(2, d);
    }
    if ((a & 0x4) != 0) {
      paramhll.a(3, e);
    }
    if ((a & 0x8) != 0) {
      paramhll.a(4, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */