import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.GetAndAdvanceOtpCounterResponse;

public final class eer
  implements Parcelable.Creator<GetAndAdvanceOtpCounterResponse>
{
  public static GetAndAdvanceOtpCounterResponse a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    Long localLong = null;
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
        localLong = emh.h(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetAndAdvanceOtpCounterResponse(i, localLong);
  }
}

/* Location:
 * Qualified Name:     eer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */