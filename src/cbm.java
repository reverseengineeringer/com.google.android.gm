import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.widget.Toast;
import com.android.mail.compose.EmptyService;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import com.android.mail.ui.AttachmentTileGrid;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class cbm
  implements ccf
{
  cbm(cbk paramcbk) {}
  
  public final void a()
  {
    Intent localIntent = new Intent(a, EmptyService.class);
    if (cxd.a())
    {
      ClipDescription localClipDescription = new ClipDescription("attachment_uris", new String[] { "text/uri-list" });
      Iterator localIterator = a.r.b.iterator();
      ??? = null;
      while (localIterator.hasNext())
      {
        Object localObject3 = (Attachment)localIterator.next();
        if ((localObject3 != null) && (!cxa.b(i)))
        {
          localObject3 = new ClipData.Item(i);
          if (??? == null) {
            ??? = new ClipData(localClipDescription, (ClipData.Item)localObject3);
          } else {
            ((ClipData)???).addItem((ClipData.Item)localObject3);
          }
        }
      }
      localIntent.setClipData((ClipData)???);
      localIntent.setFlags(1);
    }
    synchronized (cbk.o)
    {
      if (cbk.o.getAndAdd(1) == 0) {
        a.startService(localIntent);
      }
      if (cbk.m != null) {
        cbk.m.a();
      }
      return;
    }
  }
  
  public final void a(ccg paramccg, Message paramMessage)
  {
    synchronized (a.L)
    {
      a.a(paramMessage, a);
      if (cbk.m != null) {
        cbk.m.a(paramccg, paramMessage);
      }
      return;
    }
  }
  
  public final void a(ccg paramccg, boolean paramBoolean)
  {
    if (a.s != null)
    {
      Object localObject2 = cgr.b;
      ??? = a.s.g.toString();
      localObject2 = ((cgr)localObject2).d().edit();
      ((SharedPreferences.Editor)localObject2).putString("lastSendFromAccount", (String)???);
      ((SharedPreferences.Editor)localObject2).apply();
    }
    if (paramBoolean) {
      a.p();
    }
    synchronized (cbk.o)
    {
      if (cbk.o.addAndGet(-1) == 0) {
        a.stopService(new Intent(a, EmptyService.class));
      }
      if (cbk.m != null) {
        cbk.m.a(paramccg, paramBoolean);
      }
      return;
      Toast.makeText(a, buj.eC, 0).show();
    }
  }
  
  public final long b()
  {
    synchronized (a.L)
    {
      long l = a.I;
      return l;
    }
  }
}

/* Location:
 * Qualified Name:     cbm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */