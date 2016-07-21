import android.os.IInterface;
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

public abstract interface fcf
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(Status paramStatus);
  
  public abstract void a(ChangeSequenceNumber paramChangeSequenceNumber);
  
  public abstract void a(GetPermissionsResponse paramGetPermissionsResponse);
  
  public abstract void a(OnChangesResponse paramOnChangesResponse);
  
  public abstract void a(OnContentsResponse paramOnContentsResponse);
  
  public abstract void a(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse);
  
  public abstract void a(OnDownloadProgressResponse paramOnDownloadProgressResponse);
  
  public abstract void a(OnDriveIdResponse paramOnDriveIdResponse);
  
  public abstract void a(OnDrivePreferencesResponse paramOnDrivePreferencesResponse);
  
  public abstract void a(OnFetchThumbnailResponse paramOnFetchThumbnailResponse);
  
  public abstract void a(OnListEntriesResponse paramOnListEntriesResponse);
  
  public abstract void a(OnListParentsResponse paramOnListParentsResponse);
  
  public abstract void a(OnLoadRealtimeResponse paramOnLoadRealtimeResponse, fip paramfip);
  
  public abstract void a(OnMetadataResponse paramOnMetadataResponse);
  
  public abstract void a(OnResourceIdSetResponse paramOnResourceIdSetResponse);
  
  public abstract void a(OnSyncMoreResponse paramOnSyncMoreResponse);
  
  public abstract void a(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     fcf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */