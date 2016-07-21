import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountNameCheckRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;

public final class edz
  implements Parcelable.Creator<AccountNameCheckRequest>
{
  public static AccountNameCheckRequest a(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = emh.a(paramParcel);
    int i = 0;
    CaptchaSolution localCaptchaSolution = null;
    AppDescription localAppDescription = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
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
        str3 = emh.m(paramParcel, k);
        break;
      case 3: 
        str2 = emh.m(paramParcel, k);
        break;
      case 4: 
        str1 = emh.m(paramParcel, k);
        break;
      case 5: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 6: 
        localCaptchaSolution = (CaptchaSolution)emh.a(paramParcel, k, CaptchaSolution.CREATOR);
        break;
      case 7: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountNameCheckRequest(i, str3, str2, str1, localAppDescription, localCaptchaSolution, localAccount);
  }
}

/* Location:
 * Qualified Name:     edz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */