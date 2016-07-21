import android.content.IntentSender;
import android.os.IInterface;
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

public abstract interface fcc
  extends IInterface
{
  public abstract IntentSender a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest);
  
  public abstract IntentSender a(OpenFileIntentSenderRequest paramOpenFileIntentSenderRequest);
  
  public abstract DriveServiceResponse a(OpenContentsRequest paramOpenContentsRequest, fcf paramfcf);
  
  public abstract void a(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, fcf paramfcf);
  
  public abstract void a(AddEventListenerRequest paramAddEventListenerRequest, fci paramfci, String paramString, fcf paramfcf);
  
  public abstract void a(AddPermissionRequest paramAddPermissionRequest, fcf paramfcf);
  
  public abstract void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, fcf paramfcf);
  
  public abstract void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, fcf paramfcf);
  
  public abstract void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, fcf paramfcf);
  
  public abstract void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, fcf paramfcf);
  
  public abstract void a(CloseContentsRequest paramCloseContentsRequest, fcf paramfcf);
  
  public abstract void a(ControlProgressRequest paramControlProgressRequest, fcf paramfcf);
  
  public abstract void a(CreateContentsRequest paramCreateContentsRequest, fcf paramfcf);
  
  public abstract void a(CreateFileRequest paramCreateFileRequest, fcf paramfcf);
  
  public abstract void a(CreateFolderRequest paramCreateFolderRequest, fcf paramfcf);
  
  public abstract void a(DeleteResourceRequest paramDeleteResourceRequest, fcf paramfcf);
  
  public abstract void a(DisconnectRequest paramDisconnectRequest);
  
  public abstract void a(FetchThumbnailRequest paramFetchThumbnailRequest, fcf paramfcf);
  
  public abstract void a(GetChangesRequest paramGetChangesRequest, fcf paramfcf);
  
  public abstract void a(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, fcf paramfcf);
  
  public abstract void a(GetMetadataRequest paramGetMetadataRequest, fcf paramfcf);
  
  public abstract void a(GetPermissionsRequest paramGetPermissionsRequest, fcf paramfcf);
  
  public abstract void a(ListParentsRequest paramListParentsRequest, fcf paramfcf);
  
  public abstract void a(LoadRealtimeRequest paramLoadRealtimeRequest, fcf paramfcf);
  
  public abstract void a(QueryRequest paramQueryRequest, fcf paramfcf);
  
  public abstract void a(QueryRequest paramQueryRequest, fci paramfci, fcf paramfcf);
  
  public abstract void a(RemoveEventListenerRequest paramRemoveEventListenerRequest, fci paramfci, String paramString, fcf paramfcf);
  
  public abstract void a(RemovePermissionRequest paramRemovePermissionRequest, fcf paramfcf);
  
  public abstract void a(SetDrivePreferencesRequest paramSetDrivePreferencesRequest, fcf paramfcf);
  
  public abstract void a(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, fcf paramfcf);
  
  public abstract void a(SetResourceParentsRequest paramSetResourceParentsRequest, fcf paramfcf);
  
  public abstract void a(TrashResourceRequest paramTrashResourceRequest, fcf paramfcf);
  
  public abstract void a(UnsubscribeResourceRequest paramUnsubscribeResourceRequest, fcf paramfcf);
  
  public abstract void a(UntrashResourceRequest paramUntrashResourceRequest, fcf paramfcf);
  
  public abstract void a(UpdateMetadataRequest paramUpdateMetadataRequest, fcf paramfcf);
  
  public abstract void a(UpdatePermissionRequest paramUpdatePermissionRequest, fcf paramfcf);
  
  public abstract void a(fcf paramfcf);
  
  public abstract void a(fci paramfci, fcf paramfcf);
  
  public abstract void b(QueryRequest paramQueryRequest, fcf paramfcf);
  
  public abstract void b(fcf paramfcf);
  
  public abstract void c(fcf paramfcf);
  
  public abstract void d(fcf paramfcf);
  
  public abstract void e(fcf paramfcf);
  
  public abstract void f(fcf paramfcf);
}

/* Location:
 * Qualified Name:     fcc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */