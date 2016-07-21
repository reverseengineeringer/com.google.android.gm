import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountSignInRequest;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;

public final class eej
  implements Parcelable.Creator<AccountSignInRequest>
{
  public static AccountSignInRequest a(Parcel paramParcel)
  {
    AccountCredentials localAccountCredentials = null;
    boolean bool1 = false;
    int j = emh.a(paramParcel);
    CaptchaSolution localCaptchaSolution = null;
    boolean bool2 = false;
    AppDescription localAppDescription = null;
    int i = 0;
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
        break;
      case 3: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 4: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 5: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 6: 
        localAccountCredentials = (AccountCredentials)emh.a(paramParcel, k, AccountCredentials.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountSignInRequest(i, localAppDescription, bool2, bool1, localCaptchaSolution, localAccountCredentials);
  }
}

/* Location:
 * Qualified Name:     eej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */