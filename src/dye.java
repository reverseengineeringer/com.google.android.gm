import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

final class dye
  implements ServiceConnection
{
  dye(dyd paramdyd) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    dyd localdyd = a;
    if (paramIBinder == null) {
      paramComponentName = null;
    }
    for (;;)
    {
      d = paramComponentName;
      return;
      paramComponentName = paramIBinder.queryLocalInterface("com.google.android.calendar.ICalendarOobeService");
      if ((paramComponentName != null) && ((paramComponentName instanceof dde))) {
        paramComponentName = (dde)paramComponentName;
      } else {
        paramComponentName = new ddg(paramIBinder);
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    dri.b(dyd.a, "calPromotion: disconnect from oobe", new Object[0]);
    a.d = null;
    a.c = null;
  }
}

/* Location:
 * Qualified Name:     dye
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */