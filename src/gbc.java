import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Request;

final class gbc
  implements gba
{
  private IBinder a;
  
  gbc(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(GetNativeApiInfoCall.Request paramRequest, gax paramgax)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.nativeapi.internal.INativeApiService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgax != null)
          {
            paramRequest = paramgax.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramRequest = null;
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
}

/* Location:
 * Qualified Name:     gbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */