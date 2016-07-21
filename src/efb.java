import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.OtpRequest;
import com.google.android.gms.auth.firstparty.shared.AppDescription;

public final class efb
  implements Parcelable.Creator<OtpRequest>
{
  public static OtpRequest a(Parcel paramParcel)
  {
    boolean bool = false;
    byte[] arrayOfByte = null;
    int j = emh.a(paramParcel);
    AppDescription localAppDescription = null;
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
        localAppDescription = (AppDescription)emh.a(paramParcel, k, AppDescription.CREATOR);
        break;
      case 4: 
        arrayOfByte = emh.p(paramParcel, k);
        break;
      case 5: 
        bool = emh.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new OtpRequest(i, str, localAppDescription, arrayOfByte, bool);
  }
}

/* Location:
 * Qualified Name:     efb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */