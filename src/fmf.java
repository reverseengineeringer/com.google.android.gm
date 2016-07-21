import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

public final class fmf
{
  static String a = null;
  static int b = 0;
  static int c = 0;
  static int d = 0;
  
  public static String a(Context paramContext)
  {
    if (a != null) {
      return a;
    }
    b = Process.myUid();
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramContext.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if (paramContext.checkPermission("com.google.android.c2dm.permission.RECEIVE", serviceInfo.packageName) == 0) {
        try
        {
          ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo(serviceInfo.packageName, 0);
          Log.w("InstanceID/Rpc", "Found " + uid);
          c = uid;
          localObject2 = serviceInfo.packageName;
          a = (String)localObject2;
          return (String)localObject2;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2) {}
      } else {
        Log.w("InstanceID/Rpc", "Possible malicious package " + serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER without permission");
      }
    }
    Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
    try
    {
      localObject1 = paramContext.getApplicationInfo("com.google.android.gms", 0);
      a = packageName;
      c = uid;
      localObject1 = a;
      return (String)localObject1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      try
      {
        paramContext = paramContext.getApplicationInfo("com.google.android.gsf", 0);
        a = packageName;
        c = uid;
        paramContext = a;
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     fmf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */