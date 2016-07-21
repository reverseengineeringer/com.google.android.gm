import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.GoogleAccountSetupRequest;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;

public final class eey
  implements Parcelable.Creator<GoogleAccountSetupRequest>
{
  public static GoogleAccountSetupRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    Bundle localBundle = new Bundle();
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str3 = null;
    AppDescription localAppDescription = null;
    AccountCredentials localAccountCredentials = null;
    CaptchaSolution localCaptchaSolution = null;
    String str2 = null;
    String str1 = null;
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
        localBundle = emh.o(paramParcel, k);
        break;
      case 3: 
        bool6 = emh.c(paramParcel, k);
        break;
      case 4: 
        bool5 = emh.c(paramParcel, k);
        break;
      case 5: 
        bool4 = emh.c(paramParcel, k);
        break;
      case 6: 
        str7 = emh.m(paramParcel, k);
        break;
      case 7: 
        str6 = emh.m(paramParcel, k);
        break;
      case 8: 
        str5 = emh.m(paramParcel, k);
        break;
      case 9: 
        str4 = emh.m(paramParcel, k);
        break;
      case 10: 
        bool3 = emh.c(paramParcel, k);
        break;
      case 11: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 12: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 13: 
        str3 = emh.m(paramParcel, k);
        break;
      case 14: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 15: 
        localAccountCredentials = (AccountCredentials)emh.a(paramParcel, k, AccountCredentials.CREATOR);
        break;
      case 17: 
        str2 = emh.m(paramParcel, k);
        break;
      case 16: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 18: 
        str1 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleAccountSetupRequest(i, localBundle, bool6, bool5, bool4, str7, str6, str5, str4, bool3, bool2, bool1, str3, localAppDescription, localAccountCredentials, localCaptchaSolution, str2, str1);
  }
}

/* Location:
 * Qualified Name:     eey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */