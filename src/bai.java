import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class bai
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    if ("android.accounts.AccountAuthenticator".equals(paramIntent.getAction())) {
      return new baj(this, this).getIBinder();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */