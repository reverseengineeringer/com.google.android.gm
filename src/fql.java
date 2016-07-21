import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.administration.GetStorageStatsCall.Request;

public abstract class fql
  extends Binder
  implements fqk
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = GetStorageStatsCall.Request.CREATOR;
        localObject1 = fyp.a(paramParcel1);
      }
      a((GetStorageStatsCall.Request)localObject1, fqi.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a((Bundle)localObject1, fqi.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.administration.internal.ISearchAdministrationService");
    a(fqi.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     fql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */