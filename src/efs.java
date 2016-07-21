import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.WebSetupConfigRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class efs
  implements Parcelable.Creator<WebSetupConfigRequest>
{
  public static WebSetupConfigRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    AppDescription localAppDescription = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1: 
        i = emh.e(paramParcel, k);
        break;
      case 2: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new WebSetupConfigRequest(i, localAppDescription);
  }
}

/* Location:
 * Qualified Name:     efs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */