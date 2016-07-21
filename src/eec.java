import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryDataRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class eec
  implements Parcelable.Creator<AccountRecoveryDataRequest>
{
  public static AccountRecoveryDataRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = emh.a(paramParcel);
    String str1 = null;
    AppDescription localAppDescription = null;
    String str2 = null;
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
        str2 = emh.m(paramParcel, k);
        break;
      case 3: 
        bool = emh.c(paramParcel, k);
        break;
      case 4: 
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 5: 
        str1 = emh.m(paramParcel, k);
        break;
      case 6: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountRecoveryDataRequest(i, str2, bool, localAppDescription, str1, localAccount);
  }
}

/* Location:
 * Qualified Name:     eec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */