package com.google.android.gm.provider;

import cvl;

public final class SearchQuery
{
  public static final String a = cvl.a;
  public final String b = paramArrayOfString[0];
  public final String[] c;
  
  public SearchQuery(String paramString, String[] paramArrayOfString)
  {
    if ((!b.equals("documents")) && (!b.equals("tags")))
    {
      paramString = String.valueOf(b);
      if (paramString.length() != 0) {}
      for (paramString = "Unknown type: ".concat(paramString);; paramString = new String("Unknown type: ")) {
        throw new IllegalArgumentException(paramString);
      }
    }
    c = new String[3];
    c[0] = paramString;
    c[1] = paramArrayOfString[1];
    c[2] = paramArrayOfString[2];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.SearchQuery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */