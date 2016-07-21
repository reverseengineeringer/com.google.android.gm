import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract class fhy
  extends Binder
  implements fhx
{
  public static fhx a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof fhx))) {
      return (fhx)localIInterface;
    }
    return new fhz(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      Object localObject;
      if (paramParcel1.readInt() != 0)
      {
        localObject = DataHolder.CREATOR;
        localObject = elm.a(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label117;
        }
      }
      label117:
      for (paramParcel1 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((DataHolder)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     fhy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */