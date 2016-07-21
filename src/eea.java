import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckResponse;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import java.util.ArrayList;

public final class eea
  implements Parcelable.Creator<AccountNameCheckResponse>
{
  public static AccountNameCheckResponse a(Parcel paramParcel)
  {
    CaptchaChallenge localCaptchaChallenge = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String str1 = null;
    ArrayList localArrayList = null;
    String str2 = null;
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
        str2 = emh.m(paramParcel, k);
        break;
      case 3: 
        localArrayList = emh.u(paramParcel, k);
        break;
      case 4: 
        str1 = emh.m(paramParcel, k);
        break;
      case 5: 
        localCaptchaChallenge = (CaptchaChallenge)emh.a(paramParcel, k, CaptchaChallenge.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountNameCheckResponse(i, str2, localArrayList, str1, localCaptchaChallenge);
  }
}

/* Location:
 * Qualified Name:     eea
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */