package com.android.email.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import bak;

public class EasTestAuthenticatorService
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    if ("android.accounts.AccountAuthenticator".equals(paramIntent.getAction())) {
      return new bak(this, this).getIBinder();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.EasTestAuthenticatorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */