public final class fmz
  extends fml<fmz>
{
  private static volatile fmz[] c;
  public String a = "";
  public String b = "";
  
  public fmz()
  {
    f = null;
    g = -1;
  }
  
  public static fmz[] e()
  {
    if (c == null) {}
    synchronized (fmp.a)
    {
      if (c == null) {
        c = new fmz[0];
      }
      return c;
    }
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (!a.equals("")) {
      i = j + fmj.b(1, a);
    }
    j = i;
    if (!b.equals("")) {
      j = i + fmj.b(2, b);
    }
    return j;
  }
  
  public final void a(fmj paramfmj)
  {
    if (!a.equals("")) {
      paramfmj.a(1, a);
    }
    if (!b.equals("")) {
      paramfmj.a(2, b);
    }
    super.a(paramfmj);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof fmz));
        paramObject = (fmz)paramObject;
        if (a != null) {
          break;
        }
        bool1 = bool2;
      } while (a != null);
      if (b != null) {
        break label79;
      }
      bool1 = bool2;
    } while (b != null);
    label79:
    while (b.equals(b))
    {
      return a((fml)paramObject);
      if (a.equals(a)) {
        break;
      }
      return false;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (a == null)
    {
      i = 0;
      if (b != null) {
        break label48;
      }
    }
    for (;;)
    {
      return ((i + 527) * 31 + j) * 31 + b();
      i = a.hashCode();
      break;
      label48:
      j = b.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     fmz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */