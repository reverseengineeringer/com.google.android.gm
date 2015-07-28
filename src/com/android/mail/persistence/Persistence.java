package com.android.mail.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.mail.utils.LogTag;

public class Persistence
{
  public static final String TAG = ;
  private static Persistence mInstance = null;
  private static SharedPreferences sSharedPrefs;
  
  public static SharedPreferences getPreferences(Context paramContext)
  {
    if (sSharedPrefs == null) {
      sSharedPrefs = paramContext.getSharedPreferences("UnifiedEmail", 0);
    }
    return sSharedPrefs;
  }
  
  private String makeKey(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString1 != null) {
      str = paramString1 + "-" + paramString2;
    }
    return str;
  }
  
  private void remove(Context paramContext, String paramString)
  {
    paramContext = getPreferences(paramContext).edit();
    paramContext.remove(paramString);
    paramContext.apply();
  }
  
  public void remove(Context paramContext, String paramString1, String paramString2)
  {
    remove(paramContext, makeKey(paramString1, paramString2));
  }
}

/* Location:
 * Qualified Name:     com.android.mail.persistence.Persistence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */