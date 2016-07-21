import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryUpdateRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class eef
  implements Parcelable.Creator<AccountRecoveryUpdateRequest>
{
  public static AccountRecoveryUpdateRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = emh.a(paramParcel);
    AppDescription localAppDescription = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = emh.m(paramParcel, k);
        break;
      case 3: 
        str3 = emh.m(paramParcel, k);
        break;
      case 4: 
        str2 = emh.m(paramParcel, k);
        break;
      case 5: 
        str1 = emh.m(paramParcel, k);
        break;
      case 6: 
        bool = emh.c(paramParcel, k);
        break;
      case 7: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 8: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountRecoveryUpdateRequest(i, str4, str3, str2, str1, bool, localAppDescription, localAccount);
  }
}

/* Location:
 * Qualified Name:     eef
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */