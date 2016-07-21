import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader.ForceLoadContentObserver;
import android.database.ContentObserver;
import android.database.Cursor;
import java.util.List;
import java.util.Set;

public final class dpm
  extends CursorLoader
{
  long[] a;
  private final DownloadManager c;
  private final ContentObserver d;
  
  public dpm(dpf paramdpf, Context paramContext)
  {
    super(paramContext);
    c = ((DownloadManager)paramContext.getSystemService("download"));
    d = new Loader.ForceLoadContentObserver(this);
  }
  
  public final Cursor loadInBackground()
  {
    Cursor localCursor = c.query(new DownloadManager.Query().setFilterById(a));
    if (localCursor != null) {
      localCursor.registerContentObserver(d);
    }
    return localCursor;
  }
  
  protected final void onReset()
  {
    super.onReset();
    if (a != null)
    {
      List localList = hku.a(a);
      dpa localdpa = b.h;
      dri.b(dpa.a, "AttachmentManager: removing watched ids %s", new Object[] { localList });
      f.removeAll(localList);
      dri.b(dpf.a, "ASL removing %s", new Object[] { localList });
    }
  }
}

/* Location:
 * Qualified Name:     dpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */