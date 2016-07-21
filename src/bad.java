import android.net.ConnectivityManager;
import com.android.email.service.AttachmentService;
import com.android.email.service.AttachmentService.AttachmentWatchdog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public final class bad
  implements Runnable
{
  public bad(AttachmentService.AttachmentWatchdog paramAttachmentWatchdog, int paramInt) {}
  
  public final void run()
  {
    AttachmentService localAttachmentService = AttachmentService.b;
    if ((localAttachmentService == null) || (c)) {
      return;
    }
    AttachmentService.AttachmentWatchdog localAttachmentWatchdog = b;
    int j = a;
    Iterator localIterator = f.values().iterator();
    int i;
    label153:
    while (localIterator.hasNext())
    {
      bag localbag = (bag)localIterator.next();
      long l = c;
      if (System.currentTimeMillis() - i > j) {
        cvm.b("AttachmentService", "Timeout for DownloadRequest #%d ", new Object[] { Long.valueOf(c) });
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label153;
        }
        cvm.d("AttachmentService", "Cancelling DownloadRequest #%d", new Object[] { Long.valueOf(c) });
        localAttachmentService.a(localbag);
        break;
      }
    }
    if (d != null) {
      if (d.d.getActiveNetworkInfo() != null) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localAttachmentService.a();
      }
      if (f.isEmpty()) {
        break;
      }
      localAttachmentWatchdog.a(localAttachmentService);
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     bad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */