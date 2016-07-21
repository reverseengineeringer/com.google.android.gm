import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.dataservice.GplusInfoResponse;

public final class efa
  implements Parcelable.Creator<GplusInfoResponse>
{
  public static GplusInfoResponse a(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = emh.a(paramParcel);
    String str2 = null;
    String str3 = null;
    boolean bool2 = false;
    String str4 = null;
    String str5 = null;
    String str6 = null;
    boolean bool3 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default: 
        emh.b(paramParcel, k);
        break;
      case 1: 
        i = emh.e(paramParcel, k);
        break;
      case 2: 
        bool3 = emh.c(paramParcel, k);
        break;
      case 3: 
        str6 = emh.m(paramParcel, k);
        break;
      case 4: 
        str5 = emh.m(paramParcel, k);
        break;
      case 5: 
        str4 = emh.m(paramParcel, k);
        break;
      case 6: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 7: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 8: 
        str3 = emh.m(paramParcel, k);
        break;
      case 9: 
        str2 = emh.m(paramParcel, k);
        break;
      case 10: 
        str1 = emh.m(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GplusInfoResponse(i, bool3, str6, str5, str4, bool2, bool1, str3, str2, str1);
  }
}

/* Location:
 * Qualified Name:     efa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */