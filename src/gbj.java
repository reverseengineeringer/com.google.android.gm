import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.GlobalSearchQuerySpecification;
import com.google.android.gms.search.queries.GlobalQueryCall.Request;

public final class gbj
  implements Parcelable.Creator<GlobalQueryCall.Request>
{
  public static GlobalQueryCall.Request a(Parcel paramParcel)
  {
    GlobalSearchQuerySpecification localGlobalSearchQuerySpecification = null;
    int i = 0;
    int m = emh.a(paramParcel);
    int j = 0;
    String str = null;
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
        str = emh.m(paramParcel, n);
        break;
      case 2: 
        j = emh.e(paramParcel, n);
        break;
      case 3: 
        i = emh.e(paramParcel, n);
        break;
      case 4: 
        localGlobalSearchQuerySpecification = (GlobalSearchQuerySpecification)emh.a(paramParcel, n, GlobalSearchQuerySpecification.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new emi("Overread allowed size end=" + m, paramParcel);
    }
    return new GlobalQueryCall.Request(k, str, j, i, localGlobalSearchQuerySpecification);
  }
}

/* Location:
 * Qualified Name:     gbj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */