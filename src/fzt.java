import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Response;

public final class fzt
  implements Parcelable.Creator<GetPendingExperimentIdsCall.Response>
{
  public static GetPendingExperimentIdsCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    int[] arrayOfInt = null;
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
        arrayOfInt = emh.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetPendingExperimentIdsCall.Response(i, localStatus, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     fzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */