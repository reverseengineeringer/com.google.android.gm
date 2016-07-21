import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.CheckRealNameRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class eem
  implements Parcelable.Creator<CheckRealNameRequest>
{
  public static CheckRealNameRequest a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    String str1 = null;
    AppDescription localAppDescription = null;
    int i = 0;
    String str2 = null;
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
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 3: 
        str1 = emh.m(paramParcel, k);
        break;
      case 4: 
        str2 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new CheckRealNameRequest(i, localAppDescription, str1, str2);
  }
}

/* Location:
 * Qualified Name:     eem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */