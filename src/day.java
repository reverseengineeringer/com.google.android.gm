public final class day
{
  final String a;
  final dax b;
  private final String c;
  
  public day(String paramString1, String paramString2, dax paramdax)
  {
    c = paramString1;
    a = paramString2;
    b = paramdax;
  }
  
  public final String a(String paramString)
  {
    Object localObject = null;
    if (paramString.contains("*"))
    {
      String str = c;
      String[] arrayOfString = paramString.split("\\*");
      paramString = (String)localObject;
      if (arrayOfString.length > 1) {}
      try
      {
        int i = Integer.parseInt(arrayOfString[1]);
        paramString = str + i;
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        dav.f("Unable to parse slot for url parameter " + str);
        return null;
      }
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     day
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */