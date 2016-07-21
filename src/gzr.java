public final class gzr
  extends hlt
{
  public int a = 0;
  public long b = 0L;
  
  public gzr()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(1, b);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(1, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */