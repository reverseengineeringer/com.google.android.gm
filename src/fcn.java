import android.os.IBinder;

public final class fcn
  implements fcl
{
  private IBinder a;
  
  public fcn(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_3
    //   6: aload_3
    //   7: ldc 25
    //   9: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   12: iload_1
    //   13: ifeq +27 -> 40
    //   16: aload_3
    //   17: iload_2
    //   18: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   21: aload_0
    //   22: getfield 15	fcn:a	Landroid/os/IBinder;
    //   25: iconst_1
    //   26: aload_3
    //   27: aconst_null
    //   28: iconst_1
    //   29: invokeinterface 39 5 0
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 42	android/os/Parcel:recycle	()V
    //   39: return
    //   40: iconst_0
    //   41: istore_2
    //   42: goto -26 -> 16
    //   45: astore 4
    //   47: aload_3
    //   48: invokevirtual 42	android/os/Parcel:recycle	()V
    //   51: aload 4
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	fcn
    //   0	54	1	paramBoolean	boolean
    //   1	41	2	i	int
    //   5	43	3	localParcel	android.os.Parcel
    //   45	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	45	finally
    //   16	35	45	finally
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     fcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */