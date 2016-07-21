import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.GoogleAccountData;
import java.util.ArrayList;

public final class ees
  implements Parcelable.Creator<GoogleAccountData>
{
  public static GoogleAccountData a(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = emh.a(paramParcel);
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList = null;
    String str3 = null;
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
        str3 = emh.m(paramParcel, k);
        break;
      case 3: 
        bool = emh.c(paramParcel, k);
        break;
      case 4: 
        localArrayList = emh.u(paramParcel, k);
        break;
      case 5: 
        str2 = emh.m(paramParcel, k);
        break;
      case 6: 
        str1 = emh.m(paramParcel, k);
        break;
      case 7: 
        localAccount = (Account)emh.a(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleAccountData(i, str3, bool, localArrayList, str2, str1, localAccount);
  }
}

/* Location:
 * Qualified Name:     ees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */