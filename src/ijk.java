public final class ijk
  implements ihe
{
  final ihl c;
  
  public ijk(ihl paramihl)
  {
    c = paramihl;
  }
  
  static boolean a(String paramString, int paramInt)
  {
    int i = 1;
    while (i < paramInt)
    {
      int j = paramString.charAt(i);
      if (j <= 32)
      {
        if ((j == 9) || (j == 32)) {}
      }
      else {
        do
        {
          return false;
          j |= 0x20;
        } while (((48 > j) || (j > 57)) && ((97 > j) || (j > 122)));
      }
      i += 1;
    }
    return true;
  }
  
  public final String apply(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 != null)
    {
      paramString1 = new StringBuilder();
      ihi.a(paramString3, new ijl(this, paramString1));
      if (paramString1.length() != 0) {
        return paramString1.toString();
      }
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (getClass() == paramObject.getClass()) && (c.equals(c));
  }
  
  public final int hashCode()
  {
    return c.hashCode();
  }
}

/* Location:
 * Qualified Name:     ijk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */