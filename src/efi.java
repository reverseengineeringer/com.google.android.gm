import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.ReauthSettingsRequest;

public final class efi
  implements Parcelable.Creator<ReauthSettingsRequest>
{
  public static ReauthSettingsRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = emh.a(paramParcel);
    Account localAccount = null;
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
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
        break;
      case 5: 
        str1 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new ReauthSettingsRequest(i, str2, bool, localAccount, str1);
  }
}

/* Location:
 * Qualified Name:     efi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */