package com.google.android.common.html.parser;

import com.google.android.common.base.X;

public class HtmlDocument$EndTag
  extends HtmlDocument.Node
{
  private final HTML.Element element;
  private final String originalHtml;
  
  private HtmlDocument$EndTag(HTML.Element paramElement, String paramString)
  {
    if (paramElement != null) {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      element = paramElement;
      originalHtml = paramString;
      return;
    }
  }
  
  public void accept(HtmlDocument.Visitor paramVisitor)
  {
    paramVisitor.visitEndTag(this);
  }
  
  public HTML.Element getElement()
  {
    return element;
  }
  
  public String getName()
  {
    return element.getName();
  }
  
  public String toString()
  {
    return "End Tag: " + element.getName();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.EndTag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */