import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.people.model.AvatarReference;

public final class fyd
  implements Parcelable.Creator<AvatarReference>
{
  public static AvatarReference a(Parcel paramParcel)
  {
    int j = 0;
    int k = emh.a(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1: 
        j = emh.e(paramParcel, m);
        break;
      case 1000: 
        i = emh.e(paramParcel, m);
        break;
      case 2: 
        str = emh.m(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    return new AvatarReference(i, j, str);
  }
}

/* Location:
 * Qualified Name:     fyd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */