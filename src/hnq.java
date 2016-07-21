public final class hnq
  extends hln<hnq>
{
  public hoc a = null;
  private int b = 0;
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private boolean g = false;
  private String h = "";
  private boolean i = false;
  private boolean j = false;
  private String k = "";
  
  public hnq()
  {
    q = null;
    E = -1;
  }
  
  protected final int a()
  {
    int n = super.a();
    int m = n;
    if (a != null) {
      m = n + hll.d(1, a);
    }
    n = m;
    if ((b & 0x1) != 0) {
      n = m + hll.b(2, c);
    }
    m = n;
    if ((b & 0x2) != 0) {
      m = n + hll.b(3, d);
    }
    n = m;
    if ((b & 0x4) != 0) {
      n = m + hll.b(4, e);
    }
    m = n;
    if ((b & 0x8) != 0) {
      m = n + hll.b(5, f);
    }
    n = m;
    if ((b & 0x10) != 0) {
      n = m + (hll.b(6) + 1);
    }
    m = n;
    if ((b & 0x20) != 0) {
      m = n + hll.b(7, h);
    }
    n = m;
    if ((b & 0x40) != 0) {
      n = m + (hll.b(8) + 1);
    }
    m = n;
    if ((b & 0x80) != 0) {
      m = n + (hll.b(9) + 1);
    }
    n = m;
    if ((b & 0x100) != 0) {
      n = m + hll.b(10, k);
    }
    return n;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((b & 0x1) != 0) {
      paramhll.a(2, c);
    }
    if ((b & 0x2) != 0) {
      paramhll.a(3, d);
    }
    if ((b & 0x4) != 0) {
      paramhll.a(4, e);
    }
    if ((b & 0x8) != 0) {
      paramhll.a(5, f);
    }
    if ((b & 0x10) != 0) {
      paramhll.a(6, g);
    }
    if ((b & 0x20) != 0) {
      paramhll.a(7, h);
    }
    if ((b & 0x40) != 0) {
      paramhll.a(8, i);
    }
    if ((b & 0x80) != 0) {
      paramhll.a(9, j);
    }
    if ((b & 0x100) != 0) {
      paramhll.a(10, k);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hnq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */