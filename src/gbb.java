import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.search.nativeapi.GetNativeApiInfoCall.Request;

public abstract class gbb
  extends Binder
  implements gba
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IInterface localIInterface = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.search.nativeapi.internal.INativeApiService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.search.nativeapi.internal.INativeApiService");
    Object localObject;
    if (paramParcel1.readInt() != 0)
    {
      localObject = GetNativeApiInfoCall.Request.CREATOR;
      localObject = gav.a(paramParcel1);
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 != null) {
        break label105;
      }
      paramParcel1 = localIInterface;
    }
    for (;;)
    {
      a((GetNativeApiInfoCall.Request)localObject, paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localObject = null;
      break;
      label105:
      localIInterface = paramParcel1.queryLocalInterface("com.google.android.gms.search.nativeapi.internal.INativeApiCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof gax))) {
        paramParcel1 = (gax)localIInterface;
      } else {
        paramParcel1 = new gaz(paramParcel1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     gbb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */