import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.queries.GetDocumentsCall.Response;

public final class gbg
  implements Parcelable.Creator<GetDocumentsCall.Response>
{
  public static GetDocumentsCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    DocumentResults localDocumentResults = null;
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
        localDocumentResults = (DocumentResults)emh.a(paramParcel, k, DocumentResults.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetDocumentsCall.Response(i, localStatus, localDocumentResults);
  }
}

/* Location:
 * Qualified Name:     gbg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */