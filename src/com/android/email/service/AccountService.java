package com.android.email.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bab;
import bbt;
import bew;
import java.io.IOException;

public class AccountService
  extends Service
{
  public Context a;
  private final bew b = new bab(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    if (a == null) {
      a = this;
    }
    try
    {
      bbt.a(this);
      return b;
    }
    catch (IOException paramIntent)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.AccountService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */