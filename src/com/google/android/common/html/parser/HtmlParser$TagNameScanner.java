package com.google.android.common.html.parser;

class HtmlParser$TagNameScanner
{
  private int endNamePos = -1;
  private final String html;
  private int startNamePos = -1;
  private String tagName;
  
  public HtmlParser$TagNameScanner(String paramString)
  {
    html = paramString;
  }
  
  public String getTagName()
  {
    if ((tagName == null) && (startNamePos != -1) && (endNamePos != -1)) {
      tagName = html.substring(startNamePos, endNamePos);
    }
    return tagName;
  }
  
  public int scanName(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      if (i < paramInt2)
      {
        char c = html.charAt(i);
        if ((c != '>') && (c != '/') && (!Character.isWhitespace(c))) {}
      }
      else
      {
        if (i > paramInt1)
        {
          startNamePos = paramInt1;
          endNamePos = i;
        }
        return i;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlParser.TagNameScanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */