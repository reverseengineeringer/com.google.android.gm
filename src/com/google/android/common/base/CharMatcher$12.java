package com.google.android.common.base;

final class CharMatcher$12
  extends CharMatcher
{
  CharMatcher$12(char paramChar1, char paramChar2) {}
  
  public boolean matches(char paramChar)
  {
    return (val$startInclusive <= paramChar) && (paramChar <= val$endInclusive);
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    char c2;
    for (char c1 = val$startInclusive;; c1 = c2)
    {
      paramLookupTable.set(c1);
      c2 = (char)(c1 + '\001');
      if (c1 == val$endInclusive) {
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */