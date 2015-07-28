package com.google.android.common.html.parser;

import com.google.android.common.base.X;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HtmlDocument$Tag
  extends HtmlDocument.Node
{
  private List<HtmlDocument.TagAttribute> attributes;
  private final HTML.Element element;
  private final boolean isSelfTerminating;
  private final String originalHtmlAfterAttributes;
  private final String originalHtmlBeforeAttributes;
  
  private HtmlDocument$Tag(HTML.Element paramElement, List<HtmlDocument.TagAttribute> paramList, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramElement != null) {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      element = paramElement;
      attributes = paramList;
      isSelfTerminating = paramBoolean;
      originalHtmlBeforeAttributes = paramString1;
      originalHtmlAfterAttributes = paramString2;
      return;
    }
  }
  
  public void accept(HtmlDocument.Visitor paramVisitor)
  {
    paramVisitor.visitTag(this);
  }
  
  public List<HtmlDocument.TagAttribute> getAttributes()
  {
    return attributes;
  }
  
  public List<HtmlDocument.TagAttribute> getAttributes(HTML.Attribute paramAttribute)
  {
    ArrayList localArrayList = Lists.newArrayList();
    if (attributes != null)
    {
      Iterator localIterator = attributes.iterator();
      while (localIterator.hasNext())
      {
        HtmlDocument.TagAttribute localTagAttribute = (HtmlDocument.TagAttribute)localIterator.next();
        if (localTagAttribute.getAttribute().equals(paramAttribute)) {
          localArrayList.add(localTagAttribute);
        }
      }
    }
    return localArrayList;
  }
  
  public HTML.Element getElement()
  {
    return element;
  }
  
  public String getName()
  {
    return element.getName();
  }
  
  public String getOriginalHtmlAfterAttributes()
  {
    return originalHtmlAfterAttributes;
  }
  
  public String getOriginalHtmlBeforeAttributes()
  {
    return originalHtmlBeforeAttributes;
  }
  
  public boolean isSelfTerminating()
  {
    return isSelfTerminating;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Start Tag: ");
    localStringBuilder.append(element.getName());
    if (attributes != null)
    {
      Iterator localIterator = attributes.iterator();
      while (localIterator.hasNext())
      {
        HtmlDocument.TagAttribute localTagAttribute = (HtmlDocument.TagAttribute)localIterator.next();
        localStringBuilder.append(' ');
        localStringBuilder.append(localTagAttribute.toString());
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument.Tag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */