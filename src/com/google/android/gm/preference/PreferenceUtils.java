package com.google.android.gm.preference;

import android.content.Context;
import android.content.Intent;

public final class PreferenceUtils
{
  public static void validateNotificationsForAccount(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("com.google.android.gm.intent.VALIDATE_ACCOUNT_NOTIFICATIONS");
    localIntent.putExtra("account", paramString);
    paramContext.sendBroadcast(localIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.preference.PreferenceUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */