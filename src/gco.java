import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.CheckServerAuthResult;
import com.google.android.gms.signin.internal.RecordConsentRequest;

public abstract class gco
  extends Binder
  implements gcn
{
  public static gcn a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
    if ((localIInterface != null) && ((localIInterface instanceof gcn))) {
      return (gcn)localIInterface;
    }
    return new gcp(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    IInterface localIInterface = null;
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.signin.internal.ISignInService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject = (AuthAccountRequest)AuthAccountRequest.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        a((AuthAccountRequest)localObject, gcl.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (CheckServerAuthResult)CheckServerAuthResult.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a(bool1);
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0)
      {
        localObject = (ResolveAccountRequest)ResolveAccountRequest.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          break label298;
        }
        paramParcel1 = localIInterface;
      }
      for (;;)
      {
        a((ResolveAccountRequest)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
        localIInterface = paramParcel1.queryLocalInterface("com.google.android.gms.common.internal.IResolveAccountCallbacks");
        if ((localIInterface != null) && ((localIInterface instanceof ent))) {
          paramParcel1 = (ent)localIInterface;
        } else {
          paramParcel1 = new env(paramParcel1);
        }
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      a(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {}
      for (localObject = (Account)Account.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        a(paramInt1, (Account)localObject, gcl.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      localObject = emf.a(paramParcel1.readStrongBinder());
      paramInt1 = paramParcel1.readInt();
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      a((eme)localObject, paramInt1, bool1);
      paramParcel2.writeNoException();
      return true;
    case 10: 
      label298:
      paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject = (RecordConsentRequest)RecordConsentRequest.CREATOR.createFromParcel(paramParcel1);; localObject = null)
      {
        a((RecordConsentRequest)localObject, gcl.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.signin.internal.ISignInService");
    a(gcl.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gco
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */