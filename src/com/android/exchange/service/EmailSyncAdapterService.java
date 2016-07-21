package com.android.exchange.service;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Intent;
import android.os.IBinder;
import bro;
import bss;
import btg;
import cvm;

public class EmailSyncAdapterService
  extends bro
{
  private static final Object c = new Object();
  private static AbstractThreadedSyncAdapter d = null;
  
  protected final AbstractThreadedSyncAdapter a()
  {
    synchronized (c)
    {
      if (d == null) {
        d = new bss(this, this);
      }
      AbstractThreadedSyncAdapter localAbstractThreadedSyncAdapter = d;
      return localAbstractThreadedSyncAdapter;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return super.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    cvm.a("Exchange", "EmailSyncAdapterService.onCreate()", new Object[0]);
    super.onCreate();
    cvm.c("Exchange", "EmailSyncAdapterService.onCreate stoppedOldService=%s", new Object[] { Boolean.valueOf(btg.a(this, "com.android.exchange.service.EmailSyncAdapterService")) });
    startService(new Intent(this, EmailSyncAdapterService.class));
  }
  
  public void onDestroy()
  {
    cvm.a("Exchange", "EmailSyncAdapterService.onDestroy()", new Object[0]);
    super.onDestroy();
  }
}

/* Location:
 * Qualified Name:     com.android.exchange.service.EmailSyncAdapterService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */