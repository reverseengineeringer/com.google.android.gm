import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.ime.GetCorpusHandlesRegisteredForIMECall.Response;

public final class gai
  implements Parcelable.Creator<GetCorpusHandlesRegisteredForIMECall.Response>
{
  public static GetCorpusHandlesRegisteredForIMECall.Response a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    Status localStatus = null;
    int i = 0;
    String[] arrayOfString = null;
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
        arrayOfString = emh.t(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetCorpusHandlesRegisteredForIMECall.Response(i, localStatus, arrayOfString);
  }
}

/* Location:
 * Qualified Name:     gai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */