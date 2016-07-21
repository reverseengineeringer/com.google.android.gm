import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class gml
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Log.isLoggable("PrimesGservices", 3))
    {
      String str = String.valueOf(paramIntent.getAction());
      if (str.length() != 0) {
        "onReceive, action=".concat(str);
      }
    }
    else
    {
      if (!ac) {
        break label59;
      }
      paramContext.unregisterReceiver(this);
    }
    label59:
    while (!"com.google.gservices.intent.action.GSERVICES_CHANGED".equals(paramIntent.getAction()))
    {
      return;
      new String("onReceive, action=");
      break;
    }
    gmk.a.a(paramContext);
  }
}

/* Location:
 * Qualified Name:     gml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */