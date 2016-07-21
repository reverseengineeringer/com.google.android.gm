public final class hog
  extends hln<hog>
{
  private static volatile hog[] f;
  public hjx a = null;
  public hml b = null;
  public hmm c = null;
  public hnb d = null;
  public hnn e = null;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private String j = "";
  private boolean k = false;
  private String l = "";
  private String m = "";
  private String n = "";
  private String o = "";
  private long p = 0L;
  
  public hog()
  {
    q = null;
    E = -1;
  }
  
  public static hog[] b()
  {
    if (f == null) {}
    synchronized (hlr.c)
    {
      if (f == null) {
        f = new hog[0];
      }
      return f;
    }
  }
  
  protected final int a()
  {
    int i2 = super.a();
    int i1 = i2;
    if ((g & 0x1) != 0) {
      i1 = i2 + hll.c(1, h);
    }
    i2 = i1;
    if ((g & 0x2) != 0) {
      i2 = i1 + hll.b(2, i);
    }
    i1 = i2;
    if ((g & 0x4) != 0) {
      i1 = i2 + hll.b(3, j);
    }
    i2 = i1;
    if ((g & 0x8) != 0) {
      i2 = i1 + (hll.b(4) + 1);
    }
    i1 = i2;
    if ((g & 0x10) != 0) {
      i1 = i2 + hll.b(5, l);
    }
    i2 = i1;
    if ((g & 0x20) != 0) {
      i2 = i1 + hll.b(6, m);
    }
    i1 = i2;
    if ((g & 0x40) != 0) {
      i1 = i2 + hll.b(7, n);
    }
    i2 = i1;
    if ((g & 0x80) != 0) {
      i2 = i1 + hll.b(8, o);
    }
    i1 = i2;
    if ((g & 0x100) != 0) {
      i1 = i2 + hll.c(9, p);
    }
    i2 = i1;
    if (b != null) {
      i2 = i1 + hll.d(10, b);
    }
    i1 = i2;
    if (c != null) {
      i1 = i2 + hll.d(11, c);
    }
    i2 = i1;
    if (d != null) {
      i2 = i1 + hll.d(12, d);
    }
    i1 = i2;
    if (e != null) {
      i1 = i2 + hll.d(13, e);
    }
    i2 = i1;
    if (a != null) {
      i2 = i1 + hll.d(14, a);
    }
    return i2;
  }
  
  public final void a(hll paramhll)
  {
    if ((g & 0x1) != 0) {
      paramhll.a(1, h);
    }
    if ((g & 0x2) != 0) {
      paramhll.a(2, i);
    }
    if ((g & 0x4) != 0) {
      paramhll.a(3, j);
    }
    if ((g & 0x8) != 0) {
      paramhll.a(4, k);
    }
    if ((g & 0x10) != 0) {
      paramhll.a(5, l);
    }
    if ((g & 0x20) != 0) {
      paramhll.a(6, m);
    }
    if ((g & 0x40) != 0) {
      paramhll.a(7, n);
    }
    if ((g & 0x80) != 0) {
      paramhll.a(8, o);
    }
    if ((g & 0x100) != 0) {
      paramhll.a(9, p);
    }
    if (b != null) {
      paramhll.b(10, b);
    }
    if (c != null) {
      paramhll.b(11, c);
    }
    if (d != null) {
      paramhll.b(12, d);
    }
    if (e != null) {
      paramhll.b(13, e);
    }
    if (a != null) {
      paramhll.b(14, a);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */