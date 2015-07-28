package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract class IGmsCallbacks$Stub
  extends Binder
  implements IGmsCallbacks
{
  public IGmsCallbacks$Stub()
  {
    attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
  }
  
  public static IGmsCallbacks asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof IGmsCallbacks))) {
      return (IGmsCallbacks)localIInterface;
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
      paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
    paramInt1 = paramParcel1.readInt();
    IBinder localIBinder = paramParcel1.readStrongBinder();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onPostInitComplete(paramInt1, localIBinder, paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
  
  private static class Proxy
    implements IGmsCallbacks
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
    
    /* Error */
    public void onPostInitComplete(int paramInt, IBinder paramIBinder, Bundle paramBundle)
      throws RemoteException
    {
      // Byte code:
      //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   3: astore 4
      //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   8: astore 5
      //   10: aload 4
      //   12: ldc 34
      //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   17: aload 4
      //   19: iload_1
      //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   23: aload 4
      //   25: aload_2
      //   26: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
      //   29: aload_3
      //   30: ifnull +48 -> 78
      //   33: aload 4
      //   35: iconst_1
      //   36: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   39: aload_3
      //   40: aload 4
      //   42: iconst_0
      //   43: invokevirtual 51	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
      //   46: aload_0
      //   47: getfield 19	com/google/android/gms/common/internal/IGmsCallbacks$Stub$Proxy:mRemote	Landroid/os/IBinder;
      //   50: iconst_1
      //   51: aload 4
      //   53: aload 5
      //   55: iconst_0
      //   56: invokeinterface 57 5 0
      //   61: pop
      //   62: aload 5
      //   64: invokevirtual 60	android/os/Parcel:readException	()V
      //   67: aload 5
      //   69: invokevirtual 63	android/os/Parcel:recycle	()V
      //   72: aload 4
      //   74: invokevirtual 63	android/os/Parcel:recycle	()V
      //   77: return
      //   78: aload 4
      //   80: iconst_0
      //   81: invokevirtual 42	android/os/Parcel:writeInt	(I)V
      //   84: goto -38 -> 46
      //   87: astore_2
      //   88: aload 5
      //   90: invokevirtual 63	android/os/Parcel:recycle	()V
      //   93: aload 4
      //   95: invokevirtual 63	android/os/Parcel:recycle	()V
      //   98: aload_2
      //   99: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	100	0	this	Proxy
      //   0	100	1	paramInt	int
      //   0	100	2	paramIBinder	IBinder
      //   0	100	3	paramBundle	Bundle
      //   3	91	4	localParcel1	Parcel
      //   8	81	5	localParcel2	Parcel
      // Exception table:
      //   from	to	target	type
      //   10	29	87	finally
      //   33	46	87	finally
      //   46	67	87	finally
      //   78	84	87	finally
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.IGmsCallbacks.Stub
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */