import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class mj<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final mi<T> a;
  
  public mj(mi<T> parammi)
  {
    a = parammi;
  }
  
  public final T createFromParcel(Parcel paramParcel)
  {
    return (T)a.a(paramParcel, null);
  }
  
  public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return (T)a.a(paramParcel, paramClassLoader);
  }
  
  public final T[] newArray(int paramInt)
  {
    return a.a(paramInt);
  }
}

/* Location:
 * Qualified Name:     mj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */