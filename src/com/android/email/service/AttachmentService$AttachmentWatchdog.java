package com.android.email.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import bad;

public class AttachmentService$AttachmentWatchdog
  extends BroadcastReceiver
{
  private PendingIntent a;
  
  public final void a(Context paramContext)
  {
    a(paramContext, 20000L);
  }
  
  public final void a(Context paramContext, long paramLong)
  {
    if (a == null)
    {
      Intent localIntent = new Intent(paramContext, AttachmentWatchdog.class);
      localIntent.putExtra("callback_timeout", 660000);
      a = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
    }
    ((AlarmManager)paramContext.getSystemService("alarm")).set(0, System.currentTimeMillis() + paramLong, a);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    new Thread(new bad(this, paramIntent.getIntExtra("callback_timeout", 660000)), "AttachmentService AttachmentWatchdog").start();
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.AttachmentService.AttachmentWatchdog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */