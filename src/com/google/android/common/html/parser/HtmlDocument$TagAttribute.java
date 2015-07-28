package com.google.android.common.html.parser;

import com.google.android.common.base.X;

public class HtmlDocument$TagAttribute
{
  private final HTML.Attribute attribute;
  private String originalHtml;
  private String value;
  
  private HtmlDocument$TagAttribute(HTML.Attribute paramAttribute, String paramString1, String paramString2)
  {
    if (paramAttribute != null) {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      attribute = paramAttribute;
      value = paramString1;
      originalHtml = paramString2;
      return;
    }
  }
  
  public HTML.Attribute getAttribute()
  {
    return attribute;
  }
  
  public String getName()
  {
    return attribute.getName();
  }
  
  public String getValue()
  {
    if (value != null) {
      return value;
    }
    return "";
  }
  
  public String toString()
  {
    return "{" + attribute.getName() + "=" + value + "}";
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.TagAttribute
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */