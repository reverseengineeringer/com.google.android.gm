package com.google.android.common.base;

class CharEscapers$JavaCharEscaper
  extends CharEscapers.FastCharEscaper
{
  public CharEscapers$JavaCharEscaper(char[][] paramArrayOfChar)
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
    if (paramChar <= 'ÿ')
    {
      i = CharEscapers.access$100()[(paramChar & 0x7)];
      paramChar = (char)(paramChar >>> '\003');
      j = CharEscapers.access$100()[(paramChar & 0x7)];
      paramChar = (char)(paramChar >>> '\003');
      return new char[] { '\\', CharEscapers.access$100()[(paramChar & 0x7)], j, i };
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
 * Qualified Name:     com.google.android.common.base.CharEscapers.JavaCharEscaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */