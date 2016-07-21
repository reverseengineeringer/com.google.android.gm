import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Request;

public final class fzx
  implements Parcelable.Creator<SetIncludeInGlobalSearchCall.Request>
{
  public static SetIncludeInGlobalSearchCall.Request a(Parcel paramParcel)
  {
    boolean bool = false;
    int j = emh.a(paramParcel);
    String str = null;
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
        str = emh.m(paramParcel, k);
        break;
      case 2: 
        bool = emh.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new SetIncludeInGlobalSearchCall.Request(i, str, bool);
  }
}

/* Location:
 * Qualified Name:     fzx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */