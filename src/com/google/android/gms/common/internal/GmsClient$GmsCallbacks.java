package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

public final class GmsClient$GmsCallbacks
  extends IGmsCallbacks.Stub
{
  protected GmsClient$GmsCallbacks(GmsClient paramGmsClient) {}
  
  public void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    this$0.mHandler.sendMessage(this$0.mHandler.obtainMessage(1, new GmsClient.PostInitCallback(this$0, paramInt, paramIBinder, paramBundle)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.GmsClient.GmsCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */