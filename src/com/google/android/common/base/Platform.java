package com.google.android.common.base;

final class Platform
{
  private static final ThreadLocal<char[]> DEST_TL = new ThreadLocal()
  {
    protected char[] initialValue()
    {
      return new char['Ѐ'];
    }
  };
  
  static char[] charBufferFromThreadLocal()
  {
    return (char[])DEST_TL.get();
  }
  
  static CharMatcher precomputeCharMatcher(CharMatcher paramCharMatcher)
  {
    return paramCharMatcher.precomputedInternal();
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.Platform
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */