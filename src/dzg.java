import android.app.Service;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.android.mail.providers.Account;
import java.util.concurrent.TimeUnit;

public class dzg
  extends Service
{
  private static final long b = TimeUnit.SECONDS.toMillis(10L);
  final oi<Uri, Account> a = new oi();
  private ContentObserver c;
  private Handler d;
  private Looper e;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    HandlerThread localHandlerThread = new HandlerThread(dzg.class.getSimpleName());
    localHandlerThread.start();
    e = localHandlerThread.getLooper();
    d = new dzh(this, e);
    c = new dzi(this, d);
  }
  
  public void onDestroy()
  {
    dri.b("GmailWear", "unregisterReplyContentObserver(%s)", new Object[] { Integer.toHexString(hashCode()) });
    getContentResolver().unregisterContentObserver(c);
    e.quit();
    super.onDestroy();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject = paramIntent.getExtras();
    paramIntent = (Account)((Bundle)localObject).getParcelable("com.google.android.gm.wearable.extra.ACCOUNT");
    localObject = (Uri)((Bundle)localObject).getParcelable("com.google.android.gm.wearable.extra.MESSAGE_URI");
    if ((paramIntent == null) || (localObject == null)) {
      dri.d("GmailWear", "Missing params:account=%s,messageListUri=%s", new Object[] { paramIntent, localObject });
    }
    for (;;)
    {
      d.removeMessages(0);
      d.sendEmptyMessageDelayed(0, b);
      return 2;
      dri.b("GmailWear", "registerContentObserver=accountUri=%s,messageLisUri=%s", new Object[] { g, localObject });
      a.put(localObject, paramIntent);
      getContentResolver().registerContentObserver((Uri)localObject, true, c);
    }
  }
}

/* Location:
 * Qualified Name:     dzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */