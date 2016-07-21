import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class gkc
  implements Application.ActivityLifecycleCallbacks
{
  final List<gjs> a = new CopyOnWriteArrayList();
  final List<gjx> b = new CopyOnWriteArrayList();
  final List<gjv> c = new CopyOnWriteArrayList();
  final List<gju> d = new CopyOnWriteArrayList();
  final List<gjy> e = new CopyOnWriteArrayList();
  final List<gjw> f = new CopyOnWriteArrayList();
  final List<gjt> g = new CopyOnWriteArrayList();
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = a.iterator();
    while (paramActivity.hasNext()) {
      ((gjs)paramActivity.next()).a();
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    paramActivity = g.iterator();
    while (paramActivity.hasNext()) {
      paramActivity.next();
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    paramActivity = d.iterator();
    while (paramActivity.hasNext()) {
      paramActivity.next();
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    paramActivity = c.iterator();
    while (paramActivity.hasNext()) {
      paramActivity.next();
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    paramActivity = f.iterator();
    while (paramActivity.hasNext()) {
      paramActivity.next();
    }
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((gjx)localIterator.next()).a(paramActivity);
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      ((gjy)localIterator.next()).b(paramActivity);
    }
  }
}

/* Location:
 * Qualified Name:     gkc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */