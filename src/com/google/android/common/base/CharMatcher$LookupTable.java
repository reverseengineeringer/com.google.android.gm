package com.google.android.common.base;

public class CharMatcher$LookupTable
{
  int[] data = new int['ࠀ'];
  
  boolean get(char paramChar)
  {
    return (data[(paramChar >> '\005')] & '\001' << paramChar) != 0;
  }
  
  void set(char paramChar)
  {
    int[] arrayOfInt = data;
    int i = paramChar >> '\005';
    arrayOfInt[i] |= '\001' << paramChar;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.LookupTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */