import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public abstract class bew
  extends Binder
  implements bev
{
  public bew()
  {
    attachInterface(this, "com.android.emailcommon.service.IAccountService");
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
      paramParcel2.writeString("com.android.emailcommon.service.IAccountService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IAccountService");
      paramInt1 = a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IAccountService");
      paramParcel1 = a(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.android.emailcommon.service.IAccountService");
    paramParcel1 = a();
    paramParcel2.writeNoException();
    paramParcel2.writeString(paramParcel1);
    return true;
  }
}

/* Location:
 * Qualified Name:     bew
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */