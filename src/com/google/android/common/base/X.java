package com.google.android.common.base;

public final class X
{
  public static void assertTrue(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new RuntimeException("Assertion failed");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.X
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */