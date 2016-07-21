public final class hmu
  extends hln<hmu>
{
  private static volatile hmu[] a;
  private int b = 0;
  private boolean c = false;
  private String d = "";
  private String e = "";
  private String f = "";
  private int g = 0;
  
  public hmu()
  {
    q = null;
    E = -1;
  }
  
  public static hmu[] b()
  {
    if (a == null) {}
    synchronized (hlr.c)
    {
      if (a == null) {
        a = new hmu[0];
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
      i = j + hll.c(5, g);
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
    if ((b & 0x4) != 0) {
      paramhll.a(3, e);
    }
    if ((b & 0x8) != 0) {
      paramhll.a(4, f);
    }
    if ((b & 0x10) != 0) {
      paramhll.a(5, g);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hmu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */