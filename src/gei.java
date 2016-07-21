import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

final class gei
  extends gfu
{
  boolean a = false;
  
  gei(geh paramgeh)
  {
    a = (paramgeh instanceof ges);
  }
  
  public final void a(DataHolder paramDataHolder)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onDataItemChanged: ").append(b.c).append(": ").append(paramDataHolder);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f)
      {
        paramDataHolder.c();
        return;
      }
      b.d.post(new gej(this, paramDataHolder));
      return;
    }
  }
  
  public final void a(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onEntityUpdate: ").append(paramAmsEntityUpdateParcelable);
    }
    if (!a) {
      return;
    }
    geh.a(b);
    ges localges = (ges)b;
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
    }
    b.d.post(new geq(this, localges, paramAmsEntityUpdateParcelable));
  }
  
  public final void a(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onNotificationReceived: ").append(paramAncsNotificationParcelable);
    }
    if (!a) {
      return;
    }
    geh.a(b);
    ges localges = (ges)b;
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
    }
    b.d.post(new gep(this, localges, paramAncsNotificationParcelable));
  }
  
  public final void a(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onConnectedCapabilityChanged: ").append(paramCapabilityInfoParcelable);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new geo(this, paramCapabilityInfoParcelable));
      return;
    }
  }
  
  public final void a(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onChannelEvent: ").append(paramChannelEventParcelable);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new ger(this, paramChannelEventParcelable));
      return;
    }
  }
  
  public final void a(MessageEventParcelable paramMessageEventParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onMessageReceived: ").append(paramMessageEventParcelable);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new gek(this, paramMessageEventParcelable));
      return;
    }
  }
  
  public final void a(NodeParcelable paramNodeParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onPeerConnected: ").append(b.c).append(": ").append(paramNodeParcelable);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new gel(this, paramNodeParcelable));
      return;
    }
  }
  
  public final void a(List<NodeParcelable> paramList)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onConnectedNodes: ").append(b.c).append(": ").append(paramList);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new gen(this, paramList));
      return;
    }
  }
  
  public final void b(NodeParcelable paramNodeParcelable)
  {
    if (Log.isLoggable("WearableLS", 3)) {
      new StringBuilder("onPeerDisconnected: ").append(b.c).append(": ").append(paramNodeParcelable);
    }
    geh.a(b);
    synchronized (b.e)
    {
      if (b.f) {
        return;
      }
      b.d.post(new gem(this, paramNodeParcelable));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */