import android.os.IBinder;

final class ehv
  implements eht
{
  private IBinder a;
  
  ehv(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  /* Error */
  public final void a(ehq paramehq, com.google.android.gms.clearcut.LogEventParcelable paramLogEventParcelable)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: aload 4
    //   9: ldc 25
    //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: invokeinterface 35 1 0
    //   24: astore_3
    //   25: aload 4
    //   27: aload_3
    //   28: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   31: aload_2
    //   32: ifnull +37 -> 69
    //   35: aload 4
    //   37: iconst_1
    //   38: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   41: aload_2
    //   42: aload 4
    //   44: iconst_0
    //   45: invokevirtual 48	com/google/android/gms/clearcut/LogEventParcelable:writeToParcel	(Landroid/os/Parcel;I)V
    //   48: aload_0
    //   49: getfield 15	ehv:a	Landroid/os/IBinder;
    //   52: iconst_1
    //   53: aload 4
    //   55: aconst_null
    //   56: iconst_1
    //   57: invokeinterface 54 5 0
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 57	android/os/Parcel:recycle	()V
    //   68: return
    //   69: aload 4
    //   71: iconst_0
    //   72: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   75: goto -27 -> 48
    //   78: astore_1
    //   79: aload 4
    //   81: invokevirtual 57	android/os/Parcel:recycle	()V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ehv
    //   0	86	1	paramehq	ehq
    //   0	86	2	paramLogEventParcelable	com.google.android.gms.clearcut.LogEventParcelable
    //   1	27	3	localIBinder	IBinder
    //   5	75	4	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   7	14	78	finally
    //   18	25	78	finally
    //   25	31	78	finally
    //   35	48	78	finally
    //   48	63	78	finally
    //   69	75	78	finally
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     ehv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */