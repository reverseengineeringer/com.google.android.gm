package com.google.android.common.base;

abstract class CharEscapers$FastCharEscaper
  extends CharEscaper
{
  protected final int replacementLength;
  protected final char[][] replacements;
  protected final char safeMax;
  protected final char safeMin;
  
  public CharEscapers$FastCharEscaper(char[][] paramArrayOfChar, char paramChar1, char paramChar2)
  {
    replacements = paramArrayOfChar;
    replacementLength = paramArrayOfChar.length;
    safeMin = paramChar1;
    safeMax = paramChar2;
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
        if (((k < replacementLength) && (replacements[k] != null)) || (k < safeMin) || (k > safeMax)) {
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
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharEscapers.FastCharEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */