public final class drk
{
  public long a;
  public String b;
  
  public drk(long paramLong, String paramString)
  {
    a = paramLong;
    b = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof drk)) {}
    do
    {
      return false;
      paramObject = (drk)paramObject;
    } while ((a != a) || (!b.equals(b)));
    return true;
  }
  
  public final int hashCode()
  {
    return (int)a;
  }
  
  public final String toString()
  {
    long l = a;
    String str = b;
    return String.valueOf(str).length() + 21 + l + "/" + str;
  }
}

/* Location:
 * Qualified Name:     drk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */