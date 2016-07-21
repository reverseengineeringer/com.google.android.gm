import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.android.mail.providers.Account;
import com.google.android.gm.wearable.AppWearableListenerService;

final class dzi
  extends ContentObserver
{
  dzi(dzg paramdzg, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public final void onChange(boolean paramBoolean)
  {
    onChange(paramBoolean, null);
  }
  
  public final void onChange(boolean paramBoolean, Uri paramUri)
  {
    dri.b("GmailWear", "MessageList changed:uri=%s", new Object[] { paramUri });
    Account localAccount = (Account)a.a.get(paramUri);
    if (localAccount != null)
    {
      AppWearableListenerService.a(a, localAccount.h(), null, false);
      return;
    }
    dri.d("GmailWear", "Failed to find account for message list uri=%s", new Object[] { paramUri });
  }
}

/* Location:
 * Qualified Name:     dzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */