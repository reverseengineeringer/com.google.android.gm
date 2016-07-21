public final class hjx
  extends hln<hjx>
{
  private int a = 0;
  private String b = "";
  
  public hjx()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.b(2, b);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((a & 0x1) != 0) {
      paramhll.a(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hjx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */