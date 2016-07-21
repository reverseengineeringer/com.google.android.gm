import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

final class czu
  extends BroadcastReceiver
{
  private final dbi a;
  
  czu(dbi paramdbi)
  {
    a = paramdbi;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      Bundle localBundle = paramIntent.getExtras();
      paramContext = Boolean.FALSE;
      if (localBundle != null) {
        paramContext = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      paramIntent = a;
      if (paramContext.booleanValue()) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      paramIntent.a(bool);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     czu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */