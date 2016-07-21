import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.TokenRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.auth.firstparty.shared.FACLConfig;
import com.google.android.gms.auth.firstparty.shared.PACLConfig;

public final class efl
  implements Parcelable.Creator<TokenRequest>
{
  public static TokenRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    String str4 = null;
    String str3 = null;
    Bundle localBundle = new Bundle();
    FACLConfig localFACLConfig = null;
    PACLConfig localPACLConfig = null;
    boolean bool5 = false;
    boolean bool4 = false;
    String str2 = "com.google.android.gms.auth.firstparty.shared.Consent.UNKNOWN.toString()";
    AppDescription localAppDescription = null;
    CaptchaSolution localCaptchaSolution = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str1 = "com.google";
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
        str4 = emh.m(paramParcel, k);
        break;
      case 3: 
        str3 = emh.m(paramParcel, k);
        break;
      case 4: 
        localBundle = emh.o(paramParcel, k);
        break;
      case 5: 
        localFACLConfig = (FACLConfig)emh.a(paramParcel, k, FACLConfig.CREATOR);
        break;
      case 6: 
        localPACLConfig = (PACLConfig)emh.a(paramParcel, k, PACLConfig.CREATOR);
        break;
      case 7: 
        bool5 = emh.c(paramParcel, k);
        break;
      case 8: 
        bool4 = emh.c(paramParcel, k);
        break;
      case 9: 
        str2 = emh.m(paramParcel, k);
        break;
      case 10: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 11: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 12: 
        bool3 = emh.c(paramParcel, k);
        break;
      case 13: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 14: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 15: 
        str1 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new TokenRequest(i, str4, str3, localBundle, localFACLConfig, localPACLConfig, bool5, bool4, str2, localAppDescription, localCaptchaSolution, bool3, bool2, bool1, str1);
  }
}

/* Location:
 * Qualified Name:     efl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */