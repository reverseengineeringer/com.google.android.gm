import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.googlehelp.GoogleHelp;

final class fky
  implements fkw
{
  private IBinder a;
  
  fky(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(Bitmap paramBitmap, fkt paramfkt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramBitmap != null)
        {
          localParcel1.writeInt(1);
          paramBitmap.writeToParcel(localParcel1, 0);
          if (paramfkt != null)
          {
            paramBitmap = paramfkt.asBinder();
            localParcel1.writeStrongBinder(paramBitmap);
            a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramBitmap = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(GoogleHelp paramGoogleHelp, Bitmap paramBitmap, fkt paramfkt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramGoogleHelp != null)
        {
          localParcel1.writeInt(1);
          paramGoogleHelp.writeToParcel(localParcel1, 0);
          if (paramBitmap != null)
          {
            localParcel1.writeInt(1);
            paramBitmap.writeToParcel(localParcel1, 0);
            if (paramfkt == null) {
              break label131;
            }
            paramGoogleHelp = paramfkt.asBinder();
            localParcel1.writeStrongBinder(paramGoogleHelp);
            a.transact(2, localParcel1, localParcel2, 0);
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
      continue;
      label131:
      paramGoogleHelp = null;
    }
  }
  
  public final void a(GoogleHelp paramGoogleHelp, fkt paramfkt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.googlehelp.internal.common.IGoogleHelpService");
        if (paramGoogleHelp != null)
        {
          localParcel1.writeInt(1);
          paramGoogleHelp.writeToParcel(localParcel1, 0);
          if (paramfkt != null)
          {
            paramGoogleHelp = paramfkt.asBinder();
            localParcel1.writeStrongBinder(paramGoogleHelp);
            a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramGoogleHelp = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final void a(fkt paramfkt)
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
    //   31: getfield 15	fky:a	Landroid/os/IBinder;
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
    //   0	73	0	this	fky
    //   0	73	1	paramfkt	fkt
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
  
  /* Error */
  public final void b(fkt paramfkt)
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
    //   31: getfield 15	fky:a	Landroid/os/IBinder;
    //   34: iconst_5
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
    //   0	73	0	this	fky
    //   0	73	1	paramfkt	fkt
    //   3	65	2	localParcel1	Parcel
    //   7	57	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	62	finally
    //   18	25	62	finally
    //   25	48	62	finally
  }
  
  /* Error */
  public final void c(fkt paramfkt)
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
    //   15: ifnull +43 -> 58
    //   18: aload_1
    //   19: invokeinterface 45 1 0
    //   24: astore_1
    //   25: aload_2
    //   26: aload_1
    //   27: invokevirtual 48	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   30: aload_0
    //   31: getfield 15	fky:a	Landroid/os/IBinder;
    //   34: bipush 6
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 54 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 57	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 60	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 60	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aconst_null
    //   59: astore_1
    //   60: goto -35 -> 25
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 60	android/os/Parcel:recycle	()V
    //   68: aload_2
    //   69: invokevirtual 60	android/os/Parcel:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	fky
    //   0	74	1	paramfkt	fkt
    //   3	66	2	localParcel1	Parcel
    //   7	58	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	63	finally
    //   18	25	63	finally
    //   25	49	63	finally
  }
}

/* Location:
 * Qualified Name:     fky
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */