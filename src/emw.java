import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class emw
  implements ServiceConnection
{
  private final int b;
  
  public emw(emr paramemr, int paramInt)
  {
    b = paramInt;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    enz.a(paramIBinder, "Expecting a valid IBinder");
    emr localemr = a;
    if (paramIBinder == null) {
      paramComponentName = null;
    }
    for (;;)
    {
      emr.a(localemr, paramComponentName);
      paramComponentName = a;
      int i = b;
      c.sendMessage(c.obtainMessage(6, i, -1, new emz(paramComponentName)));
      return;
      paramComponentName = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
      if ((paramComponentName != null) && ((paramComponentName instanceof enq))) {
        paramComponentName = (enq)paramComponentName;
      } else {
        paramComponentName = new ens(paramIBinder);
      }
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    a.c.sendMessage(a.c.obtainMessage(4, b, 1));
  }
}

/* Location:
 * Qualified Name:     emw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */