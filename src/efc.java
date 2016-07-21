import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.OtpResponse;

public final class efc
  implements Parcelable.Creator<OtpResponse>
{
  public static OtpResponse a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    String str = null;
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new OtpResponse(i, str);
  }
}

/* Location:
 * Qualified Name:     efc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */