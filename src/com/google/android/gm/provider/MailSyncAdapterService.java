package com.google.android.gm.provider;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import dtz;

public class MailSyncAdapterService
  extends Service
{
  private static final Object a = new Object();
  private static dtz b;
  
  public IBinder onBind(Intent arg1)
  {
    synchronized (a)
    {
      IBinder localIBinder = b.getSyncAdapterBinder();
      return localIBinder;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    synchronized (a)
    {
      if (b == null) {
        b = new dtz(this);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSyncAdapterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */