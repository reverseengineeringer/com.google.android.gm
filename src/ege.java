import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;

public final class ege
  implements Parcelable.Creator<AccountCredentials>
{
  public static AccountCredentials a(Parcel paramParcel)
  {
    boolean bool = false;
    String str2 = null;
    int j = emh.a(paramParcel);
    String str1 = "com.google";
    String str3 = null;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    String str7 = null;
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
        bool = emh.c(paramParcel, k);
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
        str2 = emh.m(paramParcel, k);
        break;
      case 9: 
        str1 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new AccountCredentials(i, bool, str7, str6, str5, str4, str3, str2, str1);
  }
}

/* Location:
 * Qualified Name:     ege
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */