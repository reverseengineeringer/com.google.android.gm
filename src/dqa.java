import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils.StringSplitter;
import android.util.LruCache;
import java.util.Map;

public class dqa
  extends dqf
{
  final int a = r.getColumnIndexOrThrow("subject");
  final int b = r.getColumnIndexOrThrow("snippet");
  final int c = r.getColumnIndexOrThrow("fromAddress");
  final int d = r.getColumnIndex("fromProtoBuf");
  final int e = r.getColumnIndex("fromCompact");
  final int f = r.getColumnIndex("date");
  final int g = r.getColumnIndexOrThrow("personalLevel");
  final int h = r.getColumnIndexOrThrow("numMessages");
  public final int i = r.getColumnIndexOrThrow("maxMessageId");
  final int j = r.getColumnIndexOrThrow("hasAttachments");
  final int k = r.getColumnIndex("synced");
  public final int l = r.getColumnIndex("labelIds");
  final int m = r.getColumnIndex("unsubscribeSenderName");
  final int n = r.getColumnIndex("unsubscribeSenderIdentifier");
  final int o = r.getColumnIndex("fromCompactV2");
  final int p = r.getColumnIndexOrThrow("hasCalendarInvite");
  public final TextUtils.StringSplitter q = dpy.b();
  private final int t = r.getColumnIndexOrThrow("_id");
  private final int u = r.getColumnIndexOrThrow("hasMessagesWithErrors");
  private final int v = r.getColumnIndexOrThrow("forceAllUnread");
  private final int w = r.getColumnIndex("conversationLabels");
  private final LruCache<Long, Map<String, dqz>> x = new LruCache(50);
  
  dqa(Handler paramHandler, String paramString, Cursor paramCursor)
  {
    super(null, paramString, paramCursor);
  }
  
  protected final void a()
  {
    super.a();
  }
  
  public final long b()
  {
    return r.getLong(t);
  }
  
  public final Map<String, dqz> c()
  {
    long l1 = b();
    for (;;)
    {
      synchronized (x)
      {
        Object localObject3 = (Map)x.get(Long.valueOf(b()));
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject3 = s;
          if (w >= 0)
          {
            localObject1 = r.getString(w);
            localObject1 = drd.a((String)localObject3, (String)localObject1);
            x.put(Long.valueOf(l1), localObject1);
          }
        }
        else
        {
          return (Map<String, dqz>)localObject1;
        }
      }
      String str = "";
    }
  }
}

/* Location:
 * Qualified Name:     dqa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */