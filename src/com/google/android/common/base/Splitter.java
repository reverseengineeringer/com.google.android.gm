package com.google.android.common.base;

public final class Splitter
{
  private final boolean omitEmptyStrings;
  private final Strategy strategy;
  private final CharMatcher trimmer;
  
  private Splitter(Strategy paramStrategy)
  {
    this(paramStrategy, false, CharMatcher.NONE);
  }
  
  private Splitter(Strategy paramStrategy, boolean paramBoolean, CharMatcher paramCharMatcher)
  {
    strategy = paramStrategy;
    omitEmptyStrings = paramBoolean;
    trimmer = paramCharMatcher;
  }
  
  public static Splitter on(char paramChar)
  {
    return on(CharMatcher.is(paramChar));
  }
  
  public static Splitter on(CharMatcher paramCharMatcher)
  {
    Preconditions.checkNotNull(paramCharMatcher);
    new Splitter(new Strategy() {});
  }
  
  public Splitter omitEmptyStrings()
  {
    return new Splitter(strategy, true, trimmer);
  }
  
  private static abstract interface Strategy {}
}

/* Location:
 * Qualified Name:     com.google.android.common.base.Splitter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */