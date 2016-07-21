public final class hrg
  extends hln<hrg>
{
  private static volatile hrg[] b;
  public String a = null;
  
  public hrg()
  {
    E = -1;
  }
  
  public static hrg[] b()
  {
    if (b == null) {}
    synchronized (hlr.c)
    {
      if (b == null) {
        b = new hrg[0];
      }
      return b;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != null) {
      i = j + hll.b(1, a);
    }
    return i;
  }
  
  public final void a(hll paramhll)
  {
    if (a != null) {
      paramhll.a(1, a);
    }
    super.a(paramhll);
  }
}

/* Location:
 * Qualified Name:     hrg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */