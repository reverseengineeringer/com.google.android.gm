package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import java.util.ArrayList;

final class GmsClient$CallbackHandler
  extends Handler
{
  GmsClient$CallbackHandler(GmsClient paramGmsClient) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (what == 3) {
      this$0.onConnectionFailure(new ConnectionResult(((Integer)obj).intValue(), null));
    }
    do
    {
      return;
      if (what == 4) {
        synchronized (GmsClient.access$100(this$0))
        {
          if ((this$0.mPerformConnectionCallbacks) && (this$0.isConnected()) && (GmsClient.access$100(this$0).contains(obj))) {
            ((GooglePlayServicesClient.ConnectionCallbacks)obj).onConnected();
          }
          return;
        }
      }
    } while (((what == 2) && (!this$0.isConnected())) || ((what != 2) && (what != 1)));
    ((GmsClient.CallbackProxy)obj).deliverCallback();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient.CallbackHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */