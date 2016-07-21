import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Request;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Request;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Request;

public abstract class gae
  extends Binder
  implements gad
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
      paramParcel2.writeString("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetGlobalSearchSourcesCall.Request.CREATOR;
        localObject1 = fzq.a(paramParcel1);
      }
      a((GetGlobalSearchSourcesCall.Request)localObject1, gab.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = SetExperimentIdsCall.Request.CREATOR;
        localObject1 = fzv.a(paramParcel1);
      }
      a((SetExperimentIdsCall.Request)localObject1, gab.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetCurrentExperimentIdsCall.Request.CREATOR;
        localObject1 = fzm.a(paramParcel1);
      }
      a((GetCurrentExperimentIdsCall.Request)localObject1, gab.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetPendingExperimentIdsCall.Request.CREATOR;
        localObject1 = fzs.a(paramParcel1);
      }
      a((GetPendingExperimentIdsCall.Request)localObject1, gab.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.global.internal.IGlobalSearchAdminService");
    localObject1 = localObject5;
    if (paramParcel1.readInt() != 0)
    {
      localObject1 = SetIncludeInGlobalSearchCall.Request.CREATOR;
      localObject1 = fzx.a(paramParcel1);
    }
    a((SetIncludeInGlobalSearchCall.Request)localObject1, gab.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */