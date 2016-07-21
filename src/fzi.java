import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.search.corpora.ClearCorpusCall.Request;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Request;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Request;
import com.google.android.gms.search.corpora.RequestIndexingCall.Request;

final class fzi
  implements fzg
{
  private IBinder a;
  
  fzi(IBinder paramIBinder)
  {
    a = paramIBinder;
  }
  
  public final void a(ClearCorpusCall.Request paramRequest, fzd paramfzd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramfzd != null)
          {
            paramRequest = paramfzd.asBinder();
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
  
  public final void a(GetCorpusInfoCall.Request paramRequest, fzd paramfzd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramfzd != null)
          {
            paramRequest = paramfzd.asBinder();
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
  
  public final void a(GetCorpusStatusCall.Request paramRequest, fzd paramfzd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramfzd != null)
          {
            paramRequest = paramfzd.asBinder();
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
  
  public final void a(RequestIndexingCall.Request paramRequest, fzd paramfzd)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
        if (paramRequest != null)
        {
          localParcel1.writeInt(1);
          paramRequest.writeToParcel(localParcel1, 0);
          if (paramfzd != null)
          {
            paramRequest = paramfzd.asBinder();
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
 * Qualified Name:     fzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */