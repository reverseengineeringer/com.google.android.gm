import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Response;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Response;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Response;
import com.google.android.gms.search.global.SetExperimentIdsCall.Response;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Response;

public abstract class gab
  extends Binder
  implements gaa
{
  public static gaa a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof gaa))) {
      return (gaa)localIInterface;
    }
    return new gac(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetGlobalSearchSourcesCall.Response.CREATOR;
        paramParcel2 = fzr.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = SetExperimentIdsCall.Response.CREATOR;
        paramParcel2 = fzw.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetCurrentExperimentIdsCall.Response.CREATOR;
        paramParcel2 = fzn.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
      paramParcel2 = (Parcel)localObject4;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = GetPendingExperimentIdsCall.Response.CREATOR;
        paramParcel2 = fzt.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminCallbacks");
    paramParcel2 = (Parcel)localObject5;
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = SetIncludeInGlobalSearchCall.Response.CREATOR;
      paramParcel2 = fzy.a(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     gab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */