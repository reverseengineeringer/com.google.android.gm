import android.os.Binder;
import android.os.Parcel;

public abstract class ddf
  extends Binder
  implements dde
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.calendar.ICalendarOobeService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.calendar.ICalendarOobeService");
    boolean bool = a();
    paramParcel2.writeNoException();
    if (bool) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramParcel2.writeInt(paramInt1);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     ddf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */