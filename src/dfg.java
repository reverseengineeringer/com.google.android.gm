import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Intent;
import android.database.Cursor;
import com.google.android.gm.GmailIntentService;
import java.util.Set;

public final class dfg
  implements Runnable
{
  public dfg(GmailIntentService paramGmailIntentService, drp paramdrp, Intent paramIntent) {}
  
  public final void run()
  {
    dpa localdpa = a.w;
    long l = b.getLongExtra("extra_download_id", -1L);
    if (!f.contains(Long.valueOf(l)))
    {
      if (l == -1L) {
        dri.e(dpa.a, "Received notification from DownloadManager with invalid download id", new Object[0]);
      }
    }
    else {
      return;
    }
    Object localObject2 = new DownloadManager.Query().setFilterById(new long[] { l });
    localObject2 = e.query((DownloadManager.Query)localObject2);
    if (localObject2 == null)
    {
      dri.e(dpa.a, "null cursor from DownloadManager", new Object[0]);
      return;
    }
    try
    {
      int i = ((Cursor)localObject2).getColumnIndex("status");
      int j = ((Cursor)localObject2).getColumnIndex("reason");
      if (((Cursor)localObject2).moveToNext()) {
        localdpa.a(l, ((Cursor)localObject2).getInt(i), ((Cursor)localObject2).getInt(j));
      }
      return;
    }
    finally
    {
      ((Cursor)localObject2).close();
    }
  }
}

/* Location:
 * Qualified Name:     dfg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */