import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.NativeApiInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Response;

public final class gau
  implements Parcelable.Creator<GetNativeApiInfoCall.Response>
{
  public static GetNativeApiInfoCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    NativeApiInfo localNativeApiInfo = null;
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
        localNativeApiInfo = (NativeApiInfo)emh.a(paramParcel, k, NativeApiInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetNativeApiInfoCall.Response(i, localStatus, localNativeApiInfo);
  }
}

/* Location:
 * Qualified Name:     gau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */