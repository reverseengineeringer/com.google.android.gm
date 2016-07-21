import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bfc
  extends Binder
  implements bfb
{
  public bfc()
  {
    attachInterface(this, "com.android.emailcommon.service.IEmailServiceCallback");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.emailcommon.service.IEmailServiceCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailServiceCallback");
    a(paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readInt());
    return true;
  }
}

/* Location:
 * Qualified Name:     bfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */