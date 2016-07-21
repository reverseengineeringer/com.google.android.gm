import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public final class elm
  implements Parcelable.Creator<DataHolder>
{
  public static DataHolder a(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int k = emh.a(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default: 
        emh.b(paramParcel, m);
        break;
      case 1: 
        arrayOfString = emh.t(paramParcel, m);
        break;
      case 1000: 
        j = emh.e(paramParcel, m);
        break;
      case 2: 
        arrayOfCursorWindow = (CursorWindow[])emh.b(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3: 
        i = emh.e(paramParcel, m);
        break;
      case 4: 
        localBundle = emh.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new emi("Overread allowed size end=" + k, paramParcel);
    }
    paramParcel = new DataHolder(j, arrayOfString, arrayOfCursorWindow, i, localBundle);
    paramParcel.a();
    return paramParcel;
  }
}

/* Location:
 * Qualified Name:     elm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */