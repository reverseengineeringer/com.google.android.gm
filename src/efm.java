import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.PostSignInData;
import com.google.android.gms.auth.firstparty.dataservice.TokenResponse;
import com.google.android.gms.auth.firstparty.shared.CaptchaChallenge;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import java.util.ArrayList;

public final class efm
  implements Parcelable.Creator<TokenResponse>
{
  public static TokenResponse a(Parcel paramParcel)
  {
    int k = emh.a(paramParcel);
    int j = 0;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    boolean bool7 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    CaptchaChallenge localCaptchaChallenge = null;
    ArrayList localArrayList2 = new ArrayList();
    String str3 = null;
    String str2 = null;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 0;
    PostSignInData localPostSignInData = null;
    Account localAccount = null;
    Long localLong = null;
    boolean bool1 = false;
    ArrayList localArrayList1 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1: 
        j = emh.e(paramParcel, m);
        break;
      case 2: 
        str11 = emh.m(paramParcel, m);
        break;
      case 3: 
        str10 = emh.m(paramParcel, m);
        break;
      case 4: 
        str9 = emh.m(paramParcel, m);
        break;
      case 5: 
        str8 = emh.m(paramParcel, m);
        break;
      case 6: 
        str7 = emh.m(paramParcel, m);
        break;
      case 7: 
        str6 = emh.m(paramParcel, m);
        break;
      case 8: 
        str5 = emh.m(paramParcel, m);
        break;
      case 9: 
        str4 = emh.m(paramParcel, m);
        break;
      case 10: 
        bool7 = emh.c(paramParcel, m);
        break;
      case 11: 
        bool6 = emh.c(paramParcel, m);
        break;
      case 12: 
        bool5 = emh.c(paramParcel, m);
        break;
      case 13: 
        bool4 = emh.c(paramParcel, m);
        break;
      case 14: 
        localCaptchaChallenge = (CaptchaChallenge)emh.a(paramParcel, m, CaptchaChallenge.CREATOR);
        break;
      case 15: 
        localArrayList2 = emh.c(paramParcel, m, ScopeDetail.CREATOR);
        break;
      case 17: 
        str2 = emh.m(paramParcel, m);
        break;
      case 16: 
        str3 = emh.m(paramParcel, m);
        break;
      case 19: 
        bool2 = emh.c(paramParcel, m);
        break;
      case 18: 
        bool3 = emh.c(paramParcel, m);
        break;
      case 21: 
        localPostSignInData = (PostSignInData)emh.a(paramParcel, m, PostSignInData.CREATOR);
        break;
      case 20: 
        i = emh.e(paramParcel, m);
        break;
      case 23: 
        localLong = emh.h(paramParcel, m);
        break;
      case 22: 
        localAccount = (Account)emh.a(paramParcel, m, Account.CREATOR);
        break;
      case 25: 
        localArrayList1 = emh.u(paramParcel, m);
        break;
      case 24: 
        bool1 = emh.c(paramParcel, m);
        break;
      case 26: 
        str1 = emh.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    return new TokenResponse(j, str11, str10, str9, str8, str7, str6, str5, str4, bool7, bool6, bool5, bool4, localCaptchaChallenge, localArrayList2, str3, str2, bool3, bool2, i, localPostSignInData, localAccount, localLong, bool1, localArrayList1, str1);
  }
}

/* Location:
 * Qualified Name:     efm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */