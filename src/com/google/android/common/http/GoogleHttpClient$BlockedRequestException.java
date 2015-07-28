package com.google.android.common.http;

import java.io.IOException;

public class GoogleHttpClient$BlockedRequestException
  extends IOException
{
  private final UrlRules.Rule mRule;
  
  GoogleHttpClient$BlockedRequestException(UrlRules.Rule paramRule)
  {
    super("Blocked by rule: " + mName);
    mRule = paramRule;
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.http.GoogleHttpClient.BlockedRequestException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */