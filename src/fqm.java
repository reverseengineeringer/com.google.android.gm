import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.administration.GetStorageStatsCall.Request;

final class fqm
  implements fqk
{
  private IBinder a;
  
  fqm(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(Bundle paramBundle, fqh paramfqh)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          if (paramfqh != null)
          {
            paramBundle = paramfqh.asBinder();
            localParcel1.writeStrongBinder(paramBundle);
            a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramBundle = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GetStorageStatsCall.Request paramRequest, fqh paramfqh)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramfqh != null)
          {
            paramRequest = paramfqh.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramRequest = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void a(fqh paramfqh)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +42 -> 57
    //   18: aload_1
    //   19: invokeinterface 45 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fqm:a	Landroid/os/IBinder;
    //   34: iconst_4
    //   35: aload_2
    //   36: aload_3
    //   37: iconst_0
    //   38: invokeinterface 54 5 0
    //   43: pop
    //   44: aload_3
    //   45: invokevirtual 57	android/os/Parcel:readException	()V
    //   48: aload_3
    //   49: invokevirtual 60	android/os/Parcel:recycle	()V
    //   52: aload_2
    //   53: invokevirtual 60	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aconst_null
    //   58: astore_1
    //   59: goto -34 -> 25
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 60	android/os/Parcel:recycle	()V
    //   67: aload_2
    //   68: invokevirtual 60	android/os/Parcel:recycle	()V
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	fqm
    //   0	73	1	paramfqh	fqh
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     fqm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */