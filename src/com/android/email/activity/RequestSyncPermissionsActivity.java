package com.android.email.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import bam;
import buo;
import but;
import com.android.emailcommon.provider.Account;
import cvm;
import eo;
import ep;
import er;
import java.util.ArrayList;

public class RequestSyncPermissionsActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getStringArrayListExtra("permissions");
      if (paramBundle == null) {
        break label110;
      }
      paramBundle = (String[])paramBundle.toArray(new String[paramBundle.size()]);
      if (Build.VERSION.SDK_INT < 23) {
        break label78;
      }
      if ((this instanceof er)) {
        ((er)this).b_(0);
      }
      requestPermissions(paramBundle, 0);
    }
    label78:
    while (!(this instanceof ep))
    {
      return;
      paramBundle = null;
      break;
    }
    new Handler(Looper.getMainLooper()).post(new eo(paramBundle, this, 0));
    return;
    label110:
    finish();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 0)
    {
      int i = 0;
      paramInt = 0;
      if (i < paramArrayOfString.length)
      {
        int j;
        label33:
        String str1;
        if (paramArrayOfInt[i] == 0)
        {
          j = 1;
          but localbut = buo.a();
          String str2 = paramArrayOfString[i];
          if (j == 0) {
            break label93;
          }
          str1 = "granted";
          label53:
          localbut.a("permissions_notification", str2, str1, 0L);
          if ((paramInt == 0) && (j == 0)) {
            break label100;
          }
        }
        label93:
        label100:
        for (paramInt = 1;; paramInt = 0)
        {
          i += 1;
          break;
          j = 0;
          break label33;
          str1 = "denied";
          break label53;
        }
      }
      if (paramInt != 0)
      {
        paramArrayOfString = (Account)getIntent().getParcelableExtra("account");
        if (paramArrayOfString == null) {}
      }
    }
    try
    {
      bam.a(this, paramArrayOfString);
      finish();
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      for (;;)
      {
        cvm.d(cvm.a, paramArrayOfString, "exception requesting initial sync post-grant", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.activity.RequestSyncPermissionsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */