package com.google.android.common.html.parser;

import com.google.android.common.base.X;

class HtmlTreeBuilder$TableFixer
{
  private int state;
  private int tables = 0;
  
  HtmlTreeBuilder$TableFixer(HtmlTreeBuilder paramHtmlTreeBuilder) {}
  
  private void ensureCellState()
  {
    if (state != 1)
    {
      HtmlTreeBuilder.access$000(this$0, HTML4.TD_ELEMENT);
      HtmlDocument.Tag localTag = HtmlDocument.createTag(HTML4.TD_ELEMENT, null);
      HtmlTreeBuilder.access$100(this$0).addStartTag(localTag);
      state = 1;
    }
  }
  
  private void ensureTableState()
  {
    if (tables == 0)
    {
      HtmlTreeBuilder.access$000(this$0, HTML4.TABLE_ELEMENT);
      HtmlDocument.Tag localTag = HtmlDocument.createTag(HTML4.TABLE_ELEMENT, null);
      HtmlTreeBuilder.access$100(this$0).addStartTag(localTag);
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

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlTreeBuilder.TableFixer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */