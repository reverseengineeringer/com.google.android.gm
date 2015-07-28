package com.google.android.common.html.parser;

public abstract class HtmlDocument$Text
  extends HtmlDocument.Node
{
  private final String originalHtml;
  
  protected HtmlDocument$Text(String paramString)
  {
    originalHtml = paramString;
  }
  
  public void accept(HtmlDocument.Visitor paramVisitor)
  {
    paramVisitor.visitText(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Text)) {
        break label47;
      }
      paramObject = (Text)paramObject;
      if (originalHtml != null) {
        break;
      }
    } while (originalHtml == null);
    return false;
    return originalHtml.equals(originalHtml);
    label47:
    return false;
  }
  
  public String getOriginalHTML()
  {
    return originalHtml;
  }
  
  public abstract String getText();
  
  public int hashCode()
  {
    if (originalHtml == null) {
      return 0;
    }
    return originalHtml.hashCode();
  }
  
  public boolean isWhitespace()
  {
    String str = getText();
    int j = str.length();
    int i = 0;
    while (i < j)
    {
      if (!Character.isWhitespace(str.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public String toString()
  {
    return getText();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.Text
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */