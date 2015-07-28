package com.google.android.gms.common.internal;

public final class Preconditions
{
  private Preconditions()
  {
    throw new AssertionError("Uninstantiable");
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException("null reference");
    }
    return paramT;
  }
  
  public static void checkState(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new IllegalStateException();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.Preconditions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */