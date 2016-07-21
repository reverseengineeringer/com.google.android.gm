import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SearchResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.queries.QueryCall.Response;

public final class gbm
  implements Parcelable.Creator<QueryCall.Response>
{
  public static QueryCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    SearchResults localSearchResults = null;
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
        localSearchResults = (SearchResults)emh.a(paramParcel, k, SearchResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new QueryCall.Response(i, localStatus, localSearchResults);
  }
}

/* Location:
 * Qualified Name:     gbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */