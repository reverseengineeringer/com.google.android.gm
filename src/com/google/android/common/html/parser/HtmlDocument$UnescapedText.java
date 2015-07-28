package com.google.android.common.html.parser;

import com.google.android.common.base.X;

class HtmlDocument$UnescapedText
  extends HtmlDocument.Text
{
  protected final String text;
  
  private HtmlDocument$UnescapedText(String paramString1, String paramString2)
  {
    super(paramString2);
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      text = paramString1;
      return;
    }
  }
  
  public String getText()
  {
    return text;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.UnescapedText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */