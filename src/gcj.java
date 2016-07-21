import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;

public abstract class gcj
  extends Binder
  implements gci
{
  public gcj()
  {
    attachInterface(this, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
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
      paramParcel2.writeString("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
      a(paramParcel1.readString(), paramParcel1.createTypedArrayList(Scope.CREATOR), gco.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
    a(paramParcel1.readString(), paramParcel1.readString(), gco.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gcj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */