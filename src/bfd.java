import android.os.IBinder;
import android.os.Parcel;

final class bfd
  implements bfb
{
  private IBinder a;
  
  bfd(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.android.emailcommon.service.IEmailServiceCallback");
      localParcel.writeLong(paramLong1);
      localParcel.writeLong(paramLong2);
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      a.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     bfd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */