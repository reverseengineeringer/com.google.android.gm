import android.os.IBinder;
import android.os.Parcel;

final class enm
  implements enk
{
  private IBinder a;
  
  enm(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
      a.transact(2, localParcel, null, 1);
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
 * Qualified Name:     enm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */