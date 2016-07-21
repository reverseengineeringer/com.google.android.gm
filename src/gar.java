import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Request;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Request;

final class gar
  implements gap
{
  private IBinder a;
  
  gar(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(GetCorpusHandlesRegisteredForIMECall.Request paramRequest, gam paramgam)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.ime.internal.IIMEUpdatesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgam != null)
          {
            paramRequest = paramgam.asBinder();
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
  
  public final void a(GetIMEUpdatesCall.Request paramRequest, gam paramgam)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.ime.internal.IIMEUpdatesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgam != null)
          {
            paramRequest = paramgam.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(3, localParcel1, localParcel2, 0);
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
 * Qualified Name:     gar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */