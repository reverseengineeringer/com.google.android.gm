import android.os.Handler;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class dpl
  implements Runnable
{
  dpl(dpj paramdpj, List paramList, Map paramMap) {}
  
  public final void run()
  {
    dpj localdpj = c;
    List localList = a;
    Map localMap = b;
    Iterator localIterator = localList.iterator();
    long l1 = 0L;
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      dpi localdpi = (dpi)localIterator.next();
      j = i;
      long l2 = l1;
      if (localMap.containsKey(Long.valueOf(a)))
      {
        GmailAttachment localGmailAttachment = (GmailAttachment)localMap.get(Long.valueOf(a));
        dri.b(dpf.a, "ASL download status changed for %s: size=%d, status=%d", new Object[] { b, Long.valueOf(b), Integer.valueOf(c) });
        h = ((int)b);
        t = c;
        int m = c;
        int n = d;
        if (c != 8)
        {
          j = i;
          l2 = l1;
          if (c != 16) {}
        }
        else
        {
          int k = n;
          j = m;
          if (c == 8)
          {
            k = n;
            j = m;
            if (h != d)
            {
              j = 16;
              k = 1000;
              dri.e(dpf.a, "Attachment downloaded size does not match size.", new Object[0]);
            }
          }
          l2 = l1;
          if (j == 8) {
            l2 = l1 + h;
          }
          i += 1;
          c.h.a(a, j, k);
          j = i;
        }
      }
      l1 = l2;
    }
    if (localList.isEmpty()) {
      dri.e(dpf.a, "DownloadListener: no rows found in cursor", new Object[0]);
    }
    for (;;)
    {
      a.post(b);
      return;
      if ((l1 == 0L) && (i > 0)) {
        dri.e(dpf.a, "DownloadListener: %d attachments downloaded, size never above 0", new Object[] { Integer.valueOf(i) });
      }
    }
  }
}

/* Location:
 * Qualified Name:     dpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */