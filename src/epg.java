import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Binder;
import java.util.Iterator;
import java.util.List;

public final class epg
{
  public static String a(int paramInt)
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 3;
    if (i < paramInt + 3)
    {
      if (i + 4 >= arrayOfStackTraceElement.length) {}
      for (Object localObject = "<bottom of call stack>";; localObject = ((StackTraceElement)localObject).getClassName() + "." + ((StackTraceElement)localObject).getMethodName() + ":" + ((StackTraceElement)localObject).getLineNumber())
      {
        localStringBuffer.append((String)localObject).append(" ");
        i += 1;
        break;
        localObject = arrayOfStackTraceElement[(i + 4)];
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String a(Context paramContext)
  {
    int i = Binder.getCallingPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (pid == i) {
          return processName;
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     epg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */