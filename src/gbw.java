import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.search.queries.GetDocumentsCall.Request;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Request;
import com.google.android.gms.search.queries.GlobalQueryCall.Request;
import com.google.android.gms.search.queries.QueryCall.Request;
import com.google.android.gms.search.queries.QuerySuggestCall.Request;

public abstract class gbw
  extends Binder
  implements gbv
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.queries.internal.ISearchQueriesService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = QueryCall.Request.CREATOR;
        localObject1 = gbl.a(paramParcel1);
      }
      a((QueryCall.Request)localObject1, gbt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = QuerySuggestCall.Request.CREATOR;
        localObject1 = gbn.a(paramParcel1);
      }
      a((QuerySuggestCall.Request)localObject1, gbt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GlobalQueryCall.Request.CREATOR;
        localObject1 = gbj.a(paramParcel1);
      }
      a((GlobalQueryCall.Request)localObject1, gbt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetDocumentsCall.Request.CREATOR;
        localObject1 = gbf.a(paramParcel1);
      }
      a((GetDocumentsCall.Request)localObject1, gbt.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesService");
    localObject1 = localObject5;
    if (paramParcel1.readInt() != 0)
    {
      localObject1 = GetPhraseAffinityCall.Request.CREATOR;
      localObject1 = gbh.a(paramParcel1);
    }
    a((GetPhraseAffinityCall.Request)localObject1, gbt.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gbw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */