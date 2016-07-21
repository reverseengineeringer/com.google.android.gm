public final class fmw
  extends fml<fmw>
{
  public int a = 0;
  public String b = "";
  public String c = "";
  
  public fmw()
  {
    f = null;
    g = -1;
  }
  
  protected final int a()
  {
    int j = super.a();
    int i = j;
    if (a != 0) {
      i = j + fmj.b(1, a);
    }
    j = i;
    if (!b.equals("")) {
      j = i + fmj.b(2, b);
    }
    i = j;
    if (!c.equals("")) {
      i = j + fmj.b(3, c);
    }
    return i;
  }
  
  public final void a(fmj paramfmj)
  {
    if (a != 0) {
      paramfmj.a(1, a);
    }
    if (!b.equals("")) {
      paramfmj.a(2, b);
    }
    if (!c.equals("")) {
      paramfmj.a(3, c);
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
          do
          {
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof fmw));
          paramObject = (fmw)paramObject;
          bool1 = bool2;
        } while (a != a);
        if (b != null) {
          break;
        }
        bool1 = bool2;
      } while (b != null);
      if (c != null) {
        break label92;
      }
      bool1 = bool2;
    } while (c != null);
    label92:
    while (c.equals(c))
    {
      return a((fml)paramObject);
      if (b.equals(b)) {
        break;
      }
      return false;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = a;
    int i;
    if (b == null)
    {
      i = 0;
      if (c != null) {
        break label58;
      }
    }
    for (;;)
    {
      return ((i + (k + 527) * 31) * 31 + j) * 31 + b();
      i = b.hashCode();
      break;
      label58:
      j = c.hashCode();
    }
  }
}

/* Location:
 * Qualified Name:     fmw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */