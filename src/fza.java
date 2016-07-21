import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.corpora.RequestIndexingCall.Request;

public final class fza
  implements Parcelable.Creator<RequestIndexingCall.Request>
{
  public static RequestIndexingCall.Request a(Parcel paramParcel)
  {
    String str1 = null;
    int j = emh.a(paramParcel);
    int i = 0;
    long l = 0L;
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
        l = emh.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new RequestIndexingCall.Request(i, str2, str1, l);
  }
}

/* Location:
 * Qualified Name:     fza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */