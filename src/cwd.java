final class cwd
{
  public final int a;
  public final long b;
  
  public cwd(int paramInt, long paramLong)
  {
    a = paramInt;
    b = paramLong;
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
      paramObject = (cwd)paramObject;
    } while ((a == a) && (b == b));
    return false;
  }
  
  public final int hashCode()
  {
    return a * 31 + (int)(b ^ b >>> 32);
  }
}

/* Location:
 * Qualified Name:     cwd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */