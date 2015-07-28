package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.panorama.internal.PanoramaClientImpl;

public class PanoramaClient
  implements GooglePlayServicesClient
{
  private final PanoramaClientImpl mClientImpl;
  
  public PanoramaClient(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    mClientImpl = new PanoramaClientImpl(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void connect()
  {
    mClientImpl.connect();
  }
  
  public void disconnect()
  {
    mClientImpl.disconnect();
  }
  
  public boolean isConnected()
  {
    return mClientImpl.isConnected();
  }
  
  public void loadPanoramaInfoAndGrantAccess(OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri, Bundle paramBundle)
  {
    mClientImpl.loadPanoramaInfo(paramOnPanoramaInfoLoadedListener, paramUri, paramBundle, true);
  }
  
  public static abstract interface OnPanoramaInfoLoadedListener
  {
    public abstract void onPanoramaInfoLoaded(ConnectionResult paramConnectionResult, int paramInt, Intent paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.PanoramaClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */