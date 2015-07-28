package com.google.android.common.base;

class CharEscapers$JavascriptCharEscaper
  extends CharEscapers.FastCharEscaper
{
  public CharEscapers$JavascriptCharEscaper(char[][] paramArrayOfChar)
  {
    super(paramArrayOfChar, ' ', '~');
  }
  
  protected char[] escape(char paramChar)
  {
    if (paramChar < replacementLength)
    {
      char[] arrayOfChar = replacements[paramChar];
      if (arrayOfChar != null) {
        return arrayOfChar;
      }
    }
    if ((safeMin <= paramChar) && (paramChar <= safeMax)) {
      return null;
    }
    if (paramChar < 'Ā')
    {
      i = CharEscapers.access$100()[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      return new char[] { '\\', 'x', CharEscapers.access$100()[(paramChar & 0xF)], i };
    }
    int i = CharEscapers.access$100()[(paramChar & 0xF)];
    paramChar = (char)(paramChar >>> '\004');
    int j = CharEscapers.access$100()[(paramChar & 0xF)];
    paramChar = (char)(paramChar >>> '\004');
    int k = CharEscapers.access$100()[(paramChar & 0xF)];
    paramChar = (char)(paramChar >>> '\004');
    return new char[] { '\\', 'u', CharEscapers.access$100()[(paramChar & 0xF)], k, j, i };
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharEscapers.JavascriptCharEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */