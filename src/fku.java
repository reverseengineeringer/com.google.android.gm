import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.googlehelp.GoogleHelp;
import com.google.android.gms.googlehelp.internal.common.TogglingData;

public abstract class fku
  extends Binder
  implements fkt
{
  public fku()
  {
    attachInterface(this, "com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
  }
  
  public static fkt a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof fkt))) {
      return (fkt)localIInterface;
    }
    return new fkv(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GoogleHelp)GoogleHelp.CREATOR.createFromParcel(paramParcel1);
      }
      a((GoogleHelp)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (TogglingData)TogglingData.CREATOR.createFromParcel(paramParcel1);
      }
      a((TogglingData)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      a();
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      b();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
      c();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.googlehelp.internal.common.IGoogleHelpCallbacks");
    d();
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     fku
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */