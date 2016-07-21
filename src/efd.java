import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.PasswordCheckRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class efd
  implements Parcelable.Creator<PasswordCheckRequest>
{
  public static PasswordCheckRequest a(Parcel paramParcel)
  {
    AppDescription localAppDescription = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new PasswordCheckRequest(i, str4, str3, str2, str1, localAppDescription);
  }
}

/* Location:
 * Qualified Name:     efd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */