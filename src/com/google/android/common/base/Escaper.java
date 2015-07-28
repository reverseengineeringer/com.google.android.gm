package com.google.android.common.base;

public abstract class Escaper
{
  private final Function<String, String> asFunction = new Function()
  {
    public String apply(String paramAnonymousString)
    {
      return escape(paramAnonymousString);
    }
  };
  
  public abstract String escape(String paramString);
}

/* Location:
 * Qualified Name:     com.google.android.common.base.Escaper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */