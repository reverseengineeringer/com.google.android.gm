package com.android.email;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import arh;
import com.android.email.service.EmailBroadcastProcessorService;

public class SecurityPolicy$PolicyAdmin
  extends DeviceAdminReceiver
{
  public CharSequence onDisableRequested(Context paramContext, Intent paramIntent)
  {
    return paramContext.getString(arh.bb);
  }
  
  public void onDisabled(Context paramContext, Intent paramIntent)
  {
    EmailBroadcastProcessorService.a(paramContext, 2);
  }
  
  public void onEnabled(Context paramContext, Intent paramIntent)
  {
    EmailBroadcastProcessorService.a(paramContext, 1);
  }
  
  public void onPasswordChanged(Context paramContext, Intent paramIntent)
  {
    EmailBroadcastProcessorService.a(paramContext, 3);
  }
  
  public void onPasswordExpiring(Context paramContext, Intent paramIntent)
  {
    EmailBroadcastProcessorService.a(paramContext, 4);
  }
}

/* Location:
 * Qualified Name:     com.android.email.SecurityPolicy.PolicyAdmin
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */