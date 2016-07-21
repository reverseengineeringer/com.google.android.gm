import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eop
{
  private static final Object a = new Object();
  private static eop b;
  private static final ComponentName g = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
  private static Integer i;
  private final List<String> c;
  private final List<String> d;
  private final List<String> e;
  private final List<String> f;
  private eot h;
  
  private eop()
  {
    if (b() == eos.a)
    {
      c = Collections.EMPTY_LIST;
      d = Collections.EMPTY_LIST;
      e = Collections.EMPTY_LIST;
      f = Collections.EMPTY_LIST;
      return;
    }
    Object localObject = (String)eor.b.b();
    if (localObject == null)
    {
      localObject = Collections.EMPTY_LIST;
      c = ((List)localObject);
      localObject = (String)eor.c.b();
      if (localObject != null) {
        break label171;
      }
      localObject = Collections.EMPTY_LIST;
      label83:
      d = ((List)localObject);
      localObject = (String)eor.d.b();
      if (localObject != null) {
        break label184;
      }
      localObject = Collections.EMPTY_LIST;
      label106:
      e = ((List)localObject);
      localObject = (String)eor.e.b();
      if (localObject != null) {
        break label197;
      }
    }
    label171:
    label184:
    label197:
    for (localObject = Collections.EMPTY_LIST;; localObject = Arrays.asList(((String)localObject).split(",")))
    {
      f = ((List)localObject);
      h = new eot(((Long)eor.f.b()).longValue());
      return;
      localObject = Arrays.asList(((String)localObject).split(","));
      break;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label83;
      localObject = Arrays.asList(((String)localObject).split(","));
      break label106;
    }
  }
  
  private static ServiceInfo a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
    if ((paramContext == null) || (paramContext.size() == 0))
    {
      Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), epg.a(20) }));
      return null;
    }
    if (paramContext.size() > 1)
    {
      Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[] { paramIntent.toUri(0), epg.a(20) }));
      paramIntent = paramContext.iterator();
      if (paramIntent.hasNext())
      {
        Log.w("ConnectionTracker", nextserviceInfo.name);
        return null;
      }
    }
    return get0serviceInfo;
  }
  
  public static eop a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new eop();
      }
      return b;
    }
  }
  
  private static int b()
  {
    int k = 1;
    if (i == null) {}
    for (;;)
    {
      try
      {
        if (!emo.a) {
          continue;
        }
        if (fnd.a == null) {
          continue;
        }
        j = 1;
        if ((j == 0) || (fnd.b != Process.myUid())) {
          continue;
        }
        j = k;
        if (j == 0) {
          continue;
        }
        j = ((Integer)eor.a.b()).intValue();
        i = Integer.valueOf(j);
      }
      catch (SecurityException localSecurityException)
      {
        int j;
        i = Integer.valueOf(eos.a);
        continue;
      }
      return i.intValue();
      j = 0;
      continue;
      j = 0;
      continue;
      j = eos.a;
    }
  }
  
  public final void a(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    a(paramContext, paramServiceConnection, null, null, 1);
  }
  
  public final void a(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent, int paramInt)
  {
    if (!emo.a) {
      return;
    }
    String str1 = String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
    int j = b();
    label46:
    long l2;
    long l1;
    if ((j == eos.a) || (h == null))
    {
      j = 0;
      if (j == 0) {
        break label348;
      }
      l2 = System.currentTimeMillis();
      paramServiceConnection = null;
      if ((b() & eos.e) != 0) {
        paramServiceConnection = epg.a(5);
      }
      l1 = 0L;
      if ((b() & eos.g) != 0) {
        l1 = Debug.getNativeHeapAllocatedSize();
      }
      if ((paramInt != 1) && (paramInt != 4)) {
        break label350;
      }
    }
    for (paramServiceConnection = new ConnectionEvent(l2, paramInt, null, null, null, null, paramServiceConnection, str1, SystemClock.elapsedRealtime(), l1);; paramServiceConnection = new ConnectionEvent(l2, paramInt, epg.a(paramContext), paramString, processName, name, paramServiceConnection, str1, SystemClock.elapsedRealtime(), l1))
    {
      paramContext.startService(new Intent().setComponent(g).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", paramServiceConnection));
      return;
      if ((paramInt == 4) || (paramInt == 1))
      {
        if (h.b(str1))
        {
          j = 1;
          break label46;
        }
        j = 0;
        break label46;
      }
      Object localObject = a(paramContext, paramIntent);
      if (localObject == null)
      {
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[] { paramString, paramIntent.toUri(0) }));
        j = 0;
        break label46;
      }
      paramServiceConnection = epg.a(paramContext);
      String str2 = processName;
      localObject = name;
      if ((c.contains(paramServiceConnection)) || (d.contains(paramString)) || (e.contains(str2)) || (f.contains(localObject)) || ((str2.equals(paramServiceConnection)) && ((j & eos.f) != 0)))
      {
        j = 0;
        break label46;
      }
      h.a(str1);
      j = 1;
      break label46;
      label348:
      break;
      label350:
      paramIntent = a(paramContext, paramIntent);
    }
  }
  
  public final boolean a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || ((emo.a) && ("com.google.android.gms".equals(localComponentName.getPackageName())))) {}
    for (boolean bool = false; bool; bool = epa.a(paramContext, localComponentName.getPackageName()))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    bool = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool) {
      a(paramContext, paramServiceConnection, paramString, paramIntent, 2);
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     eop
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */