import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public final class ggw<T>
  extends gfu
{
  gdf a;
  gdh b;
  gdp c;
  gdx d;
  geb e;
  gea f;
  gdl g;
  gdj h;
  public final IntentFilter[] i;
  public final String j;
  public final String k;
  
  public final void a(DataHolder paramDataHolder)
  {
    if (c != null) {
      try
      {
        c.a(new gds(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.c();
      }
    }
    paramDataHolder.c();
  }
  
  public final void a(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable) {}
  
  public final void a(AncsNotificationParcelable paramAncsNotificationParcelable) {}
  
  public final void a(CapabilityInfoParcelable paramCapabilityInfoParcelable) {}
  
  public final void a(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (g != null) {
      paramChannelEventParcelable.a();
    }
  }
  
  public final void a(MessageEventParcelable paramMessageEventParcelable)
  {
    if (d != null) {
      d.a(paramMessageEventParcelable);
    }
  }
  
  public final void a(NodeParcelable paramNodeParcelable) {}
  
  public final void a(List<NodeParcelable> paramList) {}
  
  public final void b(NodeParcelable paramNodeParcelable) {}
}

/* Location:
 * Qualified Name:     ggw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */