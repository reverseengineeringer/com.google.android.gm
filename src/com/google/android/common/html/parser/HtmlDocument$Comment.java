package com.google.android.common.html.parser;

public class HtmlDocument$Comment
  extends HtmlDocument.Node
{
  private final String content;
  
  public HtmlDocument$Comment(String paramString)
  {
    content = paramString;
  }
  
  public void accept(HtmlDocument.Visitor paramVisitor)
  {
    paramVisitor.visitComment(this);
  }
  
  public String getContent()
  {
    return content;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.Comment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */