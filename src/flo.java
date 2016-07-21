import android.os.Binder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public abstract class flo
  extends Binder
  implements fln
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityCallbacks");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.herrevad.internal.ILightweightNetworkQualityCallbacks");
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = (Status)Status.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label105;
      }
    }
    label105:
    for (paramParcel1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel2, paramParcel1);
      return true;
      paramParcel2 = null;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     flo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */