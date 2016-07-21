import android.content.ContentResolver;
import android.os.Bundle;

public final class bes
{
  public static Bundle a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("search_status", paramInt1);
    localBundle.putInt("search_total_results", paramInt2);
    return localBundle;
  }
  
  public static void a(ContentResolver paramContentResolver, long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = buo.a();
    int i = chh.b(paramInt2);
    if ((chh.a(i)) && (((but)localObject).a())) {
      ((but)localObject).a("sync", "all_email_sync_errors", chk.a(i), 0L);
    }
    cvm.c(bbw.a, "syncStatus: lastSyncResult=%d", new Object[] { Integer.valueOf(i) });
    localObject = new Bundle(5);
    ((Bundle)localObject).putInt("type", 0);
    ((Bundle)localObject).putLong("id", paramLong);
    ((Bundle)localObject).putInt("status_code", paramInt1);
    if (paramInt1 != 1) {
      ((Bundle)localObject).putInt("result", paramInt2);
    }
    ((Bundle)localObject).putInt("progress", 0);
    paramContentResolver.call(bdv.H, "sync_status", "", (Bundle)localObject);
  }
}

/* Location:
 * Qualified Name:     bes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */