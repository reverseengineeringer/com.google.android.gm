import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;

public abstract class fwu
  extends Binder
  implements fwt
{
  public fwu()
  {
    attachInterface(this, "com.google.android.gms.people.internal.IPeopleCallbacks");
  }
  
  public static fwt a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof fwt))) {
      return (fwt)localIInterface;
    }
    return new fwv(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.people.internal.IPeopleCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label147;
        }
      }
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel2 = null)
      {
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = DataHolder.CREATOR;
          localObject1 = elm.a(paramParcel1);
        }
        a(paramInt1, paramParcel2, (DataHolder)localObject1);
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label281;
        }
      }
      for (paramParcel1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramInt1, paramParcel2, paramParcel1);
        return true;
        paramParcel2 = null;
        break;
      }
    case 4: 
      label147:
      label281:
      paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
      paramInt1 = paramParcel1.readInt();
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramInt1, paramParcel2, (DataHolder[])paramParcel1.createTypedArray(DataHolder.CREATOR));
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.people.internal.IPeopleCallbacks");
    paramInt1 = paramParcel1.readInt();
    if (paramParcel1.readInt() != 0)
    {
      paramParcel2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0) {
        break label426;
      }
      localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
      label390:
      if (paramParcel1.readInt() == 0) {
        break label432;
      }
    }
    label426:
    label432:
    for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramInt1, paramParcel2, (ParcelFileDescriptor)localObject1, paramParcel1);
      return true;
      paramParcel2 = null;
      break;
      localObject1 = null;
      break label390;
    }
  }
}

/* Location:
 * Qualified Name:     fwu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */