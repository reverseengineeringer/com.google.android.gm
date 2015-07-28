package com.google.android.common.base;

import java.util.Arrays;

final class CharMatcher$6
  extends CharMatcher
{
  public String collapseFrom(CharSequence paramCharSequence, char paramChar)
  {
    if (paramCharSequence.length() == 0) {
      return "";
    }
    return String.valueOf(paramChar);
  }
  
  public int indexIn(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 0) {
      return -1;
    }
    return 0;
  }
  
  public int indexIn(CharSequence paramCharSequence, int paramInt)
  {
    int j = paramCharSequence.length();
    Preconditions.checkPositionIndex(paramInt, j);
    int i = paramInt;
    if (paramInt == j) {
      i = -1;
    }
    return i;
  }
  
  public boolean matches(char paramChar)
  {
    return true;
  }
  
  public CharMatcher negate()
  {
    return NONE;
  }
  
  public CharMatcher or(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    return this;
  }
  
  public CharMatcher precomputed()
  {
    return this;
  }
  
  public String removeFrom(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return "";
  }
  
  public String replaceFrom(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = new char[paramCharSequence.length()];
    Arrays.fill(paramCharSequence, paramChar);
    return new String(paramCharSequence);
  }
  
  public String replaceFrom(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence1.length() * paramCharSequence2.length());
    int i = 0;
    while (i < paramCharSequence1.length())
    {
      localStringBuilder.append(paramCharSequence2);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String trimFrom(CharSequence paramCharSequence)
  {
    Preconditions.checkNotNull(paramCharSequence);
    return "";
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharMatcher.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */