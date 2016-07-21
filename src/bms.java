import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

final class bms
  extends BroadcastReceiver
{
  bms(bmr parambmr) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((paramContext == null) || (!paramContext.isConnected())) {
      a.as = false;
    }
    while ((a.as) || (a.u())) {
      return;
    }
    if (!a.ar) {
      a.j().a(2, a);
    }
    a.j().a(3, a);
    a.as = true;
    a.ak.a(0);
  }
}

/* Location:
 * Qualified Name:     bms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */