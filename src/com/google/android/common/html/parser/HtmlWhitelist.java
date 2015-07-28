package com.google.android.common.html.parser;

public abstract interface HtmlWhitelist
{
  public abstract HTML.Attribute lookupAttribute(String paramString);
  
  public abstract HTML.Element lookupElement(String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlWhitelist
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */