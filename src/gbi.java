import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.PhraseAffinityResponse;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.queries.GetPhraseAffinityCall.Response;

public final class gbi
  implements Parcelable.Creator<GetPhraseAffinityCall.Response>
{
  public static GetPhraseAffinityCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    PhraseAffinityResponse localPhraseAffinityResponse = null;
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
        localPhraseAffinityResponse = (PhraseAffinityResponse)emh.a(paramParcel, k, PhraseAffinityResponse.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetPhraseAffinityCall.Response(i, localStatus, localPhraseAffinityResponse);
  }
}

/* Location:
 * Qualified Name:     gbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */