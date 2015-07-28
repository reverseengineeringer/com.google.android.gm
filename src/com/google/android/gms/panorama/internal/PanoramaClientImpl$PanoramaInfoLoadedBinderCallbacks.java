package com.google.android.gms.panorama.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

final class PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks
  extends IPanoramaCallbacks.Stub
{
  private final PanoramaClient.OnPanoramaInfoLoadedListener mListener;
  private final Uri mRevokeUri;
  
  public PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks(PanoramaClientImpl paramPanoramaClientImpl, PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri)
  {
    mListener = paramOnPanoramaInfoLoadedListener;
    mRevokeUri = paramUri;
  }
  
  public void onPanoramaInfoLoaded(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (mRevokeUri != null) {
      this$0.getContext().revokeUriPermission(mRevokeUri, 1);
    }
    PendingIntent localPendingIntent = null;
    if (paramBundle != null) {
      localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent");
    }
    paramBundle = new ConnectionResult(paramInt1, localPendingIntent);
    this$0.doCallback(new PanoramaClientImpl.PanoramaInfoLoadedCallback(this$0, mListener, paramBundle, paramInt2, paramIntent));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.internal.PanoramaClientImpl.PanoramaInfoLoadedBinderCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */