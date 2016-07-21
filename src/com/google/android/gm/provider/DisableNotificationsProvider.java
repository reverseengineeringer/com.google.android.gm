package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import buo;
import but;
import cfg;
import cxd;
import dnm;
import dol;
import eik;

public final class DisableNotificationsProvider
  extends ContentProvider
{
  private final boolean a()
  {
    if (eik.a(getContext()) != 0) {
      return false;
    }
    int i = Binder.getCallingUid();
    eik.a(getContext().getPackageManager(), i);
    return true;
  }
  
  public final Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool1 = true;
    if (!a()) {
      return null;
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return super.call(paramString1, paramString2, paramBundle);
        if (paramString1.equals("areNotificationOperationsSupported"))
        {
          i = 0;
          continue;
          if (paramString1.equals("areNotificationsEnabled"))
          {
            i = 1;
            continue;
            if (paramString1.equals("disableNotifications")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramString1 = new Bundle(1);
    paramString1.putBoolean("supported", true);
    return paramString1;
    paramString1 = new Bundle(1);
    boolean bool2 = ContentResolver.getMasterSyncAutomatically();
    boolean bool3 = ContentResolver.getSyncAutomatically(new Account(paramString2, "com.google"), "gmail-ls");
    if ((bool2) && (bool3))
    {
      i = 1;
      bool2 = dnm.a(getContext(), paramString2).b();
      if ((i == 0) || (!bool2)) {
        break label234;
      }
    }
    for (;;)
    {
      paramString1.putBoolean("enabled", bool1);
      return paramString1;
      i = 0;
      break;
      label234:
      bool1 = false;
    }
    paramString1 = dnm.a(getContext(), paramString2);
    bool1 = paramString1.b();
    if (bool1)
    {
      paramString1.a(false);
      dol.a(getContext(), paramString2);
      if (!cxd.c()) {
        break label317;
      }
    }
    label317:
    for (paramString1 = getCallingPackage();; paramString1 = "unknown")
    {
      buo.a().a("settings", "disable_notifications", paramString1, 0L);
      paramString1 = new Bundle(1);
      paramString1.putBoolean("disabled", bool1);
      return paramString1;
    }
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (!a()) {}
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    if (!a()) {}
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    if (!a()) {}
    return null;
  }
  
  public final boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    if (!a()) {}
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if (!a()) {}
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.DisableNotificationsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */