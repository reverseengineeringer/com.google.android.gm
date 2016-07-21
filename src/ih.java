import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.Secure;
import java.util.HashSet;
import java.util.Set;

public final class ih
{
  static final int a;
  private static final Object d = new Object();
  private static String e;
  private static Set<String> f = new HashSet();
  private static final Object g = new Object();
  private static ip h;
  private static final ij i;
  public final Context b;
  public final NotificationManager c;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {
      i = new im();
    }
    for (;;)
    {
      a = i.a();
      return;
      if (Build.VERSION.SDK_INT >= 5) {
        i = new il();
      } else {
        i = new ik();
      }
    }
  }
  
  private ih(Context paramContext)
  {
    b = paramContext;
    c = ((NotificationManager)b.getSystemService("notification"));
  }
  
  public static ih a(Context paramContext)
  {
    return new ih(paramContext);
  }
  
  public static Set<String> b(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    HashSet localHashSet;
    if ((paramContext != null) && (!paramContext.equals(e)))
    {
      ??? = paramContext.split(":");
      localHashSet = new HashSet(???.length);
      int k = ???.length;
      int j = 0;
      while (j < k)
      {
        ComponentName localComponentName = ComponentName.unflattenFromString(???[j]);
        if (localComponentName != null) {
          localHashSet.add(localComponentName.getPackageName());
        }
        j += 1;
      }
    }
    synchronized (d)
    {
      f = localHashSet;
      e = paramContext;
      return f;
    }
  }
  
  public final void a(int paramInt)
  {
    i.a(c, null, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      a(new ii(b.getPackageName(), paramInt, null));
    }
  }
  
  public final void a(int paramInt, Notification paramNotification)
  {
    Bundle localBundle = gz.a.a(paramNotification);
    if ((localBundle != null) && (localBundle.getBoolean("android.support.useSideChannel"))) {}
    for (int j = 1; j != 0; j = 0)
    {
      a(new in(b.getPackageName(), paramInt, null, paramNotification));
      i.a(c, null, paramInt);
      return;
    }
    i.a(c, null, paramInt, paramNotification);
  }
  
  public final void a(ir paramir)
  {
    synchronized (g)
    {
      if (h == null) {
        h = new ip(b.getApplicationContext());
      }
      ha.obtainMessage(0, paramir).sendToTarget();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     ih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */