import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.ConfirmCredentialsRequest;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;

public final class eeq
  implements Parcelable.Creator<ConfirmCredentialsRequest>
{
  public static ConfirmCredentialsRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    AccountCredentials localAccountCredentials = null;
    int i = 0;
    CaptchaSolution localCaptchaSolution = null;
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
        localAccountCredentials = (AccountCredentials)emh.a(paramParcel, k, AccountCredentials.CREATOR);
        break;
      case 3: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new ConfirmCredentialsRequest(i, localAccountCredentials, localCaptchaSolution);
  }
}

/* Location:
 * Qualified Name:     eeq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */