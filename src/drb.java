import android.content.Context;
import android.database.ContentObserver;
import android.os.AsyncTask;
import android.os.Handler;

public final class drb
  extends ContentObserver
{
  final Context a;
  final String b;
  final boolean c;
  drc d = null;
  boolean e = false;
  
  public drb(Context paramContext, String paramString, boolean paramBoolean)
  {
    super(new Handler());
    a = paramContext.getApplicationContext();
    b = paramString;
    c = paramBoolean;
  }
  
  final void a()
  {
    d = new drc(this);
    d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    e = false;
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    if (d == null)
    {
      a();
      return;
    }
    e = true;
  }
}

/* Location:
 * Qualified Name:     drb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */