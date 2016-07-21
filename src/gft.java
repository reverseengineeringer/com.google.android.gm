import android.os.IInterface;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract interface gft
  extends IInterface
{
  public abstract void a(DataHolder paramDataHolder);
  
  public abstract void a(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable);
  
  public abstract void a(AncsNotificationParcelable paramAncsNotificationParcelable);
  
  public abstract void a(CapabilityInfoParcelable paramCapabilityInfoParcelable);
  
  public abstract void a(ChannelEventParcelable paramChannelEventParcelable);
  
  public abstract void a(MessageEventParcelable paramMessageEventParcelable);
  
  public abstract void a(NodeParcelable paramNodeParcelable);
  
  public abstract void a(List<NodeParcelable> paramList);
  
  public abstract void b(NodeParcelable paramNodeParcelable);
}

/* Location:
 * Qualified Name:     gft
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */