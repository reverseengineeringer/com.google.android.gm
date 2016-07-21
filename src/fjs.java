import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.Task;
import java.util.Iterator;
import java.util.List;

public final class fjs
{
  private static fjs b;
  public Context a;
  private final PendingIntent c;
  
  private fjs(Context paramContext)
  {
    a = paramContext;
    c = PendingIntent.getBroadcast(a, 0, new Intent(), 0);
  }
  
  public static fjs a(Context paramContext)
  {
    if (b == null) {
      b = new fjs(paramContext.getApplicationContext());
    }
    return b;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Must provide a valid tag.");
    }
    if (100 < paramString.length()) {
      throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
    }
  }
  
  public final Intent a()
  {
    int i = fjv.b(a);
    if (i < fjv.a)
    {
      Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + i);
      return null;
    }
    Intent localIntent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
    localIntent.setPackage(fjv.a(a));
    localIntent.putExtra("app", c);
    return localIntent;
  }
  
  public final void a(Task paramTask)
  {
    b(c);
    Intent localIntent = a();
    if (localIntent == null) {
      return;
    }
    Bundle localBundle = localIntent.getExtras();
    localBundle.putString("scheduler_action", "SCHEDULE_TASK");
    paramTask.a(localBundle);
    localIntent.putExtras(localBundle);
    a.sendBroadcast(localIntent);
  }
  
  public final void b(String paramString)
  {
    boolean bool2 = true;
    enz.a(paramString, "GcmTaskService must not be null.");
    Object localObject = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
    ((Intent)localObject).setPackage(a.getPackageName());
    localObject = a.getPackageManager().queryIntentServices((Intent)localObject, 0);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      bool1 = true;
      enz.b(bool1, "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!nextserviceInfo.name.equals(paramString));
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enz.b(bool1, "The GcmTaskService class you provided " + paramString + " does not seem to support receiving com.google.android.gms.gcm.ACTION_TASK_READY.");
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     fjs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */