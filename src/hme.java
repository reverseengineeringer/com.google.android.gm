public final class hme
  extends hln<hme>
{
  private static volatile hme[] b;
  public hlz a = null;
  private int c = 0;
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  
  public hme()
  {
    q = null;
    E = -1;
  }
  
  public static hme[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hme[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.d(1, a);
    }
    j = i;
    if ((c & 0x1) != 0) {
      j = i + hll.b(2, d);
    }
    i = j;
    if ((c & 0x2) != 0) {
      i = j + hll.b(3, e);
    }
    j = i;
    if ((c & 0x4) != 0) {
      j = i + hll.b(4, f);
    }
    i = j;
    if ((c & 0x8) != 0) {
      i = j + hll.b(5, g);
    }
    j = i;
    if ((c & 0x10) != 0) {
      j = i + hll.b(6, h);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.b(1, a);
    }
    if ((c & 0x1) != 0) {
      paramhll.a(2, d);
    }
    if ((c & 0x2) != 0) {
      paramhll.a(3, e);
    }
    if ((c & 0x4) != 0) {
      paramhll.a(4, f);
    }
    if ((c & 0x8) != 0) {
      paramhll.a(5, g);
    }
    if ((c & 0x10) != 0) {
      paramhll.a(6, h);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */