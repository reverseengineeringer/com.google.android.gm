import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import java.util.Iterator;
import java.util.List;

public final class gmy
{
  public static ActivityManager a = null;
  
  public static boolean a(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (processName.contains(paramContext.getPackageName()))
        {
          if (importance == 100) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            boolean bool2 = bool1;
            if (Build.VERSION.SDK_INT < 23) {
              bool2 = bool1 & b(paramContext);
            }
            if (!bool2) {
              break;
            }
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if (Build.VERSION.SDK_INT >= 20) {
      return paramContext.isInteractive();
    }
    return paramContext.isScreenOn();
  }
}

/* Location:
 * Qualified Name:     gmy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */