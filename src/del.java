import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

final class del
  extends BroadcastReceiver
{
  final IntentFilter a = new IntentFilter();
  
  del(dej paramdej)
  {
    a.addAction("android.accounts.LOGIN_ACCOUNTS_CHANGED");
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.accounts.LOGIN_ACCOUNTS_CHANGED".equals(paramIntent.getAction())) {
      b.a();
    }
  }
}

/* Location:
 * Qualified Name:     del
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */