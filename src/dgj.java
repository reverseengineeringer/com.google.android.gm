import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.Map;
import java.util.Set;

public class dgj
  extends Service
{
  String a;
  dra b;
  DataSetObserver c = null;
  
  final void a()
  {
    Object localObject2;
    if ((b != null) && (c != null))
    {
      ??? = b;
      localObject2 = c;
      f.unregisterObserver(localObject2);
      c = null;
      localObject2 = b;
    }
    for (;;)
    {
      synchronized (dra.g)
      {
        drb localdrb = (drb)dra.h.get(d);
        if (localdrb == null)
        {
          stopSelf();
          return;
        }
        Set localSet = (Set)dra.i.get(localdrb);
        if (localSet != null)
        {
          localSet.remove(localObject2);
          if (localSet.size() == 0)
          {
            dra.i.remove(localdrb);
            i = 1;
            if (i == 0) {
              continue;
            }
            b.getContentResolver().unregisterContentObserver(localdrb);
          }
        }
      }
      int i = 0;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    a = paramIntent.getStringExtra("account-name");
    if (a == null) {
      return 2;
    }
    if (dfh.g(this))
    {
      stopSelf();
      return 2;
    }
    new dgk(this).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    return 2;
  }
}

/* Location:
 * Qualified Name:     dgj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */