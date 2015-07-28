package com.google.android.gms.panorama.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class IPanoramaCallbacks$Stub
  extends Binder
  implements IPanoramaCallbacks
{
  public IPanoramaCallbacks$Stub()
  {
    attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
  }
  
  public static IPanoramaCallbacks asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof IPanoramaCallbacks))) {
      return (IPanoramaCallbacks)localIInterface;
    }
    return new Proxy(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
    paramInt1 = paramParcel1.readInt();
    Bundle localBundle;
    if (paramParcel1.readInt() != 0)
    {
      localBundle = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      paramInt2 = paramParcel1.readInt();
      if (paramParcel1.readInt() == 0) {
        break label126;
      }
    }
    label126:
    for (paramParcel1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onPanoramaInfoLoaded(paramInt1, localBundle, paramInt2, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localBundle = null;
      break;
    }
  }
  
  private static class Proxy
    implements IPanoramaCallbacks
  {
    private IBinder mRemote;
    
    Proxy(IBinder paramIBinder)
    {
      mRemote = paramIBinder;
    }
    
    public IBinder asBinder()
    {
      return mRemote;
    }
    
    public void onPanoramaInfoLoaded(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
      throws RemoteException
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      for (;;)
      {
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
          localParcel1.writeInt(paramInt1);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            localParcel1.writeInt(paramInt2);
            if (paramIntent != null)
            {
              localParcel1.writeInt(1);
              paramIntent.writeToParcel(localParcel1, 0);
              mRemote.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
            }
          }
          else
          {
            localParcel1.writeInt(0);
            continue;
          }
          localParcel1.writeInt(0);
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.panorama.internal.IPanoramaCallbacks.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */