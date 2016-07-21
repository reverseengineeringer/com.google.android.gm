public final class hmx
  extends hln<hmx>
{
  private static volatile hmx[] a;
  private int b = 0;
  private boolean c = false;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private int h = 0;
  
  public hmx()
  {
    q = null;
    E = -1;
  }
  
  public static hmx[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new hmx[0];
      }
      return a;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if ((b & 0x1) != 0) {
      i = j + (hll.b(1) + 1);
    }
    j = i;
    if ((b & 0x2) != 0) {
      j = i + hll.b(2, d);
    }
    i = j;
    if ((b & 0x4) != 0) {
      i = j + hll.b(3, e);
    }
    j = i;
    if ((b & 0x8) != 0) {
      j = i + hll.b(4, f);
    }
    i = j;
    if ((b & 0x10) != 0) {
      i = j + hll.b(5, g);
    }
    j = i;
    if ((b & 0x20) != 0) {
      j = i + hll.c(6, h);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if ((b & 0x1) != 0) {
      paramhll.a(1, c);
    }
    if ((b & 0x2) != 0) {
      paramhll.a(2, d);
    }
    if ((b & 0x4) != 0) {
      paramhll.a(3, e);
    }
    if ((b & 0x8) != 0) {
      paramhll.a(4, f);
    }
    if ((b & 0x10) != 0) {
      paramhll.a(5, g);
    }
    if ((b & 0x20) != 0) {
      paramhll.a(6, h);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */