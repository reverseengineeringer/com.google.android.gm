import android.content.Context;
import android.content.Intent;
import com.android.mail.providers.Account;
import com.google.android.gm.browse.FullMessageActivity;
import java.util.Locale;

public final class dio
  extends cot<Intent>
{
  private final String a;
  private final String b;
  
  public dio(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext);
    a = paramString1;
    b = paramString2;
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, Account paramAccount, String paramString3)
  {
    buo.a().a("plid_intent", "fallback_ui", paramString3, 0L);
    paramString3 = ghz.a(paramContext.getContentResolver(), "gmail_permalink_format", "https://mail.google.com/mail/?extsrc=sync&client=g&plid=%s");
    paramString1 = String.format(Locale.US, paramString3, new Object[] { paramString1 });
    paramContext = new Intent(paramContext, FullMessageActivity.class);
    paramContext.setFlags(134742016);
    paramContext.putExtra("permalink", paramString1);
    paramContext.putExtra("account-name", paramString2);
    if (paramAccount != null) {
      paramContext.putExtra("extra-account-uri", g);
    }
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     dio
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */