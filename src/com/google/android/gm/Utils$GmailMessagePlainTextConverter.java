package com.google.android.gm;

import com.google.android.common.html.parser.HTML.Attribute;
import com.google.android.common.html.parser.HTML.Element;
import com.google.android.common.html.parser.HTML4;
import com.google.android.common.html.parser.HtmlDocument;
import com.google.android.common.html.parser.HtmlDocument.Node;
import com.google.android.common.html.parser.HtmlDocument.Tag;
import com.google.android.common.html.parser.HtmlDocument.TagAttribute;
import com.google.android.common.html.parser.HtmlTree.DefaultPlainTextConverter;
import java.util.Iterator;
import java.util.List;

public class Utils$GmailMessagePlainTextConverter
  extends HtmlTree.DefaultPlainTextConverter
{
  private static final HTML.Attribute ELIDED_TEXT_ATTRIBUTE = new HTML.Attribute("class", 0);
  private static final HtmlDocument.Node ELIDED_TEXT_REPLACEMENT_NODE = HtmlDocument.createSelfTerminatingTag(HTML4.BR_ELEMENT, null, null, null);
  private int mEndNodeElidedTextBlock = -1;
  
  public void addNode(HtmlDocument.Node paramNode, int paramInt1, int paramInt2)
  {
    if (paramInt1 < mEndNodeElidedTextBlock) {}
    int i;
    do
    {
      return;
      if (paramInt1 == mEndNodeElidedTextBlock)
      {
        super.addNode(ELIDED_TEXT_REPLACEMENT_NODE, paramInt1, paramInt2);
        return;
      }
      if (!(paramNode instanceof HtmlDocument.Tag)) {
        break;
      }
      int j = 0;
      Object localObject = (HtmlDocument.Tag)paramNode;
      i = j;
      if ("div".equals(((HtmlDocument.Tag)localObject).getElement().getName()))
      {
        localObject = ((HtmlDocument.Tag)localObject).getAttributes(ELIDED_TEXT_ATTRIBUTE).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!"elided-text".equals(((HtmlDocument.TagAttribute)((Iterator)localObject).next()).getValue()));
        mEndNodeElidedTextBlock = paramInt2;
        i = 1;
      }
    } while (i != 0);
    super.addNode(paramNode, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.GmailMessagePlainTextConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */