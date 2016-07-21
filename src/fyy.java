import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.CorpusStatus;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Response;

public final class fyy
  implements Parcelable.Creator<GetCorpusStatusCall.Response>
{
  public static GetCorpusStatusCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    CorpusStatus localCorpusStatus = null;
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
        localCorpusStatus = (CorpusStatus)emh.a(paramParcel, k, CorpusStatus.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetCorpusStatusCall.Response(i, localStatus, localCorpusStatus);
  }
}

/* Location:
 * Qualified Name:     fyy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */