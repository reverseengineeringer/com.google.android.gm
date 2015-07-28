package com.google.android.common.html.parser;

import com.google.android.common.base.X;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HtmlTreeBuilder
  implements HtmlDocument.Visitor
{
  private static final Logger logger = Logger.getLogger(HtmlTreeBuilder.class.getName());
  private boolean built = false;
  private final List<HTML.Element> stack = new ArrayList();
  private final TableFixer tableFixer = new TableFixer();
  private HtmlTree tree;
  
  private void addMissingEndTag()
  {
    HtmlDocument.EndTag localEndTag = HtmlDocument.createEndTag(pop());
    tableFixer.seeEndTag(localEndTag);
    tree.addEndTag(localEndTag);
  }
  
  private int findStartTag(HTML.Element paramElement)
  {
    int i = stack.size() - 1;
    while (i >= 0)
    {
      if ((HTML.Element)stack.get(i) == paramElement) {
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  private HTML.Element pop()
  {
    return (HTML.Element)stack.remove(stack.size() - 1);
  }
  
  private void push(HTML.Element paramElement)
  {
    stack.add(paramElement);
  }
  
  public void finish()
  {
    while (stack.size() > 0) {
      addMissingEndTag();
    }
    tableFixer.finish();
    tree.finish();
    built = true;
  }
  
  public HtmlTree getTree()
  {
    X.assertTrue(built);
    return tree;
  }
  
  public void start()
  {
    tree = new HtmlTree();
    tree.start();
  }
  
  public void visitComment(HtmlDocument.Comment paramComment) {}
  
  public void visitEndTag(HtmlDocument.EndTag paramEndTag)
  {
    HTML.Element localElement = paramEndTag.getElement();
    int i = findStartTag(localElement);
    if (i >= 0)
    {
      while (i < stack.size() - 1) {
        addMissingEndTag();
      }
      pop();
      tableFixer.seeEndTag(paramEndTag);
      tree.addEndTag(paramEndTag);
      return;
    }
    logger.finest("Ignoring end tag: " + localElement.getName());
  }
  
  public void visitTag(HtmlDocument.Tag paramTag)
  {
    tableFixer.seeTag(paramTag);
    HTML.Element localElement = paramTag.getElement();
    if (localElement.isEmpty())
    {
      tree.addSingularTag(paramTag);
      return;
    }
    if (paramTag.isSelfTerminating())
    {
      tree.addStartTag(HtmlDocument.createTag(localElement, paramTag.getAttributes(), paramTag.getOriginalHtmlBeforeAttributes(), paramTag.getOriginalHtmlAfterAttributes()));
      paramTag = HtmlDocument.createEndTag(localElement);
      tableFixer.seeEndTag(paramTag);
      tree.addEndTag(paramTag);
      return;
    }
    tree.addStartTag(paramTag);
    push(localElement);
  }
  
  public void visitText(HtmlDocument.Text paramText)
  {
    tableFixer.seeText(paramText);
    tree.addText(paramText);
  }
  
  class TableFixer
  {
    private int state;
    private int tables = 0;
    
    TableFixer() {}
    
    private void ensureCellState()
    {
      if (state != 1)
      {
        HtmlTreeBuilder.this.push(HTML4.TD_ELEMENT);
        HtmlDocument.Tag localTag = HtmlDocument.createTag(HTML4.TD_ELEMENT, null);
        tree.addStartTag(localTag);
        state = 1;
      }
    }
    
    private void ensureTableState()
    {
      if (tables == 0)
      {
        HtmlTreeBuilder.this.push(HTML4.TABLE_ELEMENT);
        HtmlDocument.Tag localTag = HtmlDocument.createTag(HTML4.TABLE_ELEMENT, null);
        tree.addStartTag(localTag);
        tables += 1;
      }
    }
    
    void finish()
    {
      boolean bool2 = true;
      if (tables == 0)
      {
        bool1 = true;
        X.assertTrue(bool1);
        if (state != 0) {
          break label34;
        }
      }
      label34:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        X.assertTrue(bool1);
        return;
        bool1 = false;
        break;
      }
    }
    
    void seeEndTag(HtmlDocument.EndTag paramEndTag)
    {
      int i = 1;
      paramEndTag = paramEndTag.getElement();
      if ((tables > 0) && (paramEndTag.getType() == 1))
      {
        if ((!HTML4.TD_ELEMENT.equals(paramEndTag)) && (!HTML4.TR_ELEMENT.equals(paramEndTag)) && (!HTML4.TH_ELEMENT.equals(paramEndTag))) {
          break label58;
        }
        state = 0;
      }
      label58:
      do
      {
        return;
        if (HTML4.CAPTION_ELEMENT.equals(paramEndTag))
        {
          state = 0;
          return;
        }
      } while (!HTML4.TABLE_ELEMENT.equals(paramEndTag));
      boolean bool;
      if (tables > 0)
      {
        bool = true;
        X.assertTrue(bool);
        tables -= 1;
        if (tables <= 0) {
          break label125;
        }
      }
      for (;;)
      {
        state = i;
        return;
        bool = false;
        break;
        label125:
        i = 0;
      }
    }
    
    void seeTag(HtmlDocument.Tag paramTag)
    {
      paramTag = paramTag.getElement();
      if (paramTag.getType() == 1) {
        if (HTML4.TABLE_ELEMENT.equals(paramTag))
        {
          if (tables > 0) {
            ensureCellState();
          }
          tables += 1;
          state = 0;
        }
      }
      while ((tables <= 0) || (HTML4.FORM_ELEMENT.equals(paramTag)))
      {
        do
        {
          return;
          ensureTableState();
          if ((HTML4.TD_ELEMENT.equals(paramTag)) || (HTML4.TH_ELEMENT.equals(paramTag)))
          {
            state = 1;
            return;
          }
        } while (!HTML4.CAPTION_ELEMENT.equals(paramTag));
        state = 2;
        return;
      }
      ensureCellState();
    }
    
    void seeText(HtmlDocument.Text paramText)
    {
      if ((tables > 0) && (state == 0) && (!paramText.isWhitespace())) {
        ensureCellState();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlTreeBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */