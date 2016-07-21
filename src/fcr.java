public final class fcr
  extends fml<fcr>
{
  public int a = 1;
  public String b = "";
  public long c = -1L;
  public long d = -1L;
  public int e = -1;
  
  public fcr()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    int j = super.a() + fmj.b(1, a) + fmj.b(2, b) + fmj.d(3, c) + fmj.d(4, d);
    int i = j;
    if (e != -1) {
      i = j + fmj.b(5, e);
    }
    return i;
  }
  
  public final void a(fmj paramfmj)
  {
    paramfmj.a(1, a);
    paramfmj.a(2, b);
    paramfmj.b(3, c);
    paramfmj.b(4, d);
    if (e != -1) {
      paramfmj.a(5, e);
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
        } while (!(paramObject instanceof fcr));
        paramObject = (fcr)paramObject;
        bool1 = bool2;
      } while (a != a);
      if (b != null) {
        break;
      }
      bool1 = bool2;
    } while (b != null);
    while (b.equals(b))
    {
      bool1 = bool2;
      if (c != c) {
        break;
      }
      bool1 = bool2;
      if (d != d) {
        break;
      }
      bool1 = bool2;
      if (e != e) {
        break;
      }
      return a((fml)paramObject);
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = a;
    if (b == null) {}
    for (int i = 0;; i = b.hashCode()) {
      return ((((i + (j + 527) * 31) * 31 + (int)(c ^ c >>> 32)) * 31 + (int)(d ^ d >>> 32)) * 31 + e) * 31 + b();
    }
  }
}

/* Location:
 * Qualified Name:     fcr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */