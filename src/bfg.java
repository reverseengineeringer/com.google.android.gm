import android.os.IBinder;
import android.os.Parcel;
import com.android.emailcommon.provider.Policy;

final class bfg
  implements bfe
{
  private IBinder a;
  
  bfg(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.android.emailcommon.service.IPolicyService");
      a.transact(5, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  /* Error */
  public final void a(long paramLong, Policy paramPolicy, String paramString)
  {
    // Byte code:
    //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 24
    //   14: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: lload_1
    //   20: invokevirtual 42	android/os/Parcel:writeLong	(J)V
    //   23: aload_3
    //   24: ifnull +55 -> 79
    //   27: aload 5
    //   29: iconst_1
    //   30: invokevirtual 46	android/os/Parcel:writeInt	(I)V
    //   33: aload_3
    //   34: aload 5
    //   36: iconst_0
    //   37: invokevirtual 52	com/android/emailcommon/provider/Policy:writeToParcel	(Landroid/os/Parcel;I)V
    //   40: aload 5
    //   42: aload 4
    //   44: invokevirtual 55	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   47: aload_0
    //   48: getfield 15	bfg:a	Landroid/os/IBinder;
    //   51: iconst_3
    //   52: aload 5
    //   54: aload 6
    //   56: iconst_0
    //   57: invokeinterface 34 5 0
    //   62: pop
    //   63: aload 6
    //   65: invokevirtual 58	android/os/Parcel:readException	()V
    //   68: aload 6
    //   70: invokevirtual 37	android/os/Parcel:recycle	()V
    //   73: aload 5
    //   75: invokevirtual 37	android/os/Parcel:recycle	()V
    //   78: return
    //   79: aload 5
    //   81: iconst_0
    //   82: invokevirtual 46	android/os/Parcel:writeInt	(I)V
    //   85: goto -45 -> 40
    //   88: astore_3
    //   89: aload 6
    //   91: invokevirtual 37	android/os/Parcel:recycle	()V
    //   94: aload 5
    //   96: invokevirtual 37	android/os/Parcel:recycle	()V
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	bfg
    //   0	101	1	paramLong	long
    //   0	101	3	paramPolicy	Policy
    //   0	101	4	paramString	String
    //   3	92	5	localParcel1	Parcel
    //   8	82	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	23	88	finally
    //   27	40	88	finally
    //   40	68	88	finally
    //   79	85	88	finally
  }
  
  public final void a(long paramLong, Policy paramPolicy, String paramString, boolean paramBoolean)
  {
    int i = 1;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.emailcommon.service.IPolicyService");
        localParcel1.writeLong(paramLong);
        if (paramPolicy != null)
        {
          localParcel1.writeInt(1);
          paramPolicy.writeToParcel(localParcel1, 0);
          localParcel1.writeString(paramString);
          if (paramBoolean)
          {
            localParcel1.writeInt(i);
            a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        i = 0;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    int i = 0;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IPolicyService");
      localParcel1.writeLong(paramLong);
      if (paramBoolean) {
        i = 1;
      }
      localParcel1.writeInt(i);
      a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean a(Policy paramPolicy)
  {
    boolean bool = true;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.emailcommon.service.IPolicyService");
        if (paramPolicy != null)
        {
          localParcel1.writeInt(1);
          paramPolicy.writeToParcel(localParcel1, 0);
          a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          if (i != 0) {
            return bool;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        bool = false;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
  
  public final boolean b()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IPolicyService");
      a.transact(6, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     bfg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */