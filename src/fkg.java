import android.os.IBinder;
import android.os.Parcel;

final class fkg
  implements fke
{
  private IBinder a;
  
  fkg(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.gcm.INetworkTaskCallback");
      localParcel1.writeInt(paramInt);
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
 * Qualified Name:     fkg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */