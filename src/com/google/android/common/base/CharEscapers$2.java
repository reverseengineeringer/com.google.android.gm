package com.google.android.common.base;

final class CharEscapers$2
  extends CharEscaper
{
  protected char[] escape(char paramChar)
  {
    if (paramChar <= '') {
      return null;
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
 * Qualified Name:     com.google.android.common.base.CharEscapers.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */