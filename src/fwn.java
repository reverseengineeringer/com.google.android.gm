import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.people.identity.internal.ParcelableGetOptions;

public final class fwn
  implements Parcelable.Creator<ParcelableGetOptions>
{
  public static ParcelableGetOptions a(Parcel paramParcel)
  {
    Bundle localBundle = null;
    boolean bool1 = false;
    int j = emh.a(paramParcel);
    String str = null;
    boolean bool2 = false;
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
        bool3 = emh.c(paramParcel, k);
        break;
      case 1000: 
        i = emh.e(paramParcel, k);
        break;
      case 2: 
        bool2 = emh.c(paramParcel, k);
        break;
      case 3: 
        str = emh.m(paramParcel, k);
        break;
      case 4: 
        bool1 = emh.c(paramParcel, k);
        break;
      case 5: 
        localBundle = emh.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableGetOptions(i, bool3, bool2, bool1, str, localBundle);
  }
}

/* Location:
 * Qualified Name:     fwn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */