import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;

public abstract class bez
  extends Binder
  implements bey
{
  public bez()
  {
    attachInterface(this, "com.android.emailcommon.service.IEmailService");
  }
  
  public static bey a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.android.emailcommon.service.IEmailService");
    if ((localIInterface != null) && ((localIInterface instanceof bey))) {
      return (bey)localIInterface;
    }
    return new bfa(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    String str1 = null;
    boolean bool = false;
    long l1;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.android.emailcommon.service.IEmailService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      paramParcel2 = paramParcel1.readStrongBinder();
      if (paramParcel2 == null) {
        paramParcel2 = null;
      }
      for (;;)
      {
        l1 = paramParcel1.readLong();
        long l2 = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {
          bool = true;
        }
        a(paramParcel2, l1, l2, bool);
        return true;
        localObject1 = paramParcel2.queryLocalInterface("com.android.emailcommon.service.IEmailServiceCallback");
        if ((localObject1 != null) && ((localObject1 instanceof bfb))) {
          paramParcel2 = (bfb)localObject1;
        } else {
          paramParcel2 = new bfd(paramParcel2);
        }
      }
    case 2: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      c(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      l1 = paramParcel1.readLong();
      localObject1 = str1;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      paramInt1 = a(l1, (Bundle)localObject1);
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      if (localObject1 != null)
      {
        paramParcel2.writeInt(1);
        ((Bundle)localObject1).writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      b(paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      localObject1 = str2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (HostAuthCompat)HostAuthCompat.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((HostAuthCompat)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      l1 = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (SearchParams)SearchParams.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        paramParcel1 = a(l1, (SearchParams)localObject1, paramParcel1.readLong());
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readLong(), paramParcel1.readInt(), paramParcel1.readLong(), paramParcel1.readLong(), paramParcel1.readString());
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      l1 = paramParcel1.readLong();
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (ExchangeOofSettings)ExchangeOofSettings.CREATOR.createFromParcel(paramParcel1);
      }
      a(l1, paramParcel2);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readInt());
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      paramInt1 = a();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      a(paramParcel1.readLong(), paramParcel1.readString(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      b(paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      paramParcel1 = a(paramParcel1.readString(), paramParcel1.createStringArrayList(), paramParcel1.readLong(), paramParcel1.readLong());
      paramParcel2.writeNoException();
      paramParcel2.writeTypedList(paramParcel1);
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      paramParcel1 = b(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
      c(paramParcel1.readLong(), paramParcel1.readLong());
      return true;
    }
    paramParcel1.enforceInterface("com.android.emailcommon.service.IEmailService");
    str1 = paramParcel1.readString();
    str2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {
      localObject1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
    }
    paramParcel1 = a(str1, str2, (Bundle)localObject1);
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
}

/* Location:
 * Qualified Name:     bez
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */