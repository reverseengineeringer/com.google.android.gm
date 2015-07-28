package com.google.android.common.html.parser;

import com.google.android.common.base.X;

class HtmlParser$AttributeScanner
{
  boolean attrValueIsQuoted = false;
  int endNamePos = -1;
  int endValuePos = -1;
  private final String html;
  private String name;
  int startNamePos = -1;
  int startValuePos = -1;
  private String value;
  
  public HtmlParser$AttributeScanner(String paramString)
  {
    html = paramString;
  }
  
  private int skipSpaces(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      if ((paramInt1 >= paramInt2) || (!Character.isWhitespace(html.charAt(paramInt1)))) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
  }
  
  public String getName()
  {
    if ((name == null) && (startNamePos != -1) && (endNamePos != -1)) {
      name = html.substring(startNamePos, endNamePos);
    }
    return name;
  }
  
  public String getValue()
  {
    if ((value == null) && (startValuePos != -1) && (endValuePos != -1)) {
      value = html.substring(startValuePos, endValuePos);
    }
    return value;
  }
  
  public void reset()
  {
    startNamePos = -1;
    endNamePos = -1;
    startValuePos = -1;
    endValuePos = -1;
    attrValueIsQuoted = false;
    name = null;
    value = null;
  }
  
  int scanName(int paramInt1, int paramInt2)
  {
    if (html.charAt(paramInt1) != '>') {}
    for (boolean bool = true;; bool = false)
    {
      X.assertTrue(bool);
      if (paramInt1 != paramInt2) {
        break;
      }
      return paramInt1;
    }
    int i = paramInt1 + 1;
    for (;;)
    {
      if (i < paramInt2)
      {
        char c = html.charAt(i);
        if ((c != '>') && (c != '=') && (c != '/') && (!Character.isWhitespace(c))) {}
      }
      else
      {
        startNamePos = paramInt1;
        endNamePos = i;
        return i;
      }
      i += 1;
    }
  }
  
  int scanValue(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    int i = skipSpaces(paramInt1, paramInt2);
    if ((i == paramInt2) || (html.charAt(i) != '=')) {
      return paramInt1;
    }
    i = skipSpaces(i + 1, paramInt2);
    if (i == paramInt2) {
      return i;
    }
    int k = html.charAt(i);
    if ((k == 39) || (k == 34))
    {
      attrValueIsQuoted = true;
      int j = i + 1;
      for (paramInt1 = j;; paramInt1 = i + 1)
      {
        i = paramInt1;
        if ((i >= paramInt2) || (html.charAt(i) == k)) {
          break;
        }
      }
      startValuePos = j;
      endValuePos = i;
      paramInt1 = i;
      if (i < paramInt2) {
        paramInt1 = i + 1;
      }
      if (startValuePos <= -1) {
        break label267;
      }
      bool1 = true;
      label160:
      X.assertTrue(bool1);
      if (endValuePos <= -1) {
        break label273;
      }
      bool1 = true;
      label176:
      X.assertTrue(bool1);
      if (startValuePos > endValuePos) {
        break label279;
      }
      bool1 = true;
      label195:
      X.assertTrue(bool1);
      if (paramInt1 > paramInt2) {
        break label285;
      }
    }
    label267:
    label273:
    label279:
    label285:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      X.assertTrue(bool1);
      return paramInt1;
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 < paramInt2)
        {
          char c = html.charAt(paramInt1);
          if ((c != '>') && (!Character.isWhitespace(c))) {}
        }
        else
        {
          startValuePos = i;
          endValuePos = paramInt1;
          break;
        }
        paramInt1 += 1;
      }
      bool1 = false;
      break label160;
      bool1 = false;
      break label176;
      bool1 = false;
      break label195;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.html.parser.HtmlParser.AttributeScanner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */