package com.google.android.gms.panorama.internal;

import android.content.Intent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClient.CallbackProxy;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

final class PanoramaClientImpl$PanoramaInfoLoadedCallback
  extends GmsClient<IPanoramaService>.CallbackProxy<PanoramaClient.OnPanoramaInfoLoadedListener>
{
  public final ConnectionResult status;
  public final int type;
  public final Intent viewerIntent;
  
  public PanoramaClientImpl$PanoramaInfoLoadedCallback(PanoramaClientImpl paramPanoramaClientImpl, PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, ConnectionResult paramConnectionResult, int paramInt, Intent paramIntent)
  {
    super(paramPanoramaClientImpl, paramOnPanoramaInfoLoadedListener);
    status = paramConnectionResult;
    type = paramInt;
    viewerIntent = paramIntent;
  }
  
  protected void deliverCallback(PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener)
  {
    if (paramOnPanoramaInfoLoadedListener != null) {
      paramOnPanoramaInfoLoadedListener.onPanoramaInfoLoaded(status, type, viewerIntent);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.internal.PanoramaClientImpl.PanoramaInfoLoadedCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */