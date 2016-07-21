import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Request;

public final class fzm
  implements Parcelable.Creator<GetCurrentExperimentIdsCall.Request>
{
  public static GetCurrentExperimentIdsCall.Request a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetCurrentExperimentIdsCall.Request(i);
  }
}

/* Location:
 * Qualified Name:     fzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */