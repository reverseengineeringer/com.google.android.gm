import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.internal.GetPermissionsResponse;
import com.google.android.gms.drive.internal.OnChangesResponse;
import com.google.android.gms.drive.internal.OnContentsResponse;
import com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnDrivePreferencesResponse;
import com.google.android.gms.drive.internal.OnFetchThumbnailResponse;
import com.google.android.gms.drive.internal.OnListEntriesResponse;
import com.google.android.gms.drive.internal.OnListParentsResponse;
import com.google.android.gms.drive.internal.OnLoadRealtimeResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;
import com.google.android.gms.drive.internal.OnResourceIdSetResponse;
import com.google.android.gms.drive.internal.OnSyncMoreResponse;

public abstract class fcg
  extends Binder
  implements fcf
{
  public fcg()
  {
    attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
  }
  
  public static fcf a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof fcf))) {
      return (fcf)localIInterface;
    }
    return new fch(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    IInterface localIInterface = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnDownloadProgressResponse)OnDownloadProgressResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnListEntriesResponse)OnListEntriesResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnDriveIdResponse)OnDriveIdResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnMetadataResponse)OnMetadataResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnContentsResponse)OnContentsResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Status)Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      a();
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnListParentsResponse)OnListParentsResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnSyncMoreResponse)OnSyncMoreResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      OnLoadRealtimeResponse localOnLoadRealtimeResponse;
      if (paramParcel1.readInt() != 0)
      {
        localOnLoadRealtimeResponse = (OnLoadRealtimeResponse)OnLoadRealtimeResponse.CREATOR.createFromParcel(paramParcel1);
        paramParcel1 = paramParcel1.readStrongBinder();
        if (paramParcel1 != null) {
          break label596;
        }
        paramParcel1 = localIInterface;
      }
      for (;;)
      {
        a(localOnLoadRealtimeResponse, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localOnLoadRealtimeResponse = null;
        break;
        localIInterface = paramParcel1.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
        if ((localIInterface != null) && ((localIInterface instanceof fip))) {
          paramParcel1 = (fip)localIInterface;
        } else {
          paramParcel1 = new fir(paramParcel1);
        }
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnResourceIdSetResponse)OnResourceIdSetResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnDrivePreferencesResponse)OnDrivePreferencesResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnDeviceUsagePreferenceResponse)OnDeviceUsagePreferenceResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        a(bool);
        paramParcel2.writeNoException();
        return true;
      }
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnFetchThumbnailResponse)OnFetchThumbnailResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (ChangeSequenceNumber)ChangeSequenceNumber.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 18: 
      label596:
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (OnChangesResponse)OnChangesResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (GetPermissionsResponse)GetPermissionsResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     fcg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */