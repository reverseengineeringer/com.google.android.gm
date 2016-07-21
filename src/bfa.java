import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.emailcommon.provider.RecipientAvailability;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;
import java.util.List;

final class bfa
  implements bey
{
  private IBinder a;
  
  bfa(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final int a()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      a.transact(13, localParcel1, localParcel2, 0);
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
  public final int a(long paramLong, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload 5
    //   19: lload_1
    //   20: invokevirtual 49	android/os/Parcel:writeLong	(J)V
    //   23: aload_3
    //   24: ifnull +71 -> 95
    //   27: aload 5
    //   29: iconst_1
    //   30: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   33: aload_3
    //   34: aload 5
    //   36: iconst_0
    //   37: invokevirtual 59	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   40: aload_0
    //   41: getfield 15	bfa:a	Landroid/os/IBinder;
    //   44: iconst_4
    //   45: aload 5
    //   47: aload 6
    //   49: iconst_0
    //   50: invokeinterface 35 5 0
    //   55: pop
    //   56: aload 6
    //   58: invokevirtual 38	android/os/Parcel:readException	()V
    //   61: aload 6
    //   63: invokevirtual 41	android/os/Parcel:readInt	()I
    //   66: istore 4
    //   68: aload 6
    //   70: invokevirtual 41	android/os/Parcel:readInt	()I
    //   73: ifeq +9 -> 82
    //   76: aload_3
    //   77: aload 6
    //   79: invokevirtual 63	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
    //   82: aload 6
    //   84: invokevirtual 44	android/os/Parcel:recycle	()V
    //   87: aload 5
    //   89: invokevirtual 44	android/os/Parcel:recycle	()V
    //   92: iload 4
    //   94: ireturn
    //   95: aload 5
    //   97: iconst_0
    //   98: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   101: goto -61 -> 40
    //   104: astore_3
    //   105: aload 6
    //   107: invokevirtual 44	android/os/Parcel:recycle	()V
    //   110: aload 5
    //   112: invokevirtual 44	android/os/Parcel:recycle	()V
    //   115: aload_3
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	bfa
    //   0	117	1	paramLong	long
    //   0	117	3	paramBundle	Bundle
    //   66	27	4	i	int
    //   3	108	5	localParcel1	Parcel
    //   8	98	6	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   10	23	104	finally
    //   27	40	104	finally
    //   40	82	104	finally
    //   95	101	104	finally
  }
  
  public final Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
        localParcel1.writeLong(paramLong1);
        if (paramSearchParams != null)
        {
          localParcel1.writeInt(1);
          paramSearchParams.writeToParcel(localParcel1, 0);
          localParcel1.writeLong(paramLong2);
          a.transact(7, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramSearchParams = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramSearchParams;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramSearchParams = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final Bundle a(HostAuthCompat paramHostAuthCompat)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
        if (paramHostAuthCompat != null)
        {
          localParcel1.writeInt(1);
          paramHostAuthCompat.writeToParcel(localParcel1, 0);
          a.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramHostAuthCompat = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramHostAuthCompat;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramHostAuthCompat = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  /* Error */
  public final Bundle a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 25
    //   12: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 85	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: aload_2
    //   22: invokevirtual 85	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 15	bfa:a	Landroid/os/IBinder;
    //   29: bipush 9
    //   31: aload_3
    //   32: aload 4
    //   34: iconst_0
    //   35: invokeinterface 35 5 0
    //   40: pop
    //   41: aload 4
    //   43: invokevirtual 38	android/os/Parcel:readException	()V
    //   46: aload 4
    //   48: invokevirtual 41	android/os/Parcel:readInt	()I
    //   51: ifeq +28 -> 79
    //   54: getstatic 71	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
    //   57: aload 4
    //   59: invokeinterface 77 2 0
    //   64: checkcast 55	android/os/Bundle
    //   67: astore_1
    //   68: aload 4
    //   70: invokevirtual 44	android/os/Parcel:recycle	()V
    //   73: aload_3
    //   74: invokevirtual 44	android/os/Parcel:recycle	()V
    //   77: aload_1
    //   78: areturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -13 -> 68
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 44	android/os/Parcel:recycle	()V
    //   90: aload_3
    //   91: invokevirtual 44	android/os/Parcel:recycle	()V
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	bfa
    //   0	96	1	paramString1	String
    //   0	96	2	paramString2	String
    //   3	88	3	localParcel1	Parcel
    //   7	79	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	68	84	finally
  }
  
  public final Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
        localParcel1.writeString(paramString1);
        localParcel1.writeString(paramString2);
        if (paramBundle != null)
        {
          localParcel1.writeInt(1);
          paramBundle.writeToParcel(localParcel1, 0);
          a.transact(20, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramString1 = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return paramString1;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final List<RecipientAvailability> a(String paramString, List<String> paramList, long paramLong1, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeString(paramString);
      localParcel1.writeStringList(paramList);
      localParcel1.writeLong(paramLong1);
      localParcel1.writeLong(paramLong2);
      a.transact(17, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.createTypedArrayList(RecipientAvailability.CREATOR);
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void a(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel.writeInt(paramInt);
      a.transact(11, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final void a(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong);
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
  
  public final void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel.writeLong(paramLong1);
      localParcel.writeInt(paramInt);
      localParcel.writeLong(paramLong2);
      localParcel.writeLong(paramLong3);
      localParcel.writeString(paramString);
      a.transact(8, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong1);
      localParcel1.writeLong(paramLong2);
      a.transact(14, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void a(long paramLong, com.android.emailcommon.provider.ExchangeOofSettings paramExchangeOofSettings)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: aload 4
    //   7: ldc 25
    //   9: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: aload 4
    //   14: lload_1
    //   15: invokevirtual 49	android/os/Parcel:writeLong	(J)V
    //   18: aload_3
    //   19: ifnull +38 -> 57
    //   22: aload 4
    //   24: iconst_1
    //   25: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   28: aload_3
    //   29: aload 4
    //   31: iconst_0
    //   32: invokevirtual 106	com/android/emailcommon/provider/ExchangeOofSettings:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	bfa:a	Landroid/os/IBinder;
    //   39: bipush 10
    //   41: aload 4
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokeinterface 35 5 0
    //   50: pop
    //   51: aload 4
    //   53: invokevirtual 44	android/os/Parcel:recycle	()V
    //   56: return
    //   57: aload 4
    //   59: iconst_0
    //   60: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   63: goto -28 -> 35
    //   66: astore_3
    //   67: aload 4
    //   69: invokevirtual 44	android/os/Parcel:recycle	()V
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bfa
    //   0	74	1	paramLong	long
    //   0	74	3	paramExchangeOofSettings	com.android.emailcommon.provider.ExchangeOofSettings
    //   3	65	4	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   5	18	66	finally
    //   22	35	66	finally
    //   35	51	66	finally
    //   57	63	66	finally
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong1);
      localParcel1.writeString(paramString);
      localParcel1.writeLong(paramLong2);
      a.transact(15, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: iconst_1
    //   4: istore 7
    //   6: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore 9
    //   11: aload 9
    //   13: ldc 25
    //   15: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: ifnull +11 -> 30
    //   22: aload_1
    //   23: invokeinterface 114 1 0
    //   28: astore 8
    //   30: aload 9
    //   32: aload 8
    //   34: invokevirtual 117	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   37: aload 9
    //   39: lload_2
    //   40: invokevirtual 49	android/os/Parcel:writeLong	(J)V
    //   43: aload 9
    //   45: lload 4
    //   47: invokevirtual 49	android/os/Parcel:writeLong	(J)V
    //   50: iload 6
    //   52: ifeq +31 -> 83
    //   55: aload 9
    //   57: iload 7
    //   59: invokevirtual 53	android/os/Parcel:writeInt	(I)V
    //   62: aload_0
    //   63: getfield 15	bfa:a	Landroid/os/IBinder;
    //   66: iconst_1
    //   67: aload 9
    //   69: aconst_null
    //   70: iconst_1
    //   71: invokeinterface 35 5 0
    //   76: pop
    //   77: aload 9
    //   79: invokevirtual 44	android/os/Parcel:recycle	()V
    //   82: return
    //   83: iconst_0
    //   84: istore 7
    //   86: goto -31 -> 55
    //   89: astore_1
    //   90: aload 9
    //   92: invokevirtual 44	android/os/Parcel:recycle	()V
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	bfa
    //   0	97	1	parambfb	bfb
    //   0	97	2	paramLong1	long
    //   0	97	4	paramLong2	long
    //   0	97	6	paramBoolean	boolean
    //   4	81	7	i	int
    //   1	32	8	localIBinder	IBinder
    //   9	82	9	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   11	18	89	finally
    //   22	30	89	finally
    //   30	50	89	finally
    //   55	77	89	finally
  }
  
  public final void a(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeString(paramString);
      a.transact(12, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
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
  
  public final String b(String paramString)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeString(paramString);
      a.transact(18, localParcel1, localParcel2, 0);
      localParcel2.readException();
      paramString = localParcel2.readString();
      return paramString;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void b(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong);
      a.transact(5, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong1);
      localParcel1.writeLong(paramLong2);
      a.transact(16, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void c(long paramLong)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel1.writeLong(paramLong);
      a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final void c(long paramLong1, long paramLong2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.android.emailcommon.service.IEmailService");
      localParcel.writeLong(paramLong1);
      localParcel.writeLong(paramLong2);
      a.transact(19, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     bfa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */