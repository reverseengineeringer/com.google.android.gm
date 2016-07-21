import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.corpora.RequestIndexingCall.Response;

public final class fzb
  implements Parcelable.Creator<RequestIndexingCall.Response>
{
  public static RequestIndexingCall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    boolean bool = false;
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
        bool = emh.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new RequestIndexingCall.Response(i, localStatus, bool);
  }
}

/* Location:
 * Qualified Name:     fzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */