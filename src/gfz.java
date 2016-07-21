import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.wearable.internal.AddListenerRequest;
import com.google.android.gms.wearable.internal.RemoveListenerRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class gfz<T>
{
  private final Map<T, ggw<T>> a = new HashMap();
  
  public final void a(IBinder paramIBinder)
  {
    synchronized (a)
    {
      paramIBinder = gfx.a(paramIBinder);
      ggs localggs = new ggs();
      Iterator localIterator = a.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ggw localggw = (ggw)localEntry.getValue();
          try
          {
            paramIBinder.a(localggs, new AddListenerRequest(localggw));
            if (Log.isLoggable("WearableClient", 2)) {
              new StringBuilder("onPostInitHandler: added: ").append(localEntry.getKey()).append("/").append(localggw);
            }
          }
          catch (RemoteException localRemoteException)
          {
            new StringBuilder("onPostInitHandler: Didn't add: ").append(localEntry.getKey()).append("/").append(localggw);
          }
        }
      }
    }
  }
  
  public final void a(ggu paramggu)
  {
    synchronized (a)
    {
      ggs localggs = new ggs();
      Iterator localIterator = a.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          ggw localggw = (ggw)localEntry.getValue();
          if (localggw == null) {
            continue;
          }
          a = null;
          b = null;
          c = null;
          d = null;
          e = null;
          f = null;
          g = null;
          h = null;
          boolean bool = paramggu.d();
          if (!bool) {
            continue;
          }
          try
          {
            ((gfw)paramggu.k()).a(localggs, new RemoveListenerRequest(localggw));
            if (Log.isLoggable("WearableClient", 2)) {
              new StringBuilder("disconnect: removed: ").append(localEntry.getKey()).append("/").append(localggw);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableClient", "disconnect: Didn't remove: " + localEntry.getKey() + "/" + localggw);
          }
        }
      }
    }
    a.clear();
  }
}

/* Location:
 * Qualified Name:     gfz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */