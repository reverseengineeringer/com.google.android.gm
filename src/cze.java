import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

final class cze
  implements ServiceConnection
{
  cze(czd paramczd) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    dav.a("service connected, binder: " + paramIBinder);
    try
    {
      if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(paramIBinder.getInterfaceDescriptor()))
      {
        dav.a("bound to service");
        czd localczd = a;
        if (paramIBinder == null) {
          paramComponentName = null;
        }
        for (;;)
        {
          e = paramComponentName;
          a.b.a();
          return;
          paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
          if ((paramComponentName != null) && ((paramComponentName instanceof ebb))) {
            paramComponentName = (ebb)paramComponentName;
          } else {
            paramComponentName = new ebd(paramIBinder);
          }
        }
      }
      return;
    }
    catch (RemoteException paramComponentName)
    {
      a.d.unbindService(this);
      a.a = null;
      a.c.a(2);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    dav.a("service disconnected: " + paramComponentName);
    a.a = null;
    a.b.b();
  }
}

/* Location:
 * Qualified Name:     cze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */