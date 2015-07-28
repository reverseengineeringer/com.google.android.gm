package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

final class GmsClient$GmsServiceConnection
  implements ServiceConnection
{
  GmsClient$GmsServiceConnection(GmsClient paramGmsClient) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    Log.d("GmsClient", "service broker connected, binder: " + paramIBinder);
    this$0.onServiceBrokerBound(paramIBinder);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    Log.d("GmsClient", "service disconnected: " + paramComponentName);
    GmsClient.access$002(this$0, null);
    this$0.onDisconnection();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient.GmsServiceConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */