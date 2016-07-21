import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.DisconnectRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class fev
  extends emr<fcc>
{
  public final boolean f;
  DriveId g;
  final ejc h;
  final Map<DriveId, Map<Object, Object>> i = new HashMap();
  final Map<Object, Object> j = new HashMap();
  final Map<DriveId, Map<Object, Object>> k = new HashMap();
  final Map<DriveId, Map<Object, Object>> l = new HashMap();
  private final String m;
  private final Bundle n;
  private DriveId o;
  
  public fev(Context paramContext, Looper paramLooper, emc paramemc, ejc paramejc, eje parameje, Bundle paramBundle)
  {
    super(paramContext, paramLooper, 11, paramemc, paramejc, parameje);
    m = e;
    h = paramejc;
    n = paramBundle;
    paramLooper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    paramLooper.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryIntentServices(paramLooper, 0);
    switch (paramContext.size())
    {
    default: 
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + paramLooper.getAction() + " action");
    case 0: 
      f = false;
      return;
    }
    paramContext = get0serviceInfo;
    if (!exported) {
      throw new IllegalStateException("Drive event service " + name + " must be exported in AndroidManifest.xml");
    }
    f = true;
  }
  
  protected final String a()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      g = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      o = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  protected final String b()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public final void c()
  {
    if (d()) {}
    try
    {
      ((fcc)k()).a(new DisconnectRequest());
      super.c();
      synchronized (i)
      {
        i.clear();
        synchronized (j)
        {
          j.clear();
          synchronized (k)
          {
            k.clear();
          }
        }
      }
      synchronized (l)
      {
        l.clear();
        return;
        localObject1 = finally;
        throw ((Throwable)localObject1);
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  public final boolean e()
  {
    return (!a.getPackageName().equals(m)) || (!eik.a(a, Process.myUid()));
  }
  
  protected final Bundle i()
  {
    String str = a.getPackageName();
    enz.a(str);
    if (!b.c.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enz.a(bool);
      Bundle localBundle = new Bundle();
      if (!str.equals(m)) {
        localBundle.putString("proxy_package_name", m);
      }
      localBundle.putAll(n);
      return localBundle;
    }
  }
  
  public final boolean l()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     fev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */