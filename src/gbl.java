import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.QuerySpecification;
import com.google.android.gms.search.queries.QueryCall.Request;

public final class gbl
  implements Parcelable.Creator<QueryCall.Request>
{
  public static QueryCall.Request a(Parcel paramParcel)
  {
    int i = 0;
    QuerySpecification localQuerySpecification = null;
    int m = emh.a(paramParcel);
    int j = 0;
    String[] arrayOfString = null;
    String str1 = null;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default: 
        emh.b(paramParcel, n);
        break;
      case 1000: 
        k = emh.e(paramParcel, n);
        break;
      case 1: 
        str2 = emh.m(paramParcel, n);
        break;
      case 2: 
        str1 = emh.m(paramParcel, n);
        break;
      case 3: 
        arrayOfString = emh.t(paramParcel, n);
        break;
      case 4: 
        j = emh.e(paramParcel, n);
        break;
      case 5: 
        i = emh.e(paramParcel, n);
        break;
      case 6: 
        localQuerySpecification = (QuerySpecification)emh.a(paramParcel, n, QuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new emi("Overread allowed size end=" + m, paramParcel);
    }
    return new QueryCall.Request(k, str2, str1, arrayOfString, j, i, localQuerySpecification);
  }
}

/* Location:
 * Qualified Name:     gbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */