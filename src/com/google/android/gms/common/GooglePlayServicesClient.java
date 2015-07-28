package com.google.android.gms.common;

public abstract interface GooglePlayServicesClient
{
  public static abstract interface ConnectionCallbacks
  {
    public abstract void onConnected();
    
    public abstract void onDisconnected();
  }
  
  public static abstract interface OnConnectionFailedListener
  {
    public abstract void onConnectionFailed(ConnectionResult paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */