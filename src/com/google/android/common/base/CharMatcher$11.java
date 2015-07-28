package com.google.android.common.base;

import java.util.Arrays;

final class CharMatcher$11
  extends CharMatcher
{
  CharMatcher$11(char[] paramArrayOfChar) {}
  
  public boolean matches(char paramChar)
  {
    return Arrays.binarySearch(val$chars, paramChar) >= 0;
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    char[] arrayOfChar = val$chars;
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      paramLookupTable.set(arrayOfChar[i]);
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */