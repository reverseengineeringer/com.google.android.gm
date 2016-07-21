import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.administration.BundleResponse;
import com.google.android.gms.search.administration.GetStorageStatsCall.Response;

public abstract class fqi
  extends Binder
  implements fqh
{
  public static fqh a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof fqh))) {
      return (fqh)localIInterface;
    }
    return new fqj(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.administration.internal.ISearchAdministrationCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetStorageStatsCall.Response.CREATOR;
        paramParcel2 = fyq.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = BundleResponse.CREATOR;
        paramParcel2 = fyn.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationCallbacks");
    paramParcel2 = (Parcel)localObject3;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     fqi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */