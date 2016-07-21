import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.RegisterCorpusInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.corpora.GetCorpusInfoCall.Response;

public final class fyv
  implements Parcelable.Creator<GetCorpusInfoCall.Response>
{
  public static GetCorpusInfoCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    RegisterCorpusInfo localRegisterCorpusInfo = null;
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
        localRegisterCorpusInfo = (RegisterCorpusInfo)emh.a(paramParcel, k, RegisterCorpusInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetCorpusInfoCall.Response(i, localStatus, localRegisterCorpusInfo);
  }
}

/* Location:
 * Qualified Name:     fyv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */