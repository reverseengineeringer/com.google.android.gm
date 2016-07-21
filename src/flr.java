import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.herrevad.NetworkQualityReport;

public abstract class flr
  extends Binder
  implements flq
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    String str2 = null;
    String str1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityService");
      localObject = str1;
      if (paramParcel1.readInt() != 0) {
        localObject = (NetworkQualityReport)NetworkQualityReport.CREATOR.createFromParcel(paramParcel1);
      }
      a((NetworkQualityReport)localObject);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityService");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = paramParcel1.queryLocalInterface("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityCallbacks");
        if ((localObject != null) && ((localObject instanceof fln))) {
          paramParcel1 = (fln)localObject;
        } else {
          paramParcel1 = new flp(paramParcel1);
        }
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityService");
    localObject = str2;
    if (paramParcel1.readInt() != 0) {
      localObject = (NetworkQualityReport)NetworkQualityReport.CREATOR.createFromParcel(paramParcel1);
    }
    str1 = paramParcel1.readString();
    str2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a((NetworkQualityReport)localObject, str1, str2, bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     flr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */