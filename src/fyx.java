import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.corpora.GetCorpusStatusCall.Request;

public final class fyx
  implements Parcelable.Creator<GetCorpusStatusCall.Request>
{
  public static GetCorpusStatusCall.Request a(Parcel paramParcel)
  {
    String str2 = null;
    int j = emh.a(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = emh.m(paramParcel, k);
        break;
      case 2: 
        str2 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetCorpusStatusCall.Request(i, str1, str2);
  }
}

/* Location:
 * Qualified Name:     fyx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */