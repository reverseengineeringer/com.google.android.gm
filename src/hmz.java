public final class hmz
  extends hln<hmz>
{
  public hoc a = null;
  public hna b = null;
  public hna c = null;
  private int d = 0;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  
  public hmz()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    if ((d & 0x1) != 0) {
      j = i + hll.b(2, e);
    }
    i = j;
    if ((d & 0x2) != 0) {
      i = j + hll.b(3, f);
    }
    j = i;
    if ((d & 0x4) != 0) {
      j = i + hll.b(4, g);
    }
    i = j;
    if ((d & 0x8) != 0) {
      i = j + hll.b(5, h);
    }
    j = i;
    if (b != null) {
      j = i + hll.d(6, b);
    }
    i = j;
    if (c != null) {
      i = j + hll.d(7, c);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((d & 0x1) != 0) {
      paramhll.a(2, e);
    }
    if ((d & 0x2) != 0) {
      paramhll.a(3, f);
    }
    if ((d & 0x4) != 0) {
      paramhll.a(4, g);
    }
    if ((d & 0x8) != 0) {
      paramhll.a(5, h);
    }
    if (b != null) {
      paramhll.b(6, b);
    }
    if (c != null) {
      paramhll.b(7, c);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */