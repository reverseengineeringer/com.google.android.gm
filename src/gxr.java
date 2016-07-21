public final class gxr
  extends hlt
{
  public int a = 0;
  public gxx b = null;
  public gxt c = null;
  public int d = 0;
  public gxs e = null;
  public gxv f = null;
  public gxu g = null;
  
  public gxr()
  {
    E = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (b != null) {
      i = j + hll.c(1, b);
    }
    j = i;
    if (c != null) {
      j = i + hll.c(2, c);
    }
    i = j;
    if ((a & 0x1) != 0) {
      i = j + hll.c(3, d);
    }
    j = i;
    if (e != null) {
      j = i + hll.c(4, e);
    }
    i = j;
    if (f != null) {
      i = j + hll.c(5, f);
    }
    j = i;
    if (g != null) {
      j = i + hll.c(6, g);
    }
    return j;
  }
  
  public final void a(hll paramhll)
  {
    if (b != null) {
      paramhll.a(1, b);
    }
    if (c != null) {
      paramhll.a(2, c);
    }
    if ((a & 0x1) != 0) {
      paramhll.a(3, d);
    }
    if (e != null) {
      paramhll.a(4, e);
    }
    if (f != null) {
      paramhll.a(5, f);
    }
    if (g != null) {
      paramhll.a(6, g);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     gxr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */