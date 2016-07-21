import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.search.queries.GetDocumentsCall.Response;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Response;
import com.google.android.gms.search.queries.GlobalQueryCall.Response;
import com.google.android.gms.search.queries.QueryCall.Response;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public abstract class gbt
  extends Binder
  implements gbs
{
  public gbt()
  {
    attachInterface(this, "com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
  }
  
  public static gbs a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof gbs))) {
      return (gbs)localIInterface;
    }
    return new gbu(paramIBinder);
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
    Object localObject5 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = QueryCall.Response.CREATOR;
        paramParcel2 = gbm.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = QuerySuggestCall.Response.CREATOR;
        paramParcel2 = gbo.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GlobalQueryCall.Response.CREATOR;
        paramParcel2 = gbk.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
      paramParcel2 = (Parcel)localObject4;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetDocumentsCall.Response.CREATOR;
        paramParcel2 = gbg.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.queries.internal.ISearchQueriesCallbacks");
    paramParcel2 = (Parcel)localObject5;
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = GetPhraseAffinityCall.Response.CREATOR;
      paramParcel2 = gbi.a(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     gbt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */