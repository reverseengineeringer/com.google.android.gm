public final class gwu
  extends hlt
{
  private static volatile gwu[] c;
  public String a = "";
  public String b = "";
  private int d = 0;
  
  public gwu()
  {
    E = -1;
  }
  
  public static gwu[] b()
  {
    if (c == null) {}
    synchronized (hlr.c)
    {
      if (c == null) {
        c = new gwu[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((d & 0x1) != 0) {
      i = j + hll.b(1, a);
    }
    j = i;
    if ((d & 0x2) != 0) {
      j = i + hll.b(2, b);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((d & 0x1) != 0) {
      paramhll.a(1, a);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(2, b);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gwu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */