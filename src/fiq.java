import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

public abstract class fiq
  extends Binder
  implements fip
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str3 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    String str1 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    String str2 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), fit.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(fhm.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(fhm.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 40: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(fin.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 45: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      c(fhm.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), fit.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), fhv.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), fin.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      localObject1 = str2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = DataHolder.CREATOR;
        localObject1 = elm.a(paramParcel1);
      }
      a(str1, (DataHolder)localObject1, fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), fhv.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), fhy.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), fin.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), fit.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), fhv.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      c(paramParcel1.readString(), fin.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject1 = str3;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = DataHolder.CREATOR;
        localObject1 = elm.a(paramParcel1);
      }
      a(str1, paramInt1, (DataHolder)localObject1, fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = DataHolder.CREATOR;
        localObject1 = elm.a(paramParcel1);
      }
      a(str1, paramInt1, (DataHolder)localObject1, fhy.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), fhy.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((BeginCompoundOperationRequest)localObject1, fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((EndCompoundOperationRequest)localObject1, fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      d(fhm.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      e(fhm.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool, fiw.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 50: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readInt(), fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(paramParcel1);
      }
      a((ParcelableIndexReference)localObject1, fit.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject1;
      }
      for (;;)
      {
        a(str1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
        if ((localObject1 != null) && ((localObject1 instanceof fij))) {
          paramParcel1 = (fij)localObject1;
        } else {
          paramParcel1 = new fil(paramParcel1);
        }
      }
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(fin.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readInt(), fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject3;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
        if ((localObject1 != null) && ((localObject1 instanceof fhr))) {
          paramParcel1 = (fhr)localObject1;
        } else {
          paramParcel1 = new fht(paramParcel1);
        }
      }
    case 32: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject4;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
        if ((localObject1 != null) && ((localObject1 instanceof fho))) {
          paramParcel1 = (fho)localObject1;
        } else {
          paramParcel1 = new fhq(paramParcel1);
        }
      }
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject5;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
        if ((localObject1 != null) && ((localObject1 instanceof fid))) {
          paramParcel1 = (fid)localObject1;
        } else {
          paramParcel1 = new fif(paramParcel1);
        }
      }
    case 36: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject6;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
        if ((localObject1 != null) && ((localObject1 instanceof fia))) {
          paramParcel1 = (fia)localObject1;
        } else {
          paramParcel1 = new fic(paramParcel1);
        }
      }
    case 38: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 39: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), paramParcel1.readString(), fhv.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str2 = paramParcel1.readString();
      str3 = paramParcel1.readString();
      localObject1 = str1;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = DataHolder.CREATOR;
        localObject1 = elm.a(paramParcel1);
      }
      a(str2, str3, (DataHolder)localObject1, fih.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 44: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a();
      paramParcel2.writeNoException();
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DriveId)DriveId.CREATOR.createFromParcel(paramParcel1);
      }
      a((DriveId)localObject1, fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 49: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      c(fiw.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
    localObject1 = localObject11;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
    }
    a((EndCompoundOperationRequest)localObject1, fiw.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     fiq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */