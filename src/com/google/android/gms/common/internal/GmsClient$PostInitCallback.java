package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class GmsClient$PostInitCallback
  extends GmsClient<T>.CallbackProxy<Boolean>
{
  public final Bundle resolution;
  public final IBinder service;
  public final int statusCode;
  
  public GmsClient$PostInitCallback(GmsClient paramGmsClient, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramGmsClient, Boolean.valueOf(true));
    statusCode = paramInt;
    service = paramIBinder;
    resolution = paramBundle;
  }
  
  protected void deliverCallback(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    switch (statusCode)
    {
    default: 
      paramBoolean = (PendingIntent)resolution.getParcelable("pendingIntent");
      this$0.onConnectionFailure(new ConnectionResult(statusCode, paramBoolean));
      return;
    }
    try
    {
      paramBoolean = service.getInterfaceDescriptor();
      if (this$0.getServiceDescriptor().equals(paramBoolean))
      {
        Log.d("GmsClient", "bound to service broker");
        GmsClient.access$002(this$0, this$0.createServiceInterface(service));
        if (GmsClient.access$000(this$0) != null)
        {
          this$0.onConnectionSuccess();
          return;
        }
      }
    }
    catch (RemoteException paramBoolean)
    {
      GmsClient.access$400(this$0).unbindService(GmsClient.access$300(this$0));
      GmsClient.access$302(this$0, null);
      GmsClient.access$002(this$0, null);
      this$0.onConnectionFailure(new ConnectionResult(8, null));
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient.PostInitCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */