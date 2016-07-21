import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class cek<T extends Parcelable>
{
  private final Parcelable.Creator<T> a;
  
  public cek(Parcelable.Creator<T> paramCreator)
  {
    a = paramCreator;
  }
  
  public final T a(T paramT)
  {
    Parcel localParcel = Parcel.obtain();
    paramT.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramT = (Parcelable)a.createFromParcel(localParcel);
    localParcel.recycle();
    return paramT;
  }
}

/* Location:
 * Qualified Name:     cek
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */