import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.search.queries.GetDocumentsCall.Request;

public final class gbf
  implements Parcelable.Creator<GetDocumentsCall.Request>
{
  public static GetDocumentsCall.Request a(Parcel paramParcel)
  {
    QuerySpecification localQuerySpecification = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
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
        str2 = emh.m(paramParcel, k);
        break;
      case 2: 
        str1 = emh.m(paramParcel, k);
        break;
      case 3: 
        arrayOfString = emh.t(paramParcel, k);
        break;
      case 4: 
        localQuerySpecification = (QuerySpecification)emh.a(paramParcel, k, QuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetDocumentsCall.Request(i, str2, str1, arrayOfString, localQuerySpecification);
  }
}

/* Location:
 * Qualified Name:     gbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */