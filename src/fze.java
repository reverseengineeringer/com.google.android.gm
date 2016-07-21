import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.search.corpora.ClearCorpusCall.Response;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Response;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;
import com.google.android.gms.search.corpora.RequestIndexingCall.Response;

public abstract class fze
  extends Binder
  implements fzd
{
  public fze()
  {
    attachInterface(this, "com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
  }
  
  public static fzd a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof fzd))) {
      return (fzd)localIInterface;
    }
    return new fzf(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = RequestIndexingCall.Response.CREATOR;
        paramParcel2 = fzb.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = ClearCorpusCall.Response.CREATOR;
        paramParcel2 = fyt.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetCorpusStatusCall.Response.CREATOR;
        paramParcel2 = fyy.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaCallbacks");
    paramParcel2 = (Parcel)localObject4;
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = GetCorpusInfoCall.Response.CREATOR;
      paramParcel2 = fyv.a(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     fze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */