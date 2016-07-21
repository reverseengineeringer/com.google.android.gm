import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.SuggestSpecification;
import com.google.android.gms.search.queries.QuerySuggestCall.Request;

public final class gbn
  implements Parcelable.Creator<QuerySuggestCall.Request>
{
  public static QuerySuggestCall.Request a(Parcel paramParcel)
  {
    int i = 0;
    SuggestSpecification localSuggestSpecification = null;
    int k = emh.a(paramParcel);
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1000: 
        j = emh.e(paramParcel, m);
        break;
      case 1: 
        str2 = emh.m(paramParcel, m);
        break;
      case 2: 
        str1 = emh.m(paramParcel, m);
        break;
      case 3: 
        arrayOfString = emh.t(paramParcel, m);
        break;
      case 4: 
        i = emh.e(paramParcel, m);
        break;
      case 5: 
        localSuggestSpecification = (SuggestSpecification)emh.a(paramParcel, m, SuggestSpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    return new QuerySuggestCall.Request(j, str2, str1, arrayOfString, i, localSuggestSpecification);
  }
}

/* Location:
 * Qualified Name:     gbn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */