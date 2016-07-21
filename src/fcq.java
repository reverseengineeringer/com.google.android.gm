public final class fcq
  extends fml<fcq>
{
  public int a = 1;
  public long b = -1L;
  public long c = -1L;
  public long d = -1L;
  
  public fcq()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    return super.a() + fmj.b(1, a) + fmj.d(2, b) + fmj.d(3, c) + fmj.d(4, d);
  }
  
  public final void a(fmj paramfmj)
  {
    paramfmj.a(1, a);
    paramfmj.b(2, b);
    paramfmj.b(3, c);
    paramfmj.b(4, d);
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
          do
          {
            do
            {
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof fcq));
            paramObject = (fcq)paramObject;
            bool1 = bool2;
          } while (a != a);
          bool1 = bool2;
        } while (b != b);
        bool1 = bool2;
      } while (c != c);
      bool1 = bool2;
    } while (d != d);
    return a((fml)paramObject);
  }
  
  public final int hashCode()
  {
    return ((((a + 527) * 31 + (int)(b ^ b >>> 32)) * 31 + (int)(c ^ c >>> 32)) * 31 + (int)(d ^ d >>> 32)) * 31 + b();
  }
}

/* Location:
 * Qualified Name:     fcq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */