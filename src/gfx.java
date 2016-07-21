import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.internal.AddListenerRequest;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.RemoveListenerRequest;

public abstract class gfx
  extends Binder
  implements gfw
{
  public static gfw a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
    if ((localIInterface != null) && ((localIInterface instanceof gfw))) {
      return (gfw)localIInterface;
    }
    return new gfy(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject1 = null;
    Object localObject12 = null;
    gfq localgfq = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localObject2 = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localgfq;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ConnectionConfiguration)ConnectionConfiguration.CREATOR.createFromParcel(paramParcel1);
      }
      a((gfq)localObject2, (ConnectionConfiguration)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      c(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (PutDataRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      b(localgfq, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 40: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (Uri)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      c(localgfq, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      b(localgfq, (Uri)localObject1, paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Asset)Asset.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (Asset)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      c(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      d(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      d(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      e(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AddListenerRequest)AddListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (AddListenerRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RemoveListenerRequest)RemoveListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (RemoveListenerRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      e(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      f(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      g(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      h(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (AncsNotificationParcelable)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      c(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      i(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      f(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), gfo.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(gfr.a(paramParcel1.readStrongBinder()), gfo.a(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
      }
      a(localgfq, (String)localObject2, (ParcelFileDescriptor)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a(localgfq, (String)localObject2, (ParcelFileDescriptor)localObject1, paramParcel1.readLong(), paramParcel1.readLong());
        paramParcel2.writeNoException();
        return true;
      }
    case 37: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      j(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localObject1 = gfr.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {}
      for (bool = true;; bool = false)
      {
        a((gfq)localObject1, bool);
        paramParcel2.writeNoException();
        return true;
      }
    case 49: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      k(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localObject1 = gfr.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      b((gfq)localObject1, bool);
      paramParcel2.writeNoException();
      return true;
    case 51: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      l(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 52: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      m(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 53: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(gfr.a(paramParcel1.readStrongBinder()), paramParcel1.readByte());
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localgfq = gfr.a(paramParcel1.readStrongBinder());
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ConnectionConfiguration)ConnectionConfiguration.CREATOR.createFromParcel(paramParcel1);
      }
      b(localgfq, (ConnectionConfiguration)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      n(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      o(gfr.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
    p(gfr.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     gfx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */