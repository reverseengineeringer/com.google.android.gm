package com.google.android.common.base;

class CharMatcher$14
  extends CharMatcher
{
  CharMatcher$14(CharMatcher paramCharMatcher1, CharMatcher paramCharMatcher2) {}
  
  public boolean matches(char paramChar)
  {
    return !val$original.matches(paramChar);
  }
  
  public CharMatcher negate()
  {
    return val$original;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */