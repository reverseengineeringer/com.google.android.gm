package com.android.mail.compose;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import cvl;
import cvm;

public class EmptyService
  extends Service
{
  private static final String a = cvl.a;
  
  public IBinder onBind(Intent paramIntent)
  {
    cvm.c(a, "onBind()", new Object[0]);
    return null;
  }
  
  public void onCreate()
  {
    cvm.a(a, "onCreate()", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.EmptyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */