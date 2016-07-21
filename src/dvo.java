import android.content.Context;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class dvo
{
  static final String a = cvl.a;
  boolean b = false;
  final Context c;
  final String d;
  final long e;
  final long f;
  final long g;
  private final List<GmailAttachment> h = new ArrayList();
  
  public dvo(Context paramContext, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    c = paramContext;
    d = paramString;
    e = paramLong1;
    f = paramLong2;
    g = paramLong3;
  }
  
  public final GmailAttachment a(String paramString)
  {
    if (paramString != null) {
      synchronized (h)
      {
        Iterator localIterator = h.iterator();
        while (localIterator.hasNext())
        {
          GmailAttachment localGmailAttachment = (GmailAttachment)localIterator.next();
          if (paramString.equalsIgnoreCase(b)) {
            return localGmailAttachment;
          }
        }
      }
    }
    return null;
  }
  
  public final List<GmailAttachment> a()
  {
    synchronized (h)
    {
      hef localhef = hef.a(h);
      return localhef;
    }
  }
  
  final void a(dtu paramdtu)
  {
    a(r);
  }
  
  public final void a(List<GmailAttachment> paramList)
  {
    for (;;)
    {
      synchronized (h)
      {
        h.clear();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        GmailAttachment localGmailAttachment = (GmailAttachment)paramList.next();
        if (e == null) {
          e = GmailProvider.a(d, e, f, g, b, localGmailAttachment.l());
        }
        String str1;
        long l;
        String str2;
        if (i == null)
        {
          str1 = d;
          l = g;
          str2 = b;
          if (g == 1)
          {
            bool = true;
            i = dpy.a(str1, l, str2, 1, bool);
          }
        }
        else
        {
          if (j == null)
          {
            str1 = d;
            l = g;
            str2 = b;
            if (g != 1) {
              break label222;
            }
            bool = true;
            j = dpy.a(str1, l, str2, 0, bool);
          }
          h.add(localGmailAttachment);
        }
      }
      boolean bool = false;
      continue;
      label222:
      bool = false;
    }
    b = true;
  }
}

/* Location:
 * Qualified Name:     dvo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */