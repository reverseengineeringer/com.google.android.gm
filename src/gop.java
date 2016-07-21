import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.KeyguardManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class gop
  implements Application.ActivityLifecycleCallbacks
{
  public final Application a;
  private final Set<Integer> b = new HashSet();
  private int c;
  private volatile boolean d;
  private boolean e;
  private final hqj<? extends Iterable<gon>> f;
  private final hqj<? extends Iterable<goo>> g;
  private boolean h = false;
  private final HashMap<String, gon> i = new HashMap();
  private final HashMap<String, goo> j = new HashMap();
  private List<String> k = new ArrayList();
  
  public gop(Application paramApplication, hqj<? extends Iterable<goo>> paramhqj, hqj<? extends Iterable<gon>> paramhqj1)
  {
    a = paramApplication;
    f = paramhqj1;
    g = paramhqj;
  }
  
  private final void a()
  {
    if (Log.isLoggable("AppVisibilityMonitor", 3))
    {
      StringBuilder localStringBuilder = new StringBuilder((String)k.get(0));
      int m = 1;
      while (m < k.size())
      {
        String str = (String)k.get(m);
        localStringBuilder.append(" -> ");
        localStringBuilder.append(str);
        m += 1;
      }
    }
  }
  
  private final void a(Activity paramActivity)
  {
    a("invisible");
    e = paramActivity.isChangingConfigurations();
    if (!e)
    {
      c -= 1;
      b(String.format(Locale.US, "count=%d", new Object[] { Integer.valueOf(c) }));
      b(paramActivity);
    }
    for (;;)
    {
      a();
      return;
      b("changing configurations");
    }
  }
  
  private final void a(String paramString)
  {
    if (Log.isLoggable("AppVisibilityMonitor", 3))
    {
      k.clear();
      b(paramString);
    }
  }
  
  private final void b(Activity paramActivity)
  {
    boolean bool;
    if (c > 0)
    {
      bool = true;
      if (bool == d) {
        break label107;
      }
      if (!bool) {
        break label94;
      }
    }
    Iterator localIterator;
    label94:
    for (??? = "foreground";; ??? = "background")
    {
      b((String)???);
      if (!bool) {
        break label108;
      }
      synchronized (j)
      {
        localIterator = j.values().iterator();
        if (!localIterator.hasNext()) {
          break label100;
        }
        ((goo)localIterator.next()).b(paramActivity);
      }
      bool = false;
      break;
    }
    for (;;)
    {
      label100:
      d = bool;
      label107:
      return;
      label108:
      synchronized (i)
      {
        localIterator = i.values().iterator();
        if (localIterator.hasNext()) {
          ((gon)localIterator.next()).a(paramActivity);
        }
      }
    }
  }
  
  private final void b(String paramString)
  {
    if (Log.isLoggable("AppVisibilityMonitor", 3)) {
      k.add(paramString);
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    b.remove(Integer.valueOf(paramActivity.hashCode()));
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    Integer localInteger = Integer.valueOf(paramActivity.hashCode());
    if (b.contains(localInteger))
    {
      PowerManager localPowerManager = (PowerManager)a.getSystemService("power");
      if (((Build.VERSION.SDK_INT < 20) || (localPowerManager.isInteractive())) && ((Build.VERSION.SDK_INT >= 20) || (localPowerManager.isScreenOn()))) {
        break label90;
      }
    }
    label90:
    for (boolean bool = true;; bool = ((KeyguardManager)a.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      if (bool)
      {
        a(paramActivity);
        b.remove(localInteger);
      }
      return;
    }
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (!h)
    {
      Iterator localIterator;
      Object localObject2;
      synchronized (i)
      {
        localIterator = ((Iterable)f.a()).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (gon)localIterator.next();
          i.put(((gon)localObject2).b(), localObject2);
        }
      }
      synchronized (j)
      {
        localIterator = ((Iterable)g.a()).iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (goo)localIterator.next();
          j.put(((goo)localObject2).b(), localObject2);
        }
      }
      h = true;
    }
    ??? = Integer.valueOf(paramActivity.hashCode());
    if (!b.contains(???))
    {
      a("visible");
      if (e) {
        break label255;
      }
      c += 1;
      b(String.format(Locale.US, "count=%d", new Object[] { Integer.valueOf(c) }));
      b(paramActivity);
    }
    for (;;)
    {
      e = paramActivity.isChangingConfigurations();
      a();
      b.add(???);
      return;
      label255:
      b("changing configurations");
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity)
  {
    Integer localInteger = Integer.valueOf(paramActivity.hashCode());
    if (b.contains(localInteger))
    {
      a(paramActivity);
      b.remove(localInteger);
    }
  }
}

/* Location:
 * Qualified Name:     gop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */