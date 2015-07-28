package com.google.android.common.html.parser;

import com.google.android.common.base.CharMatcher;
import com.google.android.common.base.StringUtil;
import com.google.android.common.base.X;
import com.google.common.collect.Lists;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HtmlDocument
{
  private final List<Node> nodes;
  
  public HtmlDocument(List<Node> paramList)
  {
    nodes = paramList;
  }
  
  public static CDATA createCDATA(String paramString)
  {
    return new CDATA(paramString, null);
  }
  
  public static EndTag createEndTag(HTML.Element paramElement)
  {
    return createEndTag(paramElement, null);
  }
  
  public static EndTag createEndTag(HTML.Element paramElement, String paramString)
  {
    return new EndTag(paramElement, paramString, null);
  }
  
  public static Text createEscapedText(String paramString1, String paramString2)
  {
    return new EscapedText(paramString1, paramString2, null);
  }
  
  public static Comment createHtmlComment(String paramString)
  {
    return new Comment(paramString);
  }
  
  public static Tag createSelfTerminatingTag(HTML.Element paramElement, List<TagAttribute> paramList)
  {
    return createSelfTerminatingTag(paramElement, paramList, null, null);
  }
  
  public static Tag createSelfTerminatingTag(HTML.Element paramElement, List<TagAttribute> paramList, String paramString1, String paramString2)
  {
    return new Tag(paramElement, paramList, true, paramString1, paramString2, null);
  }
  
  public static Tag createTag(HTML.Element paramElement, List<TagAttribute> paramList)
  {
    return createTag(paramElement, paramList, null, null);
  }
  
  public static Tag createTag(HTML.Element paramElement, List<TagAttribute> paramList, String paramString1, String paramString2)
  {
    return new Tag(paramElement, paramList, false, paramString1, paramString2, null);
  }
  
  public static TagAttribute createTagAttribute(HTML.Attribute paramAttribute, String paramString)
  {
    return createTagAttribute(paramAttribute, paramString, null);
  }
  
  public static TagAttribute createTagAttribute(HTML.Attribute paramAttribute, String paramString1, String paramString2)
  {
    if (paramAttribute != null) {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      return new TagAttribute(paramAttribute, paramString1, paramString2, null);
    }
  }
  
  public static Text createText(String paramString1, String paramString2)
  {
    return new UnescapedText(paramString1, paramString2, null);
  }
  
  public void accept(Visitor paramVisitor)
  {
    paramVisitor.start();
    Iterator localIterator = nodes.iterator();
    while (localIterator.hasNext()) {
      ((Node)localIterator.next()).accept(paramVisitor);
    }
    paramVisitor.finish();
  }
  
  public String toString()
  {
    StringWriter localStringWriter = new StringWriter();
    accept(new DebugPrinter(new PrintWriter(localStringWriter)));
    return localStringWriter.toString();
  }
  
  public static class CDATA
    extends HtmlDocument.UnescapedText
  {
    private CDATA(String paramString)
    {
      super(paramString, null);
    }
  }
  
  public static class Comment
    extends HtmlDocument.Node
  {
    private final String content;
    
    public Comment(String paramString)
    {
      content = paramString;
    }
    
    public void accept(HtmlDocument.Visitor paramVisitor)
    {
      paramVisitor.visitComment(this);
    }
    
    public String getContent()
    {
      return content;
    }
  }
  
  public static class DebugPrinter
    implements HtmlDocument.Visitor
  {
    private final PrintWriter writer;
    
    public DebugPrinter(PrintWriter paramPrintWriter)
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
  
  public static class EndTag
    extends HtmlDocument.Node
  {
    private final HTML.Element element;
    private final String originalHtml;
    
    private EndTag(HTML.Element paramElement, String paramString)
    {
      if (paramElement != null) {}
      for (boolean bool = true;; bool = false)
      {
        X.assertTrue(bool);
        element = paramElement;
        originalHtml = paramString;
        return;
      }
    }
    
    public void accept(HtmlDocument.Visitor paramVisitor)
    {
      paramVisitor.visitEndTag(this);
    }
    
    public HTML.Element getElement()
    {
      return element;
    }
    
    public String getName()
    {
      return element.getName();
    }
    
    public String toString()
    {
      return "End Tag: " + element.getName();
    }
  }
  
  private static class EscapedText
    extends HtmlDocument.Text
  {
    private final String htmlText;
    private String text;
    
    private EscapedText(String paramString1, String paramString2)
    {
      super();
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
  
  public static abstract class Node
  {
    public abstract void accept(HtmlDocument.Visitor paramVisitor);
  }
  
  public static class Tag
    extends HtmlDocument.Node
  {
    private List<HtmlDocument.TagAttribute> attributes;
    private final HTML.Element element;
    private final boolean isSelfTerminating;
    private final String originalHtmlAfterAttributes;
    private final String originalHtmlBeforeAttributes;
    
    private Tag(HTML.Element paramElement, List<HtmlDocument.TagAttribute> paramList, boolean paramBoolean, String paramString1, String paramString2)
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
  
  public static class TagAttribute
  {
    private final HTML.Attribute attribute;
    private String originalHtml;
    private String value;
    
    private TagAttribute(HTML.Attribute paramAttribute, String paramString1, String paramString2)
    {
      if (paramAttribute != null) {}
      for (boolean bool = true;; bool = false)
      {
        X.assertTrue(bool);
        attribute = paramAttribute;
        value = paramString1;
        originalHtml = paramString2;
        return;
      }
    }
    
    public HTML.Attribute getAttribute()
    {
      return attribute;
    }
    
    public String getName()
    {
      return attribute.getName();
    }
    
    public String getValue()
    {
      if (value != null) {
        return value;
      }
      return "";
    }
    
    public String toString()
    {
      return "{" + attribute.getName() + "=" + value + "}";
    }
  }
  
  public static abstract class Text
    extends HtmlDocument.Node
  {
    private final String originalHtml;
    
    protected Text(String paramString)
    {
      originalHtml = paramString;
    }
    
    public void accept(HtmlDocument.Visitor paramVisitor)
    {
      paramVisitor.visitText(this);
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof Text)) {
          break label47;
        }
        paramObject = (Text)paramObject;
        if (originalHtml != null) {
          break;
        }
      } while (originalHtml == null);
      return false;
      return originalHtml.equals(originalHtml);
      label47:
      return false;
    }
    
    public String getOriginalHTML()
    {
      return originalHtml;
    }
    
    public abstract String getText();
    
    public int hashCode()
    {
      if (originalHtml == null) {
        return 0;
      }
      return originalHtml.hashCode();
    }
    
    public boolean isWhitespace()
    {
      String str = getText();
      int j = str.length();
      int i = 0;
      while (i < j)
      {
        if (!Character.isWhitespace(str.charAt(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    
    public String toString()
    {
      return getText();
    }
  }
  
  private static class UnescapedText
    extends HtmlDocument.Text
  {
    protected final String text;
    
    private UnescapedText(String paramString1, String paramString2)
    {
      super();
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
  
  public static abstract interface Visitor
  {
    public abstract void finish();
    
    public abstract void start();
    
    public abstract void visitComment(HtmlDocument.Comment paramComment);
    
    public abstract void visitEndTag(HtmlDocument.EndTag paramEndTag);
    
    public abstract void visitTag(HtmlDocument.Tag paramTag);
    
    public abstract void visitText(HtmlDocument.Text paramText);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlDocument
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */