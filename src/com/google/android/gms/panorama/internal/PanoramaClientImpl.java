package com.google.android.gms.panorama.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.GmsClient.CallbackProxy;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.panorama.PanoramaClient.OnPanoramaInfoLoadedListener;

public class PanoramaClientImpl
  extends GmsClient<IPanoramaService>
{
  public PanoramaClientImpl(Context paramContext, GooglePlayServicesClient.ConnectionCallbacks paramConnectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])null);
  }
  
  public IPanoramaService createServiceInterface(IBinder paramIBinder)
  {
    return IPanoramaService.Stub.asInterface(paramIBinder);
  }
  
  protected String getServiceDescriptor()
  {
    return "com.google.android.gms.panorama.internal.IPanoramaService";
  }
  
  protected void getServiceFromBroker(IGmsServiceBroker paramIGmsServiceBroker, GmsClient<IPanoramaService>.GmsCallbacks paramGmsClient)
    throws RemoteException
  {
    Bundle localBundle = new Bundle();
    paramIGmsServiceBroker.getPanoramaService(paramGmsClient, 1, getContext().getPackageName(), localBundle);
  }
  
  protected String getStartServiceAction()
  {
    return "com.google.android.gms.panorama.service.START";
  }
  
  public void loadPanoramaInfo(PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
  {
    checkConnected();
    if (paramBoolean) {
      getContext().grantUriPermission("com.google.android.gms", paramUri, 1);
    }
    if (paramBoolean) {}
    for (Uri localUri = paramUri;; localUri = null)
    {
      paramOnPanoramaInfoLoadedListener = new PanoramaInfoLoadedBinderCallbacks(paramOnPanoramaInfoLoadedListener, localUri);
      try
      {
        ((IPanoramaService)getService()).loadPanoramaInfo(paramOnPanoramaInfoLoadedListener, paramUri, paramBundle, paramBoolean);
        return;
      }
      catch (RemoteException paramUri)
      {
        paramOnPanoramaInfoLoadedListener.onPanoramaInfoLoaded(8, null, 0, null);
      }
    }
  }
  
  final class PanoramaInfoLoadedBinderCallbacks
    extends IPanoramaCallbacks.Stub
  {
    private final PanoramaClient.OnPanoramaInfoLoadedListener mListener;
    private final Uri mRevokeUri;
    
    public PanoramaInfoLoadedBinderCallbacks(PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, Uri paramUri)
    {
      mListener = paramOnPanoramaInfoLoadedListener;
      mRevokeUri = paramUri;
    }
    
    public void onPanoramaInfoLoaded(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (mRevokeUri != null) {
        getContext().revokeUriPermission(mRevokeUri, 1);
      }
      PendingIntent localPendingIntent = null;
      if (paramBundle != null) {
        localPendingIntent = (PendingIntent)paramBundle.getParcelable("pendingIntent");
      }
      paramBundle = new ConnectionResult(paramInt1, localPendingIntent);
      doCallback(new PanoramaClientImpl.PanoramaInfoLoadedCallback(PanoramaClientImpl.this, mListener, paramBundle, paramInt2, paramIntent));
    }
  }
  
  final class PanoramaInfoLoadedCallback
    extends GmsClient<IPanoramaService>.CallbackProxy<PanoramaClient.OnPanoramaInfoLoadedListener>
  {
    public final ConnectionResult status;
    public final int type;
    public final Intent viewerIntent;
    
    public PanoramaInfoLoadedCallback(PanoramaClient.OnPanoramaInfoLoadedListener paramOnPanoramaInfoLoadedListener, ConnectionResult paramConnectionResult, int paramInt, Intent paramIntent)
    {
      super(paramOnPanoramaInfoLoadedListener);
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.internal.PanoramaClientImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */