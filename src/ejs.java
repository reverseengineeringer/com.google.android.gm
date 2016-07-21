import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class ejs
  implements ekt
{
  private final ekj a;
  
  public ejs(ekj paramekj)
  {
    a = paramekj;
  }
  
  private final <A extends eit> void a(eks<A> parameks)
  {
    a.a(parameks);
    eit localeit = a.a(parameks.d());
    if ((!localeit.d()) && (a.n.containsKey(parameks.d())))
    {
      parameks.c(new Status(17));
      return;
    }
    parameks.b(localeit);
  }
  
  public final <A extends eit, R extends ejk, T extends ejq<R, A>> T a(T paramT)
  {
    return b(paramT);
  }
  
  public final void a()
  {
    while (!a.f.isEmpty()) {
      try
      {
        a((eks)a.f.remove());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.w("GoogleApiClientConnected", "Service died while flushing queue", localDeadObjectException);
      }
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt == 1)
    {
      localObject = a;
      if (!g)
      {
        g = true;
        if (l == null)
        {
          l = new ekq((ekj)localObject);
          IntentFilter localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
          localIntentFilter.addDataScheme("package");
          d.getApplicationContext().registerReceiver(l, localIntentFilter);
        }
        j.sendMessageDelayed(j.obtainMessage(1), h);
        j.sendMessageDelayed(j.obtainMessage(2), i);
      }
    }
    Object localObject = a.t.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((eks)((Iterator)localObject).next()).b(new Status(8, "The connection to Google Play services was lost"));
    }
    a.a(null);
    a.c.a(paramInt);
    a.c.a();
    if (paramInt == 2) {
      a.b();
    }
  }
  
  public final void a(Bundle paramBundle) {}
  
  public final void a(ConnectionResult paramConnectionResult, eip<?> parameip, int paramInt) {}
  
  public final <A extends eit, T extends ejq<? extends ejk, A>> T b(T paramT)
  {
    try
    {
      a(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      a.a(new ejt(this, this));
    }
    return paramT;
  }
  
  public final void b()
  {
    a.n.clear();
    a.g();
    a.a(null);
    a.c.a();
  }
  
  public final void c() {}
  
  public final String d()
  {
    return "CONNECTED";
  }
}

/* Location:
 * Qualified Name:     ejs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */