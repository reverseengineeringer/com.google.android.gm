import java.util.List;

final class cuz
  implements ihu
{
  public final String apply(String paramString, List<String> paramList)
  {
    int i = paramList.indexOf("class");
    boolean bool;
    if (i >= 0)
    {
      paramString = (String)paramList.remove(i + 1);
      paramList.remove(i);
      if (("gmail_quote".equals(paramString)) || ("yahoo_quoted".equals(paramString))) {
        bool = true;
      }
    }
    for (;;)
    {
      i = paramList.indexOf("id");
      if (i >= 0)
      {
        paramString = (String)paramList.remove(i + 1);
        paramList.remove(i);
        bool = paramString.startsWith("AOLMsgPart");
      }
      if (bool)
      {
        paramList.add("class");
        paramList.add("elided-text");
      }
      return "div";
      bool = false;
      continue;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     cuz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */