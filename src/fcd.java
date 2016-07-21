import android.content.IntentSender;
import android.os.Binder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;
import com.google.android.gms.drive.internal.AddEventListenerRequest;
import com.google.android.gms.drive.internal.AddPermissionRequest;
import com.google.android.gms.drive.internal.AuthorizeAccessRequest;
import com.google.android.gms.drive.internal.CancelPendingActionsRequest;
import com.google.android.gms.drive.internal.CheckResourceIdsExistRequest;
import com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.ControlProgressRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.DeleteResourceRequest;
import com.google.android.gms.drive.internal.DisconnectRequest;
import com.google.android.gms.drive.internal.DriveServiceResponse;
import com.google.android.gms.drive.internal.FetchThumbnailRequest;
import com.google.android.gms.drive.internal.GetChangesRequest;
import com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.GetPermissionsRequest;
import com.google.android.gms.drive.internal.ListParentsRequest;
import com.google.android.gms.drive.internal.LoadRealtimeRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;
import com.google.android.gms.drive.internal.RemovePermissionRequest;
import com.google.android.gms.drive.internal.SetDrivePreferencesRequest;
import com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest;
import com.google.android.gms.drive.internal.SetResourceParentsRequest;
import com.google.android.gms.drive.internal.TrashResourceRequest;
import com.google.android.gms.drive.internal.UnsubscribeResourceRequest;
import com.google.android.gms.drive.internal.UntrashResourceRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.UpdatePermissionRequest;

public abstract class fcd
  extends Binder
  implements fcc
{
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
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
    Object localObject12 = null;
    Object localObject13 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject17 = null;
    Object localObject18 = null;
    Object localObject19 = null;
    Object localObject20 = null;
    Object localObject21 = null;
    Object localObject22 = null;
    Object localObject23 = null;
    Object localObject24 = null;
    Object localObject25 = null;
    Object localObject26 = null;
    Object localObject27 = null;
    Object localObject28 = null;
    Object localObject29 = null;
    Object localObject30 = null;
    Object localObject31 = null;
    Object localObject32 = null;
    Object localObject33 = null;
    Object localObject34 = null;
    Object localObject35 = null;
    Object localObject36 = null;
    Object localObject37 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetMetadataRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((QueryRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((UpdateMetadataRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateContentsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateFileRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CreateFolderRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((OpenContentsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CloseContentsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      a(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((OpenFileIntentSenderRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject10;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(paramParcel1);
      }
      paramParcel1 = a((CreateFileIntentSenderRequest)localObject1);
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel2.writeInt(0);
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject11;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AuthorizeAccessRequest)AuthorizeAccessRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((AuthorizeAccessRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject12;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ListParentsRequest)ListParentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((ListParentsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject13;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AddEventListenerRequest)AddEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((AddEventListenerRequest)localObject1, fcj.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject14;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RemoveEventListenerRequest)RemoveEventListenerRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((RemoveEventListenerRequest)localObject1, fcj.a(paramParcel1.readStrongBinder()), paramParcel1.readString(), fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject15;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DisconnectRequest)DisconnectRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((DisconnectRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject16;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (TrashResourceRequest)TrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((TrashResourceRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject17;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CloseContentsAndUpdateMetadataRequest)CloseContentsAndUpdateMetadataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CloseContentsAndUpdateMetadataRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject18;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      b((QueryRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject19;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (DeleteResourceRequest)DeleteResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((DeleteResourceRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject20;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (LoadRealtimeRequest)LoadRealtimeRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((LoadRealtimeRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject21;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (SetResourceParentsRequest)SetResourceParentsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((SetResourceParentsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject22;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetDriveIdFromUniqueIdentifierRequest)GetDriveIdFromUniqueIdentifierRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetDriveIdFromUniqueIdentifierRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject23;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CheckResourceIdsExistRequest)CheckResourceIdsExistRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CheckResourceIdsExistRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      b(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      c(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject24;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (SetDrivePreferencesRequest)SetDrivePreferencesRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((SetDrivePreferencesRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject25;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RealtimeDocumentSyncRequest)RealtimeDocumentSyncRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((RealtimeDocumentSyncRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      d(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject26;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (SetFileUploadPreferencesRequest)SetFileUploadPreferencesRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((SetFileUploadPreferencesRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject27;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (CancelPendingActionsRequest)CancelPendingActionsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((CancelPendingActionsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject28;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (UntrashResourceRequest)UntrashResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((UntrashResourceRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 41: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      e(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 42: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject29;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (FetchThumbnailRequest)FetchThumbnailRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((FetchThumbnailRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 43: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      f(fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 44: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject30;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetChangesRequest)GetChangesRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetChangesRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 46: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject31;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (UnsubscribeResourceRequest)UnsubscribeResourceRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((UnsubscribeResourceRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 47: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject32;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (GetPermissionsRequest)GetPermissionsRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((GetPermissionsRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 48: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject33;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (AddPermissionRequest)AddPermissionRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((AddPermissionRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 49: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject34;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (UpdatePermissionRequest)UpdatePermissionRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((UpdatePermissionRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject35;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (RemovePermissionRequest)RemovePermissionRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((RemovePermissionRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 51: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      localObject1 = localObject36;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (QueryRequest)QueryRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((QueryRequest)localObject1, fcj.a(paramParcel1.readStrongBinder()), fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 52: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
      a(fcj.a(paramParcel1.readStrongBinder()), fcg.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
    localObject1 = localObject37;
    if (paramParcel1.readInt() != 0) {
      localObject1 = (ControlProgressRequest)ControlProgressRequest.CREATOR.createFromParcel(paramParcel1);
    }
    a((ControlProgressRequest)localObject1, fcg.a(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}

/* Location:
 * Qualified Name:     fcd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */