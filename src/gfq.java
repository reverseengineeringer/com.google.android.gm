import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AddLocalCapabilityResponse;
import com.google.android.gms.wearable.internal.ChannelReceiveFileResponse;
import com.google.android.gms.wearable.internal.ChannelSendFileResponse;
import com.google.android.gms.wearable.internal.CloseChannelResponse;
import com.google.android.gms.wearable.internal.DeleteDataItemsResponse;
import com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse;
import com.google.android.gms.wearable.internal.GetCapabilityResponse;
import com.google.android.gms.wearable.internal.GetChannelInputStreamResponse;
import com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse;
import com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse;
import com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse;
import com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse;
import com.google.android.gms.wearable.internal.GetConfigResponse;
import com.google.android.gms.wearable.internal.GetConfigsResponse;
import com.google.android.gms.wearable.internal.GetConnectedNodesResponse;
import com.google.android.gms.wearable.internal.GetDataItemResponse;
import com.google.android.gms.wearable.internal.GetFdForAssetResponse;
import com.google.android.gms.wearable.internal.GetLocalNodeResponse;
import com.google.android.gms.wearable.internal.OpenChannelResponse;
import com.google.android.gms.wearable.internal.PutDataResponse;
import com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse;
import com.google.android.gms.wearable.internal.SendMessageResponse;
import com.google.android.gms.wearable.internal.StorageInfoResponse;

public abstract interface gfq
  extends IInterface
{
  public abstract void a(Status paramStatus);
  
  public abstract void a(DataHolder paramDataHolder);
  
  public abstract void a(AddLocalCapabilityResponse paramAddLocalCapabilityResponse);
  
  public abstract void a(ChannelReceiveFileResponse paramChannelReceiveFileResponse);
  
  public abstract void a(ChannelSendFileResponse paramChannelSendFileResponse);
  
  public abstract void a(CloseChannelResponse paramCloseChannelResponse);
  
  public abstract void a(DeleteDataItemsResponse paramDeleteDataItemsResponse);
  
  public abstract void a(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse);
  
  public abstract void a(GetCapabilityResponse paramGetCapabilityResponse);
  
  public abstract void a(GetChannelInputStreamResponse paramGetChannelInputStreamResponse);
  
  public abstract void a(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse);
  
  public abstract void a(GetCloudSyncOptInOutDoneResponse paramGetCloudSyncOptInOutDoneResponse);
  
  public abstract void a(GetCloudSyncOptInStatusResponse paramGetCloudSyncOptInStatusResponse);
  
  public abstract void a(GetCloudSyncSettingResponse paramGetCloudSyncSettingResponse);
  
  public abstract void a(GetConfigResponse paramGetConfigResponse);
  
  public abstract void a(GetConfigsResponse paramGetConfigsResponse);
  
  public abstract void a(GetConnectedNodesResponse paramGetConnectedNodesResponse);
  
  public abstract void a(GetDataItemResponse paramGetDataItemResponse);
  
  public abstract void a(GetFdForAssetResponse paramGetFdForAssetResponse);
  
  public abstract void a(GetLocalNodeResponse paramGetLocalNodeResponse);
  
  public abstract void a(OpenChannelResponse paramOpenChannelResponse);
  
  public abstract void a(PutDataResponse paramPutDataResponse);
  
  public abstract void a(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse);
  
  public abstract void a(SendMessageResponse paramSendMessageResponse);
  
  public abstract void a(StorageInfoResponse paramStorageInfoResponse);
  
  public abstract void b(CloseChannelResponse paramCloseChannelResponse);
}

/* Location:
 * Qualified Name:     gfq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */