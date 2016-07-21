public final class gwc
  extends hln<gwc>
{
  public gwg a = null;
  private int b = 0;
  private int c = 0;
  private String d = "";
  
  public gwc()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + hll.c(1, c);
    }
    j = i;
    if ((b & 0x2) != 0) {
      j = i + hll.b(2, d);
    }
    i = j;
    if (a != null) {
      i = j + hll.d(3, a);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if ((b & 0x1) != 0) {
      paramhll.a(1, c);
    }
    if ((b & 0x2) != 0) {
      paramhll.a(2, d);
    }
    if (a != null) {
      paramhll.b(3, a);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */