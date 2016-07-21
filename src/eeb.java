import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.Country;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryData;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryGuidance;
import java.util.ArrayList;

public final class eeb
  implements Parcelable.Creator<AccountRecoveryData>
{
  public static AccountRecoveryData a(Parcel paramParcel)
  {
    Account localAccount = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
    AccountRecoveryGuidance localAccountRecoveryGuidance = null;
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
        localAccountRecoveryGuidance = (AccountRecoveryGuidance)emh.a(paramParcel, k, AccountRecoveryGuidance.CREATOR);
        break;
      case 3: 
        str7 = emh.m(paramParcel, k);
        break;
      case 4: 
        str6 = emh.m(paramParcel, k);
        break;
      case 5: 
        str5 = emh.m(paramParcel, k);
        break;
      case 6: 
        str4 = emh.m(paramParcel, k);
        break;
      case 7: 
        str3 = emh.m(paramParcel, k);
        break;
      case 8: 
        localArrayList = emh.c(paramParcel, k, Country.CREATOR);
        break;
      case 9: 
        str2 = emh.m(paramParcel, k);
        break;
      case 10: 
        str1 = emh.m(paramParcel, k);
        break;
      case 11: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountRecoveryData(i, localAccountRecoveryGuidance, str7, str6, str5, str4, str3, localArrayList, str2, str1, localAccount);
  }
}

/* Location:
 * Qualified Name:     eeb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */