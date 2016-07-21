import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;

final class czd
  implements czc
{
  ServiceConnection a;
  czf b;
  czg c;
  Context d;
  ebb e;
  
  public czd(Context paramContext, czf paramczf, czg paramczg)
  {
    d = paramContext;
    if (paramczf == null) {
      throw new IllegalArgumentException("onConnectedListener cannot be null");
    }
    b = paramczf;
    if (paramczg == null) {
      throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
    }
    c = paramczg;
  }
  
  private final ebb d()
  {
    if (e != null) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }
    return e;
  }
  
  public final void a()
  {
    try
    {
      d().a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      dav.b("clear hits failed: " + localRemoteException);
    }
  }
  
  public final void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    try
    {
      d().a(paramMap, paramLong, paramString, paramList);
      return;
    }
    catch (RemoteException paramMap)
    {
      dav.b("sendHit failed: " + paramMap);
    }
  }
  
  public final void b()
  {
    Intent localIntent = new Intent("com.google.android.gms.analytics.service.START");
    localIntent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
    localIntent.putExtra("app_package_name", d.getPackageName());
    if (a != null) {
      dav.b("Calling connect() while still connected, missing disconnect().");
    }
    boolean bool;
    do
    {
      return;
      a = new cze(this);
      bool = d.bindService(localIntent, a, 129);
      dav.d("connect: bindService returned " + bool + " for " + localIntent);
    } while (bool);
    a = null;
    c.a(1);
  }
  
  public final void c()
  {
    e = null;
    if (a != null) {}
    try
    {
      d.unbindService(a);
      a = null;
      b.b();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     czd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */