import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;

public abstract class gfu
  extends Binder
  implements gft
{
  public gfu()
  {
    attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
  }
  
  public static gft a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
    if ((localIInterface != null) && ((localIInterface instanceof gft))) {
      return (gft)localIInterface;
    }
    return new gfv(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0)
      {
        paramParcel2 = DataHolder.CREATOR;
        paramParcel2 = elm.a(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (MessageEventParcelable)MessageEventParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject4;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (NodeParcelable)NodeParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      b(paramParcel2);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      a(paramParcel1.createTypedArrayList(NodeParcelable.CREATOR));
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject5;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (AncsNotificationParcelable)AncsNotificationParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject6;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (ChannelEventParcelable)ChannelEventParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject7;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (CapabilityInfoParcelable)CapabilityInfoParcelable.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
    paramParcel2 = (Parcel)localObject8;
    if (paramParcel1.readInt() != 0) {
      paramParcel2 = (AmsEntityUpdateParcelable)AmsEntityUpdateParcelable.CREATOR.createFromParcel(paramParcel1);
    }
    a(paramParcel2);
    return true;
  }
}

/* Location:
 * Qualified Name:     gfu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */