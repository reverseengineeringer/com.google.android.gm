import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.ime.GetIMEUpdatesCall.Request;

public final class gaj
  implements Parcelable.Creator<GetIMEUpdatesCall.Request>
{
  public static GetIMEUpdatesCall.Request a(Parcel paramParcel)
  {
    int j = 0;
    int k = emh.a(paramParcel);
    byte[] arrayOfByte = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1000: 
        i = emh.e(paramParcel, m);
        break;
      case 1: 
        j = emh.e(paramParcel, m);
        break;
      case 2: 
        arrayOfByte = emh.p(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    return new GetIMEUpdatesCall.Request(i, j, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     gaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */