import java.util.List;

final class iit
  implements ihu
{
  static final iit c = new iit();
  
  public final String apply(String paramString, List<String> paramList)
  {
    int i = 0;
    int j = paramList.size();
    for (;;)
    {
      if (i < j)
      {
        if ("href".equals(paramList.get(i)))
        {
          paramList.add("rel");
          paramList.add("nofollow");
        }
      }
      else {
        return paramString;
      }
      i += 2;
    }
  }
}

/* Location:
 * Qualified Name:     iit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */