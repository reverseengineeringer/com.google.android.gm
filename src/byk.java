import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.browse.ConversationMessage;
import com.android.mail.providers.Account;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Message;
import java.util.Iterator;
import java.util.List;

public class byk
  implements byh
{
  public final Account a;
  
  public byk(Account paramAccount)
  {
    a = paramAccount;
  }
  
  public Intent a(Context paramContext, String paramString, ConversationMessage paramConversationMessage)
  {
    String str = cxa.c(Uri.parse(paramString));
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    Iterator localIterator = paramConversationMessage.l().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      paramString = (Attachment)localIterator.next();
    } while (!TextUtils.equals(str, b));
    for (;;)
    {
      if ((paramString == null) || (e == null))
      {
        cvm.f(cvm.a, "Couldn't find attachment uri for cid %s, messageId %d", new Object[] { str, Long.valueOf(d) });
        return null;
      }
      return cfc.a(paramContext, a.c, a.e, paramConversationMessage, e.toString());
      paramString = null;
    }
  }
}

/* Location:
 * Qualified Name:     byk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */