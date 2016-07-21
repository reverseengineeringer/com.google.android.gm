import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.search.corpora.ClearCorpusCall.Request;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Request;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Request;
import com.google.android.gms.search.corpora.RequestIndexingCall.Request;

public abstract class fzh
  extends Binder
  implements fzg
{
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
      paramParcel2.writeString("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = RequestIndexingCall.Request.CREATOR;
        localObject1 = fza.a(paramParcel1);
      }
      a((RequestIndexingCall.Request)localObject1, fze.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ClearCorpusCall.Request.CREATOR;
        localObject1 = fys.a(paramParcel1);
      }
      a((ClearCorpusCall.Request)localObject1, fze.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetCorpusStatusCall.Request.CREATOR;
        localObject1 = fyx.a(paramParcel1);
      }
      a((GetCorpusStatusCall.Request)localObject1, fze.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.corpora.internal.ISearchCorporaService");
    localObject1 = localObject4;
    if (paramParcel1.readInt() != 0)
    {
      localObject1 = GetCorpusInfoCall.Request.CREATOR;
      localObject1 = fyu.a(paramParcel1);
    }
    a((GetCorpusInfoCall.Request)localObject1, fze.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     fzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */