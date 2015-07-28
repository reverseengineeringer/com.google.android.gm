package com.google.android.common.base;

final class CharMatcher$9
  extends CharMatcher
{
  CharMatcher$9(char paramChar) {}
  
  public boolean matches(char paramChar)
  {
    return paramChar != val$match;
  }
  
  public CharMatcher negate()
  {
    return is(val$match);
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    Object localObject = this;
    if (paramCharMatcher.matches(val$match)) {
      localObject = ANY;
    }
    return (CharMatcher)localObject;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */