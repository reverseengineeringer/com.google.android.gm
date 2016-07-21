import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.queries.GetDocumentsCall.Request;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Request;
import com.google.android.gms.search.queries.GlobalQueryCall.Request;
import com.google.android.gms.search.queries.QueryCall.Request;
import com.google.android.gms.search.queries.QuerySuggestCall.Request;

final class gbx
  implements gbv
{
  private IBinder a;
  
  gbx(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(GetDocumentsCall.Request paramRequest, gbs paramgbs)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.queries.internal.ISearchQueriesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgbs != null)
          {
            paramRequest = paramgbs.asBinder();
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
  
  public final void a(GetPhraseAffinityCall.Request paramRequest, gbs paramgbs)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.queries.internal.ISearchQueriesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgbs != null)
          {
            paramRequest = paramgbs.asBinder();
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
  
  public final void a(GlobalQueryCall.Request paramRequest, gbs paramgbs)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.queries.internal.ISearchQueriesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgbs != null)
          {
            paramRequest = paramgbs.asBinder();
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
  
  public final void a(QueryCall.Request paramRequest, gbs paramgbs)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.queries.internal.ISearchQueriesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgbs != null)
          {
            paramRequest = paramgbs.asBinder();
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
  
  public final void a(QuerySuggestCall.Request paramRequest, gbs paramgbs)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.queries.internal.ISearchQueriesService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramgbs != null)
          {
            paramRequest = paramgbs.asBinder();
            localParcel1.writeStrongBinder(paramRequest);
            a.transact(6, localParcel1, localParcel2, 0);
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
 * Qualified Name:     gbx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */