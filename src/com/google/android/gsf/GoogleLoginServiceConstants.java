package com.google.android.gsf;

import android.content.Intent;

public class GoogleLoginServiceConstants
{
  public static final Intent SERVICE_INTENT = new Intent("com.google.android.gsf.action.GET_GLS");
  
  public static String featureForService(String paramString)
  {
    return "service_" + paramString;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gsf.GoogleLoginServiceConstants
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */