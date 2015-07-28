package com.google.android.common.html.parser;

import com.google.android.common.base.StringUtil;

class HtmlDocument$EscapedText
  extends HtmlDocument.Text
{
  private final String htmlText;
  private String text;
  
  private HtmlDocument$EscapedText(String paramString1, String paramString2)
  {
    super(paramString2);
    htmlText = paramString1;
  }
  
  public String getText()
  {
    if (text == null) {
      text = StringUtil.unescapeHTML(htmlText);
    }
    return text;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.EscapedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */