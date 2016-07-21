import android.os.IBinder;
import android.os.Parcel;

final class gfp
  implements gfn
{
  private IBinder a;
  
  gfp(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.wearable.internal.IChannelStreamCallbacks");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
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
  
  public final IBinder asBinder()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     gfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */