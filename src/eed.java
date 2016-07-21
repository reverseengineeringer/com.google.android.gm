import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.AccountRecoveryGuidance;

public final class eed
  implements Parcelable.Creator<AccountRecoveryGuidance>
{
  public static AccountRecoveryGuidance a(Parcel paramParcel)
  {
    Account localAccount = null;
    boolean bool1 = false;
    int j = emh.a(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    String str = null;
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
        str = emh.m(paramParcel, k);
        break;
      case 3: 
        bool3 = emh.c(paramParcel, k);
        break;
      case 4: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 5: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 6: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountRecoveryGuidance(i, str, bool3, bool2, bool1, localAccount);
  }
}

/* Location:
 * Qualified Name:     eed
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */