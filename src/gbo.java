import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SuggestionResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.queries.QuerySuggestCall.Response;

public final class gbo
  implements Parcelable.Creator<QuerySuggestCall.Response>
{
  public static QuerySuggestCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    SuggestionResults localSuggestionResults = null;
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
        localSuggestionResults = (SuggestionResults)emh.a(paramParcel, k, SuggestionResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new QuerySuggestCall.Response(i, localStatus, localSuggestionResults);
  }
}

/* Location:
 * Qualified Name:     gbo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */