public final class hkz
  extends hlt
{
  public int a = 0;
  private int b = 0;
  
  public hkz()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + hll.c(1, a);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((b & 0x1) != 0) {
      paramhll.a(1, a);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hkz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */