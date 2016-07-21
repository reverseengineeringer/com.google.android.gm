import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Request;

public final class fzq
  implements Parcelable.Creator<GetGlobalSearchSourcesCall.Request>
{
  public static GetGlobalSearchSourcesCall.Request a(Parcel paramParcel)
  {
    boolean bool = false;
    int j = emh.a(paramParcel);
    int i = 0;
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
        bool = emh.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new GetGlobalSearchSourcesCall.Request(i, bool);
  }
}

/* Location:
 * Qualified Name:     fzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */