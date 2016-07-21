import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.clearcut.LogEventParcelable;

public abstract class ehu
  extends Binder
  implements eht
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    paramParcel2 = paramParcel1.readStrongBinder();
    if (paramParcel2 == null) {
      paramParcel2 = null;
    }
    for (;;)
    {
      if (paramParcel1.readInt() != 0)
      {
        localObject = LogEventParcelable.CREATOR;
        localObject = eho.a(paramParcel1);
      }
      a(paramParcel2, (LogEventParcelable)localObject);
      return true;
      IInterface localIInterface = paramParcel2.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof ehq))) {
        paramParcel2 = (ehq)localIInterface;
      } else {
        paramParcel2 = new ehs(paramParcel2);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ehu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */