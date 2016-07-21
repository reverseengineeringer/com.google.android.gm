final class agd
{
  int a;
  int b;
  Object c;
  int d;
  
  agd(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    a = paramInt1;
    b = paramInt2;
    d = paramInt3;
    c = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (agd)paramObject;
          if (a != a) {
            return false;
          }
        } while ((a == 8) && (Math.abs(d - b) == 1) && (d == b) && (b == d));
        if (d != d) {
          return false;
        }
        if (b != b) {
          return false;
        }
        if (c == null) {
          break;
        }
      } while (c.equals(c));
      return false;
    } while (c == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (a * 31 + b) * 31 + d;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = "??";
    }
    for (;;)
    {
      return str + ",s:" + b + "c:" + d + ",p:" + c + "]";
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
}

/* Location:
 * Qualified Name:     agd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */