public final class ajb
{
  public final int a;
  public final int b;
  
  public ajb(int paramInt1, int paramInt2)
  {
    a = paramInt1;
    b = paramInt2;
  }
  
  public final int a()
  {
    return b - a;
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
      paramObject = (ajb)paramObject;
      if (b != b) {
        return false;
      }
    } while (a == a);
    return false;
  }
  
  public final int hashCode()
  {
    return a * 31 + b;
  }
  
  public final String toString()
  {
    return "[" + a + ", " + b + "]";
  }
}

/* Location:
 * Qualified Name:     ajb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */