package com.google.android.common.html.parser;

import com.google.android.common.base.CharMatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HtmlDocument$DebugPrinter
  implements HtmlDocument.Visitor
{
  private final PrintWriter writer;
  
  public HtmlDocument$DebugPrinter(PrintWriter paramPrintWriter)
  {
    writer = paramPrintWriter;
  }
  
  private void writeCollapsed(String paramString1, String paramString2)
  {
    writer.print(paramString1);
    writer.print(": ");
    paramString1 = paramString2.replace("\n", " ");
    paramString1 = CharMatcher.LEGACY_WHITESPACE.trimAndCollapseFrom(paramString1, ' ');
    writer.print(paramString1);
  }
  
  public void finish() {}
  
  public void start() {}
  
  public void visitComment(HtmlDocument.Comment paramComment)
  {
    writeCollapsed("COMMENT", paramComment.getContent());
  }
  
  public void visitEndTag(HtmlDocument.EndTag paramEndTag)
  {
    writer.println("==</" + paramEndTag.getName() + ">");
  }
  
  public void visitTag(HtmlDocument.Tag paramTag)
  {
    writer.print("==<" + paramTag.getName() + ">");
    Object localObject = paramTag.getAttributes();
    if (localObject != null)
    {
      paramTag = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HtmlDocument.TagAttribute localTagAttribute = (HtmlDocument.TagAttribute)((Iterator)localObject).next();
        paramTag.add("[" + localTagAttribute.getName() + " : " + localTagAttribute.getValue() + "]");
      }
      paramTag = (String[])paramTag.toArray(new String[paramTag.size()]);
      Arrays.sort(paramTag);
      int i = 0;
      while (i < paramTag.length)
      {
        writer.print(" " + paramTag[i]);
        i += 1;
      }
    }
    writer.println();
  }
  
  public void visitText(HtmlDocument.Text paramText)
  {
    writeCollapsed("TEXT", paramText.getText());
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.DebugPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */