import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.corpora.ClearCorpusCall.Request;

public final class fys
  implements Parcelable.Creator<ClearCorpusCall.Request>
{
  public static ClearCorpusCall.Request a(Parcel paramParcel)
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
    return new ClearCorpusCall.Request(i, str1, str2);
  }
}

/* Location:
 * Qualified Name:     fys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */