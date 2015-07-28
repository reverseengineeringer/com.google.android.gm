package com.google.android.common;

public class GoogleTrafficStats
{
  public static int getDomainType(String paramString)
  {
    if (paramString.contains("google.com")) {
      return 805306368;
    }
    if ((paramString.contains("gmail.com")) || (paramString.contains("googlemail.com"))) {
      return 268435456;
    }
    return 536870912;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.GoogleTrafficStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */