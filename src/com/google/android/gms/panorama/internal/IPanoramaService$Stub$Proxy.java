package com.google.android.gms.panorama.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

class IPanoramaService$Stub$Proxy
  implements IPanoramaService
{
  private IBinder mRemote;
  
  IPanoramaService$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  public void loadPanoramaInfo(IPanoramaCallbacks paramIPanoramaCallbacks, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
    throws RemoteException
  {
    IBinder localIBinder = null;
    int i = 1;
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
        if (paramIPanoramaCallbacks != null) {
          localIBinder = paramIPanoramaCallbacks.asBinder();
        }
        localParcel.writeStrongBinder(localIBinder);
        if (paramUri != null)
        {
          localParcel.writeInt(1);
          paramUri.writeToParcel(localParcel, 0);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
            break label134;
            localParcel.writeInt(i);
            mRemote.transact(1, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      label134:
      while (!paramBoolean)
      {
        i = 0;
        break;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.internal.IPanoramaService.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */