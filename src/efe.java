import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.PasswordCheckResponse;

public final class efe
  implements Parcelable.Creator<PasswordCheckResponse>
{
  public static PasswordCheckResponse a(Parcel paramParcel)
  {
    String str3 = null;
    int j = emh.a(paramParcel);
    String str1 = null;
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
        str1 = emh.m(paramParcel, k);
        break;
      case 3: 
        str2 = emh.m(paramParcel, k);
        break;
      case 4: 
        str3 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new PasswordCheckResponse(i, str1, str2, str3);
  }
}

/* Location:
 * Qualified Name:     efe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */