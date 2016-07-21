public final class iha
  extends Error
{
  int a;
  
  public iha() {}
  
  private iha(String paramString, int paramInt)
  {
    super(paramString);
    a = 0;
  }
  
  public iha(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, char paramChar)
  {
    this(a(paramBoolean, paramInt1, paramInt2, paramString, paramChar), 0);
  }
  
  private static String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString.length())
    {
      char c;
      String str;
      switch (paramString.charAt(i))
      {
      default: 
        c = paramString.charAt(i);
        if ((c < ' ') || (c > '~'))
        {
          str = String.valueOf(Integer.toString(c, 16));
          if (str.length() != 0)
          {
            str = "0000".concat(str);
            label150:
            str = String.valueOf(str.substring(str.length() - 4, str.length()));
            if (str.length() == 0) {
              break label297;
            }
            str = "\\u".concat(str);
            label182:
            localStringBuffer.append(str);
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append("\\b");
        continue;
        localStringBuffer.append("\\t");
        continue;
        localStringBuffer.append("\\n");
        continue;
        localStringBuffer.append("\\f");
        continue;
        localStringBuffer.append("\\r");
        continue;
        localStringBuffer.append("\\\"");
        continue;
        localStringBuffer.append("\\'");
        continue;
        localStringBuffer.append("\\\\");
        continue;
        str = new String("0000");
        break label150;
        label297:
        str = new String("\\u");
        break label182;
        localStringBuffer.append(c);
      }
    }
    return localStringBuffer.toString();
  }
  
  private static String a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString, char paramChar)
  {
    if (paramBoolean) {}
    for (String str = "<EOF> ";; str = String.valueOf(str).length() + 18 + "\"" + str + "\" (" + paramChar + "), ")
    {
      paramString = String.valueOf(a(paramString));
      return String.valueOf(str).length() + 79 + String.valueOf(paramString).length() + "Lexical error at line " + paramInt1 + ", column " + paramInt2 + ".  Encountered: " + str + "after : \"" + paramString + "\"";
      str = String.valueOf(a(String.valueOf(paramChar)));
    }
  }
  
  public final String getMessage()
  {
    return super.getMessage();
  }
}

/* Location:
 * Qualified Name:     iha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */