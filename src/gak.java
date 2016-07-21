import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.PIMEUpdateResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Response;

public final class gak
  implements Parcelable.Creator<GetIMEUpdatesCall.Response>
{
  public static GetIMEUpdatesCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    PIMEUpdateResponse localPIMEUpdateResponse = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1000: 
        i = emh.e(paramParcel, k);
        break;
      case 1: 
        localStatus = (Status)emh.a(paramParcel, k, Status.CREATOR);
        break;
      case 2: 
        localPIMEUpdateResponse = (PIMEUpdateResponse)emh.a(paramParcel, k, PIMEUpdateResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetIMEUpdatesCall.Response(i, localStatus, localPIMEUpdateResponse);
  }
}

/* Location:
 * Qualified Name:     gak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */