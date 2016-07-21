import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.Map;
import java.util.concurrent.Executor;

final class bgl
  implements ServiceConnection
{
  bgl(bgj parambgj) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    a.a(paramIBinder);
    if (cuh.a())
    {
      Class localClass = a.getClass();
      paramIBinder = (Executor)bgj.l.get(localClass);
      paramComponentName = paramIBinder;
      if (paramIBinder == null)
      {
        paramComponentName = new bgo(localClass.getSimpleName());
        bgj.l.put(localClass, paramComponentName);
      }
    }
    for (;;)
    {
      new bgm(this).executeOnExecutor(paramComponentName, new Void[0]);
      return;
      paramComponentName = AsyncTask.SERIAL_EXECUTOR;
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}

/* Location:
 * Qualified Name:     bgl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */