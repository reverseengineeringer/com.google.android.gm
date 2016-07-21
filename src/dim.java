import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.browse.ConversationMessage;
import com.google.android.gm.provider.GmailProvider;

public final class dim
  extends byk
{
  private static final String b = cvl.a;
  private final long c;
  
  public dim(com.android.mail.providers.Account paramAccount, long paramLong)
  {
    super(paramAccount);
    c = paramLong;
  }
  
  public final Intent a(Context paramContext, String paramString, ConversationMessage paramConversationMessage)
  {
    String str1 = a.c;
    if (TextUtils.equals(a.c().type, "com.google"))
    {
      paramString = Uri.parse(paramString);
      long l = Long.parseLong(e);
      String str2 = paramString.getQueryParameter(ghz.a(paramContext.getContentResolver(), "gmail-part-id-key", "attid"));
      if (TextUtils.isEmpty(str2))
      {
        cvm.e(b, "Empty partId in inlineUri: %s", new Object[] { paramString });
        return null;
      }
      paramString = GmailProvider.a(str1, c, l, d, str2, null);
      return cfc.a(paramContext, str1, a.e, paramConversationMessage, paramString.toString());
    }
    return super.a(paramContext, paramString, paramConversationMessage);
  }
}

/* Location:
 * Qualified Name:     dim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */