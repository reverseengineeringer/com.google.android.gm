import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.PasswordSettings;
import com.google.android.gms.auth.firstparty.dataservice.PinSettings;
import com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsResponse;

public final class efj
  implements Parcelable.Creator<ReauthSettingsResponse>
{
  public static ReauthSettingsResponse a(Parcel paramParcel)
  {
    int k = emh.a(paramParcel);
    PasswordSettings localPasswordSettings = null;
    int j = 0;
    int i = 0;
    PinSettings localPinSettings = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1: 
        i = emh.e(paramParcel, m);
        break;
      case 2: 
        j = emh.e(paramParcel, m);
        break;
      case 3: 
        localPasswordSettings = (PasswordSettings)emh.a(paramParcel, m, PasswordSettings.CREATOR);
        break;
      case 4: 
        localPinSettings = (PinSettings)emh.a(paramParcel, m, PinSettings.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    return new ReauthSettingsResponse(i, j, localPasswordSettings, localPinSettings);
  }
}

/* Location:
 * Qualified Name:     efj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */