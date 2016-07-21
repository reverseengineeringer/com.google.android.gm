import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Request;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Request;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Request;

final class gaf
  implements gad
{
  private IBinder a;
  
  gaf(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(GetCurrentExperimentIdsCall.Request paramRequest, gaa paramgaa)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgaa != null)
          {
            paramRequest = paramgaa.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(4, localParcel1, localParcel2, 0);
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
  
  public final void a(GetGlobalSearchSourcesCall.Request paramRequest, gaa paramgaa)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgaa != null)
          {
            paramRequest = paramgaa.asBinder();
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
  
  public final void a(GetPendingExperimentIdsCall.Request paramRequest, gaa paramgaa)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgaa != null)
          {
            paramRequest = paramgaa.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(5, localParcel1, localParcel2, 0);
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
  
  public final void a(SetExperimentIdsCall.Request paramRequest, gaa paramgaa)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgaa != null)
          {
            paramRequest = paramgaa.asBinder();
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
  
  public final void a(SetIncludeInGlobalSearchCall.Request paramRequest, gaa paramgaa)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgaa != null)
          {
            paramRequest = paramgaa.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(8, localParcel1, localParcel2, 0);
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
 * Qualified Name:     gaf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */