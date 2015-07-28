package com.google.android.common.base;

final class CharMatcher$7
  extends CharMatcher
{
  public String collapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public int indexIn(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return -1;
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt)
  {
    Preconditions.checkPositionIndex(paramInt, paramCharSequence.length());
    return -1;
  }
  
  public boolean matches(char paramChar)
  {
    return false;
  }
  
  public CharMatcher negate()
  {
    return ANY;
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    return (CharMatcher)Preconditions.checkNotNull(paramCharMatcher);
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
  
  public String removeFrom(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    Preconditions.checkNotNull(paramCharSequence2);
    return paramCharSequence1.toString();
  }
  
  protected void setBits(CharMatcher.LookupTable paramLookupTable) {}
  
  public String trimFrom(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */