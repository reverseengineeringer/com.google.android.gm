import android.content.ContentValues;
import android.content.Context;
import com.android.emailcommon.provider.Account;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpEntity;

public final class bqz
  extends bqc
{
  private final Map<String, ContentValues> a;
  
  bqz(Context paramContext, Account paramAccount, Map<String, ContentValues> paramMap)
  {
    super(paramContext, paramAccount);
    a = paramMap;
  }
  
  protected final int a(bns parambns)
  {
    if (boo.a(f, parambns.d(), g, a)) {
      return 0;
    }
    return -99;
  }
  
  protected final String b()
  {
    return "ItemOperations";
  }
  
  protected final HttpEntity c()
  {
    bpi localbpi = null;
    if (a.isEmpty()) {
      return null;
    }
    Object localObject1 = a;
    if (((Map)localObject1).isEmpty()) {}
    for (;;)
    {
      return a(localbpi);
      localbpi = new bpi();
      localbpi.a(1285);
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ContentValues)((Iterator)localObject1).next();
        String str = ((ContentValues)localObject2).getAsString("calendarServerId");
        localObject2 = ((ContentValues)localObject2).getAsString("_sync_id");
        localbpi.a(1286);
        localbpi.b(1287, "Mailbox");
        localbpi.b(18, str);
        localbpi.b(13, (String)localObject2);
        localbpi.a(1288);
        localbpi.a(1296);
        localbpi.b(261);
        localbpi.b();
        localbpi.b();
        localbpi.b();
      }
      localbpi.b();
      localbpi.a();
    }
  }
}

/* Location:
 * Qualified Name:     bqz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */