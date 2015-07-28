package com.google.android.gms.common.internal;

import android.os.IBinder;

class IGmsServiceBroker$Stub$Proxy
  implements IGmsServiceBroker
{
  private IBinder mRemote;
  
  IGmsServiceBroker$Stub$Proxy(IBinder paramIBinder)
  {
    mRemote = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return mRemote;
  }
  
  /* Error */
  public void getPanoramaService(IGmsCallbacks paramIGmsCallbacks, int paramInt, String paramString, android.os.Bundle paramBundle)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 5
    //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 6
    //   10: aload 5
    //   12: ldc 34
    //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +79 -> 97
    //   21: aload_1
    //   22: invokeinterface 42 1 0
    //   27: astore_1
    //   28: aload 5
    //   30: aload_1
    //   31: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 5
    //   36: iload_2
    //   37: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   40: aload 5
    //   42: aload_3
    //   43: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 4
    //   48: ifnull +54 -> 102
    //   51: aload 5
    //   53: iconst_1
    //   54: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   57: aload 4
    //   59: aload 5
    //   61: iconst_0
    //   62: invokevirtual 58	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   65: aload_0
    //   66: getfield 19	com/google/android/gms/common/internal/IGmsServiceBroker$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   69: iconst_2
    //   70: aload 5
    //   72: aload 6
    //   74: iconst_0
    //   75: invokeinterface 64 5 0
    //   80: pop
    //   81: aload 6
    //   83: invokevirtual 67	android/os/Parcel:readException	()V
    //   86: aload 6
    //   88: invokevirtual 70	android/os/Parcel:recycle	()V
    //   91: aload 5
    //   93: invokevirtual 70	android/os/Parcel:recycle	()V
    //   96: return
    //   97: aconst_null
    //   98: astore_1
    //   99: goto -71 -> 28
    //   102: aload 5
    //   104: iconst_0
    //   105: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   108: goto -43 -> 65
    //   111: astore_1
    //   112: aload 6
    //   114: invokevirtual 70	android/os/Parcel:recycle	()V
    //   117: aload 5
    //   119: invokevirtual 70	android/os/Parcel:recycle	()V
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	Proxy
    //   0	124	1	paramIGmsCallbacks	IGmsCallbacks
    //   0	124	2	paramInt	int
    //   0	124	3	paramString	String
    //   0	124	4	paramBundle	android.os.Bundle
    //   3	115	5	localParcel1	android.os.Parcel
    //   8	105	6	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	111	finally
    //   21	28	111	finally
    //   28	46	111	finally
    //   51	65	111	finally
    //   65	86	111	finally
    //   102	108	111	finally
  }
  
  /* Error */
  public void getPlusService(IGmsCallbacks paramIGmsCallbacks, int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, android.os.Bundle paramBundle)
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 8
    //   5: invokestatic 32	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 9
    //   10: aload 8
    //   12: ldc 34
    //   14: invokevirtual 38	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +100 -> 118
    //   21: aload_1
    //   22: invokeinterface 42 1 0
    //   27: astore_1
    //   28: aload 8
    //   30: aload_1
    //   31: invokevirtual 45	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 8
    //   36: iload_2
    //   37: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   40: aload 8
    //   42: aload_3
    //   43: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   46: aload 8
    //   48: aload 4
    //   50: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   53: aload 8
    //   55: aload 5
    //   57: invokevirtual 77	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
    //   60: aload 8
    //   62: aload 6
    //   64: invokevirtual 52	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   67: aload 7
    //   69: ifnull +54 -> 123
    //   72: aload 8
    //   74: iconst_1
    //   75: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   78: aload 7
    //   80: aload 8
    //   82: iconst_0
    //   83: invokevirtual 58	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
    //   86: aload_0
    //   87: getfield 19	com/google/android/gms/common/internal/IGmsServiceBroker$Stub$Proxy:mRemote	Landroid/os/IBinder;
    //   90: iconst_1
    //   91: aload 8
    //   93: aload 9
    //   95: iconst_0
    //   96: invokeinterface 64 5 0
    //   101: pop
    //   102: aload 9
    //   104: invokevirtual 67	android/os/Parcel:readException	()V
    //   107: aload 9
    //   109: invokevirtual 70	android/os/Parcel:recycle	()V
    //   112: aload 8
    //   114: invokevirtual 70	android/os/Parcel:recycle	()V
    //   117: return
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -92 -> 28
    //   123: aload 8
    //   125: iconst_0
    //   126: invokevirtual 49	android/os/Parcel:writeInt	(I)V
    //   129: goto -43 -> 86
    //   132: astore_1
    //   133: aload 9
    //   135: invokevirtual 70	android/os/Parcel:recycle	()V
    //   138: aload 8
    //   140: invokevirtual 70	android/os/Parcel:recycle	()V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	Proxy
    //   0	145	1	paramIGmsCallbacks	IGmsCallbacks
    //   0	145	2	paramInt	int
    //   0	145	3	paramString1	String
    //   0	145	4	paramString2	String
    //   0	145	5	paramArrayOfString	String[]
    //   0	145	6	paramString3	String
    //   0	145	7	paramBundle	android.os.Bundle
    //   3	136	8	localParcel1	android.os.Parcel
    //   8	126	9	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	132	finally
    //   21	28	132	finally
    //   28	67	132	finally
    //   72	86	132	finally
    //   86	107	132	finally
    //   123	129	132	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.IGmsServiceBroker.Stub.Proxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */