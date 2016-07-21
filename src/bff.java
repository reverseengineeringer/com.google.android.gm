import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.emailcommon.provider.Policy;

public abstract class bff
  extends Binder
  implements bfe
{
  public bff()
  {
    attachInterface(this, "com.android.emailcommon.service.IPolicyService");
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str = null;
    Object localObject = null;
    int i = 0;
    boolean bool = false;
    long l;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.emailcommon.service.IPolicyService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
      if (paramParcel1.readInt() != 0) {
        localObject = (Policy)Policy.CREATOR.createFromParcel(paramParcel1);
      }
      bool = a((Policy)localObject);
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      a(l, bool);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
      l = paramParcel1.readLong();
      localObject = str;
      if (paramParcel1.readInt() != 0) {
        localObject = (Policy)Policy.CREATOR.createFromParcel(paramParcel1);
      }
      a(l, (Policy)localObject, paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
      l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Policy)Policy.CREATOR.createFromParcel(paramParcel1);
        str = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          break label320;
        }
      }
      for (bool = true;; bool = false)
      {
        a(l, (Policy)localObject, str, bool);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    case 5: 
      label320:
      paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
      a();
      return true;
    }
    paramParcel1.enforceInterface("com.android.emailcommon.service.IPolicyService");
    bool = b();
    paramParcel2.writeNoException();
    paramInt1 = i;
    if (bool) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}

/* Location:
 * Qualified Name:     bff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */