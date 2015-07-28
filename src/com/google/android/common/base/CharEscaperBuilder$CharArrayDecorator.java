package com.google.android.common.base;

class CharEscaperBuilder$CharArrayDecorator
  extends CharEscaper
{
  private final int replaceLength;
  private final char[][] replacements;
  
  CharEscaperBuilder$CharArrayDecorator(char[][] paramArrayOfChar)
  {
    replacements = paramArrayOfChar;
    replaceLength = paramArrayOfChar.length;
  }
  
  public String escape(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        int k = paramString.charAt(i);
        if ((k < replacements.length) && (replacements[k] != null)) {
          str = escapeSlow(paramString, i);
        }
      }
      else
      {
        return str;
      }
      i += 1;
    }
  }
  
  protected char[] escape(char paramChar)
  {
    if (paramChar < replaceLength) {
      return replacements[paramChar];
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharEscaperBuilder.CharArrayDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */