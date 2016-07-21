public final class bvc
{
  public final bvb a;
  public final bve b;
  
  public bvc(bvb parambvb, bve parambve)
  {
    a = parambvb;
    b = parambve;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (bvc)paramObject;
      if (a != null)
      {
        if (a.equals(a)) {}
      }
      else {
        while (a != null) {
          return false;
        }
      }
      if (b == null) {
        break;
      }
    } while (b.equals(b));
    for (;;)
    {
      return false;
      if (b == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (a != null) {}
    for (int i = a.hashCode();; i = 0)
    {
      if (b != null) {
        j = b.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    return a.toString();
  }
}

/* Location:
 * Qualified Name:     bvc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */