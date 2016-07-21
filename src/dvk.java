import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class dvk
  implements dph
{
  public static final String a = cvl.a;
  public final WeakHashMap<Cursor, Object> b = new WeakHashMap();
  public dpf c;
  public final Object d = new Object();
  final Context e;
  final String f;
  final long g;
  public final Handler h;
  final drp i;
  private final Map<Long, dvo> j = new HashMap();
  
  public dvk(Context paramContext, String paramString, long paramLong, drp paramdrp)
  {
    e = paramContext;
    f = paramString;
    g = paramLong;
    h = new Handler(Looper.getMainLooper());
    i = paramdrp;
  }
  
  private final dvo a(dtu paramdtu)
  {
    long l = c;
    synchronized (j)
    {
      if (!j.containsKey(Long.valueOf(l)))
      {
        localdvo = new dvo(e, f, g, l, b);
        j.put(Long.valueOf(l), localdvo);
        localdvo.a(paramdtu);
        return localdvo;
      }
      dvo localdvo = (dvo)j.get(Long.valueOf(l));
    }
  }
  
  public final dvo a(long paramLong)
  {
    synchronized (j)
    {
      dvo localdvo = (dvo)j.get(Long.valueOf(paramLong));
      return localdvo;
    }
  }
  
  public final void a()
  {
    b();
  }
  
  public final dvo b(long paramLong)
  {
    dvo localdvo2 = a(paramLong);
    dvo localdvo1;
    dtu localdtu;
    if (localdvo2 != null)
    {
      localdvo1 = localdvo2;
      if (b) {}
    }
    else
    {
      localdtu = i.b(paramLong, false);
      if (localdtu != null) {
        break label56;
      }
      dri.b(a, "Message not found", new Object[0]);
      localdvo1 = null;
    }
    label56:
    do
    {
      do
      {
        return localdvo1;
        if (localdvo2 == null) {
          return a(localdtu);
        }
        localdvo1 = localdvo2;
      } while (b);
      localdvo1 = localdvo2;
    } while (b);
    localdvo2.a(localdtu);
    return localdvo2;
  }
  
  public final void b()
  {
    for (;;)
    {
      dvo localdvo;
      HashSet localHashSet;
      synchronized (j)
      {
        Iterator localIterator1 = j.values().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localdvo = (dvo)localIterator1.next();
        localHashSet = new HashSet();
        Iterator localIterator2 = localdvo.a().iterator();
        if (localIterator2.hasNext()) {
          localHashSet.add(nextb);
        }
      }
      dri.a(dvo.a, "Notifying about attachment change conversation message %d/%d", new Object[] { Long.valueOf(e), Long.valueOf(f) });
      GmailProvider.a(c, d, e, f, g, localHashSet);
    }
  }
}

/* Location:
 * Qualified Name:     dvk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */