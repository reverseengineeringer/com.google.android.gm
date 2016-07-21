import android.accounts.Account;
import android.content.ContentResolver;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Mailbox;
import java.util.Set;

public final class ayx
  implements Handler.Callback
{
  public ayx(EmailProvider paramEmailProvider) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    synchronized (a.g)
    {
      paramMessage = (azi)obj;
      Account localAccount = b;
      Bundle localBundle = Mailbox.a(c);
      ContentResolver.requestSync(localAccount, a, localBundle);
      cvm.c(EmailProvider.a, "requestSync getDelayedSyncHandler %s, %s", new Object[] { cvm.a(localAccount.toString()), localBundle.toString() });
      a.g.remove(paramMessage);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     ayx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */