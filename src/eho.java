import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public final class eho
  implements Parcelable.Creator<LogEventParcelable>
{
  public static LogEventParcelable a(Parcel paramParcel)
  {
    int j = emh.a(paramParcel);
    byte[] arrayOfByte = null;
    PlayLoggerContext localPlayLoggerContext = null;
    int i = 0;
    int[] arrayOfInt = null;
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
        localPlayLoggerContext = (PlayLoggerContext)emh.a(paramParcel, k, PlayLoggerContext.CREATOR);
        break;
      case 3: 
        arrayOfByte = emh.p(paramParcel, k);
        break;
      case 4: 
        arrayOfInt = emh.q(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new emi("Overread allowed size end=" + j, paramParcel);
    }
    return new LogEventParcelable(i, localPlayLoggerContext, arrayOfByte, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     eho
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */