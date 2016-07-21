import android.os.IBinder;
import android.os.Parcel;

final class bex
  implements bev
{
  private IBinder a;
  
  bex(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final int a(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IAccountService");
      localParcel1.writeLong(paramLong);
      a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      return i;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final android.os.Bundle a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_2
    //   15: aload_1
    //   16: invokevirtual 53	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 15	bex:a	Landroid/os/IBinder;
    //   23: iconst_2
    //   24: aload_2
    //   25: aload_3
    //   26: iconst_0
    //   27: invokeinterface 39 5 0
    //   32: pop
    //   33: aload_3
    //   34: invokevirtual 42	android/os/Parcel:readException	()V
    //   37: aload_3
    //   38: invokevirtual 46	android/os/Parcel:readInt	()I
    //   41: ifeq +26 -> 67
    //   44: getstatic 59	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   47: aload_3
    //   48: invokeinterface 65 2 0
    //   53: checkcast 55	android/os/Bundle
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 49	android/os/Parcel:recycle	()V
    //   61: aload_2
    //   62: invokevirtual 49	android/os/Parcel:recycle	()V
    //   65: aload_1
    //   66: areturn
    //   67: aconst_null
    //   68: astore_1
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_3
    //   74: invokevirtual 49	android/os/Parcel:recycle	()V
    //   77: aload_2
    //   78: invokevirtual 49	android/os/Parcel:recycle	()V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	bex
    //   0	83	1	paramString	String
    //   3	75	2	localParcel1	Parcel
    //   7	67	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	57	72	finally
  }
  
  public final String a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IAccountService");
      a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      String str = localParcel2.readString();
      return str;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     bex
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */