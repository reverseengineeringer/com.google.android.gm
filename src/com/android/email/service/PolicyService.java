package com.android.email.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bbe;
import bff;
import com.android.email.SecurityPolicy;
import cvl;

public class PolicyService
  extends Service
{
  public static final String a = cvl.a;
  public SecurityPolicy b;
  public Context c;
  private final bff d = new bbe(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    c = this;
    b = SecurityPolicy.a(this);
    return d;
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.PolicyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */