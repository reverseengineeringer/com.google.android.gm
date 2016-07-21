final class iji
  implements ihe
{
  static final iji c = new iji();
  
  public final String apply(String paramString1, String paramString2, String paramString3)
  {
    int j = paramString3.length();
    int i = 0;
    while (i < j) {
      switch (paramString3.charAt(i))
      {
      default: 
        i += 1;
        break;
      case ':': 
        switch (i)
        {
        default: 
        case 4: 
          do
          {
            return null;
          } while (!ijj.a("http", 0, paramString3, 4));
        }
        break;
      }
    }
    do
    {
      do
      {
        return iia.a(paramString3);
      } while (ijj.a("https", 0, paramString3, 5));
      return null;
    } while (ijj.a("mailto", 0, paramString3, 6));
    return null;
  }
}

/* Location:
 * Qualified Name:     iji
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */