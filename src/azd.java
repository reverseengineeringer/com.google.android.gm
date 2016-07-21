import android.os.Handler.Callback;
import android.os.Message;
import com.android.email.provider.EmailProvider;

public final class azd
  implements Handler.Callback
{
  public azd(EmailProvider paramEmailProvider) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    paramMessage = (String)obj;
    cvm.b(EmailProvider.a, "Notifying conversation Uri %s twice", new Object[] { paramMessage });
    a.a(EmailProvider.i, paramMessage);
    return true;
  }
}

/* Location:
 * Qualified Name:     azd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */