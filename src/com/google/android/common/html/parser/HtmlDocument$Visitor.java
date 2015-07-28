package com.google.android.common.html.parser;

public abstract interface HtmlDocument$Visitor
{
  public abstract void finish();
  
  public abstract void start();
  
  public abstract void visitComment(HtmlDocument.Comment paramComment);
  
  public abstract void visitEndTag(HtmlDocument.EndTag paramEndTag);
  
  public abstract void visitTag(HtmlDocument.Tag paramTag);
  
  public abstract void visitText(HtmlDocument.Text paramText);
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.Visitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */