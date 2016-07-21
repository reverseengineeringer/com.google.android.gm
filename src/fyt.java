import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.corpora.ClearCorpusCall.Response;

public final class fyt
  implements Parcelable.Creator<ClearCorpusCall.Response>
{
  public static ClearCorpusCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    int i = 0;
    Status localStatus = null;
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
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new ClearCorpusCall.Response(i, localStatus);
  }
}

/* Location:
 * Qualified Name:     fyt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */