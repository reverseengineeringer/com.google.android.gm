import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.people.internal.ParcelableLoadImageOptions;

public final class fxa
  implements Parcelable.Creator<ParcelableLoadImageOptions>
{
  public static ParcelableLoadImageOptions a(Parcel paramParcel)
  {
    boolean bool = false;
    int m = emh.a(paramParcel);
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default: 
        emh.b(paramParcel, n);
        break;
      case 1: 
        j = emh.e(paramParcel, n);
        break;
      case 1000: 
        i = emh.e(paramParcel, n);
        break;
      case 2: 
        k = emh.e(paramParcel, n);
        break;
      case 3: 
        bool = emh.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new emi("Overread allowed size end=" + m, paramParcel);
    }
    return new ParcelableLoadImageOptions(i, j, k, bool);
  }
}

/* Location:
 * Qualified Name:     fxa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */