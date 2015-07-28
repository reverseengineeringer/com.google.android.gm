package com.google.android.common.base;

final class CharMatcher$10
  extends CharMatcher
{
  CharMatcher$10(char paramChar1, char paramChar2) {}
  
  public boolean matches(char paramChar)
  {
    return (paramChar == val$match1) || (paramChar == val$match2);
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    paramLookupTable.set(val$match1);
    paramLookupTable.set(val$match2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */