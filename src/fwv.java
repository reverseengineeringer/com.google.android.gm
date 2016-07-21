import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.data.DataHolder;

final class fwv
  implements fwt
{
  private IBinder a;
  
  fwv(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(int paramInt, Bundle paramBundle1, Bundle paramBundle2)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
        localParcel.writeInt(paramInt);
        if (paramBundle1 != null)
        {
          localParcel.writeInt(1);
          paramBundle1.writeToParcel(localParcel, 0);
          if (paramBundle2 != null)
          {
            localParcel.writeInt(1);
            paramBundle2.writeToParcel(localParcel, 0);
            a.transact(1, localParcel, null, 1);
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
    }
  }
  
  public final void a(int paramInt, Bundle paramBundle, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
        localParcel.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel.writeInt(1);
          paramBundle.writeToParcel(localParcel, 0);
          if (paramParcelFileDescriptor != null)
          {
            localParcel.writeInt(1);
            paramParcelFileDescriptor.writeToParcel(localParcel, 0);
            a.transact(3, localParcel, null, 1);
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
    }
  }
  
  public final void a(int paramInt, Bundle paramBundle1, ParcelFileDescriptor paramParcelFileDescriptor, Bundle paramBundle2)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
        localParcel.writeInt(paramInt);
        if (paramBundle1 != null)
        {
          localParcel.writeInt(1);
          paramBundle1.writeToParcel(localParcel, 0);
          if (paramParcelFileDescriptor != null)
          {
            localParcel.writeInt(1);
            paramParcelFileDescriptor.writeToParcel(localParcel, 0);
            if (paramBundle2 == null) {
              break label118;
            }
            localParcel.writeInt(1);
            paramBundle2.writeToParcel(localParcel, 0);
            a.transact(5, localParcel, null, 1);
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
      continue;
      label118:
      localParcel.writeInt(0);
    }
  }
  
  public final void a(int paramInt, Bundle paramBundle, DataHolder paramDataHolder)
  {
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.people.internal.IPeopleCallbacks");
        localParcel.writeInt(paramInt);
        if (paramBundle != null)
        {
          localParcel.writeInt(1);
          paramBundle.writeToParcel(localParcel, 0);
          if (paramDataHolder != null)
          {
            localParcel.writeInt(1);
            paramDataHolder.writeToParcel(localParcel, 0);
            a.transact(2, localParcel, null, 1);
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
    }
  }
  
  /* Error */
  public final void a(int paramInt, Bundle paramBundle, DataHolder[] paramArrayOfDataHolder)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: aload 4
    //   7: ldc 25
    //   9: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 4
    //   14: iload_1
    //   15: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   18: aload_2
    //   19: ifnull +44 -> 63
    //   22: aload 4
    //   24: iconst_1
    //   25: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   28: aload_2
    //   29: aload 4
    //   31: iconst_0
    //   32: invokevirtual 39	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload 4
    //   37: aload_3
    //   38: iconst_0
    //   39: invokevirtual 62	android/os/Parcel:writeTypedArray	([Landroid/os/Parcelable;I)V
    //   42: aload_0
    //   43: getfield 15	fwv:a	Landroid/os/IBinder;
    //   46: iconst_4
    //   47: aload 4
    //   49: aconst_null
    //   50: iconst_1
    //   51: invokeinterface 45 5 0
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 48	android/os/Parcel:recycle	()V
    //   62: return
    //   63: aload 4
    //   65: iconst_0
    //   66: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   69: goto -34 -> 35
    //   72: astore_2
    //   73: aload 4
    //   75: invokevirtual 48	android/os/Parcel:recycle	()V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	fwv
    //   0	80	1	paramInt	int
    //   0	80	2	paramBundle	Bundle
    //   0	80	3	paramArrayOfDataHolder	DataHolder[]
    //   3	71	4	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   5	18	72	finally
    //   22	35	72	finally
    //   35	57	72	finally
    //   63	69	72	finally
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     fwv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */