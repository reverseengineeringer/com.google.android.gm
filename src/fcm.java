import android.os.Binder;
import android.os.Parcel;

public abstract class fcm
  extends Binder
  implements fcl
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     fcm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */