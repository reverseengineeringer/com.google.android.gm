package com.google.android.common.html.parser;

import com.google.common.collect.ImmutableSet;
import java.util.Set;

public class HtmlTree$DefaultPlainTextConverter
  implements HtmlTree.PlainTextConverter
{
  private static final Set<HTML.Element> BLANK_LINE_ELEMENTS = ImmutableSet.of(HTML4.P_ELEMENT, HTML4.BLOCKQUOTE_ELEMENT, HTML4.PRE_ELEMENT);
  private int preDepth = 0;
  private final HtmlTree.PlainTextPrinter printer = new HtmlTree.PlainTextPrinter();
  
  public void addNode(HtmlDocument.Node paramNode, int paramInt1, int paramInt2)
  {
    if ((paramNode instanceof HtmlDocument.Text))
    {
      paramNode = ((HtmlDocument.Text)paramNode).getText();
      if (preDepth > 0) {
        printer.appendPreText(paramNode);
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          printer.appendNormalText(paramNode);
          return;
          if (!(paramNode instanceof HtmlDocument.Tag)) {
            break;
          }
          paramNode = ((HtmlDocument.Tag)paramNode).getElement();
          if (BLANK_LINE_ELEMENTS.contains(paramNode)) {
            printer.setSeparator(HtmlTree.PlainTextPrinter.Separator.BlankLine);
          }
          while (HTML4.BLOCKQUOTE_ELEMENT.equals(paramNode))
          {
            printer.incQuoteDepth();
            return;
            if (HTML4.BR_ELEMENT.equals(paramNode))
            {
              printer.appendForcedLineBreak();
            }
            else if (paramNode.breaksFlow())
            {
              printer.setSeparator(HtmlTree.PlainTextPrinter.Separator.LineBreak);
              if (HTML4.HR_ELEMENT.equals(paramNode))
              {
                printer.appendNormalText("________________________________");
                printer.setSeparator(HtmlTree.PlainTextPrinter.Separator.LineBreak);
              }
            }
          }
        } while (!HTML4.PRE_ELEMENT.equals(paramNode));
        preDepth += 1;
        return;
      } while (!(paramNode instanceof HtmlDocument.EndTag));
      paramNode = ((HtmlDocument.EndTag)paramNode).getElement();
      if (BLANK_LINE_ELEMENTS.contains(paramNode)) {
        printer.setSeparator(HtmlTree.PlainTextPrinter.Separator.BlankLine);
      }
      while (HTML4.BLOCKQUOTE_ELEMENT.equals(paramNode))
      {
        printer.decQuoteDepth();
        return;
        if (paramNode.breaksFlow()) {
          printer.setSeparator(HtmlTree.PlainTextPrinter.Separator.LineBreak);
        }
      }
    } while (!HTML4.PRE_ELEMENT.equals(paramNode));
    preDepth -= 1;
  }
  
  public final String getPlainText()
  {
    return printer.getText();
  }
  
  public final int getPlainTextLength()
  {
    return printer.getTextLength();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlTree.DefaultPlainTextConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */