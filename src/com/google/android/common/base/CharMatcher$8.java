package com.google.android.common.base;

final class CharMatcher$8
  extends CharMatcher
{
  CharMatcher$8(char paramChar) {}
  
  public boolean matches(char paramChar)
  {
    return paramChar == val$match;
  }
  
  public CharMatcher negate()
  {
    return isNot(val$match);
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    if (paramCharMatcher.matches(val$match)) {
      return paramCharMatcher;
    }
    return super.or(paramCharMatcher);
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString().replace(val$match, paramChar);
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable)
  {
    paramLookupTable.set(val$match);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */