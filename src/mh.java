import android.os.Parcel;
import android.os.Parcelable.Creator;

final class mh<T>
  implements Parcelable.Creator<T>
{
  final mi<T> a;
  
  public mh(mi<T> parammi)
  {
    a = parammi;
  }
  
  public final T createFromParcel(Parcel paramParcel)
  {
    return (T)a.a(paramParcel, null);
  }
  
  public final T[] newArray(int paramInt)
  {
    return a.a(paramInt);
  }
}

/* Location:
 * Qualified Name:     mh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */