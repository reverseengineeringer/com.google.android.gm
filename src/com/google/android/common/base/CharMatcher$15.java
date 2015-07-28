package com.google.android.common.base;

class CharMatcher$15
  extends CharMatcher
{
  CharMatcher$15(CharMatcher paramCharMatcher, CharMatcher.LookupTable paramLookupTable) {}
  
  public boolean matches(char paramChar)
  {
    return val$table.get(paramChar);
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */