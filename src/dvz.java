import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;

final class dvz
  implements Application.ActivityLifecycleCallbacks
{
  private static final IntentFilter b = new IntentFilter("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
  final dwc a;
  private final BroadcastReceiver c = new dwa(this);
  
  public dvz(dwc paramdwc)
  {
    a = paramdwc;
  }
  
  final void a(Context paramContext)
  {
    if (paramContext != null) {
      new dwb(this, paramContext.getClass()).execute(new Context[] { paramContext.getApplicationContext() });
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    paramActivity.unregisterReceiver(c);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    a(paramActivity);
    paramActivity.registerReceiver(c, b);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     dvz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */